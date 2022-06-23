package com.varxyz.jv200.mod008;

public class Try_Catch {
	public static void main(String[] args) {
		try {
			int sum = 0;
			for( String arg : args) { //문자값을 받았을때
				sum += Integer.parseInt(arg); //Integer.parseInt == string int로 바꾸는 코드
			}//숫자와 문자값을숫자로 변환한 값을 더한다
			System.out.println("Sum = " + sum);
		} catch(NumberFormatException nfe) {
			System.err.println("One of the command-line" + "arguments is not an integer."); //err로 입력하면 빨간색으로 뜸!
		}
	}
}
