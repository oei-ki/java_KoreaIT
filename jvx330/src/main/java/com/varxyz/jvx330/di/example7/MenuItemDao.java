package com.varxyz.jvx330.di.example7;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component("menuItemDao") //빈 자동생성 
public class MenuItemDao {
	private static final List<MenuItem> MENU = new ArrayList<MenuItem>();
	
	public void save(MenuItem item) {
		if(!MENU.contains(item)) {
			MENU.add(item);
		}
	}
	
	public List<MenuItem> findAllMenuItemList() {
		return MENU;
	}
	
	public MenuItem findByName(String name) {
		for(MenuItem item : MENU) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		throw new RuntimeException(name + "menu dose not exist");
	}
}
