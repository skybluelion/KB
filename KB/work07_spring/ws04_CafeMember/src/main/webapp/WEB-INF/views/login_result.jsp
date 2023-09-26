<%@page import="com.spring.service.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인성공</title>
</head>
<body>
<h2>login information</h2>
id : ${vo.id}<br>
name : ${vo.name}<br>
address : ${vo.address}<br>
<p></p><hr><p></p>
<a href="logout.do">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>