package com.myproject.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


 //Lombok annotation for generating constructor and getter setter,toString et
@Data
@AllArgsConstructor // @Data does not generate all-args cons by default so explicitly we had to include
public class AccountDto {
	private Long id;
	private String accountHolderName;
	private double balance;
	
}
