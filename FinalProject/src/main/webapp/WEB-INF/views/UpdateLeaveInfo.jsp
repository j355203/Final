<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>修改假單</title>
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
		<div class="header bg-gradient-info pb-3 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div>

			<h3>&nbsp</h3>
		</div>
		<div>
			<h3>&nbsp</h3>
		</div>

		<div class="container-fluid mt--7">
			<div class="row"></div>

			<!-- 網頁格式程式碼 target="nm_iframe"-->
			<div class="row justify-content-md-center">
				<div class="col-lg-6 text-center">
					<div class="card">
						<h2>修改假單表格</h2>
						<form:form method="post" modelAttribute="updateLeave"
							style="margin:0 auto">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<form:input type="text"
											class="form-control form-control-alternative" id="empid"
											path="empid" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<form:input type="text"
												class="form-control form-control-alternative" id="ename"
												path="ename" />
										</div>
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<fmt:parseDate value="${lb.dayoffstart}" var="date1"
												pattern="yyyy-MM-dd HH:mm:ss" />
											<form:input type="date"
												class="form-control form-control-alternative"
												id="dayoffstart" path="dayoffstart" value="${date1}" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<form:input type="date"
												class="form-control form-control-alternative" id="dayoffend"
												path="dayoffend" />
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<form:select class="form-control form-control-alternative"
												path="leavestyle">
												<form:option value="-1" label="假別" />
												<form:options items="${LeaveMap1}" />
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<form:input type="text"
												class="form-control form-control-alternative" id="deptno"
												path="deptno" />
										</div>
									</div>
								</div>
							</div>

							<div id=button1 class="text-center">
								<input type="submit" class="btn btn-primary" value="修改">
								<input type="reset" class="btn btn-primary" value="清除" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>