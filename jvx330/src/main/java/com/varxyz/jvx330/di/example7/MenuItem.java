package com.varxyz.jvx330.di.example7;



public class MenuItem {
	private String name;
	private double price;
	
	
	public MenuItem(String name, double price) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "메뉴는 : " + name + "\n가격은 : " + price;
	}

}
