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

        <!-- Content Wrapper -->
            <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Admin Panel</h1>
                        <a href="" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i>Add Category</a>
                    </div>

                    <!-- Content Row -->
                    <form method="post">
                      
                        <div class="form-group">
                           <label for="exampleInputStatus1">Name: </label>
                           <input name="name" value="${order.name}" type="text" class="form-control" placeholder="Enter name" disabled="true">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputStatus1">Description:</label>
                           <input name="description" value="${order.description}" type="text" class="form-control" placeholder="Enter description" disabled="true">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputStatus1">Status:</label>
                           <select class="form-control" name="status" id="order">
                           		<option value="pending" ${order.status == "pending" ? 'selected="true"' : '' }>pending</option>
                           		<option value="finished" ${order.status == "finished" ? 'selected="true"' : '' }>finished</option>
                           		<option value="boom" ${order.status == "boom" ? 'selected="true"' : '' }>boom</option>
		                    </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                <footer class="sticky-footer ">
	                <div class="container my-auto">
	                    <div class="copyright text-center my-auto">
	                        <span>Copyright &copy; My Website 2022</span>
	                    </div>
	                </div>
                </footer>
              
                
            </div>     
     <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="LogoutServlet">Logout</a>
                </div>
            </div>
        </div>
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