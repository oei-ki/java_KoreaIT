package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

public class MenuItemDao implements MenuItemService{
	List<MenuItem> menuList = new ArrayList();
	
	@Override
	public void addMenu(String name, int price) {
		menuList.add(new MenuItem(name, price));
		System.out.println("new MenuItem name: " + name + "/ price : " + price);
	}
	@Override
	public List<MenuItem> findMenu() {
		return menuList;
	}
	@Override
	public MenuItem searchMenu(String name) {	
		for(MenuItem m : menuList) {
			if(m.getName().equals(name)){
				return m;
			}
		}
		return null;
	}

}
