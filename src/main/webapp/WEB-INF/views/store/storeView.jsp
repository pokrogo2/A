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
			fn_storeList();
			fn_storeCategory();
			fn_storeTable();
		});
	
		
		// 수정하기
		function fn_update(){
			$('#update_btn').click(function(){
				location.href='storeUpdatePage.do?storeNo=${store.storeNo}';
			});
		}
		
		// 카테고리 선택 
		function fn_storeCategory() {
			$('input:radio[name=storeCategory].attr("checked", true)');
		}
		
		
	
		// 테이블 갯수 입력창
		function fn_storeTable() {
			$('#store_table').blur(function(){
				var storeTable = /^[0-9]{1,3}$/;
				if ( !storeTable.test($('#store_table').val()) ) {
					alert('숫자만 입력해주세요. (3자리를 넘을 수 없습니다.)')
					return false;
				}
			});
		}
	
		
		
		// 목록보기 
		function fn_storeList(){
			$('#storeList_btn').click(function(){
				location.href = 'storeList.do';
			});
		}
		
	
	
	</script>


	<!-- Body -->	
	<div class="outer">
		
		<form id="f" method="post" enctype="multipart/form-data">
			<div class="store_name">
				<input type="text" id="storeName" name="storeName" value="${store.storeName}">
			</div>
			<div>평점: ★★★★☆</div>
			
			 
				<div class="store_image">
					<img alt="${store.originFilename}" src="resources/archive/${store.saveFilename}" style="width: 450px;">
				</div>
				<!-- 첨부 파일 변경  -->
				<div>
					<input type="file" name="new_file">
					기존에 ${store.originFilename} 파일이 첨부되어있습니다.<br><br>		
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
							<span><textarea rows="7" cols="25" id="store_content" name="storeContent">${store.storeContent}</textarea></span>
							</div>					
						</li>		
					</ul>
					
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>테이블 수</h2></div>
							<div class="list_right">
								<span><input type="text" id="storeTable" name="storeTable" value="${store.storeTable}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 번호</h2></div>
							<div class="list_right">
							<span><input type="text" id="storeTel" name="storeTel" value="${store.storeTel}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 주소</h2></div>
							<div class="list_right">
							<span><input type="text" id="storeAddr" name="storeAddr" value="${store.storeAddr}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>운영 시간</h2></div>
							<div class="list_right">
							<span><input type="text" id="storeTime" name="storeTime" value="${store.storeTime}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>SNS</h2></div>
							<div class="list_right">
							<span><input type="text" id="storeSns" name="storeSns" value="${store.storeSns}"></span>
							</div>					
						</li>		
					</ul>
					
				
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>메뉴소개</h2></div>
							<div class="list_right">
							<span><textarea rows="7" cols="25" id="store_menu" name="storeMenu">${store.storeMenu}</textarea></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>카테고리</h2></div>
							<div class="list_right">
							<span>
								<input type="radio" name="storeCategory" value="한식" id="f1"> 
								<label for=f1>한식</label>
								<input type="radio" name="storeCategory" value="양식" id="f2"> 
								<label for=f2>양식</label>
								<input type="radio" name="storeCategory" value="일식" id="f3"> 
								<label for=f3>일식</label>
								<input type="radio" name="storeCategory" value="중식" id="f4"> 
								<label for=f4>중식</label>
								<input type="radio" name="storeCategory" value="술" id="f5"> 
								<label for=f5>술(+19)</label>
							</span>
							</div>					
						</li>		
					</ul>
			
				
				<div class="btns">
				<div>
					
					<button id="update_btn">수정하기</button> 
					<input type="button" value="가게 목록보기" id="storeList_btn">
					
					<input type="hidden" name="storeNo" value="${store.storeNo}">
					<input type="hidden" name="originFilename" value="${store.originFilename}">
					<input type="hidden" name="saveFilename" value="${store.saveFilename}">
				</div>
			</div>
				
		</div>
		
		</form>
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>