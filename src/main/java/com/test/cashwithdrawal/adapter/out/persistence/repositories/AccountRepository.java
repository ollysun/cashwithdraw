package com.test.cashwithdrawal.adapter.out.persistence.repositories;

import com.test.cashwithdrawal.adapter.out.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}
