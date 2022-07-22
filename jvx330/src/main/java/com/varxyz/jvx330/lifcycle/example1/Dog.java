package com.varxyz.jvx330.lifcycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifcycle.AppConfig;
import com.varxyz.jvx330.lifcycle.example2.Eagle;


public class Dog implements InitializingBean, DisposableBean{
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name : " + dog.getName());
		context.close();
		

	}


	@Override
	public void destroy() throws Exception {  //이거무슨말인지 모르겠음.
		System.out.println("destroy 호출");	
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet 호출");
		if(name == null) {
			System.out.println("Property nama must be set");
			
		}else {
			System.out.println(name);
		}
	}
}
