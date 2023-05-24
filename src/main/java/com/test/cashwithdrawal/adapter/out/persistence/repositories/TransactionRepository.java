package com.test.cashwithdrawal.adapter.out.persistence.repositories;

import com.test.cashwithdrawal.adapter.out.persistence.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    Page<TransactionEntity> findByAmountOrCreatedDate(Long amount, LocalDateTime createdDate, Pageable pageable);


}
