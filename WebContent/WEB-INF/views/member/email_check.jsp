<%@page import="kr.siat.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String email = request.getParameter("email");
System.out.println("email_check : " + email);
MemberDAO dao = new MemberDAO();
boolean re = dao.existUserEmail(email);
%>

<%=re %>
</body>
</html>