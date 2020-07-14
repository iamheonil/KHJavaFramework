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

<h1>사원목록페이지</h1>
<hr>

<c:forEach items="${list }" var="emp">

${emp.empno } <br>
${emp.ename } <br>
${emp.job } <br>
${emp.deptno } <br>
<br><hr>


</c:forEach>

<a href="/dynamic/query">전송페이지로 돌아가기</a>

</body>
</html>