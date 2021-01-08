<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nhập email</title>
<link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
	<div class="container">
		<h1>Nhập email để tạo mật khẩu mới</h1>
		<c:if test="${!empty error }">
       		<div class="alert alert-danger" role="alert">
					 ${error }
			</div>
       	</c:if>
		<form action="${pageContext.request.contextPath}/ForgotPassword?command=new" method="post">
			<input type="email" class="input-field" placeholder="Nhập địa chỉ email" name="email">
			<button type="submit" class="submit-btn">Gửi</button>
		</form>
	</div>
</body>
</html>