<%@page import="model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
BoardDTO dto = new BoardDTO();
dto = (BoardDTO) request.getAttribute("boardmodify");

int num = (Integer)session.getAttribute("detailSessionNum");
System.out.println("modify.jsp num : " + num);

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
								<li><a href="#">06 Comments <i class="lnr lnr-bubble"></i>
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
						<form action="modify.board" method="POST">
							<input type="hidden" name="modifyNum" value="<%=dto.getBoardNum() %>"/>
							<div class="form-group">
								<label>글 제목</label>
								<input type="text" name="modifyTitle" value="<%=dto.getBoardTitle() %>"/>
							</div>
							<div class="form-group">
								<label>글 내용</label>
								<textarea rows="10" cols="50" name="modifyContent" ><%=dto.getBoardContent() %></textarea>
							</div>
							<div class="form-group">
								<label>패스워드</label>
								<input type="password" name="modifyPassword" value=""/>
							</div>
							<%-- <input type="text" name="modifyTitle" value="<%=dto.getBoardTitle() %>"> --%>
							<%-- <p class="excert"><textarea rows="10" cols="50" name="modifyContent" ><%=dto.getBoardContent() %></textarea></p> --%>
							<input type="submit" value="수정하기" />
							<input type="reset" value="입력 초기화" />
						</form>
					</div>
					
					
					
					
					<div class="col-lg-12">
						<div class="quotes">MCSE boot camps have its supporters and
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
						</div>
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
				<div class="comments-area">
					<h4>05 Comments</h4>
					<div class="comment-list">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/c1.jpg"
										alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Emilly Blunt</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>
							<div class="reply-btn">
								<a href="#" class="btn-reply text-uppercase">reply</a>
							</div>
						</div>
					</div>
					<div class="comment-list left-padding">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/c2.jpg"
										alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Elsie Cunningham</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>
							<div class="reply-btn">
								<a href="#" class="btn-reply text-uppercase">reply</a>
							</div>
						</div>
					</div>
					<div class="comment-list left-padding">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/c3.jpg"
										alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Annie Stephens</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>
							<div class="reply-btn">
								<a href="#" class="btn-reply text-uppercase">reply</a>
							</div>
						</div>
					</div>
					<div class="comment-list">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/c4.jpg"
										alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Maria Luna</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>
							<div class="reply-btn">
								<a href="#" class="btn-reply text-uppercase">reply</a>
							</div>
						</div>
					</div>
					<div class="comment-list">
						<div class="single-comment justify-content-between d-flex">
							<div class="user justify-content-between d-flex">
								<div class="thumb">
									<img
										src="${pageContext.request.contextPath }/inc/img/blog/c5.jpg"
										alt="">
								</div>
								<div class="desc">
									<h5>
										<a href="#">Ina Hayes</a>
									</h5>
									<p class="date">December 4, 2017 at 3:12 pm</p>
									<p class="comment">Never say goodbye till the end comes!</p>
								</div>
							</div>
							<div class="reply-btn">
								<a href="#" class="btn-reply text-uppercase">reply</a>
							</div>
						</div>
					</div>
				</div>
				<div class="comment-form">
					<h4>Leave a Reply</h4>
					<form>
						<div class="form-group form-inline">
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
						</div>
						<div class="form-group">
							<textarea class="form-control mb-10" rows="5" name="message"
								placeholder="Messege" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Messege'" required=""></textarea>
						</div>
						<a href="#" class="button button-postComment button--active">Post
							Comment</a>
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
						<a class="btn btn-warning" href="modify.board" role="button">수정</a>
						<a class="btn btn-danger" href="delete.board" role="button">삭제</a>
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




<%@ include file="/inc/bottom.jsp"%>