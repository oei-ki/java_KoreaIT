package com.varxyz.jvx330.lifcycle.example3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifcycle.AppConfig;

public class Horse implements InitializingBean, DisposableBean{
	private static int count;
	private String name;
	//빈을 여러개 만들고 카운트가 1이면 된다고?
	
	
	/*1. InitializingBean, DisposableBean 인터페이스를 이용해서 초기화하는 방법
    * 
    * 2. 빈생성 클래스에서 초기화하는방법
    * 
    * 3. 클래스내에서 처리하는 방법
    *       @PostConstruct 붙여서 초기화
    *          public void initMenuData() {}
	*/
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("horse's final count : " + Horse.getCount());
		context.close();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy 호출");	
		
	}

	@Override
	public void afterPropertiesSet() throws Exception { //콜백메소드? 디비....
		System.out.println("afterPropertiesSet 호출");
		if(name == null) {
			System.out.println("Property nama must be set");
			
		}else {
			System.out.println(name);
		}
		
	}

}
