package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/add_user")
public class AddUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String ssn = request.getParameter("ssn"); //6자리
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns =request.getParameterValues("concerns");
		
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		String pageTitle = "Hello World";
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter(); //IO(입출력)
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("  <style>"
				+ "    label {display: block;}"
				+ "    </style>");
		out.println("<H3> 회원가입을 축하합니다. " + name + "님</h3>");
		out.println(" <label for='userId'>회원 아이디 : </label>" + userId);
		out.println(" <label for='userId'>비밀번호 : </label>" + passwd);
		out.println(" <label for='userId'>주민번호 : </label>" + ssn);
		out.println(" <label for='userId'>이메일 : </label>" + email1);
		out.println(" <label for='concerns'>관심분야 : </label>");
		for(String concern : concerns) {
			out.println(concern + "&nbsp;");
		}
		out.println("</body></html>");
		out.close(); //IO 종료
	}
}
