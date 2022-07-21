package com.varxyz.jvx330.di.example3;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {

	public static void main(String[] args) {
//		String config = "com/varxyz/jvx330/di/example3/beans.xml";
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService service = context.getBean("memberService",MemberService.class); //class로 형변환한거
		service.getAllMembers().forEach(member -> System.out.println(member));
		
//		List<Member> list = service.getAllMembers();
//		for(Member member : list) {
//			System.out.println(member);
//		}

		context.close();
	}

}
