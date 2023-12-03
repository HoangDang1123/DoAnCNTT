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
					<h2>Thông tin sản phẩm</h2>
					<c:if test="${ not empty status }">
						<h5>${status}</h5>
					</c:if>
					<br> <br>
					<form:form action="them-san-pham" method="POST"
						modelAttribute="sanpham">
						<div class="form-row">
							<label for="maSanPham">Mã sản phẩm:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập mã sản phẩm"
									path="maSanPham" />
							</div>
						</div>
						<div class="form-row">
							<label for="maLoaiSanPham">Mã loại sản phẩm:</label>
							<div>
								<form:select path="maLoaiSanPham">
									<form:option value="">-- Chọn loại sản phẩm --</form:option>
									<form:options items="${loaisanpham}" itemValue="maLoaiSanPham"
										itemLabel="tenLoaiSanPham" />
								</form:select>
							</div>
						</div>
						<div>
							<div class="form-row">
								<label for="tenSanPham">Tên sản phẩm:</label>
								<div>
									<form:input type="text" placeholder=" Mời nhập tên sản phẩm"
										path="tenSanPham" />
								</div>
							</div>
						</div>
						<div class="form-row">
							<label for="giaTien">Giá tiền:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập giá tiền"
									path="giaTien" />
							</div>
						</div>
						<div class="form-row">
							<label for="soLuongHienCo">Số lượng:</label>
							<div>
								<form:input type="text" placeholder=" Mời nhập mã số lượng"
									path="soLuongHienCo" />
							</div>
						</div>
						<br>
						<button type="submit" class="defaultBtn">Lưu</button>
						<a href="<c:url value="/admin/san-pham"/>" class="defaultBtn">Quay
							lại</a>
					</form:form>

				</div>
			</div>
		</div>

	</div>
	</div>
</body>
</html>