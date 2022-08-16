<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Amado | Order</title>

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
							<h1>Orders</h1>
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
												href="${pageContext.servletContext.contextPath}/admin/addOrder" />Add
											Orders</a>
										</button>
									</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="order-table"
										class="table table-bordered table-hover">
										<thead>
											<tr>

												<th>Name</th>
												<th>Email</th>
												<th>Phone</th>
												<th>Address</th>
												<th>CreatedTime</th>
												<th>PaidTime</th>
												<th>Total</th>
												<th></th>


											</tr>
										</thead>
										<tbody>
											<c:forEach var="order" items="${orderList}">
												<tr id="orderRow-${order.id}">
													<td>${order.name}</td>
													<td>${order.email}</td>
													<td>${order.phone}</td>
													<td>${order.address}</td>
													<td>${order.createdTime}</td>
													<td>${order.paidTime}</td>

													<td></td>


													<td><a class="btn btn-block bg-gradient-info btn-sm"
														href="<c:out value="${pageContext.request.contextPath}/admin/orderDetails?orderId=${order.id}"/>"><i
															class="fa-solid fa-info"></i></a> <a
														class="btn btn-block bg-gradient-warning btn-sm"
														href="<c:out value="${pageContext.request.contextPath}/admin/updateOrder?orderId=${order.id}"/>"><i
															class="fa-solid fa-pen-to-square"></i></a>
														<button
															class="btn btn-block bg-gradient-danger btn-sm deleteBtn"
															data-order-id="${order.id}">
															<i class="fa-solid fa-trash-can unclickable"></i>
														</button></td>
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
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!-- footer -->
		<c:import url="include/footer.jsp" />

		<script type="text/javascript">


	const table = $("#order-table")?.DataTable({
	    paging: true,
	    lengthChange: false,
	    searching: false,
	    ordering: true,
	    info: true,
	    autoWidth: false,
	    responsive: true,
	  });
  
	function handleDeleteEvent (event) {
		const target =  event.target;
		
		if(!target.classList.contains("deleteBtn")){
			return;
		};
	
		const orderId = target.dataset.orderId;
		if (!orderId) {
			return;
		}
		if (!window.confirm("Do you want to delete?")) {
			return;
		}
		
		fetch('${pageContext.servletContext.contextPath}/admin/deleteOrder?orderId=' + orderId, { method: 'POST' })
			.then(resp => resp.text())
			.then(value => {
				if(value === "true"){
					removeRow("#orderRow-" + orderId);
				} else{
					alert("Delete failed!!");
				}
			});
	}
		function removeRow(id) {
	        table
	            .row($(id))
	            .remove()
	            .draw();
	    }
		document.getElementById("order-table").addEventListener("click", handleDeleteEvent);
	

	</script>
</body>
</html>
