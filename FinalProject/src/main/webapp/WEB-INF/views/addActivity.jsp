<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>新增活動</title>
<!-- Fonts -->
<script type="text/javascript">
	function demo1() {
		document.getElementById("title").value = '基隆一日遊';
		$('#activityStatus[value="1"]').attr("checked", true);
		document.getElementById("activityAddress").value = '基隆';
		document.getElementById("activityTime").value = '2020-01-04';
		document.getElementById("content").value = '情人湖公園-和平島公園-正濱漁港-大坪海岸';
	}
	-->
</script>


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
					<div class="card justify-content-center" style="width: 100%">
						<form:form method="post" modelAttribute="activityBean"
							action="addActivity" enctype="multipart/form-data">

							<h1 class="text-center">新增活動</h1>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="title"> 活動標題 : </label>
								<form:input id="title" name="title" path="title" type="text"
									class="form:input-large" value="" />
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="activityTime"> 活動時間 :
								</label>
								<form:input id="activityTime" name="activityTime"
									path="activityTime" type="text" class="form:input-large"
									value="" />
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="activityAddress">
									活動地點: </label>
								<form:input id="activityAddress" name="activityAddress"
									path="activityAddress" type="text" class="form:input-large"
									value="" />
							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="activityStatus"> 活動狀態
									: </label>
								<form:radiobutton id="activityStatus" path="activityStatus"
									value="1" />
								上架
								<form:radiobutton id="activityStatus" path="activityStatus"
									value="2" />
								下架

							</div>
							<div class="form-group row justify-content-center mt-2">
								<label class='control-label ' for="content"> 內容 : </label>
								<form:input id="content" name="content" path="content"
									type="text" class="form:input-large" value="" />
							</div>
							<div class="form-geoup">

								<div class="text-center">
									<form:input type='file'
										accept="image/gif, image/jpeg, image/png" id="activityImage"
										path="activityImage" class="form:input-lagge" />
								</div>
							</div>
							<div class="row justify-content-center">
								<input type="submit" id="" class='btn btn-primary' value="送出">
								<input type="button" class="btn btn-primary" onclick="demo1()"
									value="Demo用" />
							</div>
						</form:form>

					</div>


				</div>
			</div>

		</div>


		<!--   Core   -->
</body>

</html>