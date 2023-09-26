<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
파일 업로드 작성시 유의해야할 규칙
1. method="post"
2. enctype="multipart/form-data"
3. input type="file"
4. poem.xml :: commons-fileup 라이브러리 추가
5. 빈 설정문서 추가 :: multipartResolver
 -->
</head>
<body>
<h2 align = "center">File Upload Form...</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
	사용자명 <input type="text" name="userName">
	<input type="file" name="uploadFile">
	<input type="submit" value="파일 업로드">
</form>
</body>
</html>