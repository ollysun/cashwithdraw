package com.test.cashwithdrawal.adapter.out.persistence.Adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.cashwithdrawal.adapter.out.persistence.entity.AccountEntity;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.AccountRepository;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.shared.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccountAdapterTest {
    /**
     * Method under test: {@link AccountAdapter#save(Account)}
     */
    @Test
    void testSave() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber("42");
        accountEntity.setBalance(42L);
        accountEntity.setBankName("Bank Name");
        accountEntity.setCurrency("GBP");
        accountEntity.setFirstname("Jane");
        accountEntity.setId(1L);
        accountEntity.setNin("Nin");
        accountEntity.setRoutingNumber("42");
        accountEntity.setSurname("Doe");
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.save(Mockito.<AccountEntity>any())).thenReturn(accountEntity);
        AccountAdapter accountAdapter = new AccountAdapter(accountRepository);
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(42L);
        when(account.getAccountNumber()).thenReturn("42");
        when(account.getBankName()).thenReturn("Bank Name");
        when(account.getCurrency()).thenReturn("GBP");
        when(account.getFirstname()).thenReturn("Jane");
        when(account.getNin()).thenReturn("Nin");
        when(account.getRoutingNumber()).thenReturn("42");
        when(account.getSurname()).thenReturn("Doe");
        Account actualSaveResult = accountAdapter.save(account);
        assertEquals("42", actualSaveResult.getAccountNumber());
        assertEquals("Doe", actualSaveResult.getSurname());
        assertEquals("42", actualSaveResult.getRoutingNumber());
        assertEquals("Nin", actualSaveResult.getNin());
        assertEquals("Jane", actualSaveResult.getFirstname());
        assertEquals("GBP", actualSaveResult.getCurrency());
        assertEquals("Bank Name", actualSaveResult.getBankName());
        assertEquals(42L, actualSaveResult.getBalance().longValue());
        verify(accountRepository).save(Mockito.<AccountEntity>any());
        verify(account).getBalance();
        verify(account).getAccountNumber();
        verify(account).getBankName();
        verify(account).getCurrency();
        verify(account).getFirstname();
        verify(account).getNin();
        verify(account).getRoutingNumber();
        verify(account).getSurname();
    }

    /**
     * Method under test: {@link AccountAdapter#fetch()}
     */
    @Test
    void testFetchAll() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue((new AccountAdapter(accountRepository)).fetch().isEmpty());
        verify(accountRepository).findAll();
    }

    /**
     * Method under test: {@link AccountAdapter#findByAccountNumber(String)}
     */

    /**
     * Method under test: {@link AccountAdapter#updateAcccount(String, Long)}
     */
    @Test
    void testUpdateAcccount() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber("42");
        accountEntity.setBalance(42L);
        accountEntity.setBankName("Bank Name");
        accountEntity.setCurrency("GBP");
        accountEntity.setFirstname("Jane");
        accountEntity.setId(1L);
        accountEntity.setNin("Nin");
        accountEntity.setRoutingNumber("42");
        accountEntity.setSurname("Doe");
        Optional<AccountEntity> ofResult = Optional.of(accountEntity);

        AccountEntity accountEntity2 = new AccountEntity();
        accountEntity2.setAccountNumber("42");
        accountEntity2.setBalance(42L);
        accountEntity2.setBankName("Bank Name");
        accountEntity2.setCurrency("GBP");
        accountEntity2.setFirstname("Jane");
        accountEntity2.setId(1L);
        accountEntity2.setNin("Nin");
        accountEntity2.setRoutingNumber("42");
        accountEntity2.setSurname("Doe");
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.save(Mockito.<AccountEntity>any())).thenReturn(accountEntity2);
        when(accountRepository.findByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);
        Account actualUpdateAcccountResult = (new AccountAdapter(accountRepository)).updateAcccount("42", 42L);
        assertEquals("42", actualUpdateAcccountResult.getAccountNumber());
        assertEquals("Doe", actualUpdateAcccountResult.getSurname());
        assertEquals("42", actualUpdateAcccountResult.getRoutingNumber());
        assertEquals("Nin", actualUpdateAcccountResult.getNin());
        assertEquals("Jane", actualUpdateAcccountResult.getFirstname());
        assertEquals("GBP", actualUpdateAcccountResult.getCurrency());
        assertEquals("Bank Name", actualUpdateAcccountResult.getBankName());
        assertEquals(42L, actualUpdateAcccountResult.getBalance().longValue());
        verify(accountRepository).save(Mockito.<AccountEntity>any());
        verify(accountRepository).findByAccountNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link AccountAdapter#updateAcccount(String, Long)}
     */
    @Test
    void testUpdateAcccount2() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber("42");
        accountEntity.setBalance(42L);
        accountEntity.setBankName("Bank Name");
        accountEntity.setCurrency("GBP");
        accountEntity.setFirstname("Jane");
        accountEntity.setId(1L);
        accountEntity.setNin("Nin");
        accountEntity.setRoutingNumber("42");
        accountEntity.setSurname("Doe");
        Optional<AccountEntity> ofResult = Optional.of(accountEntity);
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.save(Mockito.<AccountEntity>any()))
                .thenThrow(new ResourceNotFoundException("User Cannot Be Found"));
        when(accountRepository.findByAccountNumber(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class,
                () -> (new AccountAdapter(accountRepository)).updateAcccount("42", 42L));
        verify(accountRepository).save(Mockito.<AccountEntity>any());
        verify(accountRepository).findByAccountNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link AccountAdapter#updateAcccount(String, Long)}
     */
    @Test
    void testUpdateAcccount3() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber("42");
        accountEntity.setBalance(42L);
        accountEntity.setBankName("Bank Name");
        accountEntity.setCurrency("GBP");
        accountEntity.setFirstname("Jane");
        accountEntity.setId(1L);
        accountEntity.setNin("Nin");
        accountEntity.setRoutingNumber("42");
        accountEntity.setSurname("Doe");
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.save(Mockito.<AccountEntity>any())).thenReturn(accountEntity);
        when(accountRepository.findByAccountNumber(Mockito.<String>any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class,
                () -> (new AccountAdapter(accountRepository)).updateAcccount("42", 42L));
        verify(accountRepository).findByAccountNumber(Mockito.<String>any());
    }
}

