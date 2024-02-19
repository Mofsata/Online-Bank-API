package com.bank.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TransactionGetDTO {
	@JsonProperty(value = "sender_id")
	private int sender;
	
	@JsonProperty(value = "receiver_id")
	private int receiver;
	
	@JsonProperty(value = "amount")
	private double amount;
}
