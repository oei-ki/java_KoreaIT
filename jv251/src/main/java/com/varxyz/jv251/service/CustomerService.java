package com.varxyz.jv251.service;

import java.util.*;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Customer;

public class CustomerService { //service를 통해서 뭐를 받는다고? 길?
	
	private CustomerDao customerDao;
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer createCustomer(String name, String ssn, String phone, String userId, String passwd) {
		return new Customer(name, ssn, phone, userId, passwd);
	}
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerDao.findCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustomers() {
		return customerDao.findAllCustomers();
	}
}
