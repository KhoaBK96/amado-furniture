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

		<!-- Product Catagories Area Start -->
		<div class="products-catagories-area clearfix">
			<div class="amado-pro-catagory clearfix">

				<c:forEach var="product" items="${products}">
					<div class="single-products-catagory clearfix">
						<a href="shop.html"> <img
							src="${pageContext.servletContext.contextPath}${product.imgUrl}"
							alt=""> <!-- Hover Content -->
							<div class="hover-content">
								<div class="line"></div>
								<p>From $${product.price}</p>
								<h4>${product.name}</h4>
							</div>
						</a>
					</div>
				</c:forEach>
				<!-- Single Catagory -->


			</div>
		</div>
		<!-- Product Catagories Area End -->
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