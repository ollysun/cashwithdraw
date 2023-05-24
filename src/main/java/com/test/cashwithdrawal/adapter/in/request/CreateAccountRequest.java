package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.domain.AccountDomain.Account;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateAccountRequest {

    @NotBlank(message = "please enter the surname")
    String surname;
    @NotBlank(message = "please enter the firstname")
    String firstname;
    @NotBlank(message = "please enter the routing number")
    String routingNumber;
    @NotBlank(message = "please enter the national identification number")
    String nin; // national identification number
    @NotBlank(message = "please enter the account number")
    String accountNumber;
    @NotBlank(message = "please enter the bank name")
    String bankName;
    @NotBlank(message = "please enter the currency")
    String currency;
    @NotNull(message = "please enter the balance")
    Long balance = 0L;

    public Account toAccountDomain(){
        return Account.builder()
                .routingNumber(routingNumber)
                .currency(currency)
                .nin(nin)
                .firstname(firstname)
                .surname(surname)
                .accountNumber(accountNumber)
                .balance(balance)
                .bankName(bankName)
                .build();
    }
}
