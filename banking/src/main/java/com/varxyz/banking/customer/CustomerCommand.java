package com.varxyz.banking.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCommand {
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
}
