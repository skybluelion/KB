<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
	text-align: center;
	background-color: LightGray;
}
.title{
	margin-left: 400px;
	margin-right: 400px;
	border: 1px solid darkgray;
	color: black;
}
.addedProduct{
	margin-left: 400px;
	margin-right: 400px;
	border: 1px solid white;
	background-image : url("img/1.jpg");
	color: white;
	border-radius: 12px;
}
.margin{
	margin-top: 150px;
}
a:link {
  color: white;
  background-color: transparent;
  text-decoration: none;
}

a:visited {
  color: pink;
  background-color: transparent;
  text-decoration: none;
}

a:hover {
  color: red;
  background-color: transparent;
  text-decoration: underline;
}

a:active {
  color: yellow;
  background-color: transparent;
  text-decoration: underline;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 class="title">상품이 저장되었습니다.</h2>
	<div class = "addedProduct">	
		<h2 class="margin">상품 번호 : <%=request.getAttribute("id") %></h2>
		<h2> 상품 명  : <%=request.getParameter("name") %></h2>
		<h2>상품 가격 : <%=request.getParameter("price") %></h2>
		<h2>상품 설명 : <%=request.getParameter("description") %></h2>
		
		<a href="AllProduct">전체 상품 보기</a><br><br>
	</div>
</body>
</html>