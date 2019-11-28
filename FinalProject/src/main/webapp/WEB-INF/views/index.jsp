<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首頁</title>

    <style>
        @media screen and (min-width: 1024px) {
            #carousel-main {
                height: 400px;
            }
        }

        /*###Tablet(medium)###*/
        @media screen and (min-width : 768px) and (max-width : 1023px) {
            #carousel-main {
                height: 200px;
            }
        }

        /*### Smartphones (portrait and landscape)(small)### */
        @media screen and (min-width : 0px) and (max-width : 767px) {
            #carousel-main {
                height: 150px;
            }
        }
    </style>
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
        <div class="header bg-gradient-info pb-5 pt-5 pt-md-8">
            <div class="container-fluid">
                <div class="header-body">
                    <!-- Card stats -->
                    <div class="row"></div>
                </div>
            </div>
        </div>
        <div class="container-fluid mt--7">
            <div id="carouselExampleIndicators" class="carousel slide h-25" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" id="carousel-main">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/landscape.jpg"
                            alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/newyork.jpg"
                            alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="${pageContext.request.contextPath}/images/sky.jpg"
                            alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">上一張</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">下一張</span>
                </a>
            </div>
            <div class="row justify-content-md-center mt-4">
                <div class="col-lg-4">
                    <div class="card">
                        <h3 class="card-header text-center">餐點專區</h3>
                        <div id="carouselExampleIndicators2" class="carousel slide carousel-fade" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators2" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators2" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators2" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" id="carousel-sec">
                                <div class="carousel-item active">
                                    <img class="d-block card-img-top"
                                        src="${pageContext.request.contextPath}/images/indexfood1.jpg"
                                        alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block card-img-top"
                                        src="${pageContext.request.contextPath}/images/indexfood2.jpg"
                                        alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block card-img-top"
                                        src="${pageContext.request.contextPath}/images/indexfood3.jpg"
                                        alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators2" role="button"
                                data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">上一張</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators2" role="button"
                                data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">下一張</span>
                            </a>
                        </div>
                        <div class="card-body">
                            <h4 class="card-title">今日特餐</h4>
                            <p class="card-text">點進來看看今天推薦什麼菜單～</p>
                            <a href="${pageContext.request.contextPath}/orderpage" class="btn btn-primary">餐點專區</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="card">
                        <h3 class="card-header text-center">活動專區</h3>
                        <img class="card-img-top" style="height:70%"
                            src="${pageContext.request.contextPath}/images/travel.jpg"
                            alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">近期活動</h4>
                            <p class="card-text">員工旅遊將於12月中舉行，詳情請見活動專區</p>
                            <a href="${pageContext.request.contextPath}/userActivity" class="btn btn-primary">活動專區</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="card">
                        <h3 class="card-header text-center">教育訓練</h3>
                        <img class="card-img-top"
                            src="${pageContext.request.contextPath}/images/spring.png"
                            alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title">Spring新課程</h4>
                            <p class="card-text">課程開幕，快來報名上課～</p>
                            <a href="${pageContext.request.contextPath}/Learningindex" class="btn btn-primary">教育訓練</a>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>

</html>