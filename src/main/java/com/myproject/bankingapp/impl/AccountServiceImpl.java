package com.myproject.bankingapp.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.bankingapp.dto.AccountDto;
import com.myproject.bankingapp.entity.Account;
import com.myproject.bankingapp.mapper.AccountMapper;
import com.myproject.bankingapp.repository.AccountRepository;
import com.myproject.bankingapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	//inject dependency
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
//		super();
		this.accountRepository = accountRepository;
	}

	
	
	//add account details
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);//calling a static method from the AccountMapper class that converts AccountDto to Account
		Account savedAccount =accountRepository.save(account);//account object is saved to the database using AccountRepository.save() inbuilt method
		return AccountMapper.mapToAccountDto(savedAccount);//To convert Account entity(savedAccount) to DTO. This pattern ensures data sent back to client is in form of DTO and not exposing the entity class which is a good practice
	}
	
	//get account details by ID
	@Override
	public AccountDto getAccountById(Long id) {
		Account acc = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist")); //check acc exist or not using findById() JPA method that retrieve the data from the database. orElseThrow() return a optional 
		return AccountMapper.mapToAccountDto(acc);
	}


	//Deposit Amount(UPDATE)
	@Override
	public AccountDto deposit(Long id, Double amount) {
		Account acc = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		Double total = acc.getBalance() + amount;
		acc.setBalance(total);
		Account savedAccount=accountRepository.save(acc);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	//Withdraw amount
	@Override
	public AccountDto withdraw(Long id, Double amount) {
		Account acc = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		if(acc.getBalance() < amount) {
			throw new RuntimeException("Insufficient amount");
		}
		else {
			Double bal =acc.getBalance() - amount;
			acc.setBalance(bal);
			Account savedAccount=accountRepository.save(acc);
			return AccountMapper.mapToAccountDto(savedAccount);
		}
	}

	//Get All accounts
	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts=accountRepository.findAll(); //findAll() returns List<Obj> using necessary queries to retrieve the data from the database, usually by generating a SELECT query that fetches all records.
		return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList()) ;
	}

	

	

	
	
}
