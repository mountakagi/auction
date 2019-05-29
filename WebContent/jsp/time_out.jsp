<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>オークション｜入札失敗</title>
<jsp:include page="header.jsp" />

<style>

.col-md-4{
	padding: 3rem;
}

</style>

<main role="main">

  <div class="album py-5 bg-light">
    <div class="container">
    	<div class="row justify-content-center">
    		<div class = "col-md-4 bg-white">
				<h3 class="text-center">入札に失敗しました。</h3>
				<p class="text-center"><small>オークションは締め切られています。</small></small></p>

				<a class="btn btn-block btn-danger" href="/auction/BuyItemListController">商品一覧</a>

			</div>
    	</div>
	</div>

</main>

<jsp:include page="footer.jsp" />