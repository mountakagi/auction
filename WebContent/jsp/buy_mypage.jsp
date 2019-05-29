<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>

.goods-price{
  font-size: 1.3rem;
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

<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">ポリテクオークション</h1>
    </div>
  </section>

    <div class="container">
    <h2>マイページ</h2>

    <div class="row">
        <div class="col-md-9">
        <h3>現在入札中の商品一覧</h3>
        	<div class="row">
 			<c:forEach var="mypageList" items="${ bidlist }" >

	          <div class="col-md-3">

	            	<p class="text-center"><img style="width: 160px" class = "img-thumbnail" src="${mypageList.image_uri}"></p>
	            	<p class="goods-title text-center"><c:out value= "${mypageList.goods_name}" /></p>
	            <div class="card-body">
	              <p class="goods-price text-center"><small>あなたの最高入札額</small><br><strong class="goods-price text-center"><c:out value= "${mypageList.bid_price}" />円</strong></p>

	              <c:choose>
	              	<c:when test="${mypageList.max_bid_user_id == user_id}">
	              		<p class="goods-price text-center"><small>最高入札者<br></small><strong>あなたです！</strong></p>
	              	</c:when>
	              	<c:otherwise>
	              		<p class="goods-price text-center"><small>最高入札者<br></small><strong><c:out value= "${mypageList.max_bid_name}" />さん</strong></p>
	              <p class="goods-price text-center"><small>最高額</small><br><strong class="goods-price text-center"><c:out value= "${mypageList.max_bid_price}" />円</strong></p>
	              	</c:otherwise>
	              </c:choose>
                <div class="d-flex justify-content-between align-items-center">
	                <form class="btn-group btn-block" method="post" action="/auction/BuyItemController">
	                	<input type="hidden" name="goods_id" value="${mypageList.goods_id}">
	                	<input type="submit" class="btn btn-danger"value="再購入ページ">
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