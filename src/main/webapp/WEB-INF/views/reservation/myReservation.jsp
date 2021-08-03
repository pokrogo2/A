<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	
</head>
<body>

		<h2>예약 현황</h2>
		
		<c:if test="${not empty list1}">
			<c:forEach var="res" items="${list1}">
					<div id="status_box">
						<div class="con">
							<h3>1</h3>
							 <a href="resView.do?resNo=${res.resNo}" id="resImg"><img alt="status_img" src="resources/archive/${res.saveFilename }"></a>
							 <div>
								<h3>${res.storeName}</h3>
								<p>예약인원 <span>테이블 1개, 인원수 ${res.resPeople}</span></p>
								<p>예약 시간 <span>${res.resDate }일 / ${res.resHours}시</span></p>
							</div>
							<a href="resDelete.do?resNo=${res.resNo }" class="cancle">예약 취소</a>
						</div>
					</div>
			</c:forEach>
		</c:if>
						
		<c:if test="${empty list1}"> 
			<h4 class="noList">현재 예약이 없습니다.</h4>
		</c:if>
	
</body>
</html>