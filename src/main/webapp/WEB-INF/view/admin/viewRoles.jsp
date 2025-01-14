<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="adminResources/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>SAC | Roles</title>

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
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.css" />

<!-- Page CSS -->

<!-- Helpers -->
<script src="<%=request.getContextPath()%>/adminResources/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="<%=request.getContextPath()%>/adminResources/js/config.js"></script>

<style type="text/css">
.cardHeight{
	height: 260px;
}
</style>
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
						<h4 class="fw-bold py-3 mb-4">
							<span class="text-muted fw-light">Roles </span>
						</h4>
						<!-- cards of roles -->
						<div class="row">
							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Admin</h5>
										<p class="card-text">Admin is the head of the
											organization. And he is responsible for managing user, i.e.
											adding, removing user or change user roles. Also, as a head,
											he can track the current running process, clients and raw
											material.</p>
										<p class="card-text">
											<small class="text-muted">Responsible for managing
												user. With all other rights</small>
										</p>
									</div>
								</div>
							</div>


							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">General Manager</h5>
										<p class="card-text">General Manager is responsible for
											managing Raw Materials, i.e. adding or altering Mill,
											Paper-Type, Client and order details. Also, he can track the
											current running process, clients and raw material.</p>
										<p class="card-text">
											<small class="text-muted">responsible for managing
												Mill, Paper-Type, Clients and Order.</small>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Manager</h5>
										<p class="card-text">Manager will manage the raw material
											stock i.e. adding and editing Reels, Paper and other
											material. As well as, manager will initiate the production of
											orders And track the production.</p>
										<p class="card-text">
											<small class="text-muted">Responsible for managing
												productions and tracking process.</small>
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Corrugation_Supervisor-1</h5>
										<p class="card-text">Supervisor-1 will start the phase-1
											of process, which is Corrugation and Cutting, with selecting
											and entering reel details. later on, the number of pieces
											produced in phase-1 will be entered by the supervisor-1 on
											the portal.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 1</small>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Pasting_Supervisor-2</h5>
										<p class="card-text">Once the Supervisor-1 complete the
											process it will be passed to phase-2:pasting and which will
											be managed by the supervisor-2. Later on, at the end of
											process pieces will be calulated and it will be enterd on the
											portal.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 2</small>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Rotery_Supervisor-3</h5>
										<p class="card-text">Once the Supervisor-2 complete the
											process it will be pass to phase-3:Rotery, which will be
											managed by the supervisor-3. Later on, at the end of process
											pieces will be calulated and it will be enterd on the portal.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 3</small>
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">RS4/Punching_Supervisor-4</h5>
										<p class="card-text">Once the Supervisor-3 complete the
											process it will be pass to phase-4:RS4-Stiching, which will
											be managed by the supervisor-4. Later on, at the end of
											process pieces will be calulated and it will be enterd on the
											portal.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 4</small>
										</p>
									</div>
								</div>
							</div>

							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight">
										<h5 class="card-title">Stiching_Supervisor-5</h5>
										<p class="card-text">Once the Supervisor-4 complete the
											process it will be pass to phase-5:Counting & bundling, which
											will be managed by the supervisor-5. Later on, at the end of
											process pieces will be calulated and it will be enterd on the
											portal.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 5</small>
										</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight" >
										<h5 class="card-title">Bundle_Supervisor-6</h5>
										<p class="card-text">Once the Supervisor-5 complete the
											process it will be pass to phase-6:Dispatching, which will be
											handle by the supervisor-6. Later on, at the end of process
											pieces will be calulated and it will be enterd into the form.</p>
										<p class="card-text">
											<small class="text-muted">Entry for Phase 7</small>
										</p>
									</div>
								</div>
							</div>
							<div class="col-sm-6 col-lg-4 mb-4">
								<div class="card">
									<div class="card-body cardHeight" >
										<h5 class="card-title">Dispatch_Supervisor-7</h5>
										<p class="card-text">Once the Supervisor-5 complete the
											process it will be pass to phase-6:Dispatching, which will be
											handle by the supervisor-6. Later on, at the end of process
											pieces will be calulated and it will be enterd into the form.</p>
										<p class="card-text">
											<small class="text-muted">Compelete</small>
										</p>
									</div>
								</div>
							</div>

						</div>
						<!--/ Card layout -->
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
	<script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.js"></script>

	<script src="<%=request.getContextPath()%>/adminResources/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script src="<%=request.getContextPath()%>/adminResources/js/masonry.js"></script>

	<!-- Main JS -->
	<script src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>

	<!-- Page JS -->

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>