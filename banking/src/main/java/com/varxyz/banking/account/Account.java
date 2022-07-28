package com.varxyz.banking.account;

import java.util.Date;

import com.varxyz.banking.customer.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long aid;
	private Customer customer;
	private String accountNum;
	private char accType;
	private double balance;
	private Date regDate;
	
	public Account() {
		
	}
	
}
