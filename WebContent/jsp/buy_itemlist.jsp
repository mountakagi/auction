<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<style>

.goods-price{
  font-size: 1rem;
 }

.goods-title{
margin: 0;
}


.col-md-3{
	background-color: #FFF;
}

.col-md-3+.col-md-3{
	padding-left: 1rem;
}

.badge {
    position: absolute;
    right: 0;
    top: 0;
	border-top: 90px solid #DC3545;
	border-left: 90px solid transparent;
}
.mask-t {
    color: #fff;
    position: absolute;
	width: 100px;
	height: 120px;
    right: 0px;
    top: 0px;

}
.mask-t strong {
    display: block;
    width:100%;
    height:100%;
    line-height: 100px;
    text-align: center;
    -webkit-transform: rotate(45deg) translate(0, -25%);
    -moz-transform: rotate(45deg) translate(0, -25%);
    -ms-transform: rotate(45deg) translate(0, -25%);
    -o-transform: rotate(45deg) translate(0, -25%);
    transform: rotate(45deg) translate(0, -25%);
}

.hidden {
	display: none;
}

.jumbotron {
  background: url("/auction/img/polioku_banar.jpg") center no-repeat; background-size: cover;
  color: #fff;
}

</style>

<main class="bg-light" role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">ポリテクオークション</h1>
    </div>
  </section>

  <script type="text/javascript" src="/auction/js/jquery.js"></script>

<script>


$(function(){
	$('.col-md-3').each(function(){

		var timeArea = $(this).find('.dead-time');
		var deadTimes =  new Date(timeArea.text().trim());
		var remainingTimes = Math.ceil(new Date(deadTimes - new Date())/60000);

		var remainDay = 0;
		var remainHour = 0;
		var remainMin = 0;



		remainDay = Math.floor(remainingTimes / 1440);
		remainHour = Math.floor(remainingTimes / 60 - 24*remainDay);
		remainMin = Math.floor(remainingTimes % 60);

		if(remainingTimes > 0) {

			(remainHour)? timeArea.text(remainDay + "日" + remainHour + "時間" + remainMin+"分") : timeArea.text(remainMin+"分") ;
		} else {
			timeArea.text("オークション終了");

			$(this).find('.badge').removeClass("hidden");
			$(this).find('.mask-t').removeClass("hidden");
			$(this).find("input.btn").removeClass("btn-danger").addClass('btn-outline-dark').prop('disabled', true).val('オークション終了');
		}

	});

});

 </script>
    <div class="container">









    <h2>購入商品一覧ページ</h2>





    <div class="row">
        <div class="col-md-9  order-md-1">
        	<div class="row">
 			<c:forEach var="itemsList" items="${ goodslist }" >
	          <div class="col-md-3">
	            <div class="badge hidden">
				</div>
				<div class="mask-t hidden">
  					<strong>SOLD OUT</strong>
				</div>

	            <img style = "width: 160px;" class="img-thumbnail" src="${itemsList.image_uri}">
	            	<p class="goods-title text-center"><c:out value= "${itemsList.goods_name}" /></p>
	            <div class="card-body">
	              <p class="goods-price text-center"><small>開始価格</small><br><strong class="text-danger"><c:out value= "${itemsList.price}" />円</strong></p>
	              <c:choose>
	              	<c:when test="${itemsList.bid_price == 0}">
	              		<p class="goods-price text-center"><small>現在最高価格</small><br><strong class="text-danger">未入札</strong></p>
	              	</c:when>
	              	<c:otherwise>
	              		<p class="goods-price text-center"><small>現在最高価格</small><br><strong class="text-danger"><c:out value= "${itemsList.bid_price}" />円</strong></p>
	              	</c:otherwise>
	              </c:choose>
	              <p class="goods-price text-center"><small>出品者</small><br><strong><c:out value= "${itemsList.owner_name}" />さん</strong></p>
	              <c:choose>
	              	<c:when test="${itemsList.max_bid_user_id == user_id}">
	              		<p class="goods-price text-center"><small>最高入札者</small><br><strong>あなたです！</strong></p>
	              	</c:when>
	              	<c:when test="${empty itemsList.max_bid_name}">
	              		<p class="goods-price text-center"><small>最高入札者</small><br><strong>未入札</strong></p>
	              	</c:when>
	              	<c:otherwise>
	              		<p class="goods-price text-center"><small>最高入札者</small><br><strong><c:out value= "${itemsList.max_bid_name}" />さん</strong></p>
	              	</c:otherwise>
	              </c:choose>
	              <p class="goods-price text-center"><small>終了時刻</small><br><strong><fmt:parseDate type="BOTH" value= "${itemsList.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" var = "deadtime"   />
	              <fmt:formatDate value="${deadtime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></strong></p>


	              <p class="goods-price text-center"><small>残り時間</small><br><strong class="dead-time"><fmt:parseDate type="BOTH" value= "${itemsList.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" var = "deadtime"   />
	              <fmt:formatDate value="${deadtime}" pattern="yyyy MM-dd HH:mm:ss" /></strong></p>

                <div class="d-flex justify-content-between align-items-center">

	                <form class="btn-group btn-block" method="post" action="/auction/BuyItemController">
	                	<input type="hidden" name="goods_id" value="${itemsList.goods_id}">
	                	<input type="submit" class="btn btn-danger"value="購入ページ">
	                </form>
	              </div>
	            </div>
	          </div>
			</c:forEach>

	        </div>
			</div>
		<jsp:include page="sidebar.jsp" />

</div>
      </div>

</main>

<jsp:include page="footer.jsp" />