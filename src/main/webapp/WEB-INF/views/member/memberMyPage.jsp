<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/writeForm.css">
<link rel="stylesheet" href="resources/asset/css/myPage.css">
<script>
	$(document).ready(function(){
		fn_leftClick();
	}); // 페이지 로드 이벤트 (종료)
	
	
	
	/* 함수 */
	
	// 죄측의 Tap 클릭 시, 클릭된 영역의 변경요소 확인
	function fn_leftClick() {
		$('a').click(function(){
			$('#left').find( $('a') ).removeClass('tabClick');
			$(this).addClass('tabClick');
			$('#rigthList').removeClass('none');
			$('#rigthMember').addClass('none');
		});
		
		$('#memberUp').click(function(){ 
			$('#rigthMember').removeClass('none');
			$('#rigthList').addClass('none');
			$('#memberUp').addClass('tabClick');
		});
	} // 
	
	
	
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		
		<h1 class="con_title">마이페이지</h1>
		
		<div class="flex">
			<div id="left" class="left myPage_box">
				<a href="#" class="tabClick">예약 현황</a>
				<a href="#reservation_history_review">예약 내역 및 리뷰</a>
				<a href="#review_history">내가 쓴 리뷰</a>
				<a href="#question_history">문의 내역</a>
				<a href="#" id="memberUp">개인 정보 수정</a>
			</div>
			
			<div class="right myPage_box" id="rigthList">
			
				<div id="reservation_status" class="">
					<h2>예약 현황</h2>
					<div id="status_box">
						<div class="con">
							<h3>1</h3>
							<a href="#"><img alt="status_img" src="resources/archive/03.jpg"></a>
							<div>
								<h3>음식점1</h3>
								<p>예약인원 <span>테이블 1개, 인원수 4명</span></p>
								<p>예약 시간 <span>2021/07/11 오전 10시 (예약)</span></p>
							</div>
							<a href="#" class="cancle">예약 취소</a>
						</div>
					</div>
				</div>
				
				<div id="reservation_history_review" class="">
					<h2>예약 내역</h2>
					<div id="history_list">
						<div class="con">
							<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
							<h3>음식점1</h3>
							<p>내용 설명</p>
						</div>
						<div class="con">
							<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
							<h3>음식점1</h3>
							<p>내용 설명</p>
						</div>
						<div class="con">
							<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
							<h3>음식점1</h3>
							<p>내용 설명</p>
						</div>
					</div>
					<div id="reservation_history_paging"></div>
					<div id="insert_review">
						<div id="grade">
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="grey">★</p>
							<span class="grey">(평점 선택)</span>
						</div>
						<form id="f" action="#" method="post" enctype="multipart/form-data" class="clear" >
							<select name="review_store">
								<option value="">== 예약한 음식점 ==</option>
								<option value="한솥">한솥</option>
								<option value="이삭토스트">이삭토스트</option>
								<option value="홍콩반점">홍콩반점</option>
							</select>
							<input type="text" name="review" id="review" placeholder="리뷰를 작성하세요">
							<input type="file" name="review_img" multiple>
							<input type="button" value="리뷰 작성" id="review_btn">
						</form>
					</div>
				</div>
				
				<div id="review_history" class="">
					<h2>내가 쓴 리뷰</h2>
					<%@ include file="../review/reviewPage.jsp" %>
					<div class="review">
						<h3>1</h3>
						<div id="box1" class="box">
							<h3>음식점1<span>신촌지점</span></h3>
							<a href="#"><img alt="store1" src="resources/archive/03.jpg" /></a>
						</div>
						<div id="box2"  class="box">
							<div id="review_grade">
								<p class="star">★</p>
								<p class="star">★</p>
								<p class="star">★</p>
								<p class="star">★</p>
								<p class="grey">★</p>
								<span class="grey">(평점)</span>
							</div>
							<p id="review_text">리뷰내용</p>
							<div id="review_img">
									<img alt="review_img" src="resources/archive/03.jpg">
									<img alt="review_img" src="resources/archive/03.jpg">
									<img alt="review_img" src="resources/archive/03.jpg">
								<c:if test="${not empty reivew.image}">
								</c:if>
							</div>
						</div>
						<div id="box3" class="box">
							<input type="button" value="리뷰 수정" id="update_review_btn">
							<br>
							<input type="button" value="리뷰 삭제" id="delete_review_btn">
						</div>
					</div> <!-- review -->
					<div id="review_padding"></div>
				</div>
				
				<div id="question_history" class="">
					<h2>문의 내역</h2>
					<div id="question_table">
						<table>
							<tbody>
								<tr>
									<td><h3>1</h3></td>
									<td>1:1 문의</td>
									<td><a href="#">Q.문의 제목</a></td>
									<td>
										<c:if test="${empty answer}">
											<p class="notAnswer">답변대기</p>
										</c:if>
										<c:if test="${not empty answer}">
											<p class="Answer">답변완료</p>
										</c:if>
									</td>
								</tr>
								<tr>
									<td><h3>1</h3></td>
									<td>1:1 문의</td>
									<td><a href="#">Q.문의 제목</a></td>
									<td>
										<c:if test="${empty answer}">
											<p class="notAnswer">답변대기</p>
										</c:if>
										<c:if test="${not empty answer}">
											<p class="answer">답변완료</p>
										</c:if>
									</td>
								</tr>
							</tbody>
							<tfoot id="question_paging"></tfoot>
						</table>
					</div>
				</div>
				
			</div> <!-- right -->
			
			<div class="right myPage_box none" id="rigthMember">
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
								<td>이메일</td>
								<td class="memberEmail">
									<input type="text" name="email" id="email">
									<input type="button" value="인증번호받기" id="verify_num_btn">
									<input type="text" name="user_key" id="user_key">
									<input type="button" value="인증하기" id="verify_btn">
								</td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" name="address" id="address" value="${loginUser.memberAddr}"></td>
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
				</form>
			</div>
			
			
		</div>
		
		
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>
	
