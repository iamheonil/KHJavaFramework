<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1> Hi </h1>
<hr>

<form action="/mybatis/selectKey" method="post">

번호 : ${selectKey.no } <br>
번호 : ${selectKey.id } <br>
번호 : ${selectKey.pw } <br>

<a href="/mybatis/selectKey">입력 폼으로</a>

</form>
</body>
</html>