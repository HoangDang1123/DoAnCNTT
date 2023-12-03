<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Nhân Viên</title>
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
									<a href="<c:url value="/admin/nhan-vien"/>">Nhân Viên</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Nhân Viên</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="/admin/xem-khach-hang"/>">Khách hàng</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Khách hàng</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="/admin/san-pham"/>">Sản phẩm</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Sản phẩm</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="/admin/loai-san-pham"/>">Loại sản
										phẩm</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Loại sản phẩm</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="nhap-hang"/>">Lịch Sử Nhập hàng</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="/user/dang-nhap"/>"><span
										class="icon-edit"></span>Lịch Sử Nhập hàng</a>
								</c:if>
							<li class=""><c:if test="${not empty LoginInfo }">
									<a href="<c:url value="thanh-toan"/>">Lịch Sử Thanh toán</a>
								</c:if> <c:if test="${empty LoginInfo }">
									<a href="<c:url value="thanh-toan"/>"><span
										class="icon-edit"></span>Lịch Sử Thanh toán</a>
								</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="well well-small">
			<h1>Nhân Viên</h1>
			<hr class="soften" />
			<br> <a href="<c:url value="/them-nhan-vien"/>" class="addBtn">Thêm</a>
			<br> <br>

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã nhân viên</th>
						<th>Tên nhân viên</th>
						<th>Giới tính</th>
						<th>Số điện thoại</th>
						<th>Chức vụ</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${ nhanvien }">
						<tr>
							<td>${ item.maNhanVien }</td>
							<td>${ item.tenNhanVien }</td>
							<td><c:if test="${ item.gioiTinh == 1 }">
							Nam
							</c:if> <c:if test="${ item.gioiTinh == 0 }">
							Nữ
							</c:if></td>
							<td>${ item.sdt }</td>
							<td>${ item.chucVu }</td>
							<td><a
								href="<c:url value='/editEmployee/${item.maNhanVien}'/>"
								class="btn btn-mini btn-info" type="button"> <span
									class="icon-edit"></span> Chỉnh sửa
							</a></td>
							<td><a
								href="<c:url value='/deleteEmployee/${item.maNhanVien}'/>"
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
