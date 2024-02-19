package com.bank.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionPostDTO {
	
	@JsonProperty(value = "transaction_id")
	private int id;

	@JsonProperty(value = "sender_id")
	private AccountDTO sender;
	
	@JsonProperty(value = "receiver_id")
	private AccountDTO receiver;
	
	@JsonProperty(value = "amount")
	private double amount;
}
