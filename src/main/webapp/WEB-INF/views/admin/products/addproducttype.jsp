<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm loại sản phẩm</title>
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
					<h2>Thông tin loại sản phẩm</h2>
					<c:if test="${ not empty status }">
						<h5>${status}</h5>
					</c:if>
					<br> <br>
					<form:form action="them-loai-san-pham" method="POST" modelAttribute="loaisanpham">
						<div class="form-row">
							<label for="maLoaiSanPham">Mã loại sản phẩm:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập mã loại sản phẩm" path="maLoaiSanPham"/>
							</div>
						</div>
						<div>
							<div class="form-row">
								<label for="tenLoaiSanPham">Tên loại sản phẩm:</label>
								<div>
									<form:input type="text" placeholder=" Mời nhập tên loại sản phẩm" path="tenLoaiSanPham"/>
								</div>

							</div>
						</div>
						<br>
						<button type="submit" class="defaultBtn">Lưu</button>
						<a href="<c:url value="/admin/loai-san-pham"/>" class="defaultBtn">Quay lại</a>
					</form:form>

				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>