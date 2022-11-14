<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"/>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");
//원래는 MemberBean m = new MemberBean 객체를 만들어야하지만 jsp:useBean으로 생성해서 안해도됨
m.setId(id);
m.setPwd(pwd);
m.setName(name);
m.setEmail(email);//get만하고 set으로 저장안하면 페이지 벗어났을때 휘발됨

MemberDAO memberDAO=new MemberDAO(); 
memberDAO.addMember(m); //회원정보를 데이터베이스에 추가한후 리턴값 없이 다시 돌아옴
List membersList = memberDAO.listMembers(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp:useBean 태그를 이용한 회원목록 관리</title>
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
		MemberBean bean = (MemberBean) membersList.get(i); //리스트형의 값을 맴버빈객체로 변환후 get메서드로 값을 가져와서 출력
		%>
		<tr align="center">
		<td>
		<%= bean.getId() %>
		</td>
		<td>
		<%= bean.getPwd() %>
		</td>
		<td>
		<%= bean.getName() %>
		</td>
		<td>
		<%= bean.getEmail() %>
		</td>
		<td>
		<%= bean.getJoinDate() %>
		</td>
		</tr>
		<%
	} //end for
} //end if
%>
</table>
</body>
</html>