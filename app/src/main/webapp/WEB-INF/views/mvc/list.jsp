<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table style="border:1px solid #000;">
	<c:forEach var="list" items="${list}">
	<tr style="border:1px solid #000;">
		<td style="border:1px solid #000;">${list.country_id}</td>
		<td style="border:1px solid #000;">${list.country_name}</td>
		<td style="border:1px solid #000;">${list.region_id}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>