<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Printd T-Shirt - RedStore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	

	$(function() {
		$('#submitButton2').click(
				function(e) {

					//Prevent default submission of form
					e.preventDefault();

					//Remove previous errors
					$('input').next('span').remove();

					$.post({
						url : 'account-registered',
						data : $('#RegForm').serialize(),
						success : function(res) {
							if (res.validated) {
								
								alert("Registration Successful");
								window.location.href = "/webbangiay/index"
							} else {
								$.each(res.errorMessages, function(key, value) {
									$('input[name=' + key + ']').after(
											'<span style="color:#FF0000" class="error">'
													+ value + '</span>');
								});
							}
						}
					})
				});

	});
</script>
<style>
.form-container {
	height: 550px;
}

.error {
	font-size: 60%;
	font-color: red;
}
</style>
</head>

<body>
	<div class="container">
		<div class="navbar">
			<div class="logo">
				<a href="index.html"><img
					src="<c:url value="/resources/images/logo.png" />" width="125px"></a>
			</div>
			<nav>
				<ul id="MenuItems">
					<li><a href="/webbangiay/index">Home</a></li>
					<li><a href="/webbangiay/product">Products</a></li>
					<li><a href="">About</a></li>
					<li><a href="">Contact</a></li>
					<li><a href="/webbangiay/account-login">Account</a></li>
				</ul>
			</nav>
			<a href="cart.html"><img
				src="<c:url value="/resources/images/cart.png" />" width="30px"
				height="30px"></a> <img
				src="<c:url value="/resources/images/menu.png" />" class="menu-icon"
				onclick="menutoggle()">
		</div>
	</div>
	<!-- ------------Account-page------------------- -->
	<div class="account-page">
		<div class="container">
			<div class="row">
				<div class="col-2">
					<img src="<c:url value="/resources/images/image1.png" />"
						width="100%">
				</div>

				<div class="col-2">
					<div class="form-container">
						<div class="form-btn">
							<span onclick="login()">Login</span> <span onclick="register()">Register</span>
							<hr id="Indicator">
						</div>

				 <form:form id="LoginForm" method="POST"
							action="/webbangiay/account-logined" modelAttribute="loginModel">
							<form:input type="email" placeholder="Email" path="email" />
							<form:input type="password" placeholder="Password"
								path="password" />
							<button type="submit" class="btn">Login</button>
							<a href="">Forgot password</a>
						</form:form>
					


						



						<!--  		<form:form id="RegForm" method="POST"
							action="/webbangiay/account-registered" modelAttribute="account">
							<form:input type="email" placeholder="Email" path="email" />
							<form:input type="text" placeholder="Name" path="name" />
							<form:input type="password" placeholder="Password"
								path="password" />
							<form:input type="text" placeholder="Phone" path="phone" />
							<form:input type="text" placeholder="Address" path="address" />
							<button type="submit" class="btn">Register</button>
						</form:form>
				-->
						<form id="RegForm" action="/account-registered">
							<input type="email" placeholder="Email" name="email" /> <input
								type="text" placeholder="Name" name="name" /> <input
								type="password" placeholder="Password" name="password" /> <input
								type="text" placeholder="Phone" name="phone" /> <input
								type="text" placeholder="Address" name="address" />
							<button id="submitButton2" type="submit" class="btn">Register</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ------------footer----------- -->

	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="footer-col-1">
					<h3>Download Our App</h3>
					<p>Download App for Android and ios mobile phone</p>
					<div class="app-logo">
						<img src="<c:url value="/resources/images/play-store.png" />"">
						<img src="<c:url value="/resources/images/app-store.png" />"">
					</div>
				</div>
				<div class="footer-col-2">
					<img src="<c:url value="/resources/images/logo-white.png" />"">
					<p>Our Purpose Is To Sustainably Make the Pleasure and Benefits
						of Sports Accessible to the Many</p>
				</div>
				<div class="footer-col-3">
					<h3>Useful Links</h3>
					<ul>
						<li>Coupons</li>
						<li>Blog Post</li>
						<li>Return Policy</li>
						<li>Join Affiliate</li>
					</ul>
				</div>
				<div class="footer-col-4">
					<h3>Follow us</h3>
					<ul>
						<li>Facebook</li>
						<li>Twitter</li>
						<li>Instagram</li>
						<li>Youtube</li>
					</ul>
				</div>
			</div>
			<hr>
			<p class="Copyright">Copyright 2020</p>
		</div>
		<!-- ------------------- js for toggle menu-------------- -->
		<script>
			var MenuItems = document.getElementById("MenuItems");

			MenuItems.style.maxHeight = "0px";

			function menutoggle() {
				if (MenuItems.style.maxHeight == "0px") {
					MenuItems.style.maxHeight = "200px";
				} else {
					MenuItems.style.maxHeight = "0px";
				}
			}
		</script>
		<!-- ------------------- js for Account form-------------- -->

		<script>
			var LoginForm = document.getElementById("LoginForm");
			var RegForm = document.getElementById("RegForm");
			var Indicator = document.getElementById("Indicator");

			function register() {
				RegForm.style.transform = "translateX(0px)";
				LoginForm.style.transform = "translateX(0px)";
				Indicator.style.transform = "translateX(100px)";

			}
			function login() {
				RegForm.style.transform = "translateX(300px)";
				LoginForm.style.transform = "translateX(300px)";
				Indicator.style.transform = "translateX(0px)";
			}
		</script>
</body>

</html>