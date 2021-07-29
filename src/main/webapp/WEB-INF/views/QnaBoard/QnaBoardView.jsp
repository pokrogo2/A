<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="QnaBoardView" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/noticeView.css">
<script>
	$(document).ready(function(){
		fn_update();
		fn_delete();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_update() {
		$('#updete_btn').click(function(){
			location.href='qnaBoardUpdatePage.do?no=${qnaBoard.no}';
		});
	}
	function fn_delete() {
		$('#delete_btn').click(function(){
			if(confirm('해당 글을 삭제하시겠습니까?')) {
				location.href='qnaBoardDelete.do?no=${qnaBoard.no}';
			}	
		});
	}
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">문의게시판</h1>
		
		<div class="qnaBoardView_box clear">
			<div> <h2>Q. ${qnaBoard.title}</h2> </div>
			<div> ${qnaBoard.content} </div>
			<div class="sub"> ${qnaBoard.writer} <span class="line">|</span> ${qnaBoard.postdate}</div>
			<div>
				<input type="button" value="목록" onclick="location.href='qnaBoardPage.do'">
					<input type="button" value="수정" id="updete_btn">
					<input type="button" value="삭제" id="delete_btn">
			</div>
		</div>
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>