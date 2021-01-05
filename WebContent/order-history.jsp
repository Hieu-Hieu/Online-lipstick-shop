<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="tab-pane fade" id="orders-tab" role="tabpanel"
		aria-labelledby="orders-nav">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>STT</th>
						<th>Địa chỉ</th>
						<th>Ngày 1đặt</th>
						<th>Tổng thanh toán</th>
						<th>Tình trạng</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="bill" items="${listBill }">
					<form >
						<tr>
							<td>${bill.getBillID()}</td>
							<td>${bill.getAddress() }</td>
							<td>${bill.getDate() }</td>
							<td>${bill.getTotal() }</td>
							<td>${bill.getState() }</td>
							<td><button class="btn">Xem</button></td>
						</tr>				
					</form>
				</c:forEach>
					
					<tr>
						<td>2</td>
						<td>Product Name</td>
						<td>01 Jan 2020</td>
						<td>$99</td>
						<td>Approved</td>
						<td><button class="btn">Xem</button></td>
					</tr>
					<tr>
						<td>3</td>
						<td>Product Name</td>
						<td>01 Jan 2020</td>
						<td>$99</td>
						<td>Approved</td>
						<td><button class="btn">Xem</button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>