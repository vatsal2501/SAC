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

<title>Admin | Add Reel</title>

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

<!-- Page CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" />
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/responsive.bootstrap5.min.css" />
	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/dataTables.bootstrap5.min.css" />
	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/customiser.css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/bootstrap-select.min.css" />
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

<body >
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
							<h5 class="card-header">Add Reel</h5>
							<hr class="my-0" />
							<div class="card-body">

								<f:form action="insertReel" method="post"
									modelAttribute="reelVO" id="reelvalidate">
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
											<label for="reelNumberOld" class="form-label">Reel
												Number</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelNumberOld"
												path="reelNumberOld" />
										</div>
										
									</div>
									<div class="row">
								<%-- 	<div class="mb-3 col-md-2">
											<label for="reelWeightOld" class="form-label">Sum</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelWeightOld"
												path="reelWeightOld" />
										</div> --%>
										<div class="mb-3 col-md-2">
											<label for="reelWeightOld" class="form-label">Weight</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelWeightOld"
												path="reelWeightOld" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="actualweight" class="form-label">Actual
												Weight</label>
											<f:input cssClass="form-control" type="text"
												id="actualWeight" path="reelWeight" />
										</div>

										<div class="mb-3 col-md-2">
											<label for="reelGSMOldgsm" class="form-label">GSM</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelGSMOld"
												path="reelGSMOld" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="actualgsm" class="form-label"> Actual GSM</label>
											<f:input cssClass="form-control" type="text" id="actualGSM"
												path="reelGSM" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="reelBFOld" class="form-label">BF</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelBFOld"
												path="reelBFOld" />
										</div>


										<div class="mb-3 col-md-2">
											<label for="actualbf" class="form-label">Actual BF</label>
											<f:input cssClass="form-control" type="text" id="actualBF"
												path="reelBF" />
										</div>
									</div>
									<div class="row">
										<div class="mb-3 col-md-2">
											<label for="reelDecalOld" class="form-label">Decal</label><span style="color:red">*</span>
											<f:input cssClass="form-control" type="text" id="reelDecalOld"
												path="reelDecalOld" />
										</div>
										<div class="mb-3 col-md-2">
											<label for="actualdecal" class="form-label">Actual
												Decal</label>
											<f:input cssClass="form-control" type="text" id="actualDecal"
												path="reelDecal" />
										</div>

										<div class="mb-3 col-md-8">
											<label for="remarks" class="form-label"> Reamrks</label>
											<f:input cssClass="form-control" type="text" id="remarks"
												path="reelRemark" />
										</div>
										<f:hidden path="reelId"/>
										<div class="mt-2">
											<button type="submit" class="btn btn-primary me-2">Save</button>
											<button type="reset" class="btn btn-outline-secondary">Reset</button>
										</div>
								</f:form>
							</div>
						</div>
						</div>
						<div class="card">
							<h5 class="card-header">Reels</h5>
							<div class="text-nowrap m-3 ">
								<table id="example" class="table table-hover dt-responsive nowrap">
									<thead>
										<tr>
											<th></th>
											<th><input type="checkbox" onclick="checkAll(this)" /></th>
<!-- 											<th>Id</th> -->
											<th>Actual Reel Number</th>
											<th>Paper Type</th>
											<th>Decal</th>
											<th>Actual Decal</th>
											<th>GSM</th>
											<th>Actual GSM</th>
											<th>BF</th>
											<th>Actual BF</th>
											<th>Actual Weight</th>
											<th>Weight</th>
											<th>Reel Number</th>
											<th>Mill Name</th>
											<th>Remarks</th>
										</tr>
									</thead>
									<tbody class="table-border-bottom-0">
									<c:forEach items="${reelList}" var="i" varStatus="j">
											<tr>
												<td></td>
												<td><input type="checkbox" name=""></td>
<%-- 												<td>${j.count}</td> --%>
												<td>${i.reelNumber}</td>
												<td>${i.paperTypeVO.paperType}</td>
												<td>${i.reelDecalOld}</td>
												<td>${i.reelDecal}</td>
												<td>${i.reelGSMOld}</td>
												<td>${i.reelGSM}</td>
												<td>${i.reelBFOld}</td>
												<td>${i.reelBF}</td>
												<td>${i.reelNumberOld}</td>
												<td>${i.reelWeight}</td>
												<td>${i.millVO.millName}</td>
												<td>${i.reelNumberOld}</td>
												<td>${i.reelRemark}</td>


											</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /Account -->
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

	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap.bundle.min.js"></script>
			<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap-select.min.js"></script>
		


	<!-- Place this tag in your head or just before your close body tag. -->
	<script src="<%=request.getContextPath()%>/adminResources/js/buttons.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/reelvalidate.js"></script>
	
	
</body>
</html>
