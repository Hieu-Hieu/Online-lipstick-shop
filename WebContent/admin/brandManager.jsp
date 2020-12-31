<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="model.Brand"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Quản lí nhà sản xuất</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link href="${root}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="slidebav.jsp"></jsp:include>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card card-plain">
								<div class="card-header card-header-primary">
									<h4 class="card-title mt-0">Quản lí nhà sản xuất</h4>
									<p class="card-category"></p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-hover">
											<thead class="">
												<th>ID</th>
												<th>Nhà sản xuất</th>
												<th>Action</th>
											</thead>
											<tbody>
											<c:forEach items="${brandes}" var="item">
												<tr>
													<td >${item.getBrandID()}</td>
													<td >${item.getBrandName()}</td>
													<td>
														<form action="${pageContext.request.contextPath}/admin/brandManager" method="get">
														  <input type="hidden" name="brand_id" value="${item.getBrandID()}">
														  <input type="hidden" name="delete_id" value="1">
														  <button type="submit" class="btn btn-primary pull-right">Xóa</button>
														</form>
														<button class="btn btn-primary pull-right" onclick="showData('${item.getBrandID()}','${item.getBrandName()}')">Update</button>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="ttt1">
							<div class="container">
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-header card-header-primary">
												<h4 class="card-title">Thông tin loại sản phẩm</h4>
											</div>
											<div class="card-body">
												<form action="${pageContext.request.contextPath}/admin/brandManager" method="post">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="bmd-label-floating">ID</label>
																	<input type="text" id="brand_id" name="brand_id" class="form-control">
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="bmd-label-floating">Nhà sản xuất</label>
																	<input type="text" id="brand_name" name="brand_name" class="form-control">
																</div>
															</div>
														</div>
														<button type="submit" class="btn btn-primary pull-right">Lưu</button>
														<button class="btn btn-primary pull-right">Hủy</button>
													</div>
											</div>
										</div>
									</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
	<script src="js/bootstrap.js"></script>
	<script>
		function showData (id, name) {
			$('#brand_id').val(id);
			$('#brand_name').val(name);
		}
	</script>
</body>

</html>