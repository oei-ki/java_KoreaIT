package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet2", urlPatterns = {"/mod005/hello.view"})
public class HelloServlet extends HttpServlet{
	private static final String DEFAULT_NAME = "World";

	public void init() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //부모꺼 이미 정의된 메소드
			throws ServletException, IOException { //doGet메소드는 service메소드? 이게 오버라이딩 한것이 JSP
		//get방식으로 이 메소드를 호출할때 실행된다(컨테이너가 실행해줌)
		String pageTitle = "Hello World";
		
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0 ) {
			name = DEFAULT_NAME;
		}
		
		response.setContentType("text/html; charset=UTF-8"); //응답을 html로 보내겠다?
		PrintWriter out = response.getWriter(); //IO(입출력)
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<H3> Welcome to 서블릿 프로그래밍 </h3>");
		out.println("</body></html>");
		out.close(); //IO 종료

	}
}
