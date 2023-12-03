<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thanh Toán</title>
<style>
/* Style cho modal */
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
	padding-top: 50px;
}

.modal-content {
	background-color: #fefefe;
	margin: 5% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Điều chỉnh kích thước modal tại đây */
	max-width: 600px; /* Kích thước tối đa */
}

/* Style cho nút đóng */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<form action="xuat-hoa-don" method="POST">
		<!-- Các trường dữ liệu khác ở đây (nếu có) -->
		<button type="submit">Thanh Toán</button>
	</form>


	<!-- Danh sách sản phẩm -->
	<div class="product-list">
		<c:forEach var="item" items="${sanpham}">
			<div class="product-item">
				<!-- Thêm một nút để mở modal -->
				<button class="btn btn-mini btn-danger edit-cart" type="button"
					onclick="openModal('${item.maSanPham}', '${item.tenSanPham}', '${item.soLuongHienCo}', '${item.giaTien}')">
					<span class="icon-edit"></span> Mua
				</button>
				<p>
					<strong>Tên sản phẩm:</strong> ${item.tenSanPham}
				</p>
				<p>
					<strong>Số Lượng Hiện Có:</strong> ${item.soLuongHienCo}
				</p>
				<p>
					<strong>Giá tiền:</strong>
					<fmt:formatNumber type="number" groupingUsed="true"
						value="${item.giaTien}" />
					₫
				</p>
				<hr class="soften" />
			</div>
		</c:forEach>
	</div>

	<!-- Modal form mua sản phẩm -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal()">&times;</span>
			<h2>Mua Sản Phẩm</h2>
			<form id="muaForm" action="thanh-toan" method="POST"
				onsubmit="submitForm()">
				<input type="hidden" id="maSanPhamInput" name="maSanPhamInput">
				<input type="hidden" id="giaTienInput" name="giaTienInput">
				<label for="soLuongInput">Số Lượng:</label> <input type="number"
					id="soLuongInput" name="soLuongInput" min="1" value="1"
					onchange="updateSoLuong(this.value)">
				<button type="submit">Mua</button>
			</form>
		</div>
	</div>

	<script>
		function updateSoLuong(newValue) {
			var soLuongInput = document.getElementById('soLuongInput');
			soLuongInput.value = newValue;
			console.log("Số Lượng:", soLuongInput.value);

		}

		// Mở modal và truyền thông tin sản phẩm
		function openModal(maSanPham, tenSanPham, soLuongHienCo, giaTien) {
			var soLuong = document.getElementById('soLuongInput');
			var maSanPhamInput = document.getElementById('maSanPhamInput');
			var giaTienInput = document.getElementById('giaTienInput');

			soLuong.value = 1;
			updateSoLuong(soLuong.value);

			maSanPhamInput.value = maSanPham;
			giaTienInput.value = giaTien;

			console.log("Ma San Pham:", maSanPhamInput.value);
			console.log("Gia Tien:", giaTienInput.value);

			document.getElementById('myModal').style.display = 'block';
		}

		// Đóng modal
		function closeModal() {
			document.getElementById('myModal').style.display = 'none';
		}

		// Kiểm tra số lượng nhập vào trước khi submit form
		document.getElementById('muaForm')
				.addEventListener(
						'submit',
						function(event) {
							var soLuong = document
									.getElementById('soLuongInput').value;

							if (soLuong == "" || isNaN(soLuong)
									|| parseInt(soLuong) <= 0) {
								alert('Vui lòng nhập số lượng lớn hơn 0.');
								event.preventDefault();
							}
						});

		// Xử lý sự kiện khi mua sản phẩm
		function submitForm() {
			// Thêm bất kỳ xử lý nào bạn muốn thực hiện khi submit form
			// ở đây, ví dụ như đóng modal hoặc thực hiện AJAX để gửi dữ liệu đi
			closeModal();
		}
	</script>
</body>
</html>
