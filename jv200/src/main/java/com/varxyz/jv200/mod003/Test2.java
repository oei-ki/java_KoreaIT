package com.varxyz.jv200.mod003;

public class Test2 {

	public static void main(String[] args) {
		int count = 0;
		int num = 0;
		
		for (int i = 2; i < 1000; i++) {
			for (int j = 2; j < i+1; j++) {
				if( i % j ==   0) {
					count++;
				}
			}
			
			if(count == 1) {
				System.out.println(i + " ");
				num++;
			}
			count = 0;
		}
		System.out.println("개수 : " + num + "개");

	}

}
