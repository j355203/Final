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
				<div class="col-lg-4 text-center">
					<h1
						style="margin-left: 0px; font-family: Microsoft JhengHei; font-weight: 1200;">審核加班資料</h1>
					<div class="row">
						<c:forEach var="cb" items='${cb}' varStatus='s'>
							<div class="col-10">
								<div class="table-responsive">
									<div>
										<table class="table align-items-center table-dark">
											<thead class="thead-dark">
												<tr>
													<td class="row1">員工編號
													<td class="row2">${cb.empid}
												<tr>
													<td class="row1">上班打卡時間
													<td class="row2"><fmt:parseDate
															value="${cb.clkintime}" var="date1"
															pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
															value="${date1}" pattern="yyyy-MM-dd HH:mm:ss" />
												<tr>
													<td class="row1">下班打卡時間
													<td class="row2"><fmt:parseDate
															value="${cb.clkouttime}" var="date2"
															pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
															value="${date2}" pattern="yyyy-MM-dd HH:mm:ss" />
												<tr>
													<td class="row1">加班時數
													<td class="row2">${cb.overtime}
												<tr>
													<td class="row1">部門編號
													<td class="row2">${cb.depno}
												</tr>
												<tr>
													<td class="row1">審核
													<td class="row2"><input type="text" readonly="true"
														class="form-control form-control-alternative"
														id="verify${cb.clockinid}" name="verify"
														value="${cb.verify}" />
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
							<div class="col-2">
								<form method="POST">
									<input type="hidden" id="verify${cb.clockinid}" name="verify"
										value="${cb.verify}" />
									<button type="button" class="btn btn-primary"
										style="margin-bottom: 10px"
										onclick="updateVerifyFun1(${cb.clockinid}, '通過')">審核通過</button>
									<button type="button" class="btn btn-primary"
										style="margin-bottom: 10px"
										onclick="updateVerifyFun1(${cb.clockinid}, '不通過')">審核不通過</button>
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
		function updateVerifyFun1(clockinid, ss) {

			console.log(clockinid);
			console.log($("#verify" + clockinid).val());

			var postData = {
				verify: ss
			};
			console.log(postData);
			$.ajax({
				type: "POST",
				url: "UpdateOvertimeVerify/" + clockinid,
				data: postData,
				success: function (data) {
					console.log(data);
					if (data.returnCode == 0) {
						if (ss == "通過") {
							$("#verify" + clockinid).val(ss);
							console.log($("#verify" + clockinid));
// 							$("#verify" + clockinid).css("background-color", "green");

						} else {
							$("#verify" + clockinid).val(ss);
							console.log($("#verify" + clockinid));
// 							$("#verify" + clockinid).css("background-color", "red");
// 							alert("不通過");
						}
					} else {
						alert("失敗");
					}
				}
			});
		}

	</script>

</html>