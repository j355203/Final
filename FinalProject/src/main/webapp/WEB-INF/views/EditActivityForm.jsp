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
<title>修改活動</title>
<style>
.card10 {
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
					<div class="card10 justify-content-center" style="width: 100%">
						<form:form method="POST" modelAttribute="updActivity"
							enctype='multipart/form-data'>
							<h1 class="text-center">修改活動</h1>
							<div class="col-sm-6 col-md-3"
								style="width: 360px; height: 360px">
								<div class="thumbnail" style="width: 320px; height: 340px">

									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="activityId"> 活動ID:
										</label>
										<form:input id="activityId" readonly="true" path="activityId"
											type="text" class="form:input-large" />
									</div>

									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="title"> 活動標題: </label>
										<form:input id="title" path="title" type="text"
											class="form:input-large" />
									</div>
									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="activityTime">
											活動時間:</label>
										<form:input id="activityTime" path="activityTime" type="text"
											class="form:input-large" />
									</div>
									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="activityAddress">活動地點:
										</label>
										<form:input id="activityAddress" path="activityAddress"
											type="text" class="form:input-large" />
									</div>
									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="activityStatus">活動狀態:
										</label>
										<%-- 										<form:input id="activityStatus" path="activityStatus" --%>
										<%-- 											type="text" class="form:input-large" /> --%>
										<form:radiobutton id="activityStatus" path="activityStatus"
											value="1" />上架
										<form:radiobutton id="activityStatus" path="activityStatus"
											value="2" />下架
									</div>
									<div class="form-group row justify-content-center mt-2">
										<label class='control-label ' for="content"> 內容: </label>
										<form:textarea id="content" path="content" type="text"
											class="form:input-large" />
									</div>

									<div class="form-geoup">

										<div class="text-center">
											<form:input type='file'
												accept="image/gif, image/jpeg, image/png" id="activityImage"
												path="activityImage" class="form:input-lagge"
												onChange="readURL(this)" />
										</div>
									</div>
									<br>
									<div class="text-center" >
										<input class="btn btn-primary" type='submit' value='修改' />
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>





		<!--   Core   -->
</body>

</html>