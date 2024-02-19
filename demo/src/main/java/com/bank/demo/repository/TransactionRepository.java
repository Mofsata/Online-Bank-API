package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.demo.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
