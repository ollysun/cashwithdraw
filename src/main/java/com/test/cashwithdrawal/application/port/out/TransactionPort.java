package com.test.cashwithdrawal.application.port.out;

import com.test.cashwithdrawal.domain.TransactionDomain;

import java.time.LocalDateTime;

public interface TransactionPort {
    TransactionDomain saveTransactionActivity(TransactionDomain transactionDomain);

}
