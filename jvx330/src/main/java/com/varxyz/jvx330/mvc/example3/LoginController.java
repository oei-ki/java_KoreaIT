package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController")  //위치한곳 명시해준거인듯?
public class LoginController {

	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
	//@PostMapping("/example3/login")
	public ModelAndView login(HttpServlet request) {
		String userId = request.getInitParameter("userId");
		String passwd = request.getInitParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/result");
		
		return mav;
	}
	
//	//@PostMapping("/example3/login")
//	public ModelAndView login(HttpServlet request,ModelAndView mav) {
//		String userId = request.getInitParameter("userId");
//		String passwd = request.getInitParameter("passwd");
//		
//		mav.addObject("userId", userId);
//		mav.addObject("passwd", passwd);
//		mav.setViewName("example3/result");
//		
//		return mav;
//	}
	
	@PostMapping("/example3/login")
	public ModelAndView login(@RequestParam(value="userId", required = true)String id,
								@RequestParam String passwd) { //required true 값 안들어오면 오류남
		//(@RequestParam(value="userId", @RequestParam String passwd)
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/result");
		
		return mav;
	}//폼 파라메터임~
}
