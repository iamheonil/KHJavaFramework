<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header class="section_header" style="top:0%">
 		<div class="top">
			<div class="logo_top"><a class="logo_text_top" href="<%= request.getContextPath() %>/index/index.do">UCLASS</a></div>
				<div class="search_top"> 
					<input Type ="text" class="inp_search_top" placeholder="검색어를 입력하세요"/>
					<button value="" class="btn_search_top"><i class="fas fa-search" style="color:black"></i></button>
				</div>
			<c:if test="${logInInfo == null}">
			<div class="top_user">
				<a class="top_user-join" href="<%=request.getContextPath()%>/member/join.do">회원가입</a>
				<a class="top_user-login" href="<%=request.getContextPath()%>/member/login.do">Login</a>
				<a class="top_user-board" href="<%=request.getContextPath()%>/notice/noticelist.do">Board</a>
			</div>
			</c:if>
			<c:if test="${logInInfo != null}">
			<div class="top_user">
				<a class="top_user-join" href="<%=request.getContextPath()%>/member/logout.do">Logout</a>
				<a class="top_user-login" href="<%=request.getContextPath()%>/member/mypage.do">MyPage</a>
				<a class="top_user-board" href="<%=request.getContextPath()%>/notice/noticelist.do">Board</a>
			</div>
			</c:if>
 		</div>
	</header>