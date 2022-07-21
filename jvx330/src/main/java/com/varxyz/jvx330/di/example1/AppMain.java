package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		Foo foo = context.getBean("foo", Foo.class); //Foo.class 그냥 가져오면 object라서 형변환? 해준거임
		System.out.println(foo);
		
		Foo foo2 = context.getBean("foo2", Foo.class); //Foo.class 그냥 가져오면 object라서 형변환? 해준거임
		System.out.println(foo2); //hash코드가 같은건 동일코드라는 거임, bean으로 동일객체 사용중
		context.close();
		
		
		//기존방식
//		Bar bar = new Bar();
//		Foo foo = new Foo(bar);
		
		
	}

}
