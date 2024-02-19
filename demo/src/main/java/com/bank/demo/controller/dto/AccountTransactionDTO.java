package com.bank.demo.controller.dto;

import java.util.List;

import com.bank.demo.entity.AccType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountTransactionDTO {
	@JsonProperty(value = "account_id")
	private int accId;
	
	@JsonProperty(value = "account_type")
	private AccType accType;
	
	@JsonProperty(value = "balance")
	private double balance;
	
	@JsonProperty(value = "transmits")
	private List<TransmitDTO> transmits;
	
	@JsonProperty(value = "receives")
	private List<ReceiveDTO> receives;
}
