<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" rel="stylesheet" />
    <link rel="stylesheet" href="./client/static/css/login.css">
</head>
<body>
    <div class="hero">
        <div class="form-box">
            <div class="button-box">
                <div id="btn"></div>
                    <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                    <button type="button" class="toggle-btn" onclick="register()">Register</button>               
            </div>       
            <form id="login" class="input-group">
                <input type="text" class="input-field" placeholder="Username">
                <input type="text" class="input-field" placeholder="Enter Password">
                <input type="checkbox" class="check-box"><span>Remember Password</span>
                <button type="submit" class="submit-btn">Log In</button>
            </form>
            <form id="register" class="input-group">
                <input type="text" class="input-field"  placeholder="Tên" >
                <input type="email" class="input-field" placeholder="Enter Email" >          
                <input type="text" class="input-field"  placeholder="Sđt">
                <input type="text" class="input-field"  placeholder="Enter Password" >
                <input type="text" class="input-field"  placeholder="Enter Password">
                <button type="submit" class="submit-btn">Register</button>
            </form>  
        </div>
    </div>
	<script src="./client/static/js/login.js"></script>
</body>
</html>