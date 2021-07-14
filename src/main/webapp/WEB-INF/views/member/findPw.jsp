<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_findPw();
			fn_emailCheck();
			fn_verify_num();
		});
		function fn_findPw(){
			$('#find_pw_btn').click(function(){
				if ($('#email').val() == '') {
					alert('이메일을 입력하세요.');
					$('#email').focus();
					return false;
				}else if(!emailPass){
					alert('가입되지 않은 이메일 입니다.');
					return false;
				} else if ( !authPass ) {
					alert('이메일 인증을 받아야 합니다.');
					return false;
				}
				else {
					$('#f').attr('action', 'findPw.do');
					$('#f').submit();
				}
			});
		}
		var emailPass = false;  // 이메일 가입여부
		function fn_emailCheck() {
			$('#email').keyup(function(){  // keyup : 이메일를 입력할때마다
				$.ajax({
					url: 'emailCheck.do',
					type: 'get',
					data: 'email=' + $('#email').val(),
					dataType: 'json',
					success: function(res){
						if (res.count == 1) {
							$('#email_result').text('가입된 이메일입니다.').css('color', 'blue');
							emailPass = true;
						} else {
							$('#email_result').text('가입되지 않은 이메일입니다.').css('color', 'red');
							emailPass = false;
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				})
				});
			
		}
		function fn_verify_num(){
			$('#verify_num_btn').click(function(){
				if ($('#email').val() == '') {
					alert('이메일을 입력하세요.');
					$('#email').focus();
					return false;
				}else if(!emailPass){
					alert('이메일을 확인해주세요.');
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
	</script>
</head>
<body>
	<%@ include file="../layout/header.jsp" %>
	<h1>비밀번호 찾기</h1>
	
	<form id="f" method="post">
		<%-- 아이디를 입력해 주세요 <br>
		<input type="text" name="id" id="id">--%>
		<br><br>
		가입 당시 이메일<br>
		<input type="text" name="email" id="email">
		<input type="button" value="인증번호받기" id="verify_num_btn"><br><br>
		<span id="email_result"></span><br><br>
		<input type="text" name="user_key" id="user_key">
		<input type="button" value="인증하기" id="verify_btn"><br><br>
		
		<input type="button" value="비밀번호 찾기" id="find_pw_btn">
		
		<input type="button" value="로그인하러 가기" onclick="location.href='loginPage.do'">	
			
	</form>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>