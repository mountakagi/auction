<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<style>
footer {
		width: 100%;
}
</style>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-4 text-center">
			<h2>登録完了しました！</h2>
				<p>ログインページよりログインすることでオークションに参加できます。</p>
				<a class="btn btn-block btn-danger" href="/auction/jsp/login.jsp">ログインページ</a>
				<a class="btn btn-block btn-outline-dark" href="/auction">トップに戻る</a>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" />