<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nhập email</title>
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
              <h3>Nhập mail</h3>
              <c:if test="${!empty error }">
       			<div class="alert alert-danger" role="alert">
					 ${error }
				</div>
       		</c:if>
            </div>
            <form action="${pageContext.request.contextPath}/ForgotPassword?command=new" method="post">
              <div class="form-group first">
                <input type="email" class="form-control" placeholder="Nhập địa chỉ email" name="email">
              </div>
              <input type="submit" value="Gửi" class="btn text-white btn-block btn-primary" style="background-color: pink; border-color: white;">
            </form>
            </div>
          </div>   
        </div>    
      </div>
    </div>
  </div>
</body>
</html>