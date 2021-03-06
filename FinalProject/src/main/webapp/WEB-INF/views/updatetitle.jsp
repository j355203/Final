<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>學分設定</title>
<%-- Fonts --%>
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<%-- Icons --%>
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/nucleo/css/nucleo.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css"
	rel="stylesheet" />
<%-- CSS Files --%>
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/css/argon-dashboard.css?v=1.1.0"
	rel="stylesheet" />

<%-- jquery --%>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

<link href="${pageContext.request.contextPath}/css/eeit10907/index2.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/eeit10907/up_main.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/eeit10907/up_title.css"
	rel="stylesheet">


<style>
* {
	font-family: "微軟正黑體";
}
</style>
</head>

<body>
	<nav
		class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white"
		id="sidenav-main">
		<div class="container-fluid">
			<!-- Toggler -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#sidenav-collapse-main" aria-controls="sidenav-main"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Brand -->
			<a class="navbar-brand pt-0"
				href="${pageContext.request.contextPath}/"> <img
				src="${pageContext.request.contextPath}/assets/img/brand/blue.png"
				class="navbar-brand-img" alt="...">
			</a>
			<!-- User -->
			<ul class="nav align-items-center d-md-none">
				<li class="nav-item dropdown"><a class="nav-link" href="#"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
						<div class="media align-items-center">
							<span class="avatar avatar-sm rounded-circle"> <!-- User Image(Toggle Type)-->
								<img alt="Image placeholder"
								src="${pageContext.request.contextPath}/assets/img/theme/team-1-800x800.jpg">
							</span>
						</div>
				</a>
					<div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
						<div class=" dropdown-header noti-title">
							<h6 class="text-overflow m-0">歡迎～</h6>
						</div>
						<a href="${pageContext.request.contextPath}/updpwd/${empid}"
							class="dropdown-item"> <i class="ni ni-single-02"></i><span>我的資料</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="${pageContext.request.contextPath}/logout"
							class="dropdown-item"> <i class="ni ni-user-run"></i><span>登出</span>
						</a>
					</div></li>
			</ul>
			<!-- Collapse -->
			<div class="collapse navbar-collapse" id="sidenav-collapse-main">
				<!-- Collapse header -->
				<div class="navbar-collapse-header d-md-none">
					<div class="row">
						<div class="col-6 collapse-brand">
							<a href="./index.html"> <img
								src="${pageContext.request.contextPath}/assets/img/brand/blue.png">
							</a>
						</div>
						<div class="col-6 collapse-close">
							<button type="button" class="navbar-toggler"
								data-toggle="collapse" data-target="#sidenav-collapse-main"
								aria-controls="sidenav-main" aria-expanded="false"
								aria-label="Toggle sidenav">
								<span></span> <span></span>
							</button>
						</div>
					</div>
				</div>
				<!-- Form -->
				<form class="mt-4 mb-3 d-md-none">
					<div class="input-group input-group-rounded input-group-merge">
						<input type="search"
							class="form-control form-control-rounded form-control-prepended"
							placeholder="Search" aria-label="Search">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<span class="fa fa-search"></span>
							</div>
						</div>
					</div>
				</form>
				<!-- Navigation -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class=" nav-link"
					href=" ${pageContext.request.contextPath}/"> <i
						class="ni ni-tv-2 text-primary"></i>首頁
				</a></li>

				<li class="nav-item"><a class="nav-link "
					href="${pageContext.request.contextPath}/calendar"> <i
						class="far fa-calendar-check text-red"></i>會議室預約
				</a></li>

				<li class="nav-item"><a class="nav-link "
					href="${pageContext.request.contextPath}/Learningindex"> <i
						class="fas fa-book text-orange"></i>教育訓練系統
				</a></li>

				<!-- 下拉選單測試區 -->
				<c:if test="${sessionScope.emplevel>=5}">
					<li class="nav-item"><a class="nav-link dropdown-item"
						data-toggle="collapse" href="#collapse-hr" aria-expanded="false"
						aria-controls="collapse" title="任用系統"> <i
							class="fas fa-users text-blue"></i>任用系統
					</a>
						<div class="collapse text-center" id="collapse-hr">
							<a class="nav-link dropdown-item"
								href="${pageContext.request.contextPath}/findalldeps" title="部門">
								<i class="fab fa-fort-awesome text-info"></i>部門
							</a> <a class="nav-link dropdown-item"
								href="${pageContext.request.contextPath}/findallemps" title="人員">
								<i class="fas fa-user-tie text-info"></i>人員
							</a>
						</div></li>
				</c:if>

				<li class="nav-item"><a class="nav-link dropdown-item"
					data-toggle="collapse" href="#collapse-food" aria-expanded="false"
					aria-controls="collapse" title="餐點專區"> <i
						class="fas fa-utensils text-red"></i> 餐點專區
				</a>
					<div class="collapse text-center" id="collapse-food">
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/foodmap" title="美食地圖">
							<i class="fas fa-map-marked-alt text-blue"></i> 美食地圖
						</a> 
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/orderpage" title="本日店家">
							<i class="fas fa-store text-orange"></i> 本日店家
						</a> 
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/orderlist" title="訂購總覽">
							<i class="fas fa-list text-info"></i> 訂購總覽
						</a>
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/storemanage" title="店家管理"> 
							<i class="fas fa-store-alt text-success"></i> 店家管理
						</a>
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/ordermanage" title="訂單確認">
							<i class="fas fa-clipboard-check"></i> 訂單報表
						</a>
					</div></li>

				<li class="nav-item"><a class="nav-link dropdown-item"
					data-toggle="collapse" href="#collapse-act" aria-expanded="false"
					aria-controls="collapse" title="活動管理"><i class="fas fa-archway text-green"></i>
						活動管理 </a>
					<div class="collapse text-center" id="collapse-act">
						<c:if test="${sessionScope.emplevel>=9}">
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/activity" title="活動一覽">
							<i class="fas fa-car-side text-blue"></i>活動一覽
						</a> <a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/addActivity"
							title="新增活動"> <i class="fas fa-plus text-blue"></i>新增活動
						</a><a class="nav-link dropdown-item" href="RegistrationForm"
							title="訂單查詢"> <i class="far fa-file-alt text-blue"></i>訂單查詢
						</a>
						</c:if>
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/userActivity"
							title="使用者活動"> <i class="fas fa-car text-blue"></i> 使用者活動
						</a> <a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/RegistrationFormBean/${emp.empid}"
							title="使用者搜尋"> <i class="fas fa-archive text-blue"></i> 我的報名紀錄
						</a> <a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/RegistrationFormBeanA"
							title="使用者搜尋"> <i class="fas fa-search text-blue"></i> 使用者搜尋
						</a>
					</div></li>

				<li class="nav-item"><a class="nav-link dropdown-item"
					data-toggle="collapse" href="#collapse-clock" aria-expanded="false"
					aria-controls="collapse" title="差勤系統"> <i
						class="far fa-calendar-alt"></i>差勤系統
				</a>
					<div class="collapse text-center" id="collapse-clock">
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/clockin" title="打卡">
							<i class="far fa-id-card text-info"></i> 打卡
						</a>
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/empSelectClockin" title="打卡">
							<i class="fas fa-clipboard text-info"></i> 打卡紀錄
						</a>
						 <a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/leave" title="請假"> <i
							class="fas fa-pray text-info"></i> 請假
						</a> 
						<c:if test="${sessionScope.emplevel>=9}">
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/AdmSelect" title="請假管理">
							<i class="fas fa-user-edit text-info"></i> 請假管理
						</a><a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/AdmFindOvertime" title="加班管理">
							<i class="fas fa-child text-info"></i> 加班管理
						</a>
						</c:if>
					</div></li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/SelectAllArticle"> <i
						class="ni ni-chat-round text-green"></i>員工討論區
				</a></li>
				<c:if test="${sessionScope.emplevel>=5}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/SelectAll-admin"> <i
							class="ni ni-chat-round text-orange"></i>員工討論區管理
					</a></li>
				</c:if>
				<!-- 下拉選單測試區 -->
				</ul>
			</div>
		</div>
	</nav>
	<div class="main-content">
		<%-- Navbar --%>
		<nav class="navbar navbar-top navbar-expand-md navbar-dark"
			id="navbar-main">
			<div class="container-fluid">
				<!-- Brand -->
				<a
					class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block"
					href="${pageContext.request.contextPath}/">首頁</a>
				<%-- User --%>
				<ul class="navbar-nav align-items-center d-none d-md-flex">
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
								<span class="avatar avatar-sm rounded-circle"> <!-- User Image -->
									<img alt="Image placeholder"
									src="${pageContext.request.contextPath}/assets/img/theme/team-1-800x800.jpg">
								</span>
								<div class="media-body ml-2 d-none d-lg-block">
									<!-- User Name -->
									<span class="mb-0 text-sm  font-weight-bold">${sessionScope.emp.empname}</span>
								</div>
							</div>
					</a>
						<div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
							<div class=" dropdown-header noti-title">
								<h6 class="text-overflow m-0">歡迎～</h6>
							</div>
							<a href="${pageContext.request.contextPath}/updpwd/${emp.empid}"
								class="dropdown-item"> <i class="ni ni-single-02"></i> <span>我的資料</span>
							</a>
							<div class="dropdown-divider"></div>
							<a href="${pageContext.request.contextPath}/logout"
								class="dropdown-item"> <i class="ni ni-user-run"></i> <span>登出</span>
							</a>
						</div></li>
				</ul>
			</div>
		</nav>
		<!-- End Navbar -->
		<!-- Header -->
		<div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
			<div class="container-fluid"
				style="background-color: #FFFFFF !important">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7"
			style="margin-top: -6rem !important">
			<div class="row"></div>

			<div class="row justify-content-md-center">
				<div class="col-lg-10"
					style="padding: 0px; margin: 0px; float: left !important">
					<ul class="nav nav-pills nav-fill flex-column flex-sm-row" id="tabs-text" role="tablist">

						<li class="nav-item"><a class="nav-link mb-sm-3 mb-md-0 " href="${pageContext.request.contextPath}/Learningindex"
								style="font-size: 30px !important; font-weight: 900 !important;color: #172b4d;">學習園地</a>
						</li>
						<li class="nav-item"><a class="nav-link mb-sm-3 mb-md-0 " href="${pageContext.request.contextPath}/mycourse"
								style="font-size: 30px !important; font-weight: 900 !important;color: #172b4d;">我的課程</a>
						</li>

						<li class="nav-item"><a class="nav-link mb-sm-3 mb-md-0" href="${pageContext.request.contextPath}/opencourse"
								style="font-size: 30px !important; font-weight: 900 !important;color: #172b4d;">開課設定</a>
						</li>
						<li class="nav-item"><a class="nav-link mb-sm-3 mb-md-0" href="${pageContext.request.contextPath}/opensourse"
								style="font-size: 30px !important; font-weight:bolder !important;color: #172b4d;">公告設定</a>
						</li>
						<li class="nav-item"><a class="nav-link mb-sm-3 mb-md-0" href="${pageContext.request.contextPath}/title"
								style="font-size: 30px !important; font-weight:bolder !important;color: #172b4d;">學分設定</a>
						</li>
					</ul>
				</div>
<br>
				<br>
				<section class="section03">
				<br>
					<div class="title3">修改職稱</div>
					<div>

						<span class="bottonspan01"> <a
							href="${pageContext.request.contextPath}/title"><button
									class="bottonstyle01" type="button" value="select">&lt;職稱專區</button></a>
						</span> <span class="bottonspan02"> <a
							href="${pageContext.request.contextPath}/employee"><button
									class="bottonstyle01" type="button" value="select">員工專區
									&gt;</button></a>
						</span>
					</div>
					<br>
				</section>
<br><br>


				<section class="section01">
				<br>
					<form>
						<div class="title1">修改職稱學門</div>

						<div class="div1" id="ttt">

							<div class="div2">
								<div class="font1">職稱代碼：</div>
								<div>
									<input style="width: 50%; height: 28px; display: none;"
										type="text" id="titleID_a1" name="titleID_a1">
								</div>
								<div>
									<input style="width: 50%; height: 28px;" type="text"
										id="titleno_a1" name="titleno_a1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">職稱名稱：</div>
								<div>
									<input style="width: 50%; height: 28px;" type="text"
										id="titlename_a1" name="titlename_a1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">預設學門一：</div>
								<select style="width: 50%; height: 28px" class="select01"
									id="subjectt1_a1" name="subjectt1_a1"></select>
							</div>
							<div class="div2">
								<div class="font1">預設學門二：</div>
								<select style="width: 50%; height: 28px" class="select01"
									id="subjectt2_a1" name="subjectt2_a1"></select>
							</div>
							<div class="div2">
								<div class="font1">預設學門三：</div>
								<select style="width: 50%; height: 28px" class="select01"
									id="subjectt3_a1" name="subjectt3_a1"></select> 
									<input
									style="width: 60%; height: 28px; display: none" type="text"
									id="Employ2313eeName1" name="Employ2313eeName1">
								<%-- 隱藏欄位 要加總3個學門 --%>
							</div>
						</div>
						<br>

						<div style="text-align: center">
							<button class='bottonstyle02' type='button' onclick='update()'>送出</button>
							<input class="bottonstyle02" type="button"
								onclick="javascript:location.href='${pageContext.request.contextPath}/title'"
								value="回上一頁"></input>
						</div>
						<br>
					</form>

				</section>
				<br> <br> <br>
				<section class="section05 ">
					<div class="div6 ">如有任何問題請洽人力資源部 教育訓練課 葉小姐 電話：02-1234567#123</div>
				</section>

			</div>
			<%-- end content --%>
		</div>





		<br>
		<%-- end content --%>




	</div>

	<%--   Core   --%>
	<script src="./assets/js/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="./assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<%--   Optional JS   --%>
	<script src="./assets/js/plugins/chart.js/dist/Chart.min.js"></script>
	<script src="./assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
	<%--   Argon JS   --%>
	<script src="./assets/js/argon-dashboard.min.js?v=1.1.0"></script>
	<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(
			function() {
<%-- 下拉功能 第1個學門--%>
	function a() {
					$.ajax({

						url : "${pageContext.request.contextPath}/title/Q1",
						data : {},
						type : "GET",
						dataType : "JSON",
						success : function(data) {
							showSubject1(data);
						}
					});
				}

				function showSubject1(data) {
					$("#subjectt1_a1").html("");
					var opt = $("<option>").val("").text("請選擇");
					$("#subjectt1_a1").append(opt);

					for (var i = 0; i < data.length; i++) {
						var opt = $("<option>").val(data[i].SubjectID).text(
								data[i].SubjectName);
						$("#subjectt1_a1").append(opt);
					}
				}
<%-- 下拉功能 第2個學門--%>
	function b() {
					$.ajax({
						url : "${pageContext.request.contextPath}/title/Q1",
						data : {},
						type : "GET",
						dataType : "JSON",
						success : function(data) {
							showSubject2(data);
						}
					});
				}

				function showSubject2(data) {
					$("#subjectt2_a1").html("");
					var opt = $("<option>").val("").text("請選擇");
					$("#subjectt2_a1").append(opt);

					for (var i = 0; i < data.length; i++) {
						var opt = $("<option>").val(data[i].SubjectID).text(
								data[i].SubjectName);
						$("#subjectt2_a1").append(opt);
					}
				}
<%-- 下拉功能 第3個學門--%>
	function c() {
					$.ajax({
						url : "${pageContext.request.contextPath}/title/Q1",
						data : {},
						type : "GET",
						dataType : "JSON",
						success : function(data) {
							showSubject3(data);
						}
					});
				}

				function showSubject3(data) {
					$("#subjectt3_a1").html("");
					var opt = $("<option>").val("").text("請選擇");
					$("#subjectt3_a1").append(opt);

					for (var i = 0; i < data.length; i++) {
						var opt = $("<option>").val(data[i].SubjectID).text(
								data[i].SubjectName);
						$("#subjectt3_a1").append(opt);
					}
				}

				a();
				b();
				c();

				//抓取前一頁的值，帶入資料
				var a = window.location.href;
				var a = a.split("?");
				function select_db() {
					$.ajax({

						url : "${pageContext.request.contextPath}/title/Q7",
						data : {
							TitleID : a[1].split("=")[1]
						},
						type : "GET",
						dataType : "JSON",
						success : function(data) {
							select(data);
						}
					});

					function select(data) {
						var TitleName = data[0].TitleName;
						$('#titleno_a1').val(data[0].TitleNO);
						$('#titlename_a1').val(TitleName);
						$('#titleID_a1').val(data[0].TitleID);
						console.log(data[0].TitleNO);
						console.log(data[0].TitleID);

						var select0 = data[0].PreTitleSubject.split(";")[0];
						var select1 = data[0].PreTitleSubject.split(";")[1];
						var select2 = data[0].PreTitleSubject.split(";")[2];
						console.log(select0);
						console.log(select1);
						console.log(select2);
						$('#subjectt1_a1 option[value=' + select0 + ']').prop('selected', true);
						$('#subjectt2_a1 option[value=' + select1 + ']').prop('selected', true);
						$('#subjectt3_a1 option[value=' + select2 + ']').prop('selected', true);

					}
				}
				select_db();
			});
<%-- 修改資料--%>
	function update() {

		var titleID_a1 = $('#titleID_a1').val();
		var titleno_a1 = $('#titleno_a1').val();
		var titlename_a1 = $('#titlename_a1').val();
		var subjectt1_a1 = $('#subjectt1_a1').val();
		var subjectt2_a1 = $('#subjectt2_a1').val();
		var subjectt3_a1 = $('#subjectt3_a1').val();
		console.log(titleID_a1);
		console.log(titleno_a1);

		function update_db() {

			$.ajax({
						url : "${pageContext.request.contextPath}/title/U1",
						data : {
							titleID_a1 : titleID_a1,
							titleno_a1 : titleno_a1,
							titlename_a1 : titlename_a1,
							subjectt1_a1 : subjectt1_a1,
							subjectt2_a1 : subjectt2_a1,
							subjectt3_a1 : subjectt3_a1
						},
						type : "POST",
						dataType : "text", //更新 與刪除都要寫 才會跳頁 或更新頁面
						success : function(data) {
							console.log("aaa");
							window.alert("修改成功");
							window.location
									.replace("${pageContext.request.contextPath}/title");

						},
						error : function() {
							console.log("XXX");
						}
					});
		}
		update_db();
	}
</script>
</html>