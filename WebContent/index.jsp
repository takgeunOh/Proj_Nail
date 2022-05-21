<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>
	
<div class= "text-center">
	<p>　</p>
	<h1> 인기 영화 </h1>
	<p>　</p>
	<div class="jb-box">      
  	<iframe width="100%" height="100%" src="https://www.youtube.com/embed/XUhRA_ObaDo" 
		title="YouTube video player" frameborder="0" 
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
	</iframe>
      <div class="jb-text">     
      </div>
    </div>
	<p>　</p>
	<p>　</p>
	<p>　</p>
	
<h1> 인기 게시판 </h1>
	<p>　</p>
	<p>　</p>
	<p>　</p>
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<%=request.getContextPath()%>/inc/img/product/movieNum1.jpg" class="d-block w-70" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<%=request.getContextPath()%>/inc/img/product/movieNum2.jpg" class="d-block w-70" alt="...">
    </div>
    <div class="carousel-item">
      <img src="<%=request.getContextPath()%>/inc/img/product/movieNum2.jpg" class="d-block w-70" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
	<p>　</p>
	<p>　</p>
	<p>　</p>	
	<h1> 임시 임시 임시 </h1>
</div>
<%@ include file="/inc/bottom.jsp" %>