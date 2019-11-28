<%@page import="finalProject.eeit10911.model.Article"%>
<%@page import="finalProject.eeit10911.model.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-TW">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>${AB.topic}</title>


	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
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

			.createDate {
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
				margin-top: 6px;
				margin-bottom: 6px;
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
			<form id="reportSpace" class="reportSpace">
				<input type="hidden" value="${AB.articleId}" name="articleId" />
				<input id="reportNum" type="hidden" value="${AB.reportStatus}" name="reportStatus" />
			</form>
			<div class="row">
				<div class="row justify-content-md-center">
					<div class="col-lg-12">
						<div align=center class="articleTable">
							<table style="background-color: snow;border-radius:10px;">
								<thead>
									<tr>
										<th class="classID">分類：${AB.articleClass}</th>
										<th class="topic" colspan="2">
											<c:out value="${AB.topic}" />
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="articleID">文章總編號：${AB.articleId}</td>
										<td class="empID">作者：${emp.empname}</td>
										<td class="createDate">
											<fmt:parseDate value="${AB.createDate}" var="date1"
												pattern="yyyy-MM-dd HH:mm:ss" />發表時間：
											<fmt:formatDate value="${date1}" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
									</tr>
									<tr>
										<td class="articleContent" colspan="3">
											<c:out value="${AB.articleContent}" />
										</td>
									</tr>
								</tbody>
							</table>
							<br style="margin-top: 6px;margin-bottom: 6px">
							<c:forEach items="${RBL}" var="RBL" varStatus="s">
								<table style="background-color: snow;border-radius:10px;">
									<thead>
										<tr>
											<th class="topic" colspan="2" style="border-right: 1px solid #000080;">
												RE：
												<c:out value="${AB.topic}" />
											</th>
											<th>
												<input style="margin-left: 110px;font-family: Microsoft JhengHei;"
													type="button" class="but1" value="刪除回覆"
													onclick="location.href='<spring:url value='/DeleteReply/${RBL.replyId}' />'" />
											</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="empID" colspan="2">作者：${RBL.empName}</td>
											<td class="createDate">
												<fmt:parseDate value="${RBL.replyDate}" var="date2"
													pattern="yyyy-MM-dd HH:mm:ss" />回覆時間：
												<fmt:formatDate value="${date2}" pattern="yyyy-MM-dd HH:mm:ss" />
											</td>
										</tr>
										<tr>
											<td class="articleContent" colspan="3">
												<c:out value="${RBL.replyContent}" />
											</td>
										</tr>
									</tbody>
								</table>
								<br style="margin-top: 6px;margin-bottom: 6px">
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-lg-2" style="margin-top: 136px;margin-left: 90px;">
					<input style="margin-bottom: 16px;" class="btn btn-warning" type="button" value="刪除違規文章"
						onclick="location.href='<spring:url value='/DeleteArticle/${AB.articleId}' />'" />
					<input style="margin-bottom: 16px;" class="btn btn-primary" type="button" value="回到被檢舉文章總覽"
						onclick="location.href='<spring:url value='SelectToBeDeleted-admin' />'" />
				</div>

			</div>
		</div>
	</div>

</body>

</html>