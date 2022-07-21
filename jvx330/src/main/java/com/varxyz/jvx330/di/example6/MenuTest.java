package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MenuTest {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuController controller = context.getBean("menuController", MenuController.class);
		controller.addMenuItem("아메리카노", 1500);
		controller.addMenuItem("카페라떼", 3500);
		controller.addMenuItem("콜드브루", 5500);
		
		controller.findMenu().forEach(menu -> System.out.println(menu.toString()));
		
		System.out.println(controller.searchMenu("카페라떼").toString());
		
		context.close();
		
	}

}
