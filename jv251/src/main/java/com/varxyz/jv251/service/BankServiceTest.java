package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.overdraftException;

public class BankServiceTest {

	public static void main(String[] args) {
		BankService service = BankService.getInstance();
		String name = "동탁";
		String ssn = "880123-1234567";
		String phone = "010-4434-3232";
		String userId = "framework";
		String passwd = "1111";
		//1.신규 고객 등록
//		service.addCustomer(name,ssn, phone, userId, passwd);
//		service.addCustomer(name, ssn, phone, userId, passwd);
//		try {
//			//2.SavingsAccount 생성
//			service.addSavingsAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}
		//3. 고객 등록 확인
//		Customer customer = service.getCustomerBySsn(ssn);
//		System.out.println(customer);
		//4.고객 계좌 목록 확인
		List<Account> myList = service.getAccountsBySsn(ssn);
		for(Account account : myList ) {
			System.out.println(account);			
		}
		try {
			service.withdraw(1000,"116-86-935");
		} catch (overdraftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
