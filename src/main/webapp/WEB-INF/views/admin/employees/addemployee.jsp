<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhân viên</title>
<style>
.form-row {
	display: flex;
	align-items: center;
}

.form-row label {
	flex-basis: 200px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="row">
		<div id="sidebar"></div>
		<div class="span12">
			<div class="span2">&nbsp;</div>
			<div class="span6">
				<div class="well">
					<h2>Thông tin nhân viên</h2>
					<c:if test="${ not empty status }">
						<h5>${status}</h5>
					</c:if>
					<br> <br>
					<form:form action="them-nhan-vien" method="POST"
						modelAttribute="nhanvien">
						<div class="form-row">
							<label for="maNhanVien">Mã nhân viên:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập mã nhân viên"
									path="maNhanVien" />
							</div>
						</div>
						<div class="form-row">
							<label for="tenNhanVien">Tên nhân viên:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập tên nhân viên"
									path="tenNhanVien" />
							</div>
						</div>
						<div class="form-row">
							<label for="gioiTinh">Giới tính:</label>
							<div>
								<form:select path="gioiTinh">
									<form:option value="1" label="Nam" />
									<form:option value="0" label="Nữ" />
								</form:select>
							</div>
						</div>
						<div class="form-row">
							<label for="sdt">Số điện thoại:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập số điện thoại"
									path="sdt" />
							</div>
						</div>
						<div class="form-row">
							<label for="chucVu">Chức vụ:</label>
							<div>
								<form:select path="chucVu">
									<form:option value="Staff" label="Staff" />
									<form:option value="Admin" label="Admin" />
								</form:select>
							</div>
						</div>
						<br>
						<button type="submit" class="defaultBtn">Lưu</button>
						<a href="<c:url value="/admin/nhan-vien"/>" class="defaultBtn">Quay
							lại</a>
					</form:form>

				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>