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
			<div class="row"></div>
			<div class="row justify-content-md-center">
				<div class="col-lg-4">
					<div class="card justify-content-center" style="width: 100%">
						<form:form method="post" modelAttribute="RegistrationFormBean" action="RegistrationFormOne">
							<div class="form-group row justify-content-center">
								<label class='control-label ' for="search"> 搜尋報名表: </label> 
								<form:input path="formId"
									id="search" name="search"  type="text"
									class="form:input-large"  />
							     </div>

							<div class="row justify-content-center">
								<input type="submit" value="送出" > 
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>


		<!--   Core   -->
		
</body>

</html>