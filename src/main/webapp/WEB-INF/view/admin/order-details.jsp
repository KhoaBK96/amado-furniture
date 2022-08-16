<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>AdminLTE 3 | DataTables</title>

<!-- link -->
<c:import url="include/link.jsp" />

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">


		<!-- /.navbar -->
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
							<h1>Order Detail</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">DataTables</li>
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
						<div class="col-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">
										<button type="button"
											class="btn btn-block btn-outline-primary btn-sm">
											<a
												href="${pageContext.request.contextPath}/admin/addOrderDetails?orderId=${order.id}">Add
												Product</a>
										</button>
									</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>ProductName</th>
												<th>ProductQuantity</th>
												<th>Price(each product)</th>
												<th>ProductImage</th>
												<th>Price</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="orderDetail" items="${ordersDetails}">
												<tr>
													<td>${orderDetail.product.name}</td>
													<td>${orderDetail.quantity}</td>
													<td>${orderDetail.product.price}</td>
													<td>${orderDetail.product.imgUrl}</td>
													<td>${orderDetail.quantity * orderDetail.product.price}</td>
												</tr>
											</c:forEach>
										</tbody>

									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<div class="card">
								<!-- /.card-header -->
								<div class="card-body">
									<table id="example2" class="table table-bordered table-hover">
										<thead>
											<tr>
												<th>Date</th>
												<th>UserName</th>
												<th>UserEmail</th>
												<th>Total</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${order.createdTime}</td>
												<td>${order.name}</td>
												<td>${order.email}</td>
												<td>${total}</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- footer -->
		<c:import url="include/footer.jsp" />
</body>
</html>
