<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%    // prevent browser cache jsp     
response.setHeader( "Pragma", "no-cache" );
response.addHeader( "Cache-Control", "must-revalidate" );
response.addHeader( "Cache-Control", "no-cache" );
response.addHeader( "Cache-Control", "no-store" );
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本日店家</title>
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
            <jsp:include page="HeadNav10919_order.jsp" />
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
			<div class="row justify-content-md-center">
				<div class="col-lg-9">
					<div class="card justify-content-md-center">
						<div class="card-header text-center">
							<h1>今日店家</h1>
						</div>
						<div id="storearea" class="row">
							<div class="col-lg-6">
								<img class="rounded m-auto d-block" src=""
									style="max-width: 100%; max-height: 100%;">
							</div>
							<div class="col-lg-6">
								<div class="embed-responsive embed-responsive-1by1">
									<iframe src="" class="embed-responsive-item" frameborder="0"
										style="border: 0;" allowfullscreen=""></iframe>
								</div>
							</div>
						</div>
						<div id="productarea" class="row justify-content-md-center mt-4">
							<div class="col-lg-4">
								<div class="card text-center">
									<div class="card-header">
										<h3></h3>
									</div>
									<div class="overflow-hidden d-inline-block">
										<img class="card-img-top" src="" alt="Card image cap">
									</div>
									<div class="card-body">
										<h1></h1>
										<div class="form-group row mb-2">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<button class="btn btn-primary" type="button">-</button>
												</div>
												<input type="text" class="form-control text-center"
													placeholder="" aria-label=""
													aria-describedby="basic-addon1" value="1" readonly>
												<div class="input-group-append">
													<button class="btn btn-primary" type="button">+</button>
												</div>
											</div>
										</div>
										<button type="button" class="btn btn-primary">加入購物車</button>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card text-center">
									<div class="card-header">
										<h3></h3>
									</div>
									<div class="overflow-hidden d-inline-block">
										<img class="card-img-top" src="" alt="Card image cap">
									</div>
									<div class="card-body">
										<h1></h1>
										<div class="form-group row mb-2">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<button class="btn btn-primary" type="button">-</button>
												</div>
												<input type="text" class="form-control text-center"
													placeholder="" aria-label=""
													aria-describedby="basic-addon1" value="1" readonly>
												<div class="input-group-append">
													<button class="btn btn-primary" type="button">+</button>
												</div>
											</div>
										</div>
										<button type="button" class="btn btn-primary">加入購物車</button>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="card text-center">
									<div class="card-header">
										<h3></h3>
									</div>
									<div class="overflow-hidden d-inline-block">
										<img class="card-img-top" src="" alt="Card image cap">
									</div>
									<div class="card-body">
										<h1></h1>
										<div class="form-group row mb-2">
											<div class="input-group mb-3">
												<div class="input-group-prepend">
													<button class="btn btn-primary" type="button">-</button>
												</div>
												<input type="text" class="form-control text-center"
													placeholder="" aria-label=""
													aria-describedby="basic-addon1" value="1" readonly>
												<div class="input-group-append">
													<button class="btn btn-primary" type="button">+</button>
												</div>
											</div>
										</div>
										<button type="button" class="btn btn-primary">加入購物車</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row justify-content-end fixed-bottom">
				<!-- Button trigger modal -->
				<button id="cartbtn" type="button" class="btn btn-primary text-left"
					data-toggle="modal" data-target="#exampleModal">
					<i class="ni ni-cart"></i> <span></span>
				</button>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal right fade" id="exampleModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog .modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title" id="exampleModalLabel">購物車</h2>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="orderList"></div>
					<hr>
					<h2>總計:</h2>
					<h2 id="totalprice">0</h2>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">關閉</button>
					<button id="submit" type="submit" class="btn btn-primary">送出</button>
				</div>
			</div>
		</div>
	</div>

	<script> var base = "${pageContext.request.contextPath}"; </script>
	<script>
		var totalPrice = 0;
		var cart = [];
	 	$(document).ready(function(){
	 		$.ajax({
				url: "${pageContext.request.contextPath}/orderpage.json",
				type: "GET",
				success: function(data){
// 					cart = [];
// 					totalPrice = 0;
					console.log(data);
					checkSessionData(cart, data.cartData);
					actionBind(data, cart);
					pageChangeEvent(cart);
				}
			});
	 	});
		
	 	function addStoreData(data){
			$("#storearea").find("img").attr("src", base + data.store[0].storeImg + "?random=" +new Date().getTime());
			$("#storearea").find("iframe").attr("src", data.store[0].storeMapLink);
		}
	
	 	function addMenuData(product) {
        	for (let i = 0; i < product.length; i++) {
            	$("#productarea > div").find("h3").eq(i).text(product[i].productName);
            	$("#productarea > div").find("img").eq(i).attr("src", base + product[i].productImg + "?random=" +new Date().getTime());
            	$("#productarea > div").find("h1").eq(i).text("NT" + product[i].price);
        	}
   		}

	 	//加入購物車資料
    	function addCartData(names, orderData, cart) {
        	let listLoc = names.indexOf(orderData.productName);
        	console.log("addCartData : ");
        	console.log(orderData);
        	console.log(listLoc);
        	if (listLoc > -1) {
            	cart[listLoc].amount = parseInt(cart[listLoc].amount) + parseInt(orderData.amount);
            	cart[listLoc].totalPrice = parseInt(cart[listLoc].totalPrice) + parseInt(orderData.totalPrice);
            	updateCard(cart, cart[listLoc]);
        	} else {
            	cart.push(orderData);
            	addCard(orderData, cart);
        	}
    	}	 
		
    	//在購物車區塊新增資料卡片
    	function addCard(orderData, cart) {
    		let names = Object.values(cart).map(item => item.productName);
    		let listLoc = names.indexOf(orderData.productName);
    		console.log("addCard : " + listLoc);
        	const div = document.createElement('div');
        	div.className = 'card';
        	div.innerHTML =
            	'<div class="row no-gutters">' +
            	'<div class="row">' +
            	'<div class="col-6">' +
            	'<img src="' + base + orderData.productImg + "?random=" + new Date().getTime() + '" class="card-img"></div>' +
            	'<div class="col-6 justify-content-center align-self-center">' +
            	'<h2>' + orderData.productName + '</h2></div></div>' +
            	'<div class="card-body">' +
            	'<div class="card-text">' +
            	'<div class="row">' +
            	'<div class="form-group col">' +
            	'<h2>數量:</h2>' +
            	'<div class="input-group">' +
            	'<div class="input-group-prepend">' +
            	'<button class="btn btn-primary" type="button">-</button></div>' +
            	'<input type="text" class="form-control text-center" placeholder="" aria-label="" aria-describedby="basic-addon1" value="' + orderData.amount + '" readonly>' +
            	'<div class="input-group-append">' +
            	'<button class="btn btn-primary" type="button">+</button></div></div></div></div>' +
            	'<div class="row">' +
            	'<div class="col-8">' +
            	'<h2 class="d-inline-block">NT</h2><h2 class="d-inline-block">' + orderData.totalPrice + '</h2></div>' +
            	'<div class="col-4">' +
            	'<button type="button" class="btn btn-danger">移除</button>' +
            	'</div></div></div></div></div>';
        	$('div#orderList').append(div);
        	amountButtonAction();
        	incartAmountAction(cart);
        	addRemoveAction(cart, listLoc);
        	console.log("addCard : " + cart);
    	}	
		
    	//更新購物車區塊卡片資料
    	function updateCard(cart, cartData) {
        	let names = Object.values(cart).map(item => item.productName);
        	let listLoc = names.indexOf(cartData.productName);
        	$('div#orderList > div:eq(' + listLoc + ')').find('input').val(cartData.amount);
        	$('div#orderList > div:eq(' + listLoc + ')').find('h2').last().text(cartData.totalPrice);
    	}	

    	//購物車資料新增 -- 結束
    	//模擬 : 購物車新增物品 -- 結束

    	//模擬 : 購物車刪除物品 -- 開始
    	function addRemoveAction(cart, listLoc) {
        	$('div#orderList > div:eq(' + listLoc + ')').find('button').last().click(function () {
        		console.log(listLoc);
            	console.log(cart);
            	let names = Object.values(cart).map(item => item.productName);
            	console.log($(this).parents().eq(4).find('h2').first().text());
            	let newListLoc = names.indexOf($(this).parents().eq(4).find('h2').first().text());
            	console.log(newListLoc);
        		console.log($(this).parents().eq(3).find('h2').last().text());
            	$(this).parents().eq(5).remove();
            	totalPrice = parseInt(totalPrice) - parseInt($(this).parents().eq(3).find('h2').last().text());
            	$('#totalprice').text(totalPrice);
            	cart.splice(newListLoc, 1);
            	console.log(cart);
        	});
    	}	

    	//模擬 : 購物車刪除物品 -- 結束

    	function amountButtonAction() {
        	//數量選擇 -- 增加 -- 開始
        	$('div.input-group-append button:first-child').unbind().on('click', function () {
            	let x = parseInt($(this).parent().prev().val());
            	$(this).parent().prev().val(x + 1).trigger('change');
        	});
        	//數量選擇 -- 增加 -- 結束

        	//數量選擇 -- 減少 -- 開始
        	$('div.input-group-prepend button:first-child').unbind().on('click', function () {
            	let x = parseInt($(this).parent().next().val());
            	if (x > 1) {
                	$(this).parent().next().val(x - 1).trigger('change');
            	}
        	});
        	//數量選擇 -- 減少 -- 結束
    	}	
        	
    	function incartAmountAction(cart) {
        	$('div#orderList > div').find('input').unbind().change(function () {
            	let names = Object.values(cart).map(item => item.productName);
            	console.log(names);
            	let name = $(this).parents('div').eq(5).children().eq(0).find('h2').last().text();
            	let listLoc = names.indexOf(name);
            	totalPrice = totalPrice - cart[listLoc].totalPrice;
            	cart[listLoc].amount = $(this).val();
            	cart[listLoc].totalPrice = cart[listLoc].price * $(this).val();
            	totalPrice = totalPrice + cart[listLoc].totalPrice;
            	$('div#orderList > div:eq(' + listLoc + ')').find('h2').last().text(cart[listLoc].totalPrice);
            	$('#totalprice').text(totalPrice);
        	});
    	}
        	
    	function actionBind(data, cart){
        	let product = data.store[0].mainCourse;

      		$('div.card-body').children('button').click(function () {
           		let names = Object.values(cart).map(item => item.productName);
           		console.log(names);
          		let ncard = $(this).parent().parent().parent().index();
           		let orderData = Object.assign({}, product[ncard]);
           		let amountKey = "amount";
           		let amountValue = $(this).prev().children().children('input').val();
           		let amountReg = /[0-9]+/;
           		if (amountReg.test(amountValue)) {
               		orderData[amountKey] = amountValue;
               		orderData['totalPrice'] = amountValue * product[ncard].price;
               		orderData['ncard'] = ncard;
               		addCartData(names, orderData, cart);
               		console.log(totalPrice);
               		totalPrice = parseInt(totalPrice) + parseInt(amountValue * product[ncard].price);
               		$('#totalprice').text(totalPrice);
               		alert('新增成功!');
           		} else {
               		alert('資料內容有誤!');
          		}

       		});
      		
      		addStoreData(data);
            addMenuData(product);
        	amountButtonAction();
        	submitAction(cart);
        	pageChangeEvent(cart);
        }    
        
    	//送出動作
        function submitAction(cart){        	
        		$("#submit").on("click",function(){
        			if(cart.length != 0){
            			cartStr = JSON.stringify(cart);
            			console.log(cartStr);
            			$.ajax({
        					url: "${pageContext.request.contextPath}/orderdata/orderList",
        					data: cartStr,
        					contentType: "application/json",
        					type: "POST",
        					success: function(data){
        						alert("新增成功!");
        						cart.splice(0, cart.length);
            					totalPrice = 0;
        						$("#orderList").html("");
            					$('#totalprice').text(totalPrice);
            					console.log(totalPrice);
        					}
        				});
            		}else{
            			alert("購物車裡面沒有東西0 A0!");
            		}	
        		});      		
        }
        
        function checkSessionData(cart, sessionData){
        	if(sessionData != null){
        		let orderData = Object.assign({}, sessionData);
        		for(i = 0; i < sessionData.length; i++){
        			cart[i] = sessionData[i];
        			addCard(orderData[i], cart, i);
        			totalPrice = totalPrice + cart[i].totalPrice;
        		}
        		$('#totalprice').text(totalPrice);
        	}
        }
        
        function pageChangeEvent(cart){
        	$(window).on('beforeunload', function () {
                cartStr = JSON.stringify(cart);
                console.log(cartStr);
                $.ajax({
            		url: "${pageContext.request.contextPath}/orderdata/cart",
            		data: cartStr,
            		contentType: "application/json",
            		type: "POST",
            		success: function(data){
							
            		}
            	});               
            });
        }       
	</script>
</body>
</html>