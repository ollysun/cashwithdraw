package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.*;

@ToString
@Builder
@Getter
@Setter
public class Account {

    String surname;
    String firstname;
    String nin; // national identification number
    String bankName;
    String accountNumber;
    String currency;
    String routingNumber;
    Long balance;


}
