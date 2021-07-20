
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="FreeBoard" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/fBoard.css">
<link rel="stylesheet" href="resources/asset/css/boardTable.css">
<script>
	$(document).ready(function(){
		fn_fBoardList();
		fn_paging();
		fn_search();
		fn_autoDrop();
	}); // 페이지 로드 이벤트 (종료)
	
	var page = 1;
	function fn_fBoardList() {
		
		$.ajax({
			url: 'fBoardList.do',
			type: 'get',
			data: 'page='+page,
			dataType: 'json',
			success:function(resultMap){
				fn_fBoard_append(resultMap);
			},
			error:function(xhr, text, error){
				alert('실패!' + error);
				console.log(page);
			}
		});
	} //
	var list = null;
	function fn_fBoard_append(resultMap){
		/* ---------------------------------------------------- */
		list = resultMap.list;
		$('#fBoard_list').empty();
		if (resultMap.status == 200) {
			$.each(list, function(i, fBoard) {
				// 회원이 등록한 게시물일 때
				if (fBoard.contentType == null) {
					$('<tr>')
					.append( $('<td>').text(fBoard.rn) )
					.append( $('<td>').text(fBoard.writer) )
					.append( $('<td>').html('<a href="fBoardView.do?no='+fBoard.no+'&loginUser=${loginUser.memberId}">'+fBoard.title+'</a>') )
					.append( $('<td>').text(fBoard.hit) )
					.append( $('<td>').text(fBoard.lastdate) )
					.appendTo('#fBoard_list');
				} else if (fBoard.contentType == '이벤트') { 
					// 가게 사장님이 등록한 게시물일 때 : 이벤트 글일 때
					$('<tr>')
					.append( $('<td>').text(fBoard.rn) )
					.append( $('<td>').html('<span class="type event">'+fBoard.contentType+'</span>') )							
					.append( $('<td>').html('<a href="fBoardView.do?no='+fBoard.no+'&loginUser=${loginUser.memberId}">'+fBoard.title+'</a>') )
					.append( $('<td>').text(fBoard.hit) )
					.append( $('<td>').text(fBoard.lastdate) )
					.appendTo('#fBoard_list');
				} else { 
					// 가게 사장님이 등록한 게시물일 때 : 홍보글 일 때
					$('<tr>')
					.append( $('<td>').text(fBoard.rn) )
					.append( $('<td>').html('<span class="type promotion">'+fBoard.contentType+'</span>') )							
					.append( $('<td>').html('<a href="fBoardView.do?no='+fBoard.no+'&loginUser=${loginUser.memberId}">'+fBoard.title+'</a>') )
					.append( $('<td>').text(fBoard.hit) )
					.append( $('<td>').text(fBoard.lastdate) )
					.appendTo('#fBoard_list');
				}
			}); 
			
		} else {
			$('<tr>')
			.append( $('<td colspan="5">').text('내용이 없습니다.') )
			.appendTo('#fBoard_list');
		}
		
		/* ---------------------------------------------------- */
		
		var paging = resultMap.paging;
		$('#fBoard_paging').empty();
		// ◀
		if ( paging.beginPage <= paging.pagePerBlock ) {
			$('<div>').addClass('disable').text('◀').appendTo('#fBoard_paging');
		} else {
			$('<div>')
			.addClass('link').addClass('previous_block')
			.attr('data-page', paging.beginPage - 1)
			.text('◀')
			.appendTo('#fBoard_paging');
		}
		// 1 2 3 4 5
		for (let p = paging.beginPage; p <= paging.endPage; p++) {
			if (p == paging.page) {
				$('<div>').addClass('now_page').text(p).appendTo('#fBoard_paging');
			} else {
				$('<div>')
				.addClass('link').addClass('go_page')
				.attr('data-page', p)
				.text(p)
				.appendTo('#fBoard_paging');
			}
		}
		// ▶
		if (paging.endPage == paging.totalPage) {
			// 마지막 페이지와 총 페이지가 동일하면 (다음으로 가는 링크는 없다.)
			$('<div>').addClass('disable').text('▶').appendTo('#fBoard_paging');
		} else {
			// 마지막 페이지가 총 페이지보다 작으면 (다음으로 가는 링크가 존재한다.)
			$('<div>')
			.addClass('link').addClass('next_block')
			.attr('data-page', paging.endPage + 1)
			.text('▶')
			.appendTo('#fBoard_paging');
		}
	};
	
	function fn_paging() {
		$('body').on('click', '.previous_block', function(){
			page = $(this).attr('data-page');
			$('#page').val(page);
			fn_fBoardList();
		});
		$('body').on('click', '.next_block', function(){
			page = $(this).attr('data-page');
			$('#page').val(page);
			fn_fBoardList();
		});
		$('body').on('click', '.go_page', function(){
			page = $(this).attr('data-page');
			$('#page').val(page);
			fn_fBoardList();
		});
	} //
	
	
	// 검색 결과
	function fn_search() {
		$('#search_btn').click(function(){
			if($('#query').val() == '') {
				fn_fBoardList();
				return false;
			}
			// param1:column[WRITER,TITLE,CONTNET,BOTH] , param2:query, param3:page
			
			$.ajax({
				url: 'searchFBoard.do',
				type: 'get',
				data: $('#f').serialize(), 
				dataType: 'json',
				success: function(resultMap){
					$('#searchTotal').text('검색결과 : ' + resultMap.searchTotal + '개');
					if (resultMap.searchTotal == 0) {
						$('#fBoard_list').empty();
						$('<tr>')
						.addClass('searchNone')
						.append( $('<td colspan="5">').text('검색결과 없음') )
						.appendTo('#fBoard_list');
					} else {
						fn_fBoard_append(resultMap);
					}
				},
				error: function(xhr, text, error) {
					console.log('에러메세지: ' + error + ", " + text);
				}
			});
		});
	} //
	
	
	function fn_autoDrop() {
		$('#dropChoice').mouseout(function(){
			$.ajax({
				url: 'fBoardAutoDrop.do',
				type: 'get',
				data: 'drop=' + $('#dropChoice').val() + '&page=' + page,
				dataType: 'json',
				success: function(resultMap){
					$('#searchTotal').text('조회결과 : ' + resultMap.dropTotal + '개');
					if (resultMap.dropTotal == 0) {
						$('#fBoard_list').empty();
						$('<tr>')
						.addClass('searchNone')
						.append( $('<td colspan="5">').text('조회결과 없음') )
						.appendTo('#fBoard_list');
					} else {
						fn_fBoard_append(resultMap);
					}
				}
			});
		});
	}
	
	
	
</script>
	
	<!-- Section -->
	<div class="container" >
		
		<h1 class="con_title">자유게시판</h1>
		
		<c:if test="${not empty loginUser}">
			<input type="button" value="글 작성" onclick="location.href='fBoardInsertPage.do'" >		
		</c:if>

		<div id="search"  class="topSelect">
			<form id="f">
				<select name="column" id="column">
					<option value="WRITER">작성자</option>
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
					<option value="BOTH">제목+내용</option>
				</select>
				<input type="text" name="query" id="query">
				<input type="hidden" value="1" name="page" id="page">
				<input type="button" value="검색" id="search_btn">
			</form>
		</div>
		<div id="drop" class="topSelect">
			<select name="drop" id="dropChoice">
				<option value="new">최근등록 순</option>
				<option value="hitHigh">조회 순</option>
				<option value="owner">홍보글+이벤트</option>
				<option value="nonOwner">사장님글 제외</option>
			</select>
		</div>
		
		<span id="searchTotal" class="clear"></span>
		
		<div class="table_box clear">
			<table>
				<thead>
					<tr>
						<td>순번</td>
						<td>작성자</td>
						<td>제목</td>
						<td>조회수</td>
						<td>작성일</td>
					</tr>
				</thead>
				<tbody id="fBoard_list"></tbody>
				<tfoot>
					<tr>
						<td colspan="5" id="fBoard_paging" class="paging"></td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>