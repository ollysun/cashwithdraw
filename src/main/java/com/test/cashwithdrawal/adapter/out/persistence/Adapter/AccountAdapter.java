package com.test.cashwithdrawal.adapter.out.persistence.Adapter;

import com.test.cashwithdrawal.adapter.out.persistence.entity.AccountEntity;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.AccountRepository;
import com.test.cashwithdrawal.application.port.out.AccountPort;
import com.test.cashwithdrawal.application.port.out.UpdateAccountStatePort;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.shared.PersistenceAdapter;
import com.test.cashwithdrawal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@PersistenceAdapter
public class AccountAdapter implements AccountPort, UpdateAccountStatePort {

    private final AccountRepository accountRepository;
    @Override
    public Account save(Account account) {
        return accountRepository.save(AccountEntity.fromDomain(account)).toDomain();
    }

    @Override
    public List<Account> fetch() {
        List<Account> accountList = new ArrayList<>();

        for (AccountEntity accountEntity : accountRepository.findAll()){
            Account account = accountEntity.toDomain();
            accountList.add(account);
        }
        return accountList;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("The account details could not be found "));
        return accountEntity.toDomain();
    }

    @Override
    public Account updateAcccount(String accountNumber, Long balance) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("The account details could not be found "));
        accountEntity.setBalance(balance);
        return accountRepository.save(accountEntity).toDomain();
    }

}
