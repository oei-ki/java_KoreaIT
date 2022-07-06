<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tap {margin-left: 20px;}
</style>
</head>
<body> 
<h1>화면이 나오고 있어요</h1>
 	<form action="list_course_contents.do" method="get">
	<c:forEach var="text" items="${contentList}">
	<p>
		<c:forEach var="ms" items="${text}">
			${ms}
		</c:forEach>
		</p>
	</c:forEach>
	<input type="submit">
	</form>
<!-- 	<div>
		<c:forEach var="text" items="${contentList}">
			${text}
		</c:forEach><br>
	</div>-->
</body>
</html>
