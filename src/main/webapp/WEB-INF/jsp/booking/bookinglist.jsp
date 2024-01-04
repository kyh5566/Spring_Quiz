<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	 <div id="wrap" class="container">
            <header class="bg-light d-flex justify-content-center align-items-center">
                <div class="display-4">통나무 펜션</div>
            </header>
            <nav>
                <ul class="nav nav-fill">
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
                    <li class="nav-item"><a href="/booking/make-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
	            	<li class="nav-item"><a href="/booking/booking-list-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
                </ul>
            </nav>
            <div class="d-flex fustify-content-center align-items-center">
            	<div class="font-weight-bold">예약 목록 보기</div>
            </div>
            <table class="table">
            	<thead>
            		<tr>
            			<th>이름</th>
            			<th>예약날짜</th>
            			<th>숙박일수</th>
            			<th>숙박인원</th>
            			<th>전화번호</th>
            			<th>예약상태</th>
            			<th></th>
            		</tr>
            	</thead>
            	<tbody>
            		<c:forEach items="${bookingList}" var="booking">
            		<tr>
            			<td>${booking.name}</td>
            			<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 MM월 dd일"/></td>
            			<td>${booking.day}</td>
            			<td>${booking.headcount}</td>
            			<td>${booking.phoneNumber}</td>
            			<td>
            				<c:choose>
            					<c:when test="${booking.state == '대기중'}">
            						<span class="text-info">${booking.state}</span>
            					</c:when>
            					<c:when test="${booking.state == '확정'}">
            						<span class="text-success">${booking.state}</span>
            					</c:when>
            					<c:when test="${booking.state == '취소'}">
            						<span class="text-danger">${booking.state}</span>
            					</c:when>
            				</c:choose>
            			</td>
            			<td>
            				<button class="del-btn btn btn-danger" type="button" data-booking-id="${booking.id}">삭제</button>
            			</td>
            		</tr>
            		</c:forEach>
            	</tbody>
            </table>
</body>
<script>
	$(document).ready(function() {
		$(".del-btn").on("click",function() {
			//alert("삭제 클릭");
			let id = $(this).data('booking-id');
			//alert(id);
			
			$.ajax({
				type:"delete"
				,url:"/booking/delete-booking"
				,data:{"id":id}
				
			,success:function(data) {
				// {"code":200, "result":"성공"}
				if (data.result == "성공") {
					location.reload(true);
				} else {
					// {"code":500, "error_message":"삭제 실패"}
					alert(error_message);
				}
			}
			,error:function(request, status, error) {
				alert("삭제하는데 실패하였습니다. error");
			}
			
			});
		});
	});
</script>
</html>