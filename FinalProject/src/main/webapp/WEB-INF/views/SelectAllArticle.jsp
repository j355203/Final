<%@page import="finalProject.eeit10911.model.Article"%>
<%@page import="java.util.ArrayList"%>
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
	<title>文章總覽</title>

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
			<div class="row"></div>
			<input class="btn btn-info" type="button" value="新增文章" style="background-color: #4682b4;border: #4682b4;"
				onclick="location.href='InsertArticle'" />
			<input class="btn btn-success" type="button" value="依分類查詢文章"
				onclick="location.href='SelectArticleByClass'" />
			<div class="table-responsive" style="margin-top: 100px;">
				<div align=center>
					<table class="table align-items-center table-dark">
						<thead class="thead-dark">
							<tr style="text-align: center;">
								<th scope="col" style="font-size: 16px; color: #FF8000;">文章分類
								<th scope="col" style="font-size: 16px; color: #FF8000;">標題
								<th scope="col" style="font-size: 16px; color: #FF8000;">發表時間
						</thead>
						<tbody class="list">
							<c:forEach items="${AB}" var="AB" varStatus="s">
								<tr>
									<td style="text-align: center; font-size: 16px;">${AB.articleClass}
									<td><a href="<spring:url value='/SelectArticle?articleId=${AB.articleId}' />"
											style="font-size: 16px; color: gold;">
											<c:out value="${AB.topic}" /></a>
									<td style="text-align: center; font-size: 16px;">
										<fmt:parseDate value="${AB.createDate}" var="date1"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate value="${date1}" pattern="yyyy-MM-dd HH:mm:ss" />
										<c:set var="count" value="${s.count}" />
							</c:forEach>
						</tbody>
					</table>
					<h3>共 ${count} 篇文章</h3>
				</div>
			</div>

		</div>
	</div>

</body>

</html>