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
    <title>新增員工</title>
	<style type="text/css">
		label{
			margin-left:15%
		}
		.bg10904 {
	background-image:url(<c:url value="/images/bg.jpg"/>);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: top center;
	}
	</style>
	<script type="text/javascript">
		function demo() {
			document.getElementById("empname").value='皮卡丘';
			$('#empgender[value="女"]').attr("checked",true);
			document.getElementById("empbirth").value='1985-11-20';
			document.getElementById("depno").value='600';
			document.getElementById("emptitle").value='財務長';
			document.getElementById("emplevel").value='6';
			document.getElementById("empphone").value='0975-332-109';
			document.getElementById("empaddress").value='真新鎮';
			document.getElementById("emponboard").value='2019-11-28';
		}
	</script>
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
                    <div class="row"></div>
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
        <div class="container-fluid mt--6">
            <div class="row">

            </div>
            <div class="row justify-content-md-center">
                <div class="col-lg-4">
                    <div class="card">
                        <h2 class="text-center">新增員工資料</h2>
                        <form:form method="post" modelAttribute="addemp" id="demoemp">
                            <div>
                                <label for="empname">員工姓名</label>
                                <form:input type="text" id="empname" path="empname" />
                            </div>
                            <div>
                                <label for="empgender">員工性別</label>
                                <form:radiobutton id="empgender" path="empgender" value="男" />男
                                <form:radiobutton id="empgender" path="empgender" value="女" />女
                            </div>
                            <div>
                                <label for="empbirth">員工生日</label>
                                <form:input type="date" id="empbirth" path="empbirth"
                                    placeholder="<spring:message code='spring.addEmp.form.placeholder'/> " />
                            </div>
                            <div>
                                <label for="depno">部門編號</label>
                                <form:select id="depno" path="depno">
                                    <form:option value="-1" label="請挑選" />
                                    <form:options items="${depList}" />
                                </form:select>
                            </div>
                            <div>
                                <label for="emptitle">員工職稱</label>
                                <form:input type="text" id="emptitle" path="emptitle" />
                            </div>
                            <div>
                                <label for="emplevel">員工權限</label>
                                <form:input type="text" id="emplevel" path="emplevel" />
                            </div>
                            <div>
                                <label for="empphone">員工電話</label>
                                <form:input type="text" id="empphone" path="empphone" />
                            </div>
                            <div>
                                <label for="empaddress">員工地址</label>
                                <form:input type="text" id="empaddress" path="empaddress" />
                            </div>

                            <div>
                                <label for="emponboard">到職日期</label>
                                <form:input type="date" id="emponboard" path="emponboard"
                                    placeholder="<spring:message code='spring.addEmp.form.placeholder'/>" />
                            </div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary" value="確定" />
                                <input type="reset" class="btn btn-primary" value="重寫" />
                                <input type="button" class="btn btn-primary" onclick="demo()" value="Demo用" />
                            </div>
                            <br>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>