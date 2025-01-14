<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="adminResources/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Sac Industries</title>

<meta name="description" content="" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/adminResources/images/SAC.jpg" />

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

<!-- Icons. Uncomment required icon fonts -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/apex-charts.css" />

<!-- Page CSS -->

<!-- Helpers -->
<script src="<%=request.getContextPath()%>/adminResources/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="<%=request.getContextPath()%>/adminResources/js/config.js"></script>
</head>

<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar layout-without-menu">
		<div class="layout-container">
			<%-- <!-- Menu -->
			<jsp:include page="menu.jsp" />
			<!-- / Menu --> --%>

			<!-- Layout container -->
			<div class="layout-page">

				<!-- Navbar -->
				<jsp:include page="header.jsp" />
				<!-- / Navbar -->
				<div class="container-xxl flex-grow-1 container-p-y">
						<div class="row">
							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Process -1</h5>
										<p class="card-text">#OrderID</p>
										<p class="card-text">Client Name</p>
										<p class="card-text">Client Item</p>
										<p class="card-text">Quantity</p>
										<button type="button" class="btn btn-outline-success">Start Order</button>
									</div>
								</div>
							</div>
						</div>
				</div>
				<!-- Content wrapper -->
				<!-- <div class="content-wrapper"></div> -->
			</div>
		</div>
	</div>

	<!-- / Layout wrapper -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/popper.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap.js"></script>


	<script
		src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/apexcharts.js"></script>

	<!--   Main JS -->
	<script src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>

	<!-- Page JS -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dashboards-analytics.js"></script>

	<!--  Place this tag in your head or just before your close body tag. -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>
