<%@page import="kr.siat.model.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.siat.model.dramaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/inc/top.jsp"%>
<%@page import="java.util.ArrayList"%>


<%
List<CartDTO> list = (ArrayList<CartDTO>)request.getAttribute("cartList");
%>


	<header id="site-header">
		<div class="container">
			<h1>장바구니 <span>[</span> <em><a href="https://codepen.io/tag/rodeo-007" target="_blank">주문 목록을 확인해주세요.</a></em> <span class="last-span is-open">]</span></h1>
		</div>
	</header>

	<div class="container">

		<section id="cart"> 
			<c:forEach var="cartProduct" items="${cartList }">
				<article class="product">
					<header>
						<a class="remove" style="text-align:center;">
							<img src="http://www.astudio.si/preview/blockedwp/wp-content/uploads/2012/08/1.jpg" alt="">
	
							<h3>삭제</h3>
						</a>
					</header>
	
					<div class="content">
	
						<h1>${cartProduct.title }</h1>
						
						${cartProduct.content }
	
						<!-- <div title="You have selected this product to be shipped in the color yellow." style="top: 0" class="color yellow"></div> -->
						<div style="top: 43px" class="type small">${cartProduct.genre }</div>
					</div>
	
					<footer class="content">
						<span class="qt-minus">-</span>
						<span class="qt">1</span>
						<span class="qt-plus">+</span>
	
						<h2 class="full-price">${cartProduct.price } ￦</h2>
	
						<h2 class="price">${cartProduct.price } ￦</h2>
					</footer>
				</article>
			</c:forEach>

		</section>

	</div>

	<footer id="site-footer">
		<div class="container clearfix">

			<div class="left">
				<h2 class="subtotal">공급가액: <span>163.96</span>￦</h2>
				<h3 class="tax">부가세 (5%): <span>8.2</span>￦</h3>
				<!-- <h3 class="shipping">Shipping: <span>5.00</span>€</h3> -->
			</div>

			<div class="right">
				<h1 class="total">최종 결제 금액: <span>177.16</span>￦</h1>
				<a class="btn">결제하기</a>
			</div>

		</div>
	</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var check = false;

function changeVal(el) {
  var qt = parseFloat(el.parent().children(".qt").html());
  var price = parseFloat(el.parent().children(".price").html());
  var eq = Math.round(price * qt * 100) / 100;
  
  el.parent().children(".full-price").html( eq + "￦" );
  
  changeTotal();			
}

function changeTotal() {
  
  var price = 0;
  
  $(".full-price").each(function(index){
    price += parseFloat($(".full-price").eq(index).html());
  });
  
  price = Math.round(price * 100) / 100;
  var tax = Math.round(price * 0.05 * 100) / 100
  var shipping = parseFloat($(".shipping span").html());
  var fullPrice = Math.round((price + tax + shipping) *100) / 100;
  
  if(price == 0) {
    fullPrice = 0;
  }
  
  $(".subtotal span").html(price);
  $(".tax span").html(tax);
  $(".total span").html(fullPrice);
}

$(document).ready(function(){
  
  $(".remove").click(function(){
    var el = $(this);
    el.parent().parent().addClass("removed");
    window.setTimeout(
      function(){
        el.parent().parent().slideUp('fast', function() { 
          el.parent().parent().remove(); 
          if($(".product").length == 0) {
            if(check) {
              $("#cart").html("<h1>The shop does not function, yet!</h1><p>If you liked my shopping cart, please take a second and heart this Pen on <a href='https://codepen.io/ziga-miklic/pen/xhpob'>CodePen</a>. Thank you!</p>");
            } else {
              $("#cart").html("<h1>No products!</h1>");
            }
          }
          changeTotal(); 
        });
      }, 200);
  });
  
  $(".qt-plus").click(function(){
    $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);
    
    $(this).parent().children(".full-price").addClass("added");
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("added"); changeVal(el);}, 150);
  });
  
  $(".qt-minus").click(function(){
    
    child = $(this).parent().children(".qt");
    
    if(parseInt(child.html()) > 1) {
      child.html(parseInt(child.html()) - 1);
    }
    
    $(this).parent().children(".full-price").addClass("minused");
    
    var el = $(this);
    window.setTimeout(function(){el.parent().children(".full-price").removeClass("minused"); changeVal(el);}, 150);
  });
  
  window.setTimeout(function(){$(".is-open").removeClass("is-open")}, 1200);
  
  $(".btn").click(function(){
    check = true;
    $(".remove").click();
  });
});
</script>

<%@ include file="/inc/bottom.jsp"%>