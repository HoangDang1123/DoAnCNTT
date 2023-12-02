<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Thông tin</title>
<style>
.control-group {
	display: flex;
	align-items: center;
}

.control-label {
	width: 150px;
	text-align: right;
	margin-right: 10px;
}
</style>
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

		<div class="row">
			<div id="sidebar"></div>
			<div class="span10">
				<div class="span3">&nbsp;</div>
				<div class="span6">
					<div class="well">
						<h5>Thông tin tài khoản</h5>
						<br>
						<form action="dang-nhap">
							<div class="control-group">
								<label class="control-label" for="id">Mã nhân viên: </label>
								<div class="controls">
									<input type="text" class="span3"
										value="${taikhoan.maNhanVien }" readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="username">Tên đăng
									nhập: </label>
								<div class="controls">
									<input type="text" class="span3"
										value="${taikhoan.tenDangNhap }" readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Mật khẩu: </label>
								<div class="controls">
									<input type="text" class="span3" value="${taikhoan.matKhau }">
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>