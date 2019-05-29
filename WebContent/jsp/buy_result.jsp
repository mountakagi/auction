<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<main role="main">

  <section class="jumbotron text-center">
    <div class="container">
      <h1 class="jumbotron-heading">板橋オークション</h1>
    </div>
  </section>

    <div class="container">
      <div class="row">
        <div class="col-md-9">
                 <h2 class="text-center">おめでとうございます！！！<br>現在あなたが最高入札者です！！！</h2>
        		 <p class="text-center"><img src = "${goods.image_uri}" width = "200px"></p>
        </div>
        <jsp:include page="sidebar.jsp" />
      </div>
    </div>
</main>

<jsp:include page="footer.jsp" />