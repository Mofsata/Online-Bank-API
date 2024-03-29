package com.bank.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.demo.controller.dto.AccountDTO;
import com.bank.demo.controller.dto.AccountTransactionDTO;
import com.bank.demo.controller.mapper.UserMapper;
import com.bank.demo.entity.Account;
import com.bank.demo.service.AccountService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accServ;
	private final UserMapper mapper;
	
//	@GetMapping
//	public ResponseEntity<List<AccountDTO>> getAllAccs() {
//		List<Account> accs = accServ.findAll();
//		List<AccountDTO> accsdto = new ArrayList<>();
//		accs.forEach(acc -> {
//			accsdto.add(mapper.toDto(acc));
//		});
//		return new ResponseEntity<>(accsdto, HttpStatus.OK);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAcc(@PathVariable(value = "id") int id) {
		Account acc = accServ.findOneAcc(id);
		AccountDTO accdto = mapper.toDto(acc);
		return new ResponseEntity<>( accdto ,  HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> postAcc(@RequestParam(name = "nid") String nid, @RequestBody AccountDTO accdto) {
		Account acc = mapper.toAccount(accdto);
		accServ.saveAcc(nid , acc);
		return new ResponseEntity<String>("Account Saved Successfully",  HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAcc(@PathVariable(value = "id") int id) {
		accServ.delAcc(id);
		return new ResponseEntity<>( "Account Closed Successfully" ,  HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{id}/deposit")
	public ResponseEntity<String> postDeposit(@PathVariable int id, @RequestParam(name = "d") Long deposit) {
		Account acc= accServ.depositAcc(id, deposit);
		return new ResponseEntity<>("Deposit Successfull, current balance = "+acc.getBalance(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{id}/withdraw")
	public ResponseEntity<String> postWithdrawal(@PathVariable int id, @RequestParam(name = "w") Long withdraw) {
		Account acc = accServ.withdrawAcc(id, withdraw);
		return new ResponseEntity<>("Withdrawal Successfull, current balance = "+acc.getBalance(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}/transactions")
	public ResponseEntity<AccountTransactionDTO> getTransofAcc(@PathVariable int id) {
		Account acc = accServ.findOneAcc(id);
		AccountTransactionDTO accdto = mapper.toAccTransDto(acc);
		
		return new ResponseEntity<>(accdto, HttpStatus.OK);
	}
	
}
