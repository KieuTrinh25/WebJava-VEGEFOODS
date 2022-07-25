<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Đăng Ký</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">


</head>
	<style>
		body {
		  background-image: url('http://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-trai-cay-dep-7.jpg');
		  background-repeat: no-repeat;
		  background-attachment: fixed;  
		  background-size: cover;
		}
	</style>
    
<body>
	<a class="login" href="HomeServlet"><img src="./Public/images/contact.png" width="150px"></a>
	 
	<hr>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
        
            <form action="SignupServlet" method="POST">
                <input type="hidden" name="page" value="register">
                <h1>ĐĂNG KÝ</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>Điền các thông tin để đăng ký</span>
                <label for="phone">
                	<input type="text" id="phone" placeholder="Enter phone"  name="phone" >
                </label>
                <label for="password">
	                <input id="password" type="password" placeholder="Password" class="form-control" name="password" value="">
                </label> 
                <label for="password">
	                <input id="passwordConfirm" type="password" placeholder="PasswordConfirm" class="form-control" name="password" value="">
                </label> 
                <button type="submit" class="submit">Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form method="POST" action="LoginServlet">                
                <input type="hidden" name="page" value="login">
                <h1>ĐĂNG NHẬP</h1>
                <div class="social-container">
                    <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <span>Điền thông tin tài khoản để đăng nhập</span>
                <label for="phone">
                <input type="text" id="phone" placeholder="Phone"  name="phone" >
                </label>
                <label for="password">
                <input id="password" type="password" placeholder="Password" class="form-control" name="password" value="">
                <span toggle="#password-field" class="fa fa-lg fa-eye field-icon toggle-password" onclick="myFunction2()"></span>
                </label> 
            <div class="">
            </div>        
            <div class="register login">
                <p> <a href="#" style="color: blue;"> Quên mật khẩu?</a></p>
                <button type="submit" >Sign in</button>
            </div>
            </form>
        </div>    
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Chào Mừng Quý Khách</h1>
                    <p>Đăng Nhập để được hỗ trợ trưc tuyến và biết thêm các thông tin sản phẩm</p>
                    <button class="ghost" id="signIn">ĐĂNG NHẬP</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Xin Chào Quý Khách</h1>
                    <p>Đăng Ký để biết thêm các sản phẩm và hỗ trợ tư vấn các sản phẩm</p>
                    <button class="ghost" id="signUp">ĐĂNG KÝ</button>
                </div>
            </div>
        </div>
    </div>
      <script>
        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click', () => {
            container.classList.add('right-panel-active');
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove('right-panel-active');
        });
        $(".toggle-password").click(function() {
           $(this).toggleClass("fa-eye fa-eye-slash");
           var input = $($(this).attr("toggle"));
           if (input.attr("type") == "password") {
             input.attr("type", "text");
           } else {
             input.attr("type", "password");
           }
        });
        function myFunction2() {
              var x = document.getElementById("password1");
              if (x.type === "password") {
                x.type = "text";
              } else {
                x.type = "password";
              }
            }
    </script>
    
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/9872ede934.js" crossorigin="anonymous"></script>
    
    <script src="js/registration.js"></script>
    <script src="js/login.js"></script>
</body>
</html>