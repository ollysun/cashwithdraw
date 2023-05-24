package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferPaymentResponse {
    private RequestInfo requestInfo;
    private PaymentInfo paymentInfo;
}
