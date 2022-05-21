<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="kr.siat.model.MovieDTO"%>
    
    <%MovieDTO dto = new MovieDTO();
       	if("GET".equals(request.getMethod())) {
    		dto = (MovieDTO) request.getAttribute("moviedetail");
    		session.setAttribute("MoviveSessionNum", dto.getMovieNum());
    		} else if("POST".equals(request.getMethod())) {
    		dto = (MovieDTO) request.getAttribute("movieaftermodify");
    	} %>
	
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center" >
					<h2 >영화 정보</h2>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">          
           				 <ol class="breadcrumb">
             			 <li class="breadcrumb-item"><a href="category.movie">목록 보기</a>
            		  </li>             
          				  </ol>
         			 </nav>              
				
				</div>
 <!-- 여기에 영화 상세 정보 -->
	<div class="text-center">
	 	<img src="<%=request.getContextPath()%>/inc/img/product/movieNum1.jpg" class="center" >
  			<h2>${movie.movieTitle}</h2>   					
							<h2><%=dto.getMovieTitle() %></h2>
							<p align="center" class="excert">장르 : <%=dto.getMovieGenre()%> /  <%=dto.getMovieAge() %>세 관람가   </p>  
							<p class="excert"> 개봉 :<%=dto.getMovieYear() %> / 감독:<%=dto.getMovieDirector() %></p>                   						
							<p class="excert">배급:<%=dto.getMovieCompany() %> / 국가:<%=dto.getMovieCountry() %></p>
							<p>　</p>
							<p> 줄거리 </p>
							<p class="excert"><%=dto.getMovieContent() %></p>									   				 
  				 </div> 
			</div>   								
    	</div>
	   	 <%
         	  if(session.getAttribute("user_email")!=null) {
        	  if((Integer)session.getAttribute("user_type")==0) {
         %>          
            		<aside class="single_sidebar_widget author_widget">
                    <a class="btn btn-primary" href="moviemodify.movie?num=<%=dto.getMovieNum() %>" role="button">수정</a>
                    <div class="br"></div>
                    </aside>                                       
                  <%       	  }          }          %>
	
<%@ include file="/inc/bottom.jsp"%>