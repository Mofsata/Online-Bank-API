package com.bank.demo.entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Accounts")
public class Account {
	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accId;
	
	@Basic
	@Column(name = "account_type")
	private AccType accType;
	
	@Basic
	@Column(name = "balance")
	private double balance;
	
	@ManyToOne(
			targetEntity = User.class, 
			fetch = FetchType.LAZY, 
			optional = true, 
			cascade = CascadeType.ALL
			)
//	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(
			mappedBy = "sender",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
			)
	private List<Transaction> transmits;
	
	@OneToMany(
			mappedBy = "receiver",
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
			)
	private List<Transaction> receives;
}
