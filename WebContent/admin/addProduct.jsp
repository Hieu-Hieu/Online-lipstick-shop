<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
													<form>
														<div class="row">
															<div class="col-md-6">
																<div class="row">
																	<div class="product-detail">
																		<img src="./static/img/son.jpg" alt="Product Image"
																			width="300px" height="300px">
																		<button type="button" class="btn btn-primary addimg">Chọn
																			ảnh</button>
																	</div>
																</div>
																<br>
																<div class="row">
																	<div class="product-detail">
																		<img src="./static/img/son.jpg" alt="Product Image"
																			width="300px" height="300px">
																		<button type="button" class="btn btn-primary addimg">Chọn
																			ảnh</button>
																	</div>
																</div>
															</div>
															<div class="col-md-6">
																<div class="row">
																	<div class="col-md-12">
																		<div class="form-group">
																			<label class="bmd-label-floating">Tên sản
																				phẩm</label> <input type="text" class="form-control">
																		</div>
																	</div>

																</div>
																<div class="row">
																	<div class="col-md-6">
																		<label class="bmd-label-floating">Nhà sản xuất</label>
																		<select class="form-control"
																			id="exampleFormControlSelect1">
																			<option>1</option>
																			<option>2</option>
																			<option>3</option>
																			<option>4</option>
																			<option>5</option>
																		</select>
																	</div>
																	<div class="col-md-6">
																		<label class="bmd-label-floating">Lạo sản phẩm</label>
																		<select class="form-control"
																			id="exampleFormControlSelect1">
																			<option>1</option>
																			<option>2</option>
																			<option>3</option>
																			<option>4</option>
																			<option>5</option>
																		</select>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Giá</label> <input
																				type="text" class="form-control">
																		</div>
																	</div>
																	<div class="col-md-6">
																		<div class="form-group">
																			<label class="bmd-label-floating">Số lượng</label> <input
																				type="text" class="form-control">
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-md-12">
																		<div class="form-group">
																			<label class="bmd-label-floating">Mô tả sản phẩm</label>
																		</div>
																		<textarea rows="10">  
                                                                </textarea>
																		<hr>
																		<button type="submit"
																			class="btn btn-primary pull-right">Cập nhật thông tin</button>
																		<button type="submit" class="btn btn-primary pull-right">Quay lại</a></button>
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
</html>