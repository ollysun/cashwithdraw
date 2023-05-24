package com.test.cashwithdrawal.application.port.in;

import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import com.test.cashwithdrawal.shared.exception.CashWithdrawalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentRestClient {

    private final RestTemplate restTemplate;

    private String resourceUrl = "http://mockoon.tools.getontop.com:3000/api/v1/payments";
    public TransferPaymentResponse restClient(TransferMoneyCommand transferMoneyCommand){

        log.info("receive request " + transferMoneyCommand.toString());
        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<TransferMoneyCommand> request = new HttpEntity<>(transferMoneyCommand);
        try {
            log.info("send request here");
            // Send the request body in HttpEntity for HTTP POST request
            ResponseEntity<TransferPaymentResponse> productCreateResponse = restTemplate.exchange(resourceUrl,
                                    HttpMethod.POST,
                                    request,
                                    TransferPaymentResponse.class);
            log.info("check response " + productCreateResponse.getBody());
            if (!productCreateResponse.getStatusCode().is2xxSuccessful()){
                log.info("error " + productCreateResponse.getBody());
                throw new CashWithdrawalException("bad request");
            }
            return productCreateResponse.getBody();
        } catch (Exception e) {
            throw new CashWithdrawalException(e.getMessage());
        }
    }
}
