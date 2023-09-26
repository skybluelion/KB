<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ConnectionPool Test...using JNDI Service</h2>
<%
	Context context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
	
	out.print("<b>1. DataSource Lookup...</b>");
	Connection conn = ds.getConnection();
	out.print("<br><b>2. Connection Rent Success!...</b>");
%>
</body>
</html>