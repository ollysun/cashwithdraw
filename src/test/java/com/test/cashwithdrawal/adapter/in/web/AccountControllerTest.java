package com.test.cashwithdrawal.adapter.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.cashwithdrawal.adapter.in.request.CreateAccountRequest;
import com.test.cashwithdrawal.adapter.in.request.DestinationTransferRequest;
import com.test.cashwithdrawal.adapter.in.request.SourceTransferRequest;
import com.test.cashwithdrawal.adapter.in.request.TransferAccountRequest;
import com.test.cashwithdrawal.adapter.in.request.TransferMoneyCommandRequest;
import com.test.cashwithdrawal.adapter.in.response.PaymentInfoResponse;
import com.test.cashwithdrawal.adapter.in.response.TransferResponse;
import com.test.cashwithdrawal.adapter.out.persistence.Adapter.AccountAdapter;
import com.test.cashwithdrawal.adapter.out.persistence.repositories.AccountRepository;
import com.test.cashwithdrawal.application.port.in.AccountUseCase;
import com.test.cashwithdrawal.application.port.in.PaymentRestClient;
import com.test.cashwithdrawal.application.port.in.TransferMoneyCommand;
import com.test.cashwithdrawal.application.port.out.TransactionPort;
import com.test.cashwithdrawal.application.port.out.UpdateAccountStatePort;
import com.test.cashwithdrawal.application.service.AccountService;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.domain.AccountDomain.PaymentInfo;
import com.test.cashwithdrawal.domain.AccountDomain.RequestInfo;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes = {AccountController.class})
@ExtendWith(SpringExtension.class)
class AccountControllerTest {
    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountUseCase accountUseCase;

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransferMoney() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.adapter.in.request.DestinationTransferRequest.toDomain(DestinationTransferRequest.java:20)
        //       at com.test.cashwithdrawal.adapter.in.request.TransferMoneyCommandRequest.toTransferMoneyCommand(TransferMoneyCommandRequest.java:15)
        //       at com.test.cashwithdrawal.adapter.in.web.AccountController.transferMoney(AccountController.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountController accountController = new AccountController(new AccountService(transactionPort,
                updateAccountStatePort, accountPort, new PaymentRestClient(mock(RestTemplate.class))));
        SourceTransferRequest source = new SourceTransferRequest();
        accountController.transferMoney(new TransferMoneyCommandRequest(source, new DestinationTransferRequest(), 10L));
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransferMoney2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.adapter.in.request.SourceTransferRequest.toDomain(SourceTransferRequest.java:22)
        //       at com.test.cashwithdrawal.adapter.in.request.TransferMoneyCommandRequest.toTransferMoneyCommand(TransferMoneyCommandRequest.java:16)
        //       at com.test.cashwithdrawal.adapter.in.web.AccountController.transferMoney(AccountController.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountController accountController = new AccountController(new AccountService(transactionPort,
                updateAccountStatePort, accountPort, new PaymentRestClient(mock(RestTemplate.class))));

        DestinationTransferRequest destination = new DestinationTransferRequest();
        destination.setAccount(new TransferAccountRequest());
        accountController.transferMoney(new TransferMoneyCommandRequest(new SourceTransferRequest(), destination, 10L));
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransferMoney3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.application.service.AccountService.sendMoney(AccountService.java:40)
        //       at com.test.cashwithdrawal.adapter.in.web.AccountController.transferMoney(AccountController.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        TransactionPort transactionPort = mock(TransactionPort.class);
        UpdateAccountStatePort updateAccountStatePort = mock(UpdateAccountStatePort.class);
        AccountAdapter accountPort = new AccountAdapter(mock(AccountRepository.class));
        AccountController accountController = new AccountController(new AccountService(transactionPort,
                updateAccountStatePort, accountPort, new PaymentRestClient(mock(RestTemplate.class))));
        SourceTransferRequest source = mock(SourceTransferRequest.class);
        when(source.toDomain()).thenReturn(null);

        TransferAccountRequest account = new TransferAccountRequest();
        account.setAccountNumber("42");

        DestinationTransferRequest destination = new DestinationTransferRequest();
        destination.setAccount(account);
        accountController.transferMoney(new TransferMoneyCommandRequest(source, destination, 10L));
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransferMoney4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.adapter.in.response.RequestInfoResponse.toRequestInfoResponse(RequestInfoResponse.java:15)
        //       at com.test.cashwithdrawal.adapter.in.response.TransferResponse.fromDomain(TransferResponse.java:20)
        //       at com.test.cashwithdrawal.adapter.in.web.AccountController.transferMoney(AccountController.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        AccountUseCase accountUseCase = mock(AccountUseCase.class);
        when(accountUseCase.sendMoney(Mockito.<TransferMoneyCommand>any())).thenReturn(new TransferPaymentResponse());
        AccountController accountController = new AccountController(accountUseCase);
        SourceTransferRequest source = mock(SourceTransferRequest.class);
        when(source.toDomain()).thenReturn(null);

        TransferAccountRequest account = new TransferAccountRequest();
        account.setAccountNumber("42");

        DestinationTransferRequest destination = new DestinationTransferRequest();
        destination.setAccount(account);
        accountController.transferMoney(new TransferMoneyCommandRequest(source, destination, 10L));
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    void testTransferMoney5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        AccountUseCase accountUseCase = mock(AccountUseCase.class);
        RequestInfo requestInfo = new RequestInfo("Status");
        when(accountUseCase.sendMoney(Mockito.<TransferMoneyCommand>any()))
                .thenReturn(new TransferPaymentResponse(requestInfo, new PaymentInfo()));
        AccountController accountController = new AccountController(accountUseCase);
        SourceTransferRequest source = mock(SourceTransferRequest.class);
        when(source.toDomain()).thenReturn(null);

        TransferAccountRequest account = new TransferAccountRequest();
        account.setAccountNumber("42");

        DestinationTransferRequest destination = new DestinationTransferRequest();
        destination.setAccount(account);
        ResponseEntity<TransferResponse> actualTransferMoneyResult = accountController
                .transferMoney(new TransferMoneyCommandRequest(source, destination, 10L));
        assertTrue(actualTransferMoneyResult.hasBody());
        assertTrue(actualTransferMoneyResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualTransferMoneyResult.getStatusCode());
        TransferResponse body = actualTransferMoneyResult.getBody();
        assertEquals("Status", body.getRequestInfoResponse().getStatus());
        PaymentInfoResponse paymentInfoResponse = body.getPaymentInfoResponse();
        assertNull(paymentInfoResponse.getId());
        assertNull(paymentInfoResponse.getAmount());
        verify(accountUseCase).sendMoney(Mockito.<TransferMoneyCommand>any());
        verify(source, atLeast(1)).toDomain();
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTransferMoney6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.test.cashwithdrawal.adapter.in.response.PaymentInfoResponse.toPaymentInfoResponse(PaymentInfoResponse.java:17)
        //       at com.test.cashwithdrawal.adapter.in.response.TransferResponse.fromDomain(TransferResponse.java:21)
        //       at com.test.cashwithdrawal.adapter.in.web.AccountController.transferMoney(AccountController.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        TransferPaymentResponse transferPaymentResponse = mock(TransferPaymentResponse.class);
        when(transferPaymentResponse.getPaymentInfo()).thenReturn(null);
        when(transferPaymentResponse.getRequestInfo()).thenReturn(new RequestInfo("Status"));
        AccountUseCase accountUseCase = mock(AccountUseCase.class);
        when(accountUseCase.sendMoney(Mockito.<TransferMoneyCommand>any())).thenReturn(transferPaymentResponse);
        AccountController accountController = new AccountController(accountUseCase);
        SourceTransferRequest source = mock(SourceTransferRequest.class);
        when(source.toDomain()).thenReturn(null);

        TransferAccountRequest account = new TransferAccountRequest();
        account.setAccountNumber("42");

        DestinationTransferRequest destination = new DestinationTransferRequest();
        destination.setAccount(account);
        accountController.transferMoney(new TransferMoneyCommandRequest(source, destination, 10L));
    }

    /**
     * Method under test: {@link AccountController#transferMoney(TransferMoneyCommandRequest)}
     */
    @Test
    void testTransferMoney7() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.nio.charset.IllegalCharsetNameException: https://example.org/example
        //       at java.nio.charset.Charset.checkName(Charset.java:308)
        //       at java.nio.charset.Charset.lookup2(Charset.java:482)
        //       at java.nio.charset.Charset.lookup(Charset.java:462)
        //       at java.nio.charset.Charset.forName(Charset.java:526)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
        //   See https://diff.blue/R013 to resolve this issue.

        TransferPaymentResponse transferPaymentResponse = mock(TransferPaymentResponse.class);
        when(transferPaymentResponse.getPaymentInfo()).thenReturn(new PaymentInfo());
        when(transferPaymentResponse.getRequestInfo()).thenReturn(new RequestInfo("Status"));
        AccountUseCase accountUseCase = mock(AccountUseCase.class);
        when(accountUseCase.sendMoney(Mockito.<TransferMoneyCommand>any())).thenReturn(transferPaymentResponse);
        AccountController accountController = new AccountController(accountUseCase);
        SourceTransferRequest source = mock(SourceTransferRequest.class);
        when(source.toDomain()).thenReturn(null);

        TransferAccountRequest account = new TransferAccountRequest();
        account.setAccountNumber("42");
        DestinationTransferRequest destination = mock(DestinationTransferRequest.class);
        when(destination.toDomain()).thenReturn(null);
        doNothing().when(destination).setAccount(Mockito.<TransferAccountRequest>any());
        destination.setAccount(account);
        ResponseEntity<TransferResponse> actualTransferMoneyResult = accountController
                .transferMoney(new TransferMoneyCommandRequest(source, destination, 10L));
        assertTrue(actualTransferMoneyResult.hasBody());
        assertTrue(actualTransferMoneyResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualTransferMoneyResult.getStatusCode());
        TransferResponse body = actualTransferMoneyResult.getBody();
        assertEquals("Status", body.getRequestInfoResponse().getStatus());
        PaymentInfoResponse paymentInfoResponse = body.getPaymentInfoResponse();
        assertNull(paymentInfoResponse.getId());
        assertNull(paymentInfoResponse.getAmount());
        verify(accountUseCase).sendMoney(Mockito.<TransferMoneyCommand>any());
        verify(transferPaymentResponse).getPaymentInfo();
        verify(transferPaymentResponse).getRequestInfo();
        verify(source, atLeast(1)).toDomain();
        verify(destination, atLeast(1)).toDomain();
        verify(destination).setAccount(Mockito.<TransferAccountRequest>any());
    }

    /**
     * Method under test: {@link AccountController#createAccount(CreateAccountRequest)}
     */
    @Test
    void testCreateAccount() throws Exception {
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(42L);
        when(account.getAccountNumber()).thenReturn("42");
        when(account.getBankName()).thenReturn("Bank Name");
        when(account.getCurrency()).thenReturn("GBP");
        when(account.getFirstname()).thenReturn("Jane");
        when(account.getNin()).thenReturn("Nin");
        when(account.getRoutingNumber()).thenReturn("42");
        when(account.getSurname()).thenReturn("Doe");
        when(accountUseCase.createAccount(Mockito.<Account>any())).thenReturn(account);

        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountNumber("42");
        createAccountRequest.setBalance(42L);
        createAccountRequest.setBankName("Bank Name");
        createAccountRequest.setCurrency("GBP");
        createAccountRequest.setFirstname("Jane");
        createAccountRequest.setNin("Nin");
        createAccountRequest.setRoutingNumber("42");
        createAccountRequest.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(createAccountRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"surname\":\"Doe\",\"firstname\":\"Jane\",\"routingNumber\":\"42\",\"nin\":\"Nin\",\"accountNumber\":\"42\",\"bankName\":\"Bank"
                                        + " Name\",\"currency\":\"GBP\",\"balance\":42}"));
    }

    /**
     * Method under test: {@link AccountController#createAccount(CreateAccountRequest)}
     */
    @Test
    void testCreateAccount2() throws Exception {
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(42L);
        when(account.getAccountNumber()).thenReturn("42");
        when(account.getBankName()).thenReturn("Bank Name");
        when(account.getCurrency()).thenReturn("GBP");
        when(account.getFirstname()).thenReturn("Jane");
        when(account.getNin()).thenReturn("Nin");
        when(account.getRoutingNumber()).thenReturn("42");
        when(account.getSurname()).thenReturn("Doe");
        when(accountUseCase.createAccount(Mockito.<Account>any())).thenReturn(account);

        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountNumber("");
        createAccountRequest.setBalance(42L);
        createAccountRequest.setBankName("Bank Name");
        createAccountRequest.setCurrency("GBP");
        createAccountRequest.setFirstname("Jane");
        createAccountRequest.setNin("Nin");
        createAccountRequest.setRoutingNumber("42");
        createAccountRequest.setSurname("Doe");
        String content = (new ObjectMapper()).writeValueAsString(createAccountRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/accounts/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link AccountController#getAccounts()}
     */
    @Test
    void testGetAccounts() throws Exception {
        when(accountUseCase.getAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AccountController#getAccounts()}
     */
    @Test
    void testGetAccounts2() throws Exception {
        Account account = mock(Account.class);
        when(account.getBalance()).thenReturn(42L);
        when(account.getAccountNumber()).thenReturn("42");
        when(account.getBankName()).thenReturn("Bank Name");
        when(account.getCurrency()).thenReturn("GBP");
        when(account.getFirstname()).thenReturn("Jane");
        when(account.getNin()).thenReturn("Nin");
        when(account.getRoutingNumber()).thenReturn("42");
        when(account.getSurname()).thenReturn("Doe");

        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        when(accountUseCase.getAll()).thenReturn(accountList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts");
        MockMvcBuilders.standaloneSetup(accountController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"surname\":\"Doe\",\"firstname\":\"Jane\",\"routingNumber\":\"42\",\"nin\":\"Nin\",\"accountNumber\":\"42\",\"bankName\":\"Bank"
                                        + " Name\",\"currency\":\"GBP\",\"balance\":42}]"));
    }
}

