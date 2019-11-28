<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>員工資料</title>

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
		<div class="container-fluid mt--7" >

			<div class="row justify-content-md-center">
				<div class="col-lg-12">
					<div class="card" style="width: 100%">
						<h2 class="text-center">所有員工資料</h2>


						<table border="1" class="table-hover text-center">
							<tr>
								<th>員工工號
								<th>員工姓名
								<th>員工性別
								<th>員工生日
								<th>部門編號
								<th>員工職稱
								<th>員工權限
								<th>員工電話
								<th>居住地址
								<th>到職日期
								
							</tr>
							
								<tr>
									<td>${RegistrationFormEmp.empid}
									<td>${RegistrationFormEmp.empname}
									<td>${RegistrationFormEmp.empgender}
									<td>${RegistrationFormEmp.empbirth}
									<td>${RegistrationFormEmp.depBean.depno}
									<td>${RegistrationFormEmp.emptitle}
									<td>${RegistrationFormEmp.emplevel}
									<td>${RegistrationFormEmp.empphone}
									<td>${RegistrationFormEmp.empaddress}
									<td>${RegistrationFormEmp.emponboard}
									
								</tr>
							
						</table>
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>