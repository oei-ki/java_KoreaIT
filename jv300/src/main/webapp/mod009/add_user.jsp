<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<style>
	select {
		width:177px;
	}
</style>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<jsp:include page="header.jsp">
			<jsp:param name="subtitle" value=" mod009 : Java Beans and include" />
		</jsp:include>
		
	</div>
	<div id="content-wrapper">
		<form action="add_user.do" method="post">
	<h2>회원가입</h2>
	<div class='signup'>
	<p>회원아이디<br><input type="text" name="userId"/></p>
	<p>비밀번호<br><input type="password" name="passwd"/></p>
	<p>이름<br><input type="text" name="userName"/></p>
	<p>주민번호<br><input type="text" name="ssn"/></p>
	<p>이메일<br><input type="text" name="email1"/>@
	<select name="email2">	
		<option value="" selected>선택</option>
		<option value="google.com">gmail.com</option>
		<option value="naver.com">naver.com</option>
		<option value="daum.net">daum.net</option>
	</select></p>
	<br>
	<p>
		<label for="addr">주소 : </label>
	    <input type="text" name="addr1" /><input type="text" name="addr2" />
	</p>
	</div>
	<input type="submit" value="확인"/>
</form>

	</div>
	<div id="footer">	
		<%@ include file="/incl/footer.jsp" %>
	</div>
</div>
</body>
</html>