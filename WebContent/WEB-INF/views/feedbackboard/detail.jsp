<%@page import="kr.siat.model.FeedbackDTO"%>
<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
FeedbackDTO dto = (FeedbackDTO)request.getAttribute("feedbackDto");
%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>문의 상세보기</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">게시판</a></li>
						<li class="breadcrumb-item active" aria-current="page">문의 게시판</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->

<h1>건의게시판</h1>
<div id="bbs">
    <table>
    <tr>
        <th style="width: 50px;">TITLE</th>
        <th style="text-align: left;color: #555;"><%=dto.getTitle() %></th>
        <th style="width: 50px;">DATE</th>
        <th style="width: 130px;color: #555;"><%=dto.getRegidate() %></th>
    </tr>  
    </table>
   
    <div id="gul-content">
        <h6>작성자 <%=dto.getAuthor() %>, 조회수 <%=dto.getViewcnt() %></h6>
        <p><%=dto.getContent() %></p>
 
    </div>
    
    <div id="list-menu" style="text-align:  right;">
        <input type="button" value="새글쓰기" onclick="goWrite()" />
    </div>
 
    <%-- <div id="view-menu">
        <div class="fl">
            <input type="button" value="수정" onclick="goModify();" />
            <input type="button" value="삭제" onclick="goDelete()" />
        </div>
        <div class="fr">           
            <input type="button" value="목록" onclick="goList()" />
            <input type="button" value="새글쓰기" onclick="goWrite()" />
        </div>     
    </div>
     
    <table>
    <tr>
        <th style="width: 60px;">NO</th>
        <th>TITLE</th>
        <th style="width: 84px;">DATE</th>
        <th style="width: 60px;">HIT</th>
    </tr>
    <!--  반복 구간 시작 -->
    <c:forEach var="article" items="${list }" varStatus="status">  
    <tr>
        <td style="text-align: center;">${article.articleNo }</td>
        <td>
            <a href="javascript:goView('${article.articleNo }')">${article.title }</a>
        </td>
        <td style="text-align: center;">${article.writeDate }</td>
        <td style="text-align: center;">${article.hit }</td>
    </tr>
    </c:forEach>
    <!--  반복 구간 끝 -->
    </table>
</div> --%>
<!--  본문 끝 -->


<%@ include file="/inc/bottom.jsp"%>