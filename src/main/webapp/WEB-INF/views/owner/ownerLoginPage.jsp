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
			fn_login();
			fn_delete();
		});
		function fn_login() {
			$('#f').submit(function(event){
				if ($('#no').val() == '' || $('#pw').val() == '') {
					alert('사업자번호와 비밀번호는 필수입니다.');
					event.preventDefault();
					return false;
				}
				if ($('#id').val() == '' || $('#pw').val() == '') {
					alert('아이디와 비밀번호는 필수입니다.');
					event.preventDefault();
					return false;
				}
			})
		}
		function fn_delete(){
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
	<section>
	<div class="container">
	<h1>로그인</h1>
	
	<c:if test="${loginOwner != null }">
		로그인 성공
		사업자번호 : ${loginOwner.ownerNo}<br>
		이메일 : ${loginOwner.ownerEmail}<br>
	
		<a href="ownerLogout.do">로그아웃</a><br>
		<a id="delete_link">회원탈퇴</a><br>
		<a href="#">가게등록</a><br>
	</c:if>
	
	
	<c:if test="${loginOwner == null}">
		<form id="f" action="ownerLogin.do" method="post">
			사업자번호<br>
			<input type="text" name="no" id="no"><br><br>
			비밀번호<br>
			<input type="password" name="pw" id="pw"><br><br>
			<button>로그인</button>
		</form>
		<br>
		<a href="ownerJoinPage.do">회원가입</a>&nbsp;&nbsp;&nbsp;
		<a href="ownerPwPage.do">비밀번호 찾기</a>
	</c:if>
	<a href="index.do">메인</a>
	</div>		
	</section>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>