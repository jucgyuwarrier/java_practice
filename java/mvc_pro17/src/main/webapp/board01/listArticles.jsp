<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<style>
	.cls1 {
	text-decoration: none;
	}
	
	.cls2 {
	text-align: center;
	font-size: 30px;
	}
</style>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
<table>
<tr align="center" bgcolor="orange">
<td>글번호</td>
<td>작성자</td>
<td>제목</td>
<td>작성일</td>
</tr>
<c:choose>
<c:when test="${articlesList == null }">
<tr height="10">
<td colspan="4">
<p align="center">
<b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
</p>
</td>
</tr>
</c:when>

<c:when test="${articlesList !=null }">
<c:forEach var="article" items="${articlesList}" varStatus="articleNum">
<tr align="center">
<td width="5%">${articleNum.count}</td>
<td width="10%">${article.id}</td>
<td align="left" width="35%">
<span style ="padding-right:30px"></span>
<c:choose>
<c:when test='${article.LEVEL > 1 }'>
<c:forEach begin="1" end="${article.LEVEL }" step="1">
<span style = "padding-left:20px"></span>
</c:forEach>
<span style="font-size:12px;">[답변]</span>
<a class='cls1' href="${contextPath}/board/viewArtice.do?articleNO=${article.articleNO}">${article.title}</a>
</c:when>
<c:otherwise>
<a class='cls1' href="${contextPath}/board/viewArticle.do?articleNO=${article.articleNO}">${article.title}</a>
</c:otherwise>
</c:choose>

<!-- ${article.content} -->
</td>
<td width="10%">
<fmt:formatDate value="${article.writeDate}"/>
</td>
</tr>
</c:forEach>
</c:when>

</c:choose>
</table>
</body>
</html>