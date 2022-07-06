<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="header">
	<h4><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8") %></h4>
	<ul>
		<li>
			<a href="http://http://localhost:8080/jv300/mod009/add_user.do">고객등록현황</a>>
		</li>
	</ul>>
	<%-- --%>
</div>