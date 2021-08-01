<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

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
		});
	} // 
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		
		<h1 class="con_title">마이페이지</h1>
		
		
		<div class="flex">
			<div id="left" class="left myPage_box">
				<a href="#" class="tabClick">예약 현황 및 리뷰</a>
				<a href="#review_history">내가 쓴 리뷰</a>
				<a href="#question_history">문의 내역</a>
				<a href="memberUpdatePage.do">개인 정보 수정</a>
			</div>
			
			<!-- 우측의 내용 삽입 -->
			<div class="right myPage_box" id="rigthList">
				
				<!-- 1. 예약 현황 -->
				<div id="reservation_status" class="">
					<%@ include file="../reservation/myReservation.jsp" %>
				</div>
				<!--  2. 리뷰 작성란 -->
				<%@ include file="../review/reviewInsert.jsp" %>
				
				<!-- 3. 작성한 리뷰 리스트 -->
				<div id="review_history" class="">
					<h2>내가 쓴 리뷰</h2>
					<%@ include file="../review/reviewPage.jsp" %>
				</div>
					
				<!-- 4. 작성한 문의 리스트 -->
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
	
		</div> <!-- flex -->
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>
	
