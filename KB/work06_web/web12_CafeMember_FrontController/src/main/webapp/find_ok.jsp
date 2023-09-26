<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 조회 결과</title>
</head>
<body>
<h2> 회원 조회 결과</h2>
ID : ${vo.id}<br>
NAME : ${vo.name}<br>
ADDRESS : ${vo.address}<br>
<a href="logout.jsp">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>