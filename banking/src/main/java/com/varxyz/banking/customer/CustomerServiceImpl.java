package com.varxyz.banking.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public boolean isUser(String userId, String passwd) {
		return customerDao.isUser(userId, passwd);
	}
	

	@Override
	public Customer getCustomer(String userId) {
		return customerDao.getCustomer(userId);
	}

	@Override
	public Customer getCustomerByAccountNum(String accountNum) {
		return customerDao.getCustomerByAccountNum(accountNum);
	}
}



