<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xuất Hóa Đơn</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	margin: 20px;
}

h1 {
	color: #333;
	border-bottom: 2px solid #333;
	padding-bottom: 5px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tbody tr:hover {
	background-color: #f5f5f5;
}

p {
	font-weight: bold;
	margin-top: 10px;
}
</style>
</head>
<body>
	<h1>Hóa Đơn</h1>
	<table>
		<thead>
			<tr>
				<th>Tên Sản Phẩm</th>
				<th>Số Lượng</th>
				<th>Đơn Giá</th>
				<th>Thành Tiền</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="chiTietDonHang" items="${chiTietDonHangList}">
				<tr>
					<td>${chiTietDonHang.tenSanPham}</td>
					<td>${chiTietDonHang.soLuong}</td>
					<td><fmt:formatNumber type="number" groupingUsed="true"
							value="${chiTietDonHang.giaTien}" /> ₫</td>
					<td><fmt:formatNumber type="number" groupingUsed="true"
							value="${chiTietDonHang.thanhTien}" /> ₫</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		Tổng Tiền:
		<fmt:formatNumber type="number" groupingUsed="true"
			value="${tongTien}" />
		₫
	</p>
	<p>Nhân Viên: ${sessionScope.LoginInfo.maNhanVien}</p>

	<form action="xuat-hoa-don" method="GET">
		<input type="hidden" name="tongTien" value="${tongTien}" /> <input
			type="hidden" name="tenNhanVien"
			value="${sessionScope.LoginInfo.maNhanVien}" />
		<!-- Các trường dữ liệu khác ở đây (nếu có) -->

		<button type="submit">Xuất Hóa Đơn</button>

		<!-- Thêm nút "Trở lại" -->
		<button type="button" onclick="goBack()">Trở lại</button>
	</form>

	<script>
    // Hàm điều hướng trang về trang trước đó
    function goBack() {
        window.history.back();
    }
</script>




</body>
</html>
