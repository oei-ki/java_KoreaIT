package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.DuplicatedEntityException;
import com.varxyz.jv251.exception.EntityNotFoundException;
import com.varxyz.jv251.exception.overdraftException;

public class BankService { //은행의 텔러역할?? 모든기능을 처리하나?
	private static final BankService service = new BankService();
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INTEREST_RATE = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT = 1000.0;
	
	private CustomerService customerService;
	private AccountService accountService;
	
	public BankService() {
		init();
	}
	
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}

	public static BankService getInstance() {
		return service;
	}
	
	public void addCustomer(String name, String ssn, String phone, String userId, String passwd) {
		if(!isCustomer(ssn)) {
			customerService.addCustomer(customerService.createCustomer(name, ssn, phone, userId, passwd));
		}else {			
			throw new DuplicatedEntityException(ssn + " is duplicated");
		}
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	public void addSavingsAccount(double balance, double interesRate, String ssn)throws CustomerNotFoundException{
		SavingsAccount account = new SavingsAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.SA);
		account.setInterestRate(interesRate);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not found");
		}
	}
	
	public void addCheckingAccount(double balance, double overdraftAmount, String ssn)throws CustomerNotFoundException{
		CheckingAccount account = new CheckingAccount();
		account.setAccountNum(accountService.generateAccountNum());
		account.setBalance(balance);
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overdraftAmount);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not found");
		}
	}
	
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	public List<Account> getAccountsBySsn(String ssn) {
		return accountService.getAccountsBySsn(ssn);
	}
	
	public void withdraw(double amount, String accountNum) throws overdraftException {
		// 1. 계좌번호를 통해 계좌번호 금액 가져오기 account.getbalance
		// 2. 계좌번호의 instanceof를 통해 s, c구분
		// 3. accout를 다운캐스팅해서 withdraw메서드 사용
		// 4. 잔액 업데이트 한 것 데이터베이스에 올리기
		// 끝
		Account account = accountService.getaccountCheck(accountNum);
		account.getBalance();
		if(account instanceof SavingsAccount) {
			((SavingsAccount)account).withdraw(amount);
		}else if(account instanceof CheckingAccount) {
			((CheckingAccount)account).withdraw(amount);
		}
		accountService.getupdateAccount(account);
	}
}
