<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%
request.setCharacterEncoding("utf-8");
request.setAttribute("id","hong");
request.setAttribute("pwd","1234");
request.setAttribute("name", "홍길동");
application.setAttribute("email","hong@test.com");
request.setAttribute("address","서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>각각 따로 저장된 동일 객체를 객체명으로만 호출시 순서</title>
</head>
<body>
<jsp:forward page="member4.jsp"/>
</body>
</html>