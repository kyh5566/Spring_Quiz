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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${BookmarkList}" var="bookmarks" varStatus="status">
				<tr>
					<td>${bookmarks.id}</td>
					<td>${bookmarks.name}</td>
					<td>${bookmarks.url}</td>
					<%-- 1. value 로 값 넣기 --%>
					<%-- <td><button type="button" class="del-btn btn btn-danger" value="${bookmarks.id}">삭제</button></td> --%>
					
					<%-- 2. data 로 값 넣기 --%>
					<td><button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmarks.id}">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script>
	$(document).ready(function() {
		// 삭제 버튼 클릭
		$(".del-btn").on("click", function(e) {
			//alert("클릭");
			
			// 1) button value 에 담은 값 가져오기
			// let id = $(this).val();
			// let id = $(this).attr("value");
			// let id = e.target.value;
			
			// 2) data 이용해서 값 가져오기
			// 태그 영역: data-bookmark-id (대문자 절대 불가)
			// 스크립트 영역: data('bookmark-id')
			let id = $(this).data('bookmark-id');
			//alert(id);
			
			$.ajax({
				//request
				type:"delete"
				,url:"/lesson06/delete-bookmark"
				,data:{"id":id}
				//response 
				,success:function(data) {
					if (data.code == 200) {
						// 성공
						location.reload(true); // 화면 그대로 새로고침 효과
					} else if (data.code == 500) {
						// 실패
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("삭제 실패(ajax)");
				}
			});
		});
	});
</script>
</body>
</html>