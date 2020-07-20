<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>부서정보 입력 페이지</h1>
<hr>

<form action="/dept/insert "method="post">
부서번호 입력 : <input type="text" name="deptno"> <br>
부서이름 입력 : <input type="text" name="dname"> <br>
부서지역 입력 : <input type="text" name="loc"> <br>
<button>전송하기</button>

</form>
</body>
</html>