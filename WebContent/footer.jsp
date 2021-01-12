<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Footer</title>    

<!-- Favicon -->
<link href="./client/static/img/favicon.ico" rel="icon">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

<!-- CSS Libraries -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="./client/static/lib/slick/slick.css" rel="stylesheet">
<link href="./client/static/lib/slick/slick-theme.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="./client/static/css/footer.css" rel="stylesheet">
</head>
<body>
    <!-- Footer Start -->
   <div class="grid wide">
   <hr>
        <div class="row no-gutters">
        	<div class="c-1"></div>
            <div class="c-10">
                <img class="logo" src="./client/static/img/logo1.png" alt="#">
            </div>
        </div>
        <div class="row no-gutters">
        	<div class="c-1"></div>
            <div class="c-5">
                <h2 style="color: #000;"><strong>4guysellingsliptick.com</strong></h2>
                <ul>
                    <li><i class="fas fa-home"></i></i>Address: Đại học SPKT</li>
                    <li><i class="fas fa-phone-alt"></i>Hotline: + 84972220XXX - + 84972220XXX</i></li>
                    <li><i class="fas fa-envelope"></i>Email: 4guysellinglipstick@gmail.com</i></li>
                    <li><i class="fab fa-facebook-messenger"></i><a href="https://www.facebook.com/4guysellinglipstick">Fanpage: 4guysellinglipstick</a></li>
                </ul>
            </div>
            <div class="c-5">
                <h2>ĐỊA CHỈ</h2>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.480424582181!2d106.77006551440977!3d10.85101709227095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752763f23816ab%3A0x282f711441b6916f!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBTxrAgcGjhuqFtIEvhu7kgdGh14bqtdCBUaMOgbmggcGjhu5EgSOG7kyBDaMOtIE1pbmg!5e0!3m2!1svi!2s!4v1608783999514!5m2!1svi!2s" width="100%" height="180" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
            </div>
        
    
    <!-- Load Facebook SDK for JavaScript -->
    <div id="fb-root"></div>
    <script>
      window.fbAsyncInit = function() {
        FB.init({
          xfbml            : true,
          version          : 'v9.0'
        });
      };

      (function(d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) return;
      js = d.createElement(s); js.id = id;
      js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>

    <!-- Your Chat Plugin code -->
    <div class="fb-customerchat"
      attribution=setup_tool
      page_id="103534591567391">
    </div>
</body>
</html>