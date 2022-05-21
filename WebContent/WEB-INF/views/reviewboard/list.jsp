<%@page import="kr.siat.model.BoardDAO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
list = (ArrayList<BoardDTO>) request.getAttribute("boardList");
BoardDAO dao = new BoardDAO();
%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="blog">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>리뷰게시판</h1>
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

<!--================Blog Categorie Area =================-->
<section class="blog_categorie_area">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
				<div class="categories_post">
					<img class="card-img rounded-0"
						src="${pageContext.request.contextPath }/inc/img/blog/cat-post/cat-post-3.jpg"
						alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="single-blog.html">
								<h5>베스트 리뷰평1</h5>
							</a>
							<div class="border_line"></div>
							<p>베스트 리뷰평1</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
				<div class="categories_post">
					<img class="card-img rounded-0"
						src="${pageContext.request.contextPath }/inc/img/blog/cat-post/cat-post-2.jpg"
						alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="single-blog.html">
								<h5>베스트 리뷰평2</h5>
							</a>
							<div class="border_line"></div>
							<p>베스트 리뷰평2</p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-lg-4 mb-4 mb-lg-0">
				<div class="categories_post">
					<img class="card-img rounded-0"
						src="${pageContext.request.contextPath }/inc/img/blog/cat-post/cat-post-1.jpg"
						alt="post">
					<div class="categories_details">
						<div class="categories_text">
							<a href="single-blog.html">
								<h5>베스트 리뷰평3</h5>
							</a>
							<div class="border_line"></div>
							<p>베스트 리뷰평3</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Blog Categorie Area =================-->


<section class="blog_area">
	<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="blog_left_sidebar">
					<c:forEach var="board" items="${boardList }">
						<!-- 추후에 c:if를 이용해서 좋아요 개수가 N개 이상인 게시글만 출력되도록 할 것. -->
						<article class="row blog_item">
							<div class="col-md-3">
								<div class="blog_info text-right">
									<div class="post_tag">
										<a href="#">액션,</a> <a href="#">코미디,</a>
										<a href="#">스릴,</a> <a href="#">공포</a>
									</div>
									<ul class="blog_meta list">
										<li><a href="#">${board.author}<i
												class="lnr lnr-user"></i></a></li>
										<li><a href="#">${board.regidate }<i
												class="lnr lnr-calendar-full"></i></a></li>
										<li><a href="#">${board.viewCnt }<i
												class="lnr lnr-eye"></i></a></li>
										<li><a href="#"> 
										<%
											 BoardDTO dto = (BoardDTO) pageContext.getAttribute("board");
											 int num = dto.getNum();
											 int commetCount = dao.getCommentCount(num);
										%> 	<%=commetCount%> Comments
											<i class="lnr lnr-bubble"></i>
										</a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-9">
								<div class="blog_post">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/main-blog/m-blog-1.jpg"
										alt="">
									<div class="blog_details">
										<a href="single-blog.html">
											<h2>
												<a href="detail.board?num=${board.num }">${board.title }</a>
											</h2>
										</a>
										<p>${board.content }</p>
										<a class="button button-blog"
											href="detail.board?num=${board.num }">View More</a>
									</div>
								</div>
							</div>
						</article>
					</c:forEach>

					<nav class="blog-pagination justify-content-center d-flex">
						<ul class="pagination">
							<li class="page-item"><a href="#" class="page-link"
								aria-label="Previous"> <span aria-hidden="true"> <span
										class="lnr lnr-chevron-left"></span>
								</span>
							</a></li>
							<li class="page-item"><a href="#" class="page-link">01</a></li>
							<li class="page-item active"><a href="#" class="page-link">02</a>
							</li>
							<li class="page-item"><a href="#" class="page-link">03</a></li>
							<li class="page-item"><a href="#" class="page-link">04</a></li>
							<li class="page-item"><a href="#" class="page-link">09</a></li>
							<li class="page-item"><a href="#" class="page-link"
								aria-label="Next"> <span aria-hidden="true"> <span
										class="lnr lnr-chevron-right"></span>
								</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="blog_right_sidebar">
					<aside class="single_sidebar_widget author_widget">
						<a id="writeBtn" class="btn btn-primary" href="javascript:void(0)" role="button">글쓰기</a>
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget search_widget">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">
									<i class="lnr lnr-magnifier"></i>
								</button>
							</span>
						</div>
						<!-- /input-group -->
						<div class="br"></div>
					</aside>
					<%-- <aside class="single_sidebar_widget popular_post_widget">
						<h3 class="widget_title">Popular Posts</h3>
						<div class="media post_item">
							<img
								src="${pageContext.request.contextPath }/inc/img/blog/popular-post/post1.jpg"
								alt="post">
							<div class="media-body">
								<a href="single-blog.html">
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
								<a href="single-blog.html">
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
								<a href="single-blog.html">
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
								<a href="single-blog.html">
									<h3>Asteroids telescope</h3>
								</a>
								<p>01 Hours ago</p>
							</div>
						</div>
						<div class="br"></div>
					</aside> --%>
					<aside class="single_sidebar_widget ads_widget">
						<%-- <a href="#"> <img class="img-fluid"
							src="${pageContext.request.contextPath }/inc/img/blog/add.jpg"
							alt="">
						</a> --%>
						<div class="br"></div>
					</aside>
					<aside class="single_sidebar_widget post_category_widget">
						<h4 class="widget_title">영화 카테고리</h4>
						<ul class="list cat-list">
							<li><a href="#" class="d-flex justify-content-between">
									<p>액션</p>
									<p>37</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>역사</p>
									<p>24</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>스포츠</p>
									<p>59</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>코미디</p>
									<p>29</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>공포</p>
									<p>15</p>
							</a></li>
							<li><a href="#" class="d-flex justify-content-between">
									<p>SF</p>
									<p>09</p>
							</a></li>
						</ul>
						<div class="br"></div>
					</aside>
					<!-- <aside class="single-sidebar-widget newsletter_widget">
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
					</aside> -->
					<!-- <aside class="single-sidebar-widget tag_cloud_widget">
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
					</aside> -->
				</div>
			</div>
		</div>
	</div>
</section>

<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>

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
		location.href="<%=request.getContextPath() %>/reviewboard/insert.board?email=" + sessionStorage.getItem("user_email");
	<%
	}
	%>
})

</script>



<%@ include file="/inc/bottom.jsp"%>