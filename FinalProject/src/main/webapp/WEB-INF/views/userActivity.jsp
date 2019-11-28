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
<title>使用者活動</title>
<!-- Fonts -->
</head>
<style>
.card2 {
	position: relative;
	flex-direction: column;
	min-width: 0;
	height: 500px;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 3px solid rgba(0, 0, 0, 0.05);
	border-radius: 0.375rem;
}
</style>

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
		<div class="container-fluid mt--7 ">

			<div class="row ">
				<!-- 		justify-content-md-center  justify-content-center-->
				<c:forEach var='userActivity' items='${userActivity}'>
					<div class="col-lg-4  ">
						<div class="card2 justify-content-center" style="width: 100%">


							<div class="caption ">
								<div class="thumbnail text-center">
									<img width='300' height='200'
										src="<c:url value='/getPicture/${userActivity.activityId}'/>" />
									<p>活動 ID :${userActivity.activityId }</p>
									<p>活動標題:${userActivity.title}</p>
									<p>活動時間:${userActivity.activityTime}</p>
									<p>活動地點:${userActivity.activityAddress}</p>
									<p>${userActivity.quantity}</p>
									<p>
										<input type="button" class="btn btn-primary"
											onclick="window.location.href='<c:url value="/activity1?activityId=${userActivity.activityId}" />'"
											value="詳細內容"> 
										<c:choose>
											<c:when test="${regis eq 'true'} }">
												<input type="button" class="btn btn-primary" value="已報名">
											</c:when>
											<c:otherwise>
												<input type="button"
													class="btn btn-primary"
													onclick="window.location.href='<c:url value="/addRegistrationForm/${userActivity.activityId}" />'"
													value="報名">
											</c:otherwise>
										</c:choose>

									</p>
								</div>
							</div>
						</div>
					</div>


				</c:forEach>
			</div>
		</div>
	</div>









	<!--   Core   -->
</body>

</html>