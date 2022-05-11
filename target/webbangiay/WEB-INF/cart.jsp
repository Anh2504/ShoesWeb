<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Printd T-Shirt - RedStore</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <c:choose>
                        	<c:when test="${sessionScope.loginStatus==true }">
                        		<li><a href="#">${username}</a></li>
                        	</c:when>
                        	
                        	<c:otherwise>
                        		<li><a href="/webbangiay/account-login">Dang nhap</a></li>
                        	</c:otherwise>
                        </c:choose>
                        
                        
                    </ul>
			</nav>
			<a href="cart.html"><img
				src="<c:url value="/resources/images/cart.png" />" width="30px"
				height="30px"></a> <img
				src="<c:url value="/resources/images/menu.png" />" class="menu-icon"
				onclick="menutoggle()">
		</div>
	</div>

	<!-- -----------------cart item details------------------- -->
	<div class="small-container cart-page">
		<table>
			<tr>
				<th>Product</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>
			<c:forEach items="${cart.getProductList() }" var="stt">

				<tr>
					<td>
						<div class="cart-info">
							<img src="<c:url value="/resources/images/${stt.getImage() }" />">
							<div>
								<p>${stt.getName() }</p>
								<small>${stt.getPrice() }</small> <br> <a href="">Remove</a>
							</div>
						</div>
					</td>
					<td><input type="number" value="1"></td>
					<td>${stt.getPrice() }</td>
				</tr>
				
			</c:forEach>





		</table>

		


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
</body>

</html>