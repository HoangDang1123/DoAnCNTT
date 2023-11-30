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
						<li class=""><c:if test="${not empty LoginInfo }">
								<a href="<c:url value="/khach-hang"/>">Khách hàng</a>
							</c:if> <c:if test="${empty LoginInfo }">
								<a href="<c:url value="/dang-nhap"/>"><span
									class="icon-edit"></span>Khách hàng</a>
							</c:if>
						<li class=""><c:if test="${not empty LoginInfo }">
								<a href="<c:url value="/san-pham"/>">Sản phẩm</a>
							</c:if>
							<c:if test="${empty LoginInfo }">
								<a href="<c:url value="/dang-nhap"/>"><span
									class="icon-edit"></span>Sản phẩm</a>
							</c:if>
						<li class=""><c:if test="${not empty LoginInfo }">
								<a href="<c:url value="/loai-san-pham"/>">Loại sản phẩm</a>
							</c:if> <c:if test="${empty LoginInfo }">
								<a href="<c:url value="/dang-nhap"/>"><span
									class="icon-edit"></span>Loại sản phẩm</a>
							</c:if>
						<li class=""><c:if test="${not empty LoginInfo }">
								<a href="<c:url value="/nhap-hang"/>">Nhập hàng</a>
							</c:if> <c:if test="${empty LoginInfo }">
								<a href="<c:url value="/dang-nhap"/>"><span
									class="icon-edit"></span>Nhập hàng</a>
							</c:if>
						<li class=""><c:if test="${not empty LoginInfo }">
								<a href="<c:url value="/thanh-toan"/>">Thanh toán</a>
							</c:if> <c:if test="${empty LoginInfo }">
								<a href="<c:url value="/dang-nhap"/>"><span
									class="icon-edit"></span>Thanh toán</a>
							</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>