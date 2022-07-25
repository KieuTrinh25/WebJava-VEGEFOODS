<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="admin/css/sb-admin-2.css" rel="stylesheet">
    <script>
        var labels = ['pending', 'finished', 'boom'];
        var data = [<?php echo count($pendingOrders ); ?>, <?php echo count($finishedOrders); ?>, <?php echo count($boomOrders); ?>];
    </script>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
         	<%@include file="../inc/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@include file="../inc/topbar.jsp" %>
                <!-- End of Topbar -->
                
 
                    <div class="container-fluid px-4">
                     <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Admin Panel</h1>
                        <a href="CreateProductServlet" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i>Add Product</a>
                    </div>
                       
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"> List Products</li>
                        </ol>
                        <div class="row">
                            <table  id="datatablesSimple" class="table table-bordered" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>STT</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Images</th>
                                        <th>Edit</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="index" value="1"/>
	                                    <c:forEach items="${productList}" var="product">
	                                    <tr>
	                                    	<td>${index}</td>
	                                        <td>${product.name}</td>
											<td>${product.price}</td>
											<td>${product.quantity}</td>
											<td><img src="${product.images}" width="100px"></td>
											
	                                        <td>
	                                            <a href="EditProductServlet?id=${product.id}">Edit</a>
	                                        </td>
	                                        <td>
	                                            <a href="DeleteProductServlet?id=${product.id}">Delete</a>
	                                        </td>
	                                    </tr>                                    
	                                    <c:set var="index" value="${index + 1}"/>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
             
                <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; My Website 2022</span>
                    </div>
                </div>
            </footer>
            </div>
     <!-- Bootstrap core JavaScript-->
    <script src="admin/vendor/jquery/jquery.min.js"></script>
    <script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="admin/js/demo/chart-pie-demo.js"></script>
    <script src="admin/js/demo/chart-bar-demo.js"></script>
    <script src="admin/js/demo/chart-area-demo.js"></script>
</body>
</html>