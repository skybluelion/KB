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
		<a href="login.jsp">�α����ϱ�</a>
	</h2>
	<b>�α׾ƿ� �Ǽ̽��ϴ�...</b>
	<br>
</body>
</html>