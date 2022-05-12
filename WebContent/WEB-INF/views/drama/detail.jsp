<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>

    <%@page import="DramaModel.dramaDTO"%>
    
       <%
dramaDTO dto = new dramaDTO();
       if("GET".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("dramadetail");

    		session.setAttribute("DramaSessionNum", dto.getDramaNum());
    	} else if("POST".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("dramaaftermodify");
    	}
       
%>
    
    

<!-- ================ start banner area ================= -->	
	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Drama Detail</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="category.drama">목록 보기</a></li>             
            </ol>
          </nav>         
          <p>test</p>  
  
		</div>
 <!-- 여기에 영화 상세 정보? -->
  				<div class="text-center">
  				 <h2>${drama.dramaTitle}</h2>
   			<div class="col-lg-9 col-md-9 drama_details"  > 
						<h2><%=dto.getDramaTitle() %></h2>
						<p class="excert"><%=dto.getDramaGenre() %>               <%=dto.getDramaYear() %></p>
						<p class="excert"><%=dto.getDramaDirector() %></p>
						<p class="excert"><%=dto.getDramaAge() %>세 관람가</p>
						<p class="excert"><%=dto.getDramaContent() %></p>					<!-- 서브타이틀 정도로 쓰기 -->
					</div>
   
  </div>
   
   
   
			</div>   
			
    </div>
     
    
    
 
	</section>
	<!-- ================ end banner area ================= -->
	
	
	
	
	
	
	
	
<%@ include file="/inc/bottom.jsp"%>