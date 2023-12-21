<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>

<meta charset="utf-8">
<head>
<script type="text/javascript">
  var cnt=0;
  function fn_addFile(){
	  if(cnt == 0){
		  $("#d_file").append("<br>"+"<input  type='file' name='main_image' id='f_main_image' />");	  
	  }else{
		  $("#d_file").append("<br>"+"<input  type='file' name='detail_image"+cnt+"' />");
	  }
  	
  	cnt++;
  }
  
  
  function fn_add_new_goods(obj){
		 fileName = $('#f_main_image').val();
		 if(fileName != null && fileName != undefined){
			 obj.submit();
		 }else{
			 alert("메인 이미지는 반드시 첨부해야 합니다.");
			 return;
		 }
		 
	}
</script>    
</head>

<BODY>
<form action="${contextPath}/admin/goods/addNewGoods.do" method="post"  enctype="multipart/form-data">
		<h1>새상품 등록창</h1>
<div class="tab_container">
	<!-- 내용 들어 가는 곳 -->
	<div class="tab_container" id="container">
		<ul class="tabs">
			<li><a href="#tab1">상품정보</a></li>
			<li><a href="#tab2">상품목차</a></li>
			<li><a href="#tab3">상품저자소개</a></li>
			<li><a href="#tab4">상품소개</a></li>
			<li><a href="#tab5">출판사 상품 평가</a></li>
			<li><a href="#tab6">추천사</a></li>
			<li><a href="#tab7">상품이미지</a></li>
		</ul>
		
		
		<div class="tab_container">
			<div class="tab_content" id="tab1">
				<table >
			<tr >
				<td width=200 >제품분류</td>
				<td width=500><select name="goods_sort">
						<option value="컴퓨터와 인터넷" selected>컴퓨터와 인터넷
						<option value="경제/경영">경제/경영
						<option value="대학교재">대학교재
						<option value="자기계발">자기계발
						<option value="자연과학/공학">자연과학/공학
						<option value="역사/인문학">역사/인문학
						<option value="K-POP">k-POP
						<option value="ROCK">ROCK
						<option value="CLASSIC">CLASSIC
						<option value="JAZZ">JAZZ
					</select>
				</td>
			</tr>
			<tr >
				<td >제품이름</td>
				<td><input name="goods_title" type="text" size="40" /></td>
				
			</tr>
			
			<tr>
				<td >저자</td>
				<td><input name="goods_writer" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >출판사</td>
				<td><input name="goods_publisher" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품정가</td>
				<td><input name="goods_price" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품판매가격</td>
				<td><input name="goods_sales_price" type="text" size="40" /></td>
			</tr>
			
			
			<tr>
				<td >제품 구매 포인트</td>
				<td><input name="goods_point" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품출판일</td>
				<td><input  name="goods_published_date"  type="date" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품 총 페이지수</td>
				<td><input name="goods_total_page" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >ISBN</td>
				<td><input name="goods_isbn" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품 배송비</td>
				<td><input name="goods_delivery_price" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품 도착 예정일</td>
				<td><input name="goods_delivery_date"  type="date" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품종류</td>
				<td>
				<select name="goods_status">
				  <option value="bestseller"  >베스트셀러</option>
				  <option value="steadyseller" >스테디셀러</option>
				  <option value="newbook" selected >신간</option>
				  <option value="on_sale" >판매중</option>
				  <option value="buy_out" >품절</option>
				  <option value="out_of_print" >절판</option>
				</select>
				</td>
			</tr>
			<tr>
			 <td>
			   <br>
			 </td>
			</tr>
				</table>	
			</div>
			<div class="tab_content" id="tab2">
				<H4>책목차</H4>
				<table>	
				 <tr>
					<div class="form-floating">
					  <textarea name="goods_contents_order" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea" style="font-size: 20px;">제품 이름</label>
					</div>
					
				</tr>
				</table>	
			</div>
			<div class="tab_content" id="tab3">
				<H4>제품 저자 소개</H4>
				 <table>
  				 <tr>
					<div class="form-floating">
					  <textarea name="goods_writer_intro" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea" style="font-size: 20px;">제품 저자 소개</label>
					</div>
			    </tr>
			   </table>
			</div>
			
			<div class="tab_content" id="tab4">
				<H4>제품소개</H4>
				<table>
   				<tr>
					<div class="form-floating">
					  <textarea name="goods_intro" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea" style="font-size: 20px;">제품소개</label>
					</div>
			    </tr>
			    </table>
			</div>
			
			<div class="tab_content" id="tab5">
				<H4>출판사 제품 평가</H4>
				<table>
				 <tr>
					<div class="form-floating">
					  <textarea name="goods_publisher_comment" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea" style="font-size: 20px;">출판사 제품 평가</label>
					</div>
			    </tr>    
			</table>
			</div>
			
			<div class="tab_content" id="tab6">
				<H4>추천사</H4>
				 <table>
				<tr>
					<div class="form-floating">
					  <textarea name="goods_recommendation" class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
					  <label for="floatingTextarea" style="font-size: 20px;">추천사</label>
					</div>
			    </tr>
				    
			    </table>
			</div>
			<div class="tab_content" id="tab7">
				<h4>상품이미지</h4>
				<table >
					<tr>
						<td >이미지파일 첨부</td>
			            <br>
			            <td> 
			            	<button type="button" style="display:block;" class="btn btn-outline-secondary" onClick="fn_addFile()">파일 추가 </button>
			            <td>
			            <div> </div>
				            <div id="d_file" style="display:block; align: left;">
				            </div>
			            </td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="clear"></div>
<center>	
	 <table>
	 <tr>
			  <td align=center>
				  <input  type="button" value="상품 등록하기"  onClick="fn_add_new_goods(this.form)">
			  </td>
			</tr>
			
			
			<!-- <div class="d-grid gap-2 col-6 mx-auto">
			  <button class="btn btn-primary" value="상품 등록하기" type="button" onClick="fn_add_new_goods(this.form)">상품 등록하기</button>
			</div> -->
	 </table>
</center>	 
</div>
</form>	 