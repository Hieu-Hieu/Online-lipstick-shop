<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@ page import= "java.util.*" %>
<%@page import="get.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<%
		List<Category> listCategory =new ArrayList<Category>();
		GetCategory category =new GetCategory();
		listCategory = category.getListCategory();
		
		List<Brand> listBrand = new ArrayList<Brand>();
      	GetBrand getBrand =new GetBrand();
      	listBrand = getBrand.getListBrand();
	%>													   
	
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
													<form method="post" action="${pageContext.request.contextPath}/admin/addProduct" enctype="multipart/form-data" >
														<div class="row">
															<div class="col-md-6">
																<div class="row">
																	<div class="product-detail">
																		 <img src="./static/img/son.jpg" alt="Product Image"
																			width="300px" height="300px" id="file-ip-1-preview"> 
																			<!-- <label for="file-ip-1">Upload Image</label> -->
																		<input class="btn btn-primary addimg" type="file" name="image1" value="#" accept="image/*"
																			id="file-ip-1" onchange="showPreview1(event);" />
																			
																	</div>
																</div>
																<br>
																<div class="row">
																	<div class="product-detail">
																		<img src="./static/img/son.jpg" alt="Product Image"
																			width="300px" height="300px" id="file-ip-2-preview">
																		<input class="btn btn-primary addimg" type="file" name="image2" value="#" accept="image/*" onchange="showPreview2(event);" >
																			
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
																			
																			<%  for(Brand b : listBrand){%>
                     												 	<option><%=b.getBrandName() %></option>
                     														 <%} %>
                     														 
																		</select>
																	</div>
																	<div class="col-md-6">
																		<label class="bmd-label-floating">Loại sản phẩm</label>
																		<select class="form-control"
																			id="exampleFormControlSelect1">
																			
																			<%for(Category c : listCategory) {%>
																			<option><%= c.getCategoryName() %></option>
																			<%} %>
																			
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
																			<label class="bmd-label-floating">Mô tả sản
																				phẩm</label>
																		</div>
																		<textarea rows="10">  
                                                                </textarea>
																		<hr>
																		<button type="submit"
																			class="btn btn-primary pull-right" value="Upload">Cập nhật
																			thông tin</button>
																		<button type="submit"
																			class="btn btn-primary pull-right">
																			Quay lại</a>
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
	
	<script type="text/javascript">
	function showPreview1(event){
		  if(event.target.files.length > 0){
		    var src = URL.createObjectURL(event.target.files[0]);
		    var preview = document.getElementById("file-ip-1-preview");
		    preview.src = src;
		    preview.style.display = "block";
		  }
		}
	function showPreview2(event){
		  if(event.target.files.length > 0){
		    var src = URL.createObjectURL(event.target.files[0]);
		    var preview = document.getElementById("file-ip-2-preview");
		    preview.src = src;
		    preview.style.display = "block";
		  }
		}
	</script>
</body>
</html>