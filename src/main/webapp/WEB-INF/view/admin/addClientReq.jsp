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

<title>Admin | Add Client Requirements</title>

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
				<!-- Basic with Icons -->
				<div class="container-xxl flex-grow-1 container-p-y">

					<div class="col-xxl">
						<div class="card mb-4">
							<h5 class="card-header">Client Requirements</h5>
							<hr class="my-0" />
							<div class="card-body">
								<f:form action="insertClientReq" method="post"
									modelAttribute="clientreqVO" id="clientreqvalidate">
									<div class="row">
										<div class="mb-3 col-md-6">
											<label for="clientName" class="form-label">Client
												Name</label><span style="color: red">*</span>
											<f:select path="clientVO.clientId" class="form-select">
												<c:forEach items="${clientList}" var="i">
													<f:option value="${i.clientId}">${i.clientName}</f:option>

												</c:forEach>
											</f:select>
										</div>
										<div class="mb-3 col-md-6">
											<label for="clientItems" class="form-label"> Client
												Items</label><span style="color: red">*</span>
											<f:input cssClass="form-control" id="clientItems"
												path="clientItems" />
										</div>


									</div>
									<div class="row">
										<div class="mb-3 col-md-4">
											<label for="length" class="form-label"> Length</label><span
												style="color: red">*</span>
											<f:input cssClass="form-control" type="text" id="length"
												path="length" />
										</div>

										<div class="mb-3 col-md-4">
											<label for="width" class=",form-label"> Width</label><span
												style="color: red">*</span>
											<f:input cssClass="form-control" type="text" id="width"
												path="width" />
										</div>
										<div class="mb-3 col-md-4">
											<label for="height" class="form-label"> Height</label><span
												style="color: red">*</span>
											<f:input cssClass="form-control" type="text" id="height"
												path="height" />
										</div>
									</div>

									<div class="row">
										<div class="mb-3 col-md-4">
											<label for="toppaper" class="form-label"> Top Paper<span
												style="color: red">*</span></label>
											<f:select path="papertypeVO.paperTypeId" class="form-select">
												<c:forEach items="${papertypeList}" var="i">
													<f:option value="${i.paperTypeId}">${i.paperType}</f:option>

												</c:forEach>
											</f:select>
										</div>
										<div class="mb-3 col-md-4">
											<label for="printing1" class="form-label">Printing</label><span
												style="color: red">*</span>
											<f:select path="printing" class="form-select">

												<f:option value="no">No</f:option>
												<f:option value="flexo">Flexo</f:option>
												<f:option value="offset">Offset</f:option>
											</f:select>
										</div>
									


									<c:if test="${plyDetailsVOList ne null}">
										<div class="mb-3 col-md-4">
											<label for="ply" class="form-label">PLY</label><span
												style="color: red">*</span>
											<f:select path="ply" class="form-select" 
												id="plySelect">
												<f:option value="">Select Ply</f:option>
												<f:option value="3">3</f:option>
												<f:option value="5">5</f:option>
												<f:option value="7">7</f:option>
												<f:option value="9">9</f:option>
											</f:select>
										</div>
									
										<div class="row">
											<table id="plyDetailsTable"
												style="border-bottom-style: solid; border: 1px;"
												class="table table-hover">
	
												<c:forEach items="${plyDetailsVOList}" var="i" varStatus="j">
													<tr>
														<td><input type="text" value="${i.paperGsm}" id="paperGsm[${j.count - 1}]" class="form-control" name="plyDetailsList[${j.count - 1}].paperGsm"></td>
														<td><input type="text" value="${i.paperBf}" id="paperBf[${j.count - 1}]" class="form-control" name="plyDetailsList[${j.count - 1}].paperBf"></td>
														<td><input type="text" value="${i.fluteGsm}" id="fluteGsm[${j.count - 1}]" class="form-control" name="plyDetailsList[${j.count - 1}].fluteGsm"></td>
														<td><input type="text" value="${i.fluteBf}" id="fluteBf[${j.count - 1}]" class="form-control" name="plyDetailsList[${j.count - 1}].fluteBf"></td>
														<td><button type="button" onclick="clearfun(${j.count - 1})" class="btn btn-outline-secondary">Reset</button></td>
														<input type="hidden" name="plyDetailsList[${j.count - 1}].plyDetailsId"value="${i.plyDetailsId}">
													</tr>
												</c:forEach>
	
											</table>
										</div>
										
									</c:if>
									
									<c:if test="${plyDetailsVOList eq null}">
									
									<div class="mb-3 col-md-4">
										<label for="ply" class="form-label">PLY</label><span
												style="color: red">*</span>
										<f:select path="ply" class="form-select" onchange="addfunc()"
												id="plySelect">
												<f:option value="">Select Ply</f:option>
												<f:option value="3">3</f:option>
												<f:option value="5">5</f:option>
												<f:option value="7">7</f:option>
												<f:option value="9">9</f:option>
											</f:select>
										</div>
										
										<div class="row">
											<table id="plyDetailsTable"
												style="border-bottom-style: solid; border: 1px; display: none;"
												class="table table-hover">
											</table>
										</div>
										
									</c:if>
									</div>
									
									<f:hidden path="clientreqId" />
									<div class="mt-2">
										<button type="submit" class="btn btn-primary me-2">Save</button>
										<button type="reset" class="btn btn-outline-secondary">Reset</button>
									</div>
								</f:form>
							</div>
							<!-- /Account -->
						</div>

						<!-- / Content -->
					</div>
				</div>
				<!-- Footer -->
				<jsp:include page="footer.jsp"></jsp:include>

				<!-- / Footer -->
			</div>
			<div class="content-backdrop fade"></div>
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

	<!-- Page JS -->
	
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/clientreqvalidation.js"></script>
	<!-- Place this tag in your head or just before your close body tag. -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>
