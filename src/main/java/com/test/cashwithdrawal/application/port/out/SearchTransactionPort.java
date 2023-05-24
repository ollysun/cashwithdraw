package com.test.cashwithdrawal.application.port.out;

import com.test.cashwithdrawal.domain.TransactionDomain;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface SearchTransactionPort {

    Page<TransactionDomain> searchTransactionByAmountOrCreatedDate(int page, int size, Long amount, LocalDateTime createdDate);

}
