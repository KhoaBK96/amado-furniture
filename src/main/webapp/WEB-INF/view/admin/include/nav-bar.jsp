<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<nav class="main-header navbar navbar-expand navbar-white navbar-light">
  <!-- Left navbar links -->
  <ul class="navbar-nav">
    <li class="nav-item d-none d-sm-inline-block">
      <a href="" class="nav-link">Home</a>
       <a href="${pageContext.servletContext.contextPath}/signout" class="nav-link">Sign out</a>
    </li>
  </ul>  
</nav>
<!-- /.navbar -->