<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Amado-furniture</title>

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
							<h1>Add Product</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#" />Home</a></li>
								<li class="breadcrumb-item active">General Form</li>
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
								<form:form action="save-orderDetail" method="post"
									modelAttribute="orderDetail">
									<div class="card-body">
										<form:hidden path="order.id" />
										<div class="form-group">
											<label>Product</label>
											<form:select id="product" onchange="getPrice()"
												class="form-control" path="product.id">
												<option value="" disabled="disabled" selected="selected">
													Choose product</option>
												<c:forEach var="product" items="${productList}">
													<option value="${product.id}" data-price="${product.price}">${product.name}</option>
												</c:forEach>
											</form:select>
										</div>
										<div class="form-group"><label>Price:</label> <span id='product-price'>0</span>$</div>
										<div class="form-group">
											<label for="date">Product Quantity</label>
											<form:input type="number" class="form-control"
												id="exampleInputEmail1" name="productQuantity"
												path="quantity" min="1" />
										</div>
									</div>
									<!-- /.card-body -->

									<div class="card-footer">
										<input type="submit" value="submit" class="btn btn-primary" />

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


		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<c:import url="include/footer.jsp" />

</body>
<script type="text/javascript">
	function getPrice() {
		const product = document.getElementById("product");
		const productId = product.value;
		const chooseProduct = product.querySelector('option[value="'
				+ productId + '"]');

		const price = chooseProduct.dataset.price;
		document.getElementById('product-price').innerText = price;

	}
</script>
</html>
