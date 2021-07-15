<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>회원가입(사장님)</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>
	
	<section>
		<div class="container">
			<form id="f" method="post">
				<h2>사장님 회원가입</h2>
				
				사업자번호<br>
				<input type="text" name="no" id="no">
				<!--<input type="button" value="조회하기" id="no_btn">  조회하기 버튼-->
				<span id="no_result"></span>
				<br><br>
				
				비밀번호<br>
				<input type="password" name="pw" id="pw">
				<span id="pw_result>"></span>
				<br><br>
				
				비밀번호 확인<br>
				<input type="password" name="pw2" id="pw2">
				<span id="pw2_result"></span>
				<br><br>
				
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
					
				사업자연락처<br>
				<input type="text" name="phone" id="phone" value="{owner.phone}">
				<br><br>
				
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