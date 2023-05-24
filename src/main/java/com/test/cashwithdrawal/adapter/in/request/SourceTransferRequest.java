package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.domain.AccountDomain.SourceTransferInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SourceTransferRequest {

    @NotBlank(message = "please enter the type")
    String type;
    @NotNull(message = "What is the source information")
    SourceInformationRequest sourceInformation;
    TransferAccountRequest account;

    public SourceTransferInfo toDomain(){
        return SourceTransferInfo.builder()
                .account(account.toDomain())
                .sourceInformation(sourceInformation.toDomain())
                .type(type)
                .build();
    }
}
