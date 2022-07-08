package com.varxyz.jv300.mod009;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/findUser.do")
public class findUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 3. 비즈니스 서비스 호출

		UserService userService = UserService.getInstance();
		userService.setUserDao(new UserDao());
		List<User> userList = userService.findUser();
		System.out.println(userList.size());
		request.setAttribute("userList", userList);

		// NextPage
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("find_user.jsp");
		dispatcher.forward(request, response);
	}

}
