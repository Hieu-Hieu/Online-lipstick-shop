<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@ page import="java.util.*"%>
<%@page import="dao.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Profile</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<!-- CSS Files -->
<c:set var="root" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="${root}/admin/static/css/material-dashboard.css"
	rel="stylesheet" />
</head>

<body class="">

	<jsp:include page="slidebav.jsp"></jsp:include>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="ttt">
								<div class="container">
									<div class="row">
										<div class="col-md-12">
											<div class="card">
												<div class="card-header card-header-primary">
													<h4 class="card-title">Thông tin chi tiết sản phẩm</h4>
												</div>
												<div class="card-body">
													<form method="post"
														action="${pageContext.request.contextPath}/admin/product/add">
														<div class="row">

															<div class="col-md-12">
																<div class="row">
																	<div class="col-md-12">
																		<div class="form-group">
																			<label class="bmd-label-floating">Tên sản
																				phẩm</label>
																			<c:if test="${!empty errorName }">
																				<div data-dismiss="alert" aria-label="Close">
																					${errorName }</div>
																			</c:if>
																			<input type="text" class="form-control" name="pName"
																				value="${product.name} " required="required">

																		</div>
																	</div>

																</div>
																<div class="row">
																	<div class="col-md-6">
																		<label class="bmd-label-floating">Nhà sản xuất</label>
																		<select class="form-control"
																			id="exampleFormControlSelect1" name="brandID"
																			required="required">

																			<c:forEach items="${ListBrand}" var="b">
																				<option value="${b.getBrandID()}">
																					${b.getBrandName()
																										}</option>
																			</c:forEach>

																		</select>
																	</div>
																	<div class="col-md-6">
																		<label class="bmd-label-floating">Loại sản
																			phẩm</label> <select class="form-control"
																			id="exampleFormControlSelect1" name="categoryID"
																			required="required">
																			<c:forEach items="${ListCategory }" var="cate">

																				<option value="${cate.getCategoryID()}">
																					${cate.getCategoryName()}</option>

																			</c:forEach>

																		</select>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Giá</label> <input
																				type="number" class="form-control" name="price"
																				required="required" value="${product.price}">
																		</div>
																	</div>
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Số lượng</label> <input
																				type="number" class="form-control" name="quantity"
																				value="${product.quantity}" required="required">
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Link hình
																				ảnh 1</label> <input type="text" class="form-control"
																				name="imgFirst" value="${product.imgFirst} ">
																		</div>
																	</div>
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Link hình
																				ảnh 2</label> <input type="text" class="form-control"
																				name="imgLast" required="required"
																				value="${product.imgLast}">
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-12">
																		<div class="form-group">
																			<label class="bmd-label-floating">Mô tả sản
																				phẩm</label>
																		</div>
																		<textarea class="form-control"
																			id="exampleFormControlTextarea1" rows="3"
																			name="description" required="required">${product.description}</textarea>

																		<button type="submit"
																			class="btn btn-primary pull-right" value="Upload">Thêm
																			/Cập nhật thông tin</button>
																		<button type="button"
																			class="btn btn-primary pull-right" onclick=" return refreshPage();">
																			Làm mới
																		</button>
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
		</div>
	</div>
</body>
<script>
function refreshPage(){
    window.location.reload();
} 
</script>
</html>