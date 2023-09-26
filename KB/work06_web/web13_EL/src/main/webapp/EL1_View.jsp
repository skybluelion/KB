<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%-- 원래는 서블릿으로 작성해야하는 일단 서블릿이라 치자 --%>
<!-- Attribute에 바인딩된 값을 받아오는 코드로 작성 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element로 받아오기</b><br>
<%= request.getAttribute("RESULT1") %><br>
<%= session.getAttribute("RESULT2") %><br>

<hr>
<b>2. JSP EL로 받아오기</b><br>
1. ${RESULT1}<br>
2. ${RESULT2}<br>
3. ${RESULT1 + 1000} <br>
</body>
</html>