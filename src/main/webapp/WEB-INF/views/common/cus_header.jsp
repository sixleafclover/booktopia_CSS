<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<head>
<!--  	 Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


</head>



<style>


</style>








<body >


<div style="background-color: #3498db; height: 300px; width: 100%; display: flex; flex-direction: column; align-items: center; justify-content: center; font-family: 'Arial', sans-serif; color: #fff; margin-top: -30px; border-radius: 10px; padding: 20px; box-sizing: border-box;">
    <p style="font-size: 40px; margin: 0; border: 4px solid #fff; padding: 10px; border-radius: 8px; font-weight: bold;">무엇을 도와드릴까요?</p>
    <button onclick="location.href='${contextPath}/main/main.do'" style="margin-top: 15px; background-color: #fff; color: #3498db; font-size: 17px; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; font-weight: bold;">main</button>
</div>




</body>
</html>