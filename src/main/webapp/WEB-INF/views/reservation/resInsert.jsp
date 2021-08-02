<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
<link rel="stylesheet" href="resources/asset/css/resInsert.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>

	$(document).ready(function(){
		fn_storeRes();	
		fn_resHours();
		
	})
	
	function fn_storeRes() {
		$('#f').submit(function(event){
			if( $('#resDate').val() == '날짜') {
				alert('날짜를 선택해주세요.')
				return false;
			} else if ( $('input[name="resHours"]').val() == '') {
				alert('시간을 선택해주세요.')
				return false;
			} else if ( $('#resPeople').val() == '명') {
				alert('인원수를 선택해주세요.')
				return false;
			}
		});
	}	

	
	function fn_resHours() {
		$('input:radio[name=resHours]').on('change', function(){
			alert( $('input[name=resHours]:checked').val() + "시로 선택되었습니다." );
		});
	}
	

</script>	
	
</head>


<body>

	<div class="outer">
		<form id="f" method="post" action="resInsert.do">
		
			<input type="hidden" value="${storeDTO.storeNo}" name="storeNo" id="storeNo">
			<input type="hidden" value="${loginUser.memberNo}" name="memberNo" id="memberNo">
		
			
			<input type="hidden" value="${resDTO.resNo}" name="resNo" id="resNo">
		
		<div class="storeView_box">
			<input type="button" value="가게 보기" onclick="location.href='storeView.do?storeNo=${storeDTO.storeNo}'" class="storeView_btn">
		</div>				 
				
			<!-- 예약 안내 문구 -->
			<div class="res_box">
				<h2>예약 하기</h2>
				<span class="notice_box">* 예약은 최대 한 달 이내로만 가능합니다 :) </span>
			</div>
			
			<!-- 예약 날짜 -->
			<div class="res_box">
				<h3>날짜 선택 <span class="red_mark">▼</span></h3>
				<select id="resDate" name="resDate">
					<option value="날짜">날짜</option>
					<% for(int i = 1; i < 32; i++){  %>
					<option value="<%=i%>"><%="2021년 8월"+i+"일"%></option> 
					<%} %>
				</select>
			</div>
			
			<!-- 예약 시간 -->
			<h3>시간 선택 <span class="red_mark">▼</span></h3>		
			<c:forEach var="i" begin="12" end="20" step="1">
				<div class="hours_box">
				<label>
					<input type="radio" name="resHours" id="resHours" value="${i}">
					${i}:00
				</label>			
				</div>
			</c:forEach>					
			
			<!-- 예약 인원 -->
			<div class="res_box">
				<h3>인원수 선택 <span class="red_mark">▼</span></h3>
				<h5>(* 4명 이하만 가능합니다.)</h5>
				<select name="resPeople" id="resPeople">
					<option value="명">명</option>
					<option value="1명">1명</option>
					<option value="2명">2명</option>
					<option value="3명">3명</option>
					<option value="4명">4명</option>
				</select>	
			</div>
		
			<!-- 예약자 정보 -->
			<div class="res_box">	
				<h3>예약자 정보<span class="red_mark">▼</span></h3>	
					<div class="res_info">
						<div>예약자 : ${loginUser.memberName}</div>
						<div>연락처: ${loginUser.memberTel}</div>
						<div>이메일 : ${loginUser.memberEmail}</div>					
					</div>				
					<div class="res_req">
						요청사항 (* 요청사항이 있을시 입력해주세요.)
					</div>
					<textarea rows="10" cols="40" id="resNote" name="resNote">
					</textarea>			
			</div>			
			
			
			<!-- 예약 버튼 -->
			<div>
				<button class="res_btn">예약하기</button>			
			</div>
		
		</form>
	</div>

</body>
</html>