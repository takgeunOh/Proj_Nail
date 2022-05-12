<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림창</title>
</head>
<body>
<script>
<%
String userEmail = (String)session.getAttribute("user_email");
	if(userEmail!=null) {
%>
		alert('로그인 성공!');
	    location.href='<%=request.getContextPath() %>';
<%	} else {
%>
		alert('로그아웃 성공!');
	    location.href='<%=request.getContextPath()%>/member/login.member';
<%	}
%>
</script>
</body>
</html>