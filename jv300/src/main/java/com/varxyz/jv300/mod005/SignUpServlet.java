package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormBasedHelloServlet
 */
@WebServlet("/mod005/user.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_ID = "testId";
	private static final String DEFAULT_PASSWD = "testPasswd";
	private static final String DEFAULT_NAME = "testName";
	private static final String DEFAULT_SSN = "testSsn";
	private static final String DEFAULT_EMAIL = "testEmail";
	private static final String DEFAULT_EMAIL2 = "testEmail2";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String id = request.getParameter("userId");
//		if (id == null || id.length() == 0) {
//			id = DEFAULT_ID;
//		}
//		
//		String pw = request.getParameter("passwd");
//		if (pw == null || pw.length() == 0) {
//			pw = DEFAULT_PASSWD;
//		}
//		
//		String name = request.getParameter("userName");
//		if (name == null || name.length() == 0) {
//			name = DEFAULT_NAME;
//		}
//		
//		String ssn = request.getParameter("ssn");
//		if (ssn == null || ssn.length() == 0) {
//			ssn = DEFAULT_SSN;
//		}
//		
//		String email = request.getParameter("email");
//		if (email == null || email.length() == 0) {
//			email = DEFAULT_EMAIL;
//		}
//		
//		String email2 = request.getParameter("email2");
//		if (email2 == null || email2.length() == 0) {
//			email2 = DEFAULT_EMAIL2;
//		}
//		
//		String[] concerns = request.getParameterValues("concerns");
//		
//		String pageTitle = "SignUp";
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head><title>" + pageTitle  + "</title></head>");
//		out.println("<body>");
//		out.println("<h3> 회원정보 확인 </h3>");
//		out.println("<ul>");
//		out.println("<li> 회원아이디 = " + id + "</li>");
//		out.println("<li> 비밀번호 = " + pw + "</li>");
//		out.println("<li> 이름 = " + name + "</li>");
//		out.println("<li> 주민번호(앞자리) = " + ssn + "</li>");
//		out.println("<li> 이메일(아이디) = " + email + "</li>");
//		out.println("<li> 이메일 = " + email2 + "</li>");
//		out.println("<li> 관심분야 = ");
//		for (String concern : concerns) {
//			out.println(concern + " </li>");
//		}
//		
//		out.println("</ul>");
//		out.println("</body></html>");
//		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		if (id == null || id.length() == 0) {
			id = DEFAULT_ID;
		}
		
		String pw = request.getParameter("passwd");
		if (pw == null || pw.length() == 0) {
			pw = DEFAULT_PASSWD;
		}
		
		String name = request.getParameter("userName");
		if (name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		String ssn = request.getParameter("ssn");
		if (ssn == null || ssn.length() == 0) {
			ssn = DEFAULT_SSN;
		}
		
		String email = request.getParameter("email");
		if (email == null || email.length() == 0) {
			email = DEFAULT_EMAIL;
		}
		
		String email2 = request.getParameter("email2");
		if (email2 == null || email2.length() == 0) {
			email2 = DEFAULT_EMAIL2;
		}
		
		String[] concerns = request.getParameterValues("concerns");
		
		String pageTitle = "SignUp";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle  + "</title></head>");
		out.println("<body>");
		out.println("<h3> 회원정보 확인 </h3>");
		out.println("<ul>");
		out.println("<li> 회원아이디 = " + id + "</li>");
		out.println("<li> 비밀번호 = " + pw + "</li>");
		out.println("<li> 이름 = " + name + "</li>");
		out.println("<li> 주민번호(앞자리) = " + ssn + "</li>");
		out.println("<li> 이메일(아이디) = " + email + "</li>");
		out.println("<li> 이메일 = " + email2 + "</li>");
		out.println("<li> 관심분야 = ");
		for (String concern : concerns) {
			out.println(concern + " </li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}

}
