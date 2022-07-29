<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
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
		<button type="button" onclick="location.href='<c:url value="success_addaccount"/>' ">계좌확인</button>
		<button type="button" onclick="location.href='<c:url value="transfer"/>' ">이체하기</button>
		<button type="button" onclick="location.href='<c:url value="deposit"/>' ">입금하기</button>
</body>
</html>