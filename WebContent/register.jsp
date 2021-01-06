<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí</title>
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="container">
        <h1>Đăng kí</h1>
        <form class="form" action="${pageContext.request.contextPath}/UserController?command=register" method="post">
        <c:if test="${!empty login }">
        <script type="text/javascript">
        if(confirm("Đăng ký thành công. Đăng nhập để tiếp tục")){
        	window.location = "signin.jsp";
        }
        </script>
        </c:if>
            <input type="text" placeholder="Tên" name="name" value="${name }" required >
            <c:if test="${!empty errorName }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorName }
					</div>
	         	</c:if>
            <input type="text" placeholder="Địa chỉ" name="address" value="${address }" required>
            
            <input type="tel" placeholder="Số điện thoại" name="phone" value="${phone }" required>
            
            <c:if test="${!empty errorPhone }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorPhone }
					</div>
	         	</c:if>
            <input type="email" placeholder="Email" name="email" value="${email }" required>
            <c:if test="${!empty errorEmail }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorEmail }
					</div>
	         	</c:if>
            
            <input type="password" placeholder="Mật khẩu" name="password" required>
            <input type="password" placeholder="Xác nhận mật khẩu" name="passwordAgain" required>
            	<c:if test="${!empty errorPass }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${errorPass }
					</div>
	         	</c:if>
            <button type="submit">Đăng kí</button>
        </form>
    </div>
    
</body>
</html>