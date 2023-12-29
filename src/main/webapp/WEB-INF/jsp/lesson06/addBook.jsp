<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- ajax를 사용하려면 jquery "원본" 필요, "slim" 불가 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div>
		제목
		<input type="text" id="title" class="form-control">
		</div>
		<div>
		주소
		<input type="text" id="url" class="form-control mb-3">
		</div>
		<button id="btn" type="button" class="btn btn-success">추가</button>
	</div>
	
<script>
	$(document).ready(function() {
		$("#btn").on("click", function() {
			// validation
			let title = $("#title").val();
			if (title == "") {
				alert("제목을 입력하세요");
				return;
			}
			let url = $("#url").val();
			if (url == "") {
				alert("주소를 입력하세요");
				return;
			}
			if (url.startWith("http")) {
				alert("올바르지않은 주소입니다");
				return;
			}
			console.log(title);
			console.log(url);
			
			// ajax
			$.ajax({
				//request
				type: "post"
				,url: "/lesson06/quiz01/add-book"
				,data: {"title":title, "url":url}
			
				// 응답값이 돌아오는 구역
				, success:function(data) {
				if (data == "성공") {
					location.href = "/lesson06/quiz01/after-add-book"
				}
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
			});
		};
	});
</script>
</body>
</html>