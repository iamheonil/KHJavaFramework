<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member.css" />
</head>

<body>
<div class="wrap">
	<div class="memberBox">
		<div class="login">
			<form action="<%=request.getContextPath()%>/member/loginimple.do" 
				  method="post">
				
				<p>id</p>
				<input class="login-text" type="text" name="id"/>
				<span id="checkMsg" class="checkMsg"></span>
				
				<p>password</p>
				<input class="login-text" type="password" name="pw"/>
				
				<span class="btn-login">
					<button>Login</button>
				</span>
				<span class="btn-signup">
					<a href="<%=request.getContextPath() %>/member/join.do"><button type="button">회원가입</button></a>
				</span>
			</form>
				
		</div>
	</div>
</div>
</body>
</html>