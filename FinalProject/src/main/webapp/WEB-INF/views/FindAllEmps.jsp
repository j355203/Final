<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>查詢所有員工</title>

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
						<h2 class="text-center">所有在職員工清單</h2>
						<br>
						<form method="POST" action="${pageContext.request.contextPath}/uploadCsv" enctype="multipart/form-data">
							<div class="text-left">
								<input type="submit" class="btn btn-primary" value="上傳csv">
								<input id="upload_csv" type="file" name="file" accept=".csv">
							</div>
						</form>

						<table border="1" class="table-hover text-center">
							<tr>
								<th>員工代號
								<th>員工姓名
								<th>員工性別
								<th>員工生日
								<th>部門編號
								<th>員工職稱
								<th>員工權限
								<th>員工電話
								<th>居住地址
								<th>到職日期
								<th>辦理離職
							</tr>
							<c:forEach var="emp" items="${emps}">
								<tr>
									<td><a href="<c:url value="/updateEmp/${emp.empid}" />">${emp.empid}</a>
									<td>${emp.empname}
									<td>${emp.empgender}
									<td>${emp.empbirth}
									<td>${emp.depBean.depno}
									<td>${emp.emptitle}
									<td>${emp.emplevel}
									<td>${emp.empphone}
									<td>${emp.empaddress}
									<td>${emp.emponboard}
									<td><a href="<c:url value="/leaveEmp/${emp.empid}" />">離職</a>
								</tr>
							</c:forEach>
						</table>
						<br>
						<div class="row justify-content-md-center">
							<input type="button" class="btn btn-primary"
								onclick="window.location.href='<c:url value="/addEmp" />'" value="新增員工">
							<input type="button" class="btn btn-primary"
								onclick="window.location.href='<c:url value="/findleaveemps" />'" value="離職員工清單">
							<input type="button" class="btn btn-primary"
								onclick="window.location.href='<c:url value="/downloadCsv" />'" value="匯出員工清單">
						</div>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>