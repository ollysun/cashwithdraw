package com.test.cashwithdrawal.adapter.in.web;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.cashwithdrawal.adapter.in.request.*;
import com.test.cashwithdrawal.adapter.in.response.PaymentInfoResponse;
import com.test.cashwithdrawal.adapter.in.response.RequestInfoResponse;
import com.test.cashwithdrawal.adapter.in.response.TransferResponse;
import com.test.cashwithdrawal.application.port.in.AccountUseCase;
import com.test.cashwithdrawal.application.port.in.security.SecurityConfig;
import com.test.cashwithdrawal.domain.AccountDomain.PaymentInfo;
import com.test.cashwithdrawal.domain.AccountDomain.RequestInfo;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(SecurityConfig.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountUseCase accountUseCase;

    @MockBean
    private TransferResponse transferResponse;


    private final ObjectMapper mapper= new ObjectMapper();


    @Test
    @WithMockUser("moses")
    void testTransferMoneyReturnBadRequest() throws Exception {

        var sourceTransferRequest = new TransferAccountRequest();
        sourceTransferRequest.setAccountNumber("0245253419");
        sourceTransferRequest.setCurrency("USD");
        sourceTransferRequest.setRoutingNumber("028444018");

        var destinationTransferRequest = new TransferAccountRequest();
        destinationTransferRequest.setAccountNumber("1885226711");
        destinationTransferRequest.setCurrency("USD");
        destinationTransferRequest.setRoutingNumber("211927207");

        var sourceaccount = new CreateAccountRequest();
        sourceaccount.setCurrency("USD");
        sourceaccount.setNin("2345tt5t");
        sourceaccount.setBalance(5000L);
        sourceaccount.setFirstname("man");
        sourceaccount.setRoutingNumber("028444018");
        sourceaccount.setSurname("mike");
        sourceaccount.setAccountNumber("0245253419");


        when(accountUseCase.createAccount(sourceaccount.toAccountDomain())).thenReturn(sourceaccount.toAccountDomain());
        var destination = new DestinationTransferRequest();
        destination.setAccount(destinationTransferRequest);
        destination.setName("TONY STARK");

        var sourceInformation = new SourceInformationRequest();
        sourceInformation.setName("ONTOP INC");

        var sourcetransfer = new SourceTransferRequest();
        sourcetransfer.setAccount(sourceTransferRequest);
        sourcetransfer.setType("COMPANY");
        sourcetransfer.setSourceInformation(sourceInformation);

        var request = TransferMoneyCommandRequest.builder()
                        .source(sourcetransfer)
                        .destination(destination)
                        .amount(300L)
                        .build();
        mockMvc.perform(post("/accounts/payment")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(request.toTransferMoneyCommand().toString()))
                .andExpect(status().isBadRequest());
    }


    @Test
    @WithMockUser("john")
    void testTransferMoneyReturnSuccessful() throws Exception {

        var sourceTransferRequest = new TransferAccountRequest();
        sourceTransferRequest.setAccountNumber("0245253419");
        sourceTransferRequest.setCurrency("USD");
        sourceTransferRequest.setRoutingNumber("028444018");

        var destinationTransferRequest = new TransferAccountRequest();
        destinationTransferRequest.setAccountNumber("1885226711");
        destinationTransferRequest.setCurrency("USD");
        destinationTransferRequest.setRoutingNumber("211927207");


        var sourceaccount = new CreateAccountRequest();
        sourceaccount.setCurrency("USD");
        sourceaccount.setNin("2345tt5t");
        sourceaccount.setBalance(5000L);
        sourceaccount.setFirstname("man");
        sourceaccount.setRoutingNumber("028444018");
        sourceaccount.setSurname("mike");
        sourceaccount.setAccountNumber("0245253419");

        when(accountUseCase.createAccount(any()))
                .thenReturn(sourceaccount.toAccountDomain());

        var destination = new DestinationTransferRequest();
        destination.setAccount(destinationTransferRequest);
        destination.setName("TONY STARK");

        var sourceInformation = new SourceInformationRequest();
        sourceInformation.setName("ONTOP INC");

        var sourcetransfer = new SourceTransferRequest();
        sourcetransfer.setAccount(sourceTransferRequest);
        sourcetransfer.setType("COMPANY");
        sourcetransfer.setSourceInformation(sourceInformation);

        var request = TransferMoneyCommandRequest.builder()
                .source(sourcetransfer)
                .destination(destination)
                .amount(300L)
                .build();

        var requestInfo = new RequestInfo("processing");
        var paymentInfo = new PaymentInfo(300L, UUID.randomUUID().toString());


        var requestInfoResponse = new RequestInfoResponse("processing");
        var paymentInfoResponse = new PaymentInfoResponse(300L, UUID.randomUUID().toString());

        var transferpaymentResponse = new TransferPaymentResponse();
        transferpaymentResponse.setPaymentInfo(paymentInfo);
        transferpaymentResponse.setRequestInfo(requestInfo);


        doReturn(transferpaymentResponse).when(accountUseCase).sendMoney(any());

        var transferresponseTest = new TransferResponse();
        transferresponseTest.setPaymentInfoResponse(paymentInfoResponse);
        transferresponseTest.setRequestInfoResponse(requestInfoResponse);
        transferresponseTest.fromDomain(transferpaymentResponse);

        mockMvc.perform(post("/accounts/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request.toTransferMoneyCommand()))
                        .characterEncoding("utf-8"))
                        .andExpect(status().isOk());



    }

}

