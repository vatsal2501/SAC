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

<title>Admin | Add Paper Type</title>

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

							<h5 class="card-header">Add Paper Type</h5>
							<hr class="my-0" />
							<div class="card-body">
								<f:form action="insertPaperType" method="post"
									modelAttribute="paperVO" id="papervalidate">
									<div class="  mb-3">
										<label for="millName" class="col-sm-2 col-form-label">Mill
											Name<span style="color:red">*</span></label>
										<f:select path="millVO.millId" class="form-select">
											<c:forEach items="${millList}" var="i">
												<f:option value="${i.millId}">${i.millName}</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class=" mb-3">
										<label class="col-sm-2 col-form-label" for="paperType">Paper
											Type<span style="color:red">*</span></label>
										<div class="col-sm-14">
												<f:input path="paperType" cssClass="form-control" id="paperType" />
										</div>
									</div>
									<div class="row justify-content-end">
										<div class="mt-2">
											<f:hidden path="paperTypeId" />
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

	<!-- Page JS -->

	<!-- Page JS -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/papertypevalidate.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
</body>
</html>