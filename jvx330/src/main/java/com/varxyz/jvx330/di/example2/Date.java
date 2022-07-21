package com.varxyz.jvx330.di.example2;


public class Date {
	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	@Override
	public int hashCode() {
		return (day ^ month ^ year);
	}
}
