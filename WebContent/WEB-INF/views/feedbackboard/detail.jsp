<%@page import="kr.siat.model.FeedbackAnswerDTO"%>
<%@page import="kr.siat.model.FeedbackDTO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
FeedbackDTO dto = (FeedbackDTO)request.getAttribute("feedbackDto");
FeedbackAnswerDTO answerDTO = (FeedbackAnswerDTO)request.getAttribute("answerDTO");
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
				<h1>문의 상세보기</h1>
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


<!-- Page content-->
        <div class="container mt-5">
            <div class="row">
                <div class="col-lg-15">
                    <!-- Post content-->
                    <article>
                        <!-- Post header-->
                        <header class="mb-4">
                            <!-- Post title-->
                            <h1 class="fw-bolder mb-1"><%=dto.getTitle() %></h1>
                            <!-- Post meta content-->
                            <div class="text-muted fst-italic mb-2"> 작성자 : <%=dto.getAuthor() %></div>
                            <div class="text-muted fst-italic mb-2"> 작성일자 : <%=dto.getRegidate()%></div>
                            <!-- Post categories-->
                            <a class="badge bg-secondary text-decoration-none link-light" href="#!">영화 추가 건의</a>
                            <a class="badge bg-secondary text-decoration-none link-light" href="#!">이용 개선 건의</a>
                        </header>
                        <!-- Preview image figure-->
                        <figure class="mb-4"><img class="img-fluid rounded" src="https://dummyimage.com/900x400/ced4da/6c757d.jpg" alt="..." /></figure>
                        <!-- Post content-->
                        <section class="mb-5">
                            <p class="fs-5 mb-4"><%=dto.getContent() %></p>
                        </section>
                    </article>
                    <!-- Comments section-->
                    <section class="mb-5">
                        <div class="card bg-light">
                            <div class="card-body">
                                <!-- Comment with nested comments-->
                                <!-- <div class="d-flex mb-4">

                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Commenter Name</div>
                                        If you're going to lead a space frontier, it has to be government; it'll never be private enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified risks.

                                        <div class="d-flex mt-4">
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                And under those conditions, you cannot establish a capital-market evaluation of that enterprise. You can't get investors.
                                            </div>
                                        </div>

                                        <div class="d-flex mt-4">
                                            <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                            <div class="ms-3">
                                                <div class="fw-bold">Commenter Name</div>
                                                When you put money directly to a problem, it makes a good headline.
                                            </div>
                                        </div>
                                    </div>
                                </div> -->
                                <!-- Single comment-->
                                <%
                                if(answerDTO==null) {
                                %>
                                	<div class="d-flex">
		                           			<div class="ms-3">답변 대기 중입니다.</div>
		                           	</div>
		                        <%
                                } else {
                                %>
                                	<div class="d-flex">
		                                <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
		                                <div class="ms-3">
		                                    <div id="answerAuthor" class="fw-bold"></div>
		                                    <div id="answerContent"></div>
		                                </div>
		                            </div>
		                        <%
                                }
		                        %>
                                <%-- <c:choose>
	                                <c:when test="${answerDTO != null}">
		                                <div class="d-flex">
		                                    <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
		                                    <div class="ms-3">
		                                        <div class="fw-bold">${answerDTO.author }</div>
		                                        ${answerDTO.answer }
		                                    </div>
		                                </div>
		                            </c:when>
		                           	<c:otherwise>
		                           		<div class="d-flex">
		                           			<div class="ms-3">답변 대기 중입니다.</div>
		                           		</div>
		                           	</c:otherwise>
		                        </c:choose> --%>
                                
                             
                            </div>
                            <!-- Comment form-->
                                <form class="mb-4">
                                	<input type="hidden" id="boardNum" name="feedbackBoard" value="<%=dto.getNum()%>">
                                <%
                                if(session.getAttribute("user_email")!=null && (Integer)session.getAttribute("user_type")==0) {
                                %>
                                	<textarea id="answer" class="form-control" rows="3" placeholder="Join the discussion and leave a comment!"></textarea>
                                	<!-- <button type="submit" class="btn btn-primary" style="margin:20px 20px;">답변 작성</button> -->
                                	<a href="javascript:void(0)" id="answer-btn" class="button button-postComment button--active" onclick="writeCmt()" style="margin:30px 10px;">답변 작성</a>
                                <%
                                }
                                %>
                                </form>
                        </div>
                    </section>
                </div>
              </div>
            </div>
               	
               	
               	
                <!-- <div class="col-lg-4">
                    Search widget
                    <div class="card mb-4">
                        <div class="card-header">Search</div>
                        <div class="card-body">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Enter search term..." aria-label="Enter search term..." aria-describedby="button-search" />
                                <button class="btn btn-primary" id="button-search" type="button">Go!</button>
                            </div>
                        </div>
                    </div>
                    Categories widget
                    <div class="card mb-4">
                        <div class="card-header">Categories</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">Web Design</a></li>
                                        <li><a href="#!">HTML</a></li>
                                        <li><a href="#!">Freebies</a></li>
                                    </ul>
                                </div>
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="#!">JavaScript</a></li>
                                        <li><a href="#!">CSS</a></li>
                                        <li><a href="#!">Tutorials</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    Side widget
                    <div class="card mb-4">
                        <div class="card-header">Side Widget</div>
                        <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use, and feature the Bootstrap 5 card component!</div>
                    </div>
                </div>
            </div>
        </div> -->

<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>

$("#answer-btn").click(function() {
	$.ajax({
		url: "<%=request.getContextPath() %>/feedbackboard/insertAnswer.board",
		type:"POST",
		data: {
			boardNum : $("#boardNum").val(),
			answer : $("#answer").val()
		},
		success:function() {
			alert("댓글이 작성되었습니다.")
			location.reload()
		},
	});
})

</script>


<%@ include file="/inc/bottom.jsp"%>