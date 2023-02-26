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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container">
        <div class="navbar">
            <div class="logo">
                <a href="index.html"><img src="<c:url value="/resources/images/logo.png" />" width="125px"></a>
            </div>
            <nav>
					<ul id="MenuItems">
						
						<li><a href="/webbangiay/index">Home</a></li>
						
						<li>
							<a href="/webbangiay/index">Giày nam</a>
								<ul class="sub-ul">
							        <c:forEach items="${categoryList }" var="stt">
							        	<li class="sub-li"><a href="/webbangiay/product/nam/${stt.getId() }">${stt.getName()}</a></li>
							        </c:forEach>
						      	</ul>
						</li>
						
						<li>
							<a href="/webbangiay/index">Giày nữ</a>
								<ul class="sub-ul">
							        <c:forEach items="${categoryList }" var="stt">
							        	<li class="sub-li"><a href="/webbangiay/product/nu/${stt.getId() }">${stt.getName()}</a></li>
							        </c:forEach>
						      	</ul>
						</li>
						
						
						<li><a href="/webbangiay/product">Products</a></li>
						<li><a href="/webbangiay/admin">Admin</a></li>
						<c:choose>
							<c:when test="${sessionScope.loginStatus==true }">
								<li><a href="#">${username}</a></li>
								<li><a href="/webbangiay/logout">Log out</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="/webbangiay/login">Login/Register</a></li>
							</c:otherwise>
						</c:choose>

						<li class="shopping-cart">
							<a class="shopping-cart" href="/webbangiay/cart">
								<img src="<c:url value="/resources/images/cart.png" />" width="30px"height="30px">
							</a>
						</li>
						
					</ul>
				</nav>
				
				
				 <img
					src="<c:url value="/resources/images/menu.png" />"
					class="menu-icon" onclick="menutoggle()">
            
        </div>
    </div>
    </div>

    <!-- ---------- single Products detail ----------- -->

    <div class="small-container single-product">
        <div class="row">
            <div class="col-2">
                <img src="<c:url value="/resources/images/${productImage.getImage1() }" />" width="100%" id="productImg">
                
                <div class="small-img-row">
                    <div class="small-img-rol">
                        <img src="<c:url value="/resources/images/${productImage.getImage2() }" />" width="100%" class="small-img">
                    </div>
                    <div class="small-img-rol">
                        <img src="<c:url value="/resources/images/${productImage.getImage3() }" />" width="100%" class="small-img">
                    </div>
                    <div class="small-img-rol">
                        <img src="<c:url value="/resources/images/${productImage.getImage4() }" />" width="100%" class="small-img">
                    </div>
                    <div class="small-img-rol">
                        <img src="<c:url value="/resources/images/${productImage.getImage5() }" />" width="100%" class="small-img">
                    </div>
                </div>

            </div>
            <div class="col-2">
                <p>Home / T-Shirt</p>
                <h1>Red Printd T-Shirt by Huy</h1>
                <h4>$50.00</h4>
                <select>
                    <option>Select Size</option>
                    <option>XXL</option>
                    <option>XL</option>
                    <option>Large</option>
                    <option>Medium</option>
                    <option>Small</option>
                    </section>
                    <input type="number" value="1">
                    <a href="/webbangiay/addtocart/${product.getId() }" class="btn">Add To Card</a>
                    <h3>Product Detail
                        <i class="fa fa-indent"></i>
                    </h3>
                    <br>
                    <p>${product.getContent() }</p>
            </div>
        </div>
    </div>

    <!-- ----- title------------- -->
    <div class="small-container">
        <div class="row row2">
            <h2>Relate Products</h2>
            <p>View More</p>
        </div>
    </div>

<!-- ---------------Products----------------- -->
    <div class="small-container">

        <div class="row">
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
               <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
               <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-half-o"></i>
                </div>
                <p>$50.00</p>
            </div>
            <div class="col-4">
                <img src="<c:url value="/resources/images/product-5.jpg" />">
                <h4>Red Printed T-Shirt</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>$50.00</p>
            </div>
        </div>
        <div class="page-btn">
            <span>1</span>
            <span>2</span>
            <span>3</span>
            <span>4</span>
            <span>&#8594;</span>
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
                        <img src="<c:url value="/resources/images/play-store.png" />">
                        <img src="<c:url value="/resources/images/app-store.png" />">
                    </div>
                </div>
                <div class="footer-col-2">
                    <img src="<c:url value="/resources/images/logo-white.png" />">
                    <p>Our Purpose Is To Sustainably Make the Pleasure and
                        Benefits of Sports Accessible to the Many</p>
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
                        <li>Youtube </li>
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
                }
                else {
                    MenuItems.style.maxHeight = "0px";
                }
            }

        </script>

<!-- ------------------- JS for  product gallery------------------------         -->
        <script>
            var ProductImg = document.getElementById("productImg");
            var SmallImg = document.getElementsByClassName("small-img");

            SmallImg[0].onclick = function()
            {
                ProductImg.src = SmallImg[0].src;
            }
            SmallImg[1].onclick = function()
            {
                ProductImg.src = SmallImg[1].src;
            }
            SmallImg[2].onclick = function()
            {
                ProductImg.src = SmallImg[2].src;
            }
            SmallImg[3].onclick = function()
            {
                ProductImg.src = SmallImg[3].src;
            }

        </script>
</body>

</html>
