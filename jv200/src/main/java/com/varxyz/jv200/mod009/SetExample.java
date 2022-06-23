package com.varxyz.jv200.mod009;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4)); //equals메서드가 같도록 오버라이딩 되어 있다?
		set.add(new Float(5.0F));
		set.add("second");
		set.add(new Integer(4));
		System.out.println(set);
		//set은 순서를 유지하지 않는 인터페이스
	}
}
