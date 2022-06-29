package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //부모꺼 이미 정의된 메소드
			throws ServletException, IOException {
		//get방식으로 이 메소드를 호출할때 실행된다(컨테이너가 실행해줌)
		String pageTitle = "Hello World";
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
