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

<h1>DEPT 리스트 조회</h1>
<hr>


<c:forEach items="${list }" var="dept">

<a href="/dept/select?deptno=${dept.deptno }">부서번호 : ${dept.deptno }</a><br>
부서이름 : ${dept.dname } <br>
부서위치 : ${dept.loc } <br>
<hr>

</c:forEach>



</body>
</html>