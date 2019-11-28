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
    <title>新增員工結果</title>
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
        <div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
            <div class="container-fluid">
                <div class="header-body">
                    <!-- Card stats -->
                    <div class="row">

                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid mt--7">
            <div class="row">

            </div>
            <div class="row justify-content-md-center">
                <div class="col-lg-4">
                    <div class="card text-center">
                        <h2>新增員工結果</h2>
                        <table border="1" class="table-hover text-center">
                            <tr>
                                <td>員工工號
                                <td>${emp.empid}
                            <tr>
                                <td>員工姓名
                                <td>${emp.empname}
                            <tr>
                                <td>員工性別
                                <td>${emp.empgender}
                            <tr>
                                <td>員工生日
                                <td>${emp.empbirth}
                            <tr>
                                <td>部門編號
                                <td>${emp.depno}
                            <tr>
                                <td>員工職稱
                                <td>${emp.emptitle}
                            <tr>
                                <td>員工權限
                                <td>${emp.emplevel}
                            <tr>
                                <td>員工電話
                                <td>${emp.empphone}
                            <tr>
                                <td>居住地址
                                <td>${emp.empaddress}
                            <tr>
                                <td>到職日期
                                <td>${emp.emponboard}
                        </table>
                        <br>
                        <input type="button" class="btn btn-primary"
                            onclick="window.location.href='<c:url value="/addEmp" />'" value="新增員工">
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>