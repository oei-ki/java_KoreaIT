package com.varxyz.jv251.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private long cid;
	private String name;
	private String ssn; //주민번호
	private String phone;
	private String userId;  //온라인상을 고려해서 만든 변수..
	private String passwd;
	private List<Account> accountList; 
	
	public Customer() {
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}

	
	
	public Customer(String name, String ssn, String phone) {
		this(name,ssn,phone,null,null);
	}

	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public String toString() { //간결하면서 사람이 읽기 쉬운 형태의 유익한 정보를 반환
		return "고객정보 = " + cid + "," + name + "," + ssn + "," + phone
		+ "," + userId + "," + passwd;
	}  //출력 형태임 따로 사용메소드 안걸어도 됨?
}
