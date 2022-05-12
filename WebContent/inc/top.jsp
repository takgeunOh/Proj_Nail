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

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/inc/css/style.css">
</head>
<body>
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<a class="navbar-brand logo_h" href="<%=request.getContextPath()%>/index.jsp"><img
						src="${pageContext.request.contextPath }/inc/img/logo.png" alt=""></a>
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
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Home</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">영화</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/movie/category.movie">영화 목록</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/movie/detail.movie">영화 상세보기</a></li>
									<li class="nav-item"><a class="nav-link"
										href="checkout.html">Product Checkout</a></li>
									<li class="nav-item"><a class="nav-link"
										href="confirmation.html">Confirmation</a></li>
									<li class="nav-item"><a class="nav-link" href="cart.html">Shopping Cart</a></li>
								</ul>
							</li>
							
								<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">드라마</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/drama/category.drama">드라마 목록</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/drama/detail.drama">드라마 상세보기</a></li>
									<li class="nav-item"><a class="nav-link"
										href="checkout.html">Product Checkout</a></li>
									<li class="nav-item"><a class="nav-link"
										href="confirmation.html">Confirmation</a></li>
									<li class="nav-item"><a class="nav-link" href="cart.html">Shopping Cart</a></li>
								</ul>
							</li>
							
							
							
							
							
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Board</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="<%=request.getContextPath()%>/bbs/list.board">Hot
											issue</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-blog.html">자유게시판</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Login</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">로그인</a></li>
									<li class="nav-item"><a class="nav-link"
										href="register.html">회원가입</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking-order.html">Tracking</a></li>
								</ul>
							</li>
							<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a></li>
						</ul>

						<ul class="nav-shop">
							<li class="nav-item"><button>
									<i class="ti-search"></i>
								</button></li>
							<li class="nav-item"><button>
									<i class="ti-shopping-cart"></i><span class="nav-shop__circle">3</span>
								</button></li>
							<li class="nav-item"><a class="button button-header"
								href="#">Buy Now</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->