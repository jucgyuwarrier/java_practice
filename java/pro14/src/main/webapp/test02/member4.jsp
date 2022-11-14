<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    <%
    session.setAttribute("address","수원시 팔달구");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호출 순위 </title>
</head>
<body>
<table border="1" align="center">
<tr align="center" bgcolor="#99ccff">
<td width="7%"><b>아이디</b>
<td width="7%"><b>비밀번호</b>
<td width="5%"><b>이름</b>
<td width="5%"><b>이메일</b></td>
<td width="5%"><b>주소</b></td>
</tr>
<tr align="center">
<td>${id }</td>
<td>${pwd }</td>
<td>${name }</td>
<td>${email }</td>
<td>${address }</td>
<%--session과 request에 동일한 이름의 객체가 있을시 request객체가 우선됨 --%>
</table>
</body>
</html>