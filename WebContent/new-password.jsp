<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tạo mật khẩu mới</title>
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="container">
        <h1>Tạo mật khẩu mới</h1>
	         	<c:if test="${!empty error }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${error }
					</div>
	         	</c:if>
         	<form id="login" action="${pageContext.request.contextPath}/NewPassword" method="post">
                <input type="password" class="input-field" placeholder="Mật khẩu mới" name="pass">
                <input type="password" class="input-field" placeholder="Nhập lại mật khẩu" name="passAgain">
                <button type="submit" class="submit-btn">Xác Nhận</button>
         	</form>
    </div>
</body>
</html>