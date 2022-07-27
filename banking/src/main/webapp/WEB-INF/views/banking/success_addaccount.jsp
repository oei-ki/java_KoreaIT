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
		<label>아이디 : </label>${view.customerId }<br>
		<label>계좌번호 : </label>${view.accountNum }<br>
		<label>계좌종류 : </label>${view.accType }<br>
		<label>잔액 : </label>${view.balance }<br>
		<label>이자율 : </label>${view.interestRate }<br>
	</c:forEach>
</body>
</html>