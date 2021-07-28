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
	$(document).ready(function(){
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
		});
	} //
	var list = null;
	function fn_qnaBoard_append(resultMap){
		/* ---------------------------------------------------- */
		list = resultMap.list;
		$('#qnaBoard_list').empty();
		if (resultMap.status == 200) {
			$.each(list, function(i, notice) {
				$('<tr>')
				.append( $('<td>').text(qnaBoard.rn) )
				.append( $('<td>').html('<a href="qnaBoardView.do?no='+notice.no+'&loginUser=${loginUser.memberId}">'+qnaBoard.title+'</a>') )
				.append( $('<td>').text(qnaBoard.postdate) )
				.appendTo('#qnaBoard_list');
			});
		} else {
			$('<tr>')
			.append( $('<td colspan="3">').text('내용이 없습니다.') )
			.appendTo('#qnaBoard_list');
		}
		
		/* ---------------------------------------------------- */
		
		var paging = resultMap.paging;
		$('#qnaBoard_paging').empty();
		// ◀
		if ( paging.beginPage <= paging.pagePerBlock ) {
			$('<div>').addClass('disable').text('◀').appendTo('#qnaBoard_paging');
		} else {
			$('<div>')
			.addClass('link').addClass('previous_block')
			.attr('data-page', paging.beginPage - 1)
			.text('◀')
			.appendTo('#qnaBoard_paging');
		}
		// 1 2 3 4 5
		for (let p = paging.beginPage; p <= paging.endPage; p++) {
			if (p == paging.page) {
				$('<div>').addClass('now_page').text(p).appendTo('#qnaBoard_paging');
			} else {
				$('<div>')
				.addClass('link').addClass('go_page')
				.attr('data-page', p)
				.text(p)
				.appendTo('#qnaBoard_paging');
			}
		}
		// ▶
		if (paging.endPage == paging.totalPage) {
			// 마지막 페이지와 총 페이지가 동일하면 (다음으로 가는 링크는 없다.)
			$('<div>').addClass('disable').text('▶').appendTo('#qnaBoard_paging');
		} else {
			// 마지막 페이지가 총 페이지보다 작으면 (다음으로 가는 링크가 존재한다.)
			$('<div>')
			.addClass('link').addClass('next_block')
			.attr('data-page', paging.endPage + 1)
			.text('▶')
			.appendTo('#qnaBoard_paging');
		}
	};
	
	function fn_paging() {
		$('body').on('click', '.previous_block', function(){
			page = $(this).attr('data-page');
			fn_qnaBoardList();
		});
		$('body').on('click', '.next_block', function(){
			page = $(this).attr('data-page');
			fn_qnaBoardList();
		});
		$('body').on('click', '.go_page', function(){
			page = $(this).attr('data-page');
			fn_qnaBoardList();
		});
	}
	
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
						<td>작성일</td>
					</tr>
				</thead>
				<tbody id="qnaBoard_list"></tbody>
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