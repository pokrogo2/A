<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_tapChange();
			fn_login();
			fn_leave();
		});
		
		
		// tap에 따라 div 전환
		function fn_tapChange() {
			$('#tap1').click(function(){
				$('input:radio[name="tap"]').attr('checked', false); // 초기화
				$('input:radio[name="tap"][value="'+ $('#loginUser').val() +'"]').attr('checked', true);
				$('#loginUser').next().addClass('tap_click');
				$('#loginOwner').next().removeClass('tap_click');
				$('#user').removeClass('none');
				$('#owner').addClass('none');
			});
			$('#tap2').click(function(){
				$('input:radio[name="tap"]').attr('checked', false); // 초기화
				$('input:radio[name="tap"][value="'+ $('#loginOwner').val() +'"]').attr('checked', true); 
				$('#loginOwner').next().addClass('tap_click');
				$('#loginUser').next().removeClass('tap_click');
				$('#owner').removeClass('none');
				$('#user').addClass('none');
			});
		} /* [END]fn_tapChange() */
		
		
		function fn_login() {
			$('#f').submit(function(event){
				
				if ( $('input:radio[name="tap"]:checked').val() == $('#loginUser').val() ) {
					if ($('#id').val() == '' || $('#pw').val() == '') {
						alert('아이디와 비밀번호는 필수입니다.');
						event.preventDefault();
						return false;
					}
				} else if($('input:radio[name="tap"]:checked').val() == $('#lginOwner').val()) {
					if ($('#no').val() == '' || $('#pw').val() == '') {
						alert('사업자번호와 비밀번호는 필수입니다.');
						event.preventDefault();
						return false;
					}
				}
				
				// form의 action 추가
				if ($('#id').val() != '') {
					$('#f').attr('action', 'login.do');
				}
				if ($('#no').val() != '') {
					$('#f').attr('action', 'ownerLogin.do');
				}
			})
		}
		function fn_leave(){
			$('#delete_link').click(function() {
				if(confirm('탈퇴하시겠습니까?')){
					location.href = 'ownerDelete.do';
				}
			})
			$('#leave_link').click(function(){
				if (confirm('탈퇴할까요?')){
					location.href = 'deleteMember.do';
				}
			})
		}
	</script>
	<style>
		#leave_link:hover {
			cursor: pointer;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	
	<link rel="stylesheet" href="resources/asset/css/writeForm.css">
	<link rel="stylesheet" href="resources/asset/css/loginPage.css">
	
	
	<div class="container">
	
		<h1 class="con_title">로그인</h1>
		
		<form id="f" method="post">
		
			<input type="radio" name="tap" value="lginUser" id="lginUser" checked>
			<label for="lginUser" id="tap1" class="tap_click">회원</label>
			<input type="radio" name="tap" value="lginOwner" id="lginOwner">
			<label for="lginOwner" id="tap2">사장님</label>
		
			<div id="user">
				아이디<br>
				<input type="text" name="id" id="id" placeholder="ID">
				비밀번호<br>
				<input type="password" name="pw" id="pw" placeholder="PassWord">
				<button>로그인</button>
				<div class="subLink">
					<a href="joinPage.do">회원가입</a>
					<span>|</span>
					<a href="findIdPage.do">아이디찾기</a>
					<span>|</span>
					<a href="findPwPage.do">비밀번호찾기</a>
				</div>
			</div>
			
			<div id="owner" class="none">
				사업자번호<br>
				<input type="text" name="no" id="no">
				비밀번호<br>
				<input type="password" name="pw" id="pw">
				<button>로그인</button>
				<div class="subLink">
					<a href="ownerJoinPage.do">회원가입</a>
					<span>|</span>
					<a href="ownerPwPage.do">비밀번호 찾기</a>
				</div>
			</div>
		</form>
		
	</div>		
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>