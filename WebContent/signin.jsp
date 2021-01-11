<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng nhập</title>
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
								<h3>
									Đăng nhập: <br> <strong>4GuysSellingLipstick</strong>
								</h3>
							</div>
							<c:if test="${!empty error }">
								<div class="alert alert-danger" role="alert">${error }</div>
							</c:if>
							<form id="login"
								action="${pageContext.request.contextPath}/UserController?command=login"
								method="post">
								<div class="form-group first">
									<input type="email" class="form-control" placeholder="Email"
										name="email" required>
								</div>
								<div class="form-group last mb-4">
									<input type="password" class="form-control"
										placeholder="Nhập mật khẩu" name="password" required>
								</div>
								<div class="d-flex mb-5 align-items-center">
									<label class="control control--checkbox mb-0"><spanclass="caption">
										<a href="register.jsp">Đăng kí</a> </span></label> <span class="ml-auto"><a
										href="enter-email.jsp" class="forgot-pass">Quên mật khẩu?</a></span>
								</div>
								<input type="submit" value="Đăng nhập"
									class="btn text-white btn-block btn-primary"
									style="background-color: pink; border-color: white;">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>