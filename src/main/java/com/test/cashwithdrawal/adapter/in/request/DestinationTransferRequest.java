package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.domain.AccountDomain.DestinationTransferInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;

@Slf4j
@Getter
@Setter
public class DestinationTransferRequest {
    @NotBlank(message = "Please enter the name for destination")
    String name;
    TransferAccountRequest account;

    public DestinationTransferInfo toDomain(){
         return DestinationTransferInfo.builder()
                 .account(account.toDomain())
                 .name(name)
                 .build();
    }
}
