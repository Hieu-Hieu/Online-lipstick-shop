<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <!-- Cart Start -->
        <div class="cart-page">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="cart-page-inner">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Tên sản phẩm</th>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Tổng</th>
                                            <th>Xóa khỏi giỏ hàng</th>
                                        </tr>
                                    </thead>
                                    <tbody class="align-middle">
                                    <c:forEach items="${listCart}" var="cart">
                                        <tr>
                                            <td>
                                                <div class="img">
                                                    <a href="#"><img src="${cart.get(1) }" alt="Image"></a>
                                                    <p>${cart.get(2) }</p>
                                                </div>
                                            </td>
                                            <td>${cart.get(3) }</td>
                                            <td>
                                            <form action="${pageContext.request.contextPath }/AddToCartController?command=update&userID=1&productID=${cart.get(0)}" method="post">
                                                <div class="qty"">
                                                    <button class="btn-minus" type="button"><i class="fa fa-minus"></i></button>
                                                    <input type="text" value="${cart.get(4) }" name="quantity">
                                                    <button class="btn-plus" type="button"><i class="fa fa-plus"></i></button>
                                                </div>
                                                    <button class="" type="submit"><i class="far fa-save"></i></button>
                                            </form>
                                            </td>
                                            <td>${cart.get(3) * cart.get(4) }</td>
                                            <td>
												<a href="${pageContext.request.contextPath }/AddToCartController?command=remove&userID=1&productID=${cart.get(0)}">
													<i class="fa fa-trash"></i>
												</a>
											</td>
										</tr>
                                    </c:forEach>
                                       
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                     <div class="col-lg-4">
                        <div class="cart-page-inner">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="cart-summary">
                                        <div class="cart-content">
                                            <h1>Tổng thanh toán<span>   $100</span></h1>
                                            <hr>
                                        </div>
                                        <div class="cart-btn">
                                            <button>Đặt hàng</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Cart End -->
        <!-- Checkout Start -->
        <div class="checkout">
            <div class="container-fluid"> 
                <div class="row">
                    <div class="col-lg-8">
                        <div class="checkout-inner">
                            <div class="billing-address">
                                <h2>Thông tin đặt hàng</h2>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label>Tên</label>
                                        <input class="form-control" type="text" placeholder="Tên">
                                    </div>
                                    <div class="col-md-6">
                                        <label>E-mail</label>
                                        <input class="form-control" type="text" placeholder="E-mail">
                                    </div>
                                    <div class="col-md-6">
                                        <label>Số điện thoại</label>
                                        <input class="form-control" type="text" placeholder="Số điện thoại">
                                    </div>
                                    <div class="col-md-12">
                                        <label>Địa chỉ</label>
                                        <input class="form-control" type="text" placeholder="Địa chỉ">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        <!-- Checkout End -->
        
        <jsp:include page="footer.jsp"></jsp:include>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="./client/static/lib/easing/easing.min.js"></script>
        <script src="./client/static/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="./client/static/js/main.js"></script>
    </body>
</html>