package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class MenuController {
	
	@Autowired
	private MenuItemService service;
	
	public MenuController() {
		System.out.println("컨트롤러 생성자 생성");
	}
	
	public void addMenuItem(String menuName, int price) {
		service.addMenu(menuName, price);
	}
	
	public List<MenuItem> findMenu(){
		return service.findMenu();
	}
	
	public MenuItem searchMenu(String name) {
		return service.searchMenu(name);
	}
	
	
}
