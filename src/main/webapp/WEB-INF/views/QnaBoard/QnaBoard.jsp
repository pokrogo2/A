<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="QnaBoard" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/boardTable.css">
<link rel="stylesheet" href="resources/asset/css/notice.css">
<script>
/* 	$(document).ready(function(){
		fn_qnaBoardList();
		fn_paging();
		
	}); // 페이지 로드 이벤트 (종료)
	
	var page = 1;
	function fn_qnaBoardList() {
		
		$.ajax({
			url: 'qnaBoardList.do',
			type: 'get',
			data: 'page='+page,
			dataType: 'json',
			success:function(resultMap){
				fn_qnaBoard_append(resultMap);
			},
			error:function(xhr, text, error){
				alert('실패!' + error);
				console.log(page);
			}
		}); */
	//} //
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">문의게시판</h1>
		
		<c:if test="${loginUser.memberId == 'ADMIN'}">
			<input type="button" value="글 작성" id="insert_btn" onclick="location.href='qnaBoardInsertPage.do?writer=${loginUser.memberId}'">
		</c:if>
		
		<div class="table_box clear">
			<table>
				<thead>
					<tr>
						<td>순번</td>
						<td>제목</td>
						<td>내용</td>
						<td>작성일</td>
					</tr>
				</thead>
				<tbody id="qnaBoard_list">
					<c:if test="${not empty list}">
					<c:forEach var="qna" items="${list}">
						<tr>
						<td>${qna.no }</td>
						<td>${qna.title }</td>
						<td><a href="qnaBoardView.do?no=${qna.no }">${qna.content }</td>
						<td>${qna.postdate }</td>
						</tr>
					</c:forEach>
					</c:if>
					<c:if test="${empty list}">
					 <tr><td colspan="4">list가없습니다.</td></tr>
					</c:if>
					
				
				
				
				</tbody>
				<input type="button" value="글 작성" id="insert_btn" onclick="location.href='qnaBoardInsertPage.do'">
				<tfoot>
					<tr>
						<td colspan="3" id="qnaBoard_paging" class="paging"></td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>