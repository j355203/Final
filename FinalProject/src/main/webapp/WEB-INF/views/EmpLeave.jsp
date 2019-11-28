<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>員工請假</title>
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
		<div class="header bg-gradient-info pb-3 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div>
			<h3>&nbsp</h3>
		</div>
		<div>
			<h3>&nbsp</h3>
		</div>

		<div class="container-fluid mt--7">
			<div class="row"></div>

			<!-- 網頁格式程式碼 target="nm_iframe"-->
			<div class="row justify-content-md-center">
				<div class="col-lg-6 text-center">
					<div class="card">
						<h2>申請請假表格 掯</h2>
						<form:form method="post" modelAttribute="leave"
							style="margin:0 auto " id="saveForm">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="lab1">員工編號</label>
										<input type="text" readonly="readonly"
											class="form-control form-control-alternative" id="EMP_NOaa"
											name="EMP_NO" value="${emp.empid}">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
									<label class="lab1">員工姓名</label>
										<div class="input-group input-group-alternative mb-4">
											<input type="text" readonly="readonly"
												class="form-control form-control-alternative" id="ENAME"
												name="ENAME" value="${emp.empname}">
										</div>
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
									<label class="lab1">請假起日</label>
										<div class="input-group input-group-alternative mb-4">
											<input type="date"
												class="form-control form-control-alternative"
												id="dayoffstart" name='dayoffstart' placeholder="請假起始日"
												 value="<fmt:formatDate value='${distributor.regtime }' pattern='yyyy-MM-dd  09:00'/>" >
										</div>

									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
									<label class="lab1">請假訖日</label>
										<div class="input-group input-group-alternative mb-4">
											<input type="date"
												class="form-control form-control-alternative" id="dayoffend"
												name="dayoffend" placeholder="請假結束日">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<form:select id="leavestyle"
												class="form-control form-control-alternative"
												path="leavestyle">
												<form:option value="-1" label="假別" />
												<form:options items="${LeaveMap}" />
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
									<label class="lab1">部門編號</label>
										<div class="input-group input-group-alternative mb-4">
											<input type="text" readonly="readonly"
												class="form-control form-control-alternative" id="deptno"
												name="deptno" value="${emp.depBean.depno}">
										</div>
									</div>
								</div>
							</div>
							
											<input type="hidden"
												class="form-control form-control-alternative" id="verify"
												name="verify" value="未審核">		
							
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<div class="input-group input-group-alternative mb-4">
											<input type="text"
												class="form-control form-control-alternative" id="imgpath"
												name="imgpath" value="${lb.imgpath}" placeholder="請假附加檔案網址">
										</div>
									</div>
								</div>
							</div>


							<div class="text-center">
								<button type="button" class="btn btn-primary"
									onClick="saveLeaveFun();">送出</button>
								<input type="reset" class="btn btn-primary" value="清除" />
								<button type="button" class="btn btn-primary"
									onclick="window.location.href='<c:url value="/empSelect" />'">查詢紀錄</button>
							</div>						
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		function saveLeaveFun() {
			var postData = {
				EMP_NObb : $("#EMP_NOaa").val(),
				ENAME : $("#ENAME").val(),
				dayoffstart : $("#dayoffstart").val(),
				dayoffend : $("#dayoffend").val(),
				leavestyle : $("#leavestyle").val(),
				deptno : $("#deptno").val(),
				verify : $("#verify").val(),
				imgpath : $("#imgpath").val()
			};
			$.ajax({
				type : "POST",
				url : "./saveLeave",
				data : postData,
				success : function(data) {
					console.log(data);
					if (data.returnCode == 0) {
						alert("成功");
					} else {
						alert("失敗");
					}
				}
			});
		}

		// 	  function empSelectfun(){
		// 		  $.ajax({
		// 				type : "GET",
		// 				url : "./FindEmpLeave",
		// 				data : getData

		// 				}
		// 			);
		// 	  }
	</script>
</body>

</html>