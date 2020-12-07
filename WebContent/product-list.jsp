<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="get.GetProduct" %>    
<%@page import="model.Product" %>
<%@page import="java.text.DecimalFormat" %>
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
        <!-- Product List Start -->
        <div class="product-view">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="product-view-top">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="product-search">
                                                <input type="email" value="Search">
                                                <button><i class="fa fa-search"></i></button>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-short">
                                                <div class="dropdown">
                                                    <div class="dropdown-toggle" data-toggle="dropdown">Product short by</div>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item">Newest</a>
                                                        <a href="#" class="dropdown-item">Popular</a>
                                                        <a href="#" class="dropdown-item">Most sale</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="product-price-range">
                                                <div class="dropdown">
                                                    <div class="dropdown-toggle" data-toggle="dropdown">Product price range</div>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a href="#" class="dropdown-item">$0 to $50</a>
                                                        <a href="#" class="dropdown-item">$51 to $100</a>
                                                        <a href="#" class="dropdown-item">$101 to $150</a>
                                                        <a href="#" class="dropdown-item">$151 to $200</a>
                                                        <a href="#" class="dropdown-item">$201 to $250</a>
                                                        <a href="#" class="dropdown-item">$251 to $300</a>
                                                        <a href="#" class="dropdown-item">$301 to $350</a>
                                                        <a href="#" class="dropdown-item">$351 to $400</a>
                                                        <a href="#" class="dropdown-item">$401 to $450</a>
                                                        <a href="#" class="dropdown-item">$451 to $500</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                       		<c:forEach items="${listProduct}" var="p">
								<div class="col-md-4">
									<div class="product-item">
										<div class="product-title">
											<a href="">${p.getName() }</a>
										</div>
										<div class="product-image">
											<a href="product-detail.jsp"> <img
												src="${p.getImgFirst() }" alt="Product Image">
											</a>
											<div class="product-action">
												<a href="${pageContext.request.contextPath}/AddToCartController?cart=no&command=add&userID=1&productID=${p.getProductID() }&quantity=1&currentPage=${currentPage}"><i
													class="fa fa-cart-plus"></i></a> 
													<a href="#"><i class="fa fa-heart"></i></a> 
													<a href="${pageContext.request.contextPath}/ProductDetailController?productID=${p.getProductID() }">Chi
													Tiết</a>
											</div>
										</div>
										<div class="product-price">
											<h3>
											<fmt:formatNumber var="price" type="number " pattern = "###,###,###" value="${p.getPrice()}" />
												${price}<span>Đ</span></h3>
											<a class="btn"
												href="${pageContext.request.contextPath}/AddToCartController?cart=open&command=add&userID=1&productID=${p.getProductID() }&quantity=1&currentPage=${currentPage}"><i
												class="fa fa-shopping-cart"></i>Mua ngay</a>
										</div>
									</div>
								</div>
							</c:forEach>
                        </div>
                        
                        <!-- Pagination Start -->
                        <div class="col-md-12">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-center">
                                <c:choose>
                                	<c:when test="${currentPage > 1}">
                                		<li class="page-item">
                                		 <a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${currentPage - 1}" tabindex="-1">Previous</a>
                                    </li>
                                	</c:when>
                                	<c:otherwise>
                                		<li class="page-item disabled">
                                		 <a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${currentPage - 1}" tabindex="-1">Previous</a>
                                    </li>
                                	</c:otherwise>
                                </c:choose>
                                    	
	                               
                                    <c:if test="${totalPage > 1 }">
                                    	<c:forEach begin="1" end="${totalPage }" var="page">
                                    		<c:choose>
                                    			<c:when test="${currentPage == page }">
                                    				<li class="page-item active">
                                    					<a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${page}">${page }</a>
                                    				</li> 
                                    			</c:when>
                                    			<c:otherwise>
                                    				<li class="page-item">
                                    					<a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${page}">${page }</a>
                                    				</li> 
                                    			</c:otherwise>
                                    		</c:choose>
                                    	</c:forEach>
                                    </c:if>
                                   
                                    <c:choose>
                                    	<c:when test="${currentPage < totalPage }">
                                    		<li class="page-item">
                                    		<a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${currentPage +1}">Next</a>
                                    </li>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<li class="page-item disabled">
                                    		<a class="page-link" href="${pageContext.request.contextPath }/ProductList?currentPage=${currentPage +1}">Next</a>
                                    </li>
                                    	</c:otherwise>
                                    </c:choose>
                                    
                                </ul>
                            </nav>
                        </div>
                        <!-- Pagination Start -->
                    </div>           
                    
                    <!-- Side Bar Start -->
                    <div class="col-lg-4 sidebar">
                        <div class="sidebar-widget category">
                            <h2 class="title">Danh sách tìm kiếm</h2>
                            <nav class="navbar bg-light">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-female"></i>3CE</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-child"></i>Inistree</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-tshirt"></i>Nhà sản xuất 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-mobile-alt"></i>Nhà sản xuất 1</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#"><i class="fa fa-microchip"></i>Nhà sản xuất 1</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="sidebar-widget tag">
                            <h2 class="title">Tags Cloud</h2>
                            <a href="#">Lorem ipsum</a>
                            <a href="#">Vivamus</a>
                            <a href="#">Phasellus</a>
                            <a href="#">pulvinar</a>
                            <a href="#">Curabitur</a>
                            <a href="#">Fusce</a>
                            <a href="#">Sem quis</a>
                            <a href="#">Mollis metus</a>
                            <a href="#">Sit amet</a>
                            <a href="#">Vel posuere</a>
                            <a href="#">orci luctus</a>
                            <a href="#">Nam lorem</a>
                        </div>
                    </div>
                    <!-- Side Bar End -->
                </div>
            </div>
        </div>
        <!-- Product List End -->  
            <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="./static/lib/easing/easing.min.js"></script>
        <script src="./static/lib/slick/slick.min.js"></script>
        
        <!-- Template Javascript -->
        <script src="./static/js/main.js"></script>
    </body>
</html>
