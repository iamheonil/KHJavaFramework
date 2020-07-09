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


	<h1>Hi</h1>
	<hr>

<c:forEach items="${jspList }" var="list">	

		번호 : ${list.NO } <br> 
		아이디 : ${list.ID } <br> 
		패스워드 : ${list.PW } <br>
		<hr>
		<br>
</c:forEach>
</body>
</html>