<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입</title>
		<link rel="stylesheet" href="resources/asset/css/main.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	$(document).ready(function(){
			fn_idCheck();
			fn_pwCheck();
			fn_pwCheck2();
			fn_verify_num();
			fn_join();
		});
		// 아이디 중복체크 함수
		var idPass = false;  // 아이디 중복체크 통과여부
		function fn_idCheck() {
			$('#id').keyup(function(){  // keyup : 아이디를 입력할때마다
				var regID = /^[a-z]+[a-z0-9]{5,19}$/;  // 나중에 수정해서 사용
				if (!regID.test($('#id').val())) {
					$('#id_result').text('아이디는 영문자로 시작하는 6~ 20 글자 영문또는 숫자여야 합니다.').css('color', 'red');
					return false;
				}
		
			
				$.ajax({
					url: 'idCheck.do',
					type: 'get',
					data: 'id=' + $('#id').val(),
					dataType: 'json',
					success: function(res){
						if (res.count == 0) {
							$('#id_result').text('가입 가능한 아이디입니다.').css('color', 'blue');
							idPass = true;
						} else {
							$('#id_result').text('이미 사용 중인 아이디입니다.').css('color', 'red');
							idPass = false;
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						
					}
				})
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
		// 회원가입함수
		function fn_join(){
			$('#join_btn').click(function(){
				if ( !idPass ) {
					alert('아이디를 확인하세요.');
					return false;
				} else if ( !pwPass || !pwPass2 ) {
					alert('비밀번호를 확인하세요.');
					return false;
				} else if ( !authPass ) {
					alert('이메일 인증을 받아야 합니다.');
					return false;
				} else {
					$('#f').attr('action', 'join.do');
					$('#f').submit();
				}
			});
		}
		</script>
		
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>

	
	<!-- Section -->
	
	<section>
	<div class="container">
		<form id="f" method="post">
		
		아이디<br>
		<input type="text" name="id" id="id">
		<span id="id_result"></span><br><br>
		
		비밀번호<br>
		<input type="password" name="pw" id="pw">
		<span id="pw_result"></span><br><br>
		
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2">
		<span id="pw2_result"></span><br><br>
		
		이름<br>
		<input type="text" name="name" id="name"><br><br>
		
		이메일<br>
		<input type="text" name="email" id="email">
		<input type="button" value="인증번호받기" id="verify_num_btn"><br><br>
		<input type="text" name="user_key" id="user_key">
		<input type="button" value="인증하기" id="verify_btn"><br><br>
		
		주소 <br>
		<input type="text" name="address" id="address"><br><br>
		전화번호<br>
		<input type="text" name="tel" id ="tel"><br><br>
		나이<br>
		<input type="text" name="age" id="age">
		<table>
			<tbody>
				<tr><td>
				<textarea>
						가. 수집하는 개인정보의 항목첫째, 회사는 회원가 입, 원활한 고객상담, 각종 서비스의 제공을 위해 최초 회원가입 당시 아래와 같은 최소한의 개인정보를 필수항목으로 수집하고 있습니다.
						회원가입
						- 이름, 생년월일, 성별, 아이디, 비밀번호, 별명, 연락처(메일주소, 휴대폰 번호 중 선택), 가입인증정보
						만14세 미만 아동 회원가입
						- 이름, 생년월일, 성별, 법정대리인 정보, 아이디, 비밀번호, 연락처 (메일주소, 휴대폰 번호 중 선택), 가입인증정보
						단체아이디 회원가입
						- 단체아이디, 회사명, 대표자명, 대표 전화번호, 대표 이메일 주소, 단체주소, 관리자 아이디, 관리자 연락처, 관리자 부서/직위
						- 선택항목 : 대표 홈페이지, 대표 팩스번호
						둘째, 서비스 이용과정이나 사업처리 과정에서 아래와 같은 정보들이 자동으로 생성되어 수집될 수 있습니다.
						- IP Address, 쿠키, 방문 일시, 서비스 이용 기록, 불량 이용 기록
						셋째, 네이버 아이디를 이용한 부가 서비스 및 맞춤식 서비스 이용 또는 이벤트 응모 과정에서 해당 서비스의 이용자에 한해서만 개인정보 추가 수집이 발생할 수 있으며, 이러한 경우 별도의 동의를 받습니다.
						넷째, 성인컨텐츠, 유료/게임 등 일부 서비스 이용시 관련 법률 준수를 위해 본인인증이 필요한 경우, 아래와 같은 정보들이 수집될 수 있습니다.
						- 이름, 생년월일, 성별, 중복가입확인정보(DI), 암호화된 동일인 식별정보(CI), 휴대폰 번호(선택), 아이핀 번호(아이핀 이용시), 내/외국인 정보
						다섯째, 유료 서비스 이용 과정에서 아래와 같은 결제 정보들이 수집될 수 있습니다.
						- 신용카드 결제시 : 카드사명, 카드번호 등
						- 휴대전화 결제시 : 이동전화번호, 통신사, 결제승인번호 등
						- 계좌이체시 : 은행명, 계좌번호 등
						- 상품권 이용시 : 상품권 번호
						나. 개인정보 수집방법회사는 다음과 같은 방법으로 개인정보를 수집합니다.
						- 홈페이지, 서면양식, 팩스, 전화, 상담 게시판, 이메일, 이벤트 응모, 배송요청
						- 협력회사로부터의 제공
						- 생성정보 수집 툴을 통한 수집
						</textarea>
						<br>
						<input type="checkbox" name="chk">개인정보 수입 및 이용에 동의합니다.
				</td></tr>
			</tbody>
		
		</table>
		<input type="button" value="가입하기" id="join_btn">
		
	</form>
				</div>		
	</section>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>