<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登入頁面</title>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link href="${pageContext.request.contextPath}/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css"
        rel="stylesheet" />
    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath}/assets/css/argon-dashboard.css?v=1.1.0" rel="stylesheet" />
    <style type="text/css">
		.bg10904 {
	background-image:url(<c:url value="/images/login2.jpg"/>);
    background-repeat: no-repeat;
    background-size: cover;
    background-position:center;
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

        <div class="container-fluid mt--15">
            <div class="row">

            </div>
            <div class="row justify-content-md-center" style="margin:20% auto">
                <div class="col-lg-4">
                    <div class="card text-center" style="background: rgba(0, 0, 0, 0)">
                    	<br>
                        <h2 style="color:black; font-size:30px">登入系統</h2>
                        <form:form method="POST" modelAttribute="login">
                            <div style="color:black;font-weight:900;font-size:20px">
                                <label for="empid" style="color: black;">員工代號</label>
                                <form:input id="empid" path="empid" type="text" />
                            </div>
                            <br>
                            <div style="color:black;font-weight:900;font-size:20px">
                                <label for="emppassword" style="color: black;">密&emsp;&emsp;碼</label>
                                <form:password id="emppassword" path="emppassword" />
                            </div>
                            <br>
                            <input type="submit" class="btn btn-primary" value="確定" />
                            &emsp;
                            <input type="reset" class="btn btn-primary" value="重寫" />
                        </form:form>
                        <h2 class="text-red d-inline-block">${errorMsgMap.loginError}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>