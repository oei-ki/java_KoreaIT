package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MollaController {
	
	@RequestMapping("/example2/saymolla")
	public ModelAndView sayMolla() {
		String text2 = "몰라 일단 연습중";
		String text3 = "집에 가고싶음";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/molla");
		mav.addObject("text2",text2);
		mav.addObject("text3",text3);
		
		return mav;
	}

}
