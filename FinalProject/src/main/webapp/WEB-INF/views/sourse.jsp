<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>學習園地</title>
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
	href="${pageContext.request.contextPath}/css/eeit10907/sourse.css">


<!-- jquery -->
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- jquery -->
<!--.active,
		.collapsible:hover {
			
		}-->
<style>
.collapsible {
	background-color: #2894FF;
	color: white;
	cursor: pointer;
	padding: 18px;
	width: 100%;
	border: none;
	text-align: left;
	outline: none;
	font-size: 20px;
	font-weight: bolder;
}

.content {
	padding: 0 18px;
	display: none;
	overflow: hidden;
	background-color: 	#ECF5FF;
}

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
								src="${pageContext.request.contextPath}/assets/img/theme/team-11-800x800.jpg">
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
					<br>
					<div class="title3">開放資源</div>
					<div>

						<span class="bottonspan01"> <a
							href="${pageContext.request.contextPath}/Learningindex">
								<button class="bottonstyle01" type="button" value="select">&lt;
									公告區</button>
						</a>
						</span>
					</div>
					<br> 
					<br>
					<hr>
				</section>
				<!-- Clarity Section -->
			</div>

			<div class="container">
				<div class="row">
					<div>

						<h1 class="large-font" style="color: black;">
							<b>開放教學影片</b>
						</h1>
						<p>
							<span style="font-size: 24px;color:#5B5B5B">此處公開學習資料，是由一群資深的講師與資深同仁經過篩選後，適合關閱的教學影片
						</p>
						<span style="font-size: 24px;color:#5B5B5B">您可以自行選擇類別，點擊影片線上學習.
						</p>
					</div>
				</div>
				<br>
				<button class="tablink" onclick="openPage('Java', this, '#2894FF')"id="defaultOpen">Java</button>
				<button class="tablink" onclick="openPage('SQL', this, '#2894FF')">SQL</button>
				<button class="tablink" onclick="openPage('HTML', this, '#2894FF')">HTML</button>
				<button class="tablink" onclick="openPage('JavaScript', this, '#2894FF')">JavaScript</button>
				
				
				
				
				<div id="Java" class="tabcontent"></div>
				<div id="SQL" class="tabcontent"></div>
				<div id="HTML" class="tabcontent"></div>
				<div id="JavaScript" class="tabcontent"></div>

				
				
				
				
				
				<script>
				
				

				function openPage(pageName, elmnt, color) {
					var i, tabcontent, tablinks;
					tabcontent = document
							.getElementsByClassName("tabcontent");
					for (i = 0; i < tabcontent.length; i++) {
						tabcontent[i].style.display = "none";
					}
					tablinks = document.getElementsByClassName("tablink");
					for (i = 0; i < tablinks.length; i++) {
						tablinks[i].style.backgroundColor = "";
					}
					document.getElementById(pageName).style.display = "block";
					elmnt.style.backgroundColor = color;
				}

				// Get the element with id="defaultOpen" and click on it
				document.getElementById("defaultOpen").click();
				</script>
				
				
			</div>
			<br>
			<div>
				<hr>





				<!-- Clarity Section -->
				<div class="container">
					<div class="row">
						<div>

							<h1 class="large-font" style="color: black;">
								<b>教學講義及文件</b>
							</h1>
							<p>
								<span style="font-size: 24px;color:#5B5B5B">此處為公開學習資料，由一群資深的講師與資深同仁編寫而成的學習文件。
							</p>
							<span style="font-size: 24px;color:#5B5B5B">您可以自行選擇類別下載想要學習的檔案資源.
								</p>
						</div>
					</div>
					<br>
					<button type="button" class="collapsible">Java文件</button>
					<!-- W3C 可擇跌 -->
					<div class="content">
					<br>
				
						<table class="tb1" id="java_file">
						</table>
						<br>
					</div>
					<button type="button" class="collapsible">SQL文件</button>
					<div class="content">
					<br>
						<table class="tb1" id="sql_file">
						</table>
						<br> <br>
					</div>
					<br>
				</div>

				<br> <br> <br>
			</div>
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





<script>
$(document).ready(function() {
			//下載檔案
			function upimg1() {
					var UpFileID = 'D1';
					$.ajax({
						url : "${pageContext.request.contextPath}/sourse/Q1",
						data : {UpFileID:UpFileID},
						type : "POST",
						dataType : "JSON",
						success : function(data) {
							showNames(data);
							console.log(data);
						}
					});
			}

			function showNames(data) {
				var str ="<tr class='tr01'>"
						+"<td  style='width: 50%;'>檔案名稱</td>"
						+"<td style='width: 10%'>下載</td>"
						+"</tr>"
				for (var i = 0; i < data.length; i++) {
					str =str+"<tr>"
							+"<td  style='width: 50%;'>"+data[i].UpFileName+"</td>"
							+"<td style='width: 10%;'><a href='"+data[i].UpFileURL+"' download='"+data[i].UpFileName+"'><button class='bottonstyle03' type='button' onclick='download1()'>點選下載</button></a></td>"
							+"</tr>";
				}
				$("#java_file").html(str)
			}
			
			
			function upimg2() {
				var UpFileID = 'D2';
				$.ajax({
					url : "${pageContext.request.contextPath}/sourse/Q1",
					data : {UpFileID:UpFileID},
					type : "POST",
					dataType : "JSON",
					success : function(data) {
						showNames2(data);
						console.log(data);
					}
				});
			}	

			function showNames2(data) {
				var str ="<tr class='tr01'>"
						+"<td  style='width: 50%;'>檔案名稱</td>"
						+"<td style='width: 10%'>下載</td>"
						+"</tr>"
				for (var i = 0; i < data.length; i++) {
					str =str+"<tr>"
							+"<td  style='width: 50%;'>"+data[i].UpFileName+"</td>"
							+"<td style='width: 10%;'><a href='"+data[i].UpFileURL+"' download='"+data[i].UpFileName+"'><button class='bottonstyle03' type='button' onclick='download1()'>點選下載</button></a></td>"
							+"</tr>";
				}
				$("#sql_file").html(str)
			}
			
			
			
			upimg1();
			upimg2();
			
			
			
			
			
			//顯示應片
			function upvideo() {
					$.ajax({
						url : "${pageContext.request.contextPath}/sourse/Q2",
						type : "POST",
						dataType : "JSON",
						success : function(data) {
							console.log(data);
							test(data);
						}
					});
			}
			function test(data) {
				var str ="";
				var a=["Java","SQL","HTML","JavaScript"];
				console.log(a[3]);
				for (var i = 0; i < data.length; i++) {
				    str = "<p><div style='width: 30%; height: 400px; padding: 20px; float: left;'>"
						+"<div style='float: left; margin-left: 10%; font-size: 20px;color:black'>影片名稱："+data[i].UpMovieName+"</div>"
						+"&nbsp;"
						+"<div style='float: left; margin-left: 10%; font-size: 20px;color:black'>內容概要："+data[i].UpMovieSum+"</div>"
						+"</div>"
						+"<iframe class='iframe21' style='width: 500px; height: 300px'"
						+" src='"+data[i].UpMovieURL+"' frameborder='0'"
						+" allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture'"
						+" allowfullscreen></iframe></p>";
						
					$("#"+a[i]+"").html(str)
				}
				

			}

			upvideo();
			});
</script>


					
						
						
						

					

					
						
						
						








<style>
* {
	box-sizing: border-box;
	font-family: "微軟正黑體";
}
.tb1 {
    /* border: 3px solid #cf9e9e; */
    width: 95%;
    border-collapse: collapse;
    /*border-left: 5px solid 		#2894FF; */
    text-align: center;
    line-height: 40px;
    padding: 0px;
    margin: 0px auto;

}
.tr01 {
     /* background-color:#D2E9FF;#2894FF*/
     line-height:40px;
    font-weight:bolder;
    font-size: 40px;
    /* 選課紀錄的表頭 */
    color:black;
     border-bottom: 5px solid #2894FF;
    }

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.container {
	padding: 30px;
	width: 80%;
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
}

.button {
	border: none;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
	background-color: #2894FF;
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
<style>
* {
	box-sizing: border-box
}

/* Set height of body and the document to 100% */
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

/* Style tab links */
.tablink {
	background-color: 	#84C1FF;
	color: white;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 17px;
	width: 25%;
}

.tablink:hover {
	background-color:  #2894FF;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: white;
	display: none;
	padding: 20px 20px;
	height: auto;
}

#Java {
	background-color: 	#ECF5FF;
	
}

#SQL {
	background-color: 	#ECF5FF;
}

#HTML {
	background-color: 	#ECF5FF;
}

#JavaScript {
	background-color: 	#ECF5FF;	
}
</style>

</html>