package com.myproject.bankingapp.service;

import java.util.List;

import com.myproject.bankingapp.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id );
	AccountDto deposit(Long id, Double amount);
	AccountDto withdraw(Long id, Double amount);
	List<AccountDto> getAllAccounts();
}
