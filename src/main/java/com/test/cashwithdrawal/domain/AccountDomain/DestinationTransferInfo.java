package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@ToString
@Value
@Builder
public class DestinationTransferInfo {
    @NotBlank(message = "Please enter the name")
    String name;
    CreatePaymentAccount account;
}