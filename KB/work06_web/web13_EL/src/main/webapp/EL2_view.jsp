<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element 사용하기</b>
<%= request.getParameter("myId") %><br>

<b>2. JSP EL 사용하기</b>
${param.myId}
<hr>
<b>3. JSP Menu에 해당하는 값 기본 Element 사용하기</b><br>
<%
	String[] menus = request.getParameterValues("menu");
	for(String m : menus) {
%>		
	<b><%= m %></b>
<%
	}

%>
<br>
<b>4. JSP Menu에 해당하는 값 EL 사용하기</b><br>
 선택한 메뉴 ::
 ${paramValues.menu[0]}
 ${paramValues.menu[1]}
 ${paramValues.menu[2]}
 ${paramValues.menu[3]}
</body>
</html>