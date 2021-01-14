
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap"
	rel="stylesheet">

<!-- CSS Libraries -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link href="./client/static/lib/slick/slick.css" rel="stylesheet">
<link href="./client/static/lib/slick/slick-theme.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="./client/static/css/style.css" rel="stylesheet">
</head>
<jsp:include page="header.jsp"></jsp:include>
<body style="background: white;">

	<!-- Main Slider Start -->
	<div class="header" >
		<div class="container-fluid" style="padding-left: 150px;">
			<div class="row">
				<div class="col-md-2" style="padding: 0; box-shadow: 5px 5px 10px rgba(0,0,0,0.3);">
					<nav class="navbar bg-light" style="align-items: flex-start;">
						<ul class="navbar-nav" style="background-color: white; ">
							<li class="nav-item">
							<a class="nav-link" href="#"><i class="fa fa-home"></i>Nhà sản xuất</a>
								<ul>
									<c:forEach items="${listBrand }" var="brand">
									<c:choose>
										<c:when test="${brand.getBrandID() eq param.brandID or brand.getBrandID() eq param.filterID}">
											<li style="padding: 0px;"><a style="text-decoration: underline; padding:0px;" href="${pageContext.request.contextPath }/ProductList?command=filter&currentPage=1&brandID=${brand.getBrandID()}&filter=brand">${brand.getBrandName() }</a></li>
										</c:when>
										<c:otherwise>
											<li style="padding: 0px;"><a style="padding:0px;"href="${pageContext.request.contextPath }/ProductList?command=filter&currentPage=1&brandID=${brand.getBrandID()}&filter=brand">${brand.getBrandName() }</a></li>
										</c:otherwise>
									</c:choose>
									</c:forEach>
								</ul>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#"><i class="fa fa-shopping-bag"></i>Loại sản xuất</a>
								<ul>
									<c:forEach items="${listCategory }" var="cate">
								<c:choose>
										<c:when test="${cate.getCategoryID() eq param.categoryID or cate.getCategoryID() eq param.filterID}">
										<li style="padding: 0px;"><a style="text-decoration: underline;" href="${pageContext.request.contextPath }/ProductList?command=filter&currentPage=1&categoryID=${cate.getCategoryID()}&filter=category">${cate.getCategoryName() }</a></li>
										</c:when>
										<c:otherwise>
										<li style="padding: 0px;"><a  href="${pageContext.request.contextPath }/ProductList?command=filter&currentPage=1&categoryID=${cate.getCategoryID()}&filter=category">${cate.getCategoryName() }</a></li>
										</c:otherwise>
									</c:choose>
										
									</c:forEach>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
				<div class="col-md-10" >
	
						<div class="product-view" style="padding: 0px;">
							<div class="container">
								<div class="row">
									<c:choose>
										<c:when test="${!empty EmptyListProduct }">
											<p>Không tìm thấy sản phẩm nào</p>
										</c:when>
										<c:when test="${!empty listProduct}">
											<c:forEach items="${listProduct}" var="p">
												<div class="col-md-3" style="box-shadow: 5px 5px 10px rgba(0,0,0,0.3); margin-left:20px; margin-right:20px">
													<div class="product-item">
														<div class="product-image" >
															<a href="${pageContext.request.contextPath}/ProductDetailController?productID=${p.getProductID() }"> 
															<img src="${p.getImgFirst() }" alt="Product Image" height="300px" style="border-bottom: solid 2px rgba(0,0,0,0.3)">
															</a>
														</div>
														<div class="product-price" style="text-align: center; background: none;">
														<p style="font-family: sans-serif; font-size: 18px; font-weight: 600; color: black; overflow: hidden; text-overflow: ellipsis; 
														display: -webkit-box; -webkit-box-orient: vertical;-webkit-line-clamp: 2;">${p.getName() }</p>
						
															<h3 style="color: #8e24aa; font-weight: bold; letter-spacing: 0.5px; font-size: 18px;">
																<fmt:formatNumber var="price" type="number "
																	pattern="###,###,###" value="${p.getPrice()}" />
																${price}VNĐ
															</h3>
															
														</div>
													</div>
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<c:redirect url="/ProductList?command=list&currentPage=1"></c:redirect>
										</c:otherwise>
									</c:choose>
								</div>

								<!-- Pagination Start -->
								<div class="col-md-12">
									<nav aria-label="Page navigation example">
										<ul class="pagination justify-content-center">
											<c:choose>
												<c:when test="${currentPage > 1}">
													<li class="page-item"><a class="page-link"
														href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${currentPage - 1}"
														tabindex="-1">Trang trước</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item disabled"><a class="page-link"
														href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${currentPage - 1}"
														tabindex="-1">Trang trước</a></li>
												</c:otherwise>
											</c:choose>


											<c:if test="${totalPage > 1 }">
												<c:forEach begin="1" end="${totalPage }" var="page">
													<c:choose>
														<c:when test="${currentPage == page }">
															<li class="page-item active"><a class="page-link"
																href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${page}">${page }</a>
															</li>
														</c:when>
														<c:otherwise>
															<li class="page-item"><a class="page-link"
																href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${page}">${page }</a>
															</li>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</c:if>

											<c:choose>
												<c:when test="${currentPage < totalPage }">
													<li class="page-item"><a class="page-link"
														href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${currentPage +1}">Trang sau</a>
													</li>
												</c:when>
												<c:otherwise>
													<li class="page-item disabled"><a class="page-link"
														href="${pageContext.request.contextPath }/ProductList?command=${command}&searchKey=${searchKey}&filterID=${filterID}&currentPage=${currentPage +1}">Trang sau</a>
													</li>
												</c:otherwise>
											</c:choose>

										</ul>
									</nav>
								</div>
							</div>
						</div>
						<!-- Product List End -->
				</div>

			</div>
		</div>
		
		<!-- Main Slider End -->
		<c:if test="${!empty LoginRequire }">
		 	<script type="text/javascript">
		 		alert("Đăng nhập để mua hàng");
		 	</script>
		</c:if>
		<!-- Back to Top -->
		<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
		<!-- JavaScript Libraries -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
		<script src="./client/static/lib/easing/easing.min.js"></script>
		<script src="./client/static/lib/slick/slick.min.js"></script>

		<!-- Template Javascript -->
		<script src="./client/static/js/main.js"></script>
		<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
