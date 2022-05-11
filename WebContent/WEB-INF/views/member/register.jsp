<%@page import="kr.siat.model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ================ start banner area ================= -->
<section class="blog-banner-area" id="category">
	<div class="container h-100">
		<div class="blog-banner">
			<div class="text-center">
				<h1>Register</h1>
				<nav aria-label="breadcrumb" class="banner-breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Login</a></li>
						<li class="breadcrumb-item active" aria-current="page">Register</li>
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
						<h4>Already have an account?</h4>
						<p>There are advances being made in science and technology
							everyday, and a good example of this is the</p>
						<a class="button button-account"
							href="<%=request.getContextPath()%>/member/login.member">Login
							Now</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="login_form_inner register_form_inner">
					<h3>Create an account</h3>
					<form action="register.member" name=search class="row login_form"
						id="register_form" method="post">
						<div class="col-md-12 form-group">
							<input type="text" class="form-control" id="userEmail"
								name="userEmail" onkeydown="checkEmail()"
								placeholder="Email Address" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Email Address'">
							<!-- <div id="checkMsg">아이디를 입력하세요.</div> -->
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
								name="userType" value="2" disabled><label
								class="form-check-label" for="inlineRadio1">기업회원
								(disabled)</label>
						</div>
						<div class="col-md-12 form-group">
							<div class="creat_account">
								<input type="checkbox" id="f-option2" name="selector"> <label
									for="f-option2">Keep me logged in</label>
							</div>
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

var checkFirst = false;
var lastKeyword = '';
var loopSendKeyword = false;

function checkEmail() {
	if(checkFirst == false) {
		// 0.5초 후에 sendKeyword() 함수 실행
		setTimeout("sendEmail();", 500);
		loopSendKeyword = true;
	}
	checkFirst = true;
}

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

function sendEmail() {
	if(loopSendKeyword == false)
		return;
	
	var keyword = document.search.userEmail.value;
	console.log(keyword);
	if(keyword=="") {
		// 이메일에 입력한 게 없으면
		lastKeyword = "";
		document.getElementById("checkMsg").style.color = 'black';
		document.getElementById("checkMsg").innerHTML = "아이디를 입력하세요.";
	} else if (keyword != lastKeyword) {
		lastKeyword = keyword;
		
		if(keyword != "") {
			var params = "email="+encodeURIComponent(keyword);
			console.log(params);
			sendRequest("email_check.jsp", params, displayResult, "POST");
			/* sendRequest("email_check.jsp", params, "POST"); */
		} else {
			
		}
	}
	setTimeout("sendEmail();", 500);
}

/* function displayResult() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			var resultText = httpRequest.responseText;
	    	var listView = document.getElementById('checkMsg');
	    	
	    	if(resultText==0) {
	     		listView.innerHTML = "사용 할 수 있는 ID 입니다";
	     		listView.style.color = "blue";
	    	} else {
	     		listView.innerHTML = "이미 등록된 ID 입니다";
	     		listView.style.color = "red";
	    	}
	   	} else {
	    	alert("에러 발생: "+httpRequest.status);
	   	}
	}
} */


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

var httpRequest = null;
function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();
	
	//method 처리

	//method값이 있으면 넘어온 method값을 사용. 없으면 GET으로 설정

	var httpMethod = method?method:"GET";

	

	if(httpMethod!="GET" && httpMethod!="POST"){

		httpMethod = "GET";

	}

	

	//params 처리

	var httpParams = (params==null || params=="")?null:params;

	

	//url처리

	var httpUrl = url;

	if(httpMethod="GET" && httpParams!=null){

		httpUrl += "?" + httpParams;

	}

	

	httpRequest.open(httpMethod,httpUrl,true);

	//POST방식일 경우를 대비해서 작성

	httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");

	httpRequest.onreadystatechange = callback;

	httpRequest.send(httpMethod=="POST"?httpParams:null);	
}

function displayResult() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
			var resultText = httpRequest.responseText;
	    	var listView = document.getElementById('checkMsg');
	    	
	    	if(resultText==0) {
	     		listView.innerHTML = "사용 할 수 있는 ID 입니다";
	     		listView.style.color = "blue";
	    	} else {
	     		listView.innerHTML = "이미 등록된 ID 입니다";
	     		listView.style.color = "red";
	    	}
	   	} else {
	    	alert("에러 발생: "+httpRequest.status);
	   	}
	}
}


</script>

<%@ include file="/inc/bottom.jsp"%>