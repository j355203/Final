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
<title>查詢活動</title>
<!-- Fonts -->
<style>
.card7 {
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

<style>
.card1 {
	position: relative;
	flex-direction: column;
	min-width: 0;
	height: 600px;
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
			<div class="row"></div>
			<div class="row justify-content-md-center">
				<div class="col-lg-4">
					<div class="card7 justify-content-center" style="width: 100%">
						<%-- 					<c:forEach items="${activity}" var="activity1"> --%>
						<div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
							<div class="thumbnail text-center"
								style="width: 320px; height: 340px">
								<div class="caption">

									<img width='300' height='200'
										src="<c:url value='/getPicture/${activity.activityId}'/>" />
									<p class="text-center">活動ID:${activity.activityId }</p>
									<p class="text-center">活動標題:${activity.title}</p>
									<p class="text-center">活動時間:${activity.activityTime }</p>
									<p class="text-center">活動地點:${activity.activityAddress }</p>
									<p class="text-center">活動狀態:${activity.activityStatus}</p>
									<%-- 									<p>活動人數:${activity.quantity }</p> --%>
									<p class="text-center">活動內容:${activity.content }</p>
								
								<input type="button" class="btn btn-primary"
									onclick="window.location.href='<c:url value="modifyActivity/${activity.activityId}" />'"
									value="修改"> 
									<input type="button"
									class="btn btn-primary"
									onclick="window.location.href='<c:url value="activity" />'"
									value="返回">
                                   </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%-- 					</c:forEach> --%>


		</div>


		<!--   Core   -->
</body>

</html>