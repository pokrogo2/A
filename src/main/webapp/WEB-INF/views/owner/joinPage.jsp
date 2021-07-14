<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입(사장님)</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	$(document).ready(function() {
		fn_noCheck();
		fn_pwCheck();
		fn_pwCheck2();
		fn_verify_num();
		fn_checkAll(checkAll);
		fn_join();
		});
		
		// 사업자번호 조회
		var noPass = false; // 사업자번호 조회체크 여부
		function fn_noCheck() {
			
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
		// 이메일 인증번호 받기 함수
		function fn_verify_num(){
			$('#verify_num_btn').click(function(){
				if ($('#email').val() == '') {
					alert('이메일을 입력하세요.');
					$('#email').focus();
					return false;
				}
				$.ajax({
					url: 'verifyNum.do',
					type: 'get',
					data: 'email=' + $('#email').val(),
					dataType: 'json',
					success: function(resultMap){
						alert('인증코드가 발송되었습니다.');
						fn_verify(resultMap.authCode);  // 인증번호 검증 함수로 발행된 인증코드 전달
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				})
			});
		}
		// 이메일 인증번호 검증 함수
		var authPass = false;  // 이메일 인증 통과여부
		function fn_verify(authCode){
			$('#verify_btn').click(function(){
				if(authCode == $('#user_key').val()){
					alert('인증되었습니다.');
					authPass = true;
				} else {
					alert('인증에 실패했습니다.');
					authPass = false;
				}
			});
		}
			
		
		// 전체 동의 시 나머지 버튼 선택/해제
		function checkAll(checkAll) {
			const checkboxes = document.getElementsByName('chk');
			
			checkboxes.forEach((checkbox) => {
				checkbox.checked = checkAll.checked;
			})
		}
		
		// 회원가입함수
		function fn_join() {
			$('#join_btn').click(function() {
				if( !noPass ){
					alert('사업자번호를조회하세요');
					return false;
				} else if(!pwPass || pwPass2) {
					alert('비밀번호가 일치하지 않습니다.');
					return false;
				} else if(!authPass) {
					alert('이메일 인증 필수입니다.');
					return false
				} else {
					$('#f').attr('action', 'join.do');
					$('#f').submit();
				}
			})
		}
	</script>	
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	
	
	<section>
		<div class="container">
			<form id="f" metohd="post">
			<h3>회원가입(사장님)</h3>
			
			사업자번호<br>
			<input type="text" name="no" id="no">
			<input type="button" value="조회하기" id="no_btn">
			<span id="no_result"></span><br><br>			
			
			비밀번호<br>
			<input type="password" name="pw" id="pw">
			<span id="pw_result"></span><br><br>
			
			비밀번호 확인<br>
			<input type="password" name="pw2" id="pw2">
			<span id="pw2_result"></span><br><br>
			
			<!--사업자번호 미등록 시-->	
			<c:if test="${empty list}">
			<li>
				<dl>
					<dt>조회된 사업자번호가 없습니다.</dt>
				</dl>
			</li>
			</c:if>
			
			<!--사업자번호 등록 시-->
			<c:if test="${not empty list}">
				<c:forEach var="owner" items="${list}">
					이메일<br>
					<input type="text" name="email" id="email" value="{owner.email}">
					<input type="button" value="인증번호받기" id="verify_num_btn">
					<br><br>
					
					인증번호확인<br>
					<input type="text" name="user_key" id="user_key">
					<input type="button" value="인증하기" id="verify_btn">
					<br><br>
					
					사업자명<br>
					<input type="text" name="name" id="name" value="{owner.name}">
					<br><br>
					
					상호명<br>
					<input type="text" name="name1" id="name1" value="{owner.name1}">
					<br><br>
					
					사업자연락처<br>
					<input type="text" name="phone" id="phone" value="{owner.phone}">
					<br><br>
					
					가게연락처<br>
					<input type="text" name="tel" id="tel" value="{owner.tel}">
					<br><br>
					
					가게 주소<br>
					<input type="text" name="address" id="address" value="{owner.address}">
					<br><br>
				</c:forEach>			
			</c:if>
			<table>
				<tbody>				
					<tr>
						<td>카테고리 분류</td>
						<td>
							<input type="radio" name="category" id="korea" checked/>한식
						</td>
						<td>
							<input type="radio" name="category" id="west"/>양식
						</td>
						<td>
							<input type="radio" name="category" id="japan"/>일식
						</td>
						<td>
							<input type="radio" name="category" id="china"/>중식
						</td>
						<td>
							<input type="radio" name="category" id="archol"/>술집
						</td>
						<td>
							<input type="radio" name="category" id="cafe"/>카페
						</td>
					</tr>					
					<tr>						
						<td>
							<input type="checkbox" name="chk" value="chk1">이용약관1 동의
						</td>
						<textarea>
						이용약관1				
						</textarea>
					</tr>
					<tr>						
						<td>
							<input type="checkbox" name="chk" value="chk2">이용약관2 동의
						</td>
						<textarea>
						이용약관2				
						</textarea>
					</tr>
					<tr>
						<td>
							<input type="checkbox" name="chk" value="checkAll" onclick="checkAll(this)">전체 동의 <!--클릭 시 이용약관 1,2 모두 체크-->
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="뒤로가기" onclick="history.back()"/>
						</td>
						<td colspan="2">
							<input type="button" value="가입하기" id="join_btn"/>
						</td>
					</tr>
				</tbody>				
			</table>
		</form>
		</div>
	</section>
	<%@ include file="../layout/footer.jsp" %>
</body>
</html>