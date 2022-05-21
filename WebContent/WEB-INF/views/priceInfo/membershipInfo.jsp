<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- partial:index.partial.html -->
<div class="pricingTable">
	<h2 class="pricingTable-title">원하는 멤버쉽을 선택하세요.</h2>
	<h3 class="pricingTable-subtitle">모든 요금제는 첫 결제 시 30일 무료 체험이 주어집니다.</h3>

	<ul class="pricingTable-firstTable">
		<li class="pricingTable-firstTable_table">
			<h1 class="pricingTable-firstTable_table__header">베이직</h1>
			<p class="pricingTable-firstTable_table__pricing">
				<span>￦</span><span>5,500</span><span>Month</span>
			</p>
			<ul class="pricingTable-firstTable_table__options">
				<li>무제한 시청</li>
				<li>시청기록 저장</li>
				<li>게시판 이용 가능</li>
			</ul>
			<button class="pricingTable-firstTable_table__getstart" onclick="location.href='checkout.cart'">결제하기</button>
			<%-- <a href="javascript:moveToPayments(<%=0 %>, ${comment.comment_board });" class="btn-reply text-uppercase" style="color:red">delete</a> --%>
		</li>
		
		<li class="pricingTable-firstTable_table">
			<h1 class="pricingTable-firstTable_table__header">스탠다드</h1>
			<p class="pricingTable-firstTable_table__pricing">
				<span>￦</span><span>6,700</span><span>Month</span>
			</p>
			<ul class="pricingTable-firstTable_table__options">
				<li>무제한 시청</li>
				<li>시청기록 저장</li>
				<li>게시판 이용 가능</li>
				<li>모바일 디바이스 지원</li>
				<li>백그라운드 재생 가능</li>
			</ul>
			<button class="pricingTable-firstTable_table__getstart" onclick="location.href='checkout.cart'">결제하기</button>
		</li>
		
		<li class="pricingTable-firstTable_table">
			<h1 class="pricingTable-firstTable_table__header">프리미엄</h1>
			<p class="pricingTable-firstTable_table__pricing">
				<span>￦</span><span>7,300</span><span>Month</span>
			</p>
			<ul class="pricingTable-firstTable_table__options">
				<li>무제한 시청</li>
				<li>시청기록 저장</li>
				<li>게시판 이용 가능</li>
				<li>모바일 디바이스 지원</li>
				<li>백그라운드 재생 가능</li>
				<li>문의 상담 최우선 배정</li>
				<li>매달 1회 무료 다운로드 가능</li>
			</ul>
			<button class="pricingTable-firstTable_table__getstart" onclick="location.href='checkout.cart'">결제하기</button>
		</li>
	</ul>
</div>
<!-- partial -->
<script src="./script.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>

function addSubscribeCart(choice) {
	/* console.log(a); */
	$.ajax({
		url: "<%=request.getContextPath()%>/cart/checkout.cart",
		type : "GET",
		data : {
			choice : choice
		},
		/* success : function() {
			alert("장바구니에 추가되었습니다.")
		}, */
	});
}
</script>

<%@ include file="/inc/bottom.jsp"%>
