package com.myproject.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> //
{
	
}
