<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>브라우저에 저장된 모든 쿠키를 받아옵니다.</h2>
<!-- 
%%	Scriptlet Element :: 자바 코드만 들어감
%=% Expression Element :: 출력문 :: ;붙이면 안됨
 -->
<%
	Cookie[] cs=request.getCookies();
	for(Cookie c :cs) {
%>
	<li>Name : <%= c.getName() %></li>
	<li>Value : <%= c.getValue() %></li>
<%
	}
%>
</body>
</html>