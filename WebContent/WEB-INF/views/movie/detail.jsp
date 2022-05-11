<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>

    <%@page import="MovieModel.MovieDTO"%>
    
       <%
MovieDTO dto = new MovieDTO();
       
       
%>
    
    

<!-- ================ start banner area ================= -->	
	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Movie Detail</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="category.movie">목록 보기</a></li>             
            </ol>
          </nav>         
          <p>test</p>  
		</div>
 <!-- 여기에 영화 상세 정보? -->
   <p>test</p>  
   <h2>${movie.movieTitle}</h2>
   
   
   
   
   
   
			</div>   
			
    </div>
     
    
    
 
	</section>
	<!-- ================ end banner area ================= -->
	
	
	
	
	
	
	
	
<%@ include file="/inc/bottom.jsp"%>