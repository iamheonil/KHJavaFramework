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


<h1>사원 상세 목록</h1>
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
		
		<tr>
			<td>${detail.empno }</td>
			<td>${detail.ename }</td>
			<td>${detail.job }</td>
			<td>${detail.mgr }</td>
			<%-- <td>${detail.hiredate }</td> --%>
			<td><fmt:formatDate value="${detail.hiredate }" pattern="yyyy-MM-dd" /></td>
			<td>${detail.sal }</td>
			<td>${detail.comm }</td>
			<td>${detail.deptno }</td>
		</tr>
	
	</table>

</body>
</html>