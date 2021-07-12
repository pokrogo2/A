<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/resList.css">
	

	<div class="outer">
		<form>
			<div class="box">
				<select>
					<option value="review">리뷰별(평점순)</option>
					<option value="hit">조회순</option>
					<option value="post">등록순</option>
				</select>	
				
				<input type="text" id="search" name="search" class="int">
				<button>검색하기</button>
			</div>
		</form>
		
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<th>썸네일</th>
					<th>상호명</th>
					<th>평점</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td>2</td>
					<td>가게이미지</td>
					<td>가게2</td>
					<td>★★★★☆</td>
					<td>100</td>
					<td>2021-07-12</td>
				</tr>		
				
				<tr>
					<td>1</td>
					<td>가게이미지</td>
					<td>가게1</td>
					<td>★★★☆☆</td>
					<td>250</td>
					<td>2021-07-12</td>
				</tr>	
			</tbody>			
			<tfoot>
				<tr>
					<td colspan="6">
						페이징 처리 예정			<!-- ${paging} -->
					</td>
				</tr>
			</tfoot>
		</table>
		
		
		
		
		
		
		
	
	
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>