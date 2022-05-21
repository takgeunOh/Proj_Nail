<%@page import="kr.siat.model.MovieCartDAO"%>
<%@page import="kr.siat.model.MovieCartDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.siat.model.dramaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/inc/top.jsp"%>
<%@page import="java.util.ArrayList"%>

<div class='container' style="margin:10px 50px;">
  <div class='heading'>
    <h3>결제하기</h3>
    <label>결제를 진행할 신용카드 정보를 입력해주세요.</label>
    <i class='icon ion-card'></i>
  </div>
  <div class='content'>
    <label>카드명</label>
    <div class='input-group'>
      <input class='form-control' type='text'>
    </div>
    <label>카드번호</label>
    <div class='input-group'>
      <input class='form-control' type='text'>
    </div>
    <label>카드만료일</label>
    <div class='input-group'>
      <input class='form-control' type='text'>
    </div>
    <label>ccv/cvv</label>
    <div class='input-group'>
      <input class='form-control' type='text'>
    </div>
    <br>
    <a id="complete" class='btn btn-primary' type='submit' style="color:white;">결제 완료</a>
  </div>
</div>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$("#complete").click(function() {
	<%
	if(session.getAttribute("user_email")==null) {
	%>
		if(confirm("로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?")==true) {
			location.href="<%=request.getContextPath() %>/member/login.member";
		} else {
			return false;
		}
	<%
	} else {
		if((Integer)session.getAttribute("user_type")==2) {
	%>
		alert("이미 구독 중인 회원님입니다. 서비스를 즐겨주세요.");
		location.href="<%=request.getContextPath() %>/index.jsp";
	<%
		} else {
	%>
	alert("결제가 정상적으로 완료되었습니다. 즐거운 시간 되세요.");
	location.href="<%=request.getContextPath() %>/index.jsp";
	<%
		}
	}
	%>
	
})

</script>


<%@ include file="/inc/bottom.jsp"%>