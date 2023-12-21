<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
    request.setCharacterEncoding("UTF-8");
%>

<head>

</head>

<body>

    <div id="ad_main_banner">
        <ul class="bjqs">
            <li><img width="959px" height="421px" src="${contextPath}/resources/image/main_banner01.jpg"></li>
            <li><img width="959" height="421" src="${contextPath}/resources/image/main_banner02.jpg"></li>
            <li><img width="959" height="421" src="${contextPath}/resources/image/main_banner03.jpg"></li>
        </ul>
    </div>

    <div class="main_book" style="background:  #5C5452; padding-top: 5px; padding-left: 10px; border-top: solid 1px white; width: 850px; margin-top: -11px;">        
    <c:set var="goods_count" value="0" />

        <h3 style="font-size: 17px; color: white; padding:10px 0px;">베스트셀러</h3>
		
        <c:forEach var="item" items="${goodsMap.bestseller}" varStatus="loop">
            <c:set var="goods_count" value="${goods_count + 1}" />

            <c:if test="${goods_count <= 4}">

                <div class="book" style="margin: 20px 10px;">
                    <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id}">
                        <img class="link" src="${contextPath}/resources/image/1px.gif">
                    </a>
                    <img width="151" height="184" src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
                    <div class="title">${item.goods_title}</div>
                    <div class="price">
                        <fmt:formatNumber value="${item.goods_price}" type="number" var="goods_price" />
                        ${goods_price}원
                    </div>
                </div>

            </c:if>
        </c:forEach>

    </div>

    <div class="clear"></div>




		
		
		<div class="main_book" style="background: #5C5452; padding-top: 5px; padding-left: 10px; border-top: solid 1px white; width: 850px;">
		
		<c:set var="goods_count" value="0" />

		<h3 style="font-size: 17px; color: white; padding: 10px 0px;">새로 출판된 책</h3>
		<div class="slider-container">
			<div class="slider">

				<c:forEach var="item" items="${goodsMap.newbook}"
					varStatus="newBookStatus">
					<c:if test="${newBookStatus.count <= 4}">
						<div class="book slideBook" style="margin: 20px 10px;">
							<a
								href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id}">
								<img class="link" src="${contextPath}/resources/image/1px.gif">
							</a> <img width="151" height="184"
								src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
							<div class="title">${item.goods_title}</div>
							<div class="price">
								<fmt:formatNumber value="${item.goods_price}" type="number"
									var="goods_price" />
								${goods_price}원
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- 세번째 배너 -->

    <div class="clear"></div>
    
    
    
    		<div id="ad_main_banner2">
			<ul class="bjqs2" >
				<li><img width="850" height="100"
					src="${contextPath}/resources/image/main_banner06.jpg"></li>
			</ul>
		</div>

    <div class="main_book" style="background:  #5C5452; padding-top: 5px; padding-left: 10px; border-top: solid 1px white; width: 850px; ">
        <c:set var="goods_count" value="0" />

        <h3 style="font-size: 17px; color: white; padding:10px 0px;">스테디셀러</h3>
        <div class="slider-container">
            <div class="slider">
                <c:forEach var="item" items="${goodsMap.steadyseller}" varStatus="steadyBookStatus">
                    <c:if test="${steadyBookStatus.count <= 4}">
                        <div class="book slideBook" style="margin: 20px 10px;">
                            <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id}">
                                <img class="link" src="${contextPath}/resources/image/1px.gif">
                            </a>
                            <img width="151" height="184" src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
                            <div class="title">${item.goods_title}</div>
                            <div class="price">
                                <fmt:formatNumber value="${item.goods_price}" type="number" var="goods_price" />
                                ${goods_price}원
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
    
        <div>
        <ul>
            <li style="list-style: none; margin-left: -30px;"><img width="850" height="100" src="${contextPath}/resources/image/main_banner07.jpg"></li>
        </ul>





	</div>

</body>
