<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>公告設定</title>
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
<!-- Icons -->
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/nucleo/css/nucleo.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css"
	rel="stylesheet" />
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/css/argon-dashboard.css?v=1.1.0"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/eeit10907/index2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/eeit10907/sourse_main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/eeit10907/sourse_mycourse.css">




<!-- jquery -->
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- jquery -->

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

					<div class="title3">公告專區</div>
					<div>

						<span class="bottonspan02"> <a
							href="${pageContext.request.contextPath}/opensourse2">
								<button class="bottonstyle01" type="button" value="select">資源專區
									&gt;</button>
						</a>
						</span> 
						 <br>
						
					</div>

					
					<br>
					<hr>
					<br>
					
				</section>
				<br>
				<!-- The App Section -->
				<br> <br>
				<div>&emsp;</div>
				<section class="section02">
						<form id="myForm">
						<div class="title1">修改公告</div>

						<div class="div1">
							<div class="div2">
								<div class="font1">類別：</div>
								<input name="htmer_radio" id="bulletin1" type="radio" value="bull1"/>
								<label for="bulletin1">公告一</label> 
								<input name="htmer_radio" id="bulletin2" type="radio" value="bull2" />
								<label for="bulletin2">公告二</label>


							</div>
							
							<div class="div2">
								<div class="font1">標題：</div>
								<div>
									<input style="width: 75%; height: 28px;" type="text"
										id="bullname_u1" name="bullname_u1">
								</div>
							</div>
							<div class="div2">
								<div class="font1">內容概述：</div>
								<div>
									<input style="width: 75%; height: 100px;" rows="2" id="bullsum_u1" name="bullsum_u1"
										cols="20">
								</div>
							</div>
							<div class="div2">
								<div class="font1">上傳圖片：</div>
								<div>
									<input style="width: 75%; height: 28px;" type="file" id="bullimg_u1" name="file">
								</div>
							</div>
							<br>
							
                        
							<div style="text-align: center">
								<button class="bottonstyle02" type="submit">送出</button>
								 <input class="bottonstyle02" type="reset" value="清除">
								 <input type="button" class="bottonstyle02" onclick="demo()" value="Demo" />
							</div>
						</div>
					</form>
					<br>
				</section>


				<br>

				

		</div>
		<br>
	</div>
	<!--   Core   -->
	<script src="./assets/js/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="./assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!--   Optional JS   -->
	<script src="./assets/js/plugins/chart.js/dist/Chart.min.js"></script>
	<script src="./assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
	<!--   Argon JS   -->
	<script src="./assets/js/argon-dashboard.min.js?v=1.1.0"></script>
	<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
</body>
<script type="text/javascript">
		function demo() {
			$('#bulletin1[value="bull1"]').attr("checked",true);
			document.getElementById("bullname_u1").value='儲備幹訓班 '; //課程名稱
			document.getElementById("bullsum_u1").value='2019年第2梯次儲備幹訓班報名開始，聘請多位專業講師蒞臨演講，以嚴格專業訓練增強員工專業能力、團隊能力、領導力...等。幹訓班訓練費用為免費，為期6個月訓練，歡迎本公司員工積極參與 !'; //學分

		}
	</script>
<script type="text/javascript">

$(function() {

	$("#myForm").submit(
			function(e){
				var check = $('input[name=htmer_radio]:checked').val();
				console.log(check);
				var bullname = $('#bullname_u1').val();
				var bullsum = $('#bullsum_u1').val();
				
				e.preventDefault(); // 停止觸發submit
				var file_name = ($('#bullimg_u1').val().split("."))[1];
				if (file_name != "JPG" && file_name != "jpg" && file_name != "PNG" && file_name != "png") {
				   alert("僅限上傳JPG及PNG")
				   return null;
				};


		   
			if(check == 'bull1'){ //修改公告一
				      var formData = new FormData($("#myForm")[0]); // 使用FormData包裝form表單來傳輸資料
						 console.log(formData)
						  $.ajax({
						         type : "POST",
						         url : "${pageContext.request.contextPath}/opensourse/U1",
						         data : formData,
						         cache : false, // 不需要cache
						         processData : false, // jQuery預設會把data轉為query String, 所以要停用
						         contentType : false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
						         dataType : "JSON",
						         success : function(data) {
						          alert_mseage("success")
						         },
						         error : function(data) {
						          console.log("error")
						         }
						        });
					      $.ajax({
						         type : "POST",
						         url : "${pageContext.request.contextPath}/opensourse/U2",
						         data : {bullname:bullname,bullsum:bullsum},
						         cache : false, // 不需要cache
						         success : function(data) {
						          alert_mseage("success")
						         },
						         error : function(data) {
						          console.log("error")
						         }
						        });	
					
					function alert_mseage() {
					 alert("上傳成功");
					 location.reload();
					 
					}
		   
		    }
			else if(check == 'bull2') { //修改公告二
		
						 var formData = new FormData($("#myForm")[0]); // 使用FormData包裝form表單來傳輸資料
						  $.ajax({
						         type : "POST",
						         url : "${pageContext.request.contextPath}/opensourse/U3",
						         data : formData,
						         cache : false, // 不需要cache
						         processData : false, // jQuery預設會把data轉為query String, 所以要停用
						         contentType : false, // jQuery預設contentType為'application/x-www-form-urlencoded; charset=UTF-8', 且不用自己設定為'multipart/form-data'
						         dataType : "JSON",
						         success : function(data) {
						          alert_mseage("success")
						         },
						         error : function(data) {
						          console.log("error")
						         }
						        });
					      $.ajax({
						         type : "POST",
						         url : "${pageContext.request.contextPath}/opensourse/U4",
						         data : {bullname:bullname,bullsum:bullsum},
						         cache : false, // 不需要cache
						         success : function(data) {
						          alert_mseage("success")
						         },
						         error : function(data) {
						          console.log("error")
						         }
						        });	
					
					function alert_mseage() {
					 alert("上傳成功");
					 location.reload();
			 
			}
		   }
		});
	
	
	});







</script>











<style>
* {
	box-sizing: border-box;
	font-family: "微軟正黑體";
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.container {
	padding: 30px;
}

.row:after {
	content: "";
	display: table;
	clear: both
}

.column-66 {
	float: left;
	width: 66.66666%;
	padding: 20px;
}

.column-33 {
	float: left;
	width: 33.33333%;
	padding: 20px;
}

.large-font {
	font-size: 48px;
}

.xlarge-font {
	font-size: 56px;
	font-weight: bolder;
	color: #8080C0;
}

.button {
	border: none;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
	background-color: #8080C0;
}

img {
	display: block;
	height: auto;
	max-width: 100%;
}

@media screen and (max-width: 1000px) {
	.column-66, .column-33 {
		width: 100%;
		text-align: center;
	}
	img {
		margin: auto;
	}
}
</style>
<script>
	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
		coll[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var content = this.nextElementSibling;
			if (content.style.display === "block") {
				content.style.display = "none";
			} else {
				content.style.display = "block";
			}
		});
	}
</script>

</html>