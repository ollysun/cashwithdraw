package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import lombok.Value;

@Value
public class TransferMoneyCommandRequest {
    SourceTransferRequest source;
    DestinationTransferRequest destination;
    Long amount;

    public TransferMoneyCommand toTransferMoneyCommand(){
        return TransferMoneyCommand.builder()
                .amount(amount)
                .destination(destination.toDomain())
                .source(source.toDomain())
                .build();
    }
}
