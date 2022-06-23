package com.varxyz.banking.mod001;

public class primeNumber2 {
	public String primeNumber2(int n) {
		String answar = ""; //소수아닐때 마지막 리턴
		int result = 0; //소수 
		int exInt = 0; //소수 아닌 값
		boolean check = true;
		
		for(int i = 2; i < n ;i++) { //소수 식
			if( n % i == 0 ) {
				check = false; //
				exInt = i; //소수 아닌거 담았음
				break; //최소 공약수를 담은듯??
			}
		}
		if() {
			
		}else {
			primeException e = new primeException();
			throws e;
		}
		
	}

}
