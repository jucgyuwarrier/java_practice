<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import=" java.util.*, sec01.ex01.*"
   isELIgnored="false" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
   <% request.setCharacterEncoding("UTF-8"); %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table class="cls1">
<tr align="center">
<td width="20%" >아이디</td>
<td width="20%" >비밀번호</td>
<td width="20%" >이름</td>
<td width="20%" >이메일</td>
<td width="20%" >가입일</td>
</tr>
<c:choose>
<c:when test="${membersList==null }">
<tr>
<td colspan=5>
<b>등록된 회원이 없습니다.</b>
</td>
</tr>
</c:when>
<c:when test="${membersList !=null }">
<c:forEach var="mem" items="${membersList }">
<tr align="center">
<td>${mem.id }</td>
<td>${mem.pwd }</td>
<td>${mem.name }</td>
<td>${mem.email }</td>
<td>${mem.joinDate }</td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</table>
<a href="#">
<p>회원 가입하기</p>
</a>
</body>
</html>