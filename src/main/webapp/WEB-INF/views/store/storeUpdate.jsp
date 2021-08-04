<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="StoreUpdate" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeUpdate.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	
	<script>
	
		$(document).ready(function(){
			fn_update();
			fn_storeTable()
			fn_storeList();
			fn_storeCategory();
			fn_storeCategory_changed()
			fn_fileAlert();
			fn_storeAddr();
			fn_mainSearchSelect_zone();
			fn_mainSearchSelect_local();
		});
	
		function fn_update(){
			$('#f').submit(function(event){
				if ($('#store_name').val() == '' ||
					$('#store_content').val() == '' ||
					$('#store_table').val() == '' ||
					$('#store_tel').val() == '' ||
					$('select[name=storeAddr1]').val() == '' ||
					$('select[name=storeAddr2]').val() == '' ||
					$('#store_time').val() == '' ||
					$('input[name=storeCategory]').val() == '' 
					) {
					alert('필수 정보를 입력하세요.');
					event.preventDefault();
					return false;
				} 
			});
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
		
		
		function fn_storeCategory() {
			$('input[value="${store.storeCategory}"]').attr('checked', true);
		}
		
		function fn_storeCategory_changed() {
			$('#store_category').on('change', function(){
				alert( "카테고리가" + " " + $('input[name=storeCategory]:checked').val() + "(으)로 변경되었습니다." );
			});
			
		}
		
		
		// 주소 (2개 select)
		function fn_storeAddr() {
			$('option[value="${store.storeAddr1}"]').attr('checked', true);
			$('option[value="${store.storeAddr2}"]').attr('checked', true);
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
		
		
		// 메인 검색 바의 지역 선택 조건
		var zoneList = null;
		function fn_mainSearchSelect_zone() {
			$.ajax({
				url: 'zoneSelect.do',
				type: 'get',
				dataType: 'json',
				success: function(resultMap){
					if (resultMap.status == 200) {
						zoneList = resultMap.zoneList;
						$.each(zoneList, function(i, zoneList) {
							$('<option>').attr('value', zoneList.zone).text(zoneList.zone).appendTo('#zone');
						});
					}
				}, 
				error: function(xhr, text, error){
					alert('오류!' + error);
				}
			});
		} //
		var localList = null;
		function fn_mainSearchSelect_local() {
			$( 'body' ).on('click', '#zone', function(event){
				$('#local').empty();
				$('<option>').attr('value', '').text('구 선택').appendTo('#local'); // <option value=""> = 구 = </option>
				// 지역의 value가 존재할 때만 진행하겠다.
				if ( $('#zone').val() != '' ) {
					$.ajax({
						url: 'localSelect.do',
						type: 'get',
						data: 'zone=' + $('#zone').val(),
						dataType: 'json',
						success: function(resultMap) {
							if (resultMap.status == 200) {
								localList = resultMap.localList;
								if (localList != null && localList != '') { // 지역의 구가 존재하는 경우에만 진행하겠다.
									$.each(localList, function(i, localList) {
										$('<option>').attr('value', localList.local).text(localList.local).appendTo('#local');
									});								
								}
							}
						}
					});
				}
			});
		}//
		
	
	</script>


	<!-- Body -->	
	<div class="outer">
		
		<form id="f" action="storeUpdate.do" method="post" enctype="multipart/form-data">
		
				<div class="store_image">
					<img alt="${store.originFilename}" src="resources/archive/${store.saveFilename}" style="width: 450px;">
				</div>
				<!-- 첨부 파일 변경  -->
				<div>
					<input type="file" id="file" name="newFile">
					기존에 ${store.originFilename} 파일이 첨부되어있습니다.<br><br>		
				</div>
			
			<!-- 빈 공간 유지 -->
			<div class="store_btns"></div>
			
			
			<div class="store_section">
				<input type="hidden" name="storeNo" value="${store.storeNo}">
					
					<p>*는 필수사항입니다.</p>
					
					<!-- 가게명 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 이름 *</h2></div>
							<div class="list_right">
								<span><input type="text" id="store_name" name="storeName" value="${store.storeName}"></span>
							</div>					
						</li>		
					</ul>
					
				
					<!-- 카테고리 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>카테고리 *</h2></div>
							<div class="list_right">
							<span id="store_category">
								<input type="radio" name="storeCategory" value="한식" id="f1"> 
								<label for=f1>한식</label>
								<input type="radio" name="storeCategory" value="양식" id="f2"> 
								<label for=f2>양식</label>
								<input type="radio" name="storeCategory" value="일식" id="f3"> 
								<label for=f3>일식</label>
								<input type="radio" name="storeCategory" value="중식" id="f4"> 
								<label for=f4>중식</label>
								<input type="radio" name="storeCategory" value="술집" id="f5"> 
								<label for=f5>술집</label>
							</span>
							</div>					
						</li>		
					</ul>
					
					<!-- 가게 소개 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게소개 *</h2></div>
							<div class="list_right">
							<span><textarea rows="7" cols="25" id="store_content" name="storeContent">${store.storeContent}</textarea></span>
							</div>					
						</li>		
					</ul>
					
					
					<!-- 테이블수 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>테이블 수 *</h2></div>
							<div class="list_right">
								<span><input type="text" id="store_table" name="storeTable" value="${store.storeTable}"></span>
							</div>					
						</li>		
					</ul>
					
					<!-- 가게번호 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 번호 *</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_tel" name="storeTel" value="${store.storeTel}"></span>
							</div>					
						</li>		
					</ul>
					
					<!-- 가게주소 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>가게 주소 *</h2></div>
							<div class="list_right">
							<select name="storeAddr1" id="zone">
								<option value="">지역 선택</option>							
							</select>
							<select name="storeAddr2" id="local">
								<option value="">구 선택</option>
							</select><br>
							<span><input type="text" id="store_addr3" name="storeAddr3" value="${store.storeAddr3}"></span>
							</div>					
						</li>		
					</ul>
					
					<!-- 운영시간 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>운영 시간 *</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_time" name="storeTime" value="${store.storeTime}"></span>
							</div>					
						</li>		
					</ul>
					
					<!-- SNS 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>SNS</h2></div>
							<div class="list_right">
							<span><input type="text" id="store_sns" name="storeSns" value="${store.storeSns}"></span>
							</div>					
						</li>		
					</ul>
					
					<!-- 메뉴소개 수정 -->
					<ul class="storeView_outer">
						<li class="storeView_list">
							<div class="list_left"><h2>메뉴소개</h2></div>
							<div class="list_right">
							<span><textarea rows="15" cols="25" id="store_menu" name="storeMenu">${store.storeMenu}</textarea></span>
							</div>					
						</li>		
					</ul>
					
				<div class="btns">
				<div>
					<button id="update_btn" class="update_btn">수정하기</button>
					<input type="button" value="가게 목록보기" id="storeList_btn" class="storeList_btn">
					
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