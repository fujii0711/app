<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> 필드셋 요소 </title>
	</head>
	<body>
	<form name="frm" action="/login/loginCheck.do">
	<fieldset>
		<legend>로그인</legend>
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" title="아이디" value="hujii0711"/>
		
		<label for="pass">비밀번호</label>
		<input type="password" name="pwd" id="pwd" title="비밀번호" value="hj1560813@"/>
		<input type="checkbox" name="remember" id="remember"/>	 
		 
		<label for="remember"> 아이디저장</label>
		<input type="submit" value="로그인"/>
	</fieldset>
	</form>
	</body>
</html>
