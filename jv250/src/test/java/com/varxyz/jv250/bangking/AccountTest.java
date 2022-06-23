package com.varxyz.jv250.bangking;

import java.util.*;

public class AccountTest {

	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNum("301-11-2548");
		sa.setBalance(200.0);
		sa.setCustomer(new Customer(1002));
		sa.setInterestRate(1.2);
		sa.setRegDate(new Date());
		sa.setAccountType('S');
		dao.addAccount(sa);
		
		for(Account account : dao.findAllAccountsBySsn("901212-1234567")) {			
			System.out.println(account);
		}
	}
}
