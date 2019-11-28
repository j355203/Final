<%@page import="finalProject.eeit10930.model.ClockinBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>查詢打卡紀錄與申請加班</title>

<style>
body {
	background-color: rgba(176, 148, 207, 0.911);
	font-family: 微軟正黑體;
	color: #333333;
}

#allpage {
	width: 250px;
	margin: 0 auto;
}

.button1 {
	width: 700px;
	margin: 100px;
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>請假系統</title>
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


		<div align="center">
			<h2>打卡紀錄</h2>

			<c:forEach var="empSelectClockin" items='${empSelectClockin}'
				varStatus='s'>
				<div class="col-5">
					<div class="table-responsive">
						<div>
							<table class="table align-items-center table-dark">
								<tr>
									<td>上班打卡
									<td>
									<fmt:parseDate value="${empSelectClockin.clkintime}" var="date3"
															pattern="yyyy-MM-dd HH:mm:ss" />
														<fmt:formatDate value="${date3}"
															pattern="yyyy-MM-dd HH:mm:ss" />
								<tr>
									<td>下班打卡
									<td>
									<fmt:parseDate value="${empSelectClockin.clkouttime}" var="date4"
															pattern="yyyy-MM-dd HH:mm:ss" />
														<fmt:formatDate value="${date4}"
															pattern="yyyy-MM-dd HH:mm:ss" />
								<tr>
									<td>審核加班
									<td>${empSelectClockin.verify}
							</table>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-primary"
					style="margin-bottom: 10px"
					onclick="location.href='updateovertime/${empSelectClockin.clockinid}'">申請加班</button>
			</c:forEach>

		</div>
</body>
</html>
