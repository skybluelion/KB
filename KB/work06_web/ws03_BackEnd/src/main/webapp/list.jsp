<%@page import="web.product.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	ArrayList<Product> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>상품 리스트</h2>
	<p>상품 등록</p>
	<table class="table table-dark table-striped">
	
		<thead>
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 가격</th>
				<th>상품 설명</th>
			</tr>
		</thead>
	
	<%
		for(Product v:list){
	%>
		<tr>
			<td><%= v.getId() %></td>
			<td><%= v.getName() %></td>
			<td><%= v.getPrice() %></td>
			<td><%= v.getDescription() %></td>
		</tr>
	<%
		}
	%>
	</table>
	<h4 align="right"><a href="index.html">INDEX</a></h4>
</div>
</body>
</html>