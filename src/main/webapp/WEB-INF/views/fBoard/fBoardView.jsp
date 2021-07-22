<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="FBoardView" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/boardTable.css">
<link rel="stylesheet" href="resources/asset/css/fBoardView.css">
<script>
	$(document).ready(function(){
		fn_fBoardNav();
		fn_update();
		fn_delete();
		fn_fReplyList();
		fn_fReply_paging();
		fn_fReply_insert();
		fn_fReply_delete();
	}); // 페이지 로드 이벤트 (종료)
	
	
	/* 함수 */
	// 자유게시판 체크 확인 (red)
	function fn_fBoardNav() {
		$('#fBoardNav').addClass('navClick');
	}
	
	function fn_update() {
		$('#updete_btn').click(function(){
			location.href='fBoardUpdatePage.do?no=${fBoard.no}';
		});
	}
	function fn_delete() {
		$('#delete_btn').click(function(){
			if(confirm('해당 게시글을 삭제하시겠습니까?')) {
				location.href='fBoardDelete.do?no=${fBoard.no}';
			}	
		});
	}
	// -------------
	// 댓글 함수
	var page = 1;
	function fn_fReplyList() {
		$.ajax({
			url: 'fReplyList.do',
			type: 'get',
			data: 'page=' + page + '&no=${fBoard.no}',
			dataType: 'json',
			success: function(resultMap){
				fn_fReply_append(resultMap);
			}
		});
	} //
	var list = null;
	function fn_fReply_append(resultMap) {
		list = resultMap.list;
		$('#fReplyList').empty();
		if(resultMap.status == 200) {
			$.each(list, function(i, fReply){
				$('<tr>')
				.append( $('<td>').text(fReply.rn) )
				.append( $('<td>').text(fReply.writer) )
				.append( $('<td>').html(fReply.content + '<span>' + fReply.postdate + '</span>') )
				.append( $('<td>').html('<input type="button" value="삭제" id="deleteReply_btn">') )
				.append( $('<input type="hidden" name="fno" id="fno">').val(fReply.fno) )
				.append( $('<input type="hidden" name="writer" id="writer">').val(fReply.writer) )
				.appendTo('#fReplyList');
			});
		} else {
			$('<tr>')
			.append( $('<td colspan="4" class="noneReply">').text('댓글을 입력해보세요.') )
			.appendTo('#fReplyList');
		}
		// paging
		var paging = resultMap.paging;
		$("#fReply_paging").empty();
		// ◀
		if (paging.beginPage <= paging.pagePerBlock) {
			// 링크없음
			$('<div>').addClass('disable').text('◀').appendTo('#fReply_paging');
		} else {
			// 이전으로 이동할 수 있는 링크가 있다.
			$('<div>')
			.addClass('link').addClass('previous_block')
			.attr('data-page', paging.beginPage - 1)
			.text('◀')
			.appendTo('#fReply_paging');
		}
		// 1 2 3 4 5
		for(let p = paging.beginPage ; p <= paging.endPage ; p++) {
			if (p == paging.page) {
				$('<div>').addClass('now_page').text(p).appendTo('#fReply_paging');
			} else {
				$('<div>')
				.addClass('link').addClass('go_page')
				attr('data-page', p)
				.text(p)
				.appendTo('#fReply_paging');
			}
		}
		// ▶
		if (paging.endPage == paging.totalPage) {
			// 링크없음
			$('<div>').addClass('disable').text('▶').appendTo('#fReply_paging');
		} else {
			// 다음으로 이동할 수 있는 링크가 있다.
			$('<div>')
			.addClass('link').addClass('next_block')
			.attr('data-page', paging.endPage + 1)
			.text('▶')
			.appendTo('#fReply_paging');
		}
	} //
	function fn_fReply_paging() {
		$('body').on('click', '.previous_block', function(){
			page = $(this).attr('data-page');
			fn_fReplyList();
		})
		$('body').on('click', '.next_block', function(){
			page = $(this).attr('data-page');
			fn_fReplyList();
		})
		$('body').on('click', '.go_block', function(){
			page = $(this).attr('data-page');
			fn_fReplyList();
		})
	} //
	
	function fn_fReply_insert() {
		$('#fReply_btn').click(function(){
			if( $('#fReply_content').val() == '' ) {
				alert('댓글 내용을 입력해주세요!');
				return false;
			}
			$.ajax({
				url: 'fReplyInsert.do',
				type: 'post',
				data: $('#f').serialize(),  
				dataType: 'json',
				success: function(resultMap) {
					alert(resultMap.message);
					fn_fReplyList();
					$('#fReply_content').val('');
				}
			});
		});
	} //
	
	function fn_fReply_delete() {
		$('body').on('click', '#deleteReply_btn', function(){
			var fno = $(this).parent().parent().find( $('input[name="fno"]') ).val();
			var writer = $(this).parent().parent().find( $('input[name="writer"]') ).val();
			if('${loginUser.memberId}' != writer) {
				alert('작성자만 삭제할 수 있습니다.');
				return false;
			}  
			if(confirm('해당 댓글을 삭제하시겠습니까?')) {
				$.ajax({
					url: 'fReplyDelete.do',
					type: 'get',
					data: 'fno=' + fno,  
					dataType: 'json',
					success: function(resultMap) {
						alert(resultMap.message);
						fn_fReplyList();
					}
				});
			}
		});
	}
			
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<h1 class="con_title">자유게시판</h1>
		
		<!-- 게시글 정보 --> 
		<div class="topBtn">
			<c:if test="${loginUser.memberId == fBoard.writer}">
				<input type="button" value="수정" id="updete_btn">
				<input type="button" value="삭제" id="delete_btn">
			</c:if>
		</div> 
		

		
		<div class="fboardView_box clear">
			<c:if test="${not empty fBoard.contentType}">
				<div class="contentType"> ${fBoard.contentType} </div>
			</c:if>
			<div> <h2>${fBoard.title}</h2> </div>
			<div class="content"> ${fBoard.content} </div>
			<c:if test="${not empty fBoard.filename1}">
				<div id="imgBox">
					<img alt="fBoardImage" src="resources/archive/${fBoard.filename1}">
				</div>
			</c:if>
			<div class="sub sub1"> ${fBoard.writer} <span class="line">|</span> ${fBoard.lastdate}</div>
			<div class="sub"> 조회수 <span class="line">|</span> <span class="hit">${fBoard.hit}</span></div>
		</div>
		
		<!-- 댓글 입력 -->
		<div class="fReply_box clear">
			<c:if test="${not empty loginUser}">
				<div id="fReply_form">
					<form id="f">
						<span>${loginUser.memberId}</span>
						<span>|</span>  
						<input type="text" name="fReply_content" id="fReply_content" placeholder="댓글 입력">
						<input type="hidden" name="writer" id="writer" value="${loginUser.memberId}" >
						<input type="hidden" name="fBoardNo" value="${fBoard.no}">
						<input type="button" value="작성" id="fReply_btn"> 
					</form>
				</div>
			</c:if>
			<div id="fReply_table" class="clear">
					<table>
						<tbody id="fReplyList">
						</tbody>
					</table>
					<span id="fReply_paging" class="paging"></span>
				</div>
		</div>
		
		<!-- 목록으로 가기 -->
		<input type="button" value="목록" onclick="location.href='fBoardPage.do'"> 
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>