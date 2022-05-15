<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>

    <%@page import="kr.siat.model.MovieDTO"%>
    
       <%
MovieDTO dto = new MovieDTO();
       if("GET".equals(request.getMethod())) {
    		dto = (MovieDTO) request.getAttribute("moviewatch");

    		session.setAttribute("MoviveSessionNum", dto.getMovieNum());
    	} else if("POST".equals(request.getMethod())) {
    		dto = (MovieDTO) request.getAttribute("movieaftermodify");
    	}
       
%>
    
    

<!-- ================ start banner area ================= -->	
	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>watch movie</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
                      
            </ol>
          </nav>         
          <p>test watch test movie</p>  
  
		</div>
 <!-- 여기에 영화 상세 정보? -->
  				<div class="text-center">
  				 <h2>${movie.movieTitle}</h2>
   			<div class="col-lg-9 col-md-9 movie_details"  > 
						<h2><%=dto.getMovieTitle() %></h2>
									<!-- 서브타이틀 정도로 쓰기 -->
					</div>
   
 <a class="button button-blog" >다운로드</a>
   
   
   
  </div>
   
   
   
			</div>   
			
    </div>
     
    
    
 
	</section>
	<!-- ================ end banner area ================= -->
	
	
	
	
	
	
	
	
<%@ include file="/inc/bottom.jsp"%>