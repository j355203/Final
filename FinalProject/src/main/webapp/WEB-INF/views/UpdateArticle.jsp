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
	<title>修改：${AB.topic}</title>


	<script>
		document.addEventListener("DOMContentLoaded", function () {
			//事件繫結
			document.getElementById("article").addEventListener("blur",
				checkArticleContent);
		});

		function checkArticleContent() {
			let theArticleContent = document.getElementById("article").value;
			let theArticleContentLen = theArticleContent.length;

			if (theArticleContent == "") {
				// alert("你不可以輸入空白");
				document.getElementById("sp2").innerHTML = "<img src='${pageContext.request.contextPath}/Image/Wrong-s.png'> 你不可以輸入空白!";
			} else if (theArticleContentLen > 2000) {
				// alert("你不可以輸入超過2000字");
				document.getElementById("sp2").innerHTML = "<img src='${pageContext.request.contextPath}/Image/Wrong-s.png'> 你輸入超過2000字!";
			} else {
				// alert("輸入正確");
				document.getElementById("sp2").innerHTML = "";
			}
		}
	</script>
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
		<div class="container-fluid mt--8">
			<input class="btn btn-info" type="button" value="回到文章"
				style="margin-bottom: 16px;background-color: #4682b4;border: #4682b4;"
				onclick="location.href='<spring:url value='/SelectArticle?articleId=${AB.articleId}' />'" />
			<div class="row">
				<div class="row justify-content-md-center">
					<div class="col-lg-10">
						<form:form method="POST" modelAttribute="UpdateArticle">
							<fieldset>
								<!-- <legend>修改討論文章</legend> -->
								<div class="fr1">
									<label for="class" class="lab1">文章標題：</label>
									<input type="hidden" value="${AB.articleId}" name="articleId" path="articleId"
										readonly />
									<input type="hidden" value="${AB.articleClass}" name="articleClass"
										path="articleClass" readonly />
									<input type="hidden" value="${AB.createDate}" name="createDate" path="createDate"
										readonly />
									<input class="form-control form-control-alternative" type="text" id="topic"
										name="topic" placeholder="${AB.topic}" value="${AB.topic}" path="topic"
										readonly />
								</div>
								<div class="fr1">
									<label for="article" class="lab1">文章內容：</label>
									<textarea class="form-control form-control-alternative" cols="55" rows="30"
										id="article" name="articleContent"
										path="articleContent">${AB.articleContent}</textarea>
									<p class="p1">(1.不可空白，2.最多2000字)</p>
									<br>
									<span id="sp2"></span>
								</div>
							</fieldset>
							<div class="sub1">
								<input class="btn btn-default" type="submit" value="送出">
								<input class="btn btn-default" type="reset" value="清除">
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>

</html>