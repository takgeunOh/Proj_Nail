<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category" style="height:40vh;">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>로그인</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">원활한 서비스 이용을 위해 로그인을 해주세요.</a></li>
						<!-- <li class="breadcrumb-item active" aria-current="page">회원가입</li> -->
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->



<%
if(session.getAttribute("user_email")==null) {
%>
<!--================Login Box Area =================-->
<section class="login_box_area section-margin">
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="login_box_img">
					<div class="hover">
						<h4>계정이 없다면 회원가입하세요!</h4>
						<p>우리는 합리적인 가격으로 비디오를 제공하며, 회원님들의 피드백을 빠르게 반영하여 업데이트합니다.</p>
						<p>구독제를 통해 합리적인 가격으로 기간동안 무제한으로 즐기시거나, 소장하고자 하는 비디오가 있다면 다운로드를 하실 수 있습니다.</p>
						<a class="button button-account" href="<%=request.getContextPath()%>/member/register.member">회원가입</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="login_form_inner">
					<h3>로그인</h3>
					<form class="row login_form" id="contactForm" action="login.member" method="POST">
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="UserEmail" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'UserEmail'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="password"
								name="password" placeholder="Password"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Password'">
						</div>
						<div class="col-md-12 form-group">
							<div class="creat_account">
								<input type="checkbox" id="f-option2" name="selector"> <label
									for="f-option2">이메일 계정 기억하기</label>
							</div>
						</div>
						<div class="col-md-12 form-group">
							<button id="btn_login" type="submit" value="submit" class="button button-login w-100">로그인</button>
							<!-- <input type="button" id="btn_login" value="로그인" /> -->
							<a href="#">비밀번호 찾기</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Login Box Area =================-->

<% } else {
	String userName = (String)session.getAttribute("user_name");
%>
	<h3><%=userName %>님 환영합니다!</h3>
	<p><a href="logout.member">로그아웃</a></p>
<%}%>

<%@ include file="/inc/bottom.jsp"%>