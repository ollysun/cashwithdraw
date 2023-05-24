package com.test.cashwithdrawal.adapter.in.request;

import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.io.Serializable;

@ToString
@Builder
@Value
public class TransferMoneyCommandRequest implements Serializable {
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
