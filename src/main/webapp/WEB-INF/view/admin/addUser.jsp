<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Admin | Add User</title>

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
				<!-- / Navbar -->

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<!-- Content -->

					<div class="container-xxl flex-grow-1 container-p-y">


						<div class="row">
							<div class="col-md-12">
								<div class="card mb-4">
									<h5 class="card-header">Add User</h5>
									<hr class="my-0" />

									<div class="card-body">
										<f:form action="saveUser" method="post"
											modelAttribute="userVO" id="uservalidate">
											<div class="row">
												<div class="mb-3 col-md-6">
													<label for="firstName" class="form-label">First
														Name <span style="color:red">*</span></label>
													<f:input path="firstName" cssClass="form-control"
														id="firstName" />

												</div>
												<div class="mb-3 col-md-6">
													<label for="lastName" class="form-label">Last Name</label><span style="color:red">*</span>
													<f:input path="lastName" cssClass="form-control" id="lastName" />

												</div>
												<div class="mb-3 col-md-6">
													<label for="userName" class="form-label">User Name</label><span style="color:red">*</span>
													<f:input path="loginVO.userName" cssClass="form-control"
														id="userName" />
												</div>
												<div class="mb-3 col-md-6">
													<label class="form-label" for="phoneNumber">Phone
														Number</label><span style="color:red">*</span>

														<f:input path="mobileNumber" cssClass="form-control"
															id="mobileNumber" />

												</div>
												<div class="mb-3 col-md-6">
													<label for="html5-password-input"
														class="col-md-2 col-form-label">Password<span style="color:red">*</span></label>
													<div class="col-md-">
														<f:input path="loginVO.password" cssClass="form-control"
															id="password" />
													</div>
												</div>
												<div class="mb-3 col-md-6">
													<label for="Roles" class="form-label">Roles</label><span style="color:red">*</span>
													<f:select path="loginVO.role"
														cssClass="selectpicker form-select" data-style="py-0">
														<f:option value="ROLE_ADMIN" disabled="true">Admin</f:option>
														<f:option value="ROLE_GENERAL_MANAGER">General_Manager</f:option>
														<f:option value="ROLE_MANAGER">Manager</f:option>
														<f:option value="ROLE_CORRUGATION_SUPERVISOR">Corrugation_Supervisor</f:option>
														<f:option value="ROLE_PASTING_SUPERVISOR">Pasting_Supervisor</f:option>
														<f:option value="ROLE_ROTERY_SUPERVISOR">Rotery_Supervisor</f:option>
														<f:option value="ROLE_RS4_SUPERVISOR">RS4/Punching_Supervisor</f:option>
														<f:option value="ROLE_STICHING_SUPERVISOR">Stiching_Supervisor</f:option>
														<f:option value="ROLE_BUNDLE_SUPERVISOR">Bundle_Supervisor</f:option>
														<f:option value="ROLE_DISPATCH_SUPERVISOR">Dispatch_Supervisor</f:option>
													</f:select>
												</div>
											</div>
											<f:hidden path="id"/>
											<f:hidden path="loginVO.id"/>
											<div class="mt-2">
												<button type="submit" class="btn btn-primary me-2">Save</button>
												<button type="reset" class="btn btn-outline-secondary">Reset</button>
											</div>
										</f:form>
									</div>
									<!-- /Account -->
								</div>
							</div>
						</div>
					</div>
					<!-- / Content -->

					<!-- Footer -->
					<jsp:include page="footer.jsp"></jsp:include>

					<!-- / Footer -->

					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->

			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>

	<!-- / Layout wrapper -->
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

	<!-- Page JS -->
	<!-- Page JS --><!-- Place this tag in your head or just before your close body tag. -->
  <script src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
  
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/uservalidate.js"></script>
	
</body>
</html>
