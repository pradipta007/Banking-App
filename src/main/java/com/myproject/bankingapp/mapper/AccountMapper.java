// This class is responsible for converting dto into jpa entity and vice versa(AccountDto(DTO class) <-> Account(entity class))
//
package com.myproject.bankingapp.mapper;

import com.myproject.bankingapp.dto.AccountDto;
import com.myproject.bankingapp.entity.Account;


	public class AccountMapper {
		public static Account mapToAccount(AccountDto accountDto) {
			Account account = new Account(
					accountDto.getId(),
					accountDto.getAccountHolderName(),
					accountDto.getBalance()
					
			);
			
			return account;		
		}
		
		//Account JPA entity into Account DTO 
		public static AccountDto mapToAccountDto(Account account) {
			AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
			return accountDto;
		}
		
		
	}
