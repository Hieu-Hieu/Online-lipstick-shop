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
						<th>Ngày đặt</th>
						<th>Tổng thanh toán</th>
						<th>Tình trạng</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bill" items="${listBill }">
						<form action="${pageContext.request.contextPath }/OrderHistory?command=detail&billID=${bill.getBillID()}" method="post">
						<tr>
							<td>${bill.getBillID()}</td>
							<td>${bill.getAddress() }</td>
							<td>${bill.getDate() }</td>
							<td>${bill.getTotal() }</td>
							<td>${bill.getState() }</td>
							<td><button class="btn" type="submit">Xem</button></td>
						</tr>
						<div>
							<c:if test="${!empty detailBill && billID eq bill.getBillID() }">
								<table>
									<c:forEach items="${detailBill }" var="bd">
										<tr>
											<td>${bd.getProduct().getName()}</td>
											<td>${bd.getProduct().getImgFirst() }</td>
											<td>${bd.getQuantity()}</td>
											<td>${bd.getProduct().getPrice()}</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
						</div>
						</form>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>