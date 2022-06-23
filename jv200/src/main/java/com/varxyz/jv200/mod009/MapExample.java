package com.varxyz.jv200.mod009;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();  //key값 value값
		map.put(Integer.valueOf(1), "유비");
		map.put(2, "관우"); //기본형타입 버전5이상부터 자동으로 바꿔줌 박싱과 언박싱을 자동으로 해줌(오토박스?) 문법적으론 틀린거임
		map.put(new Integer(3), "장비"); //자바 9이상부터는 이 형식으로 쓰지말라고 권고함.deprecated
		
		System.out.println(map.get(1)); //키값으로 값을 불러옴
		System.out.println(map.get(new Integer(2)));
		System.out.println(map.get(new Integer(3)));
		
		Set<Integer> set = map.keySet();
		for(Integer integer : set) {  //타입과 명 : 담을객체
			System.out.print(integer); //키값만 나옴
			System.out.println("=" + map.get(integer));
		}
		
	}
}
