package com.varxyz.banking.test;

import java.util.List;

import com.varxyz.banking.account.Account;
import com.varxyz.banking.customer.Customer;

public interface BankService {
	
	/**
	 * 고객 가입
	 * @param customer
	 */
	boolean addCustomer(Customer customer);

	/**
	 * 신규 계좌 생성
	 * @param account
	 */
	boolean addAccount(Account account);
	List<Account> getAccounts(String userId);
	boolean transfer(double money, String withdrawAccountNum, String depositAccountNum);
	boolean saveInterest(String accountNum, double interestRate);
	boolean getBalance(String accountNum);

}
