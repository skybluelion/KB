<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="web.servlet.dto.ParameterDto"%>
<%
	ParameterDto parameterDto = (ParameterDto) request.getAttribute("parameterDto");

	StringBuilder sbHobby = new StringBuilder();
	for (String h : parameterDto.getHobby()) {
		sbHobby.append(h).append(", ");
	}
	sbHobby.setLength(sbHobby.length()-2);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>post result</title>
    <style>
    	table {
    		width: 600px;
    	}
    	table, td {
    		border: 1px solid grey;
    		border-collapse: collapse;    		
    	}
    </style>
  </head>
	<body>
		<h1>Post Result</h1>
		<table>
			<tr><td>name</td><td><%= parameterDto.getName() %></td></tr>
			<tr><td>email</td><td><%= parameterDto.getEmail() %></td></tr>
			<tr><td>gender</td><td><%= parameterDto.getGender() %></td></tr>
			<tr><td>hobby</td><td><%= sbHobby %></td></tr>
			<tr><td>favorite</td><td><%= parameterDto.getFavorite() %></td></tr>
			<tr><td>desc</td><td><%= parameterDto.getDesc() %></td></tr>
		
		</table>		
	</body>
</html>