<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="model.Category"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Quản lí sản phẩm</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<!-- CSS Files -->
<link href="${pageContext.request.contextPath}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

<body class="">
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
									<h4 class="card-title mt-0">Quản lí loại sản phẩm</h4>
									<p class="card-category"></p>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-hover">
											<thead class="">
												<th style="width: 400px">ID</th>
												<th>Nhà sản xuất</th>
												<th></th>
											</thead>
											<tbody>
											<c:forEach items="${categoryList}" var="item">
												<tr>
													<td >${item.getCategoryID()}</td>
													<td >${item.getCategoryName()}</td>
													<td>
													<a href="${pageContext.request.contextPath}/admin/category/update?id=${item.getCategoryID()}"><button  class="btn btn-primary pull-right">Cập nhật</button></a>
														<a href="${pageContext.request.contextPath}/admin/category/delete?id=${item.getCategoryID()}" onclick="return ConfirmDelete();"><button  class="btn btn-primary pull-right">Xóa</button></a>
													</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
            <div class="col-md-6  align-self-sm-end">
              <div class="border__button">
                <a href="${pageContext.request.contextPath}/admin/addCategory.jsp"><button class="border__button--button" >Thêm mới</button></a>
              </div>
            </div>
          </div>
				</div>
			</div>
		</div>
	</div>

</body>
<script>
    function ConfirmDelete()
    {
      var x = confirm("Bạn có muốn xóa mục này?");
      if (x)
          return true;
      else
        return false;
    }
</script> 

</html>