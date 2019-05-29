<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>オークション｜入札確認</title>
<jsp:include page="header.jsp" />

<style>
 .mt25 {
  margin-top: 50px;
 }

 .buy-price:before{
	content:"¥ ";
 }

 .buy-btn{
 	font-size: 1.6rem;
 }
</style>

<main role="main">

<div class="container mt25">
	<div class="row">
	<div class="col-md-9">
	<h2 class="text-center">${ goods.goods_name }</h2>

	<div class="text-center mt25">
  			<img src = "${goods.image_uri}" width = "200px">
	</div>

	<form class="mt25" action="/auction/BuyResultController" method="POST">

  <h3 class="buy-price text-center mt25"><span class="text-danger">${ price }</span><small> (税込) 送料込み</small></h3>

  <input type="hidden" name="price" value="${ price }">
  <p class="text-center"><span>現在の最高金額</span><c:out value= "${goods.bid_price}" />円</p>
  <p  class="text-center mt25">${ goods.description }<p>
  <input type="submit" value="入札確定" class="mt25 btn btn-danger btn-block buy-btn">
</form>
	</div>


			<jsp:include page="sidebar.jsp" />

</div>
</main>

<jsp:include page="footer.jsp" />