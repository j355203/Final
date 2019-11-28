<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>會議室預約</title>

	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<style type="text/css">
		.bg10904 {
	background-image:url(<c:url value="/images/bg.jpg"/>);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: top center;
	}
	</style>
</head>

<body class="bg10904">
	<!-- 載入左側導覽列 -->
	<nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
		<jsp:include page="LeftNav.jsp" />
	</nav>
	<!-- 載入左側導覽列 -->

	<div class="main-content">
		<!-- 載入上方導覽列 -->
		<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
			<jsp:include page="HeadNav.jsp" />
		</nav>
		<!-- 載入上方導覽列 -->
		<!-- Header -->
		<div class="header bg-gradient-info pb-2 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
		<div class="container-fluid mt--7">

			<div class="row justify-content-md-center">
				<div class="col-lg-11">
					<div class="card" style="width: 100%">
						<div id="calendar" class="text-center">
							<iframe 
								src="https://calendar.google.com/calendar/b/1/embed?height=600&amp;wkst=2&amp;
								bgcolor=%23ffffff&amp;ctz=Asia%2FTaipei&amp;
								src=NGFtaWZnaWtodmEyYXE4Nm9zb2ZhcW81azBAZ3JvdXAuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&amp;
								color=%23B1440E&amp;showPrint=0&amp;showTabs=0&amp;showCalendars=0" 
								style="border-width:0" width="800" height="600" frameborder="0" scrolling="no">
							</iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>