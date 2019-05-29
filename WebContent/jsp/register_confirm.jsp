<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />

<style>
	input {
		border: 0;
	}

	main {
		margin-top: 2rem;
	}

	footer {
		position: fixed;
  		bottom: 0;
		width: 100%;
	}

	dt+dd{
		padding: 1.2rem;
	}

</style>

<main role="main">

    <div class="container">
    	<h2 class="text-center">下記の内容で登録を行います。よろしいでしょうか？</h2>
    	<div class="row justify-content-center">
    		<div class="form-confirm col-md-4">
    			<form action ="/auction/RegisterResultController" method="post">
    				<dl>
    					<dt class="h3 text-center">ID</dt>
    					<dd class="h4"><input class="text-center" type="text"  readonly = "readonly" name = "user_name" value="${user_name}"></dd>
    					<dt class="h3 text-center">パスワード</dt>
    					<dd class="h4"><input class="text-center"  type="text" readonly = "readonly" name = "user_password" value="${user_password}"></dd>
    				</dl>
					<input class="btn btn-danger btn-block" type="submit" value="登録">
				</form>
			</div>
    	</div>
</main>

<jsp:include page="footer.jsp" />