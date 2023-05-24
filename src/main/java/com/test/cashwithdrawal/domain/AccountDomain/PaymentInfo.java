package com.test.cashwithdrawal.domain.AccountDomain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo  {
    private Long amount;
    private String id;
}
