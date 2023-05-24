package com.test.cashwithdrawal.domain.AccountDomain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AccountTest {
    /**
     * Method under test: {@link Account#withdraw(Account, Long)}
     */
    @Test
    void testWithdraw() {
        Account account = new Account("Doe", "Jane", "Nin", "Bank Name", "42", "GBP", "42", 42L);
        Account towithdraw = new Account("Doe", "Jane", "Nin", "Bank Name", "42", "GBP", "42", 42L);

        Account actualWithdrawResult = account.withdraw(towithdraw, 10L);
        assertSame(towithdraw, actualWithdrawResult);
        assertEquals(32L, actualWithdrawResult.getBalance().longValue());
    }

}

