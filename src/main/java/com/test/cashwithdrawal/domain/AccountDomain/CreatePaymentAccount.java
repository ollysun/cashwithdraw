package com.test.cashwithdrawal.domain.AccountDomain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePaymentAccount {
    @NotBlank(message = "Please enter the account number")
    String accountNumber;
    @NotBlank(message = "Please enter the currency")
    String currency;
    @NotBlank(message = "Please enter the routing number")
    String routingNumber;
}
