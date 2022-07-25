<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Vegefoods</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <!-- Own Carousel -->
    <link rel="stylesheet" href="./Public/css/owl.carousel.css">
    <link rel="stylesheet" href="./Public/css/owl.theme.green.css">
     <!-- JQuery & Own Carousel -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="goto-here">
	<%@include file="header.jsp" %>

    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image: url(images/bg_1.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-md-12 ftco-animate text-center">
	              <h1 class="mb-2">Home Cart</h1>
	              <h2 class="subheading mb-4">My Cart</h2>
	               
	            </div>

	          </div>
	        </div>
	      </div>

	      <div class="slider-item" style="background-image: url(images/bg_2.jpg);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-sm-12 ftco-animate text-center">
	              <h1 class="mb-2">Home Cart</h1>
	              <h2 class="subheading mb-4">My Cart</h2>
	            </div>

	          </div>
	        </div>
	      </div>
	    </div>
    </section>
<section class="ftco-section ftco-cart">
			<div class="container">
				<div class="row">
	    			<div class="col-md-12 ftco-animate">
	    				<div class="cart-list">
		    				<table class="table">
							    <thead class="thead-primary">
							      <tr class="text-center">
							        <th class="product-remove">&nbsp;</th>
							        <th class="cart-product-name">Images</th>
							        <th class="cart-product-name">Product name</th>
							        <th class="product-price">Price</th>
							        <th class="quantity">Quantity</th>
							        <th class="product-subtotal">Total</th>
							      </tr>
							    </thead>
							    <tbody>
							      <c:forEach items="${orderDetailSesionList}" var="orderDetail">
	                                  <tr>
	                                      <td class="product-remove">
	                                          <form action="OrderServlet" method="post">
	                                              <input type="hidden" name="action" value="delete">
	                                              <button type="submit"><i class="fa fa-times-circle" aria-hidden="true"></i></button>
	                                              <input type="hidden" name="productId" value="${orderDetail.productId}">
	                                              
	                                          </form>
	                                      </td>
	                                      <td class="cart-product-name"><img src="${orderDetail.images}" width="100px"></td>
	                                      <td class="cart-product-name"><a href="javascript:void(0)">${orderDetail.productName}</a></td>
	                                      <td class="product-price"><span class="amount">${orderDetail.price} $</span></td>
	                                      <td class="quantity">
	                                          <div class="cart-plus-minus">
	                                              <input class="cart-plus-minus-box" value="${orderDetail.quantity}" type="text">
	                                          </div>
	                                      </td>
	                                      <td class="product-subtotal"><span class="amount">${(orderDetail.quantity * orderDetail.price)} $</span></td>
	                                  </tr>
	                              </c:forEach>                               	
							    </tbody>					   
							  </table>
						  </div>
						               
    			</div>
    			
    		</div>	
    		<div class="row justify-content-end">
  						<form action="CheckOutServlet" class="info" method="get">
    			<div class="col-md-7 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Estimate shipping and tax</h3>
    					<p>Enter your destination to get a shipping estimate</p>
				              <div class="form-group">
				              	<label for="">Full Name</label>
				                <input name="full_name" type="text" class="form-control text-left px-3" placeholder="">
				              </div>
				              <div class="form-group">
				              	<label for="country">Address</label>
				                <input  name="address" type="text" class="form-control text-left px-3" placeholder="">
				              </div>
				              <div class="form-group">
				              	<label for="country">Note</label>
				                <input name="note" type="text" class="form-control text-left px-3" placeholder="">
				              </div>
    				</div>
  
    			</div>
    			<div class="col-md-5 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Cart Totals</h3>
    					 <th>${total} $</th>	
    				</div>
             		<p><button type="submit" href="CheckOutServlet"class="btn btn-primary py-3 px-4">Pay</button></p>
    			</div>
	            		</form>
    		</div>
			</div>	
		</div>
</section>

<%@include file="footer.jsp" %>
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
        <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>     -->
   
</body>
</html>