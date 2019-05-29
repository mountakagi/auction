<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>オークション｜ログイン</title>
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
    <form class="col-md-4 bg-white login-form" action="../LoginController" method="POST">
  <div class="form-group">
    <label for="exampleInputEmail1"><small>ユーザーID</small></label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="IDを入力してください" name="user_name">
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1"><small>パスワード</small></label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="パスワード" name="user_password">
  </div>
  <button type="submit" class="btn btn-danger btn-block">ログイン</button>
</form>
    	</div>
	</div>

</main>

<jsp:include page="footer.jsp" />