<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

	<div id="insert_review">
		<h1>리뷰를 작성해 주세요.</h1>	
		
		<form id="f" action="insertReview.do" method="post" enctype="multipart/form-data" class="clear" >
		
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
				<span class="gray grade_span">(평점 선택)</span>
			</div>
				
			<!-- 내가 간 가게의 이름+가게번호가 전달 -->
			<select name="review_store">
				<option value="">== 예약한 음식점 ==</option>
				<option value="1">목란</option>
				<option value="이삭토스트">이삭토스트</option>
				<option value="홍콩반점">홍콩반점</option>
			</select>
			<input type="text" name="content" id="review" placeholder="리뷰를 작성하세요">
			<input type="file" name="reviewimg" multiple>
			<input type="hidden" name="writer" id="writer" value="${loginUser.memberId }">
			<button>작성</button>
								
		</form>
	</div>

</body>
</html>