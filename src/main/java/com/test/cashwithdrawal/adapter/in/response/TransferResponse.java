package com.test.cashwithdrawal.adapter.in.response;


import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TransferResponse {

    private RequestInfoResponse requestInfoResponse;
    private PaymentInfoResponse paymentInfoResponse;

    public static TransferResponse fromDomain(TransferPaymentResponse transferPaymentResponse) {
        return new TransferResponse(
            RequestInfoResponse.toRequestInfoResponse(transferPaymentResponse.getRequestInfo()),
                PaymentInfoResponse.toPaymentInfoResponse(transferPaymentResponse.getPaymentInfo())
        );
    }
}
