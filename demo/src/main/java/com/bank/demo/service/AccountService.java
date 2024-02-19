package com.bank.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.demo.entity.Account;
import com.bank.demo.entity.User;
import com.bank.demo.repository.AccountsRepository;
import com.bank.demo.repository.UsersRepository;
import com.bank.demo.service.exception.InsufficientBalanceException;
import com.bank.demo.service.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountsRepository accRepo;
	private final UsersRepository userRepo;

	public List<Account> findAll(){
		return accRepo.findAll();
	}
	
	// Get one Account
	public Account findOneAcc(int id) {
		Account acc = accRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return acc;
	}
	
	// Post an Account
	public Account saveAcc(String nid,Account acc) {
		User user = userRepo.findByNationalId(nid).orElseThrow(() -> new ResourceNotFoundException());
		acc.setUser(user);
		return accRepo.save(acc);
	}
	
	// Delete an Account by id
	public Account delAcc(int id) {
		Account acc = accRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		accRepo.delete(acc);
		return acc;
	}
	
	// Post a Deposit
	@Transactional
	public Account depositAcc(int id, long deposit) {
		Account acc = accRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		acc.setBalance(acc.getBalance() + deposit);
		return acc;
	}
	
	// Post a Withdrawal
	@Transactional
	public Account withdrawAcc(int id, long withdraw) {
		Account acc = accRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		if(acc.getBalance() < withdraw)
			throw new InsufficientBalanceException();
		acc.setBalance(acc.getBalance() - withdraw);
		return acc;
	}
}
