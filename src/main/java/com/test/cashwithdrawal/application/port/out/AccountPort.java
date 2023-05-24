package com.test.cashwithdrawal.application.port.out;

import com.test.cashwithdrawal.domain.AccountDomain.Account;

import java.util.List;

public interface AccountPort {
    Account save(Account account);
    List<Account> fetch();

    Account findByAccountNumber(String accountNumber);

}
