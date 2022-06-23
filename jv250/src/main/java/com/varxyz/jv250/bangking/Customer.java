package com.varxyz.jv250.bangking;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private long cid;
	private String name;
	private String ssn; //주민번호
	private String phone;
	private String passwd;
	private String customerId;
	private List<Account> account; 
	
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
	
	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
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

	public String toString() { //간결하면서 사람이 읽기 쉬운 형태의 유익한 정보를 반환
		return "고객정보 = " + getCid() + "," + getName() + "," + getSsn() + "," + getPhone()
		+ "," + getCustomerId() + "," + getPasswd();
	}  //출력 형태임 따로 사용메소드 안걸어도 됨?
}
