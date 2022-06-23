package com.varxyz.banking.mod001;

public class PrimeNumber {

	//소수 판별식
	public void CheckingNum(int num) {
		int count = 0;
		int[] primearr = new int[num/2];
		int checkIndex = 0; //배열의 인덱스 값 저장
		
		try {
			for (int j = 2; j < num; j++) { //소수구하는거임!
				if( num % j == 0) {
					count++;
					primearr[checkIndex] = j; //j=0이 된건 공약수라서 그런거라 공약수 배열에 넣은거
					checkIndex++; //배열추가될 때마다 인덱스도 ++
				}
			}
			if(count == 0) {
				System.out.println("소수입니다.");
			}else {
				throw new Exception(); //소수가 아니면 예외처리하게넣음
			}	
		} catch (Exception e) {
			System.out.println("소수가 아닙니다.😊");
			for(int i = 0; i < checkIndex ;i++) { //배열인덱스만큼 for문 돌림
				int num2 = num / primearr[i]; 
				System.out.println(primearr[i] + "X" + num2);
			}
		}
	}
}
