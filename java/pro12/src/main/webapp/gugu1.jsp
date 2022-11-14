<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 예제1</title>
</head>
<body>
<table border='1' width='800'>
<tr align='center' bgcolor='#FFFF66'>
<td colspan='2'><%=dan %>단 출력 </td> <!-- 셀 병합 colspan='수' -->
</tr>
<%
for(int i=1; i<10; i++){
%>
<tr align ='center'>
<td width = '400'>
<%=dan %> * <%=i %>
</td>
<td width='400'>
<%=i*dan %>
</td>
</tr>
<%}%>
</table>
</body>
</html>