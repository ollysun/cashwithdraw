package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
public class SourceInformation {
    @NotBlank(message = "please enter the name")
    String name;
}
