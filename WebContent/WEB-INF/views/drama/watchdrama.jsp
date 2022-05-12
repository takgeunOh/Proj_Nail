<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>

    <%@page import="DramaModel.dramaDTO"%>
    
       <%
dramaDTO dto = new dramaDTO();
       if("GET".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("dramawatch");

    		session.setAttribute("DramaSessionNum", dto.getDramaNum());
    	} else if("POST".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("Dramaaftermodify");
    	}
       
%>
    
    

<!-- ================ start banner area ================= -->	
	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>watch drama</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
                      
            </ol>
          </nav>         
          <p>test watch test rama</p>  
  
		</div>
 <!-- 여기에 영화 상세 정보? -->
  				<div class="text-center">
  				 <h2>${drama.movieTitle}</h2>
   			<div class="col-lg-9 col-md-9 drama_details"  > 
						<h2><%=dto.getDramaTitle() %></h2>
									<!-- 서브타이틀 정도로 쓰기 -->
					</div>
   
 <a class="button button-blog" >다운로드</a>
   
   
   
  </div>
   
   
   
			</div>   
			
    </div>
     
    
    
 
	</section>
	<!-- ================ end banner area ================= -->
	
	
	
	
	
	
	
	
<%@ include file="/inc/bottom.jsp"%>