<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>우리 가게에서 판매되는 과일들입니다.</h2>
<c:forEach var="item" items="${list}">
	<li>${item}</li>
</c:forEach>
</body>
</html>