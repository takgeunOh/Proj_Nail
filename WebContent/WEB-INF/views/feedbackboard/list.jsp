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
								<th>문의유형</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>답변상태</th>
								<%
								if(session.getAttribute("user_email")!=null && (Integer)session.getAttribute("user_type")==0) {
									// 로그인한 사람이 관리자라면 관리컬럼 보이도록 할 것.
								%>
								<th>관리</th>
								<%
								}
								%>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="feedback" items="${feedbackList }">
								<tr>
									<th scope="row">${feedback.num }</th>
									<td>${feedback.type }</td>
									<td><a href="detail.board?num=${feedback.num }">${feedback.title }</a></td>
									<td>${feedback.author }</td>
									<td>${feedback.regidate }</td>
									<td>${feedback.viewcnt }</td>
									<%
									FeedbackDTO dto = (FeedbackDTO)pageContext.getAttribute("feedback");
									System.out.println("문의게시판 리스트 번호 : " + dto.getNum());			// 정상 출력
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
									<%
									if(session.getAttribute("user_email")!=null && (Integer)session.getAttribute("user_type")==0) {
									%>
										<td>
								      	<button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="delete_click('<%=dto.getNum()%>');">
						            		<span aria-hidden="true"><i class="fa fa-close"></i></span>
						          		</button>
						        		</td>
						        	<%
									}
									%>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div style="display:flex; justify-content:flex-end;">
				<a id="writeBtn" class="btn btn-primary" href="javascript:void(0)" role="button" >문의글 작성하기</a>
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

$("#writeBtn").click(function() {
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
	%>
		location.href="<%=request.getContextPath() %>/feedbackboard/insertFeedback.board?email=" + sessionStorage.getItem("user_email");
	<%
	}
	%>
})

function delete_click(feedbackIdx) {
	// console.log("삭제문의글 번호 : " + feedbackIdx);			// 정상 출력
	var query = {idx : feedbackIdx};
	var ans = confirm("선택하신 문의글을 삭제하시겠습니까?");
	if(!ans)
		return false;
	
	$.ajax({
		url : "<%=request.getContextPath()%>/feedbackboard/feedbackBoardDelete.board",
		type:"GET",
		data : query,
		success:function(data) {
			alert("문의글 삭제가 완료되었습니다.");
			location.reload();
		},
	});
}

</script>


<%@ include file="/inc/bottom.jsp"%>