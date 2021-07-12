<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!-- Header -->
<jsp:include page="../layout/header.jsp">
	<jsp:param value="Main" name="title"/>
</jsp:include>

<link rel="stylesheet" href="resources/asset/css/resInsert.css">
	

	<div class="outer">
	
		<h2>가게 정보 등록하기</h2>
		
		<p>*는 필수사항입니다.</p>
		<form>
			<table border="1">
				<tr>
					<td>상호명</td>
					<td><input type="text" id="r_name" name="r_name" class="int" placeholder="*"><br></td>
				<tr>
					<td>가게 대표이미지</td>
					<td>
						<input type="text" id="r_image" name="r_image" class="int" placeholder="*"><br>
					</td>
				</tr>
				<tr>
					<td>SNS</td>
					<td><input type="text" id="r_sns" name="r_sns" class="int"><br></td>
				</tr>
				<tr>
					<td>Youtube URL</td>
					<td><input type="text" id="r_ytb" name="r_ytb" class="int"><br></td>
				</tr>
				<tr>
					<td>가게 소개</td>
					<td><textarea rows="7" cols="22"></textarea placeholder="*">  </td>
				</tr>
				<tr>
					<td>가게 번호</td>
					<td><input type="text" id="r_tel" name="r_tel"" class="int" placeholder="*"><br></td>
				</tr>
				<tr>
					<td>가게 주소</td>
					<td><input type="text" id="r_addr" name="r_addr" class="int" placeholder="*"><br></td>
				</tr>
				<tr>
					<td>운영 시간</td>
					<td><input type="text" id="r_hour" name="r_hour" class="int" placeholder="*"><br></td>
				</tr>
				<tr>
					<td>카테고리 분류</td>
					<td colspan="2">
						<input type="radio" name="food" value="k" id="f1"> 
						<label for=f1>한식</label>
						<input type="radio" name="food" value="e" id="f2"> 
						<label for=f2>양식</label>
						<input type="radio" name="food" value="w" id="f3"> 
						<label for=f3>일식</label>
						<input type="radio" name="food" value="c" id="f4"> 
						<label for=f4>중식</label>
						<input type="radio" name="food" value="a" id="f5"> 
						<label for=f5>술(+19)</label>
					</td>
				</tr>
				<tr>
					<td>메뉴 등록</td>
					<td>
						<input type="text" id="menu_name" name="menu_name" class="int" placeholder="메뉴명">
						<input type="text" id="menu_price" name="menu_price" class="int" placeholder="가격(,로 입력)">
					</td>
				</tr>
				<tr>
					<td>메뉴 사진 등록</td>
					<td>
						<input type="text" id="r_image" name="r_image" class="int"><br>
					</td>
				</tr>
				<tr>
					<td colspan="2">						
							<input type="button" value="뒤로가기" onclick="location.href='#'">
							<button>등록하기</button>
					</td>
				</tr>			
			</table>
			
			
		</form>
		
		
	
	
	</div>
<!-- Footer -->
<%@ include file="../layout/footer.jsp" %>