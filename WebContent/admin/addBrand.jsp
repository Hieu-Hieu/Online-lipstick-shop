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
<title>Thêm nhãn hiệu</title>
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
	<jsp:include page="slidebav.jsp"></jsp:include>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="ttt1">
							<div class="container">
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-header card-header-primary">
												<h4 class="card-title">Thêm thương hiệu</h4>
											</div>
											<div class="card-body">
												<form action="${pageContext.request.contextPath}/admin/brand/add" method="post">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group">
																	<label class="bmd-label-floating">Thương hiệu</label>
																	<input type="text" name="brandName" class="form-control">
																</div>
															</div>
														</div>
														<button type="submit" class="btn btn-primary pull-right">Lưu</button>
														<button class="btn btn-primary pull-right">Hủy</button>
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