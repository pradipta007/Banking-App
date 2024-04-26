package com.myproject.bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.bankingapp.dto.AccountDto;
import com.myproject.bankingapp.service.AccountService;

@RestController //
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;
	
	@Autowired //after spring v4.3, If your class has only one constructor, Spring assumes that this constructor is to be used for dependency injection, and so it does not require @Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//Add account REST API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){//org.springframework.http.ResponseEntity<T>
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);//org.springframework.http.ResponseEntity.ResponseEntity(T, HttpStatusCode)
	}
	
	//Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto=accountService.getAccountById(id);	
		return ResponseEntity.ok(accountDto);
	}
	
	//Deposit Amount(Update)
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){//using map to accept JSON data from request body as  Map<..> can be used to represent a JSON object
		Double amount = request.get("amount"); // Map() has a get() method that returns value against the key given, here "amount" is the key that it takes from body
		AccountDto accountDto=accountService.deposit(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//Withdraw Amount
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDto accountDto= accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDto);
	}
	
	//get all accounts
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accountDto = accountService.getAllAccounts();
		return ResponseEntity.ok(accountDto);
	}
}
