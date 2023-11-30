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
							<li class=""><a href="<c:url value="/khach-hang"/>">Khách
									hàng</a>
							<li class=""><a href="<c:url value="/san-pham"/>">Sản
									phẩm</a>
							<li class=""><a href="<c:url value="/loai-san-pham"/>">Loại
									sản phẩm</a>
							<li class=""><a href="<c:url value="/nhap-hang"/>">Nhập
									hàng</a>
							<li class=""><a href="<c:url value="/thanh-toan"/>">Thanh
									toán</a>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="well well-small">
			<h1>Khách hàng</h1>
			<hr class="soften" />

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
							<td>
								<button data-id="${ item.maKhachHang }"
									class="btn-btn-mini btn-danger edit-cart" type="button">
									<span class="icon-edit"></span>
								</button>
							</td>
							<td><a href="<c:url value="/DeleteCart/${ item.maKhachHang }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
									class="icon-remove"></span>
								</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>