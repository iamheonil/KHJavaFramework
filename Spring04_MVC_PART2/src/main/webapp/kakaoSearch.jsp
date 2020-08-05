<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="text" id="query">
<button onclick="kakaoBookApi()">카카오 api 통신</button>

<script type="text/javascript">
	function kakaoBookApi(){
		var query = document.querySelector('#query').value;
		var xhr = new XMLHttpRequest();
		
		//시작줄 작성
		xhr.open('GET','https://dapi.kakao.com/v3/search/book?query='+query);
		//헤더 설정
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhr.setRequestHeader('Authorization','KakaoAK e42421bd1a961b7042406b71226f82a5');
		//통신 시작
		xhr.send();
		xhr.addEventListener('load',function(){
			var data = xhr.response;
			console.dir(data);
			sendKakaoData(data);
		})
	}
	
	function sendKakaoData(data){
	  //method : POST, url : jacksoncore.do
		  var xhr = new XMLHttpRequest();
		  //시작줄 작성
		  xhr.open('POST','jacksoncore.do');
		  //헤더 설정
		  //Content-Type 설정
		  //Content-Type : application/json
		  //	Request message body에 있는 데이터가
		  //	json 형식의 데이터임을 header에 명시한다.
		  xhr.setRequestHeader('Content-Type','application/json');
		  //body에 데이터 추가하고 통신 시작
		  xhr.send(data);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	








</script>
</body>
</html>