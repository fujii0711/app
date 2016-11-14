<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그아웃 페이지</title>
</head>
<body>
<h1>
	로그아웃 되었습니다.
</h1>
<br>
세션 존재 여부: <%= session.getAttribute("authCheck") != null ? "존재" : "없음" %>
<br>
<a href="/login/loginPost.do">포스트페이지</a>
</body>
</html>
