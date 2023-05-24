package com.test.cashwithdrawal.adapter.in.response;

import com.test.cashwithdrawal.domain.AccountDomain.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentInfoResponse {

    private Long amount;
    private String id;

    public static PaymentInfoResponse toPaymentInfoResponse(PaymentInfo paymentInfo){
        return new PaymentInfoResponse(paymentInfo.getAmount(), paymentInfo.getId());
    }
}
