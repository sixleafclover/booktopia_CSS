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

<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>

<style>
* { font-family: 'Spoqa Han Sans Neo', 'sans-serif'; }
</style>



<script>



</script>

</head>






<nav>
	<ul>
		<c:choose>
			<c:when test="${side_menu=='admin_mode' }">

				<li>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"
							style="background: darkcyan; color: white;"><b>관리자 기능</b></li>
						<li class="list-group-item"><a
							href="${contextPath}/admin/goods/adminGoodsMain.do">상품관리</a></li>
						<li class="list-group-item"><a
							href="${contextPath}/admin/order/adminOrderMain.do">주문관리</a></li>
						<li class="list-group-item"><a
							href="${contextPath}/admin/member/adminMemberMain.do">회원관리</a></li>
					</ul>
				</li>

			</c:when>



			<c:when test="${side_menu=='my_page'}">

				<li>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"
							style="background: darkcyan; color: white;"><b>주문내역</b></li>
						<li class="list-group-item"><a
							href="${contextPath}/mypage/listMyOrderHistory.do">주문내역<br>배송 조회</a></li>
					</ul>
				</li>



				
				<li>
					<ul class="list-group list-group-flush">
						<li class="list-group-item" style="background: darkcyan; color: white;"><b>정보내역</b></li>
						<li class="list-group-item"><a href="${contextPath}/mypage/myDetailInfo.do">회원정보관리</a></li>
					</ul>
				</li>
						
				
				
				
			</c:when>




			<c:otherwise>
				<li>
					<ul class="list-group list-group-flush">
						<li class="list-group-item"
							style="background: #5C5452; color: white;"><b>도서</b></li>
						<li class="list-group-item"><a href="${contextPath}/main/economy.do">경제/경영</a></li>
						<li class="list-group-item"><a href="${contextPath}/main/univ.do">대학교재</a></li>
						<li class="list-group-item"><a href="${contextPath}/main/improvement.do">자기계발</a></li>
						<li class="list-group-item"><a href="${contextPath}/main/science.do">자연과학/공학</a></li>
						<li class="list-group-item"><a href="${contextPath}/main/history.do">역사/인문학</a></li>
					</ul>
				</li>

				<div class="clear"></div>
				
			</c:otherwise>
		</c:choose>
	</ul>
</nav>








</html>