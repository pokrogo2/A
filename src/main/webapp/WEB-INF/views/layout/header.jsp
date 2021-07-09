Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@ingyuna 
pokrogo2
/
A
1
00
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
A/src/main/webapp/WEB-INF/views/layout/header.jsp
@kimsuyeon07
kimsuyeon07 [main_header/footer] CSS_end
Latest commit 346dcec 13 minutes ago
 History
 1 contributor
65 lines (50 sloc)  1.7 KB
  
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
		pageContext.setAttribute("category", category);
	%>
	<title>${JSP_title}</title>
	<link rel="stylesheet" href="resources/asset/css/common.css">
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		
	</script>
	
</head>
<body>

	<header>
		<div id="topNav">
			<a class="logo">LOGO</a>
			<span class="sub_nav">
				<c:if test="${empty loginUser}">
					<a href="#">로그인</a>
					<span>|</span>
					<a href="#">회원가입</a>
				</c:if>
				<c:if test="${not empty loginUser}">
					<a href="#">마이페이지</a>
					<span>|</span>
					<a href="#" id="store_insert_btn">가게 등록</a>
				</c:if>
			</span>
		</div>
		<div id="catgNav" class="upDownBorder">
			<div class="clear category">
				<!-- 링크 작업 시, ?category=${ctg} 넣어서 해당 카테고리 리스트만 만들 예정 -->
				<c:forEach var="ctg" items="${category}">
					<a href="#">${ctg}</a>
				</c:forEach>
			</div>
		</div>
	</header>
		
		<section>
			
			
			
			
			
	