package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface MenuItemService {
	
	public void addMenu(String name, int price);
	
	public List<MenuItem> findMenu();
	
	public MenuItem searchMenu(String name);
}
