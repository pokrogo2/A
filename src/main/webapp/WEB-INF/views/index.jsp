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
						          .append( $('<img>').attr('alt', store.storeName).attr('src', 'resources/archive/'+store.orignFilename) ))
				.append( $('<div>').addClass('content').addClass('box_con')
						 .html('<h3>'+store.storeName+'<span>'+store.storeAddr1+'지점</span></h3>')
						 .html('<h2>'+store.storeMaxTable+'<span>/</span><span>'+store.storeTable+'</span></h2>')
						 .append( $('<div>').addClass('sub_p2')
								  .html('<p>잔여테이블</p>')
								  .html('<p>남은 인원 (Max <span>'+(store.storeTable*4)+'</span>명)</p>') )
						 .append( $('<div>').addClass('score')
								  .html('<p class="star">★</p>')
								  .html('<c:if test="${not empty store.reviewAvg}"> <p class="reviewAvg">'+store.reviewAvg+'</p> </c:if>')
								  .html('<c:if test="${empty store.reviewAvg}"> <p class="reviewAvg">0.0</p> </c:if>')
								  .html('<p class="grey">(평점)</p>')) ) )		        		    
				.appendTo('#storeBox');
			});
		} else {
			$('<div>').addClass('box').html('<h1 class="nothing">등록된 음식점이 없습니다.</h1>').appendTo('#storeBox');
			$('<div>').addClass('box').html('<h1 class="nothing">등록된 음식점이 없습니다.</h1>').appendTo('#storeBox');
		}
	} //
	
	
	function fn_newStore() {
		$.ajax({
			url: 'NewStore.do',
			type: 'get',
			dataType: 'json',
			success: function(resultMap) {
				
			},
			error: function(xhr, text, error) {
				
			}
		});
	} //
	
	
	
	
	
	
</script>
	
	<!-- Section -->
	<div class="container">
		
		<div id="mainSearch">
			<form id="f" action="" method="get">
				<select name="zone" id="zone">
					<option value="">지역</option>
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="부산">부산</option>
				</select>
				<select name="local" id="local">
					<option value="">구</option>
					<option value="용산">용산</option>
					<option value="서대문구">서대문구</option>
					<option value="강남">강남</option>
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
			<div id="storeBox">
				<%-- 추천 음식점 2개 (StoreDB 완료 되면 진행) --%>
				<c:forEach var="store" items="${recommandStore}">
					<div class="box">
						<div class="img box_con">
							<a href="storeView.do?storeNo=${store.storeNo}">
								<img alt="store1" src="resources/archive/${store.orignFilename}" />
							</a>
						</div>
						<div class="content box_con">
							<h3>${store.storeName}<span>${store.storeAddr1}지점</span></h3>
							<h2>${store.storeMaxTable}<span>/</span><span>${store.storeTable}</span></h2>
							<div class="sub_p2">
								<p>잔여테이블</p>
								<p>남은 인원 (Max <span>${store.storeTable * 4}</span>명)</p>
							</div>
							<div class="score">
								<p class="star">★</p>
								<c:if test="${not empty store.reviewAvg}">
									<p class="reviewAvg">${store.reviewAvg}</p>
								</c:if>
								<c:if test="${empty store.reviewAvg}">
									<p class="reviewAvg">0.0</p>
								</c:if>
								<p class="grey">(평점)</p>
							</div>
						</div>
					</div> <!-- box -->
				</c:forEach> 
			
				<!-- <div class="box">
					<div class="img box_con">
						<a href="#">
							<img alt="store1" src="resources/archive/03.jpg" />
						</a>
					</div>
					<div class="content box_con">
						<h3>음식점1<span>신촌지점</span></h3>
						<h2>5<span>/</span><span>1</span></h2>
						<div class="sub_p2">
							<p>잔여테이블</p>
							<p>남은 인원 (Max <span>4</span>명)</p>
						</div>
						<div class="score">
							<p class="star">★</p>
							<p>4.56</p>
							<p class="grey">(평점)</p>
						</div>
					</div>
				</div> box1
				<div class="box">
					<div class="img box_con">
						<a href="#">
							<img alt="store1" src="resources/archive/03.jpg" />
						</a>
					</div>
					<div class="content box_con">
						<h3>음식점2<span>신촌지점</span></h3>
						<h2>7<span>/</span><span>3</span></h2>
						<div class="sub_p2">
							<p>잔여테이블</p>
							<p>남은 인원 (Max <span>12</span>명)</p>
						</div>
						<div class="score">
							<p class="star">★</p>
							<p>4.56</p>
							<p class="grey">(평점)</p>
						</div>
					</div>
				</div> box1 -->
			</div> <!-- storeBox -->
			<div id="return">
				<a href="recommandStore.do">새로운 추천 보기<i class="fas fa-undo-alt"></i></a>
			</div>
		</div> <!-- selectChoiceStore -->
		
		
		
		<div id="insertStoreList">
			<h1>신규 등록한 음식점</h1>
			<a href="#">더보기 +</a>
			<div id="list">
				<%--  신규 음식점 STORE의 DB완료후 작성 --%>
				<c:forEach var="newStore" items="${newStore}">
					<div>
						<a href="storeView.do?storeNo=${store.storeNo}">
							<img alt="store1" src="resources/archive/${newStore.orignFilename}">
						</a>
						<h3><span class="storeCategory">${newStore.storeCategory}</span> ${newStore.storeName}</h3>
						<p>${newStore.storeAddr1} ${newStore.storeAddr2} ${newStore.storeAddr3.subString(0, 9)}...</p>
					</div>
				</c:forEach>
				<!-- <div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3><span class="storeCategory">중식</span> 음식점1 </h3>
					<p>서울 중구 정동길 6 진섭빌딩...</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3><span class="storeCategory">중식</span> 음식점2 </h3>
					<p>서울 중구 정동길 6 진섭빌딩...</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3><span class="storeCategory">중식</span> 음식점3 </h3>
					<p>서울 중구 정동길 6 진섭빌딩...</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3><span class="storeCategory">중식</span> 음식점4 </h3>
					<p>서울 중구 정동길 6 진섭빌딩...</p>
				</div> -->
				
				
				
			</div>
			
		</div>
		
	
	
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="layout/footer.jsp" %>