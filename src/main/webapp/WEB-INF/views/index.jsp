<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/main.css">
	
	<!-- Section -->
	<div class="container">
		
		<div id="mainSearch">
			<form id="f" action="#" method="get">
				<select name="zone" id="zone">
					<option value="">지역</option>
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="부산">부산</option>
				</select>
				<select name="local" id="local">
					<option value="">구</option>
					<option value="용산">용산</option>
					<option value="서대문구">서대문구</option>
					<option value="강남">강남</option>
					<!--  
						지역 선택하면 알아서 그 지역의 구만 보여준다
						<option value="강남">강남</option>
					-->
				</select>
				<select name="catg" id="catg">
					<option value="">음식점 카테고리</option>
					<c:forEach var="catg" items="${category}">						
						<option value="${catg}">${catg}</option>
					</c:forEach>
				</select>
				<input type="text" name="query" id="query" placeholder="검색어를 입력하세요">
				<button><i class="fas fa-search"></i></button>
			</form>
		</div>
		
	</div>
	
	
<!-- Footer -->
<%@ include file="layout/footer.jsp" %>