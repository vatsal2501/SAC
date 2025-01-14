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

<title>Admin | Add Top Paper</title>

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
				<!-- Basic with Icons -->
				<div class="container-xxl flex-grow-1 container-p-y">

					<div class="col-xxl">
						<div class="card mb-4">
							<h5 class="card-header">Add Top Paper</h5>
							<hr class="my-0" />

							<div class="card-body">

								<f:form action="insertTopPaper" method="post"
									modelAttribute="toppaperVO" id="toppapervalidate">
									<div class="row">
										<div class="mb-3 col-md-4">
											<label for="millName" class="form-label">Mill Name</label><span style="color:red">*</span>
											<f:select path="millVO.millId" class="form-select">
												<c:forEach items="${millList}" var="i">

													<f:option value="${i.millId}">${i.millName}</f:option>

												</c:forEach>
											</f:select>
										</div>
										<div class="mb-3 col-md-4">
											<label for="paperType" class="form-label">Paper Type</label><span style="color:red">*</span>
											<f:select path="paperTypeVO.paperTypeId" class="form-select">
												<c:forEach items="${paperTypeList}" var="i">
													<f:option value="${i.paperTypeId}">${i.paperType}</f:option>
												</c:forEach>
											</f:select>
										</div>


										<div class="mb-3 col-md-4">
											<label for="topPaperBundleNumber" class="form-label">Top
												Paper Bundle Number</label><span style="color:red">*</span>
											<f:input cssClass="form-control" id="topPaperBundleNumber"
												path="topPaperBundleNumber" />
										</div>
									</div>
									<div class="row">
										
										<div class="mb-3 col-md-2">
											<label for="topPaperPiecesOld" class="form-label">Pieces</label><span style="color:red">*</span>
											<f:input cssClass="form-control" id="pieces" path="topPaperPiecesOld" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="topPaperPieces" class="form-label">Actual
												Pieces</label>
											<f:input cssClass="form-control" id="topPaperPieces"
												path="topPaperPieces" />
										</div>


										<div class="mb-3 col-md-2">
											<label for="topPaperGSMOld" class="form-label">GSM</label><span style="color:red">*</span>
											<f:input cssClass="form-control" id="topPaperGSMOld" path="topPaperGSMOld" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="topPaperGSM" class="form-label"> Actual GSM</label>
											<f:input cssClass="form-control" id="topPaperGSM"
												path="topPaperGSM" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="topPaperBFOld" class="form-label">BF</label><span style="color:red">*</span>
											<f:input cssClass="form-control" id="topPaperBFOld" path="topPaperBFOld" />
										</div>


										<div class="mb-3 col-md-2">
											<label for="actualbf" class="form-label">Actual BF</label>
											<f:input cssClass="form-control" id="actualBF"
												path="topPaperBF" />
										</div>
										<div class="row">
											<div class="mb-3 col-md-2">
												<label for="topPaperDecalOld" class="form-label">Decal</label><span style="color:red">*</span>
												<f:input cssClass="form-control" path="topPaperDecalOld" id="topPaperDecalOld" />
											</div>
											<div class="mb-3 col-md-2">
												<label for="actualdecal" class="form-label">Actual
													Decal</label>
												<f:input cssClass="form-control" id="actualDecal"
													path="topPaperDecal" />
											</div>
											<div class="mb-3 col-md-8">
												<label for="remarks" class="form-label"> Remarks</label>
												<f:input path="topPaperRemark" cssClass="form-control" id="remarks" />
											</div>
										</div>
										<f:hidden path="topPaperId" />
										<div class="mt-2">
											<button type="submit" class="btn btn-primary me-2">Save</button>
											<button type="reset" class="btn btn-outline-secondary">Reset</button>
										</div>
								</f:form>
							</div>
						</div>
						</div>
						<div class="card">
							<h5 class="card-header">Top Paper Detail</h5>
							<hr class="my-0"/>
							<div class=" text-nowrap m-3">
								<table id="example"
									class="table table-hover dt-responsive nowrap">
									<thead>
										<tr>
											<th></th>
											<th><input type="checkbox" onclick="checkAll(this)" /></th>
											<th>Id</th>
											<th>Action</th>
											<th>Paper Type</th>
											<th>Decal</th>
											<th>Actual Decal</th>
											<th>GSM</th>
											<th>Actual GSM</th>
											<th>BF</th>
											<th>Actual BF</th>
											<th>Actual Pieces</th>
											<th>Pieces</th>
											<th>Top Paper Bundle Number</th>
											<th>Mill Name</th>
											<th>Remarks</th>
										</tr>
									</thead>
									<tbody class="table-border-bottom-0">
										<c:forEach items="${toppaperList}" var="i" varStatus="j">
											<tr>
												<td></td>
												<td><input type="checkbox" name=""></td>
												<td>${j.count}</td>
												
												<td>${i.paperTypeVO.paperType}</td>
												<td>${i.topPaperDecal}</td>
												<td>${i.topPaperDecalOld}</td>
												<td>${i.topPaperGSMOld}</td>
												<td>${i.topPaperGSM}</td>
												<td>${i.topPaperBFOld}</td>
												<td>${i.topPaperBF}</td>
												<td>${i.topPaperPieces}</td>
												<td>${i.topPaperPiecesOld}</td>
												<td>${i.topPaperBundleNumber}</td>
												<td>${i.millVO.millName}</td>
												<td>${i.topPaperRemark}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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

	<!-- Overlay -->
	<div class="layout-overlay layout-menu-toggle"></div>

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
	<script src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/toppapervalidate.js"></script>
	
</body>
</html>
