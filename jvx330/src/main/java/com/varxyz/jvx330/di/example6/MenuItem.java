package com.varxyz.jvx330.di.example6;

public class MenuItem {
	public String name;
	public int price;
	
	public MenuItem(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "메뉴는 : " + name + "\n가격은 : " + price;
	}
	
}
