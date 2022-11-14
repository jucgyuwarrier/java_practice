<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" 
    %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="sec01.ex02.MemberBean"/>
<jsp:setProperty name="m" property="*"/>
<jsp:useBean id="addr" class="sec01.ex02.Address"/>
<jsp:setProperty name="addr" property="city" value="서울"/>
<jsp:setProperty name="addr" property="zipcode" value="07654"/>
<%
m.setaddr(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력</title>
</head>
<body>
<table border="1" align="center">
<tr align="center" color="green">
<td>아이디</td>
<td>비밀번호</td>
<td>이름</td>
<td>이메일</td>
<td>주소</td>
<td>우편번호</td>
</tr>
<tr align="center">
<td>${m.id}</td>
<td>${m.pwd}</td>
<td>${m.name}</td>
<td>${m.email}</td>
<td><%=m.getaddr().getcity() %></td>
<td><%=m.getaddr().getzipcode() %></td>
</tr>
<tr align="center">
<td>${m.id}</td>
<td>${m.pwd}</td>
<td>${m.name}</td>
<td>${m.email}</td>
<td>${m.addr.city}</td>
<td>${m.addr.zipcode}</td>
</tr>
</table>
</body>
</html>