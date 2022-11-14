<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 인클루드 액션 태그 연습2</title>
</head>
<body>
안녕하세요. 인클루드 액션 태그 연습입니다.
<br>
<jsp:include page="bird_image.jsp" flush="ture" >
<jsp:param name="name" value="새2"/>
<jsp:param name="imgName" value="bird2.jpg"/> 

</jsp:include>
<br>
안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.
</body>
</html>