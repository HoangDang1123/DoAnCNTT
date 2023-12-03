<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa sản phẩm</title>
</head>
<body>

	<h2>Sửa sản phẩm</h2>
	<h3 style="color: red">${message}</h3>
	<form:form modelAttribute="sanPham"
		action="${pageContext.request.contextPath}/update" method="post">
 
		<%-- 		<div>Mã SP: </div>
		<form:input path="maSanPham" /> --%>

		<div>Tên SP:</div>
		<form:input path="tenSanPham" />

		<div>giaTien</div>
		<form:input path="giaTien" />

		<%-- 		<div>maLoaiSanPham</div>
		<form:input path="maLoaiSanPham" row="3" cols="40" /> --%>

		<%-- 		<div>soLuongHienCo</div>
		<form:input path="soLuongHienCo" /> --%>

		<br>


		 		<button type="submit">Cập Nhật</button> 
	</form:form>


</body>
</html>