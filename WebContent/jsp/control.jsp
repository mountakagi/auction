<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />
<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">板橋オークション</h1>
    </div>
  </section>




  <div class="container">

  <div class="row justify-content-center">

  <div class="col-md-4">

<h2 class="text-center">${goods.goods_name}</h2>

<p class="text-center"><img width="240px" src="${goods.image_uri}" src=""></p>

  <div class="form-group">

	 <form action="FinishConfirmController" method="post">
			              <input class="btn btn-danger btn-block" type ="submit" value="締切">
			              <input type="hidden" name="goods_id" value="${goods.goods_id}">
	</form>

	<form action="DeleteConfirmController" method="post">
			              <input class="btn btn-outline-dark btn-block" type ="submit" value="削除">
			              <input type="hidden" name="goods_id" value="${goods.goods_id}">
	</form>

<!--
  <a href="FinishConfirmController?goods_id=${goods.goods_id}" class="btn btn-danger btn-block">締切</a>
  <a href="DeleteConfirmController?goods_id=${goods.goods_id}" class="btn btn-outline-dark btn-block">削除</a>

   -->

 </div>

</div>
</div>
</div>


</main>

<jsp:include page="footer.jsp" />