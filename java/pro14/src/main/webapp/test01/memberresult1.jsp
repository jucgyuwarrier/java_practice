<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
request.setCharacterEncoding("UTF-8"); 
String id = request.getParameter("user_ID");
String pw = request.getParameter("user_PW");
String name = request.getParameter("name");
String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력</title>
</head>
<body>
<table border="1" align="center">
<tr align="center" bgcolor="blue">
<td width="20%"><b>아이디</b></td>
<td width="20%"><b>비밀번호</b></td>
<td width="20%"><b>이름</b></td>
<td width="20%"><b>이메일</b></td>
</tr>
<tr align=center>
<td><%=id%></td>
<td><%=pw%></td>
<td><%=name%></td>
<td><%=email%></td>
</tr>
<tr align=center>
<td>${param.user_ID}</td>
<td>${param.user_PW}</td>
<td>${param.name}</td>
<td>${param.email}</td> <%--el태그 ${param.~}을 쓰면 getParameter로 생성자 만들지 않아도 바로 긁어올 수 있음   --%>
</tr>
</table>
</body>
</html>