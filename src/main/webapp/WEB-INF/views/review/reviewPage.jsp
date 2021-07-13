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
--헤더 --
	
	<h1>리뷰 기능구현</h1>
		로그인세션을 통해 구현
	<c:if test="${empty list}">
		<h3>작성된리뷰가 없습니다.</h3>
	</c:if>
	<c:if test="${not empty list}">
		<c:forEach var="review" items="${list}">
			<table border="1">
				<tbody>
					<tr>
						<td>${review.no}</td>
						<td colspan="3">작성자 : ${review.writer}</td>
					</tr>
					<tr>
					
						<td rowspan="2">
						<img alt="${filename}" src="resources/archive/${filename}" style="width: 300px;">
						</td>
						<td>가게이름</td>
						<td>별점 : <c:forEach var="i" begin="1" end="${review.score}" step="1">
							★
							</c:forEach>
						</td>
						<td>${review.storename} / 카테고리 : ${review.storecategori}</td>			
					</tr>
					<tr>
						<td colspan="3">${review.content }</td>
					</tr>
				</tbody>
				
	
			</table>
		</c:forEach>
	</c:if>
	
	
--풋터
</body>
</html>