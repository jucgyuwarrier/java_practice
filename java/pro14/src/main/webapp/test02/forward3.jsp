<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*, sec01.ex01.*"%>
    <%
    request.setCharacterEncoding("UTF-8"); 
    List membersList=new ArrayList();
    MemberBean m3 = new MemberBean("lee", "1234", "이순신", "lee@test.com");
    MemberBean m4 = new MemberBean("son", "1234", "손흥민", "son@test.com");
    membersList.add(m3);
    membersList.add(m4);
    request.setAttribute("membersList", membersList);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="member3.jsp"/>
</body>
</html>