<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<div class="content">   
   <div class="menu">
      <div class="box_menu">
      </div>
   </div>
   <div class="notice">
     <h2><span>*공지사항</span></h2>
   </div> 
   
    <div class="desc_notice" style="left:15%; width:80%">
      <div class="tit_notice">
          <h4 class="reset">${data.notice.nIdx}</h4>
      </div>
      <div class="info" >
           <span name="noticeNo" value="${data.notice.nIdx}">게시글번호 : ${data.notice.nIdx}</span>
          <span>등록일 : ${data.notice.regDate}</span>
          <span>작성자 : ${data.notice.userId}</span>
      </div>
      <div class="info" style="height:auto">
      <c:forEach items="${data.flist}" var="file">
         <button style="margin-left:1%;" type="button" 
               onclick="downloadFile('${file.originFileName}','${file.renameFileName}')">
         ${file.originFileName}</button>
      </c:forEach>
      </div>
      <div class="text">
           ${data.notice.content}
        </div>
      <div class="btn_section">
          <button style="color:white" onclick="submitData('noticelist.do')"><span>목록</span></button>
        </div>
        <c:if test="${logInInfo.userId == data.notice.userId}">
         <div class="btn_section">
          <button style="color:white" onclick="submitData('noticedelete.do?nIdx=${data.notice.nIdx}&userId=${data.notice.userId}')"><span>삭제</span></button>
        </div>
        <div class="btn_section">
          <button style="color:white" onclick="submitData('noticeModify.do?nIdx=${data.notice.nIdx}&userId=${data.notice.userId}')"><span>수정</span></button>
        </div>
        </c:if>
        <input type="hidden" name="pwVal" id="pwVal"/>
   </div>
</div>

<script type="text/javascript">
   
   function submitData(url){
      location.href = url;
   } 
   
   function downloadFile(originalFileName, renameFileName){
        location.href = "noticedownload.do?"
            +"originalFileName="+originalFileName
            +"&renameFileName="+renameFileName
            
     /* location.href = "/resources/upload/"+rfname; */ 
  
  }

</script>










</body>
</html>