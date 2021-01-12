<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Profile
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="./static/css/material-dashboard.css" rel="stylesheet" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
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
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Thông tin tài khoản</h4>
                  <p class="card-category"></p>
                </div>
                <div class="card-body">
                  <form action="${pageContext.request.contextPath }/admin/UpdateInfo" method="post">
                    <div class="row">
                      <div class="col-md-3">
                        <div class="form-group">
                          <label class="bmd-label-floating">Username</label>
                          <input type="text" class="form-control" value="${user.getUsername() }" name="username" required="required">
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating" >Email</label>
                          <input type="email" class="form-control" value="${user.getEmail() }" required="required" name="email">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Mật khẩu hiện tại</label>
                          <input type="text" class="form-control" name="oldPass" required="required">
                        </div>
                      </div>
                      <div class="col-md-4">
                       
                        <div class="form-group">
                          <label class="bmd-label-floating">Mật khẩu mới</label>
                          <input type="text" class="form-control" name="newPass1" required="required">
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Xác nhận mật khẩu</label>
                          <input type="text" class="form-control" name="newPass2" required="required">
                        </div>
                      </div>
                    </div>
                    <c:if test="${!empty oldPassError }">
	                            <div>${oldPassError}</div>
				      	 </c:if>
				      	 <c:if test="${!empty newPassError }">
	                                 		<div>${newPassError}</div>
							       		</c:if>
                    <button type="submit" class="btn btn-primary pull-right">Cập nhật thông tin</button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
		<c:if test="${!empty updateSuccess }">
	            <script type="text/javascript">
	            	alert("${updateSuccess}")
	            </script>
		</c:if>

</html>