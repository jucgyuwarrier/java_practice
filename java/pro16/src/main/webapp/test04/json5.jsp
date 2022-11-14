<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		var jsonInfo = '{"name":"박지성", "age":"25", "gender":"상남자", "nickname":"축잘알"}';
		$.ajax({
			type:"post", 
			async:false, 
			url:"${contextPath}/json", 
			data:{jsonInfo: jsonInfo}, 
			success:function (data, textStatus) {
				
			},
			error:function(data,textStatus) {
				alert("에러가 발생했습니다."); 
			},
			complete:function(data,textStatus) {
			}
		}); //end ajax
	});
});
</script>
</head>
<body>
<input type="button" id="checkJson" value="전송">
</body>
</html>