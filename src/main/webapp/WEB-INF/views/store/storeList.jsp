<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>

	// 페이지 로드 이벤트
	$(document).ready(function(){
		fn_storeList();
		fn_paging();
		
		
	});
	
	
	// 가게 목록
	var page = 1;	
	function fn_storeList() {
		var obj = {
			page: page
		};
		$.ajax({
			url: 'storeList.do',
			type: 'post',
			contentType: 'application/json',
			data: JSON.stringify(obj),
			dataType: 'json',
			success: function(resultMap) {
				
				// 1. 목록 만들기
				
				$('#store_list').empty();	//  기존 목록 지우기
				
				/* 회원 목록 만들어주기*/
				if (resultMap.exists) {
					
					$.each(resultMap.list, function(i, store){		
						$('<tr>')						
						.append( $('<td>').text(store.storeNo) )		
						// .append( $('<td>').text(store.storeFilename) ) 썸네일 보류 
						.append( $('<td>').text(store.storeName) )
						.append( $('<td>').text(store.storeHit) )	
						.appendTo('#store_list');		
					});				
				} else {
					$('<tr>')
					.append('<td colspan="3">등록된 가게가 없습니다.</td>')
					.appendTo('#store_list');
				}
				
				// 2. 페이징 만들기
				var paging = resultMap.paging;
				
				$('#paging').empty();	// 기존 페이징 초기화		
				
				
				// 2) 이전('◀') 
				if (paging.beginPage <= paging.pagePerBlock) {	// 이전이 없음(1블록)
					// class
					// 1. disable : color silver
					$('<div>').addClass('disable').text('◀').appendTo('#paging');
				} else {	// 이전('◀')이 있음 
					// class
					// 1. previous_block : click 이벤트에서 활용
					// 2. link : cursor pointer
					$('<div>')
					.addClass('previous_block').addClass('link')
					.attr('data-page', paging.beginPage - 1)
					.text('◀')
					.appendTo('#paging')
				}
				
				// 3) 1 2 3 4 5 
				for (let p = paging.beginPage; p <= paging.endPage; p++) {
					if (p == paging.page) {		// 표시된 페이지가 현재 페이지 (링크 없음)
						// class
						// 1. now_page : color limegreen
						$('<div>')
						.addClass('now_page')
						.text(p)
						.appendTo('#paging');
					} else {
						// class
						// 1. go_page : click 이벤트에서 활용
						// 2. link : cursor pointer
						$('<div>')
						.addClass('go_page').addClass('link')
						.attr('data-page', p)
						.text(p)
						.appendTo('#paging');
					}
				}				
				
				// 4) 다음('▶')
				if (paging.endPage == paging.totalPage) {	// 다음('▶')이 없음(마지막 블록)
					// class
					// 1. disable : color silver
					$('<div>')
					.addClass('disable')
					.text('▶')
					.appendTo('#paging');
				} else {	// 다음('▶')이 있음
					// class
					// 1. next_block : click 이벤트에서 활용
					// 2. link : cursor pointer
					$('<div>')
					.addClass('next_block').addClass('link')
					.attr('data-page', paging.endPage + 1)
					.text('▶')
					.appendTo('#paging');
				}		
			}
		});
	}
	
	// 가게 목록 페이징(페이징 링크 처리) 
	function fn_paging() {
		$('body').on('click', '.previous_block', function(){
			page = $(this).attr('data-page');		
			fn_storeList();
		});
		$('body').on('click', '.go_page', function(){
			page = $(this).attr('data-page');
			fn_storeList();
		});
		$('body').on('click', '.next_block', function(){
			page = $(this).attr('data-page');
			fn_storeList();
		});	
	}


</script>

	
	<!-- 가게 리스트 검색-->
	<div class="outer">
		<form>
			<div class="box">
				<select>
				
					<!-- 리뷰별: 보류  -->
					<option value="review">리뷰별(평점순)</option> 
										
					<option value="hit">조회순</option>
					<option value="post">등록순</option>
				</select>	
		
				<input type="text" id="search" name="search" class="int">
				<button>검색하기</button>
			</div>
		
		
	<!-- 가게 리스트 -->
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<!-- <th>썸네일</th> -->
					<th>상호명</th>	
					
					<!--  ** 평점: 보류   -->
					<!--  <th>평점</th> -->
					
					<th>조회수</th>
				</tr>	
			</thead>
			<tbody id="store_list">
		
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5">
						<div id="paging"></div>
					</td>
				</tr>
			</tfoot>	
		
		</table>	
	
		</form>
	</div>
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp"%>