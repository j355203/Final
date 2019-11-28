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
<link href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/css/eeit10907/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css"
	rel="stylesheet" />
<%-- CSS Files --%>
<link href="${pageContext.request.contextPath}/css/eeit10907/assets/css/argon-dashboard.css?v=1.1.0" rel="stylesheet" />

<%-- jquery --%>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

<link href="${pageContext.request.contextPath}/css/eeit10907/index2.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/eeit10907/emp_main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/eeit10907/emp_employee.css" rel="stylesheet">
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
			<div class="container-fluid" style="background-color:#FFFFFF!important">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7" style="margin-top: -6rem !important">
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
					<div class="title3">員工設定</div>
					<div>

						<span class="bottonspan01"> <a
							href="${pageContext.request.contextPath}/title.html"><button class="bottonstyle01"
									type="button" value="select">&lt; 職稱設定</button></a>
						</span>
					</div>
					<br>
					<div>&emsp;</div>
					<hr>
					<br>
				</section>
				
				
				<br>
				<!-- The App Section -->
				<br> <br>
				<div>&emsp;</div>
				<section class="section02">
					<div class="title1">查詢員工學分</div>
					<form>
						<div class="div1">

							<div class="div2">
								<div class="font1">員工編號：</div>
								<div>
									<input style="width: 50%; height: 28px;" type="text"
										id="employeeid_q1" name="employeeid_q1">
								</div>
							</div>

							<div class="div2">
								<div class="font1">員工姓名：</div>
								<div>
									<input style="width: 50%; height: 28px;" type="text"
										id="employeename_q1" name="employeename_q1">

								</div>
							</div>


						</div>

						<div class="div4">
							<button class="bottonstyle02" type="button"
								onclick="employee_q1()">查詢</button>
							<input class="bottonstyle02" type="reset" value="清除">

							<button class="bottonstyle02" type="button"
								onclick="employeenull_q1()">未設定區</button>
						</div>
						<br><br>
					</form>
					<input style="display: none;" id="EmployeeID_in" type="text"
						size="7">
					<table class="tb1" id="ttt">
						<tr class="tr01">
							<td style="width: 5%">員工編號</td>
							<td style="width: 5%">員工姓名</td>
							<td style="width: 5%">職稱代碼</td>
							<td style="width: 8%">職稱名稱</td>
							<td style="width: 10%">學門</td>
							<td style="width: 5%">修課紀錄</td>
							<td style="width: 4%">修改</td>
						
						</tr>

					</table>
					<br>
					<br>
					<br>
				</section>

				<br>
				<%-- end content --%>
<br>

			<section class="section05 ">
				<div class="div6 ">如有任何問題請洽人力資源部 教育訓練課 葉小姐 電話：02-1234567#123</div>
			</section>




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
//存放員工編號

var winObj1,winObj2; 
function ShowMeDate2(){
	var windowEvent = window.event; //當視窗有事件時
	var data = $(windowEvent.target).closest("tr");// 尋找最近tr的資料位置     //
	var empid=(data[0].cells[0].textContent);
	console.log(data[0].cells[0].textContent);
	$('#EmployeeID_in').val(empid);
}

//詳細課程資料
		var winObj1,winObj2; 
		function ShowMeDate1(){
			var windowEvent = window.event; //當視窗有事件時
			var data = $(windowEvent.target).closest("tr");// 尋找最近tr的資料位置     //
			var empid=(data[0].cells[0].textContent);
			console.log(data[0].cells[0].textContent);
			$('#EmployeeID_in').val(empid);
			winObj1 = window.open("${pageContext.request.contextPath}/detailcourse4"); //開啟一個頁面
		}
<%--參考網址 https://stackoverflow.com/questions/27654298/jquery-refresh-reload-page-if-ajax-success-after-time--%>
	
	

</script>
<script>
<%-- 用員工編號查--%>
	function employee_q1() {
		var windowEvent = window.event; //當視窗有事件時
		var empid=$('#employeeid_q1').val();
		var empname=$('#employeename_q1').val();
		console.log(empid);
		console.log(empname);
		a(empid);
		b(empname);
	};
	function a(empid){
		 $.ajax({
		  url : "${pageContext.request.contextPath}/employee/Q1",
		data:{empid:empid},
		  type : "POST",
		  dataType:"JSON",
		  success : function(data) {  
			  showcolws(data);
		  }
		});
		 
		 function showcolws(data) 
		 {
			 var str ="<tr class='tr01'>"+
				"<td style='display:none;'><hidden>empid</hidden ></td>"+
				"<td style='width: 5%'>員工編號</td>"+
				"<td style='width: 5%'>員工姓名</td>"+
				"<td style='width: 5%'>職稱代碼</td>"+
				"<td style='width: 8%'>職稱名稱</td>"+
				"<td style='width: 10%'>學門</td>"+
				"<td style='width: 5%'>修課紀錄</td>"+
				"<td style='width: 4%'>修改</td>"+
				
			"</tr>"
			 for (var i = 0; i < data.length; i++) {
				    	str = str + "<tr class='tr02'>"+
				    	"<td style='display:none;'><hidden>"+data[i].empid+"</hidden ></td>"+
						"<td>"+data[i].empid+"</td>"+
						"<td>"+data[i].empname+"</td>"+
						"<td>"+data[i].TitleNO+"</td>"+
						"<td>"+data[i].TitleName+"</td>"+
						"<td>"+data[i].PreSubject_Name+"</td>"+
						"<td><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate1()'>修課紀錄</button></td>"+
						"<td><a href='${pageContext.request.contextPath}/updateemployee?empid="+data[i].empid+"'><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate2()'>修改</button></a></td>"+
						
						"</tr>" 
                }

			 $("#ttt").html(str)
		 }
		 
	}
	
	//用員工名稱查詢
	function b(empname){
		 $.ajax({
		  url : "${pageContext.request.contextPath}/employee/Q2",
			data:{empname:empname},
		  type : "GET",
		  dataType:"JSON",
		  success : function(data) {  
			  showcolws(data);
		  }
		});
		 
		 function showcolws(data) 
		 {
			 var str ="<tr class='tr01'>"+
				"<td style='display:none;'><hidden>empid</hidden ></td>"+
				"<td style='width: 5%'>員工編號</td>"+
				"<td style='width: 5%'>員工姓名</td>"+
				"<td style='width: 5%'>職稱代碼</td>"+
				"<td style='width: 8%'>職稱名稱</td>"+
				"<td style='width: 10%'>學門</td>"+
				"<td style='width: 5%'>修課紀錄</td>"+
				"<td style='width: 4%'>修改</td>"+
				
			"</tr>"
			 for (var i = 0; i < data.length; i++) {
				    	str = str + "<tr class='tr02'>"+
				    	"<td style='display:none;'><hidden>"+data[i].empid+"</hidden ></td>"+
						"<td>"+data[i].empid+"</td>"+
						"<td>"+data[i].empname+"</td>"+
						"<td>"+data[i].TitleNO+"</td>"+
						"<td>"+data[i].TitleName+"</td>"+
						"<td>"+data[i].PreSubject_Name+"</td>"+
						"<td><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate1()'>修課紀錄</button></td>"+
						"<td><a href='${pageContext.request.contextPath}/updateemployee?empid="+data[i].empid+"'><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate2()'>修改</button></a></td>"+
						
						"</tr>" 
                }
			 $("#ttt").html(str)
		 }
		 
	}
	
	
	//未設定區
	function employeenull_q1() {
		var windowEvent = window.event; //當視窗有事件時
		c();
	};
	function c(){
		console.log('123')
		 $.ajax({
		  url : "${pageContext.request.contextPath}/employee/Q3",
		  data:{},
		  type : "GET",
		  dataType:"JSON",
		  success : function(data) {  
			  showcolws(data);
		  }
		});
		 
		 function showcolws(data) 
		 {
			 var str ="<tr class='tr01'>"+
				"<td style='display:none;'><hidden>empid</hidden ></td>"+
				"<td style='width: 5%'>員工編號</td>"+
				"<td style='width: 5%'>員工姓名</td>"+
				"<td style='width: 5%'>職稱代碼</td>"+
				"<td style='width: 8%'>職稱名稱</td>"+
				"<td style='width: 10%'>學門</td>"+
				"<td style='width: 5%'>修課紀錄</td>"+
				"<td style='width: 4%'>修改</td>"+
				
			"</tr>"
			 for (var i = 0; i < data.length; i++) {
				    	str = str + "<tr class='tr02'>"+
				    	"<td style='display:none;'><hidden>"+data[i].empid+"</hidden ></td>"+
						"<td>"+data[i].empid+"</td>"+
						"<td>"+data[i].empname+"</td>"+
						"<td>"+data[i].TitleNO+"</td>"+
						"<td>"+data[i].TitleName+"</td>"+
						"<td>"+data[i].PreSubjectID+"</td>"+
						"<td><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate1()'>修課紀錄</button></td>"+
						"<td><a href='${pageContext.request.contextPath}/updateemployee?empid="+data[i].empid+"'><button class='bottonstyle03' "+
						"type='button' onclick='ShowMeDate2()'>修改</button></a></td>"+
						
						"</tr>" 
                }
			 $("#ttt").html(str)
		 }
		 
	}
	
</script>
</html>