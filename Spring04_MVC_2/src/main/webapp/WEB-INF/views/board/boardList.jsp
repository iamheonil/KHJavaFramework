<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
	<div class="menu" style="top: 3%">
		<div class="box_menu">
		</div>
	</div>
	<div class="notice">
	  <h2><span>*게시판</span></h2>
	</div> 
	<div class="box_search">
  	   <table class="list_notice">
       <caption></caption>
       <thead>
           <tr>
               <th style="width: 10%; height:20%;"><span>번호</span></th>
               <th style="width: 80%;"><span>제목</span></th>
               <th style="width: 10%;"><span>등록일</span></th>
           </tr>
       </thead>
       <tbody>
       
       	<c:forEach items="${noticeData.nlist}" var="notice">
           <tr>
               <td class="num">${notice.nIdx}</td>
               <td class="subject"><a href="<%= request.getContextPath() %>/notice/noticedetail.do?nIdx=${notice.nIdx}">${notice.title}</a></td>
               <td class="date">${notice.regDate}</td>
           </tr>
        </c:forEach>
        
       </tbody>
       </table>
       <div class="paging"><!-- section pagination -->
         <a href="<%= request.getContextPath() %>/notice/noticelist.do" class="nav first"><i class="fas fa-angle-double-left"></i></a>
        <c:choose>
        	<c:when test="${paging.blockStart > 1 }">
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockStart-1}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:when>
        	<c:otherwise>
        		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockStart}" class="nav prev"><i class="fas fa-angle-left"></i></a>
        	</c:otherwise>
        </c:choose>
        <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
         <a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${page}" class="num active"><span>${page}</span></a>
        </c:forEach> 
        
        <c:choose>
        	<c:when test="${paging.blockEnd+1 > paging.lastPage }">
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockEnd}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:when>
        	<c:otherwise>
         		<a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.blockEnd+1}" class="nav next"><i class="fas fa-angle-right"></i></a>
        	</c:otherwise>
   	   	</c:choose>
 	   	 
 	   	 <a href="<%= request.getContextPath() %>/notice/noticelist.do?cPage=${paging.lastPage}" class="nav last"><i class="fas fa-angle-double-right"></i></a>
      	<div class="btn_section" style="background-color:white">
      	 <a href="<%= request.getContextPath() %>/board/boardform.do" style="font-size:1.1vw">공지 쓰기</a>
   	  	</div>
   	   </div><!-- // section pagination -->
   	   
     </div>
	
</body>
</html>