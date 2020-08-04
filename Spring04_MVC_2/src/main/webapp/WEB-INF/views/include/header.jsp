<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <!--viewport: 모바일브라우저에서 사용하는 가상의 window
  	데스크탑의 사이트를 모바일에 표시하려고 하면 좁은 모바일 화면에 사이트를 표시하려다 보니
  	요소들의 크기가 작아져 사용자가 사용하기 불편해진다. 확대해서 보든가 해야함...
  	이때 viewport메타태그를 이용하면 너비나 배율을 조정할 수 있다.
  	width: 넓이
  	initial-scale : 배율
  	웹환경에서는 무시되는 태그이다.
    -->
  <meta name="viewport" content="width=device-width, initial-scale=2.0">
  <title>UClass</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/common.css" />
	<!-- 
		orientation:portrait //단말기 세로방향
		orientation:landscape //단말기 가로방향

		min-aspect-ratio : 최소 화면 비율
		max-aspect-ratio : 최대 화면 비율
		
		브라우저화면상에서는 깨져서 나옴 ㅠㅠ 하지마셈
	 -->
  <link rel="stylesheet" media="screen and (min-aspect-ratio:4/3) " href="<%= request.getContextPath() %>/resources/css/web.css" />
  <link rel="stylesheet" media="screen and (max-aspect-ratio:4/3)" href="<%= request.getContextPath() %>/resources/css/mob.css" />
  <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/icon/all.css" />