<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="NoticeUpdate" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/writeForm.css">
<link rel="stylesheet" href="resources/asset/css/fBoardForm.css">
<script>
	$(document).ready(function(){
		fn_update();
		fn_init();
		fn_contentType_checked();
		fn_onOff();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_update() {
		$('#f').submit(function(event){
			if ($('#writer').val() == '') {
				alert('작성자에 오류가 있습니다.');
				history.back();
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
			} else if ( $('#title').val() == '${fBoard.title}'
					 && $('#content').val() == '${fBoard.content}' 
					 && $('input[name="fileDelete"]').val() == $('#false').val() ) {
				alert('수정할 내용이 없습니다.');
				$('#title').focus();
				event.preventDefault();
				return false;				
			}	
		});
	} //
	
	function fn_contentType_checked() {
			$('input[value="${fBoard.contentType}"]').attr('checked', true);
			$('input[value="${fBoard.contentType}"]').next().addClass('click');
	}
	
	function fn_init() {
		$('#init_btn').click(function(){
			$('#title').val('');
			$('#content').val('');
			$('#file').val('');
			$('input[name="fileDelete"]').prop('checked', true);
		});
	}
	
	function fn_onOff() {
		$('input[name="contentType"]').click(function(){
			$(this).parent().find($('label')).removeClass('click');
			$(this).next().addClass('click');
		});
		$('input[name="fileDelete"]').click(function(){
			$(this).parent().find($('label')).removeClass('click');
			$(this).next().addClass('click');
		});
	}
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">자유게시판</h1>
		
		<div class="write_box">
			
			<form id="f" method="post" action="fBoardUpdate.do" enctype="multipart/form-data">
				<div class="btn">
					<input type="button" value="목록" onclick="location.href='fBoardPage.do'">
					<input type="button" value="초기화" id="init_btn">
				</div>
				<div class="clear con">
					
					<input type="hidden" name="no" value="${fBoard.no}">
					<input type="hidden" name="filename0" value="${fBoard.filename1}">
					
					<!-- 홍보글,이벤트 일때만 보이는 tap(radio) -->
					
						<div id="radio" class="ownerChoiceRadio">
							<input type="radio" name="contentType" value="홍보글" id="promotion">
							<label for="promotion">홍보글</label>
							<input type="radio" name="contentType" value="이벤트" id="event">
							<label for="event">이벤트</label>
						</div>
					<br>
						
					<label for="writer">작성자</label> <br> 
					<input type="text" name="writer" id="writer" value="${fBoard.writer}" readonly>
					<label for="title">제목</label> <br>
					<input type="text" name="title" id="title" value="${fBoard.title}">
					<textarea rows="30" cols="50" name="content" id="content">${fBoard.content}</textarea>
					<!-- 단일 이미지 추가 -->
					<input type="file" name="file" id="file"> 
					<br>
					<!-- 업로드된 이미지를 지울것인지 체크 -->
					<div id="radio" class="fileDeleteChoice">
						<input type="radio" name="fileDelete" value="true" id="true">
						<label for="true">파일 삭제</label>
						<input type="radio" name="fileDelete" value="false" id="false" checked>
						<label for="false" class="click">파일 삭제 취소</label>
					</div>
				</div>
				
				<button>수정하기</button>
				
			</form>
			
		</div>
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>