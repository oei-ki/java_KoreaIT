package com.varxyz.jvx330.di.example4.ex2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.intro.Hello;

public class ByNameClient {
	private NamingService service;
	
	//jmsNamingService 프로퍼티
	public NamingService getNamingService() {
		return service;
	}
	
	
	public void setJmsNamingService(NamingService namingService) {
		this.service = namingService;
	}
	
	public void service(String name) {
		Object o = service.lookup(name);
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex2/beans.xml"; 
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		ByTypeClient client = context.getBean("byTypeClient", ByTypeClient.class);
		client.service("myQueue");
		context.close();
	}
	//set get이 프로퍼티임
}
