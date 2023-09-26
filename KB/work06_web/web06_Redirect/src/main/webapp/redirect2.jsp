<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String city = request.getParameter("city");
%>
<b>당신이 선택한 도시는 <%= city %> 입니다.</b>
</body>
</html>