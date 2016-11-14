<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<p>ok1: <%= session.getAttribute("authCheck") != null ? "true" : "false"%></p>
	<p>ok2: <%= session.getAttribute("authCheck")%></p>
	<br>
	<p>아이디: ${authCheck.id} </p>
	<p>비밀번호: ${authCheck.pwd}</p>
	<br>
	<a href="/login/loginOut.do">로그아웃</a>
	<br>
	<a href="/login/loginPost.do">포스트페이지</a>
</body>
</html>
