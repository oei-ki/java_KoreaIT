package com.varxyz.banking;

import com.varxyz.banking.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account{
	private double interestRate;
	
	public void withdraw(double amount) {
		
	}
}