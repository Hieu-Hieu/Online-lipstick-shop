<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nhập mã</title>
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
									Nhập code</strong>
								</h3>
							</div>
							
							<c:if test="${!empty error }">
								<div class="alert alert-danger" role="alert">${error }</div>
							</c:if>
							<c:choose>
								<c:when test="${param.command eq 'newUser'}">
									<c:if test="${!empty login }">
										<script type="text/javascript">
											if (confirm("Đăng ký thành công. Đăng nhập để tiếp tục")) {
												window.location = "signin.jsp";
											}
										</script>
									</c:if>
									<form action="${pageContext.request.contextPath}/CreateAccount?command=check" method="post">
										<div class="form-group first">
											<input type="text" class="form-control"
												placeholder="Nhập mã code" name="enterCode" required>
										</div>
										<input type="submit" value="Tiếp tục"
											class="btn text-white btn-block btn-primary"
											style="background-color: #8e24aa; border-color: white;font-size: 20px; font-weight: 600;"/>
										<c:if test="${!empty sended }">
											<p>Đã gửi lại mã cho bạn</p>
										</c:if>

									</form>
									<div class="d-flex mb-5 align-items-center">
										<span class="ml-auto">
										<a href="${pageContext.request.contextPath}/CreateAccount?command=again" style="padding-right: 150px;">Gửi lại</a></span>
									</div>
								</c:when>
								<c:otherwise>
									<form id="login" action="${pageContext.request.contextPath}/ForgotPassword?command=check" method="post">
										<div class="form-group first">
											<input type="text" class="form-control"
												placeholder="Nhập mã code" name="codeNumber" required>
										</div>
										<input type="submit" value="Tiếp tục"
											class="btn text-white btn-block btn-primary"
											style="background-color: #8e24aa; border-color: white; font-size: 20px; font-weight: 600;">
									</form>
									<div class="d-flex mb-5 align-items-center">
										<span class="ml-auto"><a href ="${pageContext.request.contextPath}/ForgotPassword?command=again 
										" style="padding-right: 150px;" onclick="onsubmit">Gửi lại</a></span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		function onsubmit() {
			alert("Chúng tôi đã gửi mã xác nhận cho bạn");
		}
	</script>
</body>
</html>