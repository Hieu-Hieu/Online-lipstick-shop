<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
	<link rel="stylesheet" href="./client/static/css/login2.css">
	<link rel="stylesheet" href="./client/static/css/bootstrap.min.css">
</head>
<body>
      <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6 order-md-2">
          <img src="./client/static/img/bn.jpg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>Đăng kí</h3>
            </div>
            <form action="${pageContext.request.contextPath}/UserController?command=register" method="post">
            <c:if test="${!empty login }">
        		<script type="text/javascript">
        		if(confirm("Đăng ký thành công. Đăng nhập để tiếp tục")){
        		window.location = "signin.jsp";
      		  	}
        		</script>
        	</c:if>
              <div class="form-group first">
                <input type="text" class="form-control" placeholder="Tên" name="name" value="${name }" required>
                <c:if test="${!empty errorName }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorName }
					</div>
	         	</c:if>
              </div>
              <div class="form-group last mb-4">
                  <input type="text" class="form-control" placeholder="Địa chỉ" name="address" value="${address }" required>   
              </div>
              <div class="form-group first">
              	<input type="tel" class="form-control" placeholder="Số điện thoại" name="phone" value="${phone }" required>
              	<c:if test="${!empty errorPhone }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorPhone }
					</div>
	         	</c:if>
              </div>
              <div class="form-group last mb-4">
                <input type="email" class="form-control" placeholder="Email" name="email" value="${email }" required>
                <c:if test="${!empty errorEmail }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorEmail }
					</div>
	         	</c:if>
              </div>
              <div class="form-group first">
                <input type="password" class="form-control" placeholder="Mật khẩu" name="password" required>
              </div>
              <div class="form-group last mb-4">
                <input type="password" class="form-control" placeholder="Xác nhận mật khẩu" name="passwordAgain" required>
            	<c:if test="${!empty errorPass }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorPass }
					</div>
	         	</c:if>
              </div>
              <div class="d-flex mb-5 align-items-center">
                <span class="ml-auto"><a href="index.jsp" class="forgot-pass">Quay lại</a></span> 
              </div>
              <input type="submit" value="Đăng kí" class="btn text-white btn-block btn-primary" style="background-color: #8e24aa; border-color: white; font-size: 20px; font-weight: 600;">
            </form>
            </div>
          </div>   
        </div>    
      </div>
    </div>
  </div>
</body>
</html>