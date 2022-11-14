<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m" property="*" /> 
<%--전송된 회원정보를 빈의 속성에 설정함 대신 전송하는 객체 이름과 빈 내부의 객체이름이 일치해야함--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean 객체 이름으로 매서드 호출</title>
</head>
<body>
<table border=1 align="center">
<tr align="center">
<td><%=m.getId() %></td>
<td><%=m.getPwd() %></td>
<td><%=m.getName() %></td>
<td><%=m.getEmail() %></td>
</tr>
<tr align="center">
<td>${m.id}</td>
<td>${m.pwd}</td>
<td>${m.name}</td>
<td>${m.email}</td>
</table>
</body>
</html>