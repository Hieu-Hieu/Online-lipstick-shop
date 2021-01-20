<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Quản lí đơn hàng
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="${pageContext.request.contextPath}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
<jsp:include page="slidebav.jsp"></jsp:include>
  <div class="wrapper ">
    <div class="main-panel">
      <div class="content">
        <div class="container-fluid">
       
          <c:if test="${!empty detailBill}">
								<h5 style="margin-top: 20px;">Chi tiết đơn hàng:
									${detailBill.get(0).getBill().getBillID()}</h5>
								<table class="table table-borderless">
									<thead class="thead">
										<tr>
											<th>Mã đơn</th>
											<th>Mã sản phẩm</th>
											<th>Tên sản phẩm</th>
											<th>Hình ảnh</th>
											<th>Thương hiệu</th>
											<th>Số lượng</th>
											<th>Giá</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${detailBill }" var="bd">
											<tr>
												<td>${bd.getBill().getBillID()}</td>
												<td>${bd.getProduct().getProductID()}</td>
												<td>${bd.getProduct().getName()}</td>
												<td><img width="50px" height="50px"
													src="${bd.getProduct().getImgFirst() }" /></td>
												<td>${bd.getProduct().getBrand().getBrandName()}</td>
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

</body>

</html>