<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>Login / Register</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Login/Register</li>
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
						<h4>New to our website?</h4>
						<p>There are advances being made in science and technology
							everyday, and a good example of this is the</p>
						<a class="button button-account" href="<%=request.getContextPath()%>/member/register.member">Create an Account</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="login_form_inner">
					<h3>Log in to enter</h3>
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
									for="f-option2">Keep me logged in</label>
							</div>
						</div>
						<div class="col-md-12 form-group">
							<button id="btn_login" type="submit" value="submit" class="button button-login w-100">Log In</button>
							<!-- <input type="button" id="btn_login" value="로그인" /> -->
							<a href="#">Forgot Password?</a>
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