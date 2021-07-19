<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>
<link rel="stylesheet" href="resources/asset/css/myPage.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		fn_insert();
	}); // 페이지 로드 이벤트 (종료)
	
	function fn_insert() {
		$('#f').submit(function(event){
			if ($('#writer').val() == '') {
				alert('작성자에 오류가 있습니다.');
				/* history.back(); */
				return false;			
			} else if ($('#review').val()== '') {
				alert('내용을 입력해주세요.');
				$('#content').focus();
				event.preventDefault();
				return false;
				
			}else if ($("select[name=review_store]").val()=='') {
				alert('가게를 선택해주세요.');
				return false;
			}else if(!$(':input:radio[id=star]:checked').val()){
				alert('별점을 선택해주세요.');
				return false;
			}
		});
	}
	


	

</script>
	
</head>
<body>
<div class="container">
		
		
		<h1 class="con_title">마이페이지</h1>
		
		<div class="flex">
			<div id="left" class="left myPage_box">
				<ul>
					<li><a href="#">예약 현황</a></li>
					<li><a href="#reservation_history_review">예약 내역 및 리뷰</a></li>
					<li><a href="#review_history">내가 쓴 리뷰</a></li>
					<li><a href="#question_history">문의 내역</a></li>
					<li><a href="#">개인 정보 수정</a></li>
				</ul>
			</div>


				<div id="insert_review">
				<h1>리뷰를 작성해 주세요.</h1>	
						<form id="f" action="updateReview.do" method="post" enctype="multipart/form-data" class="clear" >
						<div id="grade">
					<div class="startRadio">
  <label class="startRadio__box">
    <input type="radio" name="star" id="star" value="1">
    <span class="startRadio__img"><span class="blind">1</span></span>
  </label>
  <label class="startRadio__box">
     <input type="radio" name="star" id="star" value="2">
    <span class="startRadio__img"><span class="blind">2</span></span>
  </label>
  <label class="startRadio__box">
     <input type="radio" name="star" id="star" value="3">
    <span class="startRadio__img"><span class="blind">3</span></span>
  </label>
  <label class="startRadio__box">
   	 <input type="radio" name="star" id="star" value="4">
    <span class="startRadio__img"><span class="blind">4</span></span>
  </label>
  <label class="startRadio__box">
     <input type="radio" name="star" id="star" value="5">
    <span class="startRadio__img"><span class="blind">5</span></span>
  </label>
  
</div>
							<span class="grey">(평점 선택)</span>
						</div>
						<!-- 내가 간 가게의 이름+가게번호가 전달 -->
							<select name="review_store">
								<option value="${review.storeNo }">${review.storeName }</option>
							</select>
							<input type="text" name="content" id="review" placeholder="리뷰를 작성하세요" value="${review.content }">
							<input type="file" name="review_img" multiple>
							<input type="hidden" name="writer" id="writer" value="${loginUser.memberId }">
							<button>작성</button>
							
						</form>
					</div>
</div>
		
		
		
		
		
	</div> <!-- container -->
	
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>

</body>
</html>