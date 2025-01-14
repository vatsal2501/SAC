<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="../assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Admin | View Orders</title>

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


<!-- Vendors CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.css" />

<!-- Page CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap5.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap5.min.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/customiser.css" />

<!-- Core CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/demo.css" />

<!-- Helpers -->
<script src="<%=request.getContextPath()%>/adminResources/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="<%=request.getContextPath()%>/adminResources/js/config.js"></script>
</head>

<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- Menu -->
			<jsp:include page="menu.jsp"></jsp:include>
			<!-- / Menu -->

			<!-- Layout container -->
			<div class="layout-page">
				<!-- Navbar -->

				<jsp:include page="header.jsp"></jsp:include>
				<!-- / Navbar -->

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<!-- Content -->

					<div class="container-xxl flex-grow-1 container-p-y">

						<div class="card">
							<h5 class="card-header">View Orders</h5>
							<hr class="my-0" />
							<div class=" text-nowrap m-3">
								<table id="example"
									class="table table-hover dt-responsive nowrap">
									<thead>
										<tr>
											<th></th>
											<th><input type="checkbox" onclick="checkAll(this)" /></th>
											<th>Id</th>
											<th>Client Name</th>
											<th>Client Items</th>
											<th>Length</th>
											<th>Width</th>
											<th>Breath</th>
											<th>Quantity</th>
											<th id="status">Status</th>
											<th>Start</th>
											<th>Action</th>
										</tr>
									</thead>
									<c:forEach items="${orderList}" var="i" varStatus="j">
										<tbody class="table-border-bottom-0">
											<tr>
												<td></td>
												<td><input type="checkbox" name=""></td>
												<td>${j.count}</td>
												<td>${i.clientVO.clientName}</td>
												<td>${i.clientReqVO.clientItems}</td>
												<td>${i.clientReqVO.length}</td>
												<td>${i.clientReqVO.width}</td>
												<td>${i.clientReqVO.height}</td>
												<td>${i.orderQuantity}</td>
												<td>${i.processStatus}</td>
												<td><div class="d-flex align-items-center">
															<a onclick="status"
															data-toggle="tooltip" data-placement="top"
															title="Start" data-original-title="Edit"
															href="startOrder?id=${i.orderId}"><button type="button"
																class="btn btn-sm btn-outline-success">
																<span class="tf-icons bx bx-check"></span>&nbsp; Start
															</button></a> </div></td>
												<td>
													<div class="d-flex align-items-center">
														<a data-toggle="tooltip" data-placement="top"
															title="Edit Order" data-original-title="Edit"
															href="editOrder?id=${i.orderId}"><i
															class="bx bx-edit"></i></a> 
													</div>
												</td>
											</tr>
									</c:forEach>


									</tbody>
								</table>
							</div>
						</div>
					</div>

					<!-- / Content -->
				</div>
				<!-- Footer -->
				<jsp:include page="footer.jsp"></jsp:include>
				<!-- / Footer -->
			</div>

			<!-- Content wrapper -->
		</div>
		<!-- / Layout page -->


		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>


	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->

	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/popper.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.js"></script>
	<%-- 
		<script
			src="<%=request.getContextPath()%>/adminResources/js/table-treeview.js"></script>

		<script async
			src="<%=request.getContextPath()%>/adminResources/js/chart-custom.js"></script>
 --%>
	<script src="<%=request.getContextPath()%>/adminResources/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->

	<!-- Main JS -->
	<script src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>

	<!-- Page JS -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/customizer.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.bootstrap5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/responsive.bootstrap5.min.js"></script>
	<!-- Place this tag in your head or just before your close body tag. -->

	
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>
