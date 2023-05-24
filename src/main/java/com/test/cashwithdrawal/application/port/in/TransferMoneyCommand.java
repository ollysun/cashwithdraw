package com.test.cashwithdrawal.application.port.in;

import com.test.cashwithdrawal.domain.AccountDomain.DestinationTransferInfo;
import com.test.cashwithdrawal.domain.AccountDomain.SourceTransferInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class TransferMoneyCommand {

    SourceTransferInfo source;
    DestinationTransferInfo destination;
    Long amount;
}
