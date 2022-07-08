package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mod010/mypage") //로그인한후
public class MyPageSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
	
	public void init() {
		userService = new UserService(new UserDao());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId");
		if(userId == null) { //로그인 안하고 들어온 거
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			
			if(cookie.getName().equals("lastAccessTime")) {
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
		response.addCookie(lastAccessTime());
		
		
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}
	
	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date()); //쿠키는 문자로만 가능
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "UTF-8")); //시간에 특수문자 : encode 사용
		} catch (Exception e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(60 * 60* 24 * 30);
		cookie.setPath("/");  //쿠기를 어떻게 심거나 가져올지? /를 하게 되면 위로는 하지않겠따??모르겠음
		return cookie;
	}


}
