package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

@Controller
public class HelloController {
	
	@RequestMapping("/example1/sayHello")  //view의 요청 경로 지정 / defalt get방식
	public ModelAndView SayHello() {
		String greeting = "Hello! 윤정 스프링 MVC";
		
		//model(화면?보여주는데이터)객체를 이용해, view로 data 전달 (뷰에서 보여질 데이터가 모델임)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello"); //forward랑 같은 역할 (jsp경로임)
		
//		WebMVCConfig클래스에서 만든 메서드
//		public void configureViewResolvers(ViewResolverRegistry registry) {
//			registry.jsp("/WEB-INF/views/", ".jsp");
//		}
//		이걸로 ("example1/hello") 앞 뒤를 다 잘라낸거임
		
		mav.addObject("greeting", greeting);
		
		return mav;
	}	
}
