package com.varxyz.jv200.mod003;

public class MyDate {
	// 인스턴스 == 객체 == 오브젝트
	private int day; //인스턴스 변수 
	private int month;
	private int year;
	
	//class 안에는 무조건 하나의 생성자가 있어야한다.
	//생성자를 만들어주지 않아도 보이지않는 default 생성자가 존재한다.
	//전역변수 초기화 시 기본값 0 , 지역변수 초기화 시 기본값 없음.
	//레퍼런스 , 객체 ?
	public MyDate(int day, int month, int year) { //생성자 //int day == parameter
		this.day = day; //this.day == MyDate class 바로 밑의 인스턴스 변수
		this.month = month;
		this.year = year;
	}

	public MyDate(MyDate date) { //생성자
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}

	public String toString() {
		return "day=" + day + ", month=" + month + ", year=" + year;
	}
	
}
