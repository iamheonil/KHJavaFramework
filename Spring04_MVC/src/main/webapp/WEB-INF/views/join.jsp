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
			       action="<%=request.getContextPath()%>/member/joinemailCheck.do"
			       method="post"
			       onsubmit="return validate();">
			       	<span class="sector-title">회원가입</span>
			        <div class="join-info">
						<p>* id</p>
						<button type="button" class="btn_id-check" onclick="idCheck()">ID 확인</button>
				  		<input type="text" name="userId" id="userId" class="join-text" size="10"/>
			  			<span id="id-check-msg" class="id-check-msg"></span>
			  		</div>
			  		<div class="join-info">
				  		<p>* password</p>
				  		<input type="password" name="userPwd" id="userPwd" class="join-text" size="10"/>
			  		</div>
			  		<div class="join-info">
				  		<p>* email</p>
				  		<input type="text" name="m_email" class="join-text" size="10"/>
				  	</div>
				  	<div class="join-info">
				  		<p>* hp</p>
				  		<input type="text" name="m_tell" class="join-text" size="10"/>
				  	</div>
				  	<button type="submit" class="btn-join-submit">전송</button>
			</form>
		</div>
	</div>
</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.js"
	  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
 	  crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	var ajaxFlag = false;
	function validate() {
		
        var pass = document.getElementById('userPwd');
        var regExpPw = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;

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
        if(!chk(regExpPw, pass,'비밀번호 숫자,영어,특수문자가 하나 이상 포함, 8글자 이상 50글자 이하')){
        	return false;
        }

        return true;
    }
	
	function idCheck(){
		//추가된 코드
		var jacksonTest = {userId:$('#userId').val()};
		var id = $('#userId').val();
		$.ajax(
			{
				url:'<%=request.getContextPath()%>/member/idcheck.do?userId=' + id,
				type : 'get',
				//data:$("#userId").serialized(),
				//추가된 코드
				//data:jacksonTest,
				success:function(data){
					if(data != ''){
						document.querySelector('#id-check-msg').textContent = data.m_id + '는 이미 존재하는 아이디 입니다.';						
					}else{
						document.querySelector('#id-check-msg').textContent = '사용 가능한 아이디 입니다.';
						ajaxFlag = true;
					}
				}
			}
		)
	}
	
	</script>
	
</body>
</html>
