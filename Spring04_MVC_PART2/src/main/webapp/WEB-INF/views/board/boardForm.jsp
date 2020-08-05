<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<!-- 에디터 영역 생성 -->
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<%-- 
<script src="<%= request.getContextPath() %>/resources/ckeditor/ckeditor.js"></script> 
--%>
	
	<div class="menu">
		<div class="box_menu">
		</div>
	</div>
	<div class="notice">
	  <h2><span>*게시판</span></h2>
	</div> 
	<!--
		Request Message Header 
		Content-Type : multipart/form-data 
		여러 종류의 데이터가 동시에 서버에게 보내질 때 사용
	-->
	<form action="<%= request.getContextPath() %>/notice/noticeupload.do" method="post" enctype="multipart/form-data">
	 	<div class="desc_notice">
	 		<div>
			    <div class="tit_notice">
			          	제목 : <input type="text" name="title"/>
			          	<!-- multiple : 여러개의 파일 선택을 허용하는 속성 -->
			          	파일업로드 : <input type="file" name="files" id="contract_file" multiple/>
		        </div>
		        <div class="text">
			      <textarea cols="150" rows="15" name="content" id="content" style="resize: none;"></textarea> 
			    </div>
		    </div>
		    <div class="btn_section" style="background-color:red">
	       	  <button style="color:white; text-align:center; font-size:1.5vw">전송</button>
	   	    </div>
		</div>
	</form>
	<script type="text/javascript">
	</script>
</body>
</html>