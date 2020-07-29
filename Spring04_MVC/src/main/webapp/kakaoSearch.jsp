<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		
		function kakaoBookApi() {
			
			
			var xhr = new XMLHttpRequest();
			var query = document.querySelector('#query').value;			
			// 시작줄 작성하기
			xhr.open('GET', 'https://dapi.kakao.com/v3/search/book?query='+query);
			
			// 헤더 설정하기
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			xhr.setRequestHeader('Authorization', 'KakaoAK b8aca08a034cc411244c663362b60e23');
			
			// GET 방식으로 통신시작
			xhr.send();
			
			xhr.addEventListener('load', function() {
				
				console.dir(xhr.response);
			});
		}
	
	</script>

</head>
<body>

	검색 할 내용 <input type="text" id="query">

	<button onclick="kakaoBookApi()">카카오 통신</button>

</body>
</html>