<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category" style="height:40vh;">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>회원가입</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">회원가입을 통해 더 많은 혜택을 누리세요.</a></li>
						<!-- <li class="breadcrumb-item active" aria-current="page">Register</li> -->
					</ol>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- ================ end banner area ================= -->

<!--================Login Box Area =================-->
<section class="login_box_area section-margin">
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="login_box_img">
					<div class="hover">
						<h4>이미 계정이 있으십니까?</h4>
						<p>이미 계정이 있으시다면 아래 버튼을 클릭하여 로그인 후 서비스를 이용해주세요.</p>
						<a class="button button-account"
							href="<%=request.getContextPath()%>/member/login.member">로그인하기</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="login_form_inner register_form_inner">
					<h3>회원가입</h3>
					<form action="register.member" name=search class="row login_form"
						id="register_form" method="post">
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="userEmail"
								name="userEmail"
								placeholder="Email Address" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Email Address'">
								<div id="checkMsg">이메일을 입력하세요.</div>
						</div>
						<div class="col-md-12 form-group">
							<input type="password" maxlength="15" class="form-control"
								id="userPassword" name="userPassword" placeholder="Password"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = '8자리 이상 15자리이하의 영문, 숫자, 특수문자'">
						</div>
						<div class="col-md-12 form-group">
							<input type="password" maxlength="15" class="form-control"
								id="confirmPassword" name="confirmPassword" onkeyup="checkPwd()"
								placeholder="Confirm Password" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Confirm Password'">
							<div id="checkPwd"></div>
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="userName"
								name="userName" placeholder="UserName"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'UserName'">
						</div>
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="userPhone"
								name="userPhone" placeholder="PhoneNumber"
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Phone Number'">
						</div>
						<div class="col-md-12 form-check form-check-inline"
							style="justify-content: space-around">
							<input type="radio" class="form-check-input" id="userType"
								name="userType" value="0"><label
								class="form-check-label" for="inlineRadio1">관리자</label> <input
								type="radio" class="form-check-input" id="userType"
								name="userType" value="1"><label
								class="form-check-label" for="inlineRadio1">일반회원</label> <input
								type="radio" class="form-check-input" id="userType"
								name="userType" value="2"><label
								class="form-check-label" for="inlineRadio1">구독회원</label>
						</div>
						<div class="col-md-12 form-group">
							<!-- <div class="creat_account">
								<input type="checkbox" id="f-option2" name="selector"> <label
									for="f-option2">Keep me logged in</label>
							</div> -->
						</div>
						<div class="col-md-12 form-group">
							<button type="submit" class="button button-register w-100"
								onclick="chkPw(); return false;">회원가입</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Login Box Area =================-->

<script src=" http://code.jquery.com/jquery.js"></script>
<script>

function chkPw() {
	var pw = $("#userPassword").val();
	var num = pw.search(/[0-9]/g);
	var eng = pw.search(/[a-z]/ig);
	var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(pw.length < 8 || pw.length > 16) {
		alert("비밀번호를 8~15자리 이내로 입력해주세요.");
		return false;
	} else if (pw.search(/\s/) != -1) {
		alert("비밀번호는 공백 없이 입력해주세요.")
		return false;
	} else if (num < 0 || eng < 0 || sep < 0) {
		alert("비밀번호는 영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
		return false;
	} else {
		console.log("통과");
		return true;
	}
}

/* var checkFirst = false;
var lastKeyword = '';
var loopSendKeyword = false;

function checkEmail() {
	if(checkFirst == false) {
		// 0.5초 후에 sendKeyword() 함수 실행
		setTimeout("sendEmail();", 500);
		loopSendKeyword = true;
	}
	checkFirst = true;
} */

function checkPwd() {
	// onkeyup : 키를 입력 중에 발생하는 이벤트
	console.dir(document.forms[0]);
	var f1 = document.forms[0];
	/* var pw1 = f1.pwd.value;
	var pw2 = f1.pwd_check.value; */
	var pw1 = f1.userPassword.value;
	var pw2 = f1.confirmPassword.value;
	
	console.log(pw2);
	
	if(pw1=='' && pw2!='') {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "사용할 비밀번호를 먼저 입력해주세요"
	}
	else if(pw1!='' && pw2==''){
		document.getElementById('checkPwd').innerHTML = "";
	} else if (pw1=='' && pw2=='')
		document.getElementById('checkPwd').innerHTML = "";
	else if(pw1!=pw2) {
		document.getElementById('checkPwd').style.color = "red";
		document.getElementById('checkPwd').innerHTML = "비밀번호가 일치하지 않습니다.";
	} else if(pw1==pw2 && pw1!=''){
		document.getElementById('checkPwd').style.color = "blue";
		document.getElementById('checkPwd').innerHTML = "암호가 확인되었습니다.";
	}
	
	setTimeout("checkPwd();", 500);
}


function getXMLHttpRequest(){

	

	if(window.ActiveXObject){

		

		try{

			return new ActiveXObject("Msxml2.XMLHTTP");

		} catch (e) {

			try {

				return new ActiveXObject("Microsoft.XMLHTTP");

			} catch (e) {

				return null;

			}

		}

	} else if (window.XMLHttpRequest) {

		return new XMLHttpRequest;

	} else {

		return null;

	}

}

/* $('#userEmail').focusout(function(){
	let userEmail = $('#userEmail').val(); // input_id에 입력되는 값
	console.log(userEmail);			// 정상 출력
	
	$.ajax({
		url : "email_check.jsp",
		type : "post",
		data : {userEmail: userEmail},
		dataType : 'json',
		success : function(result){
			if(result == 0){
				$("#checkMsg").html('사용할 수 없는 아이디입니다.');
				$("#checkMsg").attr('color','red');
			} else{
				$("#checkMsg").html('사용할 수 있는 아이디입니다.');
				$("#checkMsg").attr('color','green');
			} 
		},
		error : function(){
			alert("서버요청실패");
		}
	})
	 // 이메일 체크는 나중에 할 것.....
}) */


</script>

<%@ include file="/inc/bottom.jsp"%>