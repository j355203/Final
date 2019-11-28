<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
	<!-- Icons -->
	<link href="${pageContext.request.contextPath}/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css"
		rel="stylesheet" />
	<!-- CSS Files -->
	<link href="${pageContext.request.contextPath}/assets/css/argon-dashboard.css?v=1.1.0" rel="stylesheet" />
	<link
	href="${pageContext.request.contextPath}/dist/eeit10919/dist/css/map-icons.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/coliff/bootstrap-rfs/bootstrap-rfs.css">
<style>
/* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
#map {
	width: 100%;
	height: 100%;
}

/* Optional: Makes the sample page fill the window. */
.map-icon-label .map-icon {
	font-size: 12px;
	color: #FFFFFF;
	line-height: 24px;
	text-align: center;
	white-space: nowrap;
}

.btn {
	white-space: normal;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<!-- Brand -->
		<a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block"
			href="${pageContext.request.contextPath}/">首頁</a>
		<!-- User -->
		<ul class="navbar-nav align-items-center d-none d-md-flex">
			<li class="nav-item dropdown"><a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
					<div class="media align-items-center">
						<span class="avatar avatar-sm rounded-circle">
							<!-- User Image -->
							<img alt="Image placeholder"
								src="${pageContext.request.contextPath}/assets/img/theme/team-1-800x800.jpg">
						</span>
						<div class="media-body ml-2 d-none d-lg-block">
							<!-- User Name -->
							<span class="mb-0 text-sm  font-weight-bold">${sessionScope.emp.empname}</span>
						</div>
					</div>
				</a>
				<div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
					<div class=" dropdown-header noti-title">
						<h6 class="text-overflow m-0">歡迎～</h6>
					</div>
					<a href="${pageContext.request.contextPath}/updpwd/${emp.empid}" class="dropdown-item"> <i
							class="ni ni-single-02"></i> <span>我的資料</span>
					</a>
					<div class="dropdown-divider"></div>
					<a href="${pageContext.request.contextPath}/logout" class="dropdown-item"> <i
							class="ni ni-user-run"></i> <span>登出</span>
					</a>
				</div>
			</li>
		</ul>
	</div>
</body>

</html>