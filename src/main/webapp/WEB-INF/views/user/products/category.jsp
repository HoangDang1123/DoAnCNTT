<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Sản phẩm</title>
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
							<li class=""><a href="<c:url value="/khach-hang"/>">Khách hàng</a>
							<li class=""><a href="<c:url value="/san-pham"/>">Sản phẩm</a>
							<li class=""><a href="<c:url value="/loai-san-pham"/>">Loại sản phẩm</a>
							<li class=""><a href="<c:url value="/nhap-hang"/>">Nhập hàng</a>
							<li class=""><a href="<c:url value="/thanh-toan"/>">Thanh toán</a>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="well well-small">
			<h1>Sản phẩm</h1>
			<hr class="soften" />

			<table class="table table-bordered table-condensed">
				<thead>
					<tr>
						<th>Mã loại sản phẩm</th>
						<th>Tên loại sản phẩm</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="item" items="${ Cart }">
						<tr>
							<td><img width="100"
								src="<c:url value="/assets/user/img/${ item.value.product.img }"/>"
								alt=""></td>
							<td>${ item.value.product.title }</td>
							<td><span class="shopBtn"
								style="background-color: ${ item.value.product.code_color };"><span
									class="icon-ok"></span></span></td>
							<td><fmt:formatNumber type="number" groupingUsed="true"
									value="${ item.value.product.price }" /> ₫</td>
							<td><input type="number" min="0" max="1000" class="span1"
								style="max-width: 34px" placeholder="1"
								id="quanty-cart-${ item.key }" size="16" type="text"
								value="${ item.value.quanty }"></td>
							<td>
								<button data-id="${ item.key }"
									class="btn-btn-mini btn-danger edit-cart" type="button">
									<span class="icon-edit"></span>
								</button>
							</td>
							<td><a href="<c:url value="/DeleteCart/${ item.key }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
									class="icon-remove"></span>
							</a></td>
							<td><fmt:formatNumber type="number" groupingUsed="true"
									value="${ item.value.totalPrice }" /> ₫</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>