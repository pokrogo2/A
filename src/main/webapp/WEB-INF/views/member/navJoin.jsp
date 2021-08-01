
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Join" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/joinPage.css">

<script>
	$(document).ready(function(){

	}); // 페이지 로드 이벤트 (종료)
	
	
	
	/* 함수 */
	
</script>
	
	<!-- Section -->
	<div class="container" >
		
		<h1 class="con_title">회원가입</h1>
		
		<div id="joinBox">
			<!-- <a href=""><i class="far fa-user"></i></a> -->
			<a href="userJoinPage.do"><i class="fas fa-user"></i></a>
			<a href="ownerJoinPage.do"><i class="fas fa-store"></i></a>
		</div>
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>