<%@page import="model.BillDetail"%>
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

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<!-- Cart Start -->
	<c:if test="${!empty quantityError}">
		<script type="text/javascript">
			var mess = "${quantityError}";
			alert(mess);
		</script>
	</c:if>
	<div class="cart-page">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-10">
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
													<a href="#"><img
														src="${cart.getProduct().getImgFirst()}" alt="Image"></a>
													<p>${cart.getProduct().getName()}</p>
												</div>
											</td>

											<td><fmt:formatNumber var="price" type="number"
													pattern="###,###,###"
													value="${cart.getProduct().getPrice()}" /> ${price }Đ</td>
											<td>
												<form
													action="${pageContext.request.contextPath }/AddToCartController?command=update&productID=${cart.getProduct().getProductID()}"
													method="post">
													<div class="qty"">
														<button class="btn-minus" type="button">
															<i class="fa fa-minus"></i>
														</button>
														<input type="text" value="${cart.getQuantity() }"
															name="quantity" min="1">
														<button class="btn-plus" type="button">
															<i class="fa fa-plus"></i>
														</button>
													</div>
													<button class="" type="submit">
														<i class="far fa-save"></i>
													</button>
												</form>
											</td>
											<fmt:formatNumber var="totalPrice" type="number"
												pattern="###,###,###"
												value="${cart.getQuantity() * cart.getProduct().getPrice() }" />
											<td>${totalPrice }Đ</td>
											<td><a
												href="${pageContext.request.contextPath }/AddToCartController?command=remove&productID=${cart.getProduct().getProductID()}">
													<i class="fa fa-trash"></i>
											</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</div>
	<!-- Cart End -->
	<!-- Checkout Start -->
	<div class="checkout">
		<div class="container-fluid">
			<div class="row">

			<div class="col-lg-1"></div>
			<div class="col-lg-6">
				<form action="${pageContext.request.contextPath}/BillController" method="post" style="display: flex">
					
						<div class="checkout-inner">
							<div class="billing-address">
								<h2>Thông tin đặt hàng</h2>
								<div class="row">
									<div class="col-md-6">
										<label>Tên</label> <input class="form-control" type="text"
											placeholder="Tên" value="${user.getUsername() }" name="name">
									</div>
									<div class="col-md-6">
										<label>E-mail</label> <input class="form-control" type="text"
											placeholder="E-mail" value="${user.getEmail() }" name="email">
									</div>
									<div class="col-md-6">
										<label>Số điện thoại</label> <input class="form-control"
											type="text" placeholder="Số điện thoại"
											value="${user.getPhone() }" name="phone">
									</div>
									<div class="col-md-12">
										<label>Địa chỉ</label> <input class="form-control" type="text"
											placeholder="Địa chỉ" value="${user.getAddress() }"
											name="address">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
					<div class="cart-page">
						
							<div class="cart-page-inner"
								style=" width: 400px; height: 300px;">
								<div class="cart-content">
									<h2>
										Tổng thanh toán
										<fmt:formatNumber var="total" type="number"
											pattern="###,###,###" value="${totalCart }" />
											<c:if test="${totalCart>0 }">
												<br> <span> ${total }Đ</span>
											</c:if>
									</h2>

									<hr>
								</div>
								<c:if test="${!empty listCart }">
									<button type="submit" class="btn"
									style="border: solid 2px #8e24aa; font-size: 18px; font-weight: 600; color: white; background-color: #8e24aa;">Đặt
									hàng</button>
								</c:if>

							</div>
						</div>
					</div>
				</form>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</div>
	<!-- Checkout End -->

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="./client/static/lib/easing/easing.min.js"></script>
	<script src="./client/static/lib/slick/slick.min.js"></script>

	<!-- Template Javascript -->
	<script src="./client/static/js/main.js"></script>
</body>
</html>
