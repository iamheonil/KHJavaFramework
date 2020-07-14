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

<h1>부서정보 상세보기</h1>
<hr>

<h2>아 상세하다 상세해</h2>

부서번호 : ${result.deptno }<br>
부서이름 : ${result.dname } <br>
부서위치 : ${result.loc } <br>
<hr>

<a href="/dept/list">목록 페이지로 돌아가기</a>


</body>
</html>