package com.varxyz.banking;

import java.util.Date;

import com.varxyz.banking.cutomer.Customer;

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
	
}
