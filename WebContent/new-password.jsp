<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tạo mật khẩu mới</title>
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
								<h3>Tạo mật khẩu mới</h3>
							</div>
							<c:if test="${!empty error }">
								<div class="alert alert-danger" role="alert">${error }</div>
							</c:if>
							<form id="login"
								action="${pageContext.request.contextPath}/NewPassword"
								method="post">
								<div class="form-group first">
									<input type="password" class="form-control"
										placeholder="Mật khẩu mới" name="pass">
								</div>
								<div class="form-group last mb-4">
									<input type="password" class="form-control"
										placeholder="Nhập lại mật khẩu" name="passAgain">
								</div>
								<input type="submit" value="Xác nhận"
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