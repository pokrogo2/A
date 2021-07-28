<%@page import="java.sql.Array"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%
		request.setCharacterEncoding("UTF-8");
		Optional<String> opt = Optional.ofNullable(request.getParameter("JSP_title"));
		String JSP_title = opt.orElse("환영합니다");
		String[] category = {"한식", "양식", "일식", "중식", "술집(19+)"} ;
		pageContext.setAttribute("JSP_title", JSP_title);
		request.setAttribute("category", category);
	%>
	<title>${JSP_title}</title>
	<link rel="stylesheet" href="resources/asset/css/common.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		
	</script>
	
</head>
<body>

	<header>
		<div id="topNav">
			<a href="index.do" class="logo">LOGO</a>
			<span class="sub_nav">
				<c:if test="${empty loginUser}">
					<a href="loginPage.do">로그인</a>
					<span>|</span>
					<a href="joinPage.do">회원가입</a><br><br>
					<a href="ownerLoginPage.do">사장로그인</a>
					<span>|</span>
					<a href="ownerJoinPage.do">사장회원가입</a>
				</c:if>
				<c:if test="${not empty loginUser}">
                    <a href="logout.do">로그아웃</a>S
                    <span>|</span>
					<a href="memberMyPage.do">마이페이지</a>
					<span>|</span>
					<a href="insertStorePage.do" id="store_insert_btn">가게 등록</a>
					<span>|</span>
					<a href="viewStorePage.do" id="store_insert_btn">가게 View</a>
				</c:if>
			</span>
		</div>
		<div id="catgNav" class="upDownBorder">
			<div class="clear category">
				<!-- 링크 작업 시, ?category=${ctg} 넣어서 해당 카테고리 리스트만 만들 예정 -->
				<c:forEach var="ctg" items="${category}">
					<a href="#">${ctg}</a>
				</c:forEach>
				<span>|</span>
				<a href="fBoardPage.do">자유게시판</a>
			</div>
		</div>
			
		<div id="sideFix">
			<div> <a href="noticePage.do">공지사항</a> </div>
			<div> <a href="qnaBoardPage.do">1:1문의</a> </div>
			<div> <a href="#">검색</a> </div>
		</div>
	</header>
		
		<section>
			
			
			
			
			
			
			
			
			
			