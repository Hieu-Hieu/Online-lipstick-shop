<%@page import="get.GetCart"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header</title>

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
    <!-- Nav Bar Start -->
    <div class="nav">
        <div class="container-fluid">
            <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                <a href="#" class="navbar-brand">MENU</a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto">
                    	<a></a>
                        <a href="index.jsp" class="nav-item nav-link">Trang chủ</a>
                        <a href="my-account.jsp" class="nav-item nav-link">Tài khoản</a>
                    </div>
                    <c:choose>
                    	<c:when test="${user.getUsername() == null}">
		                    <div class="navbar-nav ml-auto">
		                        <a href="signin.jsp" class="nav-item nav-link">Đăng nhập</a>
		                       	<a href="register.jsp" class="nav-item nav-link">Đăng kí</a>
		                    </div>
                    	</c:when>
                    	<c:otherwise>
                    		<div class="navbar-nav ml-auto">
		                        ${user.getUsername()}
		                    </div>
                    	</c:otherwise>
                    </c:choose>
                </div>
            </nav>
        </div>
    </div>
    <!-- Nav Bar End --> 

 
        <!-- Bottom Bar Start -->
        <div class="bottom-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-3">
                        <div class="logo">
                            <a href="index.jsp">
                                <img src="./client/static/img/logo.png" alt="Logo">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="search">
	                        <form action="${pageContext.request.contextPath }/ProductList?command=search&currentPage=1" method="post">
	                            <input type="text" placeholder="Tìm Kiếm" name="input" value="${param.searchkey }">
	                            <button type="submit"><i class="fa fa-search"></i></button>
	                        </form>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="user">
                        <c:choose>
                        	<c:when test="${!empty user.getUserID() }">
	                            <a href="${pageContext.request.contextPath }/CartController" class="btn cart">
	                                <i class="fa fa-shopping-cart"></i>
	                                <span>
									<%GetCart gc =new GetCart();
									User u = (User)session.getAttribute("user");%>
									<%=gc.totalProduct(u.getUserID())%>
									
									</span>
	                            </a>
                        	</c:when>
                        	<c:otherwise>
                        		<a href="${pageContext.request.contextPath }/CartController" class="btn cart">
	                                <i class="fa fa-shopping-cart"></i>
	                                <span>
									0
									</span>
	                            </a>
                        	</c:otherwise>
                        </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bottom Bar End -->    
</body>
</html>