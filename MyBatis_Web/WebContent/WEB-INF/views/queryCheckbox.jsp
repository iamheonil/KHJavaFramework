<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>동적쿼리테스트</h1>
	<hr>
	
	<form action="/dynamic/query" method="post">
		<label>10부서 <input type="checkbox" name="deptno" value="10"></label>
		<label>20부서 <input type="checkbox" name="deptno" value="20"></label>
		<label>30부서 <input type="checkbox" name="deptno" value="30"></label>
		
		<button>전송</button>
	</form>

</body>
</html>