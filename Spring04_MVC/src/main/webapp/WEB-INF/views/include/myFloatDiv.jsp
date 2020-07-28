<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<aside class="floatdivWrapper">
	<div class="floatdiv"><!-- lnb -->
        <h3 class="subject"><span> - 메뉴</span></h3>
        <ul class="fdlist"><!-- d1 -->
            <li class="d1">
            	<i class="far fa-clipboard"></i>
                <a href="#!"><span>마이페이지</span></a>
            </li>
            <li class="d1">
            	<i class="fas fa-search-plus"></i>
                <a href="/<%= request.getContextPath() %>/use/rentbooklist.do"><span>대출목록</span></a>
			</li>
            <li class="d1">
            	<i class="far fa-question-circle"></i>
            	<a href="#!"><span>고객센터</span></a>
            </li>
            <li class="d1">
            	<i class="fas fa-users"></i>
                <a href="#!"><span>About us</span></a>
            </li>
        </ul><!-- // d1 -->
    </div>
	</aside> 