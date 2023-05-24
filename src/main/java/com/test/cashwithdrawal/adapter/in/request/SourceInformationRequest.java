package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.domain.AccountDomain.SourceInformation;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SourceInformationRequest {

    @NotBlank(message = "please enter the name")
    String name;

    public SourceInformation toDomain(){
        return SourceInformation.builder()
                .name(name)
                .build();
    }
}
