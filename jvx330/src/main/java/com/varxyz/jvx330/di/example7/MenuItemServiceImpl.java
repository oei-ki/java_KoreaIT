package com.varxyz.jvx330.di.example7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("menuItemService") //name("menuItemService")으로 빈생성?지정?
public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
	private MenuItemDao itemDao; //itemDao받는 생성자를 만든거임
	
	@Override
	public void addMenuItem(MenuItem item) {
		itemDao.save(item);
	}
	@Override
	public List<MenuItem> getAllMenuList() {
		return itemDao.findAllMenuItemList();
	}
	
	@Override
	public MenuItem getMenuItem(String name) {
		return itemDao.findByName(name);
	}
}
