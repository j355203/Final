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
    <title>新增部門</title>
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
        <div>
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
                    <div class="card text-center">
                        <h2 class="text-center">新增部門資料</h2>
                        <br>
                        <form:form method="POST" modelAttribute="departmentBean">
                            <div>
                                <label for="depname">輸入部門名稱</label>
                                <form:input id="depname" path="depname" type="text" />
                            </div>
                            <div class="text-center">
                                <h4>${errorDep.message}</h4>
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary" value="確定" />
                                <input type="reset" class="btn btn-primary" value="重寫" />
                            </div>
                            <br>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>