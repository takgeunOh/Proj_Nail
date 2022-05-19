<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="/inc/top.jsp"%>
    <%@page import="java.util.ArrayList"%>

    <%@page import="kr.siat.model.dramaDTO"%>
    
       <%
			dramaDTO dto = new dramaDTO();
       		if("GET".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("dramadetail");
    		session.setAttribute("DramaSessionNum", dto.getDramaNum());
    		} else if("POST".equals(request.getMethod())) {
    		dto = (dramaDTO) request.getAttribute("dramaaftermodify");
    		}
       
		%>
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>드라마 정보</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="category.drama">목록 보기</a></li>             
            </ol>
          </nav>          
		</div>
  				<div class="text-center">
  				<img src="<%=request.getContextPath()%>/inc/img/product/movieNum2.jpg" class="center" >
  				 <h2>${drama.dramaTitle}</h2>   			
						<h2><%=dto.getDramaTitle() %></h2>
						<p class="excert">장르 : <%=dto.getDramaGenre() %>  / <%=dto.getDramaAge() %>세 관람가</p>
						<p class="excert"> 개봉 :<%=dto.getDramaYear() %> / 감독:<%=dto.getDramaDirector() %></p>
						<p class="excert">배급:<%=dto.getDramaCompany() %> / 국가:<%=dto.getDramaCountry() %></p>
						<p>　</p>
						<p>줄거리</p>
						<p class="excert"><%=dto.getDramaContent() %></p>				
 		 			</div>
				</div>   			
   			 </div>
		    <%
              if(session.getAttribute("user_email")!=null) {
        	  if((Integer)session.getAttribute("user_type")==0) {
        	%>          
            	<aside class="single_sidebar_widget author_widget">
               	<a class="btn btn-primary" href="dramamodify.drama?num=<%=dto.getDramaNum() %>" role="button">수정</a>
			 	<div class="br"></div>
            	</aside>                                   
                  <%       	  }          }          %>
                  	
<%@ include file="/inc/bottom.jsp"%>