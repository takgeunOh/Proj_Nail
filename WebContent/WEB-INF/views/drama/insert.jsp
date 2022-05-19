<%@page import="kr.siat.model.dramaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	ArrayList<dramaDTO> list = new ArrayList<dramaDTO>();
list = (ArrayList<dramaDTO>) request.getAttribute("dramaList");
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
	</div>   			
    </div>
     
    
    
 
	</section>
<!-- ================ end banner area ================= -->

<div class="br">
	<div class="container">
		<form action="insert.movie" method="post">
			<div class="form-group">
				<label for="subject">제목</label> <input type="text"
					class="form-control" id="title" name="title"
					placeholder="제목을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="writer">장르</label> <input type="text"
					class="form-control" id="genre" name="genre"
					placeholder="내용을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="writer">감독</label> <input type="text"
					class="form-control" id="director" name="director"
					placeholder="비밀번호를 입력하세요.">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="content" rows="5"></textarea>
			</div>
			
			<div class="form-group">
				<label for="writer">연도</label> <input type="text"
					class="form-control" id="year" name="year"
					placeholder="연도를 입력하세요.">
			</div>
			
			<div class="form-group">
				<label for="writer">가격</label> <input type="text"
					class="form-control" id="price" name="price"
					placeholder="가격을 입력하세요.">
			</div>
			
			<div class="form-group">
				<label for="writer">국가</label> <input type="text"
					class="form-control" id="country" name="country"
					placeholder="국가를 입력하세요.">
			</div>
			
			<div class="form-group">
				<label for="writer">배급사</label> <input type="text"
					class="form-control" id="company" name="company"
					placeholder="배급사를 입력하세요.">
			</div>
			
			<div class="form-group">
				<label for="writer">숨김여부</label> <input type="text"
					class="form-control" id="hide" name="hide"
					placeholder="숨김여부를 입력하세요 .">
			</div>
			
			<div class="form-group">
				<label for="writer">연령</label> <input type="text"
					class="form-control" id="age" name="age"
					placeholder="제한 연령을 입력하세요.">
			</div>
			
			<button type="submit" class="btn btn-primary">작성</button>
		</form>
	</div>
</div>





<%@ include file="/inc/bottom.jsp"%>