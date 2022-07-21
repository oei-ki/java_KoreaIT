package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml"; //Spring container?를 얻기 위해 GenericXmlApplicationContext 사용함.
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Hello hello = context.getBean("helloBean", Hello.class); //캐스팅해도 되고~ close 전까진 get빈계속 사용 가능
		
//		Hello hello = new HelloBeanKo();
		System.out.println(hello.sayHello("Spring")); //beans.xml 내용임~~
		context.close(); 
	}

}
 