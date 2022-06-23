package com.varxyz.jv200.mod004;

public class Emoticon {
	public static void main(String[] args) {
		int num = (int) Math.round(Math.random()*1566);
		String[] array = new String[1566];
		
		for (int i = 0; i < 700; i++) {
			array[i] = "동그라미";
		}
		for (int i = 700; i < 1200; i++) {
			array[i] = "삼각형";
		}
		for (int i = 1200; i < 1500; i++) {
			array[i] = "사각형";
		}
		for (int i = 1500; i < 1550; i++) {
			array[i] = "오각형";
		}
		for (int i = 1550; i < 1560; i++) { 
			array[i] = "육각형";
		}
		for (int i = 1560; i < 1565; i++) {
			array[i] = "팔각형";
		}
		for (int i = 1565; i < 1566; i++) {
			array[i] = "별";
		}
		System.out.println(num);
		System.out.println(array[num]); //null 이 왜 튀어나오냐 -> 초기값
	}
}
