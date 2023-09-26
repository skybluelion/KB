<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>
	<c:when test="${!empty vo}">
		<%
		session.invalidate();
		%>
	</c:when>
	<c:otherwise>
		<a href="index.jsp">INDEX</a>
	</c:otherwise>
</c:choose>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>logout.jsp</title>
<script>
	function logout() {
		alert("Logout~~");
	}
</script>
</head>
<body onload="return logout()">
	<a href="index.jsp">INDEX</a>
	<h2>
		<a href="login.jsp">로그인하기</a>
	</h2>
	<b>로그아웃 되셨습니다...</b>
	<br>
</body>
</html>