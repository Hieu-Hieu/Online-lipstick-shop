<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>E Store - eCommerce HTML Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">

        <!-- Favicon -->
        <link href="./static/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="./static/lib/slick/slick.css" rel="stylesheet">
        <link href="./static/lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="./static/css/style.css" rel="stylesheet">
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
                                        <img src="./static/img/product-1.jpg" alt="Product Image">
                                        <img src="./static/img/product-3.jpg" alt="Product Image">
                                        <img src="./static/img/product-5.jpg" alt="Product Image">
                                        <img src="./static/img/product-7.jpg" alt="Product Image">
                                        <img src="./static/img/product-9.jpg" alt="Product Image">
                                        <img src="./static/img/product-10.jpg" alt="Product Image">
                                    </div>
                                    <div class="product-slider-single-nav normal-slider">
                                        <div class="slider-nav-img"><img src="./static/img/product-1.jpg" alt="Product Image"></div>
                                        <div class="slider-nav-img"><img src="./static/img/product-3.jpg" alt="Product Image"></div>
                                        <div class="slider-nav-img"><img src="./static/img/product-5.jpg" alt="Product Image"></div>
                                        <div class="slider-nav-img"><img src="./static/img/product-7.jpg" alt="Product Image"></div>
                                        <div class="slider-nav-img"><img src="./static/img/product-9.jpg" alt="Product Image"></div>
                                        <div class="slider-nav-img"><img src="./static/img/product-10.jpg" alt="Product Image"></div>
                                    </div>
                                </div>
                                <div class="col-md-7">
                                    <div class="product-content">
                                        <div class="title"><h2>Product Name</h2></div>
                                        <div class="price">
                                            <h4>Giá:</h4>
                                            <p>$99 <span>$149</span></p>
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
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. In condimentum quam ac mi viverra dictum. In efficitur ipsum diam, at dignissim lorem tempor in. Vivamus tempor hendrerit finibus. Nulla tristique viverra nisl, sit amet bibendum ante suscipit non. Praesent in faucibus tellus, sed gravida lacus. Vivamus eu diam eros. Aliquam et sapien eget arcu rhoncus scelerisque. Suspendisse sit amet neque neque. Praesent suscipit et magna eu iaculis. Donec arcu libero, commodo ac est a, malesuada finibus dolor. Aenean in ex eu velit semper fermentum. In leo dui, aliquet sit amet eleifend sit amet, varius in turpis. Maecenas fermentum ut ligula at consectetur. Nullam et tortor leo. 
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
        <script src="./static/lib/easing/easing.min.js"></script>
        <script src="./static/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="./static/js/main.js"></script>
    </body>
</html>
