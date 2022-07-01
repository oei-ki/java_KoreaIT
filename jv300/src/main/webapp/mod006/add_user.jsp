<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
	label {display: block;}
	</style>
  <form action="add_user.do" method="post">
    <label for="userId">회원 아이디 : </label>
    <input type="text" name="userId" />
    <label for="password">비밀번호 : </label>
    <input type="password" name="passwd" />
    <label for="userName">이름 : </label>
    <input type="text" name="userName" />
    <label for="ssn">주민번호 : </label>
    <input type="text" name="ssn" />
    <label for="email1">이메일 : </label>
    <input type="text" name="email1" />
    <select class="email2" name="email2">
      이메일2 :
      <option value="@naver.com">@naver.com</option>
      <option value="@goolge.com">@goolge.com</option>
      <option value="@daum.net">@daum.net</option>
    </select>
    <label for="addr">주소 : </label>
    <input type="text" name="addr1" /><input type="text" name="addr2" />
    <input type="submit" value="확인">
  </form>
</body>
</html>