<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RedStore | Ecommerce Website Design</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
 
    <div class="header">
        <div class="container">
            <div class="navbar">
                <div class="logo">
                    <a href="index.html"><img src="<c:url value="/resources/images/logo.png" />" width="125px"></a>
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
                <a href="cart.html"><img src="<c:url value="/resources/images/cart.png" />" width="30px" height="30px"></a>
                <img src="<c:url value="/resources/images/menu.png" />" class="menu-icon" 
                onclick="menutoggle()">
            </div>
            <div class="row">
                <div class="col-2">
                    <h1>Give Your Workout<br> A New Style!</h1>
                    <p>Success ins't always about greatness. It's about
                        consistency. Consistent <br>hard work gains success. Greatness
                        will come. </p>
                    <a href="" class="btn">Explore Now &#8594;</a>
                </div>
                <div class="col-2">
                    <img src="<c:url value="/resources/images/image1.png" />">
                </div>
            </div>
        </div>
    </div>

    <!-- ------------- featured categorries ---------------- -->
    <div class="categories">
        <div class="small-container">
            <div class="row">
                <div class="col-3">
                    <img src="<c:url value="/resources/images/category-1.jpg" />">
                </div>
                <div class="col-3">
                    <img src="<c:url value="/resources/images/category-2.jpg" />">
                </div>
                <div class="col-3">
                    <img src="<c:url value="/resources/images/category-3.jpg" />">
                </div>

            </div>
        </div>

    </div>
    <!-- ------------- featured products ---------------- -->
    
    
    <div class="small-container">
        <h2 class="title">Featured Products</h2>
        
        <c:forEach items="${productList }" var="stt">
        <c:if test= "${stt.getId()==1 || ((stt.getId()-1) % 4)==0}">
        	<div class="row">
        </c:if>
        	<div class="col-4">
                <a href="productdetail/${stt.getId() }"><img src="<c:url value="/resources/images/${stt.getImage() }" />"></a>
                <h4>${stt.getName() }</h4>
                <div class="rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star-o"></i>
                </div>
                <p>${stt.getPrice() }₫</p>
            </div>
         <c:if test= "${stt.getId() % 4==0}">
        	</div>
         </c:if>
        	
    	</c:forEach>
        
        
    </div>
    
    
    
    <!-- ------------ offer -------------- -->
    <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2"><img src="<c:url value="/resources/images/exclusive.png" />" class="offer-img"> </div>
                <div class="col-2">
                    <p>Exclusive Availabble on RedStore</p>
                    <h1>Smart Band 4</h1>
                    <small>
                        The Mi Smart Band 4 features a 39.9% larger (than Mi Band 4) AMOLED color full-touch display
                        with
                        adjustable brightness, so everything is clear as can be</small>
                    <a href="" class="btn">Buy Now &#8594;</a>
                </div>
            </div>
        </div>
    </div>
    <!-- ------------ testimonial -------------- -->
    <div class="testimonial">
        <div class="small-container">
            <div class="row">
                <div class="col-3">
                    <i class="fa fa-qoute-lef"></i>
                    <p>Abilities or he perfectly pretended so strangers be exquisite. Oh to another chamber pleased
                        imagine do in. Went me rank at last loud shot an draw. Excellent so to no sincerity smallness.
                        Removal request delight if on he we</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="<c:url value="/resources/images/user-1.png" />">
                    <h3>Äáº¡t 1 PhÃ­ch</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-qoute-lef"></i>
                    <p>Abilities or he perfectly pretended so strangers be exquisite. Oh to another chamber pleased
                        imagine do in. Went me rank at last loud shot an draw. Excellent so to no sincerity smallness.
                        Removal request delight if on he we</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="<c:url value="/resources/images/user-2.png" />"">
                    <h3>An Nguyen</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-qoute-lef"></i>
                    <p>Abilities or he perfectly pretended so strangers be exquisite. Oh to another chamber pleased
                        imagine do in. Went me rank at last loud shot an draw. Excellent so to no sincerity smallness.
                        Removal request delight if on he we</p>
                    <div class="rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                    </div>
                    <img src="<c:url value="/resources/images/user-3.png" />"">
                    <h3>Quang Hoang</h3>
                </div>
            </div>
        </div>
    </div>
    <!-- ------------------- brands --------------------- -->
    <div class="brands">
        <div class="small-container">
            <div class="row">
                <div class="col-5">
                    <img src="<c:url value="/resources/images/logo-godrej.png" />"">
                </div>
                <div class="col-5">
                    <img src="<c:url value="/resources/images/logo-oppo.png" />"">
                </div>
                <div class="col-5">
                    <img src="<c:url value="/resources/images/logo-coca-cola.png" />"">
                </div>
                <div class="col-5">
                    <img src="<c:url value="/resources/images/logo-paypal.png" />"">
                </div>
                <div class="col-5">
                    <img src="<c:url value="/resources/images/logo-philips.png" />"">
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
    </div>
    <!-- ------------------- js for toggle menu-------------- -->
    <script>
        var MenuItems = document.getElementById("MenuItems");
        
        MenuItems.style.maxHeight = "0px";

        function menutoggle(){
            if(MenuItems.style.maxHeight == "0px")
            {
                MenuItems.style.maxHeight = "200px";
            }
        else
            {
                MenuItems.style.maxHeight = "0px";
            }
        }

    </script>
</body>
</html>