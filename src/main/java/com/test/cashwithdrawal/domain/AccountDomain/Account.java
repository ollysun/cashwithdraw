package com.test.cashwithdrawal.domain.AccountDomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@ToString
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    String surname;
    String firstname;
    String nin; // national identification number
    String bankName;
    String accountNumber;
    String currency;
    String routingNumber;
    Long balance;


    Account withdraw(Account towithdraw, Long amount){
        Long newBalance = towithdraw.getBalance() - amount;
        towithdraw.setBalance(newBalance);
        return towithdraw;
    }
}
