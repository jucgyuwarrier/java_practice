<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
		var article = {articleNO: "114",
			writer:"박지성",
			title:"안녕하세요",
			content:"상품 소개 글입니다."
		};
		
		$.ajax({//새 글등록은 post방식으로 요청
			type:"POST",
			url:"${contextPath}/boards",//새 글을 등록하는 메서드를 호출
			/*
			type:"PUT", 114번글 수정요청
			url:"${contextPath}/boards/114",
			*/
			contextType: "application/json",
			data:JSON.stringify(article),
			//글 정보를 제이슨 형식으로 전송함
			success:function (data, testStatus){
				alert(data);
			},
			error:function(data, textStatus){
				alert("에러가 발생했습니다.");
			},
			complete:function(data,textStatus){
				
			}
		});	
	});
});

</script>
</head>
<body>
<input type="button" id="checkJson" value="새글 쓰기"/><br><br>
<div id = "output"></div>
</body>
</html>