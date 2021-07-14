<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/main.css">
	
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
		
		<div id=recommandStore>
		
			<h1>음식점을 추천해 드려요!</h1>
			
			<div id="storeBox">
				<div class="box">
					<div id="img" class="box_con">
						<img alt="store1" src="resources/archive/03.jpg" />
					</div>
					<div id="content"  class="box_con">
						<h3>음식점1<span>신촌지점</span></h3>
						<h2>5/<span>1</span></h2>
						<div class="sub_p2">
							<p>잔여테이블</p>
							<p>남은 인원 (Max <span>4</span>명)</p>
						</div>
						<div id="grade">
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="grey">★</p>
							<p class="grey">(평점)</p>
						</div>
						<div id="review">
							<c:if test="${empty reivew}">
								<p>리뷰 내용이 없습니다</p>
							</c:if>
							<c:if test="${not empty reivew}">
								<p>${reivew}</p>
							</c:if>
						</div>
					</div>
				</div> <!-- box -->
				
				<div class="box">
					<div id="img" class="box_con">
						<img alt="store1" src="resources/archive/03.jpg" />
					</div>
					<div id="content"  class="box_con">
						<h3>음식점1<span>신촌지점</span></h3>
						<h2>5/<span>1</span></h2>
						<div class="sub_p2">
							<p>잔여테이블</p>
							<p>남은 인원 (Max <span>4</span>명)</p>
						</div>
						<div id="grade">
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="star">★</p>
							<p class="grey">★</p>
							<p class="grey">(평점)</p>
						</div>
						<div id="review">
							<c:if test="${empty reivew}">
								<p>리뷰 내용이 없습니다</p>
							</c:if>
							<c:if test="${not empty reivew}">
								<p>${reivew}</p>
							</c:if>
						</div>
					</div>
				</div> <!-- box -->
			</div>
			
			<div id="return">
				새로운 추천 보기<a href="#"><i class="fas fa-undo-alt"></i></a>
			</div>
			
			
		</div> <!-- selectChoiceStore -->
		
		
		<div id="insertStoreList">
			
			<h1>신규 등록한 음식점</h1>
			
			<a href="#">더보기 +</a>
			<div id="list">
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3>음식점1</h3>
					<p>내용 설명</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3>음식점1</h3>
					<p>내용 설명</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3>음식점1</h3>
					<p>내용 설명</p>
				</div>
				<div>
					<a href="#"><img alt="store1" src="resources/archive/03.jpg"></a>
					<h3>음식점1</h3>
					<p>내용 설명</p>
				</div>
				
				
			</div>
			
		</div>
		
		
		
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="layout/footer.jsp" %>