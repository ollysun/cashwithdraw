package com.test.cashwithdrawal.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.test.cashwithdrawal.adapter.out.persistence.Adapter.AccountAdapter;
import com.test.cashwithdrawal.adapter.out.persistence.entity.AccountEntity;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.AccountRepository;
import com.test.cashwithdrawal.application.port.in.PaymentRestClient;
import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import com.test.cashwithdrawal.application.port.out.TransactionPort;
import com.test.cashwithdrawal.application.port.out.UpdateAccountStatePort;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.shared.exception.CashWithdrawalException;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

class AccountServiceTest {
    /**
     * Method under test: {@link AccountService#sendMoney(TransferMoneyCommand)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendMoney() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.application.service.AccountService.sendMoney(AccountService.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        (new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)))).sendMoney(mock(TransferMoneyCommand.class));
    }

    /**
     * Method under test: {@link AccountService#createAccount(Account)}
     */
    @Test
    void testCreateAccount() {
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
        AccountAdapter accountPort = new AccountAdapter(accountRepository);
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(42L);
        when(account.getAccountNumber()).thenReturn("42");
        when(account.getBankName()).thenReturn("Bank Name");
        when(account.getCurrency()).thenReturn("GBP");
        when(account.getFirstname()).thenReturn("Jane");
        when(account.getNin()).thenReturn("Nin");
        when(account.getRoutingNumber()).thenReturn("42");
        when(account.getSurname()).thenReturn("Doe");
        Account actualCreateAccountResult = accountService.createAccount(account);
        assertEquals("42", actualCreateAccountResult.getAccountNumber());
        assertEquals("Doe", actualCreateAccountResult.getSurname());
        assertEquals("42", actualCreateAccountResult.getRoutingNumber());
        assertEquals("Nin", actualCreateAccountResult.getNin());
        assertEquals("Jane", actualCreateAccountResult.getFirstname());
        assertEquals("GBP", actualCreateAccountResult.getCurrency());
        assertEquals("Bank Name", actualCreateAccountResult.getBankName());
        assertEquals(42L, actualCreateAccountResult.getBalance().longValue());
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
     * Method under test: {@link AccountService#createAccount(Account)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccount2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.test.cashwithdrawal.shared.exception.CashWithdrawalException: An error occurred
        //       at com.test.cashwithdrawal.adapter.out.persistence.entity.AccountEntity.fromDomain(AccountEntity.java:48)
        //       at com.test.cashwithdrawal.adapter.out.persistence.Adapter.AccountAdapter.save(AccountAdapter.java:24)
        //       at com.test.cashwithdrawal.application.service.AccountService.createAccount(AccountService.java:80)
        //   See https://diff.blue/R013 to resolve this issue.

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
        AccountAdapter accountPort = new AccountAdapter(accountRepository);
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account account = mock(Account.class);
        when(account.getBalance()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getAccountNumber()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getBankName()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getCurrency()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getFirstname()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getNin()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getRoutingNumber()).thenThrow(new CashWithdrawalException("An error occurred"));
        when(account.getSurname()).thenThrow(new CashWithdrawalException("An error occurred"));
        accountService.createAccount(account);
    }

    /**
     * Method under test: {@link AccountService#getAll()}
     */
    @Test
    void testGetAll() {
        AccountRepository accountRepository = mock(AccountRepository.class);
        when(accountRepository.findAll()).thenReturn(new ArrayList<>());
        AccountAdapter accountPort = new AccountAdapter(accountRepository);
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        assertTrue((new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)))).getAll().isEmpty());
        verify(accountRepository).findAll();
    }

    /**
     * Method under test: {@link AccountService#getAll()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAll2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.application.service.AccountService.getAll(AccountService.java:85)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        (new AccountService(transactionPort, updateAccountStatePort, null,
                new PaymentRestClient(mock(RestTemplate.class)))).getAll();
    }

    /**
     * Method under test: {@link AccountService#checkBalance(Account, Long)}
     */
    @Test
    void testCheckBalance() {
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account source = mock(Account.class);
        when(source.getBalance()).thenReturn(42L);
        assertFalse(accountService.checkBalance(source, 10L));
        verify(source, atLeast(1)).getBalance();
    }

    /**
     * Method under test: {@link AccountService#checkBalance(Account, Long)}
     */
    @Test
    void testCheckBalance2() {
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account source = mock(Account.class);
        when(source.getBalance()).thenReturn(1L);
        assertTrue(accountService.checkBalance(source, 10L));
        verify(source, atLeast(1)).getBalance();
    }

    /**
     * Method under test: {@link AccountService#checkBalance(Account, Long)}
     */
    @Test
    void testCheckBalance3() {
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account source = mock(Account.class);
        when(source.getBalance()).thenReturn(-1L);
        assertTrue(accountService.checkBalance(source, 10L));
        verify(source).getBalance();
    }

    /**
     * Method under test: {@link AccountService#checkBalance(Account, Long)}
     */
    @Test
    void testCheckBalance4() {
        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountService accountService = new AccountService(transactionPort, updateAccountStatePort, accountPort,
                new PaymentRestClient(mock(RestTemplate.class)));
        Account source = mock(Account.class);
        when(source.getBalance()).thenThrow(new CashWithdrawalException("An error occurred"));
        accountService.checkBalance(source, 10L);
        verify(source).getBalance();
    }
}

