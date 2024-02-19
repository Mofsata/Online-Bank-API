package com.bank.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.demo.entity.User;



@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
	Optional<User> findByNationalId(String nationalId);
	Optional<User> findByPhone(long phone);
}
