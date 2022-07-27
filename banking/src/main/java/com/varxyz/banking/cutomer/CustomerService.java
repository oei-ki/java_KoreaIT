package com.varxyz.banking.cutomer;

import java.util.List;

public interface CustomerService {
	public void addCustomer(Customer customer);
	public Customer getCustomer(String userId);
}
