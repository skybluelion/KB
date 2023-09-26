<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%
	Map<String, String> map = (Map<String, String>) request.getAttribute("map");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>get result</title>
  </head>
	<body>
		<h1>Get Result</h1>
<%
	for( String key : map.keySet() ){
%>
	<h1><%=key %> : <%= map.get(key)%></h1>
<%	
	}
%>		
	</body>
</html>