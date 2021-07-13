<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/resView.css">
	

	<div class="outer">
		<h1>가게 View</h1>
	
		<div class="res_name">가게1(상호명)</div>
		
		<div class="res_image">
			<div>가게 대표 이미지 box</div>	
		</div>
		
		<div class="res_rating">★평점 4/5</div>
		
		<form>
			<div class="res_btns">
				<input type="button" value="공유하기" id="share" name="share">
				<input type="button" value="지도보기" id="map" name="map">
				<button>예약하기</button>
			</div>
		</form>
		
		<ul>
			<li><a href="#">홈</a></li>
			<li><a href="#">메뉴</a></li>
			<li><a href="#">리뷰</a></li>
			<li><a href="#">사진</a></li>
		</ul>
		
		<div class="res_section">
			<div class="res_exp">
				가게소개 -> 
				<div class="exp_box"></div>
			</div>	
			<div class="res_tel">
				<p>가게번호 -></p>
				<p class="content_box"></p>		
			</div>
			
			<div class="res_addr">
				<p>가게주소 -></p>
				<p class="content_box"></p>		
			</div>
			
			<div class="res_hours">
				<p>운영시간 -></p>
				<p class="content_box"></p>		
			</div>
			
			<div class="res_category">
				<p>카테고리 -></p>
				<p class="content_box"></p>		
			</div>
			
			<div class="res_menu">
				<p>메뉴 -></p>
				<p class="content_box">메뉴명</p>		
				<p class="content_box">가격</p>		
			</div>
			
			<div class="res_menu">
				<p>메뉴 사진 -></p>
				<p class="content_box"></p>		
			</div>
		</div>
		
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>