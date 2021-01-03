<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="model.Category"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Quản lí sản phẩm</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="${pageContext.request.contextPath}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
	
	<jsp:include page="slidebav.jsp"></jsp:include>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							
						</div>
					</div>
					<div class="row">
						<div class="ttt1">
							<div class="container">
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-header card-header-primary">
												<h4 class="card-title">Cập nhật loại sản phẩm</h4>
											</div>
											<div class="card-body">
												<form action="${pageContext.request.contextPath}/admin/category/update" method="post">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																<label class="bmd-label-floating">Mã loại sản phẩm</label>
																	<input type="hidden"  name="categoryID" value="${category.getCategoryID()}" class="form-control">
																	<input type="text"  disabled="disabled" value="${category.getCategoryID()}" class="form-control">
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="bmd-label-floating">Tên loại sản phẩm</label>
																	<input type="text" name="categoryName" value="${category.getCategoryName()}" class="form-control">
																</div>
															</div>
														</div>
														<button type="submit" class="btn btn-primary pull-right">Lưu</button>
														<button  class="btn btn-primary pull-right">Hủy</button>
														<a href="${pageContext.request.contextPath}/admin/categoryManager"></a>
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
	</div>
	
</body>

</html>