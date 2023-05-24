package com.test.cashwithdrawal.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private LocalDateTime createdDate;

	@Column(name = "destination_account_number")
	private String destinationAccountNumber;

	@Column(name = "source_account_number")
	private String sourceAccountNumber;

	@Column
	private Long amount;

	@Column
	private String username;

	private String status;

}