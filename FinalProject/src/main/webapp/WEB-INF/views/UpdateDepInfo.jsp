<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>更新部門名稱</title>

    <script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
    <style type="text/css">
		.bg10904 {
	background-image:url(<c:url value="/images/bg.jpg"/>);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: top center;
	}
	</style>
</head>

<body class="bg10904">
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
        <div class="header bg-gradient-info pb-2 pt-5 pt-md-8">
            <div class="container-fluid">
                <div class="header-body">
                    <!-- Card stats -->
                    <div class="row">

                    </div>
                </div>
            </div>
        </div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
		<div class="row">
			<h3>&nbsp;</h3>
		</div>
        <div class="container-fluid mt--10">
            <div class="row">
            </div>
            <div class="row justify-content-md-center">
                <div class="col-lg-4">
                    <div class="card text-center" style="width:100%">
                        <h2>更新部門名稱</h2><br>
                        <form:form method="post" modelAttribute="updateDep">
                            部門編號
                            <form:input type="text" path="depno" value="${dep.depno}" readonly="true" />
                            <br><br>
                            部門名稱
                            <form:input type="text" path="depname" value="${dep.depname}" />
                            <br><br>
                            <input type="submit" class="btn btn-primary" value="修改">
                            <br><br>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>