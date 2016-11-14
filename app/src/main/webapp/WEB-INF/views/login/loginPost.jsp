<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>포스트 페이지</title>
</head>
<body>
<h1>
	포스트 페이지
</h1>
세션 존재 여부: <%= session.getAttribute("authCheck") != null ? "존재" : "없음" %>
<p>아이디: ${authCheck.id} </p>
<p>비밀번호: ${authCheck.pwd}</p>
<br>
<a href="/login/loginCheck.do">로그인 체크</a>
</body>
</html>
