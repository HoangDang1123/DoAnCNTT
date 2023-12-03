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
										value="${taikhoan.tenDangNhap }">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">Mật khẩu: </label>
								<div class="controls">
									<input type="text" class="span3" value="${taikhoan.matKhau }">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="name">Tên nhân viên: </label>
								<div class="controls">
									<input type="text" class="span3" value="${thongtin.tenNhanVien }">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="name">Giới tính: </label>
								<div class="controls">
									<c:if test="${thongtin.gioiTinh == 1 }">
										<input type="text" class="span3" value="Nam">
									</c:if>
									<c:if test="${thongtin.gioiTinh == 0 }">
										<input type="text" class="span3" value="Nữ">
									</c:if>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="sdt">Số điện thoại: </label>
								<div class="controls">
									<input type="text" class="span3" value="${thongtin.sdt }">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="role">Chức vụ: </label>
								<div class="controls">
									<input type="text" class="span3" value="${thongtin.chucVu }" readonly>
								</div>
							</div>
							
							<a href="javascript:history.back()" class="defaultBtn">Quay lại</a>
						</form>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>