<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>사원 전체 목록</h1>
<hr>

	<table>
		<thead>
			<tr>
				<td>사원번호</td>	
				<td>사원이름</td>	
				<td>직업</td>	
				<td>매니저번호</td>	
				<td>입사일</td>	
				<td>월급</td>	
				<td>커미션</td>	
				<td>부서번호</td>	
			</tr>
		</thead>
		
	<c:forEach items="${list }" var="emp">
		<tr>
			<td>${emp.empno }</td>
			<td><a href="detail?ename=${emp.ename}">${emp.ename }</a></td>
			<td>${emp.job }</td>
			<td>${emp.mgr }</td>
			<%-- <td>${emp.hiredate }</td> --%>
			<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy-MM-dd" /></td>
			<td>${emp.sal }</td>
			<td>${emp.comm }</td>
			<td>${emp.deptno }</td>
		</tr>
	</c:forEach>
	
	</table>

</body>
</html>