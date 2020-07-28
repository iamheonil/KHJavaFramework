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
			       action="<%=request.getContextPath()%>/member/joinimple.do"
			       method="post">
			       	<span class="sector-title">회원가입</span>
			        <div class="join-info">
						<p>* id</p>
						<button type="button" class="btn_id-check" onclick="idCheck()">ID 확인</button>
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
				  		<input type="text" name="tell" class="join-text" size="10"/>
				  	</div>
				  	<button type="submit" class="btn-join-submit">전송</button>
			</form>
		</div>
	</div>
</div>
	
	
</body>
</html>
