package com.bank.demo.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReceiveDTO {
	@JsonProperty(value = "transaction_id")
	private int id;
	
	@JsonProperty(value = "sender_id")
	private int sender;
	
	@JsonProperty(value = "amount")
	private double amount;
}
