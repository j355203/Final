<%@page import="finalProject.eeit10911.model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh-TW">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>查詢分類</title>


</head>

<body>
	<!-- 載入左側導覽列 -->
	<nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
		<jsp:include page="LeftNav.jsp" />
	</nav>
	<!-- 載入左側導覽列 -->

	<div class="main-content">
		<!-- 載入上方導覽列 -->
		<nav class="navbar navbar-top navbar-expand-md navbar-dark" id="navbar-main">
			<jsp:include page="HeadNav.jsp" />
		</nav>
		<!-- 載入上方導覽列 -->
		<style>
			.fr1 {
				width: 600px;
				margin: 10px auto;
				border-bottom: 1px solid #808000;
				padding-bottom: 3px;
			}

			.sub1 {
				width: 700px;
				margin: 10px;
				text-align: center;
			}

			.lab1 {
				width: 90px;
				float: left;
				text-align: right;
			}

			fieldset {
				width: 700px;
				border: 2px solid;
				border-color: saddlebrown;
				background-color: snow
			}

			textarea {
				resize: none;
			}

			form {
				margin: auto 170px;
			}

			select,
			option,
			input,
			textarea {
				background-color: white;
			}

			p.p1 {
				color: grey;
				font-size: 12px;
				margin-top: 6px;
				margin-bottom: 5px;
			}
		</style>
		<!-- Header -->
		<div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row">
						<!-- <h2 class="formtop">文章總覽</h2> -->
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7">
			<div class="row">
				<div class="row justify-content-md-center">
					<div class="col-lg-10">
						<h1 style="margin-left: 450px;">查詢分類文章</h1>
						<form:form method="POST" modelAttribute="SelectArticleByClass">
							<fieldset>
								<!-- <legend>查詢分類</legend> -->
								<div class="fr1">
									<label for="class" class="lab1">選擇分類：</label>
									<form:select style="margin-bottom: 6px;"
										class="form-control form-control-alternative" id="class" name="articleClass"
										path="articleClass">
										<form:options items="${classMap}" />
									</form:select>
								</div>
							</fieldset>
							<div class="sub1">
								<input class="btn btn-default" type="submit" value="送出">
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>

</html>