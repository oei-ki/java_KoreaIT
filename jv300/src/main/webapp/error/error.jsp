<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<String> errorMsgs = (List)request.getAttribute("errorMsgs"); 
	// List<String> errorMsgs = (List)Object errorMsgs;
	%>
	<%= errorMsgs%>
</body>
</html>