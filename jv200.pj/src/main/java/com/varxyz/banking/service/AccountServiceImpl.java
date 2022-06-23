package com.varxyz.banking.service;

import java.util.*;
import java.util.List;
import com.varxyz.banking.domain.*;

/**
 * @author Administrator
 *
 */
public class AccountServiceImpl implements AccountService{
	private static AccountService service = new AccountServiceImpl(); //객체 생성(싱글톤)이 객체하나로 모든 메소드 처리를 한다?
	private List <Account> accountList = new ArrayList<Account>(); //db역할?을 위해?
	private CustomerService customerService;
	
	private AccountServiceImpl() {  //생성자를 private하면서 다른 객체를 생성하지 못하게 한다.(new x)
		customerService = CustomerServiceImpl.getInstance();
	}
	
	public static AccountService getInstance() {  
		return service;
	}
	
	public Account createSavingsAccount(String acountNum, double balance, double interestRate) {  //SavingsAccount계좌생성
		return new SavingsAccount(acountNum,balance,interestRate);
	}
	
	public Account createCheckingAccount(String acountNum, double balance, double overdraftAmount) { //CheckingAccount계좌생성
		return new CheckingAccount(acountNum,balance,overdraftAmount);
	}
	
	/**
	 * 신규 계좌 등록  계좌정보와 고객정보 전체를 캡슐화
	 */
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	
	/**
	 * 전달된 ssn을 통해 고객을 조회한 후 신규 계좌 등록
	 */
	public void addAccount(Account account,String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}

	public List<Account> getAccountBySsn(String ssn) {  //저장된 계좌가 나와야함
		return null;
	}
	
	public Account getAccountByAccountNum(String accountNum) {  //계좌번호 조회??
		for(Account a : accountList) {
			if(accountNum.equals(a.getAccountNum())) {
				return a;
			}
		}
		return null;
	}
}
