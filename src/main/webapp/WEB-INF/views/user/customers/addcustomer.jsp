<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm khách hàng</title>
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
					<h2>Thông tin khách hàng</h2>
					<c:if test="${ not empty status }">
						<h5>${status}</h5>
					</c:if>
					<br> <br>
					<form:form action="them-khach-hang" method="POST" modelAttribute="khachhang">
						<div class="form-row">
							<label for="maKhachHang">Mã khách hàng:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập mã khách hàng" path="maKhachHang"/>
							</div>
						</div>
						<div>
							<div class="form-row">
								<label for="tenKhachHang">Tên khách hàng:</label>
								<div>
									<form:input type="text" placeholder=" Mời nhập tên khách hàng" path="tenKhachHang"/>
								</div>

							</div>
						</div>
						<div>
							<div class="form-row">
								<label for="sdt">Số điện thoại:</label>
								<div>
									<form:input type="text" placeholder=" Mời nhập số điện thoại" path="sdt"/>
								</div>

							</div>
						</div>
						<br>
						<button type="submit" class="defaultBtn">Lưu</button>
						<a href="<c:url value="/user/khach-hang"/>" class="defaultBtn">Quay lại</a>
					</form:form>

				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>