<%@page import="java.io.PrintWriter"%>
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

System.out.println("email_check.jsp 통과");
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("EUC-KR");

String userEmail = request.getParameter("userEmail");

MemberDAO dao = new MemberDAO();

boolean emailCheck = dao.existUserEmail(userEmail);

if(emailCheck) {
	System.out.println("이미 존재하는 이메일입니다.");
} else {
	System.out.println("사용 가능한 이메일입니다.");
}

out.write(emailCheck + "");
// ajax 결과값인 result가 된다. String으로 값을 내보낼 수 있도록 +"" 해준 것.

%>
</body>
</html>