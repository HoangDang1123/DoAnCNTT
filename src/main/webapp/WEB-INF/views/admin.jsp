<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />"
	rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link
	href="<c:url value="/assets/user/font-awesome/css/font-awesome.css" />"
	rel="stylesheet">

<!-- Favicons -->
<link rel="shortcut icon"
	href="<c:url value="/assets/user/ico/favicon.ico" />">
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<a class="" href="<c:url value="/admin/"/>"> <span class="icon-home"></span>
					Trang chủ
				</a>
				<c:if test="${not empty sessionScope.LoginInfo}">
					<a href="<c:url value="/thong-tin"/>"><span class="icon-user"></span>${sessionScope.LoginInfo.tenDangNhap}</a>
					<a href="<c:url value="/dang-xuat"/>"><span class="icon-edit"></span>
						Đăng xuất</a>
				</c:if>

				<c:if test="${empty LoginInfo }">
					<a href="<c:url value="/user/dang-nhap"/>"><span class="icon-edit"></span>Đăng
						nhập</a>
				</c:if>
				<a href="#"><span class="icon-envelope"></span> Liên
					hệ</a>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>

		<%@include file="/WEB-INF/views/layouts/admin/header.jsp"%> 

		<jsp:include page="${param.view }"></jsp:include>

		<%@include file="/WEB-INF/views/layouts/admin/footer.jsp"%>

	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img
					src="<c:url value="/assets/user/img/paypal.jpg"/>" alt="payment"></a>
				<a href="#"><img
					src="<c:url value="/assets/user/img/goverment.png"/>" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2023<br> Nhóm 04 - 04CLC
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src=" <c:url value="/assets/user/js/jquery.js" />"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js" />"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/assets/user/js/shop.js" /> "></script>
</body>
</html>
