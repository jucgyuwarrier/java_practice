<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
request.setCharacterEncoding("utf-8");
request.setAttribute("address","서울시 강남구");
%>
<%-- 맴버폼1에서 가입정보를 넘겨받고 거기에 주소 객체를 request 객체에 추가후 맴버리절트로 포워드시킴 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestScope 실습</title>
</head>
<body>
<jsp:forward page="memberresult.jsp"></jsp:forward>
</body>
</html>