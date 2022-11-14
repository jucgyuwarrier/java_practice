<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
    
    <%
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    
    //MemberBean m = new MemberBean(id, pwd, name, email);안해도 됨
    
    m.setId(id);
    %>
   <%--<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
   	   	<jsp:setProperty name="m" property="id" value='<%= request.getParameter("id") %>'/>
   	   	<jsp:setProperty name="m" property="id" param="id" />
   	   	<jsp:setProperty name="m" property="id"/> param 생략해도 디폴트로 알아서 긁어와서 넣어줌
  	   	<jsp:setProperty name="m" property="*" />  --%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>