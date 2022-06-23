package com.varxyz.banking.domain;

import java.util.*;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerService service = new CustomerServiceImpl(); //객체 생성(싱글톤)이 객체하나로 모든 메소드 처리를 한다?
	private Map<String, Customer> map = new HashMap<>();

	CustomerServiceImpl() {
		super(); //안 적어도 생략되어 있음.
	}
	
	public static CustomerService getInstance() {
-		return service;
	}
	
	public void addCustomer(Customer customer) {
		if(!map.containsKey(customer.getSsn())) {  //containsKey-맵에서 인자로 보낸 키가 있으면 true 없으면 false를 반환
			map.put(customer.getSsn(), customer);
		} //map리스트에 customer에 받은 주민번호가 없으면 리스트에 키값과 value값을 넣어라.
	}

	public Customer getCustomerBySsn(String ssn) { //위에서 입력된 키값으로 값조회
		if(map.containsKey(ssn)) {			
			return map.get(ssn);	
		}
		return null;
	}
	
	public Collection<Customer> getAllCustomers() { //모든고객
		return map.values();
	}
	

	public int getNumOfCustomers() {//고객 수
		return map.size(); //컬렉션프레임워크 타입의 길이
	}
	
	
	
	
}
