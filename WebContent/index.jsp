
<%@ page import= "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Product" %>
    <%@page import="get.GetProduct" %>
<!DOCTYPE html>
<html lang="en">
    <head>
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
    
  
        <!-- Main Slider Start -->
        <div class="header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <nav class="navbar bg-light" style="align-items: flex-start;">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-home"></i>Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-shopping-bag"></i>Best Selling</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-plus-square"></i>New Arrivals</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-female"></i>Fashion & Beauty</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-child"></i>Kids & Babies Clothes</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-tshirt"></i>Men & Women Clothes</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>Gadgets & Accessories</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#"><i class="fa fa-microchip"></i>Electronics & Accessories</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-9">
                        <div class="row">
                            <div class="product-view">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-item">
                                                <div class="product-title">
                                                    <a href="#">Son Nữ Hoàng</a>
                                                </div>
                                                <div class="product-image">
                                                    <a href="product-detail.jsp">
                                                        <img src="./client/static/img/son1.png" alt="Product Image">
                                                    </a>
                                                </div>
                                                <div class="product-price">
                                                    <h3>300000<span>vnđ</span></h3>
                                                    <a class="btn" href="cart.jsp"><i class="fa fa-shopping-cart"></i>Thêm</a>
                                                </div>
                                            </div>
                                        </div>
                                    <!-- Pagination Start -->
                                    <div class="col-md-12">
                                        <nav aria-label="Page navigation example">
                                            <ul class="pagination justify-content-center">
                                                <li class="page-item disabled">
                                                    <a class="page-link" href="#" tabindex="-1">Trước	</a>
                                                </li>
                                                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                <li class="page-item">
                                                    <a class="page-link" href="#">Sau</a>
                                                </li>
                                            </ul>
                                        </nav>
                                    </div>
                                    <!-- Pagination Start -->
                                </div>              
                            </div>
                            <!-- Product List End -->  
                        </div>
                    </div>
                            
            </div>
        </div>
        <!-- Main Slider End -->      

	
		<jsp:include page="footer.jsp"></jsp:include>
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="./client/static/lib/easing/easing.min.js"></script>
        <script src="./client/static/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="./client/static/js/main.js"></script>
    </body>
</html>
