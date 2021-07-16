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
		});
		function fn_login() {
			$('#f').submit(function(event){
				if ($('#no').val() == '' || $('#pw').val() == '') {
					alert('사업자번호와 비밀번호는 필수입니다.');
					event.preventDefault();
					return false;
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
	
	<c:if test="${loginUser != null and loginUser.status ==1}">
		로그인 성공
		사업자번호 : ${loginUser.ownerNo}<br>
		이메일 : ${loginUser.ownerEmail}<br>
	
		<a href="logout.do">로그아웃</a><br>
		<a id="leave_link">회원탈퇴</a><br>
		<a href="#">가게등록</a><br>
	</c:if>
	<c:if test="${loginUser.status==0 }">
		사업자번호 : ${loginUser.ownerNo}<br>
		이메일 : ${loginUser.ownerEmail}
		는 탈퇴된 회원입니다.
		<br><br><br><hr>
		<form id="f" action="ownerlogin.do" method="post">
			사업자번호<br>
			<input type="text" name="no" id="no"><br><br>
			비밀번호<br>
			<input type="password" name="pw" id="pw"><br><br>
			<button>로그인</button>
		</form>
		<br>
		<a href="ownerjoinPage.do">회원가입</a>&nbsp;&nbsp;&nbsp;
	</c:if>
	<c:if test="${loginUser == null}">
		<form id="f" action="ownerlogin.do" method="post">
			사업자번호<br>
			<input type="text" name="id" id="id"><br><br>
			비밀번호<br>
			<input type="password" name="pw" id="pw"><br><br>
			<button>로그인</button>
		</form>
		<br>
		<a href="ownerjoinPage.do">회원가입</a>&nbsp;&nbsp;&nbsp;
	</c:if>
	<a href="index.do">메인</a>
	</div>		
	</section>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>