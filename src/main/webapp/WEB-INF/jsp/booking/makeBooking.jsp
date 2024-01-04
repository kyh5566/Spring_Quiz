<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<%-- data Picker --%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- 외부 stylesheet -->
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
	    <header class="d-flex justify-content-center align-items-center">
	        <div class="display-4">통나무 팬션</div>
	    </header>
	    <nav>
	        <ul class="nav nav-fill">
	            <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
	            <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
	            <li class="nav-item"><a href="/booking/make-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
	            <li class="nav-item"><a href="/booking/booking-list-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
	        </ul>
	    </nav>
	    <section class="contents py-4">
	        <h2 class="text-center font-weight-bold m-4">예약 목록 보기</h2>
	        <div class="d-flex justify-content-center">
	            <div class="booking-box">
	                <div class="subject-text my-2 font-weight-bold">이름</div>
	                <input type="text" class="form-control" id="name">
	
	                <div class="subject-text my-2 font-weight-bold">예약날짜</div>
	                <input type="text" class="form-control" id="date">
	
	                <div class="subject-text my-2 font-weight-bold">숙박일수</div>
	                <input type="text" class="form-control" id="day">
	
	                <div class="subject-text my-2 font-weight-bold">숙박인원</div>
	                <input type="text" class="form-control" id="headcount">
	
	                <div class="subject-text my-2 font-weight-bold">전화번호</div>
	                <input type="text" class="form-control" id="phoneNumber">
	
	                <button type="button" id="makeBookingBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
	            </div>
			</div>
	    </section>
	    <footer>
	        <small class="text-secondary">
	            제주특별자치도 제주시 애월읍<br>
	            사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
	            Copyright 2024 tongnamu. All right reserved.
	        </small>
	    </footer>
	</div>
	
<script>
	$(document).ready(function() {
		$('#date').datepicker({
			minDate:0
			, dateFormat:'yy-mm-dd'
		});
		$("#makeBookingBtn").on("click", function() {
			//alert("예약하기");
			let name = $("#name").val().trim();
			let date = $("#date").val().trim();
			let day = $("#day").val().trim();
			let headcount = $("#headcount").val().trim();
			let phoneNumber = $("#phoneNumber").val().trim();
			if(!name) {
				alert("이름을 입력하세요.");
				return;
			} else if (!date) {
				alert("예약날짜를 선택하세요.");
				return;
			} else if (!day) {
				alert("숙박일수를 입력하세요.");
				return;
			} else if (!headcount) {
				alert("숙박인원을 입력하세요.");
				return;
			} else {
				alert("전화번호를 입력하세요.");
				return;
			}
			
			if (isNaN(day)) {
				alert("숙박일수는 숫자만 입력 가능합니다.");
				return;
			}
			if (isNaN(headcount)) {
				alert("인원은 숫자만 입력 가능합니다.");
				return;
			}
			$.ajax({
				//request
				type:"post"
				,url:"/booking/make-booking"
				,data:{"name":name,"date":date,"day":day,"headcount":headcount,"phoneNumber":phoneNumber}
				,dataType:"json"
				
				//response
				,success:function(data) {
					if(data.result == "성공") {
						alert("예약되었습니다.");
						location.href = "/booking/booking-list-view";
					}
				}
				,error:function(e) {
					alert("error : " + e);
				}
				}); 
		});
	});
</script>
</body>
</html>