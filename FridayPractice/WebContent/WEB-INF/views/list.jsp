<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>리스트 조회페이지</h1>
<hr>

<c:forEach items="${list }" var="list">

<a href="/dept/select?deptno=${list.deptno }">${list.deptno}</a> <br>
${list.dname} <br>
${list.loc} <br>
<hr>

</c:forEach>

</body>
</html>