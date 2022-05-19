<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="kr.siat.model.MovieDTO"%>
  
    <%
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		list = (ArrayList<MovieDTO>) request.getAttribute("movieList");
	%>    
    <c:if test="${empty searchList }">
		<h2>검색 결과 데이터가 존재하지 않습니다.</h2>
	</c:if>
		<p>　</p>
		<p>　</p>
		<p>　</p>
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Movie Category</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              
              <li class="breadcrumb-item active" aria-current="page">영화목록</li>
            </ol>
          </nav>
				</div>
			</div>
    </div>
	  
  <section class="section-margin--small mb-5">
    <div class="container">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
          <div class="sidebar-categories">
            <div class="head">장르</div>
            <ul class="main-categories">
              <li class="common-filter">
                <form action="#">
                  <ul>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="action" name="brand"><label for="action">액션<span></span></label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="history" name="brand"><label for="history">역사<span></span></label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="sports" name="brand"><label for="sports">스포츠<span></span></label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="comedey" name="brand"><label for="comedey">코미디<span></span></label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="horror" name="brand"><label for="horror">공포<span></span></label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="SF" name="brand"><label for="SF">SF<span></span></label></li>                  
                  </ul>
                </form>
              </li>
            </ul>
          </div>
          <div class="sidebar-filter">
            <div class="top-filter-head">Product Filters</div>
            <div class="common-filter">
              <div class="head">배급사</div>
              <form action="#">
                <ul>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="company1" name="brand"><label for="company1">회사1<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="company2" name="brand"><label for="company2">화사2<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="company3" name="brand"><label for="company3">회사3<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="company4" name="brand"><label for="company4">회사4<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="company5" name="brand"><label for="company5">회사5<span></span></label></li>
                </ul>
              </form>
            </div>
            <div class="common-filter">
              <div class="head">국적</div>
              <form action="#">
                <ul>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="KOR" name="country"><label for="KOR">한국<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="USA" name="country"><label for="USA">미국<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="ENG" name="country"><label for="ENG">영국<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="FRA" name="country"><label for="FRA">프랑스<span></span></label></li>                 
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="JAP" name="country"><label for="JAP">일본<span></span></label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="HKG" name="country"><label for="HKG">홍콩<span></span></label></li>
                </ul>
              </form>
            </div>
            <div class="common-filter">
              <div class="head">Price</div>
              <div class="price-range-area">
                <div id="price-range"></div>
                <div class="value-wrapper d-flex">
                  <div class="price">Price:</div>
                  <span>$</span>
                  <div id="lower-value"></div>
                  <div class="to">to</div>
                  <span>$</span>
                  <div id="upper-value"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
          <!-- Start Filter Bar -->
          <div class="filter-bar d-flex flex-wrap align-items-center">
            <div class="sorting">
              <select>
                <option  ${param.sorting=="title"?"selected":""} value="title">제목</option>
                <option  ${param.sorting=="director"?"selected":""} value="director">감독</option>
                <option  ${param.sorting=="country"?"selected":""} value="country">국가</option>
              </select>
            </div>
            
            <div>
              <div class="input-group filter-bar-search">
              </div>
               
                <form class="form-inline my-2 my-lg-0" action="search.movie" method="POST">
      				<input class="form-control mr-sm-2" type="text" name="searchtext" placeholder="Search">
     				 <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
  				</form>
              
            </div>
          </div>
         
          <section class="lattest-product-area pb-40 category-list">
            <div class="row">                   
            <c:forEach var="movie" items="${searchList}">
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                <!-- 이미지 오버레이  -->
                  <div class="card-product__img">
              
                    <img class="card-img" src=  "<%=request.getContextPath()%>/inc/img/product/movieNum1.jpg">
                    <ul class="card-product__imgOverlay">
                     
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                      <li><button><i class="ti-heart"></i></button></li>
                    </ul>
                  </div>
                <div class="card-body">
                   <!-- 여기에 영화 목록 받아 오기 -->                
                   	
					<a href="detail.movie?num=${movie.movieNum}">${movie.movieTitle}</a>
                    <p>${movie.moviePrice}원</p>
             		<a class="button button-blog" href="watchmovie.movie?num=${movie.movieNum}">바로보기</a> 
                                                                      
                  </div>           
                </div>
              </div>
           	 </c:forEach> 
            </div>
           </section>

                       
            <%
              if(session.getAttribute("user_email")!=null) {
        	  if((Integer)session.getAttribute("user_type")==0) {
        	%>
          
            		<aside class="single_sidebar_widget author_widget">
                    <a class="btn btn-primary" href="insert.movie" role="button">영화 추가</a>
                    <div class="br"></div>
                    </aside>
           <%
        	 		 }
         			 }
         	 %>
         </div>
      </div>
    </div>
  </section>
 
<%@ include file="/inc/bottom.jsp"%>