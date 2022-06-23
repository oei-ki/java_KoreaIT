package com.varxyz.jv200.mod006;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean equals(Object o) {
		if (o instanceof MyDate) {
			MyDate d = (MyDate) o;
			if( d.day == day && d.month == month && d.year == year ) {
				return true;
			}
		}
		return false;
	}
	
//	//위 오버라이딩 한 equals 메소드를 검수하기 위한 메인클래스
//	public static void main(String[] args) {
//		MyDate d1 = new MyDate(1, 1, 2000);
//		MyDate d2 = new MyDate(1, 1, 2000);
//		
//		boolean flag = d1.equals(d2); //불린 값으로 반환
//		System.out.println(flag);
//	}
	
}
