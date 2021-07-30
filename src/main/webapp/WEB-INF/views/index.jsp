<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/main.css">

<script>
	$(document).ready(function(){
		fn_mainSearchSelect_zone();
		fn_mainSearchSelect_local();
		fn_search();
		fn_bannerLink();
		fn_recommandStore();
		fn_newStore();
	}) // 페이지 로드 이벤트 종료
	
	function fn_bannerLink() {
		$('#storeBann').click(function(){
			$.ajax({
				url: 'storeExist.do',
				type: 'post',
				data: 'ownerNo=${ownerUser.ownerNo}',
				dataType: 'json',
				success: function(resultMap) {
					$('#storeBann').attr('href', resultMap.view);
				}
			});
		});
	} //
	
	 
	function fn_recommandStore() {
		$.ajax({
			url: 'recommandStore.do',
			type: 'get',
			dataType: 'json',
			success: function(resultMap) {
				fn_recommandStore_append(resultMap);
			},
			error: function(xhr, text, error) {
				alert('오류!' + error);
			}
		});
	} // ↕ 연결
	var recommandStore = null;
	function fn_recommandStore_append(resultMap) {
		$('#storeBox').empty();
		if (resultMap.status == 200) {
			recommandStore = resultMap.recommandStore;
			$.each(recommandStore, function(i, store) {
				$('<div>').addClass('box')
				.append( $('<div>').addClass('img').addClass('box_con')
						 .append( $('<a>').attr('href', 'storeView.do?storeNo='+store.storeNo)
						          .append( $('<img>').attr('alt', store.storeName).attr('src', 'resources/archive/'+store.originFilename) ) ) )
				.append( $('<div>').addClass('content').addClass('box_con')
						 .append( $('<p class="category">'+store.storeCategory+'</p>') )
						 .append( $('<h3>'+store.storeName+'</h3>') )
						 .append( $('<p class="p addr">'+store.storeAddr1+' '+store.storeAddr2+' '+store.storeAddr3+'</p>') ) 
						 .append( $('<p class="p time"><span>영업시간</span>'+store.storeTime+'</p>') )
						 .append( $('<div>').addClass('score')
								  .append( $('<p class="star">★</p>') )
								  .append( $('<p class="reviewAvg">'+store.reviewAvg+'</p>') )
								  .append( $('<p class="grey">(평점)</p>') ) ) ) 		        		    
				.appendTo('#storeBox');
			});
		} else if(resultMap.status == 500) {
			$('<div>').addClass('box').html('<p class="nothing">등록된 음식점이 없습니다.</p>').appendTo('#storeBox');
			$('<div>').addClass('box').html('<p class="nothing">등록된 음식점이 없습니다.</p>').appendTo('#storeBox');
		}
	} //
	
	
	function fn_newStore() {
		$.ajax({
			url: 'NewStore.do',
			type: 'get',
			dataType: 'json',
			success: function(resultMap) {
				fn_newStore_append(resultMap);
			},
			error: function(xhr, text, error) {
				
			}
		});
	} // ↕ 연결
	var newStore = null;
	function fn_newStore_append(resultMap) {
		$('#list').empty();
		if (resultMap.status == 200) {
			newStore = resultMap.newStore;
			$.each(newStore, function(i, store) {
				$('<div>')
				.append( $('<a>').attr('href', 'storeView.do?storeNo='+store.storeNo)
						 .append( $('<img>').attr('alt', store.storeName).attr('src', 'resources/archive/'+store.originFilename) ))
				.append( $('<h3><span class="storeCategory">'+store.storeCategory+'</span>'+store.storeName+'</h3>') )
				.append( $('<p>'+store.storeAddr1+' '+store.storeAddr2+' '+store.storeAddr3+'</p>') )
				.appendTo('#list');
			});
		} else if(resultMap.status == 500) {
			$('#insertStoreList').empty();
		}
	}//
	
	
	// 메인 검색 바의 지역 선택 조건
	var zoneList = null;
	function fn_mainSearchSelect_zone() {
		$.ajax({
			url: 'zoneSelect.do',
			type: 'get',
			dataType: 'json',
			success: function(resultMap){
				if (resultMap.status == 200) {
					zoneList = resultMap.zoneList;
					$.each(zoneList, function(i, zoneList) {
						$('<option>').attr('value', zoneList.zone).text(zoneList.zone).appendTo('#zone');
					});
				}
			}, 
			error: function(xhr, text, error){
				alert('오류!' + error);
			}
		});
	} //
	var localList = null;
	function fn_mainSearchSelect_local() {
		$( 'body' ).on('click', '#zone', function(event){
			$('#local').empty();
			$('<option>').attr('value', '').text('구 선택').appendTo('#local'); // <option value=""> = 구 = </option>
			// 지역의 value가 존재할 때만 진행하겠다.
			if ( $('#zone').val() != '' ) {
				$.ajax({
					url: 'localSelect.do',
					type: 'get',
					data: 'zone=' + $('#zone').val(),
					dataType: 'json',
					success: function(resultMap) {
						if (resultMap.status == 200) {
							localList = resultMap.localList;
							if (localList != null && localList != '') { // 지역의 구가 존재하는 경우에만 진행하겠다.
								$.each(localList, function(i, localList) {
									$('<option>').attr('value', localList.local).text(localList.local).appendTo('#local');
								});								
							}
						}
					}
				});
			}
		});
	}//
			
	
	// 검색 시 주의 사항
	function fn_search() {
		$('#f').submit(function(event) {
			if ( $('#zone').val() == '' ) {
				alert('지역 선택은 필수입니다.');
				event.preventDefault();
				return false;
			}
		});
	} //
	
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<div id="mainSearch">
			<form id="f" action="searchStore.do" method="get">
				<select name="zone" id="zone">
					<option value="">지역 선택</option>
				</select>
				<select name="local" id="local">
					<option value="">구 선택</option>
					<!--  
						지역 선택하면 알아서 그 지역의 구만 보여준다
						<option value="강남">강남</option>
					-->
				</select>
				<select name="catg" id="catg">
					<option value="">음식점 카테고리</option>
					<c:forEach var="catg" items="${category}">						
						<option value="${catg}">${catg}</option>
					</c:forEach>
				</select>
				<input type="text" name="query" id="query" placeholder="검색어를 입력하세요">
				<button><i class="fas fa-search"></i></button>
			</form>
		</div> <!-- mainSearch -->
		
		
		<!-- 가게관리 배너 : ownerUser확인 -->
		<c:if test="${not empty ownerUser}">
			<div class="storebannBox">
				<a id="storeBann"><img alt="banner1" src="resources/asset/img/mainBanner1.png"></a>
			</div>
		</c:if>
		
		
		<div id=recommandStore>
		
			<h1>음식점을 추천해 드려요!</h1>
			<div id="storeBox"></div> <!-- 추천 음식점 2box -->
			<div id="return">
				<a href="index.do#mainSearch">새로운 추천 보기<i class="fas fa-undo-alt"></i></a>
			</div>
		</div> <!-- recommandStore -->
		
		
		<div id="insertStoreList">
			<h1>신규 등록한 음식점</h1>
			<a href="#">더보기 +</a>
			<%--  신규 음식점 STORE 리스트 --%>
			<div id="list"></div>
		</div> <!-- insertStoreList -->
			
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="layout/footer.jsp" %>