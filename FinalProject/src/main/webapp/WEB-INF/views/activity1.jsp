<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>活動詳細</title>
<!-- Fonts -->
<style>
.card1 {
	position: relative;
	flex-direction: column;
	min-width: 0;
	height: 550px;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 3px solid rgba(0, 0, 0, 0.05);
	border-radius: 0.375rem;
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
		<div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7">

			<div class="row justify-content-md-center">
				<div class="col-lg-4">
					<div class="card1 justify-content-center" style="width: 100%">
						<form:form method="POST" modelAttribute="updActivity">

							<div class="caption">
								<div class="thumbnail text-center">
									<img width='300' height='200'
										src="<c:url value='/getPicture/${activity1.activityId}'/>" />
									<p>活動 ID :${activity1.activityId}</p>
									<p>活動標題:${activity1.title}</p>
									<p>活動時間:${activity1.activityTime }</p>
									<p>活動地點:${activity1.activityAddress }</p>
									<p>${activity1.quantity}</p>
									<p>活動內容:${activity1.content}</p>
									<p>
										<input type="button" class="btn btn-primary"
											onclick="window.location.href='<c:url value="userActivity" />'"
											value="返回">
									</p>
								</div>

							</div>
						</form:form>
					</div>

				</div>

			</div>
		</div>
	</div>


	<!--   Core   -->
</body>

</html>