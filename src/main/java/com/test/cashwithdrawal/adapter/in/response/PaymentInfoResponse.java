package com.test.cashwithdrawal.adapter.in.response;

import com.test.cashwithdrawal.domain.AccountDomain.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class PaymentInfoResponse {

    private Long amount;
    private String id;

}
