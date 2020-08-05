<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>


	<script type="text/javascript">
		function deleteFile(fIdx){
			
			console.log(fIdx);
			
			var xhr = new XMLHttpRequest();
			
			// 통신을 위한 시작줄 설정
			xhr.open('POST', '<%= request.getContextPath() %>/notice/noticeFileDelete.do');
			
			// http Request header 설정
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			// http Request body 설정
			// 전송할 데이터가 있다면 여기에 담아서 전ㄱ송
			xhr.send('fIdx=' + fIdx)
			
			// ajax 통신이 끝난 뒤 실행할 콜백함수 등록
			xhr.addEventListener('load', function() {
				
				var res = xhr.response;
				
				if(res = '1') {
					document.querySelector('#f'+fIdx).remove();
				} else {
					alert('hi');
				}

				
		})
	}

	</script>

</head>
<body>
<!-- 에디터 영역 생성 -->
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
<%-- 
<script src="<%= request.getContextPath() %>/resources/ckeditor/ckeditor.js"></script> --%>
	
	<div class="menu">
		<div class="box_menu">
		</div>
	</div>
	<div class="notice">
	  <h2><span>*게시판</span></h2>
	</div> 
	<form  
		action="<%= request.getContextPath() %>/notice/noticeupload.do"
		method="post" 
		enctype="multipart/form-data"
		style="left:15%; width:80%">
	 	<div class="desc_notice" >
	 		<div>
			    <div class="tit_notice">
			          	제목 : <input type="text" name="title" value="${data.notice.title}"/>
			          	파일업로드 : <input type="file" name="files" id="contract_file" multiple/>
		        </div>
		        <div class="info" style="height:auto; background-color:lightblue">
					<c:forEach items="${data.flist}" var="file">
						<button style="margin-left:1%;" type="button" onclick="deleteFile('${file.fIdx}')" id='f${file.fIdx}'>
						${file.originFileName} <i class="fas fa-times"></i></button>
					</c:forEach>
	      		</div>
		        <div class="text">
			      <textarea rows="15" name="content" id="content" style="resize: none; width:100%; ">
			      	${data.notice.content}
			      </textarea> 
			    </div>
		    </div>
		    <div class="btn_section" style="background-color:red">
	       	  <button style="color:white; text-align:center; font-size:1.5vw">전송</button>
	   	    </div>
		</div>
	</form>

</body>
</html>