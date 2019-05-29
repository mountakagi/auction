<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<style>
.login-form {
	padding: 3rem;
}
</style>

<main role="main">

  <div class="album py-5 bg-light">
    <div class="container">
    	<div class="row justify-content-center">
    	<form class="col-md-4 bg-white login-form" action="/auction/RegisterConfirmController" method="post">

  <div class="form-group">
    <label for="exampleInputEmail1"><small>新規ユーザー登録</small></label>
    <input type="text" name="user_name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="ユーザー名を入力してください">
	<c:out value="${errlog}"/>
  </div>



  <div class="form-group">
    <label for="exampleInputPassword1"><small>新規パスワード</small></label>
    <input type="password" class="form-control" name="user_password" id="exampleInputPassword1" placeholder="パスワード">
  </div>

  <button type="submit" class="btn btn-danger btn-block">登録</button>
</form>
    	</div>
	</div>

</main>

<jsp:include page="footer.jsp" />