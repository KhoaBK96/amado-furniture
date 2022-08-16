<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>



<!DOCTYPE html>
<html lang="en">

<c:import url="include/header.jsp"></c:import>

<body>
	<!-- Search Wrapper Area Start -->
	<c:import url="include/search.jsp"></c:import>
	<!-- Search Wrapper Area End -->

	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper d-flex clearfix">

		<c:import url="include/nav.jsp"></c:import>
		<!-- Header Area End -->

		<div class="shop_sidebar_area">

			<!-- ##### Single Widget ##### -->
			<div class="widget catagory mb-50">
				<!-- Widget Title -->
				<h6 class="widget-title mb-30">Catagories</h6>

				<!--  Catagories  -->
				<div class="catagories-menu">
					<ul>
						<li class='${dto.categoryId == 0 ? "bg-dark" : "bg-light" }'><a
							href="${pageContext.servletContext.contextPath}/shop">All</a></li>

					</ul>
					<ul>
						<c:forEach var="category" items="${categoryList}">

							<li
								class='${category.id == dto.categoryId ? "bg-dark" : "bg-light"}'><a
								href="${pageContext.servletContext.contextPath}/shop/${category.id}?page=1">${category.name}</a></li>

						</c:forEach>

					</ul>
				</div>
			</div>

			<!-- ##### Single Widget ##### -->



		</div>

		<div class="amado_product_area section-padding-100">
			<div class="container-fluid">

				<div class="row">
					<div class="col-12">
						<div
							class="product-topbar d-xl-flex align-items-end justify-content-between">
							<!-- Total Products -->
							<div class="total-products">
								<p>Showing 1-8 0f 25</p>
								<div class="view d-flex">
									<a href="#"><i class="fa fa-th-large" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-bars" aria-hidden="true"></i></a>
								</div>
							</div>
							<!-- Sorting -->
							<div class="product-sorting d-flex">
								<div class="sort-by-date d-flex align-items-center mr-15">
									<p>Sort by</p>
									<form method="get">
										<select name="page" onchange="location = this.value"
											id="sortType">
											<option
												value="${pageContext.servletContext.contextPath}/shop/${dto.categoryId}?page=${dto.page}&sort=default">Newest</option>
											<option
												value="${pageContext.servletContext.contextPath}/shop/${dto.categoryId}?page=${dto.page}&sort=price-asc">Lowest
												Price</option>
											<option
												value="${pageContext.servletContext.contextPath}/shop/${dto.categoryId}?page=${dto.page}&sort=price-desc">Highest
												Price</option>
										</select>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<c:forEach var="product" items="${dto.products}">
						<!-- Single Product Area -->
						<div class="col-12 col-sm-6 col-md-12 col-xl-6">
							<div class="single-product-wrapper">
								<!-- Product Image -->

								<div class="product-img">
									<img
										src="${pageContext.servletContext.contextPath}${product.imgUrl}"
										alt="">
									<!-- Hover Thumb -->
									<img class="hover-img"
										src="${pageContext.servletContext.contextPath}/shop-resources/img/product-img/product2.jpg"
										alt="">
								</div>

								<!-- Product Description -->
								<div
									class="product-description d-flex align-items-center justify-content-between">
									<!-- Product Meta Data -->
									<div class="product-meta-data">
										<div class="line"></div>
										<p class="product-price">$${product.price}</p>
										<a href="product-details.html">
											<h6>${product.name}</h6>
										</a>
									</div>
									<!-- Ratings & Cart -->
									<div class="ratings-cart text-right">

										<div class="cart">

											<a href="cart.html" data-toggle="tooltip"
												data-placement="left" title="Add to Cart"><img
												src="${pageContext.servletContext.contextPath}/shop-resources/img/core-img/cart.png"
												alt=""></a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<!-- Pagination -->
					<nav aria-label="navigation">
						<ul class="pagination justify-content-end mt-50">
							<c:set var="pageUrl"
								value='${pageContext.servletContext.contextPath}/shop/${dto.categoryId == 0 ? "" : dto.categoryId}'></c:set>
							<li class='page-item ${dto.page -1 == 0 ? "disabled" : "" }'
								aria-label="Previous"><a class="page-link"
								href='${pageUrl}?page=${dto.page -1}'><span
									aria-hidden="true">«</span></a></li>

							<c:forEach begin="1" end="${dto.maxPage}" var="pageLink">

								<li class='page-item ${pageLink == dto.page ? "active" : ""}'><a
									class="page-link" href="${pageUrl}?page=${pageLink}">${pageLink}</a></li>

							</c:forEach>
							<li
								class='page-item ${ dto.page + 1 > dto.maxPage ? "disabled" : "" }'><a
								class="page-link" href='${pageUrl}?page=${dto.page + 1}'
								aria-label="Next"><span aria-hidden="true">»</span></a></li>

						</ul>
					</nav>
				</div>
			</div>
		</div>


	</div>
	</div>
	<!-- ##### Main Content Wrapper End ##### -->

	<!-- ##### Newsletter Area Start ##### -->
	<c:import url="include/newsletter.jsp"></c:import>
	<!-- ##### Newsletter Area End ##### -->

	<!-- ##### Footer Area Start ##### -->
	<c:import url="include/footer.jsp"></c:import>
	<!-- ##### Footer Area End ##### -->

	<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
	<c:import url="include/jQuery.jsp"></c:import>

</body>

</html>