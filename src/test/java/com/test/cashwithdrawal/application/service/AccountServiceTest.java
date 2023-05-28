package com.test.cashwithdrawal.application.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.cashwithdrawal.adapter.in.request.CreateAccountRequest;
import com.test.cashwithdrawal.adapter.out.persistence.Adapter.AccountAdapter;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.AccountRepository;
import com.test.cashwithdrawal.application.port.in.PaymentRestClient;
import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import com.test.cashwithdrawal.application.port.out.AccountPort;
import com.test.cashwithdrawal.application.port.out.TransactionPort;
import com.test.cashwithdrawal.application.port.out.UpdateAccountStatePort;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import com.test.cashwithdrawal.shared.exception.CashWithdrawalException;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

class AccountServiceTest {

    private final TransactionPort transactionPort =
            Mockito.mock(TransactionPort.class);

    private final UpdateAccountStatePort updateAccountStatePort =
            Mockito.mock(UpdateAccountStatePort.class);

    private final AccountPort accountPort =
            Mockito.mock(AccountPort.class);

    private final PaymentRestClient paymentRestClient =
            Mockito.mock(PaymentRestClient.class);

    private final AccountService accountService =
            new AccountService(transactionPort,updateAccountStatePort,accountPort,paymentRestClient, 1000L);



    /**
     * Method under test: {@link AccountService#createAccount(Account)}
     */
    @Test
    void testCreateAccountSuccessful() {
       var account = Account.builder()
               .accountNumber("0245253419")
               .nin("2345tt5t")
               .balance(5000L)
               .surname("john")
               .firstname("mike")
               .bankName("west bank")
               .routingNumber("w3eeeee34")
               .build();
        given(accountService.createAccount(account))
                .willReturn(account);
        accountService.createAccount(account);
    }

    /**
     * Method under test: {@link AccountService#createAccount(Account)}
     */
    @Test
    void testCreateAccountThrowError() {

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)), 1000L);
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(500L);
        assertThrows(CashWithdrawalException.class, () -> accountService.createAccount(account));
    }

    /**
     * Method under test: {@link AccountService#getAll()}
     */
    @Test
    void testGetAll() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.findAll()).thenReturn(new ArrayList<>());
        AccountAdapter accountPort = new AccountAdapter(accountRepository);
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        assertTrue((new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)), 1000L)).getAll().isEmpty());
        verify(accountRepository).findAll();
    }
}

