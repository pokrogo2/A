<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_update();
			fn_pwCheck0();
			fn_pwCheck();
			fn_pwCheck2();
		});
		function fn_update() {
			$('#memberUpdate_btn').click(function(){
				if ( !pwPass0 ) {
					alert('현재 비밀번호를 확인하세요.');
					return false;
				} else if ( !pwPass || !pwPass2 ) {
					alert('새로운 비밀번호가 일치하지않습니다.');
					return false;
				} else {
					$('#f2').attr('action', 'updateMember.do');
					$('#f2').submit();
				}
			});
		}
		// 비밀번호 검증 함수
		var pwPass = false;
		function fn_pwCheck(){
			$('#pw').keyup(function(){  // keyup : 비밀번호를 입력할때마다
				var regPW = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; // 나중에 수정해서 사용
				if (regPW.test($('#pw').val())){
					$('#pw_result').text('사용 가능한 비밀번호입니다.').css('color', 'blue');
					pwPass = true;
				} else {
					$('#pw_result').text('비밀번호는 숫자,특문,영문을 사용한 8자리 이상이어야합니다.').css('color', 'red');
					pwPass = false;
				}
			});
		}
		// 비밀번호 입력 확인 함수
		var pwPass2 = false;
		function fn_pwCheck2(){
			$('#pw2').keyup(function(){  // keyup : 비밀번호를 입력할때마다
				if ($('#pw').val() == $('#pw2').val()){
					$('#pw2_result').text('비밀번호 일치').css('color', 'blue');
					pwPass2 = true;
				} else {
					$('#pw2_result').text('비밀번호를 확인하세요.').css('color', 'red');
					pwPass2 = false;
				}
			});
		}
		var pwPass0 = false;
		function fn_pwCheck0(){
			$('#pw0').keyup(function(){  // keyup : 비밀번호를 입력할때마다
				if ($('#pw0').val() == $('#loginUserPw').val()){
					$('#pw0_result').text('비밀번호 일치').css('color', 'blue');
					pwPass0 = true;
				} else {
					$('#pw0_result').text('비밀번호를 확인하세요.').css('color', 'red');
					pwPass0 = false;
				}
			});
		}
		</script>
<link rel="stylesheet" href="resources/asset/css/writeForm.css">
<link rel="stylesheet" href="resources/asset/css/myPage.css">
<div class="container">
		
		
		<h1 class="con_title">마이페이지</h1>
			<div class="flex">
			<div id="left" class="left myPage_box">
				<ul>
					<li><a href="#">예약 현황</a></li>
					<li><a href="#reservation_history_review">예약 내역 및 리뷰</a></li>
					<li><a href="#review_history">내가 쓴 리뷰</a></li>
					<li><a href="#question_history">문의 내역</a></li>
					<li><a href="memberUpdatePage.do">개인 정보 수정</a></li>
				</ul>
			</div>
			<div class="right myPage_box" id="rigthList">
			
				<form id="f2" method="post">
					<table>
						<tbody>
					
							<tr>
								<td>아이디</td>
								<td><input type="text" name="id" id="id" value="${loginUser.memberId}" readonly></td>
							</tr>
							<tr>
								<td>현재 비밀번호</td>
								<td>
									<input type="password" name="pw0" id="pw0">
									<span id="pw0_result"></span>
									<input type="hidden" name="loginUserPw" id="loginUserPw" 
									value="${loginUser.memberPw}">
								</td>
							</tr>
							<tr>
								<td>새 비밀번호</td>
								<td>
									<input type="password" name="pw" id="pw">
									<span id="pw_result"></span>
								</td>
							</tr>
							<tr>
								<td>새 비밀번호 확인</td>
								<td>
									<input type="password" name="pw2" id="pw2">
									<span id="pw2_result"></span>
								</td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" id="name" value="${loginUser.memberName}"></td>
							</tr>
				
							<tr>
								<td>주소</td>
								<td><input type="text" name="addr" id="addr" value="${loginUser.memberAddr}"></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><input type="text" name="tel" id ="tel" value="${loginUser.memberTel}"></td>
							</tr>
							<tr>
								<td>나이</td>
								<td><input type="text" name="age" id="age" value="${loginUser.memberAge}"></td>
							</tr>
							<tr>
								<td colspan="2" class="bottomBtn"><input type="button" value="개인정보 수정하기" id="memberUpdate_btn"></td>
							</tr>
							
						</tbody>
					</table>
					<input type="hidden" name="email" value="${loginUser.memberEmail }">
					<input type="hidden" name="no" value="${loginUser.memberNo }">
				</form>
			</div>
			
			
		</div>
			
		
		</div>
		
		
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>
	
