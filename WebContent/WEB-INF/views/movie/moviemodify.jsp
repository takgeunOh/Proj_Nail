<%@page import="kr.siat.model.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
list = (ArrayList<MovieDTO>) request.getAttribute("movieList");

MovieDTO dto = new MovieDTO();
dto = (MovieDTO) request.getAttribute("moviemodify");

//int num = (Integer)session.getAttribute("detailSessionNum");
//System.out.println("moviemodify.jsp num : " + num);




%>

<!-- ================ start banner area ================= -->

	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Movie Modify</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="category.movie">목록 보기</a></li>             
            </ol>
          </nav>         
         
  
		</div>
	</div>   			
    </div>
     
    
    
 
	</section>
<!-- ================ end banner area ================= -->

<div class="br">
	<div class="container">
		<form action="moviemodify.movie" method="POST">
							<input type="hidden" name="modifyNum" value="<%=dto.getMovieNum() %>"/>
							<div class="form-group">
								<label>영화 제목</label>
								<input type="text" name="modifyTitle" value="<%=dto.getMovieTitle() %>"/>
							</div>
							
							<div class="form-group">
								<label>영화 장르</label>
								<input type="text" name="modifyGenre" value="<%=dto.getMovieGenre() %>"/>
							</div>	
							<div class="form-group">
								<label>영화 감독</label>
								<input type="text" name="modifyDirector" value="<%=dto.getMovieDirector() %>"/>
							</div>
						
							<div class="form-group">
								<label>영화 내용</label>
								<textarea rows="10" cols="50" name="modifyContent" ><%=dto.getMovieContent() %></textarea>
							</div>
							
							<div class="form-group">
								<label>영화 개봉 연도</label>
								<input type="text" name="modifyYear" value="<%=dto.getMovieYear() %>"/>
							</div>
							
							<div class="form-group">
								<label>영화 가격</label>
								<input type="text" name="modifyPrice" value="<%=dto.getMoviePrice() %>"/>
							</div>
							
							<div class="form-group">
								<label>국가</label>
								<input type="text" name="modifyCountry" value="<%=dto.getMovieCountry() %>"/>
							</div>
							
							<div class="form-group">
								<label>배급사</label>
								<input type="text" name="modifyCompany" value="<%=dto.getMovieCompany() %>"/>
							</div>
							
							<div class="form-group">
								<label>영화 숨김 여부</label>
								<input type="text" name="modifyHide" value="<%=dto.getMovieHide() %>"/>
							</div>
							
							<div class="form-group">
								<label>연령</label>
								<input type="text" name="modifyAge" value="<%=dto.getMovieAge() %>"/>
							</div>
							
							
							
							<%-- <input type="text" name="modifyTitle" value="<%=dto.getBoardTitle() %>"> --%>
							<%-- <p class="excert"><textarea rows="10" cols="50" name="modifyContent" ><%=dto.getBoardContent() %></textarea></p> --%>
							<input type="submit" value="수정하기" />
							<input type="reset" value="입력 초기화" />
						</form>
	</div>
</div>





<%@ include file="/inc/bottom.jsp"%>