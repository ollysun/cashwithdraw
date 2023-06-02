package com.test.cashwithdrawal.application.service;

import com.test.cashwithdrawal.application.port.in.PaymentRestClient;
import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import com.test.cashwithdrawal.application.port.in.AccountUseCase;
import com.test.cashwithdrawal.application.port.out.AccountPort;
import com.test.cashwithdrawal.application.port.out.TransactionPort;
import com.test.cashwithdrawal.application.port.out.UpdateAccountStatePort;
import com.test.cashwithdrawal.domain.TransactionDomain;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import com.test.cashwithdrawal.shared.TransactionType;
import com.test.cashwithdrawal.shared.UseCase;
import com.test.cashwithdrawal.shared.exception.CashWithdrawalException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@UseCase
@Transactional
public class AccountService implements AccountUseCase {

    public AccountService(TransactionPort transactionPort, UpdateAccountStatePort updateAccountStatePort, AccountPort accountPort,
                          PaymentRestClient paymentRestClient,
                          @Value("${minimum.balance}") Long minimumBalance) {
        this.transactionPort = transactionPort;
        this.updateAccountStatePort = updateAccountStatePort;
        this.accountPort = accountPort;
        this.paymentRestClient = paymentRestClient;
        this.minimumBalance = minimumBalance;
    }

    private final TransactionPort transactionPort;

    private final UpdateAccountStatePort updateAccountStatePort;

    private final AccountPort accountPort;

    private final PaymentRestClient paymentRestClient;

    private Long minimumBalance;
    @Override
    public TransferPaymentResponse sendMoney(TransferMoneyCommand command) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        // get source account details
        Account sourceaccount =  accountPort.findByAccountNumber(command.getSource().getAccount().getAccountNumber());

        // check if the user has fund in the account against the amount
        if(checkBalance(sourceaccount, command.getAmount())){
            throw new CashWithdrawalException("Not enough balance to carry out this transaction");
        }

        TransferPaymentResponse transferPaymentResponse = paymentRestClient.restClient(command);
        saveActivity(transferPaymentResponse.getRequestInfo().getStatus(), command,username);

        // withdraw the amount and update the balance
        Long newBalance = sourceaccount.getBalance() - command.getAmount();
        sourceaccount.setBalance(newBalance);
        Account accountNewBalance = updateAccountStatePort.updateAcccount(sourceaccount.getAccountNumber(), newBalance);
        if(accountNewBalance != null){
            command.setAmount(command.getAmount());
            saveActivity(TransactionType.WITHDRAW_AMOUNT.name(), command,username);
        }



        //charge fee 10% on source account balance
        long fee =  (10 * sourceaccount.getBalance()) / 100;
        Long balance = sourceaccount.getBalance()  - fee;
        Account account = updateAccountStatePort.updateAcccount(sourceaccount.getAccountNumber(), balance);
        if(account != null){
            command.setAmount(fee);
            saveActivity(TransactionType.REMOVE_CHARGES.name(), command,username);
        }


        return transferPaymentResponse;

    }

    @Override
    public Account createAccount(Account account) {
        if(account.getBalance() <= 0 || account.getBalance() < minimumBalance){
            throw new CashWithdrawalException("Please enter the minimum balance to create account:  " + minimumBalance);
        }
        return accountPort.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountPort.fetch();
    }


    public boolean checkBalance(Account source, Long amount){
        return source.getBalance() <= 0 || amount > source.getBalance();
    }

    private void saveActivity(String status, TransferMoneyCommand command, String username){
        TransactionDomain transactionDomain = new TransactionDomain();
        transactionDomain.setAmount(command.getAmount());
        transactionDomain.setCreatedDate(LocalDateTime.now());
        transactionDomain.setSourceAccountNumber(command.getSource().getAccount().getAccountNumber());
        transactionDomain.setDestinationAccountNumber(command.getDestination().getAccount().getAccountNumber());
        transactionDomain.setUsername(username);
        transactionDomain.setStatus(status);
        transactionPort.saveTransactionActivity(transactionDomain);
    }


}
