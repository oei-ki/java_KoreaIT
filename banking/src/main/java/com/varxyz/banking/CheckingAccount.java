package com.varxyz.banking;

import com.varxyz.banking.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account{
	private double overDraftAmount;
}

