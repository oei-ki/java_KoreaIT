package com.varxyz.jv250.banking;

import java.util.List;

public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String customerID;
	private String password;
	private List<Account> accountList;
	
	public Customer() {
		
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return cid + ", " + name + ", " + ssn + ", " + phone;
	}
	
}


// CustomerService : Customer에 대한 서비스를 처리한느 클래스
// 주요 메서드
// getCustomerBySsn 주민번호 고객 조회
// getAllCustomers() 전체 고객 목록
// getNumOfCustomers() 전체 고객수 

//기타
// CustomerService는 고객의 정보를 보관할 수 있는 속성을 유지해야한다.
// 고객의 정보를 유지할 수 있는 속성을 정의하라