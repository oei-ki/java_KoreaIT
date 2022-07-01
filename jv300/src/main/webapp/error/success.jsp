<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! %><!-- 멤버선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String userName = (String)request.getAttribute("userName"); 
	// List<String> errorMsgs = (List)Object errorMsgs;
	%>
	<%= userName%>님 환영합니다.
</body>
</html>