package com.test.cashwithdrawal.application.port.out;

import com.test.cashwithdrawal.domain.AccountDomain.Account;

public interface UpdateAccountStatePort {
    Account updateAcccount(String accountNumber, Long balance);
}
