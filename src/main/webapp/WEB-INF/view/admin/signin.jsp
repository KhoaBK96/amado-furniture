<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Male fashion | Log in</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback" />
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/admin-resources/plugins/fontawesome-free/css/all.min.css" />
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/admin-resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css" />
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/admin-resources/css/adminlte.min.css" />
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href=""><img src="shop/img/logo.png" alt="Logo"></a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>

				<form:form method="post" modelAttribute="user">
				<c:if test='${sessionScope["login-failed"] != null}'>
					<div class="alert alert-danger" role="alert">
						<p>Wrong user or password!!!</p>
					</div>
					<c:remove var="login-failed" scope="session" />
				</c:if>
				<div class="input-group mb-3">

					<form:input type="userName" class="form-control" placeholder="Name"
						name="userName" path="userName"/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<form:input type="password" class="form-control" placeholder="Password"
						name="password" path="password"/>
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-8">
						<div class="icheck-primary">
							<input type="checkbox" id="remember" /> <label for="remember">
								Remember Me </label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-4">
						<button type="submit" class="btn btn-primary btn-block">
							Sign In</button>
					</div>
					<!-- /.col -->
				</div>
				</form:form>
				
				<!-- /.social-auth-links -->
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="${pageContext.servletContext.contextPath}/admin-resources/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="${pageContext.servletContext.contextPath}/admin-resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.servletContext.contextPath}/admin-resources/dist/js/adminlte.min.js"></script>
</body>
</html>
