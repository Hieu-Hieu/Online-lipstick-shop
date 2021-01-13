<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
          Slide bav
        </title>
        <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <!-- CSS Files -->
        <link href="./static/css/material-dashboard.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
      </head>
<body>
    <div class="sidebar" data-color="purple" data-background-color="white">
        <div class="sidebar-wrapper" >
          <ul class="nav">
            <li class="nav-item active  ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/dashboard.jsp">
                <i class="material-icons"></i>
					<p>Dashboard</p>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/product/list?command=list&currentPage=1">
                <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                <p>Quản lí sản phẩm</p>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/user/list">
                <i class="fa fa-address-book" aria-hidden="true"></i>
                <p>Quản lí người dùng</p>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/category/list">
                <i class="fas fa-align-left"></i>
                <p>Quản lý loại sản phẩm</p>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/brand/list?command=list">
                <i class="fa fa-university" aria-hidden="true"></i>
                <p>Quản lí nhãn hiệu</p>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link" href="${pageContext.request.contextPath }/admin/order/list">
                <i class="fa fa-truck" aria-hidden="true"></i>
                <p>Quản lý đơn hàng</p>
              </a>
            </li>
            
          </ul>
        </div>
      </div>
</body>
</html>