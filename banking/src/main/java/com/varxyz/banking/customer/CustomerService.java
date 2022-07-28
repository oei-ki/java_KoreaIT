package com.varxyz.banking.customer;

import java.util.List;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public Customer getCustomer(String userId);
	public Customer getCustomerByAccountNum(String accountNum);
}
