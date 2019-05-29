<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>オークション｜メインページ</title>
<jsp:include page="header.jsp" />

<style>
.btn-buy, .btn-sell {
	font-size: 3.8rem;
}

.col-md-12 + .col-md-12{
	margin-top: 3.8rem;
}

.jumbotron {
  background: url("/auction/img/polioku_banar.jpg") center no-repeat; background-size: cover;
}
</style>

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">ポリオク</h1>
    </div>

  </section>

 <div class="container">


 <div class="row">
 <div class="col-md-12">
 <a href="../auction/BuyItemListController" class = "btn btn-danger btn-block btn-buy"><strong>購入一覧ページ</strong></a>
 </div>
  <div class="col-md-12">
 <a href="../auction/SellItemListController" class = "btn btn-outline-info btn-block btn-sell"><strong>出品一覧ページ</strong></a>
 </div>
 </div>
</div>

</main>

<jsp:include page="footer.jsp" />