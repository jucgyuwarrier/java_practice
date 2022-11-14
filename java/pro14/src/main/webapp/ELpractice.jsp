<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL표현 언어에서 사용되는 데이터</title>
</head>
<body>
<h1>표현 언어로 여러 가지 데이터 출력하기</h1>
<h1>
\${100} : ${100}<br>
\${"안녕하세요"} : ${"안녕하세요"}<br>
\${10+1} : ${10+1}<br>
\${"10"+1} : ${"10"+1}<br>
<%-- 
	string형 숫자+ 숫자는 문자형이 숫자형으로 반환됨
	문자열끼리는 더할수 없음
	문자열과 숫자는 더할 수 없음
 --%>
</h1>
</body>
</html>