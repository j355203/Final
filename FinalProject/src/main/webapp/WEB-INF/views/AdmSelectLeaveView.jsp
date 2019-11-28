<%@page import="finalProject.eeit10930.model.LeaveBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>管理請假紀錄</title>
	<style>
		body {
			background-color: rgba(176, 148, 207, 0.911);
			font-family: 微軟正黑體;
			color: #333333;
		}
	</style>
	<script src="https://cdn.staticfile.org/angular.js/1.4.6/angular.min.js"></script>
	<meta charset="UTF-8">
	<title>請假系統</title>
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
		<div class="container-fluid mt--7" ng-app>
			<div class="row"></div>
			<!-- 網頁格式程式碼 target="nm_iframe"-->
			<div class="row justify-content-md-center">
				<div class="col-lg-4 text-center">
					<h1 style="margin-left: 0px; font-family: Microsoft JhengHei; font-weight: 1200;">審核請假資料</h1>
					<div class="row" ng-app>


						<c:forEach var="lb" items='${lb}' varStatus='s'>
								<div class="col-10 ">
									<div class="table-responsive">
										<div>
											<table class="table align-items-center table-dark">
												<thead class="thead-dark">
													<tr>
														<td>員工編號
														<td>${lb.empid}
													<tr>
														<td>員工姓名
														<td>${lb.ename}
													<tr>
														<td>請假起日
														<td>
															<fmt:parseDate value="${lb.dayoffstart}" var="date1"
																pattern="yyyy-MM-dd HH:mm:ss" />
															<fmt:formatDate value="${date1}"
																pattern="yyyy-MM-dd HH:mm:ss" />
													<tr>
														<td>請假訖日
														<td>
															<fmt:parseDate value="${lb.dayoffend}" var="date2"
																pattern="yyyy-MM-dd HH:mm:ss" />
															<fmt:formatDate value="${date2}"
																pattern="yyyy-MM-dd HH:mm:ss" />
													<tr>
														<td>請假假別
														<td>${lb.leavestyle}
													<tr>
														<td>部門編號
														<td>${lb.deptno}
													</tr>
													<tr>
														<td>請假證明
														<td><a href="${lb.imgpath}" target="_blank">連結</a>
													<tr>
														<td>審核
														<td><input type="text" readonly="true"
																class="form-control form-control-alternative"
																id="verify${lb.leaveid}" name="verify"
																value="${lb.verify}" />
													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
								
								<div class="col-2" ng-hidden="${lb.verify} == '未審核'">
									<form method="POST">
										<input type="hidden"
										id="verify${lb.leaveid}" name="verify"
										value="${lb.verify}" />
									<button type="button" class="btn btn-primary" style="margin-bottom: 10px" 
									onclick="updateVerifyFun(${lb.leaveid}, '通過')">審核通過</button>
									<button type="button" class="btn btn-primary" style="margin-bottom: 10px"
										onclick="updateVerifyFun(${lb.leaveid}, '不通過')">審核不通過</button>
									</form>

								</div>
							
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function updateVerifyFun(leaveid, ss) {

		console.log(leaveid);
		console.log($("#verify" + leaveid).val());

		var postData = {
			verify: ss
		};
		console.log(postData);
		$.ajax({
			type: "POST",
			url: "UpdateVerify/" + leaveid,
			data: postData,
			success: function (data) {
				console.log(data);
				if (data.returnCode == 0) {
					if (ss == "通過") {
						$("#verify" + leaveid).val(ss);
						console.log($("#verify" + leaveid));
// 						$("#verify" + leaveid).css("background-color", "green");

					} else {
						$("#verify" + leaveid).val(ss);
						console.log($("#verify" + leaveid));
// 						$("#verify" + leaveid).css("background-color", "red");
						
					}
				} else {
					alert("失敗");
				}
			}
		});
	}

</script>

</html>