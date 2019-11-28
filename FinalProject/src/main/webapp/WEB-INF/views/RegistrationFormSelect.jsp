<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>單筆訂單查詢</title>
<!-- Fonts -->

</head>

<body>
	<!-- 載入左側導覽列 -->
	<nav
		class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white"
		id="sidenav-main">
		<jsp:include page="LeftNav.jsp" />
	</nav>
	<!-- 載入左側導覽列 -->

	<div class="main-content">
		<!-- 載入上方導覽列 -->
		<nav class="navbar navbar-top navbar-expand-md navbar-dark"
			id="navbar-main">
			<jsp:include page="HeadNav.jsp" />
		</nav>
		<!-- 載入上方導覽列 -->
		<!-- End Navbar -->
		<!-- Header -->
		<div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7">
			
			<div class="row justify-content-md-center">
				<div class="col-lg-4">
					<div class="card justify-content-center" style="width: 100%">

						<div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
							<div class="thumbnail" style="width: 320px; height: 340px">
								<div class="caption ">

                                     
                                    <h1 class="text-center">報名表</h1>
									<p class="text-center">報名表ID:${RegistrationForm.formId }</p>
									<p class="text-center">員工ID:${RegistrationForm.empid}</p>
									<p class="text-center">員工姓名:${RegistrationForm.empname }</p>
									<p class="text-center">部門編號:${RegistrationForm.depno }</p>
									<p class="text-center">活動ID:${RegistrationForm.activityId}</p>

								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			<%-- 					</c:forEach> --%>


		</div>


		<!--   Core   -->
</body>

</html>