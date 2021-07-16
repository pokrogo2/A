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
		fn_insert();
		fn_init();
		fn_onOff();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_insert() {
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
			}
		});
	} //
	
	function fn_init() {
		$('#init_btn').click(function(){
			$('#title').val('');
			$('#content').val('');
			$('#file').val('');
			$('#event').prop('checked',true);
		});
	}//
	
	function fn_onOff() {
		$('input[name="contentType"]').click(function(){
			$(this).parent().find($('label')).removeClass('click');
			$(this).next().addClass('click');
		});
		$('input[name="fileDelete"]').click(function(){
			$(this).parent().find($('label')).removeClass('click');
			$(this).next().addClass('click');
		});
	}//
	
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">자유게시판</h1>
		
		<div class="write_box">
			
			<form id="f" method="post" action="fBoardInsert.do" enctype="multipart/form-data">
				<div class="btn">
					<input type="button" value="목록" onclick="location.href='fBoardPage.do'">
					<input type="button" value="초기화" id="init_btn">
				</div>
				<div class="clear con">
					
					<!-- 사장님에게만 보이는 버튼 (무조건 눌려있어야 한다.) -->
					<c:if test="${not empty loginUser.ownerno}">
						<div id="radio" class="ownerChoiceRadio">
							<input type="radio" name="contentType" value="홍보글" id="promotion">
							<label for="promotion">홍보글</label>
							<input type="radio" name="contentType" value="이벤트" id="event" checked>
							<label for="event" class="click">이벤트</label>
						</div>
					</c:if>
					<br>
						
					<label for="writer">작성자</label> <br> <!-- readonly -->
					<input type="text" name="writer" id="writer" value="${loginUser.id}">
					<label for="title">제목</label> <br>
					<input type="text" name="title" id="title" placeholder="제목">
					<label for="content">내용</label> <br>
					<textarea rows="30" cols="50" name="content" id="content" placeholder="내용 입력"></textarea>
					<!-- 단일 이미지 추가 -->
					<input type="file" name="file" id="file"> 
				</div>
				
				<button>저장하기</button>
				
			</form>
			
		</div>
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>