package com.varxyz.banking.domain;

import java.util.*;

/**
 * CustomerService는 고객의 정보를 보관할 수 있는 속성을 유지해야한다.
 * @author Administrator
 *
 */
public interface CustomerService{ //똑같은 일을 하기때문에 객체에 따른 수가 필요없이 하나로 이뤄진다??
	void addCustomer(Customer customer);//신규 고객추가
	Customer getCustomerBySsn(String ssn); //주민번호고객 조회
	Collection<Customer> getAllCustomers(); //전체 고객목록
	int getNumOfCustomers(); //전체 고객 수

}
