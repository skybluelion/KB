<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${!empty vo}">
		<% session.invalidate(); %>
	</c:when>
	<c:otherwise>
		<h2><a href="login.jsp">로그인 하기</a></h2>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("Log Out!");
	}
</script>
</head>
<body onload="return logout()">
	<b>로그아웃 되셨습니다...</b><br>
	<a href="index.jsp">INDEX</a>
</body>
</html>