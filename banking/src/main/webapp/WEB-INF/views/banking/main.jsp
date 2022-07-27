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
	<h3>${customer.name }님 로그인 환영!</h3><br>
	<form action="login" method="post">
		<label>cid : </label>${customer.cid }<br>
		<label>아이디 : </label>${customer.userId }<br>
		<label>비밀번호 : </label>${customer.passwd }<br>
		<label>이름 : </label>${customer.name }<br>
		<label>주민번호 : </label>${customer.ssn }<br>
		<label>연락처 : </label>${customer.phone }<br>
	</form>
		<button><a href="/jvx330/banking/addaccount">신규계좌생성</a></button>
		<button type="button" onclick="location.href='<c:url value="success_addaccount"/>' ">계좌확인</a></button>
		<button type="button" onclick="location.href='<c:url value="success_addaccount"/>' ">이체하기</a></button>
</body>
</html>