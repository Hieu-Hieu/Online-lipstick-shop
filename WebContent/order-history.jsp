<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
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
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-2" style="box-shadow: 2px 0px 2px rgba(142,36,170,0.3);">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link"><i class="fa fa-shopping-bag"></i>Lịch sử
							đặt hàng</a> <a class="nav-link" href="my-account.jsp"><i
							class="fa fa-user"></i>Thông tin chi tiết</a>
					</div>
				</div>
				<div class="col-md-8">
				<div class="cart-page">
					<div class="cart-page-inner" style="padding-top: 0px">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead class="thead-dark">
									<tr>
										<th>STT</th>
										<th>Địa chỉ</th>
										<th>Ngày đặt</th>
										<th>Tổng thanh toán</th>
										<th>Tình trạng</th>
										<th></th>
									</tr>
								</thead>
								<tbody class="align-middle">
									<c:forEach var="bill" items="${listBill }">
										<form
											action="${pageContext.request.contextPath }/OrderHistory?command=detail&billID=${bill.getBillID()}"
											method="post">
											<tr>
												<td>${bill.getBillID()}</td>
												<td>${bill.getAddress() }</td>
												<td>${bill.getDate() }</td>
												<fmt:formatNumber var="total" type="number"
												pattern="###,###,###"
												value="${bill.getTotal()}" />
												<td>${total}Đ</td>
												<td>${bill.getState() }</td>
												<td><button class="btn" type="submit" style="width:50px;">Xem</button></td>
											</tr>
											<tr>
												<div></div>
										</form>
									</c:forEach>

								</tbody>
							</table>
							
							<c:if test="${!empty detailBill}">
								<h5 style="margin-top: 20px;">Chi tiết đơn hàng:
									${detailBill.get(0).getBill().getBillID()}</h5>
								<table class="table table-bordered">
									<thead class="thead-dark">
										<tr>
											<th>ID</th>
											<th>Tên sản phẩm</th>
											<th>Hình ảnh</th>
											<th>Số lượng</th>
											<th>Giá</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${detailBill }" var="bd">
											<tr>
												<td>${bd.getBill().getBillID()}</td>
												<td>${bd.getProduct().getName()}</td>
												<td><img width="50px" height="50px"
													src="${bd.getProduct().getImgFirst() }" /></td>
												<td>${bd.getQuantity()}</td>
												<fmt:formatNumber var="price" type="number"
												pattern="###,###,###"
												value="${bd.getProduct().getPrice()}" />
												<td>${price}Đ</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- My Account End -->

</body>
</html>