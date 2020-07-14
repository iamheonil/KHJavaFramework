<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/dept/insert" method="post">

부서번호 : <input type="text" name="deptno"> <br>
부서이름 : <input type="text" name="dname"> <br>
부서지역 : <input type="text" name="loc"> <br>
<br>
<button>전송하기!</button>

</form><br>

<a href="/dept/list">목록으로 돌아가기</a>
</body>
</html>