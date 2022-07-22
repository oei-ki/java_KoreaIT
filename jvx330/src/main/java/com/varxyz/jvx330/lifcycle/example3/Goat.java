package com.varxyz.jvx330.lifcycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifcycle.AppConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat {	
	private static int count;
	//빈을 여러개 만들고 카운트가 1이면 된다고?
	
	public Goat() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		System.out.println("Gost's final count : " + Goat.getCount());
		context.close();
	}
}
