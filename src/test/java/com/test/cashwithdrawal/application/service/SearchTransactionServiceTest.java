package com.test.cashwithdrawal.application.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.cashwithdrawal.application.port.out.SearchTransactionPort;
import com.test.cashwithdrawal.domain.TransactionDomain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

class SearchTransactionServiceTest {
    /**
     * Method under test: {@link SearchTransactionService#searchTransaction(int, int, Long, LocalDateTime)}
     */
    @Test
    void testSearchTransaction() {
        SearchTransactionPort searchTransactionPort = mock(SearchTransactionPort.class);
        PageImpl<TransactionDomain> pageImpl = new PageImpl<>(new ArrayList<>());
        when(searchTransactionPort.searchTransactionByAmountOrCreatedDate(anyInt(), anyInt(), Mockito.<Long>any(),
                Mockito.<LocalDateTime>any())).thenReturn(pageImpl);
        SearchTransactionService searchTransactionService = new SearchTransactionService(searchTransactionPort);
        Page<TransactionDomain> actualSearchTransactionResult = searchTransactionService.searchTransaction(1, 3, 10L,
                LocalDate.of(1970, 1, 1).atStartOfDay());
        assertSame(pageImpl, actualSearchTransactionResult);
        assertTrue(actualSearchTransactionResult.toList().isEmpty());
        verify(searchTransactionPort).searchTransactionByAmountOrCreatedDate(anyInt(), anyInt(), Mockito.<Long>any(),
                Mockito.<LocalDateTime>any());
    }
}

