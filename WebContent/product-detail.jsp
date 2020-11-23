<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Product" %>
    <%@page import="get.GetProduct" %>
<!DOCTYPE html>
<html lang="en">
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <title>E Store - eCommerce HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">

        <!-- Favicon -->
        <link href="./client/static/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="./client/static/lib/slick/slick.css" rel="stylesheet">
        <link href="./client/static/lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="./client/static/css/style.css" rel="stylesheet">
    </head>

    <body>
    <jsp:include page="header.jsp"></jsp:include>
        <!-- Product Detail Start -->
        <div class="product-detail">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="product-detail-top">
                            <div class="row align-items-center">
                                <div class="col-md-5">
                                    <div class="product-slider-single normal-slider">
                                        <img src="${product.getImgFirst() }" alt="Product Image">
                                        <img src="${product.getImgLast() }" alt="Product Image">
                                        
                                    </div>
                                    <div class="product-slider-single-nav normal-slider">
									<div class="slider-nav-img">
										<img src="${product.getImgFirst() }" alt="Product Image">
									</div>
									<div class="slider-nav-img">
										<img src="${product.getImgLast() }" alt="Product Image">
									</div>

								</div>
                                </div>
                                <div class="col-md-7">
                                    <div class="product-content">
                                        <div class="title"><h2>${product.getName()}</h2></div>
                                        <div class="price">
                                            <h4>Giá:</h4>
                                            <p>${product.getPrice() } <span>$149</span></p>
                                        </div>
                                        <div class="quantity">
                                            <h4>Số lượng:</h4>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </div>
                                        <div class="action">
                                            <a class="btn" href="#"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row product-detail-bottom">
                            <div class="col-lg-12">
                                <ul class="nav nav-pills nav-justified">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="pill" href="#description">Mô tả sản phẩm</a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                    <div id="description" class="container tab-pane active">
                                        <h4>Product description</h4>
                                        <p>
                                         ${product.getDescription() }
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- Product Detail End -->
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="./client/static/lib/easing/easing.min.js"></script>
        <script src="./client/static/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="./client/static/js/main.js"></script>
    </body>
</html>
