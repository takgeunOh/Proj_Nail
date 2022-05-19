<%@page import="kr.siat.model.dramaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
list = (ArrayList<dramaDTO>) request.getAttribute("dramaList");

dramaDTO dto = new dramaDTO();
dto = (dramaDTO) request.getAttribute("dramamodify");

//int num = (Integer)session.getAttribute("detailSessionNum");
//System.out.println("moviemodify.jsp num : " + num);




%>

<!-- ================ start banner area ================= -->

	<section class="blog-banner-area" id="category">
		<div class="container h-100">
			<div class="blog-banner">
				<div class="text-center">
					<h1>Drama Modify</h1>
					<nav aria-label="breadcrumb" class="banner-breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="category.drama">목록 보기</a></li>             
            </ol>
          </nav>         
         
  
		</div>
	</div>   			
    </div>
     
    
    
 
	</section>
<!-- ================ end banner area ================= -->

<div class="br">
	<div class="container">
		<form action="dramamodify.drama" method="POST">
							<input type="hidden" name="modifyNum" value="<%=dto.getDramaNum() %>"/>
							<div class="form-group">
								<label>드라마 제목</label>
								<input type="text" name="modifyTitle" value="<%=dto.getDramaTitle() %>"/>
							</div>
							
							<div class="form-group">
								<label>드라마 장르</label>
								<input type="text" name="modifyGenre" value="<%=dto.getDramaGenre() %>"/>
							</div>	
							<div class="form-group">
								<label>드라마 감독</label>
								<input type="text" name="modifyDirector" value="<%=dto.getDramaDirector() %>"/>
							</div>
						
							<div class="form-group">
								<label>드라마 내용</label>
								<textarea rows="10" cols="50" name="modifyContent" ><%=dto.getDramaContent() %></textarea>
							</div>
							
							<div class="form-group">
								<label>방영 연도</label>
								<input type="text" name="modifyYear" value="<%=dto.getDramaYear() %>"/>
							</div>
							
							<div class="form-group">
								<label>가격</label>
								<input type="text" name="modifyPrice" value="<%=dto.getDramaPrice() %>"/>
							</div>
							
							<div class="form-group">
								<label>국가</label>
								<input type="text" name="modifyCountry" value="<%=dto.getDramaCountry() %>"/>
							</div>
							
							<div class="form-group">
								<label>배급사</label>
								<input type="text" name="modifyCompany" value="<%=dto.getDramaCompany() %>"/>
							</div>
							
							<div class="form-group">
								<label>숨김 여부</label>
								<input type="text" name="modifyHide" value="<%=dto.getDramaHide() %>"/>
							</div>
							
							<div class="form-group">
								<label>연령</label>
								<input type="text" name="modifyAge" value="<%=dto.getDramaAge() %>"/>
							</div>
							
							
							
							<%-- <input type="text" name="modifyTitle" value="<%=dto.getBoardTitle() %>"> --%>
							<%-- <p class="excert"><textarea rows="10" cols="50" name="modifyContent" ><%=dto.getBoardContent() %></textarea></p> --%>
							<input type="submit" value="수정하기" />
							<input type="reset" value="입력 초기화" />
						</form>
	</div>
</div>





<%@ include file="/inc/bottom.jsp"%>