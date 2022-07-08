<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>주소</th>
	</tr>
		<c:forEach var="test" items="${userList}">
	<tr>
			<td>${test.userId}</td>
			<td>${test.passwd}</td>
			<td>${test.userName}</td>
			<td>${test.ssn}</td>
			<td>${test.email}</td>
			<td>${test.addr}</td>
	</tr>
		</c:forEach>
</table>
</body>
</html>