package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	@Autowired
	@Qualifier("sessionCartService") //사용하려는 beans name
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService") //사용하려는 beans name
	private CartService service2;
	
	public CartController() {
		System.out.println("CartController 생성");
	}
	
	public void prosessRequest() {
		service.addItem();
	}
	//@Autowired byType?임 같은 거 두개면 오류남
	
}
