package com.varxyz.jv200.mod006;

public class Manager extends Employee { //부모(Employee) 클래스 상속받은 자식 클래스 
	public String department;
	
	//method overriding
	public String getDetails() { //나 자신 -> this. //부모 -> super.
		return super.getDetails() + "\nDepartment : " + department; //오버라이딩
	}
	
}