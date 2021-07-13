<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/resList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>

	// 페이지 로드 이벤트
	$(document).ready(function(){
		fn_resList();
		fn_paging();
		fn_selectResByNo();
	});
	
	
	// 가게 목록
	var page = 1;	
	function fn_resList() {
		var obj = {
			page: page
		};
		$.ajax({
			url: 'resList.do',
			type: 'post',
			contentType: 'application/json',
			data: JSON.stringify(obj),
			dataType: 'json',
			success: function(resultMap) {
				
				// 1. 목록 만들기
				
				$('#res_list').empty();	
				
				if (resultMap.exists) {
					
					$.each(resultMap.list, function(i, res){		
						$('<tr>')
						
						.append( $('<td>').text(res.no) )		
						.append( $('<td>').text(res.image) )
						.append( $('<td>').text(res.name) )
						.append( $('<td>').text(res.rating) )
						.append( $('<td>').text(res.hit) )	
						.append ($('<td>').text(res.postDate))
						.append( $('<td>').html('<input type="hidden" name="no" id="no" value="' + res.no + '">') )
						.appendTo('#res_list');		
					});				
				} else {
					$('<tr>')
					.append('<td colspan="6">등록된 가게가 없습니다.</td>')
					.appendTo('#res_list');
				}
				
				// 2. 페이징 만들기
				var paging = resultMap.paging;
				
				// 1) 기존 페이징 초기화 
				$('#paging').empty();		
				
				
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
			fn_resList();
		});
		$('body').on('click', '.go_page', function(){
			page = $(this).attr('data-page');
			fn_resList();
		});
		$('body').on('click', '.next_block', function(){
			page = $(this).attr('data-page');
			fn_resList();
		});	
	}


</script>

	
	<!-- 가게 리스트 검색-->
	<div class="outer">
		<form>
			<div class="box">
				<select>
					<option value="review">리뷰별(평점순)</option>
					<option value="hit">조회순</option>
					<option value="post">등록순</option>
				</select>	
			</div>
			
			<div class="box">
				<input type="text" id="search" name="search" class="int">
				<button>검색하기</button>
			</div>
		</form>
		
	<!-- 가게 리스트 -->
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<th>썸네일</th>
					<th>상호명</th>
					<th>평점</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>	
			</thead>
			<tbody>
				<tr>
					<td>2</td>
					<td>가게이미지</td>
					<td>가게2</td>
					<td>★★★★☆</td>
					<td>100</td>
					<td>2021-07-12</td>
				</tr>		
				
				<tr>
					<td>1</td>
					<td>가게이미지</td>
					<td>가게1</td>
					<td>★★★☆☆</td>
					<td>250</td>
					<td>2021-07-12</td>
				</tr>	
			</tbody>	
			
		<!-- 페이징 -->			
			<tfoot>
				<tr>
					<td colspan="6">
						페이징 처리 예정			<!-- ${paging} -->
					</td>
				</tr>
			</tfoot>
		</table>
	
	
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>