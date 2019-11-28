<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂購總覽</title>

<style>
select {
	-webkit-appearance: none;
}

@media ( min-width : 480px) {
	table {
		width: auto;
	}
}

.table tr {
    cursor: pointer;
}

.hiddenRow {
    padding: 0 4px !important;
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
			<div class="row mt-2">
				<div class="col">
					<div class="card shadow">
						<div class="card-header border-0">
							<h3 class="mb-1 ml-1">訂購紀錄</h3>
							<div class="row d-flex mb-0">
								<div class="col-lg-3">
									<select class="custom-select">
										<option selected hidden>搜尋條件</option>
										<option value="1">本日</option>
										<option value="2">全部</option>
										<option value="3">店家</option>
										<option value="4">日期</option>
									</select>
								</div>
								<div class='col-lg-8'></div>
							</div>
						</div>
						<div id="orderArea" class="table-responsive table-hover">
							<table class="table align-items-center table-flush text-center">
								<thead class="thead-light">
									<tr>
										<th scope="col">
											<h4>訂購編號</h4>
										</th>
										<th scope="col">金額總計</th>
										<th scope="col">付款狀態</th>
										<th scope="col" class="d-none d-lg-table-cell">店家</th>
										<th scope="col" class="d-none d-lg-table-cell">日期</th>
										<th scope="col" class="d-none d-lg-table-cell"></th>
									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
						</div>
						<div class="card-footer py-4">
							<nav aria-label="...">
								<ul class="pagination justify-content-center mb-0">
									<li id="button-down" class="page-item disabled"><div class="page-link"
										tabindex="-1"> <i class="fas fa-angle-left"></i>
											<span class="sr-only">Previous</span>
									</div></li>
									
									<li class="page-item"><div class="page-link"> <i
											class="fas fa-angle-right"></i> <span class="sr-only">Next</span>
									</div></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		let recordPerPage = 5;
		let status = [ "已付款", "未付款", "逾期!" ];
		
		$(document).ready(function() {
			initTable();
		});
		
		function initTable(){
			$.ajax({
				url: "${pageContext.request.contextPath}/orderlist/detail/page=1&recperpage=" + recordPerPage + ".json",
				type: "GET",
				success: function(data){
					console.log(data.orders);
					console.log(data.pageData);
					if(data.orders.length > 0){
						addOrderToTabel(data.orders);
						addUpDownAction(data.pageData);
						addPageButton(data.pageData);
					}else{
						$("#orderArea > table > tbody").text("尚無資料");
						addUpDownAction(data.pageData);
						addPageButton(data.pageData);
					}
					timeCheck();
				}
			});
		}
		
		//將伺服器端接收的資料放入表格 -- 開始
		function addOrderToTabel(product) {
			$("#orderArea > table > tbody").text("");
			for (let i = 0; i < product.length; i++) {
				let status;
				let str = "";
                if(product[i].orderStatus == 0){
                    status = "未付款";
                    bgc = "red";
                }else{
                    status = "已付款";
                    bgc = "green";
                }
                for(let j = 0; j < product[i].orderItem.length; j++){
                	str = str + 
                		"<tr>" +
                		"<td>" + product[i].orderItem[j].mainCourse.productName + "</td>" +
                		"<td>" + product[i].orderItem[j].amount + "</td>" +
                		"<td>" + (product[i].orderItem[j].amount * product[i].orderItem[j].mainCourse.price) + "</td>" +
                		"</tr>"
                }
				$("#orderArea > table > tbody").append(
						"<tr data-toggle='collapse' data-target='#demo" + i + "'>" + "<td>" + product[i].orderName + "</td>" + "<td>"
								+ "NT" + product[i].totalPrice + "</td>" + "<td>"
								+ "<span class='badge badge-dot mr-4'>"
								+ "<i class='bg-" + bgc + "'></i>"
								+ status + "</span></td>"
								+ "<td class='d-none d-lg-table-cell'>"
								+ product[i].orderItem[0].mainCourse.storeBean.storeName + "</td>"
								+ "<td class='d-none d-lg-table-cell time'>"
								+ product[i].enterTime + "</td>"
								+ "<td>" + "<input class='btn btn-danger' type='button' value='取消訂單' />" + "</td>" +
						"</tr>" + 
						"<tr>" + "<td colspan='6' class='hiddenRow'>" +
						"<table class='card accordian-body collapse align-items-center' id='demo" + i +"'>" +
						"<tr><th>商品名稱</th><th>商品數量</th><th>商品總價</th></tr>" +
						str +
						"</table></td>" + 
						"</tr>");
			}
		}

		//將伺服器端接收的資料放入表格 -- 結束

		//依照篩選條件不同新增不同輸入區域--開始
		// = 1 全部 --> 不新增輸入區域
		// = 2 店家 --> 新增輸入區域
		// = 3 日期 --> 新增datepicker
		$("select").change(function() {
							$(this).parents().eq(1).children().eq(1).html("")
							let date = new Date();
							let now = formatDate(date);
							let monday = formatDate(getMonday(date));
							let selectValue = $(this).val();
							if(selectValue == 1 | selectValue == 2){
								let data = {"serchType" : selectValue, "text" : "N"};
								$.ajax({
									url: "${pageContext.request.contextPath}/orderlist/chtype",
									type: "POST",
									data: data,
									success: function(data){
										console.log(data);
										initTable();
									}
								});
							}
							if (selectValue == 3) {
								$(this).parents().eq(1).children().eq(1).append(
												"<div class='form-group mb-0'>"
														+ "<div class='input-group input-group-alternative'>"
														+ "<div class='input-group-prepend'>"
														+ "<span class='input-group-text'><i class='fas fa-search'></i></span>"
														+ "</div>"
														+ "<input id='storeserch' class='form-control' placeholder='Search' type='text'>"
														+ "</div></div>");

								//依照搜尋條件 -- 店家輸入欄尋找對應店家(按下Enter)
								$("input").keydown(function(event) {
									if (event.which == 13) {
										let text = $("#storeserch").val();
										console.log(text);
										$.ajax({
											url: "${pageContext.request.contextPath}/orderlist/chtype",
											type: "POST",
											data:{"serchType" : parseInt(selectValue), "text" : text},
											success: function(data){
												console.log(data);
												initTable();
											}
										});
									}
								});
							}
							if (selectValue == 4) {
								$(this).parents().eq(1).children().eq(1).append(
												"<div class='input-daterange datepicker row align-items-center'>"
														+ "<div class='col'>"
														+ "<div class='form-group'>"
														+ "<div class='input-group input-group-alternative'>"
														+ "<div class='input-group-prepend'>"
														+ "<span class='input-group-text'><i class='ni ni-calendar-grid-58'></i></span>"
														+ "</div>"
														+ "<input id='startDate' class='form-control' placeholder='Start date' type='text' value=" + monday + ">"
														+ "</div></div></div>"
														+ "<div class='col'>"
														+ "<div class='form-group'>"
														+ "<div class='input-group input-group-alternative'>"
														+ "<div class='input-group-prepend'>"
														+ "<span class='input-group-text'><i class='ni ni-calendar-grid-58'></i></span>"
														+ "</div>"
														+ "<input id='endDate' class='form-control' placeholder='End date' type='text' value=" + now + ">"
														+ "</div></div></div></div>");
								$('.datepicker').datepicker('setStartDate', monday);
								$('.datepicker').datepicker("setEndDate", now);
							}
							
						});

		function formatDate(date) {
			var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
					+ d.getDate(), year = d.getFullYear();

			if (month.length < 2)
				month = '0' + month;
			if (day.length < 2)
				day = '0' + day;

			return [ month, day, year ].join('/');
		}

		function getMonday(date) {
			let d = new Date(date);
			var day = d.getDay(), diff = d.getDate() - day
					+ (day == 0 ? -6 : 1); // adjust when day is sunday
			return new Date(d.setDate(diff));
		}
		//依照篩選條件不同新增不同輸入區域--結束
		
		function addPageButton(pageData){
			let str = "";
			let endnum = 0;
			for(let i = 0; i < pageData.totalPage; i++){
				if(i == (pageData.currentPage - 1)){
					str = str + 
					  "<li class='page-item number-button active'>" + 
					  "<div class='page-link'>" + (i + 1) + "</div></li>";
				}else{
					str = str + 
					  "<li class='page-item number-button'>" + 
					  "<div class='page-link'>" + (i + 1) + "</div></li>";
				}
				endnum = endnum + 1;
			}
			$(".number-button").remove();
// 			$("#button-down").nextAll(".number-button").text("");
			$("#button-down").after(str);
			$(".number-button > div").click(function(){
				let currentPage = parseInt($(this).text());
				$.ajax({
					url: "${pageContext.request.contextPath}/orderlist/detail/page=" + currentPage + "&recperpage=" + recordPerPage + ".json",
					type: "GET",
					success: function(data){
						$("#orderArea > table > tbody").text("");
						addOrderToTabel(data.orders);
						addUpDownAction(data.pageData);
						timeCheck();
					}
				});
				$(".number-button").removeClass("active");
				$(this).parent().addClass("active");
			});
		}
		
		function addUpAction(pageData){
			let targetPage = parseInt(pageData.currentPage) + 1;
			$(".page-item").last().click(function(){				
				$.ajax({
					url: "${pageContext.request.contextPath}/orderlist/detail/page=" + targetPage + "&recperpage=" + recordPerPage + ".json",
					type: "GET",
					success: function(data){
						$("#orderArea > table > tbody").text("");
						addOrderToTabel(data.orders);
						addUpDownAction(data.pageData);
						timeCheck();
					}
				});
				$(".number-button").parent().children().eq(targetPage - 1).removeClass("active");
				$(".number-button").parent().children().eq(targetPage).addClass("active");
			});
		}
		
		function addDownAction(pageData){
			let targetPage = parseInt(pageData.currentPage) - 1;
			$(".page-item").first().click(function(){
				$.ajax({
					url: "${pageContext.request.contextPath}/orderlist/detail/page=" + targetPage + "&recperpage=" + recordPerPage + ".json",
					type: "GET",
					success: function(data){
						$("#orderArea > table > tbody").text("");
						addOrderToTabel(data.orders);
						addUpDownAction(data.pageData);
						timeCheck();
					}
				});
				$(".number-button").parent().children().eq(targetPage + 1).removeClass("active");
				$(".number-button").parent().children().eq(targetPage).addClass("active");
			});
		}
		
		function addUpDownAction(pageData){
			if((pageData.currentPage == 1 & pageData.currentPage == pageData.totalPage) | pageData.totalPage == 0){
				$(".page-item").first().unbind( "click" );
				$(".page-item").last().unbind( "click" );
				$(".page-item").first().addClass("disabled");
				$(".page-item").last().addClass("disabled");
			}else if(pageData.currentPage == pageData.totalPage){
				$(".page-item").last().unbind( "click" );
				$(".page-item").first().unbind().bind( "click", addDownAction(pageData));
				$(".page-item").first().removeClass("disabled");
				$(".page-item").last().addClass("disabled");
			}else if(pageData.currentPage == 1){
				$(".page-item").first().unbind( "click" );
				$(".page-item").last().unbind().bind("click", addUpAction(pageData));
				$(".page-item").first().addClass("disabled");
				$(".page-item").last().removeClass("disabled");
			}else{
				$(".page-item").first().unbind().bind( "click", addDownAction(pageData));
				$(".page-item").last().unbind().bind("click", addUpAction(pageData));
				$(".page-item").first().removeClass("disabled");
				$(".page-item").last().removeClass("disabled");
			}
		}
		
		function timeCheck(){
			let DeadLine = "02:00:00";
			let d1 = new Date();
			let todayDate = d1.toLocaleString('zh-TW', {timeZone: 'Asia/Taipei'}).slice(0,10);
			console.log(todayDate);
			let numDate = todayDate.replace(/\//g, "");
			console.log(todayDate.replace(/\//g, "-"));
			let d2 = new Date(todayDate.replace(/\//g, "-") + "T" + DeadLine + "Z");
			let orderTimes = $('td.time');
			console.log(orderTimes);
			for(let i = 0; i < orderTimes.length; i++){
				let targetNumDate = orderTimes.eq(i).text().slice(0,10).replace(/-/g, "");
				let dataDate = new Date(orderTimes.eq(i).text().replace(" ", "T") + "Z");
				console.log(numDate);
				console.log(targetNumDate);
				console.log(numDate > targetNumDate);
				console.log(d1);
				console.log(d2);
				console.log(d1 > d2);
				if(numDate > targetNumDate || d1 > d2){
					console.log(orderTimes.eq(i).parent().find('input'));
					orderTimes.eq(i).parent().find('input').remove();
				}
			}
		}
	</script>
</body>
</html>