package com.test.cashwithdrawal.adapter.in.web;

import com.test.cashwithdrawal.adapter.in.request.CreateAccountRequest;
import com.test.cashwithdrawal.adapter.in.request.TransferMoneyCommandRequest;
import com.test.cashwithdrawal.adapter.in.response.AccountResponse;
import com.test.cashwithdrawal.adapter.in.response.TransferResponse;
import com.test.cashwithdrawal.application.port.in.AccountUseCase;
import com.test.cashwithdrawal.domain.AccountDomain.Account;
import com.test.cashwithdrawal.domain.AccountDomain.TransferPaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountUseCase accountUseCase;

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        return new ResponseEntity<>(AccountResponse.getAllAccount(accountUseCase.getAll()), HttpStatus.OK);
    }

    @PostMapping(path = "/payment")
    public ResponseEntity<TransferResponse> transferMoney(@RequestBody @Valid TransferMoneyCommandRequest paymentRequest) {
        log.info(" payment request " + paymentRequest.toTransferMoneyCommand().toString());
        TransferPaymentResponse transferPaymentResponse = accountUseCase.sendMoney(paymentRequest.toTransferMoneyCommand());
        return new ResponseEntity<>(TransferResponse.fromDomain(transferPaymentResponse), HttpStatus.OK);
    }


    @PostMapping(path = "/create")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        Account account = accountUseCase.createAccount(createAccountRequest.toAccountDomain());
        return new ResponseEntity<>(AccountResponse.fromDomain(account), HttpStatus.CREATED);
    }


}
