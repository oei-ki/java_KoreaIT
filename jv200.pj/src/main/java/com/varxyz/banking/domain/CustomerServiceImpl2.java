package com.varxyz.banking.domain;

import java.util.*;

public class CustomerServiceImpl2 implements CustomerService{
	private List<Customer> customerList = new ArrayList();

	public void addCustomer(Customer customer) {
		if(getCustomerBySsn(customer.getSsn()) == null) {
			customerList.add(customer);
		}
	}

	public Customer getCustomerBySsn(String ssn) { //주민번호 조회
		for(Customer c : customerList) {
			if(ssn.equals(c.getSsn())) {
				return c;
			}
		}
		return null;
	}
	
	public Collection<Customer> getAllCustomers() { //모든고객수
		return customerList;
	}

	public int getNumOfCustomers() { //고객수
		return customerList.size();
	}
	
	
	
}
