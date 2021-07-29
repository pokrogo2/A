<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="StoreList" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/storeList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>

	$(document).ready(function(){
		fn_search();
		fn_autoSearch();
		fn_searchOrder();
	});

	
	// 가게 목록 검색
	function fn_search(){
		$('#search_btn').click(function(){			
			$('#f').attr('action', 'storeSearch.do');
			$('#f').submit();
		});
	}
	
	
	/* 검색 결과 불러오기 */
	function fn_autoSearch(){
			$('#query').keyup(function(){
				$('#autoSearch').empty();  
				var obj = {
					column: $('#column').val(),
					query: $('#query').val()
				};
				$.ajax({
					url: 'autoSearch.do',
					type: 'post',
					contentType: 'application/json',
					data: JSON.stringify(obj),
					dataType: 'text',
					success: function(resultMap){
						console.log(resultMap);
						var result = JSON.parse(resultMap);
						if (result.status == 200) {
							$.each(result.list, function(i, store){
								$('<option>')
								.val(store[$('#column').find('option[value="' + obj.column + '"]').data('name')])
								.appendTo('#autoSearch');
							});
						}
					}
				});
			});
		}

		// 조회순, 등록순 검색
		function fn_searchOrder() {
			$('input:radio[name=searchOrder]').click(function(){
				alert($(this).val());
				/*
				$.ajax({
					url: 'searchOrder.do',
					type: 'get',
					data: 'searchOrder=' + $('input[name="searchOrder"]').val() + '&page=' + page,
					dataType: 'text',
					success: function(){
						location.href = 'storeList.do';
					}
				});
				*/
			});
	}
		
	
	
	
	
	

</script>


<!-- body -->
<!-- 가게 리스트 검색-->
<div class="outer">
	<form id="f" method="post">
		
		<!-- 상호명 검색 -->
		<div id="storeSearch" class="search_box">
			<select id="column" name="column">
				<option value="STORENAME" data-name="storeName">상호명</option>
			</select>	
			
			
		<!-- 자동 완성 검색 -->
		<input list="autoSearch" type="text" name="query" id="query">
		<datalist id="autoSearch">
		</datalist>
		 
		<input type="button" value="검색" id="search_btn" class="search_btn">						
		
		</div>
		
		
		<!-- 조회순, 등록순 검색 -->
		<div id="searchOrder" class="searchOrder_box">
			<input type="radio" name="searchOrder" value="orderByHit" id="s1"> 
			<label for=s1>조회순</label>
			<input type="radio" name="searchOrder" value="등록순" id="s2"> 
			<label for=s2>등록순</label>		
		</div>
	
		 
		
		
		
		<!-- 보류
		<div id="lineUp" class="search_box">	
			<select id="searchLineUp" name="lineUp">
				 
				 <!--  리뷰별: 보류 
					<option value="review">리뷰별(평점순)</option> 
				-->
				 
				 <!--  
				<option value="orderByHit">조회순</option>
				<option value="orderByPost">등록순</option>
				
			</select>	 	
		</div>
		 -->
		

	</form>

	
	<!-- 가게 리스트 -->
	<form>
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<th>썸네일</th>
					<th>상호명</th>	
					
					<!--  ** 평점: 보류   -->
					<!--  <th>평점</th> -->
					
					<th>조회수</th>
				</tr>	
			</thead>
			<tbody>
				
				<c:if test="${empty list}">
					<td colspan="4">등록된 가게가 없습니다.</td>
				</c:if>
				
				<c:if test="${not empty list}">
					<c:forEach var="store" items="${list}">
					<tr>
						<td>${store.storeNo}</td>
						<td><a href="storeView.do?storeNo=${store.storeNo}"><img alt="${store.originFilename}" src="resources/archive/${store.saveFilename}" style="width: 200px;"></a></td>
						<td>${store.storeName}</td>
						<td>${store.storeHit}</td>
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						${paging}
					</td>
				</tr>
			</tfoot>	
		
		</table>	

	</form>
</div>

<!-- Footer -->
<%@ include file="../layout/footer.jsp"%>