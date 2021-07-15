<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="NoticeView" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/noticeView.css">
<script>
	$(document).ready(function(){
		fn_update();
		fn_delete();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_update() {
		$('#updete_btn').click(function(){
			location.href='noticeUpdatePage.do?no=${notice.no}';
		});
	}
	function fn_delete() {
		$('#delete_btn').click(function(){
			if(confirm('해당 공지사항 게시판을 삭제하시겠습니까?')) {
				location.href='noticeDelete.do?no=${notice.no}';
			}	
		});
	}
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">공지사항</h1>
		
		<div class="noticeView_box clear">
			<div> <h2>Q. ${notice.title}</h2> </div>
			<div> ${notice.content} </div>
			<div class="sub"> ${notice.writer} <span class="line">|</span> ${notice.lastdate}</div>
			<div class="sub"> 조회수 <span class="line">|</span> <span class="hit">${notice.hit}</span></div>
			<div>
				<input type="button" value="목록" onclick="location.href='noticePage.do'">
				<c:if test="${loginUser.id == 'ADMIN'}">
					<input type="button" value="수정" id="updete_btn">
					<input type="button" value="삭제" id="delete_btn">
				</c:if>
			</div>
		</div>
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>