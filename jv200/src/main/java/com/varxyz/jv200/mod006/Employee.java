package com.varxyz.jv200.mod006;

import java.util.Date;

	//접근제한자 : default(공백) , public , private , protected
public class Employee { // 부모 클래스
	protected String name; //EmployeeTest클래스가 동일 패키지에 있어서 접근 제한자 default 값 가능
	protected double salary;
	public MyDate birthDate;
	
	public String getDetails() {
		return "Name: " + name + "\nSalary: " + salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setBirthDate(MyDate myDate) {
		this.birthDate = myDate;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			if( e.getName().equals(name) && e.getBirthDate().equals(birthDate) ) {
				return true;
			}
		}
		return false;
	}
}
