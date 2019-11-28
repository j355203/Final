<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head></head>

<body>

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
						<a href="${pageContext.request.contextPath}/"> <img
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
						<c:if test="${sessionScope.emplevel>=9}">
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/storemanage" title="店家管理"> 
							<i class="fas fa-store-alt text-success"></i> 店家管理
						</a>
						<a class="nav-link dropdown-item"
							href="${pageContext.request.contextPath}/ordermanage" title="訂單確認">
							<i class="fas fa-clipboard-check"></i> 訂單報表
						</a>
						</c:if>
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


	<!--   Core   -->
	<script
		src="${pageContext.request.contextPath}/assets/js/plugins/jquery/dist/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<!--   Optional JS   -->
	<script
		src="${pageContext.request.contextPath}/assets/js/plugins/chart.js/dist/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
	<!--   Argon JS   -->
	<script
		src="${pageContext.request.contextPath}/assets/js/argon-dashboard.min.js?v=1.1.0"></script>
	<script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>

</body>

</html>