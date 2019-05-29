<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %>
<jsp:useBean id="date" class="java.util.Date"/>


<style>

.sell-btn {
	font-size: 2rem;
	font-weight: bold;
}

.sell-btn:hover {
	text-decoration: none;
}

.sell-thumb{
	height: 200px;
	overflow: hidden;
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

<div class="album py-5 bg-light">
    <div class="container">

    <div class="row">

	<div class="col-md-9">

    <h2>お客様の出品一覧</h2>




		<c:choose>
	     <c:when test="${empty sellinglist}">
	       	<p ><strong>お客様の出品は存在しません。新規出品してみましょう!</strong></p>
	     </c:when>
	     <c:otherwise>
<p>出品中一覧</p>
	<div class="row">


		<c:forEach var="sellinglistitem" items="${sellinglist}">
			<fmt:parseDate var="deaddate" value="${sellinglistitem.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" />

	            <c:if test="${date.before(deaddate) and sellinglistitem.status == 1}">

				        <div class="col-md-3">
				          <div class="card mb-3 shadow-sm">
				            <img class="sell-thumb" src="${sellinglistitem.image_uri}">
								<p class="text-center"><strong><c:out value="${sellinglistitem.goods_name}"/></strong></p>
				            <div class="card-body">
				              <p class="card-text"><c:out value="${sellinglistitem.description}"/></p>
				              <p class="goods-price text-center">終了日時：<strong><fmt:parseDate type="BOTH" value= "${sellinglistitem.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" var = "deadtime"   />
			              <fmt:formatDate value="${deadtime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></strong></p>
			              <form action="SellControlController" method="post">
			              <input class="btn btn-block btn-secondary" type ="submit" value="管理する">
			              <input type="hidden" name="goods_id" value="${sellinglistitem.goods_id}">
			              </form>
					   <!--          <a class="btn btn-block btn-secondary" href="SellControlController?goods_id=${sellinglistitem.goods_id}">管理する</a>-->
				            </div>
				          </div>
				        </div>
		        </c:if>
		</c:forEach>


</div>
<p>締切済一覧</p>
    <div class="row">


		<c:forEach var="sellinglistitem" items="${sellinglist}">
			<fmt:parseDate var="deaddate" value="${sellinglistitem.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" />

	            <c:if test="${deaddate.before(date) or sellinglistitem.status == 3}">
				        <div class="col-md-3">
				          <div class="card mb-3 shadow-sm">
				            <img class="sell-thumb" src="${sellinglistitem.image_uri}">
								<p class="text-center"><strong><c:out value="${sellinglistitem.goods_name}"/></strong></p>
				            <div class="card-body">
				              <p class="card-text"><c:out value="${sellinglistitem.description}"/></p>
				              <p class="goods-price text-center">終了日時：<strong><fmt:parseDate type="BOTH" value= "${sellinglistitem.dead_time}" pattern="yyyy-MM-dd HH:mm:ss" var = "deadtime"   />
			              <fmt:formatDate value="${deadtime}" pattern="yyyy年MM月dd日 HH:mm:ss" /></strong></p>
			              <form action="SellControlController" method="post">
			              <input class="btn btn-block btn-secondary" type ="submit" value="管理する">
			              <input type="hidden" name="goods_id" value="${sellinglistitem.goods_id}">
			              </form>
				<!--  	             <a class="btn btn-block btn-secondary" href="SellControlController?goods_id=${sellinglistitem.goods_id}">管理する</a>  -->
				            </div>
				          </div>
				        </div>
		        </c:if>
		</c:forEach>


		</div>
	</div>

				<jsp:include page="sidebar.jsp" />

			</c:otherwise>
	     </c:choose>
</div>
 <a href="jsp/sell_item.jsp"><button type="submit" class="btn btn-danger btn-block sell-btn">新規出品</button></a>





      </div>
    </div>


</main>

<jsp:include page="footer.jsp" />