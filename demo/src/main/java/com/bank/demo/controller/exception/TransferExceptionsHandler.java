package com.bank.demo.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.demo.service.exception.InsufficientBalanceException;

@ControllerAdvice
public class TransferExceptionsHandler {
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleBalanceInsufficient(InsufficientBalanceException ex) {
		ErrorResponse msg = new ErrorResponse();
		msg.setCode(2);
		msg.setMessage("Insufficient funds for the completion of the transaction");
		msg.setDetails("Make sure the required funds are available");

		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

}
