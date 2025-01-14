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
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- Menu -->
			<jsp:include page="menu.jsp" />
			<!-- / Menu -->

			<!-- Layout container -->
			<div class="layout-page">

				<!-- Navbar -->
				<jsp:include page="header.jsp" />
				<!-- / Navbar -->

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<div class="container-xxl flex-grow-1 container-p-y">
						<div class="row">
							<div class="col-lg-15 mb-4 order-0">
								<div class="card">
									<div class="d-flex align-items-end row">
										<div class="col-sm-15">
											<div class="card-body">
												<table id="example"
													class="table table-hover dt-responsive nowrap">
													<thead>
														<tr>
															<th></th>
															<th>Id</th>
															<th>Name</th>
															<th>Last Active</th>
															<th>UserName</th>
															<th>Role</th>
															<th>Action</th>
															<th></th>
														</tr>
													</thead>
													<tbody class="table-border-bottom-0">
														<c:forEach items="${userList}" var="i" varStatus="j">
															<tr>
																<td></td>
																<td>${j.count}</td>
																<td>${i.firstName}${i.lastName}</td>
																<td>${i.loginVO.lastActive}</td>
																<td>${i.loginVO.userName}</td>
																<td>${i.loginVO.role}</td>

																<td>
																	<div class="d-flex align-items-center">
																		<a data-toggle="tooltip" data-placement="top"
																			title="Enable" data-original-title="Enable" href="#"><button
																				type="button" class="btn btn-sm btn-outline-success">
																				<span class="tf-icons bx bx-check"></span>&nbsp;
																				Enable
																			</button></a> <a data-toggle="tooltip" data-placement="top"
																			title="Disable" data-original-title="Disable"
																			href="#" style="margin-left: 5px">
																			<button type="button"
																				class="btn btn-sm btn-outline-danger">
																				<span class="tf-icons bx bx-block"></span>&nbsp;
																				Disable
																			</button>
																		</a>

																	</div>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>

											</div>
										</div>

									</div>
								</div>
							</div>
							<!-- Total Revenue -->
							<div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">
								<div class="card" style="height: 565px">
									<div class="row row-bordered g-0">
										<div class="col-md-8">
											<h5 class="card-header m-0 me-2 pb-3">Reel Detail</h5>
											<table id="example"
												class="table table-hover dt-responsive nowrap">
												<thead>
													<tr>
														<th></th>
														<th>Id</th>
														<th>Reel Number</th>
														<th>Paper Type</th>
														<th>Decal</th>
														<th>GSM</th>
														<th>BF</th>
														<th>Weight</th>
														<th>Mill Name</th>
														<th>Reel Number</th>


													</tr>
												</thead>
												<tbody class="table-border-bottom-0">
													<c:forEach items="${reelList}" var="i" varStatus="j">
														<tr>
															<td></td>
															<td>${j.count}</td>
															<td>${i.reelNumber}</td>
															<td>${i.paperTypeVO.paperType}</td>
															<td>${i.reelDecal}</td>
															<td>${i.reelGSM}</td>
															<td>${i.reelBF}</td>
															<td>${i.reelWeight}</td>
															<td>${i.millVO.millName}</td>
															<td>${i.reelNumberOld}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<!--/ Total Revenue -->
							<div class="col-12 col-md-8 col-lg-4 order-3 order-md-2">
								<div class="row">

									<div class="col-12 mb-4">
										<div class="card">
											<div class="card-body">
												<div
													class="card-title d-flex align-items-start justify-content-between">
													<div>
														<span class="fw-semibold d-block mb-1">Reel stock
															in percentage</span>
													</div>
													<div class="dropdown">
														<button class="btn p-0" type="button" id="cardOpt1"
															data-bs-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="bx bx-dots-vertical-rounded"></i>
														</button>
														<div class="dropdown-menu" aria-labelledby="cardOpt1">
															<a class="dropdown-item" href="javascript:void(0);">View
																More</a> <a class="dropdown-item" href="javascript:void(0);">Delete</a>
														</div>
													</div>
												</div>
												<small>Year <script>
													document.write(new Date()
															.getFullYear());
												</script></small>
												<h3 class="card-title mb-2">${weightPr}%</h3>
												<small class="text-success fw-semibold"><i
													class="bx bx-up-arrow-alt"></i> +28.14%</small>
											</div>
										</div>
									</div>
									<div class="col-12 mb-4">
										<div class="card">
											<div class="card-body">
												<div
													class="card-title d-flex align-items-start justify-content-between">
													<div>
														<span class="fw-semibold d-block mb-1">Reel stock
															in Kilograms</span>
													</div>
													<div class="dropdown">
														<button class="btn p-0" type="button" id="cardOpt1"
															data-bs-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="bx bx-dots-vertical-rounded"></i>
														</button>
														<div class="dropdown-menu" aria-labelledby="cardOpt1">
															<a class="dropdown-item" href="addReel">Add More</a> <a
																class="dropdown-item" href="viewReel">View More</a>
														</div>
													</div>
												</div>
												<small>Year <script>
													document.write(new Date()
															.getFullYear());
												</script></small>
												<h3 class="card-title mb-2">${weight}kg</h3>
												<small class="text-success fw-semibold"><i
													class="bx bx-up-arrow-alt"></i> +28.14%</small>
											</div>
										</div>
									</div>
									<div class="col-12 mb-4">
										<div class="card">
											<div class="card-body">
												<div
													class="card-title d-flex align-items-start justify-content-between">
													<div>
														<span class="fw-semibold d-block mb-1">Top Paper
															Pieces Stock</span>
													</div>
													<div class="dropdown">
														<button class="btn p-0" type="button" id="cardOpt1"
															data-bs-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false">
															<i class="bx bx-dots-vertical-rounded"></i>
														</button>
														<div class="dropdown-menu" aria-labelledby="cardOpt1">
															<a class="dropdown-item" href="javascript:void(0);">View
																More</a> <a class="dropdown-item" href="javascript:void(0);">Delete</a>
														</div>
													</div>
												</div>
												<small>Year <script>
													document.write(new Date()
															.getFullYear());
												</script></small>

												<h3 class="card-title mb-2">${pieces}</h3>
												<small class="text-success fw-semibold"><i
													class="bx bx-down-arrow-alt"></i> -4%</small>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-15 mb-4 order-0">
								<div class="card">
									<div class="d-flex align-items-end row">
										<div class="col-sm-7">
											<div class="card-body">
												Pending Order Table
												<div class=" text-nowrap m-3">
													<table id="example"
														class="table table-hover dt-responsive nowrap">
														<thead>
															<tr>
																<th></th>
																<th>Id</th>
																<th>Client Name</th>
																<th>Client Items</th>
																<th>Length</th>
																<th>Width</th>
																<th>Breath</th>
																<th>Quantity</th>
																<th id="status">Status</th>
																<th>Process Action</th>
																<th>Action</th>
															</tr>
														</thead>
														<c:forEach items="${orderList}" var="i" varStatus="j">
															<tbody class="table-border-bottom-0">
																<tr>
																	<td></td>
																	<td>${j.count}</td>
																	<td>${i.clientVO.clientName}</td>
																	<td>${i.clientReqVO.clientItems}</td>
																	<td>${i.clientReqVO.length}</td>
																	<td>${i.clientReqVO.width}</td>
																	<td>${i.clientReqVO.height}</td>
																	<td>${i.orderQuantity}</td>
																	<td>${i.processStatus}</td>
																	<td>
																		<div class="d-flex align-items-center">
																			<!-- 	<button type="button"
																class="btn btn-sm btn-outline-success">
																<span class="tf-icons bx bx-check"></span>&nbsp; Start
															</button>		 -->

																		</div>
																		<div class="d-flex align-items-center">
																			<a onclick="status" data-toggle="tooltip"
																				data-placement="top" title="Edit User"
																				data-original-title="Edit"
																				href="startOrder?id=${i.orderId}"><button
																					class="btn btn-outline-primary" id="process-btn"
																					onclick="processClick()">More Detials</button> </a>

																			<!-- <button type="button"
																class="btn btn-sm btn-outline-success">
																<span class="tf-icons bx bx-check"></span>&nbsp; Start
															</button></a> -->
																		</div>

																	</td>
																	<td>
																		<div class="d-flex align-items-center">
																			<a data-toggle="tooltip" data-placement="top"
																				title="Edit Order" data-original-title="Edit"
																				href="editOrder?id=${i.orderId}"><i
																				class="bx bx-edit"></i></a> <a data-toggle="tooltip"
																				data-placement="top" title="Delete Order"
																				data-original-title="Delete"
																				href="deleteOrder?id=${i.orderId}"><i
																				class="bx bx-trash-alt text-danger ms-2"></i></a>
																		</div>
																	</td>
																</tr>
														</c:forEach>


														</tbody>
													</table>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- / Layout wrapper -->
					<jsp:include page="footer.jsp"></jsp:include>
					<!-- Core JS -->
					<!-- build:js assets/vendor/js/core.js -->
					<script
						src="<%=request.getContextPath()%>/adminResources/js/jquery.js"></script>
					<script
						src="<%=request.getContextPath()%>/adminResources/js/popper.js"></script>
					<script
						src="<%=request.getContextPath()%>/adminResources/js/bootstrap.js"></script>


					<script
						src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.js"></script>
					<script
						src="<%=request.getContextPath()%>/adminResources/js/menu.js"></script>
					<!-- endbuild -->

					<!-- Vendors JS -->
					<script
						src="<%=request.getContextPath()%>/adminResources/js/apexcharts.js"></script>

					<!--   Main JS -->
					<script
						src="<%=request.getContextPath()%>/adminResources/js/main.js"></script>

					<!-- Page JS -->
					<script
						src="<%=request.getContextPath()%>/adminResources/js/dashboards-analytics.js"></script>

					<!--  Place this tag in your head or just before your close body tag. -->
					<script
						src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>
