package com.varxyz.jv200.mod003;

public class PassTest {
	public static void changeInt(int value) {
		value = 55;
	}
	
	public static void changeObjectRef(MyDate ref) {
		ref = new MyDate(1, 1, 2000); //객체 생성
		//객체 생성 시, parameter로 값을 받아주려면 생성자를 생성하고
		//parameter를 선언해줘야한다
	}
	
	public static void changeObjectAttr(MyDate ref) {
		//MyDate class 내의 method
		ref.setDay(4);
		ref.setMonth(4);
	}
	
	public static void main(String[] args) { //main class
		MyDate date;
		int val;
		val = 11;
		changeInt(val);
		System.out.println("int value is " + val);
		
		date = new MyDate(22, 7, 1964); //객체 생성
		changeObjectRef(date);
		System.out.println("MyDate is " + date);
		
		changeObjectAttr(date);
		System.out.println("int value is " + date);
	}
}
