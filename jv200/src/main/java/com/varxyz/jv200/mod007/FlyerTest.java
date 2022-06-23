package com.varxyz.jv200.mod007;

public class FlyerTest {

	public static void main(String[] args) {
		Flyer f = new AirPlane(); //
//		Flyer f = getFlyer();  변화에 덜 민감한 코드 --새로생기는 Flyer의 종류에 따라 바꾸기 쉽다. Flyer가 정해져있지 않은 상태의 코드
		f.takeOff();
		

	}

}
