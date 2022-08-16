<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Amado Furniture Admin | addUser</title>

<!-- link -->
<c:import url="include/link.jsp" />
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Main Sidebar Container -->
		<c:import url="include/nav-bar.jsp" />
		<!-- Main Sidebar Container -->
		<c:import url="include/side-bar.jsp" />
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Add User</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#" />Home</a></li>
								<li class="breadcrumb-item active">Add User</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-6">
							<!-- general form elements -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Quick Example</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form:form action="save-user" modelAttribute="user"
									method="POST">
									<div class="card-body">
										<form:hidden path="userId" />
										<div class="form-group">
											<label for="name">Name</label>
											<form:input path="userName" type="name" class="form-control"
												name="name"/>
										</div>
										<div class="form-group">
											<label for="password">Password</label>
											<form:input path="password" type="text" class="form-control"
												name="password"/>
										</div>
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<input type="submit" value="submit" class="btn btn-primary"/>
									</div>
								</form:form>
							</div>
							<!-- /.card -->

							<!--/.col (right) -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer"> </footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script src="admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
		src="admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE App -->
	<script src="admin/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="admin/js/demo.js"></script>
	<!-- Page specific script -->
	<script>
		$(function() {
			bsCustomFileInput.init();
		});
	</script>
</body>
</html>
