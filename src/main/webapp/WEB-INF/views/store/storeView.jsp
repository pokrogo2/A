<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeView.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	
	<script>
	
		$(document).ready(function(){
			fn_update();
			fn_delete();
			fn_storeList();
		})
		
		// 수정하기
		function fn_update(){
			$('#update_btn').click(function(){
				location.href='storeUpdatePage.do?storeNo=${store.storeNo}';
			});
		}
		
		// 삭제하기
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					$('#f').attr('action', 'storeDelete.do');
					$('#f').submit();
				}
			});
		}
		
		// 목록보기 
		function fn_storeList(){
			$('#storeList_btn').click(function(){
				location.href = 'storeList.do';
			})
		}
		
	
	</script>


	<!-- Body -->	
	<div class="outer">
		<form id="f" method="post" enctype="multipart/form-data">
			<div class="btns">
				<div>
					<input type="button" value="수정하기" id="update_btn">
					<input type="button" value="삭제하기" id="delete_btn">
					<input type="button" value="가게 목록보기" id="storeList_btn">
					
					<input type="hidden" name="storeNo" value="${store.storeNo}">
					<input type="hidden" name="originFilename" value="${store.originFilename}">
					<input type="hidden" name="saveFilename" value="${store.saveFilename}">
				</div>
			</div>
		
		
	
		<div class="store_name">${store.storeName}</div>
		<div>평점: ★★★★☆</div>
		
		 
			<div class="store_image">
				<img alt="${store.originFilename}" src="resources/archive/${store.saveFilename}" style="width: 450px;">
			</div>
		<!-- 
		<div class="store_rating">★평점 4/5</div>		
		-->
		
		
			<div class="store_btns">
				<input type="button" value="공유하기" id="share" name="share">
				<input type="button" value="지도보기" id="map" name="map">
				<button>예약하기</button>
			</div>
		
		
		<ul>
			<li><a href="#">홈</a></li>
			<li><a href="#">메뉴</a></li>
			<li><a href="#">리뷰</a></li>
			<li><a href="#">사진</a></li>
		</ul>
		
		<div class="store_section">
			<input type="hidden" name="storeNo" value="${store.storeNo}">
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>가게소개</h2></div>
						<div class="list_right">
						<span>${store.storeContent}</span>
						</div>					
					</li>		
				</ul>
				
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>테이블 수</h2></div>
						<div class="list_right">
						<span>${store.storeTable}</span>
						</div>					
					</li>		
				</ul>
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>가게 번호</h2></div>
						<div class="list_right">
						<span>${store.storeTel}</span>
						</div>					
					</li>		
				</ul>
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>가게 주소</h2></div>
						<div class="list_right">
						<span>${store.storeAddr}</span>
						</div>					
					</li>		
				</ul>
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>운영 시간</h2></div>
						<div class="list_right">
						<span>${store.storeTime}</span>
						</div>					
					</li>		
				</ul>
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>SNS</h2></div>
						<div class="list_right">
						<span><a>${store.storeSns}</a></span>
						</div>					
					</li>		
				</ul>
				
				<!-- 
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>카테고리</h2></div>
						<div class="list_right">
						<span>${store.storeCategory}</span>
						</div>					
					</li>		
				</ul>
				 -->
			
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>메뉴소개</h2></div>
						<div class="list_right">
						<span>${store.storeMenu}</span>
						</div>					
					</li>		
				</ul>
				
				<ul class="storeView_outer">
					<li class="storeView_list">
						<div class="list_left"><h2>카테고리</h2></div>
						<div class="list_right">
						<span id="storeCategory_List">${store.storeCategory}</span>
						</div>					
					</li>		
				</ul>
				
			
			</div>
		</form>
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>