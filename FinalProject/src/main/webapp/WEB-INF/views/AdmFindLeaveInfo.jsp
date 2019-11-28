<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
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

		<div class="container-fluid mt--7" style="margin-top: 2rem !important">
			<div class="row"></div>

			<!-- 網頁格式程式碼 target="nm_iframe"-->
			<div class="row justify-content-md-center">
				<div class="col-lg-5 text-center">
				<h1 style="margin-left: 0px; font-family: Microsoft JhengHei; font-weight: 1200;">管理請假資料</h1>
					<form:form method="POST" modelAttribute="AdmSelect"
						style="width: 1000px;">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<div class="input-group input-group-alternative mb-4">
										<form:select id="deptno"
											class="form-control form-control-alternative" name="deptno"
											path="deptno">

											<form:options items="${DepMap}" />
										</form:select>
									</div>
								</div>
							</div>
						</div>


						<div class="row" style="margin-left: 160px">
							<input type="submit" class="btn btn-primary" value="送出" /> <input
								type="reset" class="btn btn-primary" value="清除" />
						</div>
					</form:form>
				</div>
			</div>
			<div>
				<iframe id="id_iframe" name="nm_iframe" style="display: none;"></iframe>
			</div>
		</div>

	</div>

</body>

</html>