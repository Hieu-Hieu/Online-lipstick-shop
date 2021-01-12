<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Product"%>
<%@page import="get.GetProduct"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Daily Shop | Product Detail</title>

<link href="./client/static/img/favicon.ico" rel="icon">
<link href="./client/static/css/detail/font-awesome.css"
	rel="stylesheet">
<link href="./client/static/css/detail/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="./client/static/css/detail/jquery.simpleLens.css">
<link href="./client/static/css/detail/theme-color/default-theme.css"
	rel="stylesheet">
<link
	href="./client/static/css/detail/sequence-theme.modern-slide-in.css"
	rel="stylesheet" media="all">
<link href="./client/static/css/detail/style.css" rel="stylesheet">
</head>
<body>
	
	

	<!-- product category -->
	<section id="aa-product-details">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="aa-product-details-area">
						<div class="aa-product-details-content">
							<div class="row">
								<!-- Modal view slider -->
								<div class="col-md-5 col-sm-5 col-xs-12">
									<div class="aa-product-view-slider">
										<div id="demo-1" class="simpleLens-gallery-container">
											<div class="simpleLens-container">
												<div class="simpleLens-big-image-container">
													<a data-lens-image="${product.getImgFirst() }"
														class="simpleLens-lens-image"><img
														src="${product.getImgFirst() }"
														class="simpleLens-big-image" height="300px" width="250px"></a>
												</div>
											</div>
											<div class="simpleLens-thumbnails-container">
												<a data-big-image="${product.getImgFirst() }"
													data-lens-image="${product.getImgFirst() }"
													class="simpleLens-thumbnail-wrapper" href="#"> <img
													src="${product.getImgFirst() }" height="55px" width="45px">
												</a> <a data-big-image="${product.getImgLast() }"
													data-lens-image="${product.getImgLast() }"
													class="simpleLens-thumbnail-wrapper" href="#"> <img
													src="${product.getImgLast() }" height="55px" width="45px">
												</a>
											</div>
										</div>
									</div>
								</div>
								<!-- Modal view content -->
								<div class="col-md-7 col-sm-7 col-xs-12">
									<div class="aa-product-view-content">
										<h3>${product.getName()}</h3>
										<div class="aa-price-block">
											<span class="aa-product-view-price">${price }Đ</span>
										</div>

										<form
											action="${pageContext.request.contextPath }/AddToCartController?cart=open&command=add&productID=${product.getProductID()}"
											method="post">
											<div class="quantity">
												<h4>Số lượng:</h4>
												<div class="qty">
													<button class="btn-minus" type="button">
														<i class="fa fa-minus"></i>
													</button>
													<input type="text" value="1" name="quantity" />
													<button ./client/static/css/detail/img/m/1.jpg
														type="button">
														<i class="fa fa-plus"></i>
													</button>
												</div>
											</div>
											<div class="action">
												<c:choose>
													<c:when test="${!empty user}">
														<button class="btn" type="submit" href="">
															<i class="fa fa-shopping-cart"></i>Thêm vào giỏ
														</button>
													</c:when>
													<c:otherwise>
														<button class="btn" onclick="handle()" type="button">
															<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
														</button>
													</c:otherwise>
												</c:choose>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="aa-product-details-bottom">
							<ul class="nav nav-tabs" id="myTab2">
								<li><a href="#" data-toggle="tab">Mô tả sản phẩm</a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane fade in active" id="description">
									<p>${product.getDescription() }</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				function handle() {
					if (confirm("Đăng nhập để tiếp tục")) {
						window.location = "signin.jsp";
					} else {
						window.location = "index.jsp";
					}
				}
			</script>
	</section>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="./client/static/css/detail/js/bootstrap.js"></script>
	<script
		src="./client/static/css/detail/js/sequence-theme.modern-slide-in.js"></script>
	<script type="text/javascript"
		src="./client/static/css/detail/js/jquery.simpleGallery.js"></script>
	<script type="text/javascript"
		src="./client/static/css/detail/js/jquery.simpleLens.js"></script>
	<script src="./client/static/css/detail/js/custom.js"></script>

</body>
</html>