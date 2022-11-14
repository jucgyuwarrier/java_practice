<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"
    import="java.util.*, sec01.ex01.*"
    %>
<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
    <jsp:setProperty name="m1" property="*"/>
    <jsp:useBean id="membersList" class="java.util.ArrayList"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
<table align="center" width="100%">
<tr align="center" bgcolor="skyblue">
<td width="7%">아이디</td>
<td width="7%">비밀번호</td>
<td width="5%">이름</td>
<td width="11%">이메일</td>
<td width="5%">가입일</td>
</tr>
<%
if(membersList.size()==0) {
%>
<tr>
<td colspan="5">
<p align="center">
<b><span style="font-size:9pt;">등록된 회원이 없습니다.</span></b>
</p>
</td>
</tr>
<%
}else{
	for(int i=0; i<membersList.size(); i++) {
		MemberBean bean = (MemberBean) membersList.get(i);
		%>
		<tr align="center">
		<td>
		${bean.id}
		</td>
		<td>
		${bean.pwd}
		</td>
		<td>
		${bean.name}
		</td>
		<td>
		${bean.email}
		</td>
		<td>
		${bean.joinDate}
		</td>
		</tr>
		<%
	} //end for
} //end if
%>
</table>
</body>
</html>