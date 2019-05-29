<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<style>
 .mt25 {
  margin-top: 50px;
 }
</style>

<main role="main">

<div class="container mt25">
	<div class="row">

	<form class="col-md-10">
	<h2>出品をキャンセル</h2>
	<p class="text-danger">下記の商品の出品をキャンセルします。よろしいですか？</p>
	<div class="text-center">
  		<img width="240px" src="${goods.image_uri}">
	</div>

  <div class="form-group">
    <label for="goods_name">商品名</label>
    <input type="email" name="goods_name" class="form-control" id="goods_name" aria-describedby="emailHelp" placeholder="商品名" readonly="readonly" value="${goods.goods_name}">
  </div>
    <div class="form-group">
    <label for="goods_name">価格</label>
    <input type="email" name="price" class="form-control" id="goods_name" aria-describedby="emailHelp" placeholder="100万円以上を入力してください。" readonly="readonly" value="${goods.price}">
  </div>

<!--
  <div class="form-group">
      <label for="date">オークション終了日</label>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
-->

	<div class="form-group">
    <label for="goods_name">カテゴリ</label>
    <input type="text" name="category" class="form-control" id="goods_name" readonly="readonly" value="${goods.category}">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">商品説明</label>
    <textarea name="description" cols="120" rows="10" class="form-control" id="exampleInputPassword1" placeholder="商品の魅力を伝えると購入されやすくなります。"readonly="readonly" >${goods.description}</textarea>
  </div>


  <a href="DeleteResultController?goods_id=${goods.goods_id}" class="btn btn-danger float-right">削除確定</a>
</form>
	</div>
</div>


</main>

<jsp:include page="footer.jsp" />