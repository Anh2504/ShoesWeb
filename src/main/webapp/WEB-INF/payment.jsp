<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>RedStore | Ecommerce Website Design</title>
  
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">

 
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

.container2 {
  width : 400px;
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

.container2 * {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}
.fa {
  font-family: FontAwesome;
  
}

* {
  box-sizing: border-box;
}

.row2 {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container2 {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
  margin: 50px;
}

.container2 input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.container2 label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.container2 .btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.container2 .btn:hover {
  background-color: #45a049;
}

.container2 a {
  color: #2196F3;
}

.container2 hr {
  border: 1px solid lightgrey;
}

.container2 span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row2 {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>

</head>
<body>

<div class="header">
		<div class="container">
			<div class="navbar">
				<div class="logo">
					<a href="index.html"><img
						src="<c:url value="/resources/images/logo.png" />" width="125px"></a>
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
					<h1>
						Give Your Workout<br> A New Style!
					</h1>
					<p>
						Success ins't always about greatness. It's about consistency.
						Consistent <br>hard work gains success. Greatness will come.
					</p>
					<a href="" class="btn">Explore Now &#8594;</a>
				</div>
				<div class="col-2">
					<img src="<c:url value="/resources/images/image1.png" />">
				</div>
			</div>
		</div>
	</div>
<!-- payment form -->

<div class="row2">
  <div class="col-75">
    <div class="container2">
      <form:form action="/webbangiay/perform-payment" modelAttribute="paymentForm">
      
        <div class="row2">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <form:input type="text" id="fname" name="firstname" placeholder="John M. Doe" path="userName" />
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <form:input type="text" id="email" name="email" placeholder="john@example.com" path="email" />
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
            <form:input type="text" id="adr" name="address" placeholder="542 W. 15th Street" path="address" />
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <form:input type="text" id="city" name="city" placeholder="New York" path="city" />

            
          </div>

        
          
        </div>
        
        <input type="submit" value="Continue to checkout" class="btn">
      </form:form>
    </div>
  </div>
  
</div>


</body>
</html>
