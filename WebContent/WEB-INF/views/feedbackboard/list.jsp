<%@page import="kr.siat.model.FeedbackDTO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/notice.css">

<%
ArrayList<FeedbackDTO> list = new ArrayList<FeedbackDTO>();
list = (ArrayList<FeedbackDTO>) request.getAttribute("feedbackList");
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
									<%
									FeedbackDTO dto = (FeedbackDTO)pageContext.getAttribute("feedback");
									// System.out.println("문의게시판 리스트 번호 : " + dto.getNum());			// 정상 출력
									if(dto.getAnswerCheck()==1) {
									%>
									<td><a href="javascript:changeProcess(${feedback.num }, <%=session.getAttribute("user_type") %>)" class="btn btn-danger">답변 대기</a></td>
									<!-- <td><a href="#" class="btn btn-warning">Open</a></td> -->
									<!-- <td><a href="#" class="btn btn-danger">On hold</a></td> -->
									<%
									} else if(dto.getAnswerCheck()==2) {
									%>
										<td><a href="javascript:changeProcess(${feedback.num }, <%=session.getAttribute("user_type") %>)" class="btn btn-warning">답변 처리 중</a></td>
									<%
									} else if(dto.getAnswerCheck()==3){
									%>
										<td><a href="javascript:changeProcess(${feedback.num }, <%=session.getAttribute("user_type") %>)" class="btn btn-success">답변 완료</a></td>
									<%
									}
									%>
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


<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>

function changeProcess(feedbackIdx, userType) {
	var query = {idx : feedbackIdx};

	<%
	if(session.getAttribute("user_email")!=null) {
	%>
		if(userType==0) {
			$.ajax({
				url : "<%=request.getContextPath()%>/feedbackboard/changeProcess.board",
				type:"GET",
				data : query,
				success:function(data) {
					location.reload();
				},
			});
		} else {
			alert("관리자만 가능합니다.");
		}
	<%
	}
	else {
	%>
		alert("관리자만 가능합니다.");
	<%
	}
	%>
}
</script>


<%@ include file="/inc/bottom.jsp"%>