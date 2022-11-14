<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestScope 연습</title>
</head>
<body>
<table border="1" align="center">
<tr align="center" bgcolor="blue">
<td width="20%"><b>아이디</b></td>
<td width="20%"><b>비밀번호</b></td>
<td width="20%"><b>이름</b></td>
<td width="20%"><b>이메일</b></td>
<td width="20%"><b>주소</b></td>
</tr>

<tr align=center>
<td>${param.user_ID}</td>
<td>${param.user_PW}</td>
<td>${param.name}</td>
<td>${param.email}</td> <%--el태그 ${param.~}을 쓰면 getParameter로 생성자 만들지 않아도 바로 긁어올 수 있음   --%>
<td>${requestScope.address}</td> <%-- --%>
</tr>
</table>
</body>
</html>