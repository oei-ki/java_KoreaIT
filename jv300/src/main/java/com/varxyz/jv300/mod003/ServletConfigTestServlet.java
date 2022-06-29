package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet{
	private static final String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
	private String[] seasons;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException{
//		String season_list = config.getInitParameter("season_list"); //= =>본인 메소드를 부를는 거/ 여기선 부모꺼를 불러 사용함
//		if(season_list == null) { //getInitParameter 초기파라메터 가져옴 (Wep.xml에서 초기화)
//			season_list = DEFAULT_SEASONS; 
//		}
//		seasons = season_list.split(", ");
//	}
	
	@Override
	public void init() throws ServletException{
		String season_list = getInitParameter("season_list"); //= =>본인 메소드를 부를는 거/ 여기선 부모꺼를 불러 사용함
		if(season_list == null) { //getInitParameter 초기파라메터 가져옴 (Wep.xml에서 초기화)
			season_list = DEFAULT_SEASONS; 
		}
		seasons = season_list.split(", ");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>Servlet Lifecycle Test</h3>");
		out.println("<ul>");
		for(String season : seasons) {
			out.println("<li>"+ season + "</li>");
		}
		out.println("</ul></body></html>");
		out.close();
	}
}