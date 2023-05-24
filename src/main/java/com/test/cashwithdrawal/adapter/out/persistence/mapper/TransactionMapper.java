package com.test.cashwithdrawal.adapter.out.persistence.mapper;

import com.test.cashwithdrawal.adapter.out.persistence.entity.TransactionEntity;
import com.test.cashwithdrawal.domain.TransactionDomain;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public  TransactionDomain toDomain(TransactionEntity transactionEntity) {
        var domain = new TransactionDomain();
        domain.setUsername(transactionEntity.getUsername());
        domain.setAmount(transactionEntity.getAmount());
        domain.setSourceAccountNumber(transactionEntity.getSourceAccountNumber());
        domain.setDestinationAccountNumber(transactionEntity.getDestinationAccountNumber());
        domain.setId(transactionEntity.getId());
        domain.setCreatedDate(transactionEntity.getCreatedDate());
        domain.setStatus(transactionEntity.getStatus());
        return domain;
    }

    public TransactionEntity fromDomain(TransactionDomain transactionDomain) {
        var entity = new TransactionEntity();
        entity.setId(transactionDomain.getId());
        entity.setAmount(transactionDomain.getAmount());
        entity.setCreatedDate(transactionDomain.getCreatedDate());
        entity.setUsername(transactionDomain.getUsername());
        entity.setSourceAccountNumber(transactionDomain.getSourceAccountNumber());
        entity.setDestinationAccountNumber(transactionDomain.getDestinationAccountNumber());
        entity.setStatus(transactionDomain.getStatus());
        return entity;
    }
}
