<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Đăng nhập</title>
</head>
<body>
	<div class="row">
		<div id="sidebar"></div>
		<div class="span12">
			<div class="span4">&nbsp;</div>
			<div class="span4">
				<div class="well">
					<h5>Đăng nhập hệ thống</h5>
					<br>
					<c:if test="${ statusLogin }">
						<h1>${statusLogin}</h1>
					</c:if>
					<form:form action="dang-nhap" method="POST" modelAttribute="user">
						<div class="control-group">
							<label class="control-label" for="inputEmail">Tài khoản</label>
							<div class="controls">
								<form:input type="text" class="span3"
									placeholder=" Mời nhập tài khoản" path="tenDangNhap" />
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">Mật khẩu
							</label>
							<div class="controls">
								<form:input type="password" class="span3"
									placeholder=" Mời nhập mật khẩu" path="matKhau" />
							</div>
						</div>
						<br />
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="defaultBtn">Đăng nhập</button>
								<a href="#">Quên mật khẩu ?</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

	</div>
	</div>

</body>
