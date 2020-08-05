<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 양식</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member.css" />
</head>
<body>
<div class="wrap">
	<div class="memberBox">
		<div class="join">
		      <form 
			       action="<%=request.getContextPath()%>/member/joinemailcheck.do"
			       method="post"
			       onsubmit="return validate();">
			       	<span class="sector-title">회원가입</span>
			        <div class="join-info">
						<p>* id</p>
						<button type="button" class="btn_id-check" onclick="xmlIdCheck()">ID 확인</button>
				  		<input type="text" name="userId" id="userId" class="join-text" size="10"/>
			  			<span id="id-check-msg" class="id-check-msg"></span>
			  		</div>
			  		<div class="join-info">
				  		<p>* password</p>
				  		<input type="password" name="password" id="userPwd" class="join-text" size="10"/>
			  		</div>
			  		<div class="join-info">
				  		<p>* email</p>
				  		<input type="text" name="email" class="join-text" size="10"/>
				  	</div>
				  	<div class="join-info">
				  		<p>* hp</p>
				  		<input type="text" name="tel" class="join-text" size="10"/>
				  	</div>
				
				  	<button type="submit" class="btn-join-submit">전송</button>
			</form>
		</div>
	</div>
</div>
	<script type="text/javascript">
	var ajaxFlag = false;
	function validate() {
        var pass = document.getElementById('password');
        var regExpPw = /(?=.*\d)(?=.*[~`!@#$%\^&*()-+=])(?=.*[a-zA-Z]).{8,15}$/;

        function chk(re, e, msg) {
            if(re.test(e.value)) {           		
                return true;          
	    	}else{
           	  alert(msg);
              e.value = "";
              e.focus();
              //기본 이벤트 취소
              return false;
            }
     	}

        if(!ajaxFlag){
        	alert("아이디 중복검사를 해주세요");
        	return false;
        }
       
        // 비밀번호 검사
      	// 암호는 영문자와 숫자로 8글자이상  기호문자 한개이상 8글자 이상
        if(!chk(regExpPw, pass,'비밀번호 숫자,영어,특수문자가 하나 이상 포함, 8글자 이상 15글자 이하')){
        	return false;
        }

        return true;
    }
	
	function xmlIdCheck(){
		//querySelector : 
		//	css선택자로 원하는 html element 객체를 불러온다.
		//  jquery의 $('')와 유사하다.
		var id = document.querySelector('#userId').value;
		var xhr = new XMLHttpRequest();
		//통신을 위한 시작줄 작성
		xhr.open('POST'
		,'<%=request.getContextPath()%>/member/idcheck.do');
		//http request header 설정
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		//http request body 설정
		//xhr.send() : 전송할 데이터가 있다면 파라미터에 넣어서 보내주면 된다.
		xhr.send('userId='+id);
		//ajax 통신이 끝난 뒤 실행할 콜백함수 등록
		xhr.addEventListener('load',function(){
			//responseBody에 있는 값을 data에 넣어줌
			var data = xhr.response;
			if(data != ''){
				ajaxFlag = false;
				document.querySelector('#id-check-msg').textContent = data + '는 이미 존재하는 아이디 입니다.';
			}else{
				document.querySelector("#id-check-msg").textContent = '사용 가능한 아이디 입니다.';
				ajaxFlag = true;
			}
		})
	}
	
	</script>
		
	
	
</body>
</html>
