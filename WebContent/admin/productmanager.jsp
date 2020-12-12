<%@page import="get.CategoryDAO"%>
<%@page import="get.BrandDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="get.GetProduct"%>
<%@ page import="java.util.*"%>
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
<link href="../static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="slidebav.jsp"></jsp:include>

	<%
		GetProduct getProduct = new GetProduct();
			List<Product> list = new ArrayList<Product>();
			list = getProduct.getAllProduct(0, 9);
	%>
	<div class="wrapper ">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card card-plain">
								<div class="card-header card-header-primary">
									<h4 class="card-title mt-0">Quản lí sản phẩm</h4>
									<p class="card-category"></p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-hover">
											<thead class="">
												<th>ID</th>
												<th>Hình ảnh</th>
												<th>Tên</th>
												<th>Thể loại</th>
												<th>Giá tiền</th>
												<th>Số lượng(Thỏi)</th>
												<th>Action</th>
											</thead>
											<tbody>
												<%
													for (Product l : list) {
												%>
												<tr>
													<td><%=l.getProductID()%></td>
													<td><img src="<%=l.getImgFirst()%>" alt=""
														width="30px" height="30px"></td>
													<td><%=l.getName()%></td>
													<td>
														<%
															Category cate = l.getCategory();
														%> <%=cate.getCategoryName()%>
													</td>
													<td><%=l.getPrice()%> VNĐ</td>
													<td><%=l.getQuantity()%></td>
													<td><a href="addProduct.jsp">Xem/Sửa</a></td>
												</tr>
												<%
													}
												%>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6   align-self-md-center">
							<ul class="pagination modal-2">
								<li><a href="#" class="prev">&laquo </a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#" class="active">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">6</a></li>
								<li><a href="#">7</a></li>
								<li><a href="#">8</a></li>
								<li><a href="#">9</a></li>
								<li><a href="#" class="next"> &raquo;</a></li>
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6  align-self-sm-end">
							<div class="border__button">
								<button class="border__button--button" type="button"
									data-toggle="modal" data-target=".bs-example-modal-lg">Thêm</button>
								<button class="border__button--button">Xóa</button>
								<button class="border__button--button" type="button"
									data-toggle="modal" data-target=".bs-example-modal-lg">Chỉnh
									sửa</button>
							</div>
						</div>
						<div class="modal fade bs-example-modal-lg" tabindex="-1"
							role="dialog" aria-labelledby="myLargeModalLabel">
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
																	<div class="col-md-8">
																		<div class="form-group">
																			<label class="bmd-label-floating">Nhà sản
																				xuất</label> <select class="form-control " id="sel1">
																				<%
																					List<Brand> listBrand = new ArrayList<Brand>();
																																																								BrandDAO getBrand = new BrandDAO();
																																																								listBrand = getBrand.getListBrand();
																																																								for (Brand b : listBrand) {
																				%>
																				<option><%=b.getBrandName()%></option>
																				<%
																					}
																				%>
																			</select> <label class="bmd-label-floating">Loại sản
																				phẩm</label> <select class="form-control " id="sel1">
																				<%
																					List<Category> listCategory = new ArrayList<Category>();
																																						CategoryDAO category = new CategoryDAO();
																																						listCategory = category.getListCategory();
																				%>
																				<%
																					for (Category c : listCategory) {
																				%>
																				<option><%=c.getCategoryName()%></option>
																				<%
																					}
																				%>
																			</select>
																		</div>
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
																			<label class="bmd-label-floating">Mô tả sản
																				phẩm</label>
																		</div>
																		<textarea rows="10">  
                                                            </textarea>
																		<hr>
																		<button type="submit"
																			class="btn btn-primary pull-right">Cập nhật
																			thông tin</button>
																		<button type="submit"
																			class="btn btn-primary pull-right">Hủy</button>
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

		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
			integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
			crossorigin="anonymous"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			
		</script>
</body>

</html>