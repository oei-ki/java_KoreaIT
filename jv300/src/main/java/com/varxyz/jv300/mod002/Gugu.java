package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugu extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) //부모꺼 이미 정의된 메소드
			throws ServletException, IOException {
		//get방식으로 이 메소드를 호출할때 실행된다(컨테이너가 실행해줌)
		String pageTitle = "Hello gugudan";
		response.setContentType("text/html; charset=UTF-8"); //응답을 html로 보내겠다?
		PrintWriter out = response.getWriter(); //IO(입출력)
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<style>"
				+ "table{border-collapse: collapse;}"
				+ "td{border:1px solid black;}"
				+ "</style>");
		out.println("<table><tr>");
			for(int i = 1; i < 10; i++) {
				for (int j = 2; j < 10 ;j++) {
					out.println("<td>"+j+"*"+i+"="+i*j+"</td>");
					if ( j == 9 ) {
						out.println("<tr></tr>");
					}
				}
			}
		out.println("</tr></table></body></html>");
		out.close(); //IO 종료

	}
}
