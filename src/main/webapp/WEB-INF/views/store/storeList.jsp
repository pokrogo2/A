<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>



</script>


<!-- 가게 리스트 검색-->
<div class="outer">
	<form>
		<div class="box">
			<select>
			
				<!-- 리뷰별: 보류 
				<option value="review">리뷰별(평점순)</option> 
				 -->
									
				<option value="hit">조회순</option>
				<option value="post">등록순</option>
			</select>	
	
			<input type="text" id="search" name="search" class="int">
			<button>검색하기</button>
		</div>
	
	
<!-- 가게 리스트 -->
	<table border="1">
		<thead>
			<tr>
				<th>No.</th>
				<!-- <th>썸네일</th> -->
				<th>상호명</th>	
				
				<!--  ** 평점: 보류   -->
				<!--  <th>평점</th> -->
				
				<th>조회수</th>
			</tr>	
		</thead>
		<tbody>
			
			<c:if test="${empty list}">
				<td colspan="3">등록된 가게가 없습니다.</td>
			</c:if>
			
			<c:if test="${not empty list}">
				<c:forEach var="store" items="${list}">
					<td>${store.storeNo}</td>
					<td><a href="storeView.do?storeNo=${store.storeNo}">${store.storeName}</a></td>
					<td>${store.storeHit}</td>
				</c:forEach>
			</c:if>
		</tbody>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">
					${paging}
				</td>
			</tr>
		</tfoot>	
	
	</table>	

	</form>
</div>

<!-- Footer -->
<%@ include file="../layout/footer.jsp"%>