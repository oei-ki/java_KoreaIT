package com.varxyz.jvx330.di.example7;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class MenuItem {
	private String name;
	private double price;
	
	
	public MenuItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "메뉴는 : " + name + "\n가격은 : " + price;
	}

}
