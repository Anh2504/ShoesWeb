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
<style>
	.page-btn{
		margin-left : 160px;
	}
	
</style>
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
        
        <div class="row__">
        <c:forEach items="${productList }" var="stt">
        
  <!--  <c:if test= "${stt.getId()==1 || ((stt.getId()-1) % 4)==0}">
        	<div class="row">
        </c:if>
   -->     
        	<div class="col-4">
                <a href="/webbangiay/productdetail/${stt.getId() }"><img src="<c:url value="/resources/images/${stt.getImage() }" />"></a>
                <h4>${stt.getId() }</h4>
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
  <!--   <c:if test= "${stt.getId() % 4==0}">
        	</div>
         </c:if>
  -->      	
    	</c:forEach>
        </div>
        
    </div>
    
   <!--  
    <div class="page-btn">
    	<c:forEach var="stt" begin = "1" end= "${totalPage}">
    		<a href="/webbangiay/product/${sex}/${id}/${stt}"><span >${stt}</span> </a>
   	 	</c:forEach>
         
    </div>
   -->
   
    
    <! pagination button -->
 	<div class="page-btn">
 		<c:if test="${totalPage > 3 }">
 		
	    	<!-- page button -->
	    	<c:if test="${pageIndex > 1}">
	    		<a href="/webbangiay/product/${sex}/${id}/1"><span ><<</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex - 1}"><span ><</span> </a>
	    	</c:if>
	    	
	    	<!-- first page -->
	    	<c:if test="${pageIndex == 1}">
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex}" ><span style="background-color:#ff523b">${pageIndex}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex + 1}"><span >${pageIndex + 1}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex + 2}"><span >${pageIndex + 2}</span> </a>
	    	</c:if>
	    	
	    	<!-- middle pages -->
	    	<c:if test="${pageIndex > 1 && pageIndex < totalPage}">
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex - 1}"><span >${pageIndex - 1}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex}" ><span style="background-color:#ff523b">${pageIndex}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex + 1}"><span >${pageIndex + 1}</span> </a>
	    	</c:if>
	    	
	    	<!-- last page -->
	    	<c:if test="${pageIndex == totalPage}">
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex - 2}"><span >${pageIndex - 2}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex - 1}"><span >${pageIndex - 1}</span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex}" ><span style="background-color:#ff523b">${pageIndex}</span> </a>
	    	</c:if>
	    	
	    	<!-- page button -->
	    	<c:if test="${pageIndex < totalPage}">
	    		<a href="/webbangiay/product/${sex}/${id}/${pageIndex + 1}"><span >></span> </a>
	    		<a href="/webbangiay/product/${sex}/${id}/${totalPage}"><span >>></span> </a>
	    	</c:if>
	    </c:if>
	    <c:if test="${totalPage <= 3 }">
	    	<c:forEach var = "i" begin = "1" end = "${totalPage }">
	    		<a href="/webbangiay/product/${sex}/${id}/${i}"><span >${i}</span> </a>
	    	</c:forEach>
	    </c:if>
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