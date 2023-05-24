package com.test.cashwithdrawal.adapter.in.web;

import com.test.cashwithdrawal.application.port.in.SearchTransactionUseCase;
import com.test.cashwithdrawal.domain.TransactionDomain;
import com.test.cashwithdrawal.shared.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private final SearchTransactionUseCase searchTransactionUseCase;

    @GetMapping(path = "/search")
    public Page<TransactionDomain> searchTransaction( @RequestParam(required = false) Long  amount,
                                                      @RequestParam(required = false) LocalDateTime createdDate,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        return searchTransactionUseCase.searchTransaction(page,size,amount,createdDate);
    }
}
