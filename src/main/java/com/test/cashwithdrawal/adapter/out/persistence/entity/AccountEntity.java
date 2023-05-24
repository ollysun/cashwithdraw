package com.test.cashwithdrawal.adapter.out.persistence.entity;

import com.test.cashwithdrawal.domain.AccountDomain.Account;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String surname;
    String firstname;
    @Column(name = "routing_number",nullable = false)
    String routingNumber;
    String nin; // national identification number
    @Column(name = "account_number", unique = true, nullable = false)
    String accountNumber;
    String bankName;
    Long balance;
    String currency;

    public Account toDomain() {
        return Account.builder()
                .accountNumber(accountNumber)
                .balance(balance)
                .nin(nin)
                .surname(surname)
                .firstname(firstname)
                .routingNumber(routingNumber)
                .bankName(bankName)
                .currency(currency)
                .build();
    }



    public static AccountEntity fromDomain(Account account) {
        return AccountEntity.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .nin(account.getNin())
                .surname(account.getSurname())
                .firstname(account.getFirstname())
                .routingNumber(account.getRoutingNumber())
                .bankName(account.getBankName())
                .currency(account.getCurrency())
                .build();
    }

}
