package com.test.cashwithdrawal.application.port.in;

import com.test.cashwithdrawal.domain.TransactionDomain;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface SearchTransactionUseCase {
    Page<TransactionDomain> searchTransaction(int page, int size, Long balance, LocalDateTime createdDate);
}
