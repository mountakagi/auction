<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<style>
 .mt25 {
  margin-top: 50px;
 }
</style>

<main role="main">

<div class="container mt25">
	<div class="row">
	<div class="col-md-10">
	<h2>出品確認画面</h2>


	<div class="text-center">
  			<img src=${goods.image_uri} width="150px">
	</div>

	<form class="col-md-10" action="../auction/SellResultController" method="Post">
  <div class="form-group">
    <label for="goods_name">商品名</label>
    <input type="text" name="goods_name" class="form-control" id="goods_name" readonly="readonly" value="${goods.goods_name}">
  </div>

  <div class="form-group">
    <input type="text" name="img_path" class="form-control" readonly="readonly" value="${goods.image_uri}">
  </div>



      <div class="form-group">
    <label for="goods_name">価格</label>
    <input type="number" name="price" class="form-control" id="goods_name" readonly="readonly" value="${goods.price}">
  </div>
<%--
  <div class="form-group">
      <label for="date">オークション終了日</label>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' disabled="disabled" class="form-control" value="2021-05-01 24:00:00" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
 --%>
	<div class="form-group">
    <label for="goods_name">カテゴリ</label>
    <input type="text" name="category" class="form-control" id="goods_name" readonly="readonly" value="${goods.category}">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">商品説明</label>
    <textarea cols="120" name="description" rows="10" class="form-control" readonly="readonly">${goods.description}</textarea>
  </div>

  <div class="form-group">
    <label for="goods_name">終了時刻</label>
<input type="datetime" name="dead_time" class="form-control" id="goods_name" readonly="readonly" value="${goods.dead_time}">
  </div>

  <a href="./jsp/sell_item.jsp" class="btn btn-outline-dark">もどる</a>

  <input type="submit" class="btn btn-danger float-right" value="出品確定">
</form>
	</div>
</div>


</main>

<jsp:include page="footer.jsp" />