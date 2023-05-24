package com.test.cashwithdrawal.adapter.in.response;


import com.test.cashwithdrawal.domain.AccountDomain.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Builder
@Getter
@Setter
public class AccountResponse {

    String surname;
    String firstname;
    String routingNumber;
    String nin; // national identification number
    String accountNumber;
    String bankName;
    String currency;
    Long balance;

    public static AccountResponse fromDomain(Account account) {
        return AccountResponse.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .nin(account.getNin())
                .surname(account.getSurname())
                .firstname(account.getFirstname())
                .routingNumber(account.getRoutingNumber())
                .accountNumber(account.getAccountNumber())
                .bankName(account.getBankName())
                .currency(account.getCurrency())
                .build();
    }


    public static List<AccountResponse> getAllAccount(List<Account> accountList){
        List<AccountResponse> accountResponseList = new ArrayList<>();
        for (Account account: accountList){
            AccountResponse accountResponse = fromDomain(account);
            accountResponseList.add(accountResponse);
        }
        return accountResponseList;
    }



}
