<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function addImage() {
	$("#div1").html("<img src='../image/bird2.JPG'>");
	
}
</script>
</head>
<body>
<div id="div1"></div>
<input type="button" value="이미지 추가하기" onClick="addImage()" />
</body>
</html>