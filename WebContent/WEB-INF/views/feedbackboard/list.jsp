<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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

<div class=container>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일자</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${feedbackList }">
				<tr>
					<th scope="row">${board.num }</th>
					<td><a href="feedbackDetail.board?num=${board.num }">${board.title }</td>
					<%-- <td>${board.content }</td> --%>
					<td>${board.author }</td>
					<td>${board.regidate }</td>
					<td>${board.viewcnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>



<%@ include file="/inc/bottom.jsp"%>