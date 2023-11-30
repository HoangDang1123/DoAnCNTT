<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Trang chủ</title>
<body>

	<!-- 
Body Section 
-->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class=""><a href="<c:url value="/khach-hang"/>">Khách hàng</a>
						<li class=""><a href="<c:url value="/san-pham"/>">Sản phẩm</a>
						<li class=""><a href="<c:url value="/loai-san-pham"/>">Loại sản phẩm</a>
						<li class=""><a href="<c:url value="/nhap-hang"/>">Nhập hàng</a>
						<li class=""><a href="<c:url value="/thanh-toan"/>">Thanh toán</a>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>