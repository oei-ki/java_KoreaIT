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
<form action="transfer" method="post">
	계좌선택 : 
	<select name="withdrawAccountNum">
	<c:forEach var="account" items="${accountList}">	
		 <option value=${account.accountNum }>${account.accountNum }</option>
	</c:forEach>
	</select>
	이체금액 : <input type="text" name="sendMoney">
	상대방계좌 : <input type="text" name="depositAccountNum">
	<button type="submit">송금</button>
</form>
</body>
</html>
