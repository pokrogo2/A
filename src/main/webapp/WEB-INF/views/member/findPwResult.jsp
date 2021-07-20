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
			
		});
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

	<link rel="stylesheet" href="resources/asset/css/writeForm.css">
	<link rel="stylesheet" href="resources/asset/css/memberFindResult.css">
	
	<!-- Section -->
	
	<section>
	<div class="container">
		<h1 class="con_title">비밀번호 찾기 결과</h1>
		
		<c:if test="${findUser == null}">
			<h2>일치하는 회원 정보가 없습니다.</h2>
			<a href="findPwPage.do">비밀번호 찾기</a>
		</c:if>
		
		<c:if test="${findUser != null}">
	
			<p>아이디 : <span>${findUser.memberId}</span></p>
			<p>이름 : <span>${findUser.memberName}</span></p>
			<p>비밀번호 : <span>${findUser.memberPw}</span></p>
			
			<div class="btnBox">
				<input type="button" value="로그인하러 가기" onclick="location.href='loginPage.do'">	
			</div>	
		</c:if>
	</div>		
	</section>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>