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
			fn_storeTable()
			fn_storeList();
			fn_storeCategory();
			fn_fileAlert();
		});
		
		
		// 가게 업데이트
		function fn_update(){
			$('#f').submit(function(event){
				if ($('#store_name').val() == '' ||
					$('#store_content').val() == '' ||
					$('#store_table').val() == '' ||
					$('#store_tel').val() == '' ||
					$('#store_addr').val() == '' ||
					$('#store_time').val() == '' ||
					$('input[name="storeCategory"]').val() == '' 
					) {
						alert('필수 정보를 입력하세요.');
						event.preventDefault();
						return false;
				} else ( $('#store_name').val() == '${store.storeName}'
					 && $('#store_content').val() == '${store.storeContent}' 
					 && $('#store_table').val() == '${store.storeTable}' 
					 && $('#store_tel').val() == '${store.storeTel}' 
					 && $('#store_addr').val() == '${store.storeAddr}' 
					 && $('#store_time').val() == '${store.storeTime}' )
						  {
					alert('수정할 내용이 없습니다.');
					$('#title').focus();
					event.preventDefault();
					return false;				
				}	
				$('#f').attr('action', 'storeUpdate.do');
				$('#f').submit();	
			});
		}
		
		// && $('input[name="storeCategory"]').val() == $('#false').val() )
		
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
		
		// 카테고리 선택 
		function fn_storeCategory() {
			$('input:radio[name=storeCategory].attr("checked", true)');
		}
		
		
		// 파일 업로드 제한 
		function fn_fileAlert(){
			$('#file').change(function(){
				var extension = $(this).val().substring($(this).val().lastIndexOf('.') + 1).toUpperCase();
				var extList = ['JPG', 'JPEG', 'PNG', 'GIF'];
				if ($.inArray(extension, extList) == -1) {
					alert('확장자가 jpg, jpeg, png, gif인 파일만 업로드 가능합니다.');
					$(this).val('');
					return false;
				}
				var maxSize = 1024 * 1024 * 10; 
				var fileSize = $(this)[0].files[0].size;
				if (fileSize > maxSize) {
					alert('10MB 이하의 파일만 업로드 가능합니다.');
					$(this).val('');
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
		
		<form id="f" action="storeUpdate.do" method="post" enctype="multipart/form-data">
			<div class="store_name">
				<input type="text" id="store_name" name="storeName" value="${store.storeName}">
			</div>
			<div>평점: ★★★★☆</div>
			
			 
				<div class="store_image">
					<img alt="${store.originFilename}" src="resources/archive/${store.saveFilename}" style="width: 450px;">
				</div>
				<!-- 첨부 파일 변경  -->
				<div>
					<input type="file" id="file" name="newFile">
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
								<span><input type="text" id="store_table" name="storeTable" value="${store.storeTable}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 번호</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_tel" name="storeTel" value="${store.storeTel}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 주소</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_addr" name="storeAddr" value="${store.storeAddr}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>운영 시간</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_time" name="storeTime" value="${store.storeTime}"></span>
							</div>					
						</li>		
					</ul>
					
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>SNS</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_sns" name="storeSns" value="${store.storeSns}"></span>
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