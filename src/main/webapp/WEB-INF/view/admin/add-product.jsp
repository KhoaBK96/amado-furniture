<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Amado Furniture Admin | addProduct</title>

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
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Add Product</li>
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
								<form:form action="save-product" modelAttribute="product"
									method="POST">
									<div class="card-body">
										<form:hidden path="id" />
										<div class="form-group">
											<label for="name">Name</label>
											<form:input path="name" type="name" class="form-control"
												name="name" />
										</div>

										<div class="form-group">
											<label for="price">Price</label>
											<form:input path="price" type="price" class="form-control"
												name="price" />
										</div>

										<div class="form-group">
											<label for="imgUrl">ImgUrl</label>
											<form:input path="imgUrl" class="form-control" name="imgUrl" />
										</div>

										<div class="form-group">
											<label for="details">Details</label>
											<form:input path="details" class="form-control"
												name="details" />
										</div>
										<div class="form-group">
											<label for="date">CreatedDate</label>
											<form:input path="createdDate" class="form-control"
												name="date" />
										</div>

										<div class="form-group">

											<label>Category</label>
											<form:select class="form-control" path="category.id">
												<c:forEach var="category" items="${categories}">
													<c:choose>

														<c:when test="${category.id == product.category.id}">

															<option value="${category.id}" selected="selected">${category.name}</option>

														</c:when>

														<c:otherwise>

															<option value="${category.id}">${category.name}</option>

														</c:otherwise>

													</c:choose>

												</c:forEach>
											</form:select>

										</div>

										<div class="card-footer">
											<input type="submit" value="submit" class="btn btn-primary" />
										</div>
									</div>
								</form:form>
							</div>
							<!-- /.card-body -->



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
