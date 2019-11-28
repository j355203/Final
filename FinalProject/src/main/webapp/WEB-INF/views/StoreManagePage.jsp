<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>店家管理</title>
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
            <jsp:include page="HeadNav10919_store.jsp" />
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
			<div class="row">
				<div class="card w-100">
					<!-- StorePageCard Start -->
					<!-- 卡片標題 -- 開始 -->
					<div class="card-header">
						<div class="row">
							<div class="col">
								<div class="row">
									<div class="col-auto">
										<h1>店家列表</h1>
									</div>
									<div class="col-1">
										<a data-toggle='modal' data-target='#exampleModalCenter' data-backdrop='static' data-keyboard='false'  class="addStore d-inline-block" title="新增店家"
											href="">
											<button id="addbtn" type="button"
												class="btn btn-danger text-left">
												<i class="fas fa-plus-square"></i> <span></span>
											</button>
										</a>
									</div>
									<div class="w-100"></div>
									<div class="col-lg-3">
										<select class="custom-select">
											<option selected hidden>搜尋條件</option>
											<option value="2">全部</option>
											<option value="3">店家名稱</option>
											<option value="3">店家編號</option>
										</select>
									</div>
									<div class="col-lg-9"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- CardHeader End -->
					<!-- CardBody Start -->
					<div class="card-body row table-responsive table-hover">
						<table class="table align-items-center table-flush">
							<thead class="thead-light text-center">
								<tr>
									<th scope="col">
										<h4>店家圖片</h4>
									</th>
									<th scope="col">
										<h4>店家名稱</h4>
									</th>
									<th scope="col">
										<h4>店家類型</h4>
									</th>
									<th scope="col">
										<h4>狀態</h4>
									</th>
									<th scope="col" class="d-none d-lg-table-cell">
										<h4>編輯</h4>
									</th>
								</tr>
							</thead>
							<tbody class="text-center">

							</tbody>
						</table>
					</div>
				</div>
				<!-- StorePageCard End -->
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				
					<div class="card">
						<h3 class="card-header text-center">商店資訊</h3>
						<div class="card-body p-0 row">
							<div class="col-6">
								<div class="addPageImageArea col float-right mt-4">
									<img src="" id="productImg"> <label for="imgUp"
										class="imgHint">點一下以上傳圖片</label> <input type="file"
										name="filename" id="imgUp"
										accept="image/gif, image/jpeg, image/png"
										style="display: none">
								</div>
							</div>
							<div class="col-6">
								<div class="addPageInfoArea">
									<div class="row pb-4 mt-3 justify-content-end">
										<div class="col-md-3">商店名稱 :</div>
										<div class="col-md-9 pl-0">
											<input type="text" id="productName" placeholder="請輸入名稱" />
										</div>
										<div class="col-md-9 msg"></div>
									</div>
									<div class="row pb-4 justify-content-end">
										<div class="col-md-3">種類 :</div>
										<div class="col-md-9 pl-0">
											<input type="radio" name="type" checked="true" value="1"/>正餐類 <input
												type="radio" name="type" value="2"/>飲料類
										</div>
										<div class="col-md-9 msg"></div>
									</div>
									<div class="row pb-4 justify-content-end">
										<div class="col-md-3">狀態 :</div>
										<div class="col-md-9 pl-0">
											<input type="radio" name="status" checked="true" value="1"/>開放中 <input
												type="radio" name="status" value="0"/>關閉中
										</div>
										<div class="col-md-9 msg"></div>
									</div>
									<div class="row pb-4 justify-content-end">
										<div class="col-md-3">地圖連結 :</div>
										<div class="col-md-9 pl-0">
											<input type="text" id="productMapLink"
												placeholder="請輸入google分享地圖" />
										</div>
										<div class="col-md-9 msg"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="row justify-content-center pb-3">
							<div>
								<input id="submit" class="btn btn-primary" type="submit"
									value="確認修改" /> 
								<input class="btn btn-primary" type="button"
									value="回列表" data-dismiss="modal">
								<input id="storeDemo" class="btn btn-info" type="button" value="展示用"/>
							</div>
						</div>
					
				</div>
			</div>
		</div>
	</div>

	<!--<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>-->
	<!-- Add mousewheel plugin (this is optional) -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/fancybox-2.1.7/lib/jquery.mousewheel.pack.js"></script>
	<!-- Add fancyBox -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/fancybox-2.1.7/source/jquery.fancybox.pack.js?v=2.1.7"></script>
	<script>
		//資料模擬 開始
		let pageData;
		let recPerPage = 1;
		let storesData;
		//定位用名稱陣列
		let names;
		let actionType;
		let targetData;
		//送圖片用的仿造form
		let formData = new FormData();
		//紀錄原本圖片的名字
		let imgName = [];
		//資料模擬 結束

		//增加商店資訊到表格 開始
		function addDataToTable(storeDatas) {
			let status = [ "關閉", "開放中" ];
			let str = "";
			$("tbody").text("");
			for (let i = 0; i < storeDatas.length; i++) {
				imgName[i] = storesData[i].storeImg;
				storesData[i].storeImg = storesData[i].storeImg + "?random=" +new Date().getTime();
				console.log(storesData[i].storeImg);
				let statusImg;
				if(storesData[i].storeStatus == 1){
					statusImg = "<a class='dropdown-item text-red'><i class='fas fa-arrow-down'></i>關閉店家</a>"
				}else{
					statusImg = "<a class='dropdown-item text-green'><i class='fas fa-arrow-up'></i>開啟店家</a>"
				}
				str = str
						+ "<tr>"
						+ "<td>"
						+ "<div class='imgBox'>"
						+ "<img src='" + "${pageContext.request.contextPath}" + storeDatas[i].storeImg + "'>"
						+ "</div>"
						+ "<td>"
						+ storeDatas[i].storeName
						+ "</td>"
						+ "<td>"
						+ storeDatas[i].storeType
						+ "</td>"
						+ "<td>"
						+ status[storeDatas[i].storeStatus]
						+ "</td>"
						+ "<td>"
						+ "<div class='dropdown'>"
						+ "<a class='btn btn-sm btn-icon-only text-dark edit-button' href='#' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>"
						+ "<i class='fas fa-ellipsis-v fa-2x'></i>"
						+ "</a>"
						+ "<div class='dropdown-menu dropdown-menu-left dropdown-menu-arrow'>"
						+ "<a data-toggle='modal' data-target='#exampleModalCenter' data-backdrop='static' data-keyboard='false' class='dropdown-item update-store text-blue'>"
						+ "<i class='fas fa-pencil-alt fa-2x'></i>修改店家資訊</a>"
						+ "<a class='dropdown-item' href='${pageContext.request.contextPath}/mainCourse'><i class='fas fa-list'></i></i>商品一覽</a>"
						+ "</div></div></td></td>"
			}
			$("tbody").append(str);
		}

		//增加商店資訊到表格 結束
	</script>
	<script>
		$(document).ready(function() {
			initTable(${pageInfo});
			pageData = ${pageInfo};
		});
		
		//初始化表格內容
		function initTable(pageData){
			$.ajax({
				url : "${pageContext.request.contextPath}/storemanage/store/page=" + pageData.currentPage + "&recperpage="
						+ pageData.recPerPage + ".json",
				type : "GET",
				success : function(data) {
					storesData = data.storeData;
					names = Object.values(storesData).map(item => item.storeName);
					console.log(storesData);
					console.log(pageData);
					console.log(names);
					addDataToTable(storesData);
					addDataToModal(storesData, names);
					modalAction();
					newStore(storesData);
					addDataButtonAction();
					preloadData(storesData);
					cache: false;
				}
			});
		}
	</script>
	<script>
     	let nameStatus;
     	let mapLinkStatus;
     	let correctImgString = "<img src='${pageContext.request.contextPath}/images/ok.png'>";
     	let wrongImgSting = "<img src='${pageContext.request.contextPath}/images/wrong.png'>";
     	
     	//將modal中除了submit的按鈕和輸入都綁上對應的事件
		function modalAction(){
	        
			$("#imgUp").unbind().change(function (event) {
	            uploadImg(this);
	            cleanImgBoxText();
	        });

	        $("#productName").unbind().blur(function () {
	            checkNameInput();
	        });

	        $("#productMapLink").unbind().blur(function () {
	            checkMapLinkInput();
	        });
	        
	        $("#submit").next().unbind().click(function(){
	        	cleanMsg();
	        	console.log(storesData);
	        });
		}
     	
     	//取得更改的資訊
     	function getData(targetData, listLoc){
     		let storeData = Object.assign({}, targetData);
     		delete storeData.mainCourse;
     		storeData.storeName = $("#productName").val();
     		if($("input[name=type]:checked").val() == 1){
     			storeData.storeType = "正餐類";
     		}else if($("input[name=type]:checked").val() == 2){
     			storeData.storeType = "飲料類";
     		}
     		storeData.storeStatus = $("input[name=status]:checked").val();
     		storeData.storeMapLink = $("#productMapLink").val();
     		storeData.storeImg = imgName[listLoc];
     		console.log($("#imgUp").val() == "");
     		return storeData;
     	}
     	
     	function getNewData(targetData, listLoc){
     		let newData = new FormData();
     		newData.append("storeName", $("#productName").val());
     		if($("input[name=type]:checked").val() == 1){
     			newData.append("storeType", "正餐類");
     		}else if($("input[name=type]:checked").val() == 2){
     			newData.append("storeType", "飲料類");
     		}
     		newData.append("storeStatus", $("input[name=status]:checked").val());
     		newData.append("storeMapLink", $("#productMapLink").val());
     		return newData;
     	}
     	
     	//上傳圖片到server端
     	function uploadFile(formData) {
     		console.log(formData.get("img"));
     	    $.ajax({
     	       url: "${pageContext.request.contextPath}/storemanage/updateimg",
     	       type: "POST",
     	       data: formData,
     	       processData: false,
     	       contentType: false,
     	       success: function(response) {
     	           console.log("success");
     	           formData.delete("img");
     	       }
     	    });
     	}
		
     	//modal送出按鈕事件
		function submitAction(targetData, listLoc, actionType){
			console.log(targetData);
			console.log(actionType);
     		if(actionType == 1){
     			console.log("im 1");
     			$("#submit").unbind().click(function () {
    	            let status = submitCheck();
    	            if (status == true) {
    	            	let newData = getData(targetData, listLoc);
    	            	console.log(newData);
    	            	let dataStr = JSON.stringify(newData);
    	            	console.log(dataStr);
    	            	$.ajax({
    	            		url : "${pageContext.request.contextPath}/storemanage/updatestore",
    	            		contentType: "application/json",
        					type: "POST",
        					data : dataStr,
        					success : function(data){
        						uploadFile(formData);
        						alert("編輯成功");
        						console.log(data);
        						initTable(pageData);
        		                $("#exampleModalCenter").modal('toggle');
        		                cleanMsg();
        					}
    	            	});	                
    	                return status;
    	            } else {
    	                return status;
    	            }
    	        });
     		}else if(actionType == 2){
     			console.log("im 2");
     			$("#submit").unbind().click(function () {
    	            let status = submitCheck();
    	            if (status == true) {
    	            	console.log(targetData);
    					let newData = getNewData(targetData, listLoc);
    	            	console.log(newData);
    	            	$.ajax({
    	            		url : "${pageContext.request.contextPath}/storemanage/addstore",
        					type: "POST",
        					processData: false,
        		     	    contentType: false,
        					data : newData,
        					success : function(data){
        						uploadFile(formData);
        						alert("編輯成功");
        						console.log(data);
        						initTable(pageData);
        		                $("#exampleModalCenter").modal('toggle');
        		                cleanMsg();
        					}
    	            	});	                
    	                return status;
    	            } else {
    	                return status;
    	            }
     			});			     		
			}
     	}
		
     	//增加按鈕的動作事件
		function addDataButtonAction(){
			$(".addStore").unbind().click(function(){
				$("#productName").val("");
				$("#productMapLink").val("");
				$("#productImg").attr("src", "");
				initImgBoxText();
			});
		}
     	
     	function preloadData(data){
     		$(".edit-button").unbind().click(function(){
     			let currentName = $(this).parents().eq(2).children().eq(1).text();
				console.log(currentName);
				let listLoc = names.indexOf(currentName);
				console.log(listLoc);		
				targetData = data[listLoc];
				console.log(targetData);	
     			$.ajax({
					url : "${pageContext.request.contextPath}/storemanage/store/store=" + targetData.storeId + ".json",
					type : "GET",
					success : function(data) {
						console.log(data);
					}
				});
     		});
     	}
		
     	//將資料帶入modal中順便綁定事件
		function addDataToModal(data, names){
			$(".update-store").unbind().click(function(){
				actionType = 1;				
				let currentName = $(this).parents().eq(3).children().eq(1).text();
				console.log($(this).parents());
				let listLoc = names.indexOf(currentName);
				console.log(listLoc);		
				targetData = data[listLoc];
				console.log(targetData);
				$("#productName").val(targetData.storeName);
				$("#productMapLink").val(targetData.storeMapLink);
				$("#productImg").attr("src", "${pageContext.request.contextPath}" + targetData.storeImg);
				let storeTypeValue;
				if(targetData.storeType == "正餐類"){
					storeTypeValue = 1;
				}else if(targetData.storeType == "飲料類"){
					storeTypeValue = 2;
				}
				$("input[name=type][value='"+ storeTypeValue + "']").prop("checked", true);
				$("input[name=status][value='"+ targetData.storeStatus + "']").prop("checked", true);				
				cleanImgBoxText();
				submitAction(targetData, listLoc, actionType);
			});
		}
     	
     	function newStore(data){
     		$("#addbtn").unbind().click(function(){
     			actionType = 2;
     			let listLoc = 0;
     			targetData = data[listLoc];
     			console.log(targetData);
     			cleanImgBoxText();
				submitAction(targetData, listLoc, actionType);
     		});
     	}
	 
		//清除訊息區塊
        function cleanMsg(){
        	$(".msg").html("");
        }

		//上傳圖片並顯示到指定區域
        function uploadImg(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                var filename = $("#imgUp").val();
            }
            reader.onload = function (e) {
                $('#productImg').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
            var blobFile = input.files[0];
            formData.append("img", blobFile);
        }

        function cleanImgBoxText() {
            $(".imgHint").html("&nbsp");
        }
        
        function initImgBoxText(){
        	$(".imgHint").html("點一下以上傳圖片");
        }

        function checkIdInput() {
            let idTextBox = $("#productId");
            let idString = idTextBox.val();
            let idMsg = $("#productId").parent().next();
            console.log(idMsg);
            let idRegex = /^[a-zA-Z]{3}[0-9]{3}/;
            if (idString.length == 0) {
                idMsg.html(
                    wrongImgSting + "代號不得空白"
                );
                idMsg.css(
                    "color", "red"
                );
                idStatus = 1;
            } else if (!idRegex.test(idString)) {
                idMsg.html(
                    wrongImgSting + "代號格式有誤"
                );
                idMsg.css(
                    "color", "red"
                );
                idStatus = 1;
            } else {
                idMsg.html(
                    correctImgString + "正確"
                );
                idMsg.css(
                    "color", "lime"
                );
                let storeCode = idString.substring(0, 4).toUpperCase();
                let productCode = idString.substring(4, 7);
                let productId = storeCode + productCode;
                idTextBox.val(productId);
                idStatus = 0;
            }
        }

        function checkNameInput() {
            let nameTextBox = $("#productName");
            let nameString = nameTextBox.val();
            let nameMsg = $("#productName").parent().next();
            if (nameString.length == 0) {
                nameMsg.html(
                    wrongImgSting + "名稱不得空白"
                );
                nameMsg.css(
                    "color", "red"
                );
                nameStatus = 1;
            } else {
                nameMsg.html(
                    correctImgString + "正確"
                );
                nameMsg.css(
                    "color", "lime"
                );
                nameStatus = 0;
            }
        }

        function checkPriceInput() {
            let priceTextBox = $("#productPrice");
            let priceString = priceTextBox.val();
            let priceMsg = $("#productPrice").parent().next();
            let priceReg = /^[0-9]+$/;
            let priceReg2 = /^0.+/;
            if (priceString.length == 0) {
                priceMsg.html(wrongImgSting + "價格不得空白");
                priceMsg.css("color", "red");
                priceStatus = 1;
            } else if (!priceReg.test(priceString)) {
                priceMsg.html(wrongImgSting + "價格只能輸入數字");
                priceMsg.css("color", "red");
                priceStatus = 1;
            } else {
                if (priceReg2.test(priceString)) {
                    priceMsg.html(wrongImgSting + "價格第一位不得為0");
                    priceMsg.css("color", "red");
                    priceStatus = 1;
                } else {
                    priceMsg.html(correctImgString + "正確");
                    priceMsg.css("color", "lime");
                    priceStatus = 0;
                }
            }
        }

        function checkMapLinkInput(){
            let mapTextBox = $("#productMapLink");
            let mapString = mapTextBox.val();
            console.log(mapString);
            let pmapMsg = $("#productMapLink").parent().next();
            let mapReg = /^https:\/\/www.google.com.+/;
            if(!mapReg.test(mapString)){
                pmapMsg.html(wrongImgSting + "請輸入正確的網址");
                pmapMsg.css("color", "red");
                mapLinkStatus = 1;
            }else{
                pmapMsg.html(correctImgString + "正確");
                pmapMsg.css("color", "lime");
                mapLinkStatus = 0;
            }
        }

        function submitCheck() {
            checkNameInput();
            checkMapLinkInput();
            let statusCode = nameStatus + mapLinkStatus;
            if (statusCode == 0) {
                return true;
            } else {
                alert("仍有錯誤，請檢查!");
                return false;
            }
        }
        
        $("#storeDemo").click(function(){
        	$("#productName").val("鬍鬚張");
        	$("#productMapLink").val("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3039.861299520083!2d121.54437220370127!3d25.03323629566759!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x287499b6d2526518!2z6ayN6aya5by16a2v6IKJ6aOvIOWPsOWMl-Wkp-WuieW6lw!5e0!3m2!1szh-TW!2stw!4v1574768275213!5m2!1szh-TW!2stw");
        });
    </script>
</body>
</html>