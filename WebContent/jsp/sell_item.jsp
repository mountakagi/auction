<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<style>
 .mt25 {
  margin-top: 50px;
 }

 .custom-file-input:lang(ja) ~ .custom-file-label::after {
  content: "参照";
}

.custom-file {
  overflow: hidden;
}
.custom-file-label {
  white-space: nowrap;
}

.mt-25{
	margin-top: 25px;
}

</style>


<script type="text/javascript" src="/auction/js/jquery.js"></script>
<script src="/auction/js/jquery.datetimepicker.full.min.js"></script>

<script>

$(function(){

	$('.custom-file-input').change(function(){
		$('.custom-file-label').text($(this).val());
	});

});

</script>


<div class="container mt25">
	<div class="row">
	<h2>商品を出品する</h2>
	<form class="mt25" action="/auction/SellConfirmController" method="POST" enctype="multipart/form-data">
  <div class="form-group">
    <label for="goods_name">商品名</label>
    <input maxlength="16" type="text" class="form-control" id="goods_name" name="goods_name"placeholder="商品名" required="required">
  <%--   <small>※ 板橋さんの私物のみ出品できます。</small> --%>
  </div>
    <div class="form-group">
    <label for="goods_name">開始価格</label>
    <input type="number" class="form-control" max="100000000" min="1" id="goods_name" name="price" aria-describedby="emailHelp" placeholder="入札最低価格を入力してください。" required="required">円
  </div>


  <div class="form-group">
      <label for="date">オークション終了日</label>
                <div class='input-group date'>
                    <input id="datetimepicker" type='text' name="deadtime" class="form-control" placeholder = "オークションの終了日時を入力してください。" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
<div class="form-group">
      <label for="date">カテゴリ</label>
                <div class='input-group date' >
                    <input type='text' name= "category" class="form-control" placeholder="生活用品など" required="required"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>

  <div class="form-group">
    <label for="exampleInputPassword1">商品説明</label>
    <textarea name="description" cols="120" rows="10" class="form-control" id="exampleInputPassword1" placeholder="商品の魅力を伝えると購入されやすくなります。"></textarea>
  </div>

	<div class="custom-file">
	  <input type="file" class="custom-file-input"  name="file" lang="ja"  required="required">
	  <label class="custom-file-label"></label>
	</div>

  	<input class="btn btn-danger btn-lg mt-25" type="submit" value="出品確認">
  </div>
</form>
	</div>
</div>


</main>

<jsp:include page="footer.jsp" />

<script>
jQuery.datetimepicker.setLocale('ja');

jQuery('#datetimepicker').datetimepicker({
 format:'Y-m-d H:i:00'
});
</script>