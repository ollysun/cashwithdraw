package com.test.cashwithdrawal.application.port.in;

import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;

import java.util.List;

public interface AccountUseCase {

    TransferPaymentResponse sendMoney(TransferMoneyCommand command);

    Account createAccount(Account account);

    List<Account> getAll();

}
