package com.varxyz.jv200.mod003;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
				if ( j == 9 ) {
					System.out.println();
				}
			}
		}
	}

}
