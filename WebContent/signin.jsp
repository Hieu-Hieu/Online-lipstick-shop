<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="container">
        <h1>Đăng nhập</h1>
	         	<c:if test="${!empty error }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${error }
					</div>
	         	</c:if>
         	<form id="login" action="${pageContext.request.contextPath}/UserController?command=login" method="post">
                <input type="text" class="input-field" placeholder="Tên đăng nhập" name="username">
                <input type="password" class="input-field" placeholder="Nhập mật khẩu" name="password">
                <button type="submit" class="submit-btn">Đăng nhập</button>
         	</form>
        <a href="register.jsp" class="register">Đăng kí</a>
        <a href="#" class="forget">Quên mật khẩu ?</a>
    </div>
</body>
</html>