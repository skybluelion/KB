<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberVO vo=(MemberVO)session.getAttribute("vo");
	String book=(String)session.getAttribute("pname");
	if(vo!=null){ //로그인 한 상태라면...
%>
	<h3>로그인부터 하세요</h3>
	<a href= "login.html">LOGIN</a>
<%		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Information...</h2>
LOGIN ID : <b><%= vo.getId() %></b><br>
LOGIN Name : <b><%= vo.getName() %></b><br>
ProductName : <b><%= book %></b><br>

</body>
</html>