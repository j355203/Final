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
<title>課程設定</title>
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
<link href="${pageContext.request.contextPath}/css/eeit10907/de_main.css" rel="stylesheet">

<style>
	* {
		font-family: "微軟正黑體";
	}
</style>
</head>

<body>
	<nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
		<div class="container-fluid">
			<!-- Toggler -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main"
				aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Brand -->
			<a class="navbar-brand pt-0" href="${pageContext.request.contextPath}/"> <img
					src="${pageContext.request.contextPath}/assets/img/brand/blue.png" class="navbar-brand-img"
					alt="...">
			</a>
			<!-- User -->
			<ul class="nav align-items-center d-md-none">
				<li class="nav-item dropdown"><a class="nav-link" href="#" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<div class="media align-items-center">
							<span class="avatar avatar-sm rounded-circle">
								<!-- User Image(Toggle Type)-->
								<img alt="Image placeholder"
									src="${pageContext.request.contextPath}/assets/img/theme/team-4-800x800.jpg">
							</span>
						</div>
					</a>
					<div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right">
						<div class=" dropdown-header noti-title">
							<h6 class="text-overflow m-0">歡迎～</h6>
						</div>
						<a href="${pageContext.request.contextPath}/updpwd/${empid}" class="dropdown-item">
							<i class="ni ni-single-02"></i><span>我的資料</span>
						</a>
						<div class="dropdown-divider"></div>
						<a href="${pageContext.request.contextPath}/logout" class="dropdown-item">
							<i class="ni ni-user-run"></i><span>登出</span>
						</a>
					</div>
				</li>
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
							<button type="button" class="navbar-toggler" data-toggle="collapse"
								data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false"
								aria-label="Toggle sidenav">
								<span></span> <span></span>
							</button>
						</div>
					</div>
				</div>
				<!-- Form -->
				<form class="mt-4 mb-3 d-md-none">
					<div class="input-group input-group-rounded input-group-merge">
						<input type="search" class="form-control form-control-rounded form-control-prepended"
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
		<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
			<div class="container-fluid">
				<!-- Brand -->
				<a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block"
					href="${pageContext.request.contextPath}/">首頁</a>
				<!-- User -->
				<ul class="navbar-nav align-items-center d-none d-md-flex">
					<li class="nav-item dropdown"><a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
							<div class="media align-items-center">
								<span class="avatar avatar-sm rounded-circle">
									<!-- User Image -->
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
							<a href="${pageContext.request.contextPath}/updpwd/${emp.empid}" class="dropdown-item"> <i
									class="ni ni-single-02"></i>
								<span>我的資料</span>
							</a>
							<div class="dropdown-divider"></div>
							<a href="${pageContext.request.contextPath}/logout" class="dropdown-item"> <i class="ni ni-user-run"></i>
								<span>登出</span>
							</a>
						</div>
					</li>
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
				<section class="section03">
					<div class="title3">課程詳細資料</div>

				</section>


				<section class="section02">


					<form>
						<br>
						<table class="tb1" id="ttt">

							<tr class="tr01">
								<td style="font-weight: bolder; "
									colspan="4">詳細資料</td>
							</tr>


							<tr>
								<td style="width: 12%; font-weight: bolder;">學門</td>
								<td style="width: 10%;" colspan="3"></td>

							</tr>


							<tr>
								<td style="font-weight: bolder;">課程名稱</td>
								<td style="width: 12%;" colspan="3"></td>
								<!-- <td></td>
                        <td></td> -->
							</tr>
							<tr>
								<td style="font-weight: bolder;">學分</td>
								<td></td>
								<td style="width: 12%; font-weight: bolder;">上課教室</td>
								<td></td>
							</tr>
							<tr>
								<td style="font-weight: bolder;">開始時間</td>
								<td></td>
								<td style="width: 12%; font-weight: bolder;">結束時間</td>
								<td></td>
							</tr>
							<tr>
								<td style="font-weight: bolder;">修課人數</td>
								<td></td>
								<td style="width: 12%; font-weight: bolder;">滿意度</td>
								<td></td>
							</tr>
				

							<tr>
								<td style="font-weight: bolder;">課程概要</td>
								<td style="width: 12%;" colspan="3"></td>
								<!-- <td></td>
                        <td></td> -->
							</tr>
						</table>
						<br>
						<br>
						<br>
						<table class="tb1" id="ttt3">
							<tr class="tr01">
								<td style="font-weight: bolder"
									colspan="7">滿意度</td>
							</tr>
							<tr>
								<td style="width: 9%;">講師教學邏輯性</td>
								<td style="width: 10%;">講師分析問題講解</td>
								<td style="width: 10%;">課程內容實務導向性</td>
								<td style="width: 8%;">課程資料實用性</td>
								<td style="width: 8%;">講師總體評價</td>
								<td style="width: 8%;">課程總體評價</td>
								<td style="width: 5%;">總體評價</td>
							</tr>
						</table>
						<br>
						<br>
						<br>
						<table class="tb1" id="ttt2">
							<tr class="tr01">
								<td style="font-weight: bolder;"
									colspan="9">選課名單與評價</td>
							</tr>
							<tr>
								<td style="width: 5%;">員工編號</td>
								<td style="width: 8%;">員工姓名</td>
								<td style="width: 9%;">講師教學邏輯性</td>
								<td style="width: 10%;">講師分析問題講解</td>
								<td style="width: 10%;">課程內容實務導向性</td>
								<td style="width: 8%;">課程資料實用性</td>
								<td style="width: 8%;">講師總體評價</td>
								<td style="width: 8%;">課程總體評價</td>
								<td style="width: 5%;">總體評價</td>
							</tr>
						</table>
						<br>

					</form>
					<br> <br><br>
				</section>
<br> <br>
				<section class="section05 ">
					<div class="div6 ">如有任何問題請洽人力資源部 教育訓練課 葉小姐 電話：02-1234567#123</div>
				</section>

			</div>
			<%-- end content --%>



				<br>
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

<script>
	$(function() {
		CourseID = $("#CourseID_in", window.opener.document).val(); //抓取前一頁的ID
	})
</script>
<script>

		$(document).ready(function()
		{
			CourseID=$("#CourseID_in",window.opener.document).val();//取得前一頁的值
			SubjectID=$("#SubjectID_in",window.opener.document).val();//取得前一頁的值
			console.log(CourseID);
			console.log(SubjectID);
			a(CourseID);
			b(CourseID);
			c(CourseID,SubjectID);
			
			//課程詳細
			function a(CourseID) 
			{
				 $.ajax({
				  url : "${pageContext.request.contextPath}/opencourseall/Q7",
					 data:{CourseID:CourseID},
				  type : "GET",
				  dataType:"JSON",
				  success : function(data) {
					  console.log(data);
				   showNames(data);
				  }
				 });
				 function showNames(data) 
				 {
					 var str =""
				    	
					 for (var i = 0; i < 1; i++) {
						    	str = str + "<tr>"+
								"<td style='display:none;'><hidden>"+data[i].CourseID+"</hidden ></td></tr>"+
								"<tr class='tr01'>"+
		                        "<td style='font-weight:bolder;' colspan='4'>詳細資料</td>"+
		                    	"</tr>"+
								"<tr>"+
								"<td style='width: 10%'>學門</td>"+
								"<td style='width: 10%;' colspan='3'>"+data[i].SubjectName+"</td>"+
								"</tr>"+
								"<tr>"+
								"<td style='width: 20%'>課程名稱</td>"+
								"<td style='width: 10%;' colspan='3'>"+data[i].CourseName+"</td>"+
								"</tr>"+
								"<tr >"+
								"<td style='width: 10%'>學分</td>"+
								"<td style='width: 10%;'>"+data[i].Credits+"</td>"+
								"<td style='width: 10%'>上課教室</td>"+
								"<td style='width: 10%;'>"+data[i].RoomName+"</td>"+
								"</tr>"+
								"<tr>"+
								"<td style='width: 10%'>開始時間</td>"+
								"<td style='width: 10%;'>"+data[i].StartDateTime+"</td>"+
								"<td style='width: 5%'>結束時間</td>"+
								"<td style='width: 10%;'>"+data[i].EndDateTime+"</td>"+
								"</tr>"+
								"<tr>"+
								"<td style='width: 10%'>概要</td>"+
								"<td style='width: 10%;' colspan='3'>"+data[i].CourseSummary+"</td>"+
								"</tr>";

	                        console.log(data[i]);    
	                    }
					 $("#ttt").html(str) 
				 }
			}
		
			 
			 
			 
			//有選課的人
			 function b(CourseID) 
				{
					 $.ajax({

					  url : "${pageContext.request.contextPath}/opencourseall/Q8",
						 data:{CourseID:CourseID},
					  type : "GET",
					  dataType:"JSON",
					  success : function(data) {
					   showNames(data);
					  }
					 });
					 
					 function showNames(data) 
					 {
						  console.log(data);
						 var str ="<tr class='tr01'>"+
		                        "<td style='font-weight:bolder;' colspan='9'>選課名單與評價</td>"+
		                        "</tr>"+
		                        "<tr >"+
		                        "<td style='width: 10%'> 員工編號</td>"+
		                        "<td style='width: 10%'> 員工姓名</td>"+    
								"<td style='width: 10%'> 教學邏輯性</td>"+
								"<td style='width: 11%'> 分析問題講解</td>"+
								"<td style='width: 10%'> 內容實務導向</td>"+
								"<td style='width: 10%'> 資料實用</td>"+
								"<td style='width: 8%'> 講師<br>總體評價</td>"+
								"<td style='width: 8%'> 課程<br>總體評價</td>"+
								"<td style='width: 10%'> 總體評價</td>"+
		                    	"</tr>";
					    	
						 for (var i = 0; i < data.length; i++) {
							    	str = str +
									"<tr>"+
									"<td style='width: 10%;'>"+data[i].empid+"</td>"+
									"<td style='width: 10%;'>"+data[i].empname+"</td>"+
									"<td style='width: 10%;'>"+data[i].TeacherQ1+"</td>"+
									"<td style='width: 10%;'>"+data[i].TeacherQ2+"</td>"+
									"<td style='width: 10%;'>"+data[i].ContentQ1+"</td>"+
									"<td style='width: 10%;'>"+data[i].ContentQ2+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisTeacher+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisContent+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisfaction+"</td>"+
									"</tr>";
		                    }
						 $("#ttt2").html(str) 
					 }
				}
			
			//總體滿意度
			 function c(CourseID,SubjectID) 
				{
					 $.ajax({

					  url : "${pageContext.request.contextPath}/opencourseall/Q9",
					  data:{CourseID:CourseID,SubjectID : SubjectID},
					  type : "GET",
					  dataType:"JSON",
					  success : function(data) {
					   showNames(data);
					  }
					 });
					 
					 function showNames(data) 
					 {
						  console.log(data);
						 var str ="<tr class='tr01'>"+
		                        "<td style='font-weight:bolder;' colspan='9'>課程滿意度總平均</td>"+
		                        "</tr>"+
		                        "<tr >"+ 
								"<td style='width: 10%'> 講師教學邏輯性</td>"+
								"<td style='width: 11%'> 講師分析問題講解</td>"+
								"<td style='width: 10%'> 課程內容實務導向</td>"+
								"<td style='width: 10%'> 課程資料實用</td>"+
								"<td style='width: 8%'> 講師總體評價</td>"+
								"<td style='width: 8%'> 課程總體評價</td>"+
								"<td style='width: 10%'> 總體評價</td>"+
		                    	"</tr>";

		                    	
						 for (var i = 0; i < data.length; i++) {
							    	str = str +
									"<tr>"+

									"<td style='width: 10%;'>"+data[i].TeacherQ1+"</td>"+
									"<td style='width: 10%;'>"+data[i].TeacherQ2+"</td>"+
									"<td style='width: 10%;'>"+data[i].ContentQ1+"</td>"+
									"<td style='width: 10%;'>"+data[i].ContentQ2+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisTeacher+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisContent+"</td>"+
									"<td style='width: 10%;'>"+data[i].MySatisfaction+"</td>"+
									"</tr>";
		                    }
						 $("#ttt3").html(str) 
					 }
				}
				
				 
					 
			
		 });


</script>
</html>