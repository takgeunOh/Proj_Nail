<%@page import="model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
list = (ArrayList<BoardDTO>) request.getAttribute("boardList");
%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="blog">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>Our Blog</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Blog</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->

<div class="br">
	<div class="container">
		<form action="insert.board" method="post">
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
				<label for="writer">비밀번호</label> <input type="text"
					class="form-control" id="password" name="password"
					placeholder="비밀번호를 입력하세요.">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="5"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">작성</button>
		</form>
	</div>
</div>





<%@ include file="/inc/bottom.jsp"%>