package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Value
@Builder
public class SourceTransferInfo {
    @NotBlank(message = "please enter the type")
    String type;
    @NotNull(message = "What is the source information")
    SourceInformation sourceInformation;
    CreatePaymentAccount account;
}
