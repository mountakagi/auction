<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<style>
.jumbotron {
  background: url("/auction/img/polioku_banar.jpg") center no-repeat; background-size: cover;
  color: #fff;
}
</style>

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">ポリテクオークション</h1>
    </div>
  </section>


    <div class="container">

 		<div class="row">
        	<div class="col-md-9 text-center">
	    		<h3>こちらの商品を入札でよろしいでしょうか？</h3>
	        	<dl>
	        		<dt>商品画像</dt>
	        		<dd><img src = "${goods.image_uri}" width = "360px"></dd>
	        		<dt>商品タイトル</dt>
	        		<dd><c:out value= "${goods.goods_name}"/></dd>

	        		<dt>商品説明文</dt>
	        		<dd><c:out value= "${goods.description}"/></dd>

	        		<dt>商品金額</dt>
	        		<dd>
	        		  <c:choose>
		              	<c:when test="${goods.bid_price == 0}">
		              		開始価格:<c:out value="${goods.price}"></c:out>円
		              	</c:when>
		              	<c:otherwise>
		              		入札最高額:<c:out value="${goods.bid_price}"></c:out>円
		              	</c:otherwise>
		              </c:choose>
	        		</dd>

	        	</dl>
	        	<p>入札金額を入力してください</p>
				<form method="post" action="/auction/BuyConfirmController">
					<c:choose>
	              		<c:when test="${goods.bid_price == 0}">
	              			<input type="number" max="100000000" style="width:20%" min="1" name="price" value="${ goods.price+100 }" required="required">
	              		</c:when>

	              		<c:otherwise>
	              			<input type="number" max="100000000"  style="width:20%"  min="1" name="price" value="${ goods.bid_price+100 }" required="required">
	              		</c:otherwise>
	              	</c:choose>
	                	<input type="submit" class="btn btn-danger"value="入札">
	                </form>





			</div>
		<jsp:include page="sidebar.jsp" />

      </div>
    </div>










<!--  	                  		       <input type="text" name="price">
  		       <a class="btn btn-danger" href="buy_confirm.jsp">購入</a>
 -->
<!--
<input type="text" name="price">
<a href="buy_item.jsp">  <button type="submit" class="btn btn-danger">購入</button></a>

            </form>







            -->
<!--
<a href="buy_confirm.jsp">
buy_confirm.jspに飛びたい</a>
-->


</main>

<jsp:include page="footer.jsp" />