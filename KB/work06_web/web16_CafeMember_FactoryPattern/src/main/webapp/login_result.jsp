<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Information</title>
</head>
<body>
<h2>Login Information</h2>
ID : ${vo.id}<br>
NAME : ${vo.name}<br>
ADDRESS : ${vo.address}<br>
<p></p><hr><p></p>
<a href="logout.jsp">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>