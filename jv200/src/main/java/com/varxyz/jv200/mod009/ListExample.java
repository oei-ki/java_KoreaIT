package com.varxyz.jv200.mod009;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
//collection List ArrayList
	//순서가 있고 중복 허용함
		public static void main(String[] args) {
			List list = new ArrayList();
			list.add("one");
			list.add("second");
			list.add("3rd");
			list.add(new Integer(4)); 
			list.add(new Float(5.0F));
			list.add("second");
			list.add(new Integer(4));
			System.out.println(list);
		}
	}
