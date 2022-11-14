<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false" 
    import="java.util.*, sec02.ex02.*"
    %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var ="contextPath" value="${pageContext.request.contextPath}" />
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<c:choose>
<c:when test = '${msg=="addMember"}'>
<script>
window.onload = function() {
	alert("회원을 등록했습니다.");
}
</script>
</c:when>
<c:when test = '${msg=="modified"}'>
<script>
window.onload = function () {
	alert("회원 정보를 수정했습니다.");
}
</script>
</c:when>
<c:when test='${msg=="deleted"}'>
<script>
window.onload = function () {
	alert("회원 정보를 삭제했습니다.");
}
</script>
</c:when>
</c:choose>

<meta charset="UTF-8">
<title>회원 정보 출력창</title>

</head>
<body>
<table>
<tr align="center" bgcolor="skyblue">
<td width="20%" >아이디</td>
<td width="20%" >비밀번호</td>
<td width="20%" >이름</td>
<td width="20%" >이메일</td>
<td width="20%" >가입일</td>
<c:choose>
<c:when test="${membersList == null}">
<tr>
<td colspan=5>
<b>등록된 회원이 없습니다.</b>
</td>
</tr>
</c:when>
<c:when test="${membersList != null}">
<c:forEach var = "mem" items="${membersList}">
<tr align="center">
<td>${mem.id}</td>
<td>${mem.pwd}</td>
<td>${mem.name}</td>
<td>${mem.email}</td>
<td>${mem.joinDate}</td>
<td><a href="${contextPath}/member/modMemberForm.do?id=${mem.id}">수정</a></td>
<td><a href="${contextPath}/member/delMember.do?id=${mem.id}">삭제</a></td>
</tr>
</c:forEach>
</c:when>
</c:choose>
</tr>
</table>
<a href="${contextPath}/member/memberForm.do">
<p>회원가입하기</p>
</a>
</body>
</html>