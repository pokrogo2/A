<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/viewStore.css">
	

	<div class="outer">
		<h1>가게 View</h1>
	
		<div class="store_name">상호명: ${store.storeName}</div>
		
		<!-- 
		<div class="store_image">
			<div>가게 대표 이미지 box</div>	
		</div>
		
		<div class="store_rating">★평점 4/5</div>
		
		-->
		
		<form>
			<div class="store_btns">
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
		
		<div class="store_section">
			<input type="hidden" name="storeNo" value="${store.storeNo}">
				<div class="store_exp">
					가게소개 -> 
					<div class="exp_box">${store.storeContent}</div>
				</div>	
				
				<div class="store_exp">
					테이블 갯수 -> 
					<div class="exp_box">${store.storeTable}</div>
				</div>	
				
				<div class="store_tel">
					<p>가게번호 -></p>
					<p class="content_box">${store.storeTel}</p>		
				</div>
				
				<div class="store_addr">
					<p>가게주소 -></p>
					<p class="content_box">${store.storeAddr}</p>		
				</div>
				
				<div class="store_time">
					<p>운영시간 -></p>
					<p class="content_box">${store.storeTime}</p>		
				</div>
				
		</div>
		
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>