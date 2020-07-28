<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mypage.css" />
<style>
input,textarea:focus {
        outline: none;
   }
   
input{
	top:-30%; 
	text-align:center;
} 

.leave{
		display:block;
		width:30%;
		height:10%;
		background-color:#ffc300b0;
		border-radius:6px;
		margin-top:0.5%;
		left:48%;
		transform: translateX(-50%);
}

.leave button{
	font-size:1.2vw;
	color:white;
	top:50%;
	transform: translateY(-50%);
}

.modify button{
	font-size:1.2vw;
	color:white;
	top:50%;
	transform: translateY(-50%);
}
	
.modify{
	display:block;
	width:30%;
	height:10%;
	background-color:#008eff;
	border-radius:6px;
	margin-top:0.5%;
	left:48%;
	transform: translateX(-50%);
	font-size:1.2vw;
}
.myinfo input{
	display:block;
	width:100%;
}
  
</style>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<div class="content">
	<div class="menu">
		<div class="box_menu">
		</div>
	</div>
	<br>
	<h1>MyPage</h1>
	<hr>
	<form id="form-data" action="" method="POST">
	<div class="wrap_my">
		<div class="myinfo">
			<div style="text-align:left">아이디 :</div>
			<div><input name="userId" style="width:100%" type="text" value="${loginInfo.userId}"></div>
		</div>

		<div class="myinfo">
			<div style="text-align:left">비밀번호 :</div>
			<div><input name="password" style="width:100%" type="password" value="${loginInfo.password}"></div>
		</div>
		
		<div class="myinfo">
			<div style="text-align:left">이메일 :</div>
			<div><input name="email" style="width:100%" type="text" value="${loginInfo.email}"></div>
		</div>

		<div class="myinfo">
			<div style="text-align:left">전화번호 :</div>
			<div><input name="tell" style="width:100%" type="text" value="${loginInfo.tell}"></div>
		</div>	
		<div class="modify">
			<button onclick="selectUrl('/member/modify.do')">수정하기</button>
		</div>
		<div class="leave">
			<button onclick="selectUrl('/member/leave.do')">탈퇴하기</button>
		</div>
		<br><br>
	</div>
	</form>
</div>	

<script type="text/javascript">
	function selectUrl(url){
		var root = '<%=request.getContextPath()%>';
		document.querySelector('#form-data').action = root + url;
	}
</script>


</body>

</html>