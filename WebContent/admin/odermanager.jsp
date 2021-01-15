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
        <label for="exampleFormControlSelect1">Chọn loại đơn hàng</label>
        	<form action="${pageContext.request.contextPath}/admin/order/list" method="get">
			    <select name="status" class="form-control" id="exampleFormControlSelect1" style="width: 25%; background-color: #f1f1f1;">
			    
			      <option value="pending">Đang chờ duyệt</option>
			      <c:choose>
			      	<c:when test="${status=='censored'}">
			      		<option value="censored" selected="selected">Đã duyệt</option>
			      	</c:when>
			      	<c:otherwise>
			      		<option value="censored" >Đã duyệt</option>
			      	</c:otherwise>
			      </c:choose>
			      <c:choose>
			      	<c:when test="${status=='cancel'}">
			      		 <option value="cancel" selected="selected">Đã hủy</option>
			      	</c:when>
			      	<c:otherwise>
			      		<option value="cancel">Đã hủy</option>
			      	</c:otherwise>
			      	</c:choose>
			      	
			      <c:choose>
			      	<c:when test="${status=='orderSuccess'}">
			      		  <option value="orderSuccess" selected="selected">Đã giao</option>
			      	</c:when>
			      	<c:otherwise>
			      		 <option value="orderSuccess">Đã giao</option>
			      	</c:otherwise>
			      </c:choose>
			     
			    </select>
			    <input type="submit" value="Lọc" style="background-color: #ab47bc; color: white; width: 80px; height: 30px; font-sixe: 18px; border-radius: 5%; border: none; margin-top:5px;">
			 </form>
          <div class="row">
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0"> Quản lí đơn hàng</h4>
                  <p class="card-category"> </p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead class="">
                        <th>
                          ID
                        </th>
                        <th>
                          Người nhận
                        </th>
                        <th>Ngày đặt</th>
                        <th>
                          Địa chỉ
                        </th>
                        <th>
                          Tổng thanh toán
                        </th>
                        <th>
                          Tình trạng
                        </th>
                        <th>
							Duyệt
						 </th>
                      </thead>
                      <tbody>
                      <form action="${pageContext.request.contextPath}/admin/order/list" method="get">
                      <c:forEach var="bill" items="${listBill}">
                        <tr>
                          <td>
                            ${bill.billID}
                          </td>
                          <td>
                             ${bill.user.username}
                          </td>
                          <td>${bill.date}</td>
                          <td>
                             ${bill.address}
                          </td>
                          <td>
                           <fmt:formatNumber var="price" type="number " pattern = "###,###,###" value="${bill.total}" />
							${price}<span>VNĐ</span>
                             
                          </td>
                          <td>
                             ${bill.state}
                          </td>
                          <td>
                          <c:choose>
  							<c:when test="${status == 'cancel' || status == 'orderSuccess' }">
                          		<a href="${pageContext.request.contextPath }/admin/BillDetail?billID=${bill.billID}">Chi tiết</a>
                          	</c:when>
                          	<c:otherwise>
                          <input type="hidden" value="${bill.billID}" name="id">
                            <select  name="Action" style="font-size: 1.063rem; padding: 8px 4px;vertical-align: middle; border-color: #ddd; border-radius: 5%; padding-right: 10px; background-color: #f1f1f1;" >
                              <c:if test = "${status == 'pending'}">
							  <option value="Duyet">Duyệt đơn</option>
							  <option value="Huy">Hủy đơn</option>
							  </c:if>
							  <c:if test = "${status == 'censored'}">
							  <option value="Huy">Hủy đơn</option>
							  <option value="DaGiao">Đã giao</option>
							  </c:if>
							</select>
							<button type="submit" onclick="return ConfirmClick()"  class="btn btn-primary pull-right"	>Cập nhật</button>
							</c:otherwise>
							</c:choose>
                          </td>
                        </tr>
                        </c:forEach>
                        </form>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>

</body>
<script>
    function ConfirmClick()
    {
      var x = confirm("Xác nhận thay đổi?");
      if (x)
          return true;
      else
        return false;
    }
</script> 
</html>