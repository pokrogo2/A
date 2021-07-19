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
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		
		<h1 class="con_title">마이페이지</h1>
		
		<div class="flex">
			<div id="left" class="left myPage_box">
				<ul>
					<li><a href="#">예약 현황</a></li>
					<li><a href="#reservation_history_review">예약 내역 및 리뷰</a></li>
					<li><a href="#review_history">내가 쓴 리뷰</a></li>
					<li><a href="#question_history">문의 내역</a></li>
					<li><a href="#">개인 정보 수정</a></li>
				</ul>
			</div>
			
			<div class="right myPage_box">
			
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
				
				<!-- 예약 내역  -->
				
				
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
					<!--  리뷰 작성란 -->
				<%@ include file="../review/reviewInsert.jsp" %>
				<div id="review_history" class="">
					<h2>내가 쓴 리뷰</h2>
					<c:if test="${empty list}">
		<h3>작성된리뷰가 없습니다.</h3>
		
	</c:if>
			<%@ include file="../review/reviewPage.jsp" %>
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
		</div>
		</div>
		
		
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>
	
