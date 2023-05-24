package com.test.cashwithdrawal.adapter.in.response;


import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponse {

    private RequestInfoResponse requestInfoResponse;
    private PaymentInfoResponse paymentInfoResponse;

    public TransferResponse fromDomain(TransferPaymentResponse transferPaymentResponse) {
        requestInfoResponse = new RequestInfoResponse(transferPaymentResponse.getRequestInfo().getStatus());
        paymentInfoResponse = new PaymentInfoResponse(transferPaymentResponse.getPaymentInfo().getAmount(),
                transferPaymentResponse.getPaymentInfo().getId());
        return new TransferResponse(requestInfoResponse, paymentInfoResponse);
    }
}
