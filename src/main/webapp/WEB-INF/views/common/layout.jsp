<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("utf-8");
%>



<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">


<!-- 파비콘 (타이틀 아이콘) -->
<link rel="icon" type="image/x-icon" href="${contextPath}/resources/image/favicon.ico" />


<link href="${contextPath}/resources/css/main.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/basic-jquery-slider.css" rel="stylesheet" type="text/css" media="screen">
<link href="${contextPath}/resources/css/mobile.css" rel="stylesheet" type="text/css">
<script src="${contextPath}/resources/jquery/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/stickysidebar.jquery.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/basic-jquery-slider.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/tabs.js" type="text/javascript"></script>
<script src="${contextPath}/resources/jquery/carousel.js" type="text/javascript"></script>
<script>
	// 슬라이드 
	$(document).ready(function() {
	    // ad_main_banner2 초기화
	    $('#ad_main_banner2').bjqs2({
	        'width' : 850,
	        'height' : 100,
	        'showMarkers' : true,
	        'showControls' : false,
	        'centerMarkers' : false
	    });
	
	    // ad_main_banner 초기화
	    $('#ad_main_banner').bjqs({
	        'width' : 850,
	        'height' : 400,
	        'showMarkers' : true,
	        'showControls' : false,
	        'centerMarkers' : false
	    });
	});




	
	
	// 스티키
	//화면 오른쪽에 계속 같이 움직이는 사이드바
/*  	$(function() {
		$("#sticky").stickySidebar({
			timer : 100,
			easing : "easeInBounce"
		});
	}); */
</script>
	<title><tiles:insertAttribute name="title" /></title>
	
</head>





<body>
	<div id="outer_wrap">
		<div id="wrap">
			<header>
				   <tiles:insertAttribute name="header" />
			</header>
			<div class="clear"></div>
			<aside>
				 <tiles:insertAttribute name="side" />
			</aside>
			<article>
			 	<tiles:insertAttribute name="body" />
			</article>
			<div class="clear"></div>
			<footer>
        		<tiles:insertAttribute name="footer" />
        	</footer>
		</div>
		 <tiles:insertAttribute name="quickMenu" />
    </div>        	
</body>      
        
        