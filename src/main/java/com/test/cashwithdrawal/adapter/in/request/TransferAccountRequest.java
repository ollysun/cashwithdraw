package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.domain.AccountDomain.CreatePaymentAccount;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TransferAccountRequest {

    @NotBlank(message = "Please enter the account number")
   String accountNumber;
    @NotBlank(message = "Please enter the currency")
   String currency;
    @NotBlank(message = "Please enter the routing number")
    String routingNumber;

   public CreatePaymentAccount toDomain(){
       return CreatePaymentAccount.builder()
               .accountNumber(accountNumber)
               .currency(currency)
               .routingNumber(routingNumber)
               .build();
    }
}
