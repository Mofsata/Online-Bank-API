package com.bank.demo.controller.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	private int code;
	private String message;
	private String details;
}
