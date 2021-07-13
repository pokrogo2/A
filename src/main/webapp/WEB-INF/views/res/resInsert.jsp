<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/resInsert.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	
	$(document).ready(function(){
		fn_resInsert();
		fn_resTable();
	});
	
	// 가게 등록 함수
	function fn_resInsert(){
		$('#f').submit(function(event){
			if ($('#r_name').val() == '' ||
				$('#r_intro').val() == '' ||
				$('#r_table').val() == '' ||
				$('#r_tel').val() == '' ||
				$('#r_addr').val() == '' ||
				$('#r_hours').val() == '' ||
				$('#r_image').val() == '' ) {
				alert('필수 정보를 입력하세요.');
				event.preventDefault();
				return false;
			} 
			$('#f').attr('action', 'resInsert.do');
			$('#f').submit();	
		});
	}
	
	// 테이블 갯수 입력창
	function fn_resTable() {
		$('#r_table').blur(function(){
			var resTable = /^[0-9]$/;
			if ( !resTable.test($('#r_table').val()) ) {
				alert('숫자만 입력해주세요.')
				return false;
			}
		});
	}
	
	

</script>


	<div class="outer">
	
		
		<form id="f" method="post" enctype="multipart/form-data">
		
			<h3>가게 정보를 입력해주세요 :)</h3>
			<p>*는 필수사항입니다.</p>
			
			<table>
				<tbody>
					<tr>
						<td>사업주명</td>
						<td><input type="text" value="${Owner.name}" id="owener_name" name="owener_name" class="int" readonly><br></td>
					<tr>
					<tr>
						<td>상호명 *</td>
						<td><input type="text" id="r_name" name="r_name" class="int"><br></td>
					<tr>
						<td>가게 소개 *</td>
						<td><textarea rows="7" cols="25" id="r_intro"></textarea><br></td>
					</tr>
					<tr>
						<td>테이블 수 *</td>
						<td><input type="text" id="r_table" name="r_table" class="int"><br></td>
					</tr>			
					<tr>
						<td>가게 번호 *</td>
						<td><input type="text" id="r_tel" name="r_tel" class="int"><br></td>
					</tr>
					<tr>
						<td>가게 주소 *</td>
						<td><input type="text" id="r_addr" name="r_addr" class="int"><br></td>
					</tr>
					<tr>
						<td>운영 시간 *</td>
						<td><input type="text" id="r_hour" name="r_hours" class="int"><br></td>
					</tr>
					<tr>
					<tr>
						<td>SNS</td>
						<td><input type="text" id="r_sns" name="r_sns" class="int"><br></td>
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
							<input type="text" id="menu_name" name="menu_name" class="menu_int" placeholder="메뉴명">
							<input type="text" id="menu_price" name="menu_price" class="menu_int" placeholder="가격(,로 입력)">
						</td>
					</tr>
					<tr>
						<td>메뉴 사진 등록</td>
						<td>
							<input type="file" name="files" multiple><br>
						</td>
					</tr>
					<tr>
						<td>가게 대표이미지 *</td>
						<td>
							<input type="file" id="r_image" name="files" multiple><br>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">						
								<input type="button" value="뒤로가기" onclick="history.back()" class="btn1">
								<button id="res_insert" class="btn2">등록하기</button>
						</td>
					</tr>	
				</tfoot>		
			</table>
			
			
		</form>
		
		
	
	
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>