package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  //어노테이션 알아보기
public class RequestMappingController {
	
	@RequestMapping(value="/example2/mapping", method=RequestMethod.GET) //겟방식으로 들어왔을때 이 경로를 불러라
	public String getMapping() { //컨테이너가 불러줘야 함
		return	"example2/mapping_result";
	}
	
	@RequestMapping(value="/example2/mapping", method=RequestMethod.POST) //겟방식으로 들어왔을때 이 경로를 불러라
	public ModelAndView postMapping() { //컨테이너가 불러줘야 함
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result");
		mav.addObject("result","post 요청의 결과 메세지");
		
		return	mav;
	}
}
