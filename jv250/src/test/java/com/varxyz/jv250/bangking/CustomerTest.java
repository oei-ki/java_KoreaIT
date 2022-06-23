package com.varxyz.jv250.bangking;

import java.util.List;

public class CustomerTest {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		//findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for(Customer customer : customerList) {
			System.out.println(customer);
		}
		System.out.println("------------------------------------");
	
		//find
		Customer customer = dao.findCustomerBySsn("901212-1234567");
		System.out.println(customer);
		System.out.println("------------------------------------");
		
		Customer c = new Customer();
		c.setName("공명");
		c.setSsn("970824-1234567");
		c.setPhone("010-5656-5656");
		c.setCustomerId("spring");
		c.setPasswd("1111");
		
		dao.addCustomer(c);
	}

}
