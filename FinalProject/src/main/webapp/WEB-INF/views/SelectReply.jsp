<%@page import="finalProject.eeit10911.model.Article"%>
<%@page import="finalProject.eeit10911.model.Reply"%>
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
	<title>RE：${AB.topic}</title>

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
			.articleTable {
				margin-left: 100px;
			}

			table {
				border-collapse: separate;
				border-spacing: 0;
				border: 2px solid #000080;
				margin: center;
				width: 800px;
				height: 600px;
				margin-bottom: 8px;
				border-radius: 10px;
			}

			th,
			tb {
				border-collapse: separate;
			}

			th {
				border-bottom: 1px solid #000080;
			}

			.classID {
				width: 100px;
				height: 24px;
				text-align: center;
				border-right: 1px solid #000080;
			}

			.topic {
				width: 700px;
				height: 24px;
				text-align: center;
			}

			.articleID {
				width: 200px;
				height: 24px;
				text-align: center;
				border-right: 1px solid #000080;
				border-bottom: 1px solid #000080;
			}

			.empID {
				width: 300px;
				height: 24px;
				text-align: center;
				border-right: 1px solid #000080;
				border-bottom: 1px solid #000080;
			}

			.createDate,
			.replyDate {
				width: 300px;
				height: 24px;
				text-align: center;
				border-bottom: 1px solid #000080;
			}

			.articleContent {
				width: 800px;
				height: 555px;
				padding-left: 7px;
				vertical-align: text-top;
				/* padding-top: 6px; */
				padding-right: 7px;
				padding-bottom: 6px;
				white-space: pre-line;
				word-wrap: break-word;
				word-break: break-all;
			}

			form {
				margin-top: 3px;
			}

			.but1 {
				background-color: #ffd700;
				color: #008000;
				position: relative;
				border: 1px solid rgba(0, 0, 0, 0.5);
				transition: all 0.5s linear;
			}

			.but1:hover {
				border-radius: 25px;
				transition: all 0.5s linear;
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
		<div class="container-fluid mt--8">
			<!-- <input style="margin-bottom: 16px;" class="btn btn-success" type="button" value="回到整串文章"
				onclick="location.href='<spring:url value='/SelectArticle?articleId=${RB.articleId}' />'" /> -->
			<div class="row">
				<div class="row justify-content-md-center">
					<div class="col-lg-12">
						<div align=center class="articleTable">
							<table style="background-color: snow;border-radius:10px;">
								<thead>
									<tr>
										<th class="topic" colspan="2">
											RE：
											<c:out value="${AB.topic}" />
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="empID">作者：${RB.empName}</td>
										<td class="createDate">回覆時間：${RB.replyDate}</td>
									</tr>
									<tr>
										<td class="articleContent" colspan="2">
											<c:out value="${RB.replyContent}" />
										</td>
									</tr>
								</tbody>
							</table>
							<br style="margin-top: 6px;margin-bottom: 6px">
						</div>
					</div>
				</div>
				<div class="col-lg-2" style="margin-top: 136px;margin-left: 20px;">
					<input style="margin-bottom: 16px;" class="btn btn-success" type="button" value="回到整串文章"
						onclick="location.href='<spring:url value='/SelectArticle?articleId=${RB.articleId}' />'" />
				</div>

			</div>
		</div>
	</div>
</body>

</html>