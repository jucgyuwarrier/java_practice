<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json 배열 연습</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
$("#checkJson").click(function() { 
	var jsonStr = 
		'{"members":[{"name":"박지성", "age":"25", "gender":"남자", "nickname":"날쎈돌이"}'+ ', {"name":"손헝민", "age":"30","gender":"상남자", "nickname":"탱크"}] }';
	var jsonInfo = JSON.parse(jsonStr);
	var output = "회원 정보<br>";
	output += "======<br>";
	for (var i in jsonInfo.members) {
		output += "이름: " + jsonInfo.members[i].name + "<br>";
		output += "나이: " + jsonInfo.members[i].age + "<br>";
		output += "성별: " + jsonInfo.members[i].gender + "<br>";
		output += "별명: " + jsonInfo.members[i].nickname + "<br><br><br>";
	}
	$("#output").html(output);
	});
	
});


</script>
</head>
<body>
<input type="button" id="checkJson" value="출력"/>
<div id="output"></div>
</body>
</html>