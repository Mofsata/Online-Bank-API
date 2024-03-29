package com.bank.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.demo.entity.Transaction;
import com.bank.demo.repository.TransactionRepository;
import com.bank.demo.service.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {
	private final TransactionRepository repo;

	public List<Transaction> findAll() {
		return repo.findAll();
	}

	public Transaction findById(int id) {
		Transaction trans = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return trans;
	}

}
