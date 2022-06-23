package com.varxyz.banking.mod001;

public class primeNumber3 {

	//소수 판별식
	public void CheckingNum(int num) {
		int count = 0;
		int[] primearr = new int[num];
		int checkIndex = 0; //배열의 인덱스 값 저장
		
		try {
			for (int j = 2; j < num; j++) { //소수구하는거임!
				if( num % j == 0) {
					count++;
					if(( j %  ) != 0) {
						primearr[checkIndex] = j;
						checkIndex++;
					}
				}
				if(count == 0) {
					System.out.println("소수입니다.");
				}else {
					throw new Exception(); //소수가 아니면 예외처리하게넣음	
				}
			}
		}catch (Exception e) {
			System.out.println("소수가 아닙니다.😊");
			for(int i = 0; i < checkIndex ;i++) { //배열인덱스만큼 for문 돌림
				System.out.println(primearr[i]);
			}
		}
	}
}