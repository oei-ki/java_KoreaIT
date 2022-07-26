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
	<h3>뱅킹 회원가입</h3>
	<form action="addCustomer" method="post">
		<label>아이디 : </label><input type="text" name="userId"><br>
		<label>비밀번호 : </label><input type="password" name="passwd"><br>
		<label>이름 : </label><input type="text" name="name"><br>
		<label>주민번호 : </label><input type="text" name="ssn"><br>
		<label>연락처 : </label><input type="text" name="phone"><br>
		<input type="submit" value="뱅킹 가입"/>
	</form>
</body>
</html>