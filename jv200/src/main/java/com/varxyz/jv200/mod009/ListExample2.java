package com.varxyz.jv200.mod009;

import java.util.ArrayList;
import java.util.List;

public class ListExample2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(); //숫자타입(사용자가 지정하는 형식)
		List<String> list2 = new ArrayList<String>(); //문자타입
		list.add(0,new Integer(42));  
		list.add(5);
		list.add(6);
		list2.add("3rd"); 
		list2.add("first");
		list2.add("second");
		list2.add("666");
		System.out.println(list);
		System.out.println(list2);
		
		
//		for(Integer s : list) {      //  for( String s : list그릇객체?) sop(s)
//			System.out.println(s);   //이걸 더 많이 씀..?
//		}
		
//		for(int i =0; i < list.size(); i++) {
//			Object n1 = list.get(i);
//			System.out.println(n1);
//		}

	}

}
