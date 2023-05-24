package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferPaymentResponse {
    private RequestInfo requestInfo;
    private PaymentInfo paymentInfo;
}
