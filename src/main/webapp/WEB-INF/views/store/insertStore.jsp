<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/insertStore.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	
	$(document).ready(function(){
		fn_storeInsert();
		fn_storeTable();
	});
	
	// 가게 등록 함수
	function fn_storeInsert(){
		$('#f').submit(function(event){
			if ($('#store_name').val() == '' ||
				$('#store_intro').val() == '' ||
				$('#store_table').val() == '' ||
				$('#store_tel').val() == '' ||
				$('#store_addr').val() == '' ||
				$('#store_time').val() == '' ||
				$('#store_image').val() == '' ) {
				alert('필수 정보를 입력하세요.');
				event.preventDefault();
				return false;
			} 
			$('#f').attr('action', 'storeInsert.do');
			$('#f').submit();	
		});
	}
	
	// 테이블 갯수 입력창
	function fn_storeTable() {
		$('#store_table').blur(function(){
			var storeTable = /^[0-9]$/;
			if ( !storeTable.test($('#store_table').val()) ) {
				alert('숫자만 입력해주세요.')
				return false;
			}
		});
	}
	
	// 
	
	

</script>


	<div class="outer">
	
		
		<form id="f" method="post" enctype="multipart/form-data">
		
			<h3>가게 정보를 입력해주세요 :)</h3>
			<p>*는 필수사항입니다.</p>
			
			<table>
				<tbody>
				
				
					<!--
						<tr>
							<td>사업주명</td>
							<td><input type="text" value="${owner.name}" id="owner_name" name="owner_name" class="int" readonly><br></td>
						<tr>
					-->
					 
					
					<tr>
						<td>상호명 *</td>
						<td><input type="text" id="store_name" name="storeName" class="int"><br></td>
					<tr>
						<td>가게 소개 *</td>
						<td><textarea rows="7" cols="25" id="store_content" name="storeContent"></textarea><br></td>
					</tr>
					<tr>
						<td>테이블 수 *</td>
						<td><input type="text" id="store_table" name="storeTable" class="int"><br></td>
					</tr>			
					<tr>
						<td>가게 번호 *</td>
						<td><input type="text" id="store_tel" name="storeTel" class="int"><br></td>
					</tr>
					<tr>
						<td>가게 주소 *</td>
						<td><input type="text" id="store_addr" name="storeAddr" class="int"><br></td>
					</tr>
					<tr>
						<td>운영 시간 *</td>
						<td><input type="text" id="store_time" name="storeTime" class="int"><br></td>
					</tr>
					<tr>
					<tr>
						<td>SNS</td>
						<td><input type="text" id="store_sns" name="storeSns" class="int"><br></td>
					</tr>
					<tr>
						<td>카테고리 분류 *</td>
						<td colspan="2">
							<input type="radio" name="food" value="k" id="f1"> 
							<label for=f1>한식</label>
							<input type="radio" name="food" value="e" id="f2"> 
							<label for=f2>양식</label>
							<input type="radio" name="food" value="w" id="f3"> 
							<label for=f3>일식</label>
							<input type="radio" name="food" value="c" id="f4"> 
							<label for=f4>중식</label>
							<input type="radio" name="food" value="a" id="f5"> 
							<label for=f5>술(+19)</label>
						</td>
					</tr>
					
					<tr>
						<td>메뉴 등록</td>
						<td>
							<input type="text" id="menu_name" name="storeMenu" class="menu_int" placeholder="메뉴명">
							<!-- <input type="text" id="menu_price" name="storeMenu" class="menu_int" placeholder="가격(,로 입력)">  -->
						</td>
					</tr>
					
					<!-- 
					<tr>
						<td>메뉴 사진 등록</td>
						<td>
							<input type="file" name="files" multiple><br>
						</td>
					</tr>				
					 -->
					 
					<tr>
						<td>가게 대표이미지 *</td>
						<td>
							<input type="file" id="store_image" name="files" multiple><br>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">						
								<input type="button" value="뒤로가기" onclick="history.back()" class="btn1">
								<button id="store_insert" class="btn2">등록하기</button>
						</td>
					</tr>	
				</tfoot>		
			</table>
			
			
		</form>
		
		
	
	
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp"%>