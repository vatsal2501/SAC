<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="../assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Admin | Add New Order</title>

<meta name="description" content="" />

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

<!-- Page CSS -->

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
				<!-- Basic with Icons -->
				<div class="container-xxl flex-grow-1 container-p-y">

					<div class="col-xxl">
						<div class="card mb-4">
							<div
								class="card-header d-flex align-items-center justify-content-between">
								<h5 class="class-header">Add Order</h5>
								<hr class="my-0" />
							</div>
							<div class="card-body">
								<f:form action="insertOrder" method="post"
									modelAttribute="orderVO" id="ordervalidate">
									<div class="row">
										<div class="mb-3 col-md-4">
											<label for="clientname" class="form-label">Client
												Name</label><span style="color: red">*</span>
											<f:select path="clientVO.clientId" id="clientname"
												class="form-select" onchange="getItemsByClient()">
												<option selected="selected" disabled="disabled">Select</option>
												<c:forEach items="${clientList}" var="i">
													<f:option value="${i.clientId}">${i.clientName}</f:option>
												</c:forEach>
											</f:select>
										</div>

										<div class="mb-3 col-md-4">
											<label for="clientitems" class="form-label">Client
												Items</label><span style="color: red">*</span>
											<f:select path="clientReqVO.clientreqId" class="form-select" id="clientItems" onchange="getItemsDetailsByClientItem()">

											</f:select>
										</div>

										<div class="mb-3 col-md-4">
											<label for="length" class="form-label">Length</label> <input
												type="text" id="length" class="form-control"  name="length">
										</div>
									</div>
									<div class="row">
										<div class="mb-3 col-md-4">
											<label for="width" class="form-label">Width</label> <input
												type="text" id="width" class="form-control"  name="width">
										</div>


										<div class="mb-3 col-md-4">
											<label for="height" class="form-label">Height</label> <input
												type="text" id="height" class="form-control"  name="height">
										</div>

										<div class="mb-3 col-md-4">
											<label for="orderQuantity" class="form-label">Quantity</label><span
												style="color: red">*</span>
											<f:input cssClass="form-control" id="orderQuantity"
												path="orderQuantity" />
										</div>
									</div>
									<div class="row justify-content-end">
										<div class="mt-2">
											<f:hidden path="orderId" /> 
											<button type="submit" class="btn btn-primary">Save</button>
											<button type="reset" class="btn btn-outline-secondary">Reset</button>
										</div>
									</div>
								</f:form>
							</div>
							<!-- /Account -->
						</div>
					</div>

					<!-- / Content -->
				</div>
				<!-- Footer -->
				<jsp:include page="footer.jsp"></jsp:include>

				<!-- / Footer -->

				<div class="content-backdrop fade"></div>
			</div>
			<!-- Content wrapper -->

			<!-- / Layout page -->
		</div>

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

	<script src="<%=request.getContextPath()%>/adminResources/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->

	<!-- Main JS -->
	<script src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>
	
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/ordervalidation.js"></script>

	<!-- Page JS -->

	<!-- Place this tag in your head or just before your close body tag. -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>
