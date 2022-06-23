package com.varxyz.jv200.mod006;

import java.util.Date;

public class EmployeeTest { //Employee 클래스를 테스트 하기 위한 메인클래스

	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "유비"; //Employee클래스가 현재클래스와 동일 패키지에 있어서 default(접근제한자) 값가능
		e.salary = 5000.0;
//		e.birthDate = new Date(); //Emplyee 클래스에 birthDate 변수의 접근제한자가 private라 에러
		String detail = e.getDetails();
		System.out.println(detail);
		
		Manager m = new Manager();
		m.department = "영업부";
		m.name = "관우";
		m.salary = 2000.0;
		System.out.println(m.getDetails());
	}

}

