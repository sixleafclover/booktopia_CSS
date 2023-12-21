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

<div class="clear"></div>

<div class="main_book">
    <c:set var="goods_count" value="0" />

    <h3 style="font-size: 17px;">역사/인문학</h3>
    <div class="slider-container">
        <div class="slider">
            <c:forEach var="item" items="${goodsMap.history}" varStatus="historyStatus">
                <c:if test="${historyStatus.count <= 200}">
                    <div class="book slideBook">
                        <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id}">
                            <img class="link" src="${contextPath}/resources/image/1px.gif">
                        </a>
                        <img width="121" height="154" src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
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

</body>