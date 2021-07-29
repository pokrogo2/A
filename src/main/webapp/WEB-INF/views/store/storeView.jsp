<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="StoreView" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeView.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	
	<script>
	
		$(document).ready(function(){
			fn_update();
			fn_delete();
			fn_storeList();
			fn_storeRes();
			fn_storeRes2();
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

		// 예약하기 (로그인했을 경우)
		function fn_storeRes() {
			$('#storeRes_btn').click(function() {
				if(confirm('예약하시겠습니까?')); {
					$('#f').attr('action', 'storeResPage.do');
					$('#f').submit();
				}
			});
		}
		
		// 로그인 안했을 경우 예약버튼 클릭 -> 로그인page로 이동 
		function fn_storeRes2() {
			$('#storeRes_btn2').click(function() {
				alert('로그인 페이지로 이동합니다.');
				location.href='loginPage.do';
			});
		}
		
		
		
	</script>


	<!-- Body -->	
	<div class="outer">
		<form id="f" method="post" enctype="multipart/form-data">
			<div class="btns">
				<div>
				
						<input type="button" value="수정하기" id="update_btn" class="update_btn">
						<input type="button" value="삭제하기" id="delete_btn" class="delete_btn">
						
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
			
		
		
			<div class="store_btns">
		
				<input type="button" value="가게 목록보기" id="storeList_btn" class="storeList_btn">
				
				<!-- 로그인 했을 경우에만 보이는 예약 활성화 버튼 -->
				<c:if test="${not empty loginUser}">
					<input type="button" value="예약하기" id="storeRes_btn"  name="storeRes_btn" class="storeRes_btn">  
				</c:if>
				
				<c:if test="${empty loginUser}">
					<input type="button" value="예약하기" id="storeRes_btn2" name="storeRes_btn2" class="storeRes_btn">
				</c:if>
			</div>
		
		
		<ul>
			<li><a href="#">홈</a></li>
			<li><a href="#">메뉴</a></li>
			<li><a href="#">리뷰</a></li>
			<li><a href="#">사진</a></li>
		</ul>
		
		<div class="store_section">
			<input type="hidden" name="storeNo" value="${store.storeNo}">
			<input type="hidden" name="storeTable" value="${store.storeTable}">
				
			<div class="category_box">
				<span class="category_icon">
					<i class="fas fa-utensils"></i>
				</span>
				<span class="category_box">
					${store.storeCategory}
				</span>
					
			</div>
			
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
						<div class="list_left"><h2>메뉴소개</h2></div>
						<div class="list_right">
						<span>${store.storeMenu}</span>
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
						<span>${store.storeAddr1}</span>
						<span>${store.storeAddr2}</span>
						<span>${store.storeAddr3}</span>
						
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
							<span class="sns_link">
								<a href="${store.storeSns}">${store.storeSns}</a>
							</span>
						</div>					
					</li>		
				</ul>
				
				
	
			</div>
		</form>
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>