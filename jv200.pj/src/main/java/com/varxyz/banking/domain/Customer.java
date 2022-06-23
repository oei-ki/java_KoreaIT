package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private String ssn; //주민번호
	private String phone;
	private String customerId;
	private String passwd;
	private List<Account> AccountList; //보유계좌
	
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
	}


	public List<Account> getAccountList() {
		return AccountList;
	}


	public void setAccountList(List<Account> accountList) {
		AccountList = accountList;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
