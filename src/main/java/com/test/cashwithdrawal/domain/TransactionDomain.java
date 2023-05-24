package com.test.cashwithdrawal.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDomain {

   Long id;

   LocalDateTime createdDate;

   String destinationAccountNumber;

   String sourceAccountNumber;

   Long amount;

   String username;

   String status;

}
