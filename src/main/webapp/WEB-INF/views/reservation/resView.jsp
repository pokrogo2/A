<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<link rel="stylesheet" href="resources/asset/css/resView.css">
</head>
<body>

	<div class="outer">
	
			<input type="hidden" name="storeNo" id="storeNo">
			<input type="hidden" value="${loginUser.memberNo}" name="memberNo" id="memberNo">
			
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>예약번호</h3></div>
					<div class="list_right">
					<span>${res.resNo}</span>
					</div>					
				</li>		
			</ul>
		</div>
			
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>예약 날짜</h3></div>
					<div class="list_right">
					<span>2021년 8월 ${res.resDate}일</span>
					</div>					
				</li>		
			</ul>
		</div>
		
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>예약 시간</h3></div>
					<div class="list_right">
					<span>${res.resHours}:00</span>
					</div>					
				</li>		
			</ul>
		</div>
		
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>예약 인원</h3></div>
					<div class="list_right">
					<span>${res.resPeople}</span>
					</div>					
				</li>		
			</ul>
		</div>
		
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>요청사항</h3></div>
					<div class="list_right">
					<span>${res.resNote}</span>
					</div>					
				</li>		
			</ul>
		</div>
		
		
		<div>
			<ul class="resView_outer">
				<li class="resView_list">
					<div class="list_left"><h3>예약 등록일</h3></div>
					<div class="list_right">
					<span>${res.resPostdate}</span>
					</div>					
				</li>		
			</ul>
		</div>
	
	</div>


</body>
</html>