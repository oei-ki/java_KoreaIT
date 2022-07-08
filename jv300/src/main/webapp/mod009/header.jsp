<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="header">
	<h4><%=URLDecoder.decode(request.getParameter("subtitle"), "UTF-8") %></h4>
	<ul>
		<li>
			<a href="/jv300/mod009/findUser.do"/>고객등록현황</a> 
		</li>
	</ul>
	<%-- --%>
</div>