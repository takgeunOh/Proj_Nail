<%@page import="kr.siat.model.FeedbackDTO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="blog">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>문의글 작성하기</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active" aria-current="page">문의하실 내용을 입력해주세요. 최대한 빠른 시일 내에 답변드리겠습니다.</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->

<div class="container" class="br">
	<div class="container">
		<!-- <form action="insert.board" method="post">
			<div class="form-group">
				<label for="subject">제목</label> <input type="text"
					class="form-control" id="title" name="title"
					placeholder="제목을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="writer">작성자</label> <input type="text"
					class="form-control" id="author" name="author"
					placeholder="내용을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="5"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">작성</button>
		</form> -->
		<div class="container" style="margin: 30px 30px; padding: 30px 30px;">
			<form action="insertFeedback.board" method="post">
				<div class="form-group">
					<input type="hidden" name="user_email" value="<%=session.getAttribute("user_email")%>">
					<label for="email">글 작성자</label> <input type="text"
						class="form-control" id="user_name" name="user_name"
						value="<%=session.getAttribute("user_name")%>" readonly>
				</div>
				<div class="form-group">
					<label for="exampleFormControlSelect1">건의 카테고리</label><br> 
					<select name="queryType" class="form-control" id="exampleFormControlSelect1">
						<option>영화 추가 건의</option>
						<option>드라마 추가 건의</option>
						<option>이용권 문의</option>
						<option>이용환경 문의</option>
						<option>계정 문의</option>
					</select>
				</div><br><br>
				<div class="form-group">
					<label for="email">문의글 제목</label> <input type="text"
						class="form-control" id="title" placeholder="글 제목을 입력해주세요."
						name="title">
				</div>
				<div class="form-group">
					<label for="pwd">문의 내용</label>
					<textarea class="form-control" id="content" name="content" rows="5"
						placeholder="글 내용을 입력해주세요."></textarea>
				</div>
				<button type="submit" class="btn btn-primary">작성 완료</button>
			</form>
		</div>
	</div>
</div>


<%@ include file="/inc/bottom.jsp"%>