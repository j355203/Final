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
<title>員工報名</title>
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
						<form:form method="post" modelAttribute="RegistrationFormBean">
							<h1 class="text-center">活動報名</h1>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="empid"> 員工ID: </label>
								<form:input id="empid" path="empid" type="text"
									class="form:input-large" value="${emp.empid}" />
								<!-- 									label=傳值到資料庫    value=顯示畫面的值-->
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="empname"> 員工姓名: </label>
								<form:input id="empname" path="empname" type="text"
									class="form:input-large" value="${emp.empname}" />
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="depno"> 部門編號: </label>
								<form:input id="depno" path="depno" type="text"
									class="form:input-large" value="${emp.depBean.depno}" />
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="activityId"> 活動ID: </label>
								<form:input id="activityId" path="activityId" type="text"
									class="form:input-large" value="${activityId}" />
							</div>
							<div class="row justify-content-center">
								<c:choose>
									<c:when test="${regis eq '已報名' }">
										<input type="button" class="btn btn-primary" value="已報名">
									</c:when>
									<c:otherwise>
										<input type="submit" class='btn btn-primary' value="送出">
									</c:otherwise>
								</c:choose>
								
							</div>
						</form:form>

					</div>


				</div>
			</div>

		</div>


		<!--   Core   -->
</body>

</html>