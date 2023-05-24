package com.test.cashwithdrawal.application.service;

import com.test.cashwithdrawal.application.port.in.SearchTransactionUseCase;
import com.test.cashwithdrawal.application.port.out.SearchTransactionPort;
import com.test.cashwithdrawal.domain.TransactionDomain;
import com.test.cashwithdrawal.shared.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@UseCase
@RequiredArgsConstructor
public class SearchTransactionService implements SearchTransactionUseCase {

    private final SearchTransactionPort searchTransactionPort;
    @Override
    public Page<TransactionDomain> searchTransaction(int page, int size, Long amount, LocalDateTime createdDate) {
        return searchTransactionPort.searchTransactionByAmountOrCreatedDate(page, size, amount,createdDate);
    }
}
