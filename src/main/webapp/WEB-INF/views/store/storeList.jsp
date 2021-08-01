<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
		fn_storeNav();
		// fn_searchLineUp();
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

	
		// 네비게이션 클릭 시, 해당 메뉴 체크
	function fn_storeNav() {
		<% 
			request.setCharacterEncoding("UTF-8");
			String storeCategory = request.getParameter("storeCategory");
			String findA = "#" + storeCategory;
		%>
		var nav = '<%= findA %>';
		$(nav).addClass('navClick');
	}
	
	

</script>


<!-- body -->
<!-- 가게 리스트 검색-->
<div class="outer">
	<form id="f" method="post">
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
		
		<!-- 
		<div id="searchLineUp" class="search_box">
			<input type="radio" name="searchLineUp" value="조회순" id="s1"> 
			<label for=s1>조회순</label>
			<input type="radio" name="searchLineUp" value="등록순" id="s2"> 
			<label for=s2>등록순</label>		
		</div>
		 -->
		
		
		<div id="lineUp" class="search_box">	
			<select id="searchLineUp" name="lineUp">
				 
				 <!--  리뷰별: 보류 
					<option value="review">리뷰별(평점순)</option> 
				-->
				 
				 <!--  
				<option value="orderByHit">조회순</option>
				<option value="orderByPost">등록순</option>
				-->
			</select>	 	
		</div>
	
		

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