package com.varxyz.jv251.dao;

public class DaoTest {

	public static void main(String[] args) {
		CustomerDao cd = new CustomerDao();
		System.out.println(cd.findAllCustomers());
		System.out.println(cd.findCustomerBySsn("901212-1234567"));
		
		
		AccountDao ad = new AccountDao();
		System.out.println(ad.findAllAccountsBySsn("901212-1234567"));

	}

}
