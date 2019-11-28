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
	<link href="${pageContext.request.contextPath}/css/eeit10919/test1.css"
	rel="stylesheet" />
<style>
select {
	-webkit-appearance: none;
}

@media ( min-width : 480px) {
	table {
		width: auto;
	}
}

.hiddenRow {
	padding: 0 4px !important;
	background-color: #eeeeee;
	font-size: 13px;
}

.table tr td {
	font-family: 微軟正黑體;
	font-size: 24px;
}

#addbtn:hover span:after {
	content: "新增商品";
}

#bkbtn:hover span:after {
	content: "返回商店列表";
}

.addPageImageArea {
	border: 1px dashed gray;
	/* padding: 5px; */
	width: 200px;
	height: 200px;
	line-height: 200px;
	vertical-align: middle;
}

.addPageImageArea img {
	display: inline-block;
	max-width: 100%;
	max-height: 95%;
	vertical-align: middle;
}

.imgHint {
	margin: 0px;
	width: 100%;
	text-align: center;
	color: gray;
	font-family: 微軟正黑體;
	cursor: pointer;
	display: block;
	cursor: pointer;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

.addPageInfoArea div div img {
	max-height: 100%;
	height: 100%;
}

.msg {
	height: 16px;
	font-family: 微軟正黑體;
	font-weight: bold;
	padding: 1px;
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