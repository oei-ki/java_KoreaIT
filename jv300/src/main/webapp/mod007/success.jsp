<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
	label {display: block;}
	</style>
	
	<div id="wrapper">
		<div id="header">
			<jsp:include page="/incl/banner.jsp">
				<!--<jsp:param name="subtitle" value="mod007 : Java Bean and include"/>-->
				<jsp:param name="subtitle" value="<%=URLEncoder.encode(\"mod007 : 자바빈즈:\", \"UTF-8\") %>"/>
			</jsp:include> <!-- 동적인거 -->
		</div>
		<div id="content-wrapper"> <!-- 레이아웃 -->
			<h3>회원가입되었습니다.</h3>
			<jsp:useBean id="user" class="com.varxyz.jv300.mod007.User" scope="request"/>
			아이디 : <jsp:getProperty property="userId" name="user"/><br>
			이름 : <jsp:getProperty property="userName" name="user"/>
		</div>
		<div id="footer">
			<%@ include file="/incl/footer.jsp" %> <!-- 정적인거 -->
		</div>
	</div>
	
</body>
</html>