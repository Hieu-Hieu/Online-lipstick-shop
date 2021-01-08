<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhập mã</title>
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="container">
        <h1>Nhập mã</h1>
	         	<c:if test="${!empty error }">
	         		<div class="alert alert-danger" role="alert">
	 					 ${error }
					</div>
	         	</c:if>
	         	<c:choose>
	         		<c:when test="${param.command eq 'newUser'}">
	         		<c:if test="${!empty login }">
				        <script type="text/javascript">
				        if(confirm("Đăng ký thành công. Đăng nhập để tiếp tục")){
				        	window.location = "signin.jsp";
				        }
				        </script>
				        </c:if>
	         			<form id="login" action="${pageContext.request.contextPath}/CreateAccount?command=check" method="post">
			                <input type="text" class="input-field" placeholder="Nhập mã code" name="enterCode" required>
			                <button type="submit" class="submit-btn">Tiếp tục</button>
         				</form>
         				<c:if test="${!empty sended }">
         					<p>Đã gửi lại mã cho bạn</p>
         				</c:if>
         				<a href="${pageContext.request.contextPath}/CreateAccount?command=again">Gửi lại</a>
	         		</c:when>
	         		<c:otherwise>
		         		<form id="login" action="${pageContext.request.contextPath}/ForgotPassword?command=check" method="post">
		               		<input type="text" class="input-field" placeholder="Nhập mã code" name="codeNumber" required>
		                	<button type="submit" class="submit-btn">Tiếp tục</button>
	         			</form>
         				<a href="${pageContext.request.contextPath}/ForgotPassword?command=again">Gửi lại</a>
	         		</c:otherwise>
	         	</c:choose>
         	
    </div>
</body>
</html>