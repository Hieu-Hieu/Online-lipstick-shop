<%@page import="model.User"%>
<%@page import="get.GetUser"%>
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
        <!-- My Account Start -->
        
        <%
        GetUser getUser = new GetUser();
        User u = new User();
        u = (User)session.getAttribute("user");
        u = getUser.getUserByID(u.getUserID());
        %>
        <div class="my-account">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <div class="nav flex-column nav-pills" role="tablist" aria-orientation="vertical">
                            <a class="nav-link" href="${pageContext.request.contextPath}/OrderHistory?command=list"><i class="fa fa-shopping-bag"></i>Lịch sử đặt hàng</a>
                            <a class="nav-link" id="account-nav" data-toggle="pill" href="#account-tab" role="tab"><i class="fa fa-user"></i>Thông tin chi tiết</a>
                            <a class="nav-link" href="${pageContext.request.contextPath}/UserLogout"><i class="fa fa-sign-out-alt"></i>Đăng xuất</a>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="tab-content">
                            
                            <div class="tab-pane fade" id="account-tab" role="tabpanel" aria-labelledby="account-nav">
                                <h4>Thông tin chi tiết</h4>
                                <form action="${pageContext.request.contextPath }/UserController?command=update" method="post">
	                                <div class="row">
	                                    <div class="col-md-6">
	                                        <input class="form-control" type="text" placeholder="Tên" value="${u.getUsername() }" name="username" required>
	                                    </div>
	                                    <div class="col-md-6">
	                                        <input class="form-control" type="tel" placeholder="Số điện thoại" value="${u.getPhone() }" name="phone" required>
	                                    </div>
	                                    <div class="col-md-6">
	                                        <input class="form-control" type="email" placeholder="Email" value="${u.getEmail() }" name="email" required>
	                                    </div>
	                                    <div class="col-md-12">
	                                        <input class="form-control" type="text" placeholder="Địa chỉ" value="${u.getAddress() }" name="address" required>
	                                    </div>
	                                    <div class="col-md-12">
	                                        <button type="submit">Cập nhật</button>
	                                    </div>
	                                </div>
                                </form>
                                <h4>Đổi mật khẩu</h4>
                                <div class="row">
                                    <div class="col-md-12">
                                        <input class="form-control" type="password" placeholder="Mật khẩu hiện tại">
                                    </div>
                                    <div class="col-md-6">
                                        <input class="form-control" type="text" placeholder="Mật khẩu mới">
                                    </div>
                                    <div class="col-md-6">
                                        <input class="form-control" type="text" placeholder="Xác nhận mật khẩu">
                                    </div>
                                    <div class="col-md-12">
                                        <button class="btn">Lưu thay đổi</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- My Account End -->
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
