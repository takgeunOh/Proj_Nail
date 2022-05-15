<%@page import="kr.siat.model.CommentDAO"%>
<%@page import="kr.siat.model.CommentDTO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
BoardDTO dto = new BoardDTO();
if("GET".equals(request.getMethod())) {
	dto = (BoardDTO) request.getAttribute("boarddetail");

	session.setAttribute("detailSessionNum", dto.getBoardNum());
} else if("POST".equals(request.getMethod())) {
	dto = (BoardDTO) request.getAttribute("boardaftermodify");
}

ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
commentList = (ArrayList<CommentDTO>)request.getAttribute("boardCommentList");
// System.out.println("detail.jsp에서의 boardCommentList : " + commentList);		// 정상 출력
System.out.println("detail.jsp에서의 userEmail : " + session.getAttribute("user_email"));
%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="blog">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>Board Details</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">MOVIE</a></li>
						<li class="breadcrumb-item active" aria-current="page">DRAMA</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->


<!--================Blog Area =================-->
<section
	class="blog_area single-post-area py-80px section-margin--small">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 posts-list">
				<div class="single-post row">
					<div class="col-lg-12">
						<div class="feature-img">
							<img class="img-fluid"
								src="${pageContext.request.contextPath }/inc/img/blog/feature-img1.jpg"
								alt="">
						</div>
					</div>
					<div class="col-lg-3  col-md-3">
						<div class="blog_info text-right">
							<div class="post_tag">
								<a href="#">Food,</a> <a class="active" href="#">Technology,</a>
								<a href="#">Politics,</a> <a href="#">Lifestyle</a>
							</div>
							<ul class="blog_meta list">
								<li><a href="#"><%=dto.getBoardAuthor() %> <i class="lnr lnr-user"></i>
								</a></li>
								<li><a href="#"><%=dto.getBoardRegidate() %> <i
										class="lnr lnr-calendar-full"></i>
								</a></li>
								<li><a href="#"><%=dto.getBoardViewCnt() %> <i class="lnr lnr-eye"></i>
								</a></li>
								<li><a href="#">${fn:length(boardCommentList) } Comments<i class="lnr lnr-bubble"></i>
								</a></li>
							</ul>
							<ul class="social-links">
								<li><a href="#"> <i class="fab fa-facebook-f"></i>
								</a></li>
								<li><a href="#"> <i class="fab fa-twitter"></i>
								</a></li>
								<li><a href="#"> <i class="fab fa-github"></i>
								</a></li>
								<li><a href="#"> <i class="fab fa-behance"></i>
								</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-9 col-md-9 blog_details">
						<h2><%=dto.getBoardTitle() %></h2>
						<p class="excert"><%=dto.getBoardContent() %></p>					<!-- 서브타이틀 정도로 쓰기 -->
					</div>
					<div class="col-lg-12">													<!-- 여기서부터는 콘텐츠 -->
						<%-- <div class="quotes">MCSE boot camps have its supporters and
							its detractors. Some people do not understand why you should have
							to spend money on boot camp when you can get the MCSE study
							materials yourself at a fraction of the camp price. However, who
							has the willpower to actually sit through a self-imposed MCSE
							training.</div>
						<div class="row">
							<div class="col-6">
								<img class="img-fluid"
									src="${pageContext.request.contextPath }/inc/img/blog/post-img1.jpg"
									alt="">
							</div>
							<div class="col-6">
								<img class="img-fluid"
									src="${pageContext.request.contextPath }/inc/img/blog/post-img2.jpg"
									alt="">
							</div>
							<div class="col-lg-12 mt-4">
								<p>MCSE boot camps have its supporters and its detractors.
									Some people do not understand why you should have to spend
									money on boot camp when you can get the MCSE study materials
									yourself at a fraction of the camp price. However, who has the
									willpower.</p>
								<p>MCSE boot camps have its supporters and its detractors.
									Some people do not understand why you should have to spend
									money on boot camp when you can get the MCSE study materials
									yourself at a fraction of the camp price. However, who has the
									willpower.</p>
							</div>
						</div> --%>
					</div>
				</div>
				<div class="navigation-area">
					<div class="row">
						<div
							class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
							<div class="thumb">
								<a href="#"> <img class="img-fluid"
									src="${pageContext.request.contextPath }/inc/img/blog/prev.jpg"
									alt="">
								</a>
							</div>
							<div class="arrow">
								<a href="#"> <span class="lnr text-white lnr-arrow-left"></span>
								</a>
							</div>
							<div class="detials">
								<p>Prev Post</p>
								<a href="#">
									<h4>Space The Final Frontier</h4>
								</a>
							</div>
						</div>
						<div
							class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
							<div class="detials">
								<p>Next Post</p>
								<a href="#">
									<h4>Telescopes 101</h4>
								</a>
							</div>
							<div class="arrow">
								<a href="#"> <span class="lnr text-white lnr-arrow-right"></span>
								</a>
							</div>
							<div class="thumb">
								<a href="#"> <img class="img-fluid"
									src="${pageContext.request.contextPath }/inc/img/blog/next.jpg"
									alt="">
								</a>
							</div>
						</div>
					</div>
				</div>
				
				
				
				<div id="comment_area" class="comments-area">
					<!-- <h4>05 Comments</h4> -->
					<h4>${fn:length(boardCommentList) } Comments</h4>
					<!-- commentList : 해당 글에 있는 댓글의 목록 (reviewBoardDetail에서 넘어와야할듯) -->
					<c:choose>
						<c:when test="${boardCommentList != null}">
							<c:forEach var="comment" items="${boardCommentList }">
								<div class="comment-list">
									<div class="single-comment justify-content-between d-flex">
										<div class="user justify-content-between d-flex">
											<div class="thumb">
												<img
													src="${pageContext.request.contextPath }/inc/img/blog/c1.jpg"
													alt="">
											</div>
											<div class="desc">
												<h5><a href="#">${comment.comment_id }</a></h5>
												<p class="date">${comment.comment_date }</p>
												<p class="comment">${comment.comment_content }</p>
											</div>
										</div>
										<div class="reply-btn">
										<%
											if(session.getAttribute("user_email")!=null) {
												CommentDTO commentDTO = (CommentDTO)pageContext.getAttribute("comment");
					
												if(session.getAttribute("user_email").equals(commentDTO.getComment_id())) {
										%>
													<a href="javascript:void(0)" class="btn-reply text-uppercase" style="color:blue">reply</a>
													<!-- comment.comment_num : 댓글의 글 번호 전달 -->
													<input type="hidden" id="commentNum" class="commentNum" name="commentNum" value="<%=commentDTO.getComment_num()%>">
													<input type="hidden" id="boardNum" class="boardNum" name="boardNum" value="<%=commentDTO.getComment_board()%>">
													<%
													// System.out.println("detail.jsp 게시글번호 : " + commentDTO.getComment_board());
													// System.out.println("detail.jsp 댓글번호 : " + commentDTO.getComment_num());
													%>
													
													<!-- <a href="javascript:void(0)" id="deleteBtn" class="btn-reply text-uppercase" style="color:red">delete</a> -->
													<!-- <a href="javascript:void(0)" class="btn-reply text-uppercase" style="color:red">delete</a> -->
													<a href="javascript:reDelCheck(${comment.comment_num }, ${comment.comment_board });" class="btn-reply text-uppercase" style="color:red">delete</a>
										<%		
												}
											} else {}
											
										%>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="comment-list">
								<div class="single-comment justify-content-between d-flex">
									<h6><strong>등록된 댓글이 없습니다. 리뷰에 대한 첫 댓글을 달아보세요.</strong></h6>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					
				</div>
		
				<div class="comment-form">
					<h4>댓글 남기기</h4>
					<%-- <%
					if(session.getAttribute("user_email")!=null) {
					%>
						<form>
							<!-- <div class="form-group form-inline">
								<div class="form-group col-lg-6 col-md-6 name">
									<input type="text" class="form-control" id="name"
										placeholder="Enter Name" onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter Name'">
								</div>
								<div class="form-group col-lg-6 col-md-6 email">
									<input type="email" class="form-control" id="email"
										placeholder="Enter email address"
										onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter email address'">
								</div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="subject"
									placeholder="Subject" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Subject'">
							</div> -->
							<div class="form-group">
								<textarea class="form-control mb-10" rows="5" name="message"
									placeholder="Messege" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Messege'" required></textarea>
							</div>
							<a id="cmtCnt-btn" class="button button-postComment button--active">Post Comment</a>
							
						</form>
					<%
					} else {
					%>
						<h5>로그인이 필요한 서비스입니다.</h5>
						<a href="login.member" class="button button-postComment button--active">로그인하러 가기</a>
					<%
					}
					%> --%>
					
					<form id="writeCommentForm">
						<input type="hidden" id="boardNum" name="comment_board" value="<%=dto.getBoardNum()%>">
						<input type="hidden" id="userEmail" name="comment_id" value="<%=session.getAttribute("user_email") %>">
						<div class="form-group">
								<textarea id="cmtCnt" class="form-control mb-10" rows="5" name="comment_content"
									placeholder="Messege" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Messege'" required></textarea>
						</div>
						<a href="javascript:void(0)" id="cmtCnt-btn" class="button button-postComment button--active" onclick="writeCmt()">Post Comment</a>
						<!-- <button type="submit">댓글 등록</button> -->
					</form>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget search_widget">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search Posts"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="lnr lnr-magnifier"></i>
								</button>
							</span>
						</div>
						<!-- /input-group -->
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget author_widget">
						<a class="btn btn-warning" href="modify.board?num=<%=dto.getBoardNum() %>&password=<%=dto.getBoardPassword() %>" role="button">수정</a>
						<%-- <a class="btn btn-danger" href="delete.board?num=<%=dto.getBoardNum() %>&password=<%=dto.getBoardPassword() %>" role="button">삭제</a> --%>
						<a class="btn btn-danger" href="#" data-toggle="modal" data-target="#moaModal">삭제</a>
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget popular_post_widget">
						<h3 class="widget_title">Popular Posts</h3>
						<div class="media post_item">
							<img
								src="${pageContext.request.contextPath }/inc/img/blog/popular-post/post1.jpg"
								alt="post">
							<div class="media-body">
								<a href="blog-details.html">
									<h3>Space The Final Frontier</h3>
								</a>
								<p>02 Hours ago</p>
							</div>
						</div>
						<div class="media post_item">
							<img
								src="${pageContext.request.contextPath }/inc/img/blog/popular-post/post2.jpg"
								alt="post">
							<div class="media-body">
								<a href="blog-details.html">
									<h3>The Amazing Hubble</h3>
								</a>
								<p>02 Hours ago</p>
							</div>
						</div>
						<div class="media post_item">
							<img
								src="${pageContext.request.contextPath }/inc/img/blog/popular-post/post3.jpg"
								alt="post">
							<div class="media-body">
								<a href="blog-details.html">
									<h3>Astronomy Or Astrology</h3>
								</a>
								<p>03 Hours ago</p>
							</div>
						</div>
						<div class="media post_item">
							<img
								src="${pageContext.request.contextPath }/inc/img/blog/popular-post/post4.jpg"
								alt="post">
							<div class="media-body">
								<a href="blog-details.html">
									<h3>Asteroids telescope</h3>
								</a>
								<p>01 Hours ago</p>
							</div>
						</div>
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget ads_widget">
						<a href="#"> <img class="img-fluid"
							src="${pageContext.request.contextPath }/inc/img/blog/add.jpg"
							alt="">
						</a>
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget post_category_widget">
						<h4 class="widget_title">Post Catgories</h4>
						<ul class="list cat-list">
							<li><a href="#" class="d-flex justify-content-between">
									<p>Technology</p>
									<p>37</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Lifestyle</p>
									<p>24</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Fashion</p>
									<p>59</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Art</p>
									<p>29</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Food</p>
									<p>15</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Architecture</p>
									<p>09</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>Adventure</p>
									<p>44</p>
							</a></li>
						</ul>
						<div class="br"></div>
					</aside>
					<aside class="single-sidebar-widget newsletter_widget">
						<h4 class="widget_title">Newsletter</h4>
						<p>Here, I focus on a range of items and features that we use
							in life without giving them a second thought.</p>
						<div class="form-group d-flex flex-row">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-envelope" aria-hidden="true"></i>
									</div>
								</div>
								<input type="text" class="form-control"
									id="inlineFormInputGroup" placeholder="Enter email address"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Enter email'">
							</div>
							<a href="#" class="bbtns">Subcribe</a>
						</div>
						<p class="text-bottom">You can unsubscribe at any time</p>
						<div class="br"></div>
					</aside>
					<aside class="single-sidebar-widget tag_cloud_widget">
						<h4 class="widget_title">Tag Clouds</h4>
						<ul class="list">
							<li><a href="#">Technology</a></li>
							<li><a href="#">Fashion</a></li>
							<li><a href="#">Architecture</a></li>
							<li><a href="#">Fashion</a></li>
							<li><a href="#">Food</a></li>
							<li><a href="#">Technology</a></li>
							<li><a href="#">Lifestyle</a></li>
							<li><a href="#">Art</a></li>
							<li><a href="#">Adventure</a></li>
							<li><a href="#">Food</a></li>
							<li><a href="#">Lifestyle</a></li>
							<li><a href="#">Adventure</a></li>
						</ul>
					</aside>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Blog Area =================-->

<!-- Moa Modal-->
  <div class="modal fade" id="moaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">비밀번호 확인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="delete.board" method="post">
          <div class="form-group">
          	<input type="hidden" name="deleteNum" value="<%=dto.getBoardNum() %>" />
            <label for="recipient-name" class="col-form-label">비밀번호 입력 : </label>
            <input type="text" class="form-control" name="deletePassword" id="recipient-name">
          </div>
          <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button type="submit" class="btn btn-primary">삭제하기</button>
	      </div>
        </form>
      </div>
    </div>
  </div>
</div>


<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>



var httpRequest = null;

// httpRequest 객체 생성
function getXMLHttpRequest() {
	var httpRequest = null;
	
	if(window.ActiveXObject){
        try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
        } catch(e) {
            try{
                httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) { httpRequest = null; }
        }
    }
    else if(window.XMLHttpRequest){
        httpRequest = new window.XMLHttpRequest();
    }
    return httpRequest;
}


<%-- function writeCmt() {
	var form = document.getElementById("writeCommentForm");
	
	var board = form.comment_board.value;
	var email = '<%=session.getAttribute("user_email")%>';
	var content = form.comment_content.value;
	
	if(!content) {
		alert("내용을 입력하세요.");
		return false;
	} else {
		var param = "comment_board=" + board + "&comment_id=" + email + "&comment_content=" + content;
		
		httpRequest = getXMLHttpRequest();
        httpRequest.onreadystatechange = checkFunc;
        httpRequest.open("POST", "CommentWriteAction.co", true);    
        httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
        httpRequest.send(param);

	}
} --%>







function checkFunc() {
	if(httpRequest.readyState === 4 && httpRequest.status === 200) {
		var resultText = httpRequest.responseText;
		if(resultText==1)
			document.location.reload();
	}
}


$("#cmtCnt-btn").click(function() {
	<%
	if(session.getAttribute("user_email")==null) {
	%>
		alert("로그인이 필요합니다.");
		location.href="<%=request.getContextPath() %>/member/login.member";
	<%
	} else {
	%>
		$.ajax({
			url: "<%=request.getContextPath() %>/reviewboard/insertComment.board",
			type:"POST",
			data: {
				boardNum : $("#boardNum").val(),
				userEmail : $("#userEmail").val(),
				content : $("#cmtCnt").val()
			},
			success:function() {
				alert("댓글이 작성되었습니다.")
				location.reload()
			},
		})
	<%
	}
	%>
})

<%-- $(".btn-reply").click(function(e) {
	e.preventDefault();
	$.ajax({
		url: "<%=request.getContextPath()%>/reviewboard/deleteComment.board",
		type:"POST",
		data: {
			commentNum : $('.commentNum').val(),
			boardNum : $('.boardNum').val()
		},
		sucess:function() {
			alert("댓글이 삭제되었습니다.");
			location.reload();
		},
	})
}) --%>

<%-- $(".comments-area").on('click', ".deleteBtn", function(e) {
	e.preventDefault();			// url에 # 생기는 것 방지
	$.ajax({
		url: "<%=request.getContextPath()%>/reviewboard/deleteComment.board",
		type:"GET",
		data: {
			commentNum : $("#commentNum").val(),
			boardNum : $("#boardNum").val()
		},
		sucess:function() {
			alert("댓글이 삭제되었습니다.");
			location.reload();
		},
	})
}) --%>

function reDelCheck(commentIdx, boardIdx) {
	var query = {commentIdx : commentIdx, boardIdx : boardIdx};
	var ans = confirm("선택하신 댓글을 삭제하시겠습니까?");
	if(!ans)
		return false;
	
	$.ajax({
		url: "<%=request.getContextPath()%>/reviewboard/deleteComment.board",
		type:"GET",
		data : query,
		success:function(data) {
			alert("댓글이 삭제되었습니다.");
			location.reload();
		},
		error : function(data) {
			alert("댓글이 삭제되지 않았습니다.");
		}
	});
}


</script>

<%@ include file="/inc/bottom.jsp"%>