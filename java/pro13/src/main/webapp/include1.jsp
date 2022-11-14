<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
안녕하세요. 이미지 인클루드 액션태그 연습입니다.
<br>
<jsp:include page="bird_image.jsp" flush="true">
<jsp:param name="name" value="새1" />
<jsp:param name="imgName" value="bird1.jpg" /> 
</jsp:include>
<br>
안녕하세요. 이미지 인클루드 액션태그 연습입니다.
</body>
</html>