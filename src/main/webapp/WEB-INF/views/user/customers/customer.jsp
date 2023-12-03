<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Khách hàng</title>
</head>
<body>
	<div class="row">
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
									<a href="<c:url value="thanh-toan"/>">Thanh Toán</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Thanh Toán</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="/user/xem-san-pham"/>">Sản phẩm</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span class="icon-edit"></span>Sản
										phẩm</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="/user/khach-hang"/>">Khách hàng</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Khách hàng</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="nhap-hang"/>">Nhập Hàng</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Nhập Hàng</a>
								</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="well well-small">
			<h1>Khách hàng</h1>
			<hr class="soften" />
			<br> <a href="<c:url value="/them-khach-hang"/>"
				class="addBtn">Thêm</a> <br>
			<br>

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã khách hàng</th>
						<th>Tên khách hàng</th>
						<th>Số điện thoại</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${ khachhang }">
						<tr>
							<td>${ item.maKhachHang }</td>
							<td>${ item.tenKhachHang }</td>
							<td>${ item.sdt }</td>
							<td><a
								href="<c:url value='/editCustomer/${item.maKhachHang}'/>"
								class="btn btn-mini btn-info" type="button"> <span
									class="icon-edit"></span> Chỉnh sửa
							</a></td>
							<td><a
								href="<c:url value='/deleteCustomer/${item.maKhachHang}'/>"
								class="btn btn-mini btn-danger" type="button"> <span
									class="icon-remove"></span> Xóa
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>