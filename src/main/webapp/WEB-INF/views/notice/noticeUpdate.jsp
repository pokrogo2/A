<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="NoticeUpdate" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/noticeUpdate.css">
<script>
	$(document).ready(function(){
		fn_update();
		fn_init();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_update() {
		$('#f').submit(function(event){
			if ($('#title').val() == '' || $('#content').val()== '') {
				alert('제목과 내용은 필수입니다.');
				event.preventDefault();
				return false;
			} else if ($('#title').val() == '${notict.title}' || $('#content').val()== '${notice.content}') {
				alert('수정할 수 있는 내용이 없습니다.');
				event.preventDefault();
				return false;
			}	
		});
	} //
	
	function fn_init() {
		$('#init_btn').click(function(){
			$('#title').val('');
			$('#content').val('');
		});
	}
	
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">공지사항</h1>
		
		<div class="noticeView_box">
			
			<form id="f" method="post" action="noticeUpdate.do">
				<div class="btn">
					<input type="button" value="목록" onclick="location.href='noticePage.do'">
					<input type="button" value="초기화" id="init_btn">
				</div>
				<div class="clear con">
					<label for="writer">작성자</label> <br>
					<input type="text" name="writer" id="writer" value="${notice.writer}" readonly>
					<label for="title">제목</label> <br>
					<input type="text" name="title" id="title" value="${notice.title}">
					<input type="hidden" name="no" value="${notice.no}">
					<textarea rows="30" cols="50" name="content" id="content">${notice.content}</textarea>
				</div>
				
				<button>수정하기</button>
				
			</form>
			
		</div>
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>