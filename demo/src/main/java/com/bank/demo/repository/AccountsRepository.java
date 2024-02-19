package com.bank.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Integer>{

}
