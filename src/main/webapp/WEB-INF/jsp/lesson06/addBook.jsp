<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" id="title" class="form-control">
		</div>

		<div class="form-group">
			<label for="url">URL 주소</label>
		<div class="d-flex">
			<input type="text" id="url" class="form-control">
			<button type="button" id="duplicationBtn" class="btn btn-info">중복확인</button>
		</div>
		<small class="text-danger d-none" id="duplicationText">중복된 url 입니다.</small>
		<small class="text-success d-none" id="availableUrlText">저장 가능한 url 입니다.</small>
		</div>
		
		<button type="button" id="addFavoriteBtn" class="btn btn-success btn-block">추가</button>
	</div>
	
	<script>
		$(document).ready(function() {
			//중복확인
			$("#duplicationBtn").on("click",function() {
				//alert("중복확인");
				let url = $("#url").val().trim();
				if (!url) {
					alert("url을 입력하세요");
					return;
				}
				//AJAX통신 - db 중복확인
				$.ajax({
					// request
					type:"post"
					,url:"/lesson06/is-duplication-url"
					,data:{"url":url}
					
					//response
					,success:function(data) { // data = json => dictionary
						// {"code":200,"is_duplication":true} => 중복
						if (data.is_duplication) {
							//중복
							$("#duplicationText").removeClass("d-none");
							$("#availableUrlText").addClass("d-none");
						} else {
							//중복 아님
							$("#duplicationText").addClass("d-none");
							$("#availableUrlText").removeClass("d-none");
						}
					}
					,error:function(request, status, error) {
						alert("중복 확인에 실패");
					}
				});
			});
			
			$('#addFavoriteBtn').on('click', function(e) {
				var title = $('#title').val().trim();
				var url = $('#url').val().trim();
				
				if (title == '') {
					alert("제목을 입력하세요.");
					return;
				}
				
				if (url == '') {
					alert("주소를 입력하세요.");
					return;
				}
				
				if (url.startsWith("http") == false && url.startsWith("https") == false) {
					alert("주소 형식이 잘못되었습니다.");
					return;
				}
				
				$.ajax({
					type:'post'
					, url: '/lesson06/add_book'
					, data: {'title':title, 'url':url}
					, dataType: 'json'   // response body 
					, success: function(data) {
						//- AJAX 통신 후 response로는 String 또는 JSON이 리턴되어야 한다.
						//alert(data.result);
						if (data.result == 'success') {
							location.href = "/lesson06/after-add-book";
						}
					}, error:function(e) {
						alert("error:" + e);
					} 
				});
			});
		});
	</script>
</body>
</html>