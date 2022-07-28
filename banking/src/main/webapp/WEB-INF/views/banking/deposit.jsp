<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		계좌선택 : 
	<select name="withdrawAccountNum">
	<c:forEach var="account" items="${accountList}">	
		 <option value="account">${account.accountNum }</option>
	</c:forEach>
	</select>
	입금액 : <input type="text" name="depositMoney">
</body>
</html>