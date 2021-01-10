<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="my-account">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">
					<div class="nav flex-column nav-pills" role="tablist"
						aria-orientation="vertical">
						<a class="nav-link"><i class="fa fa-shopping-bag"></i>Lịch sử
							đặt hàng</a> <a class="nav-link" href="my-account.jsp"><i
							class="fa fa-user"></i>Thông tin chi tiết</a>
					</div>
				</div>
				<div class="col-md-9">
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
						<tbody>
							<c:forEach var="bill" items="${listBill }">
								<form
									action="${pageContext.request.contextPath }/OrderHistory?command=detail&billID=${bill.getBillID()}"
									method="post">
									<tr>
										<td>${bill.getBillID()}</td>
										<td>${bill.getAddress() }</td>
										<td>${bill.getDate() }</td>
										<td>${bill.getTotal() }</td>
										<td>${bill.getState() }</td>
										<td><button class="btn" type="submit">Xem</button></td>
									</tr>
									<tr>
										<div></div>
								</form>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button>
	<c:if test="${!empty detailBill}">
		<script>
			document.getElementByID("exampleModal")
		</script>
	</c:if>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					
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
										<td>${bd.getProduct().getPrice()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>
			</div>
		</div>
	</div>
	<!-- My Account End -->
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>