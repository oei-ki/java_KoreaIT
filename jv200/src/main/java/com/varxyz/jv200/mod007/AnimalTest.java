package com.varxyz.jv200.mod007;

public class AnimalTest {
	public static void main(String[] args) {
//		Animal animal = new Animal(); //추상클래스라 객체 만들수 없음
		Animal animal = new Dog(); //자식객체 가져온거
		animal.makeSound();
	}

}
