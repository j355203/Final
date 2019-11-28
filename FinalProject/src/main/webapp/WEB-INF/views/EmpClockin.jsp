<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="finalProject.eeit10930.model.ClockinBean"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>打卡</title>

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(
			function() {
				$("#clockinButton").click(
						function() {
							console.log($("#addclockinInfo").serialize());
							$.ajax({
								type : "POST",
								url : "addclockin",
								data : $("#addclockinInfo").serialize(),
								dataType : "text",
							});
							today = new Date();
							hour = today.getHours();
							minute = today.getMinutes();
							second = today.getSeconds();
							prepand = (hour >= 12) ? "下午" : "上午";
							hour = (hour >= 12) ? hour - 12 : hour;
							string = "    打卡時間" + prepand + hour + "點" + minute + "分" + second + "秒";
							alert(today.getHours() + "點" + today.getMinutes()
									+ "分" + today.getSeconds() + "秒"
									+ "上班打卡成功!!");
							// alert("上班打卡成功!"+string);
						});
			});

	$(document).ready(function() {
		$("#clockoutButton").click(function() {
			$.ajax({
				type : "POST",
				url : "updateclockout",
				data : $("#updateclockoutInfo").serialize(),
				dataType : "text",
			});
			today = new Date();
			hour = today.getHours();
			minute = today.getMinutes();
			second = today.getSeconds();
			prepand = (hour >= 12) ? "下午" : "上午";
			hour = (hour >= 12) ? hour - 12 : hour;
			string = "    打卡時間" + prepand + hour + "點" + minute + "分" + second + "秒";
			alert("下班打卡成功!" + string);
		});
	});

	$(document).ready(function() {
		setInterval(function() {
			var hours = new Date().getHours();
			$(".hours").html((hours < 10 ? "0" : "") + hours);
		}, 1000);
		setInterval(function() {
			var minutes = new Date().getMinutes();
			$(".min").html((minutes < 10 ? "0" : "") + minutes);
		}, 1000);
		setInterval(function() {
			var seconds = new Date().getSeconds();
			$(".sec").html((seconds < 10 ? "0" : "") + seconds);
		}, 1000);
	});

	
</script>
<style type="text/css">
form {
	margin: 0px;
	display: inline
}

.divclock {
	background-image:
		url(${pageContext.request.contextPath}/images/eeit10930/clock.png);
	width: 600px;
	height: 400px;
	/* 		border:2px #ccc solid; */
	background-size: 600px 400px;
}
</style>
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

		<div class="container-fluid mt--8 col-10" >
			<!-- 網頁格式程式碼 target="nm_iframe"-->
			<div align=center>
				<div class="col-10" style="margin-top: 0px">
					<!-- 					<div class="col"> -->
					<div class="divclock">
						<h1 class="card-title text-center" style="line-height: 400px">
							<div>
								<a><span class="badge hours"
									style="color: white; font-size: 2em;"></span></a> <a><span
									style="color: white; font-size: 2em;">:</span></a> <a><span
									class="badge min" style="color: white; font-size: 2em;"></span></a>
								<a><span style="color: white; font-size: 2em;"><a><span
											style="color: white; font-size: 2em;">:</span></span> <a><span
										class="badge sec" style="color: white; font-size: 2em;"></span></a>
							</div>
	
						</h1>
					</div>
	
				</div>
	
			</div>
			
			<div align=center style="weight: 500px">
			
				<form:form id="addclockinInfo" modelAttribute="addclockin">
					<input type="hidden" value="${clockin.empid}" name="empid">
					<input type="hidden" value="${emp.depBean.depno}" name="depno">
				</form:form>
				<input type="button" class="btn btn-success btn-lg"
					style="width: 180px; height: 180px; background-color: #33CCFF;border: #33CCFF;margin-right: 20px" id="clockinButton" value="上班打卡" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				

				<form:form id="updateclockoutInfo" modelAttribute="updateclockout">
					<input type="hidden" value="${clockin.empid}" name="empid">
				</form:form>
				<input type="button" class="btn btn-success btn-lg"
					style="width: 180px; height: 180px; background-color: #33CCFF;border: #33CCFF;" id="clockoutButton"
					value="下班打卡" />
			</div>
				

			<div>
				<iframe id="id_iframe" name="nm_iframe" style="display: none;"></iframe>
			</div>
		</div>
		
	</div>	
</body>

</html>