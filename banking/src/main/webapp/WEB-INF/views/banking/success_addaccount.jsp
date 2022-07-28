<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
</head>
<body>
	<h1>계좌 확인</h1> 
	<c:forEach var="view" items="${accountList}">
		<li>계좌번호 : ${view.accountNum }</li>	
		<li>계좌종류 : ${view.accType }</li>	
		<li>잔액 : ${view.balance }</li>	
	-------------------------------------------------------<br>
	</c:forEach>
</body>
</html>