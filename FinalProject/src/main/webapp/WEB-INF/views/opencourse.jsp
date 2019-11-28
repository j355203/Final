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
<title>開課設定</title>
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
	href="${pageContext.request.contextPath}/css/eeit10907/open_main.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/eeit10907/open_opencourse.css"
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
								src="${pageContext.request.contextPath}/assets/img/theme/team-4-800x800.jpg">
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
		<!-- Navbar -->
		<nav class="navbar navbar-top navbar-expand-md navbar-dark"
			id="navbar-main">
			<div class="container-fluid">
				<!-- Brand -->
				<a
					class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block"
					href="${pageContext.request.contextPath}/">首頁</a>
				<!-- User -->
				<ul class="navbar-nav align-items-center d-none d-md-flex">
					<li class="nav-item dropdown"><a class="nav-link pr-0"
						href="#" role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
							<div class="media align-items-center">
								<span class="avatar avatar-sm rounded-circle"> <!-- User Image -->
									<img alt="Image placeholder"
									src="${pageContext.request.contextPath}/assets/img/theme/team-4-800x800.jpg">
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

				<br> <br>
				<section class="section03">
					<br> <br>
					<div class="title3">開課專區</div>
					<div>

						<span class="bottonspan02"> <a
							href="${pageContext.request.contextPath}/opencourseall"><button
									class="bottonstyle01" type="button" value="select">課程專區
									&gt;</button></a>
						</span> 
					</div>
					<br> <br>
					<hr>
				</section>
				<section class="section01">

					<div class="title1">新增學門</div>

					<div class="div1">

						<div class="div2">
							<div class="font1">學門名稱：</div>
							<div>
								<input style="width: 75%; height: 28px;" type="text"
									id="subjectname_a1" name="subjectname_a1">
							</div>
						</div>
						<div class="div2">
							<div class="font1">學門學分：</div>
							<div>
								<input style="width: 15%; height: 28px;" type="text"
									id="subjectscore_a1" name="subjectscore_a1">
							</div>
						</div>

						<br>

						<div style="text-align: center">
							<button class="bottonstyle02" type="button"
								onclick="subject_a1()">送出</button>
							<input class="bottonstyle02" type="reset" value="清除">
							<input type="button" class="bottonstyle02" onclick="demo2()" value="Demo" />
						</div>
					</div>

				</section>


				<br>

				<section class="section01">
					<form>
						<div class="title1">新增課程</div>

						<div class="div3">

							<div class="div2">
								<div class="font1">學門：</div>
								<div>
									<select style="width: 15%; height: 35px" id="subjectname_a2"></select>
								</div>
							</div>
							<div class="div2">
								<div class="font1">課程名稱：</div>
								<div>
									<input style="width: 75%; height: 28px;" type="text"
										id="coursename_a1" name="coursename_a1">
								</div>
							</div>

							<div class="div2">
								<div class="font1">學分：</div>
								<div>
									<input style="width: 15%; height: 28px;" type="text"
										id="coursecredits_a1" name="coursecredits_a1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">開始時間：</div>
								<div>
									<input style="width: 30%; height: 28px;" type="datetime-local"
										id="starttime_a1" name="starttime_a1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">結束時間：</div>
								<div>
									<input style="width: 30%; height: 28px;" type="datetime-local"
										id="endtime_a1" name="endtime_a1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">上課教室：</div>
								<div>
									<select style="width: 15%; height: 35px; float: left"
										id="courseroom_a1" name="courseroom_a1" onchange="getval();"></select>

									<div class="font1" style="width: 20%; float: left">可容納人數為：</div>
									<input style="width: 5%; height: 35px;" type="text"
										id="roomsize">人 <br>
								</div>

							</div>
							
							<div class="div2">
								<div class="font1" style="clear: left">名額：</div>
								<div>
									<input style="width: 15%; height: 28px; float: left"
										type="text" id="signup_a1" name="signup_a1">
								</div>
								<br>
							</div>

							<div class="div2">
								<div class="font1" style="clear: left">課程概要：</div>
								<div>
									<textarea
										style="resize: none; width: 75%; height: 150px; float: left"
										id="coursesummary_a1" name="coursesummary_a1"></textarea>
								</div>

							</div>
							<br>
							<div style="text-align: center; clear: left">
<br>
								<button class="bottonstyle02" type="button" onclick="subject_a2()">送出</button>
								<input class="bottonstyle02" type="reset" value="清除">
								 <input type="button" class="bottonstyle02" onclick="demo()" value="Demo" />
							</div>


						</div>
					</form>
				</section>



				<br>
				<section class="section05 ">
					<div class="div6 ">如有任何問題請洽人力資源部 教育訓練課 葉小姐 電話：02-1234567#123</div>
				</section>

			</div>
			<%-- end content --%>

		</div>
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
		function demo() {
			document.getElementById("coursename_a1").value='Java JDBC應用 '; //課程名稱
			document.getElementById("coursecredits_a1").value='5'; //學分
			$('#subjectname_a2 option[value="1"]').attr("selected",true);
			console.log($('#subjectname_a2 option[value="1"]').text())
			$('#courseroom_a1 option[value="1"]').attr("selected",true).change();
			document.getElementById("signup_a1").value='10'; //學分
			document.getElementById("coursesummary_a1").value='Java JDBC應用'; //學分
		}
</script>

<script type="text/javascript">
		function demo2() {
			document.getElementById("subjectname_a1").value='SpringMVC  '; //課程名稱
			document.getElementById("subjectscore_a1").value='20'; //學分

		}
</script>
<script type="text/javascript">
	$(document).ready(
					function() {
<%-- 下拉功能學門--%>
	function a() {
							$
									.ajax({

										url : "${pageContext.request.contextPath}/opencourse/Q1",
										data : {},
										type : "GET",
										dataType : "JSON",
										success : function(data) {
											showSubject(data);
										}
									});
						}

						function showSubject(data) {
							$("#subjectname_a2").html("");
							var opt = $("<option>").val("").text("請選擇");
							$("#subjectname_a2").append(opt);

							for (var i = 0; i < data.length; i++) {
								var opt = $("<option>").val(data[i].SubjectID)
										.text(data[i].SubjectName);
								$("#subjectname_a2").append(opt);
							}
						}
<%-- 下拉功能 教室--%>
	function b() {
							$
									.ajax({
										url : "${pageContext.request.contextPath}/opencourse/Q2",
										data : {},
										type : "GET",
										dataType : "JSON",
										success : function(data) {
											showClassroom2(data);

										}
									});
						}

						function showClassroom2(data) {
							$("#courseroom_a1").html("");
							var opt = $("<option>").val("").text("請選擇");
							$("#courseroom_a1").append(opt);

							for (var i = 0; i < data.length; i++) {
								var opt = $("<option>").val(data[i].RoomID)
										.text(data[i].RoomName);
								$("#courseroom_a1").append(opt);

							}

						}

						a();
						b();

					});
<%-- 下拉功能 教室人數--%>
	function getval() {
		var courseroom_a1 = $('#courseroom_a1').val();
		console.log(courseroom_a1);
		$.ajax({
			url : "${pageContext.request.contextPath}/opencourse/Q3",
			data : {
				courseroom_a1 : courseroom_a1
			},
			type : "GET",
			dataType : "JSON",
			success : function(data) {
				showClassroomsize(data);

			}

		});
	}
	function showClassroomsize(data) {
		$("#roomsize").val(data[0].RoomSize).attr('readonly', 'readonly');
	}

	function subject_a1() {
		var subjectname_a1 = $('#subjectname_a1').val();
		var subjectscore_a1 = $('#subjectscore_a1').val();
		console.log("123");
		$.ajax({

			url : "${pageContext.request.contextPath}/opencourse/A1",
			data : {
				subjectname_a1 : subjectname_a1,
				subjectscore_a1 : subjectscore_a1
			},
			type : "POST",
			success : function(data) { //成功後要更新  才能網頁更新
				window.alert("新增成功");
				window.location.reload(true);
			}
		});
	}
	function subject_a2() {
		var subjectname_a2 = $('#subjectname_a2').val();
		var coursename_a1 = $('#coursename_a1').val();
		var coursecredits_a1 = $('#coursecredits_a1').val();
		var starttime_a1 = $('#starttime_a1').val();
		var endtime_a1 = $('#endtime_a1').val();
		var courseroom_a1 = $('#courseroom_a1').val();
		var signup_a1 = $('#signup_a1').val();
		var coursesummary_a1 = $('#coursesummary_a1').val();
		var roomsize = $('#roomsize').val();
		var signup_a1 = $('#signup_a1').val();

		if (Number(signup_a1) > Number(roomsize) || Number(signup_a1) <= 0)
<%--Number 在js中 代表 字串轉數字--%>
	{
			alert("請輸入0以上至教室容納人數區間之數值");
			return null;
		}

		$.ajax({
			url : "${pageContext.request.contextPath}/opencourse/A2",
			data : {
				subjectname_a2 : subjectname_a2,
				coursename_a1 : coursename_a1,
				starttime_a1 : starttime_a1,
				endtime_a1 : endtime_a1,
				courseroom_a1 : courseroom_a1,
				coursecredits_a1 : coursecredits_a1,
				signup_a1 : signup_a1,
				coursesummary_a1 : coursesummary_a1
			},
			type : "POST",
			success : function(data) { //成功後要更新  才能網頁更新
				window.alert("新增成功");
				window.location.reload(true)
			}
		});
	}
</script>
</html>