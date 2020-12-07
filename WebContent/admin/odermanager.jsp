<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<%@page import="get.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@page import="java.text.DecimalFormat"%> 
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
  <!-- CSS Files -->
  <link href="./static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
<% 
GetBill getbill =new GetBill();
List <Bill> listBill =new ArrayList<Bill>();
listBill= getbill.getListBill();
%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="slidebav.jsp"></jsp:include>
  <div class="wrapper ">
    <div class="main-panel">
      <div class="content">
        <div class="container-fluid">
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
                          Action
                        </th>
                      </thead>
                      <tbody>
                      <% for(Bill b : listBill){ %>
                        <tr>
                          <td>
                            <%=b.getBillID() %>
                          </td>
                          <td>
                            <%=b.getUserID()%>
                          </td>
                          <td>
                            <%= b.getAddress() %>
                          </td>
                          <td>
                           <%-- <fmt:formatNumber value= "<%=b.getTotal()%>" type="number" pattern="###.###" />VNĐ
                            <%= b.getTotal() %> --%>
                            <% DecimalFormat formatter = new DecimalFormat("###,###,###");%>

							<%= formatter.format(b.getTotal())%> VNĐ
                          </td>
                          <td>
                            <% if(b.getPaid()==1)
                            	%>
                            	Đã thanh toán
                            
                            <% if(b.getPaid()==0)
                            	%> Chưa thanh toán
                          </td>
                          <td>
                            <a>Xem chi tiết</a>
                          </td>   
                        </tr>
                        <%} %>
                        
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6   align-self-md-center">
            <ul class="pagination modal-2">
              <li><a href="#" class="prev">&laquo </a></li>
              <li><a href="#">1</a></li>
              <li> <a href="#">2</a></li>
              <li> <a href="#" class="active">3</a></li>
              <li> <a href="#">4</a></li>
              <li> <a href="#">5</a></li>
              <li> <a href="#">6</a></li>
              <li> <a href="#">7</a></li>
              <li> <a href="#">8</a></li>
              <li> <a href="#">9</a></li>
              <li><a href="#" class="next">  &raquo;</a></li>
            </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>

</html>