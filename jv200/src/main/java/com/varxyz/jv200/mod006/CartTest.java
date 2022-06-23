package com.varxyz.jv200.mod006;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("ThinkPad"));
		cart.addProduct(new SmartPhone("Samsung Galuxy"));
		cart.addProduct(new SmartPhone("Apple Iphone"));
		System.out.println(cart.getProducts().length + "개");
		System.out.println(cart.getDetails());
	}
}
