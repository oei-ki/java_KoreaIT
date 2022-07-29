package com.varxyz.banking.test;

public class TransferAccountTest {
	public static void main(String[] args) {
		
		
		TransferAccount test = new TransferAccount();
		deposit();
		withdraw();
		test.transfer(2000.0,"내계좌","이체계좌");
	}
	
}
