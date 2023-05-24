package com.test.cashwithdrawal.adapter.out.persistence.Adapter;

import com.test.cashwithdrawal.adapter.out.persistence.entity.TransactionEntity;
import com.test.cashwithdrawal.adapter.out.persistence.mapper.TransactionMapper;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.TransactionRepository;
import com.test.cashwithdrawal.application.port.out.SearchTransactionPort;
import com.test.cashwithdrawal.application.port.out.TransactionPort;
import com.test.cashwithdrawal.domain.TransactionDomain;
import com.test.cashwithdrawal.shared.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@PersistenceAdapter
public class TransactionAdapter implements TransactionPort, SearchTransactionPort {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionDomain saveTransactionActivity(TransactionDomain transactionDomain) {
        TransactionEntity transactionEntity = transactionMapper.fromDomain(transactionDomain);
        return transactionMapper.toDomain(transactionRepository.save(transactionEntity));
    }

    @Override
    public Page<TransactionDomain> searchTransactionByAmountOrCreatedDate(int page, int size, Long amount, LocalDateTime createdDate) {
        Pageable paging = PageRequest.of(page, size, Sort.by("createdDate")); // descending by default
        Page<TransactionDomain> transactionDomainPage;
        if(Objects.isNull(amount) && Objects.isNull(createdDate)){
            transactionDomainPage   = transactionRepository.findAll(paging).map(transactionMapper::toDomain);
        }else {
            transactionDomainPage = transactionRepository.findByAmountOrCreatedDate(amount,createdDate, paging).map(transactionMapper::toDomain);
        }
        return transactionDomainPage;
    }


}
