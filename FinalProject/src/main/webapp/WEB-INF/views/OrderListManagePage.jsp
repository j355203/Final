<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂購管理</title>

<link href="${pageContext.request.contextPath}/css/eeit10919/test1.css"
	rel="stylesheet" />
<style>
select {
	-webkit-appearance: none;
}

@media ( min-width : 480px) {
	table {
		width: auto;
	}
}

.table td {
	font-size: 16px;
}

.table thead th {
	font-size: 16px;
}

.table tr td {
	cursor: pointer;
}

.hiddenRow {
	padding: 0 0px !important;
	background-color: #eeeeee;
	font-size: 13px;
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
		<div class="header bg-gradient-info pb-8 pt-5 pt-md-8">
			<div class="container-fluid">
				<div class="header-body">
					<!-- Card stats -->
					<div class="row"></div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--7">
			<div class="row"></div>
			<div class="row mt-2">
				<div class="col">
					<div class="card shadow">
						<div class="card-header border-0">
							<h3 class="mb-1 ml-1">本日訂購清單</h3>
						</div>
						<div class="card-body">
							<div class="table-responsive table-hover">
								<table class="table align-items-center table-flush text-center">
									<thead class="thead-light">
										<tr>
											<th scope="col">本日店家</th>
											<th scope="col">店家名稱</th>
											<th scope="col">訂單總數</th>
											<th scope="col" class="d-none d-lg-table-cell">金額總計</th>
											<th scope="col" class="d-none d-lg-table-cell">付款狀態</th>
										</tr>
									</thead>
									<tbody>
										<tr data-toggle='collapse' data-target='#demo1'>
											<td>
												<div class='imgBox'>
													<img src="">
												</div>
											</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr id="detail">
											<td colspan='6' class='hiddenRow px-0'>
												<table
													class='card accordian-body collapse align-items-center text-center'
													id='demo1'>
													<tr>
														<th scope="col">訂單編號</th>
														<th scope="col">訂購員工姓名</th>
														<th scope="col" class="d-none d-lg-table-cell">金額總計</th>
														<th scope="col" class="d-none d-lg-table-cell">付款狀態</th>
														<th scope="col">付款按鈕</th>
													</tr>

												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="card card-stats mb-2 mt-2">
						<div class="card-body">
							<div class="row">
								<div class="col-auto">
									<div
										class="icon icon-shape bg-danger text-white rounded-circle shadow">
										<i class="fas fa-utensils"></i>
									</div>
								</div>
								<div class="col">
									<h1 class="card-title text-uppercase text-muted mb-0">餐點總數</h1>
									<span class="h2 font-weight-bold mb-0"></span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-6">
					<div class="card card-stats mb-2 mt-2">
						<div class="card-body">
							<div class="row">
								<div class="col-auto">
									<div
										class="icon icon-shape bg-warning text-white rounded-circle shadow">
										<i class="fas fa-dollar-sign"></i>
									</div>
								</div>
								<div class="col">
									<h1 class="card-title text-uppercase text-muted mb-0">實收金額</h1>
									<span class="h2 font-weight-bold mb-0">0</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="card shadow">
						<div class="card-header border-0 pb-0">
							<h3 class="mb-3 ml-1">訂購報表</h3>
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#course" role="tab"
									aria-controls="home" aria-selected="true">餐點統計</a></li>
								<li class="nav-item"><a class="nav-link" id="profile-tab"
									data-toggle="tab" href="#dep" role="tab"
									aria-controls="profile" aria-selected="false">領取表單</a></li>
							</ul>
						</div>
						<div class="card-body pt-0">
							<div class="row">
								<div class="col pr-0">
									<div class="tab-content" id="myTabContent">
										<div class="tab-pane fade show active" id="course"
											role="tabpanel" aria-labelledby="home-tab">
											<div class="row"></div>
										</div>
										<div class="tab-pane fade" id="dep" role="tabpanel"
											aria-labelledby="profile-tab">
											<div class="row"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
	
		//取消tr上的按鈕觸發下拉事件
        function clickException() {
            $("tr > td > div.btn").unbind().click(function (ev) {
                ev.stopPropagation();
            });
        }

        //新增資料到第一層表格(整體付款狀態層) -- 開始
        //已經有訂購資料的話用這個
        function addOuterTable(data) {
            let totalPrice = 0;
            let payColor = ["danger", "success"];
            let payCount = 0;
            let payStr = "";
            $(".imgBox > img").attr("src", "${pageContext.request.contextPath}" + data[0].storeBean.storeImg + "?random=" +new Date().getTime());
            $("tbody > tr > td").eq(1).text(data[0].storeBean.storeName);
            $("tbody > tr > td").eq(2).text(data.length);
            for (let i = 0; i < data.length; i++) {
                totalPrice = totalPrice + parseInt(data[i].totalPrice);
                if (data[i].orderStatus == 0) {
                    payCount = payCount + 1;
                } else if (data[i].orderStatus == 1) {
                    payCount = payCount;
                }
            }
            $("tbody > tr > td").eq(3).text(totalPrice);
            if (payCount > 0) {
                payStr = payStr + "<div class='alert alert-" + payColor[0] + " m-0'>" + "尚有" + payCount + "筆未付款</div>";
            } else {
                payStr = payStr + "<div class='alert alert-" + payColor[1] + " m-0'>" + "全部付款完成</div>";
            }
            $("tbody > tr > td").eq(4).append(payStr);
        }
        
        //還沒有訂購資料的話是這個
        function noOrderData(data){
        	let totalPrice = 0;
            let payColor = ["danger", "success"];
            let payCount = 0;
            let payStr = "";
            $(".imgBox > img").attr("src", "${pageContext.request.contextPath}" + data[0].storeImg);
            $("tbody > tr > td").eq(1).text(data[0].storeName);
            $("tbody > tr > td").eq(2).text(0);
            $("tbody > tr > td").eq(3).text(totalPrice);
            $("tbody > tr > td").eq(4).append("尚無訂購資料")
        }
        
        //更新狀態後用這個
        function updateOrderData(data){
        	let payColor = ["danger", "success"];
        	let payCount = 0;
        	let payStr = "";
        	for (let i = 0; i < data.length; i++) {
                if (data[i].orderStatus == 0) {
                    payCount = payCount + 1;
                } else if (data[i].orderStatus == 1) {
                    payCount = payCount;
                }
            }
        	if (payCount > 0) {
                payStr = payStr + "<div class='alert alert-" + payColor[0] + " m-0'>" + "尚有" + payCount + "筆未付款</div>";
            } else {
                payStr = payStr + "<div class='alert alert-" + payColor[1] + " m-0'>" + "全部付款完成</div>";
            }
            $("tbody > tr > td").eq(4).text("");
            $("tbody > tr > td").eq(4).append(payStr);
        }
        
        //新增資料到第一層表格(整體付款狀態層) -- 結束

        //新增資料到第二層表格(訂單層) -- 開始
        //初始化新增
        function addSecondTable(data) {
        	$("#demo1 > tbody > tr:gt(0)").remove();
            let secondTableStr = "";
            let payColor = ["danger", "success"];
            for (let i = 0; i < data.length; i++) {
                let payStatusStr = "";
                let payButtonStr = "";
                if (data[i].orderStatus == 0) {
                    payStatusStr = payStatusStr + "<span class='badge badge-dot'>" + "<i class='bg-" + payColor[0] + "'></i>未付款" + "</span>";
                    payButtonStr = payButtonStr + "<div class='btn btn-" + payColor[1] + " paybtn'>" + "確認付款" + "</div>" +
                                                  "<div class='btn btn-danger'>取消訂單</div>";
                } else if (data[i].orderStatus == 1) {
                    payStatusStr = payStatusStr + "<span class='badge badge-dot'>" + "<i class='bg-" + payColor[1] + "'></i>已付款" + "</span>";
                    payButtonStr = payButtonStr + "<div class='btn btn-" + payColor[0] + " unpaybtn'>" + "取消付款" + "</div>" +
                                                  "<div class='btn btn-danger'>取消訂單</div>";
                }
                let orderItemStr = "";
                for (let j = 0; j < data[i].orderItem.length; j++) {
                    orderItemStr = orderItemStr +
                        "<tr>" +
                        "<td>" + data[i].orderItem[j].mainCourse.productName + "</td>" +
                        "<td>" + data[i].orderItem[j].amount + "</td>" +
                        "<td>" + data[i].orderItem[j].mainCourse.price * data[i].orderItem[j].amount + "</td>" +
                        "</tr>"
                }
                secondTableStr = secondTableStr +
                    "<tr data-toggle='collapse' data-target='#demo1_" + i + "'>" +
                    "<td>" + data[i].orderName + "</td>" +
                    "<td>" + data[i].employeeBean.empname + "</td>" +
                    "<td>" + data[i].totalPrice + "</td>" +
                    "<td>" + payStatusStr + "</td>" +
                    "<td>" + payButtonStr + "</td>" +
                    "</tr>" +
                    "<tr>" +
                    "<td colspan='6' class='hiddenRow px-0'>" +
                    "<table class='card accordian-body collapse align-items-center text-center' id='demo1_" + i + "'>" +
                    "<tr>" + "<th scope='col'>商品名稱</th>" + "<th scope='col'>數量</th>" + "<th scope='col'>金額總計</th>" + "</tr>" +
                    orderItemStr +
                    "</table>" +
                    "</td>" +
                    "</tr>"
            }
            $("#demo1 > tbody").append(secondTableStr);
        }

        //更新狀態後用這個
        function updateSecondTable(data, iloc){
        	$("#demo1 > tbody > tr").eq(1 + 2 * (iloc)).children().eq(3).text("");
        	$("#demo1 > tbody > tr").eq(1 + 2 * (iloc)).children().eq(4).text("");
        	let secondTableStr = "";
            let payColor = ["danger", "success"];
            let payStatusStr = "";
            let payButtonStr = "";
        	if (data.orderStatus == 0) {
                payStatusStr = payStatusStr + "<span class='badge badge-dot'>" + "<i class='bg-" + payColor[0] + "'></i>未付款" + "</span>";
                payButtonStr = payButtonStr + "<div class='btn btn-" + payColor[1] + " paybtn'>" + "確認付款" + "</div>" +
                                              "<div class='btn btn-danger'>取消訂單</div>";
            } else if (data.orderStatus == 1) {
                payStatusStr = payStatusStr + "<span class='badge badge-dot'>" + "<i class='bg-" + payColor[1] + "'></i>已付款" + "</span>";
                payButtonStr = payButtonStr + "<div class='btn btn-" + payColor[0] + " unpaybtn'>" + "取消付款" + "</div>" +
                                              "<div class='btn btn-danger'>取消訂單</div>";
            }
        	$("#demo1 > tbody > tr").eq(1 + 2 * (iloc)).children().eq(3).append(payStatusStr);
        	$("#demo1 > tbody > tr").eq(1 + 2 * (iloc)).children().eq(4).append(payButtonStr);
        }
        
        //新增資料到第二層表格(訂單層) -- 結束

        //初始化表格 -- 開始
        let orderData;
        let names;
        let countArray = [0, 0, 0];
        let countTotal;
        $(document).ready(function () {
        	initOrder();
        });
        
        function initOrder(){
        	$.ajax({
        		url:"${pageContext.request.contextPath}/ordermanage/today",
        		contentType: "application/json",
				type: "POST",
				success:function(data){
					orderData = data;
					getTodayCourse(orderData);
		        	getDepData(orderData);
					names = Object.values(data).map(item => item.orderName);
					if(data[0].storeId == null){	
						addOuterTable(data);
			            addSecondTable(data);
			            clickException();
			            paySubmitAction();
			            console.log(data);
					}else{
						noOrderData(data);
						$("#demo1 > tbody").text("尚無資料");
					}					
				}
        	});
        }
        //初始化表格 -- 結束
        
        //付款按鈕事件 -- 開始       
        function payButton(){
        	$(".paybtn").unbind().click(function(ev){
        		if(confirm("是否確認付款?")){
        			ev.stopPropagation();
        			let currentBtnName = $(this).parents('tr').eq(0).children('td').eq(0).text();
            		let iloc = names.indexOf(currentBtnName);
            		let targetOrderId = orderData[iloc].orderId;
            		$.ajax({
            			url : "${pageContext.request.contextPath}/ordermanage/status1",
            			type : "POST",
            			data : {"id" : targetOrderId},
            			success:function(data){
            				orderData[iloc].orderStatus = 1;
            				updateOrderData(orderData);
    			            updateSecondTable(orderData[iloc], iloc);
    			            paySubmitAction();
    			            amountUpdate(orderData[iloc]);
    			            amountUpdateDep(orderData[iloc]);
            			}
            		});
        		}else{
        			ev.stopPropagation();
        		}      		
        	});
        }
        
        function unpayButton(){
        	$(".unpaybtn").unbind().click(function(ev){
        		if(confirm("是否取消付款?")){
        			ev.stopPropagation();
        			let currentBtnName = $(this).parents('tr').eq(0).children('td').eq(0).text();
            		let iloc = names.indexOf(currentBtnName);
            		let targetOrderId = orderData[iloc].orderId;
            		$.ajax({
            			url : "${pageContext.request.contextPath}/ordermanage/status0",
            			type : "POST",
            			data : {"id" : targetOrderId},
            			success:function(data){
            				orderData[iloc].orderStatus = 0;
            				updateOrderData(orderData);
    			            updateSecondTable(orderData[iloc], iloc);
    			            paySubmitAction();
    			            amountUpdate(orderData[iloc]);
    			            amountUpdateDep(orderData[iloc]);
            			}
            		});
        		}else{
        			ev.stopPropagation();
        		}
        	});
        }
        
        function paySubmitAction(){
        	payButton();
        	unpayButton();
        }
        //付款按鈕事件 -- 結束
        
        //(自作孽，不可活XwX) -- 開始
        //1.根據菜單進行報表分類
        //取得本日菜單資料
        let todayStore;
        let courseNames;
        function getTodayCourse(orderData){
        	$.ajax({
        		url : "${pageContext.request.contextPath}/ordermanage/storeInfo",
        		contentType: "application/json",
				type: "POST",
				async:false,
				success:function(data){
					console.log(data);
					todayStore = data;
					courseNames = Object.values(todayStore.mainCourse).map(item => item.productName);
					createCourseCard(todayStore, orderData);
					amountCount(orderData);
				}
        	});
        }
        
        //創建餐點對應的卡片
         function createCourseCard(data){
        	let courseStr = "";
        	let mainCourseData = data.mainCourse;
        	for(let i = 0; i < mainCourseData.length; i++){
        		courseStr = courseStr + 
        					'<div class="card card-stats mb-xl-0 courseCard">' + 
        					'<div class="card-body">' + 
        					'<div class="row">' +
        					'<div class="col-auto">' +
        					'<h1>' + mainCourseData[i].productName + "</h1>" +
        					'</div>' +
        					'<div class="col">' + '<h2 class="text-right">共0份</h2>' + "</div>" +
        					'</div></div></div>'
        	}
        	$("#course").append(courseStr);
        }
        
        //計算各項餐點的數量並填入對應數字
      	let totalPrice = 0;
        function amountCount(orderData){
        	for(let i = 0; i < orderData.length; i++){
        		if(orderData[i].orderStatus == 1){
        			totalPrice = totalPrice + orderData[i].totalPrice;
        			for(let j = 0; j < orderData[i].orderItem.length; j++){
            			let iloc = courseNames.indexOf(orderData[i].orderItem[j].mainCourse.productName);
            			countArray[iloc] = countArray[iloc] + orderData[i].orderItem[j].amount;
            			$(".courseCard").find('h2').eq(iloc).text("");
            			$(".courseCard").find('h2').eq(iloc).text('共' + countArray[iloc] + '份');
            		}
        		}     		
        	}     	
        	countTotal = countArray.reduce((a, b) => a + b, 0);
        	$("span.h2").eq(0).text(countTotal);
        	$("span.h2").eq(1).text(totalPrice);
        	console.log($("span.h2"));
        }
        
        function amountUpdate(orderData){
        	if(orderData.orderStatus == 1){
        		totalPrice = totalPrice + orderData.totalPrice;
        		for(let j = 0; j < orderData.orderItem.length; j++){
        			let iloc = courseNames.indexOf(orderData.orderItem[j].mainCourse.productName);
        			countArray[iloc] = countArray[iloc] + orderData.orderItem[j].amount;
        			$(".courseCard").find('h2').eq(iloc).text("");
        			$(".courseCard").find('h2').eq(iloc).text('共' + countArray[iloc] + '份');
        		}
        	}else if(orderData.orderStatus == 0){
        		totalPrice = totalPrice - orderData.totalPrice;
        		for(let j = 0; j < orderData.orderItem.length; j++){
        			let iloc = courseNames.indexOf(orderData.orderItem[j].mainCourse.productName);
        			countArray[iloc] = countArray[iloc] - orderData.orderItem[j].amount;
        			$(".courseCard").find('h2').eq(iloc).text("");
        			$(".courseCard").find('h2').eq(iloc).text('共' + countArray[iloc] + '份');
        		}
        	}
        	countTotal = countArray.reduce((a, b) => a + b, 0);
        	$("span.h2").eq(0).text(countTotal);
        	$("span.h2").eq(1).text(totalPrice);
        }
        
        //2.根據部門進行報表分類
        let depData;
        let depNos;
        let depCountArray;
        let depGetArray;
        function getDepData(orderData){
        	$.ajax({
        		url : "${pageContext.request.contextPath}/ordermanage/depInfo",
        		contentType: "application/json",
				type: "POST",
				success:function(data){
					depData = data;
					depNos = Object.values(depData).map(item => item.depno);
					depCountArray = new Array(depNos.length).fill(0);
					depGetArray = new Array();
					for(let i = 0; i < depNos.length; i++){
						depGetArray.push([0, 0, 0])
					}
					createDepCard(data, orderData, courseNames);
					amountCountDep(orderData, courseNames);
				}
        	});      	
        }
        
        function createDepCard(data, orderData, courseNames){
        	let depStr = '<div class="table-responsive table-hover">' +
            			 '<table class="table align-items-center table-flush text-center">';
            let depSubStr = '';
            let empNames = Object.values(orderData).map(item => item.employeeBean.empname);
        	for(let i = 0; i < data.length; i++){
        		depStr = depStr + 
        					'<tr class="depCard" data-toggle="collapse" data-target="#dep' + i + '">' +
        					'<td>' + '<h1 class="text-left">' + data[i].depname + "</h1>" + '</td>' +
        					'<td>' + '<h2 class="text-center float-right">無訂購資料</h2>' + '</td>' +
        					'</tr>' +
        					'<tr>' +
        					'<td colspan="6" class="hiddenRow px-0">' +
        					"<table class='card accordian-body collapse align-items-center text-center' id='dep" + i + "'>";
                let targetNames = [];
                let targetData = [];
        		for(let j = 0; j < orderData.length; j++){
        			if(orderData[j].orderStatus == 1){
        				if(orderData[j].employeeBean.depBean.depno == data[i].depno){
            				if(targetNames.indexOf(orderData[j].employeeBean.empname) < 0){
            					targetNames.push(orderData[j].employeeBean.empname);
            				}       				
            			}
        			}      			
        		}
        		let firstLine = '';
        		if(targetNames.length == 0){
        			firstLine = firstLine + '<tr>' + '<td>' + '尚無資料' + '</td>' + '</tr>';
        		}else{
        			firstLine = firstLine + 
        						"<tr>" + 
        						"<th scope='col'>訂購人姓名</th>" + 
        						"<th scope='col'>訂購餐點</th>" + 
        						"<th scope='col'>數量</th>" + 
        						"<th scope='col'>領取按鈕</th>"
        						"</tr>";
        		}
        		depStr = depStr + firstLine;
        		let orderItemStr = ''; 
        		for(let k = 0; k < targetNames.length; k++){
        			let orderItemAmount = [0, 0, 0];
        			console.log(targetNames);
        			let idx = empNames.indexOf(targetNames[k]);
        			while (idx != -1) {
        				for(let l = 0; l < orderData[idx].orderItem.length; l++){
        					if(orderData[idx].orderStatus == 1 && orderData[idx].orderItem[l].status == 0){
        						let iloc = courseNames.indexOf(orderData[idx].orderItem[l].mainCourse.productName);
            					orderItemAmount[iloc] = orderItemAmount[iloc] + orderData[idx].orderItem[l].amount;
        					}else if(orderData[idx].orderStatus == 1 && orderData[idx].orderItem[l].status == 1){
        						let iloc = courseNames.indexOf(orderData[idx].orderItem[l].mainCourse.productName);
            					orderItemAmount[iloc] = orderItemAmount[iloc] - orderData[idx].orderItem[l].amount;
        					}    					
        				}
        				targetData.push(orderData[idx]);
        				console.log(idx);
        				idx = empNames.indexOf(targetNames[k], idx + 1);
        				console.log(idx);
        			}
        			console.log(targetData);
        			console.log(orderItemAmount);
        			for(let m = 0; m < orderItemAmount.length; m++){
            			if(orderItemAmount[m] > 0){
            				orderItemStr = orderItemStr + 
            				   			   '<tr>' +
            				   			   '<td>' + targetNames[k] + '</td>' +
            				   			   '<td>' + courseNames[m] + '</td>' +
            				   			   '<td>' + orderItemAmount[m] + '</td>' +
            				   			   '<td>' + '<div class="gon btn btn-success">確認領取</div>' + '<td>' +
            				   			   '</tr>'
            			}else if(orderItemAmount[m] < 0){
            				orderItemStr = orderItemStr + 
				   			   			   '<tr>' +
				   			   			   '<td>' + targetNames[k] + '</td>' +
				   			   			   '<td>' + courseNames[m] + '</td>' +
				   			   			   '<td>' + orderItemAmount[m] * -1 + '</td>' +
				   			   			   '<td>' + '<div class="gon">已領取</div>' + '<td>' +
				   			   			   '</tr>'
            			}
            		}
        		}
        		depStr = depStr + orderItemStr + '</table></td></tr>';
        	}
        	depStr = depStr + '</table></div>';
        	$("#dep").append(depStr);
        	getOrNotAction();
        }
        
        function amountCountDep(orderData, courseNames){
        	console.log(orderData);
        	for(let i = 0; i < orderData.length; i++){
        		if(orderData[i].orderStatus == 1){
        			let iloc = parseInt(depNos.indexOf(orderData[i].employeeBean.depBean.depno));
        			let amount = 0;
        			for(let j = 0; j < orderData[i].orderItem.length; j++){
        				let itemLoc = courseNames.indexOf(orderData[i].orderItem[j].mainCourse.productName);
        				if(orderData[i].orderItem[j].status == 1){
        					depGetArray[iloc][itemLoc] = depGetArray[iloc][itemLoc];
        					amount = amount;
        				}else{
        					depGetArray[iloc][itemLoc] = depGetArray[iloc][itemLoc] + orderData[i].orderItem[j].amount;
        					amount = amount + orderData[i].orderItem[j].amount;
        				}
        			}
        			depCountArray[iloc] = depCountArray[iloc] + amount;
        			if(depCountArray[iloc] == 0){
        				$(".depCard").find('h2').eq(iloc).text("");
            			$(".depCard").find('h2').eq(iloc).text('全部領取完畢');
            			$(".depCard").find('h2').eq(iloc).addClass('alert alert-success w-25');           			
        			}else{
        				$(".depCard").find('h2').eq(iloc).text("");
            			$(".depCard").find('h2').eq(iloc).text('尚有' + depCountArray[iloc] + '份未領取');
            			$(".depCard").find('h2').eq(iloc).addClass('alert alert-danger w-25');
        			}
        		}
        	}
        	console.log(depGetArray);
        	for(let j = 0; j < depGetArray.length; j++){
        		console.log(depGetArray[j].reduce((a,b)=>a+b));
        		let targetCard = $(".depCard").eq(j);
        		let nrow = targetCard.next().children().children().children().children().length;
        		let rows = targetCard.next().children().children().children().children();
        		for(let k = 1; k < nrow; k++){
        			let rowItemName = rows.eq(k).children().eq(1).text();
        			let itemLoc2 = courseNames.indexOf(rowItemName);
        			console.log(depGetArray[j][itemLoc2]);
        			if(depGetArray[j][itemLoc2] == 0){
                		console.log(rows.find('div.gon'));
        				rows.find('div.gon').eq((k - 1)).unbind();
        				rows.find('div.gon').eq((k - 1)).removeClass('btn btn-success');
        				rows.find('div.gon').eq((k - 1)).text('已領取');
        			}
        		}        		
        	}
        }
        
        function amountUpdateDep(orderData){
        	//判斷回來的這筆訂購資料是完成付款還是取消付款
        	if(orderData.orderStatus == 1){
        		let iloc = depNos.indexOf(orderData.employeeBean.depBean.depno);
    			let amount = 0;
    			for(let j = 0; j < orderData.orderItem.length; j++){
    				amount = amount + orderData.orderItem[j].amount;
    			}
    			depCountArray[iloc] = depCountArray[iloc] + amount;
    			$(".depCard").find('h2').eq(iloc).text("");
    			$(".depCard").find('h2').eq(iloc).text('尚有' + depCountArray[iloc] + '份未領取');
    			$(".depCard").find('h2').eq(iloc).addClass('alert alert-danger w-25');
    			let rec = $(".depCard").eq(iloc).next().find('tr');
    			let targerRecItemName = [];
    			let targetRecItemAmount = [];
    			let targetRecLoc = [];
    			//判斷裡面原本是不是"尚無資料"的狀態
    			if(rec.length > 1){
    				for(let k = 1; k < rec.length; k++){
    					//判斷裡面是不是有相同人的訂購資料
    					if(rec.eq(k).find('td').eq(0).text() == orderData.employeeBean.empname){
    						targerRecItemName.push(rec.eq(k).find('td').eq(1).text());
    						targetRecItemAmount.push(rec.eq(k).find('td').eq(2).text());
    						targetRecLoc.push(k);
    					}
    				}
    				for(let l = 0; l < orderData.orderItem.length; l++){
    					//判斷這個人的訂購單的物品是否已經有出現過
        				if(targerRecItemName.includes(orderData.orderItem[l].mainCourse.productName)){
        					let targetItemLoc = targerRecItemName.indexOf(orderData.orderItem[l].mainCourse.productName);
        					let targetNumber = parseInt(targetRecItemAmount[targetItemLoc]) + orderData.orderItem[l].amount;
        					rec.eq(targetRecLoc[targetItemLoc]).find('td').eq(2).text(targetNumber);
        				}else{
        					let newStr = '';
        					for(let n = 0; n < orderData.orderItem.length; n++){
                    			newStr = newStr + 
                    				   	 '<tr>' +
                    				   	 '<td>' + orderData.employeeBean.empname + '</td>' +
                    				   	 '<td>' + orderData.orderItem[n].mainCourse.productName + '</td>' +
                    				   	 '<td>' + orderData.orderItem[n].amount + '</td>' +
                    				   	 '<td>' + '<div class="gon btn btn-success">確認領取</div>' + '<td>' +
                    				     '</tr>'         			
                    		}
        					rec.parent().append(newStr);
        				}
        			}
    			}else{
    				rec.text("");
    				let newStr = '';
    				newStr = newStr +
							 "<tr>" + 
							 "<th scope='col'>訂購人姓名</th>" + 
							 "<th scope='col'>訂購餐點</th>" + 
						  	 "<th scope='col'>數量</th>" + 
							 "<th scope='col'>領取按鈕</th>"
							 "</tr>";
    				for(let m = 0; m < orderData.orderItem.length; m++){
            			newStr = newStr + 
            				   	 '<tr>' +
            				   	 '<td>' + orderData.employeeBean.empname + '</td>' +
            				   	 '<td>' + orderData.orderItem[m].mainCourse.productName + '</td>' +
            				   	 '<td>' + orderData.orderItem[m].amount + '</td>' +
            				   	 '<td>' + '<div class="gon btn btn-success">確認領取</div>' + '<td>' +
            				     '</tr>'         			
            		}
    				rec.parent().append(newStr);
    			}
        	}else if(orderData.orderStatus == 0){
        		let iloc = depNos.indexOf(orderData.employeeBean.depBean.depno);
    			let amount = 0;
    			for(let j = 0; j < orderData.orderItem.length; j++){
    				amount = amount + orderData.orderItem[j].amount;
    			}
    			depCountArray[iloc] = depCountArray[iloc] - amount;
    			//判斷對應部門的餐點數量
    			if(depCountArray[iloc] == 0){
    				$(".depCard").find('h2').eq(iloc).text("");
    				$(".depCard").find('h2').eq(iloc).text('無訂購資料');
        			$(".depCard").find('h2').eq(iloc).removeClass('alert alert-danger w-25');
        			$(".depCard").eq(iloc).next().children().find('tbody').text("");
        			$(".depCard").eq(iloc).next().children().find('tbody').html('<tr>' + '<td>' + '尚無資料' + '</td>' + '</tr>');
    			}else{
    				$(".depCard").find('h2').eq(iloc).text("");
        			$(".depCard").find('h2').eq(iloc).text('尚有' + depCountArray[iloc] + '份未領取');
        			$(".depCard").find('h2').eq(iloc).addClass('alert alert-danger w-25');
        			let rec = $(".depCard").eq(iloc).next().find('tr');        			
        			let targerRecItemName = [];
        			let targetRecItemAmount = [];
        			let targetRecLoc = [];
        			for(let k = 1; k < rec.length; k++){
    					//判斷裡面是不是有相同人的訂購資料
    					console.log(rec.eq(k).find('td').eq(0));
    					if(rec.eq(k).find('td').eq(0).text() == orderData.employeeBean.empname){
    						targerRecItemName.push(rec.eq(k).find('td').eq(1).text());
    						targetRecItemAmount.push(rec.eq(k).find('td').eq(2).text());
    						targetRecLoc.push(k);
    					}
    				}
        			for(let l = 0; l < orderData.orderItem.length; l++){
    					//判斷這個人的訂購單的物品是否已經有出現過
        				if(targerRecItemName.includes(orderData.orderItem[l].mainCourse.productName)){
        					let targetItemLoc = targerRecItemName.indexOf(orderData.orderItem[l].mainCourse.productName);
        					let targetNumber = parseInt(targetRecItemAmount[targetItemLoc]) - orderData.orderItem[l].amount;
        					if(targetNumber > 0){
        						rec.eq(targetRecLoc[targetItemLoc]).find('td').eq(2).text(targetNumber);
        						console.log(rec.eq(targetRecLoc[targetItemLoc]));
        					}else{
        						rec.eq(targetRecLoc[targetItemLoc]).remove();
        						console.log(rec.eq(targetRecLoc[targetItemLoc]));
        					}        					
        				}
        			}
    			}
        	}
        	getOrNotAction();
        }
        
        function getOrNotAction(){
        	$('.gon').unbind().click(function(){
        		let getOrNotStatus;
        		let orderListId;
        		if(confirm('是否領取')){
        			getOrNotStatus = 1;
        			let targetEmpName = $(this).parents().eq(1).children().eq(0).text();
        			let targetItemName = $(this).parents().eq(1).children().eq(1).text();
        			let targetItemAmount = $(this).parents().eq(1).children().eq(2).text();
        			for(let i = 0; i < orderData.length; i++){
        				if(orderData[i].employeeBean.empname == targetEmpName){
        					for(let j = 0; j < orderData[i].orderItem.length; j++){
        						if(orderData[i].orderItem[j].mainCourse.productName == targetItemName){
        							$.ajax({
        								url : "${pageContext.request.contextPath}/ordermanage/liststatus",
        		            			type : "POST",
        		            			data : {"getOrNotStatus" : getOrNotStatus,
        		            				    "id" : orderData[i].orderItem[j].id},
        		            			success : function(data){

        		            			}
        							})
        						}
        					}
        				}
        			}
        			$(this).unbind();
        			$(this).removeClass('btn btn-success');
        			$(this).text('已領取');
        			let numberReg = /[0-9]+/;
        			let targetText = $(this).parents().eq(5).prev().find('td').eq(1).text();
        			console.log(targetText);
        			let number = targetText.match(numberReg)[0];
        			if(number - targetItemAmount > 0){
        				targetText = targetText.replace(numberReg, number - targetItemAmount);
        				$(this).parents().eq(5).prev().find('h2').text(targetText);
        			}else{
        				$(this).parents().eq(5).prev().find('h2').text('全部領取完畢');
        				$(this).parents().eq(5).prev().find('h2').removeClass('alert-danger');
        				$(this).parents().eq(5).prev().find('h2').addClass('alert-success');
        			}
        			
        		}
        	});
        }
        
        
    </script>
</body>
</html>