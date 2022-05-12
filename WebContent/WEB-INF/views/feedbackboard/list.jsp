<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/notice.css">

<%
	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
list = (ArrayList<BoardDTO>) request.getAttribute("feedbackList");
%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>커뮤니티</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">게시판</a></li>
						<li class="breadcrumb-item active" aria-current="page">문의 게시판</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">문의 게시판</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="table-wrap">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>답변상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="feedback" items="${feedbackList }">
								<tr>
									<th scope="row">${feedback.num }</th>
									<td><a href="detail.board?num=${feedback.num }">${feedback.title }</a></td>
									<td>${feedback.author }</td>
									<td>${feedback.regidate }</td>
									<td>${feedback.viewcnt }</td>
									<td><a href="#" class="btn btn-success">Progress</a></td>
									<!-- <td><a href="#" class="btn btn-warning">Open</a></td> -->
									<!-- <td><a href="#" class="btn btn-danger">On hold</a></td> -->
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		
	</div>
</section>

<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>



<%@ include file="/inc/bottom.jsp"%>