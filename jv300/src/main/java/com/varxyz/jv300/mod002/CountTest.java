package com.varxyz.jv300.mod002;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String pageTitle = "Test";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3> 구구단 </h3>");
		
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				out.println(j + " * " + i + " = " + i * j + "");
				out.println("&nbsp");
//				out.println("\t");
			}
			out.println("<br>");
		}
		
		out.println("</body></html>");
		
		out.close();
	}
}
