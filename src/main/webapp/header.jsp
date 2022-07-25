<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<div class="py-1 bg-primary">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon"><i class="fa fa-phone-square" aria-hidden="true"></i></span></div>
						    <span class="text">079 254 5710</span>
					    </div>
					    <div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon"><i class="fa fa-envelope-o" aria-hidden="true"></i></span></div>
						    <span class="text">trinh0792545710@gmail.com</span>
					    </div>
					    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						    <span class="text">3-5 Business days delivery &amp; Free Returns</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="HomeServlet">Vegefoods</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="HomeServlet" class="nav-link">Home</a></li>
	          <li class="nav-item dropdown">
	              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
	         	  <div class="dropdown-menu" aria-labelledby="dropdown04">
		              <c:forEach items="${categoryList}" var="category">
		               	<a class="dropdown-item" href="ShopServlet">${category.name}</a>
		              </c:forEach>   
	              </div>
            </li>
	          <li class="nav-item"><a class="nav-link" href="AboutServlet">About</a></li>
	          <li class="nav-item"><a class="nav-link" href="BlogServlet">Blog</a></li>
	          <li class="nav-item"><a class="nav-link" href="ContactServlet">Contact</a></li>
	          
			  <div class="search " style="margin-right:40px; margin-top: 10px; border-radius:20px">
                  <form action="SearchServlet" method="GET" class="header-search">
                      <input type="hidden" name="contlioller" value="homeController">
                      <input type="hidden" name="page" value="search">
                      <input name="q" type="search-box" size="20" placeholder="Search...">
                  </form>                     
              </div>
              <li class="nav-item cta cta-colored"><a href="CartServlet" class="nav-link"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i>[0]</a></li>
              <%             
              if (session.getAttribute("logged") != null) {
            	  boolean checkLogin = (boolean)session.getAttribute("logged");
            	  if (checkLogin == true) {
              %>
              <li class="nav-item"><a class="nav-link" href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true"></i></a></li>
           		<% } %>
			  <% } else { %>
			    <li class="nav-item"><a class="nav-link" href="LoginServlet"><i class="fa fa-user" aria-hidden="true"></i></a></li>
			  <% } %>			 
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->