<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="NoticeUpdate" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/writeForm.css">
<link rel="stylesheet" href="resources/asset/css/noticeForm.css">
<script>
	$(document).ready(function(){
		fn_insert();
		fn_init();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_insert() {
		$('#f').submit(function(event){
			if ($('#writer').val() == '') {
				alert('작성자에 오류가 있습니다.');
				/* history.back(); */
				return false;
			} else if ($('#title').val() == '') {
				alert('제목을 입력해주세요.');
				$('#title').focus();
				event.preventDefault();
				return false;				
			} else if ($('#content').val()== '') {
				alert('내용을 입력해주세요.');
				$('#content').focus();
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
		
		<div class="write_box">
			
			<form id="f" method="post" action="noticeInsert.do">
				<div class="btn">
					<input type="button" value="목록" onclick="location.href='noticePage.do'">
					<input type="button" value="초기화" id="init_btn">
				</div>
				<div class="clear con">
					<label for="writer">작성자</label> <br>
					<input type="text" name="writer" id="writer" value="${loginUser.memberId}">
					<label for="title">제목</label> <br>
					<input type="text" name="title" id="title" placeholder="제목">
					<label for="content">내용</label> <br>
					<textarea rows="30" cols="50" name="content" id="content"></textarea>
				</div>
				
				<button>저장하기</button>
				
			</form>
			
		</div>
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>