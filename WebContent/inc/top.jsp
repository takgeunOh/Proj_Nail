<%@page import="kr.siat.model.MovieCartDAO"%>
<%@page import="kr.siat.model.MovieCartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>NailKang Shop - Home</title>
<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
<link rel="icon"
	href="${pageContext.request.contextPath }/inc/img/Fevicon.png"
	type="image/png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/fontawesome/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/themify-icons/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/nice-select/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/vendors/owl-carousel/owl.carousel.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath }/inc/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/subscribe.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/inc/css/membership.css">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/deleteStyle.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css"> --%>

</head>
<body>
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<a class="navbar-brand logo_h" href="<%=request.getContextPath()%>/index.jsp"><img src="${pageContext.request.contextPath }/inc/img/NailKang_logo_resize.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto mr-auto">
							<!-- <li class="nav-item active"> -->
							<li class="nav-item active">
								<a class="nav-link" href="<%=request.getContextPath() %>/index.jsp">홈</a>
							</li>
                     <li class="nav-item submenu dropdown"><a href="#"
                        class="nav-link dropdown-toggle" data-toggle="dropdown"
                        role="button" aria-haspopup="true" aria-expanded="false" >영화</a>
                        <ul class="dropdown-menu">
                           <li class="nav-item"><a class="nav-link"
                              href="<%=request.getContextPath()%>/movie/category.movie">영화 목록</a></li>                                        
                           <%-- <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/movie/cart.cart">Shopping Cart</a></li> --%>
                        </ul>
                    	</li>
                        <li class="nav-item submenu dropdown"><a href="#"
                        class="nav-link dropdown-toggle" data-toggle="dropdown"
                        role="button" aria-haspopup="true" aria-expanded="false">드라마</a>
                        <ul class="dropdown-menu">
                           <li class="nav-item"><a class="nav-link"
                              href="<%=request.getContextPath()%>/drama/category.drama">드라마 목록</a></li>
                          
                           <%-- <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/drama/cart.cart">Shopping Cart</a></li> --%>
                        </ul>
                     </li>
                     
                     
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">게시판</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/reviewboard/list.board">리뷰게시판</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/feedbackboard/list.board">문의게시판</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">가격 정책</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/priceInfo/membershipInfo.member">멤버쉽 안내</a></li>
									<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/priceInfo/downloadInfo.member">다운로드 안내</a></li>
								</ul>
							</li>
							<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/contact.jsp">문의상담</a></li>
						</ul>

						<ul class="nav-shop" style="margin:0px;">
							<!-- <li class="nav-item">
								<button><i class="ti-search"></i></button>
							</li> -->
							<li class="nav-item" style="margin:0px;">
								<button onclick="location.href='<%=request.getContextPath()%>/cart/cartInfo.cart'">
									<i class="ti-shopping-cart"></i>
									<%
									ArrayList<MovieCartDTO> top_list = new ArrayList<MovieCartDTO>();
									MovieCartDAO movieCartDAO = new MovieCartDAO();
									top_list = movieCartDAO.getList();
									%>
									<span class="nav-shop__circle"><%=movieCartDAO.getCountCartList(top_list) %></span>
								</button>
							</li>
							
							<%
							if(session.getAttribute("user_email")==null) {
							%>
								<li class="nav-item" style="padding:10px 10px; margin:0px 0px"><a class="button button-header"
								href="<%=request.getContextPath()%>/member/login.member">Login</a></li>
							<%
							} else {
								if((Integer)session.getAttribute("user_type")==0) {
							%>
									<li class="nav-item" style="padding:10px 10px; margin:0px 0px">
										<a class="button button-header" href="<%=request.getContextPath()%>/member/logout.member">[관리자] Logout</a>
									</li>
							<%	
								} else if ((Integer)session.getAttribute("user_type")==1) {
							%>
									
									<li class="nav-item" style="padding:10px 10px; margin:0px 0px">
										<a class="button button-header" href="<%=request.getContextPath()%>/member/logout.member">[일반회원] Logout</a>
									</li>
							<%
								} else if ((Integer)session.getAttribute("user_type")==2) {
							%>
									<li class="nav-item" style="padding:10px 10px; margin:0px 0px">
										<a class="button button-header" href="<%=request.getContextPath()%>/member/logout.member">[구독회원] Logout</a>
									</li>
							<%
								}
							}
							%>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->