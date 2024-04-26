//Account Entity class
package com.myproject.bankingapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //(no argument constructor is required by Hibernate and JPA for creating instances of the entity)
@AllArgsConstructor

@Entity
@Table(name="accounts")	
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "account_holder_name")
	private String accountHolderName;
	private double balance;
}
