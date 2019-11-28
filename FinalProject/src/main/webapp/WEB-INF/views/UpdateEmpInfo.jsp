<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>更新員工資料</title>
	<style type="text/css">
		label{
			margin-left:15%
		}
		.bg10904 {
	background-image:url(<c:url value="/images/bg.jpg"/>);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: top center;
	}
	</style>
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
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
			<div class="row"></div>
			<div class="row justify-content-md-center">
				<div class="col-lg-4">
					<div class="card" style="width: 100%">
						<h2 class="text-center">更新員工資料</h2>
						<form:form method="POST" modelAttribute="updEmp">
							<div>
								<label for="empid">員工工號</label>
								<form:input type="text" path="empid" readonly="true" />
							</div>
							<div>
								<label for="empname">員工姓名</label>
								<form:input type="text" id="empname" path="empname" />
							</div>
							<div>
								<label for="empgender">員工性別</label>
								<form:radiobutton id="empgender" path="empgender" value="男" label="男" />
								<form:radiobutton id="empgender" path="empgender" value="女" label="女" />
							</div>
							<div>
								<label for="empbirth">員工生日</label>
								<form:input type="date" id="empbirth" path="empbirth" />
							</div>
							<div>
								<label for="depno">部門編號</label>
								<form:select id="depno" path="depno">
									<form:option value="${updEmp.depBean.depno}" label="${updEmp.depBean.depname}" />
									<form:options items="${depList}" />
								</form:select>
							</div>
							<div>
								<label for="emptitle">員工職稱</label>
								<form:input type="text" id="emptitle" path="emptitle" />
							</div>
							<div>
								<label for="emplevel">員工權限</label>
								<form:input type="text" id="emplevel" path="emplevel" />
							</div>
							<div>
								<label for="empphone">員工電話</label>
								<form:input type="text" id="empphone" path="empphone" />
							</div>
							<div>
								<label for="empaddress">員工地址</label>
								<form:input type="text" id="empaddress" path="empaddress" />
							</div>

							<div>
								<label for="emponboard">到職日期</label>
								<form:input type="date" id="emponboard" path="emponboard" />
							</div>
							<div class="text-center">
								<input type="submit" class="btn btn-primary" value="修改">
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>