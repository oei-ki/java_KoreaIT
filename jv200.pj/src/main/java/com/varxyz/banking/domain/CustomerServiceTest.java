package com.varxyz.banking.domain;


public class CustomerServiceTest {

	public static void main(String[] args) {
//		CustomerService customerService();
//		customerService.addCustomer(null);
		
		CustomerService customer = new CustomerServiceImpl(); //업캐스팅 자식클래스에서 부모클래스로 형변환
		customer.addCustomer(new Customer("홍길동","1234-5647","010-1111-2222","abcd","abcd123"));
		customer.addCustomer(new Customer("김길동","4567-5647","010-2222-3333","abcd","abcd123"));
		
		customer.getCustomerBySsn("1234-5647");
		System.out.println(customer.getNumOfCustomers());
		System.out.println(customer.getCustomerBySsn("1234-5647"));
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
