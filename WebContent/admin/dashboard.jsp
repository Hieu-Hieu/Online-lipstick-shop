<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Dashboard</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="./static/css/material-dashboard.css" rel="stylesheet" />

</head>
<body class="">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="slidebav.jsp"></jsp:include>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6">
							<a href="${pageContext.request.contextPath}/admin/product/list?currentPage=1">
								<div class="card card-stats">
									<div class="card-header card-header-warning card-header-icon">
										<div class="card-icon">
											<i class="material-icons">content_copy</i>
										</div>
										<p class="card-category">Quản lí sản phẩm</p>
										<h3 class="card-title"></h3>
									</div>
									<div class="card-footer">
										<div class="stats">Thêm chỉnh sửa và xóa sản phẩm</div>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<a href="./usermanager.jsp">
								<div class="card card-stats">
									<div class="card-header card-header-success card-header-icon">
										<div class="card-icon">
											<i class="material-icons">store</i>
										</div>
										<p class="card-category">Quản lí người dùng</p>
									</div>
									<div class="card-footer">
										<div class="stats">Xem thông tin chi tiết người dùng</div>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<a href="">
								<div class="card card-stats">
									<div class="card-header card-header-success card-header-icon">
										<div class="card-icon">
											<i class="material-icons">info_outline</i>
										</div>
										<p class="card-category">Quản lí đơn hàng</p>
									</div>
									<div class="card-footer">
										<div class="stats">Xem chi tiết và tình trạng từng đơn
											hàng</div>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6">
							<a href="./profile.jsp">
								<div class="card card-stats">
									<div class="card-header card-header-success card-header-icon">
										<div class="card-icon">
											<i class="fa fa-twitter"></i>
										</div>
										<p class="card-category">Thông tin cá nhân</p>
									</div>
									<div class="card-footer">
										<div class="stats">Xem chỉnh sửa thông tin chi tiết cá
											nhân</div>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>