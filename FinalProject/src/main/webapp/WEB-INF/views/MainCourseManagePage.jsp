<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>餐點管理</title>
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
            <jsp:include page="HeadNav10919_maincourse.jsp" />
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
					<!-- 卡片標題 -- 開始 -->
					<div class="card-header">
						<div class="row">
							<div class="col-lg-2">
								<div id="storeImg" class="imgBox">
									<img src="">
								</div>
							</div>
							<div class="col-lg-10 p-0">
								<div class="row">
									<div id="storeName" class="col-auto">
										<h1 class="d-inline-block"></h1>
									</div>
									<div class="col-auto d-flex">
										<a data-toggle='modal' data-target='#exampleModalCenter'
											data-backdrop='static' data-keyboard='false'
											class="addProduct d-inline-block" title="新增店家" href="">
											<button id="addbtn" type="button"
												class="btn btn-danger text-left">
												<i class="fas fa-plus-square"></i> <span></span>
											</button>
										</a> <a class="d-inline-block ml-2" title="返回店家列表"
											href="${pageContext.request.contextPath}/storemanage">
											<button id="bkbtn" type="button"
												class="btn btn-primary text-left">
												<i class="far fa-arrow-alt-circle-left"></i> <span></span>
											</button>
										</a>
									</div>
									<div class="w-100"></div>
									<div class="col-lg-3">
										<select class="custom-select">
											<option selected hidden>搜尋條件</option>
											<option value="1">本日</option>
											<option value="2">全部</option>
											<option value="3">店家</option>
											<option value="4">日期</option>
										</select>
									</div>
									<div class="col-lg-9"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- 卡片標題 -- 結束 -->
					<!-- 卡片主體 -- 開始 -->
					<div class="card-body">
						<div id="orderArea" class="table-responsive table-hover">
							<table class="table align-items-center table-flush">
								<thead class="thead-light text-center">
									<tr>
										<th scope="col">
											<h4>商品圖片</h4>
										</th>
										<th scope="col">
											<h4>商品名稱</h4>
										</th>
										<th scope="col">
											<h4>商品價格</h4>
										</th>
										<th scope="col">
											<h4>商品種類</h4>
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
					<!-- 卡片主體 -- 結束 -->
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
													<div class="col-md-3">商品名稱 :</div>
													<div class="col-md-9 pl-0">
														<input type="text" id="productName" placeholder="請輸入名稱" />
													</div>
													<div class="col-md-9 msg"></div>
												</div>
												<div class="row pb-4 justify-content-end">
													<div class="col-md-3">價格 :</div>
													<div class="col-md-9 pl-0">
														<input type="text" id="productPrice" placeholder="請輸入價格" />
													</div>
													<div class="col-md-9 msg"></div>
												</div>
												<div class="row pb-4 justify-content-end">
													<div class="col-md-3">種類 :</div>
													<div class="col-md-9 pl-0">
														<input type="radio" name="type" checked="true" value="1" />葷
														<input type="radio" name="type" value="2" />素
													</div>
													<div class="col-md-9 msg"></div>
												</div>
												<div class="row pb-4 justify-content-end">
													<div class="col-md-3">狀態 :</div>
													<div class="col-md-9 pl-0">
														<input type="radio" name="status" checked="true" value="1" />上架中
														<input type="radio" name="status" value="0" />下架中
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
											<input class="btn btn-primary"
												type="button" value="回列表" data-dismiss="modal">
											<input id="mainCourseDemo" class="btn btn-info" type="button" value="展示用"/>
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
		let status = [ "下架中", "上架中" ];
		let type = ["葷", "素"];
		let pageData;
		let recPerPage = 1;
		let storeData;
		//紀錄原本圖片的名字
		let imgName = [];
		//增加商店圖片到指定區域
		function addStoreLogo(storeData){
			$("#storeImg > img").attr("src", "${pageContext.request.contextPath}" + ${storeImg} + "?random=" +new Date().getTime());
		}
		
		function addStoreName(storeData){
			$("#storeName > h1").text(${storeName});
		}
		
		//增加商店資訊到表格 開始
		function addDataToTable(storeData) {
			addStoreLogo(storeData);
			addStoreName(storeData);
			let status = [ "下架中", "上架中" ];
			let str = "";
			$("tbody").text("");
			for (let i = 0; i < storeData.length; i++) {
				imgName[i] = storeData[i].productImg;
				storeData[i].productImg = storeData[i].productImg + "?random=" +new Date().getTime();
				console.log(storesData[i].productImg);
				let statusImg;
				if(storesData[i].productStatus == 1){
					statusImg = "<a class='dropdown-item text-red'><i class='fas fa-arrow-down'></i>下架商品</a>"
				}else{
					statusImg = "<a class='dropdown-item text-green'><i class='fas fa-arrow-up'></i>上架商品</a>"
				}
				str = str
						+ "<tr>"
						+ "<td>"
						+ "<div class='imgBox'>"
						+ "<img src='" + "${pageContext.request.contextPath}" + storeData[i].productImg + "'>"
						+ "</div>"
						+ "<td>"
						+ storeData[i].productName
						+ "</td>"
						+ "<td>"
						+ storeData[i].price
						+ "</td>"
						+ "<td>"
						+ type[storeData[i].productType - 1]
						+ "</td>"
						+ "<td>"
						+ status[storeData[i].productStatus]
						+ "</td>"
						+ "<td>"
						+ "<div class='dropdown'>"
						+ "<a class='btn btn-sm btn-icon-only text-dark edit-button' href='#' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>"
						+ "<i class='fas fa-ellipsis-v fa-2x'></i>"
						+ "</a>"
						+ "<div class='dropdown-menu dropdown-menu-left dropdown-menu-arrow'>"
						+ "<a data-toggle='modal' data-target='#exampleModalCenter' data-backdrop='static' data-keyboard='false' class='dropdown-item update-store text-blue'>"
						+ "<i class='fas fa-pencil-alt fa-2x'></i>修改商品資訊</a>"
						+ "</div></div></td></td>"
			}
			$("tbody").append(str);
		}

		//增加商店資訊到表格 結束
		
		$(document).ready(function() {
			initTable(${pageInfo});
			pageData = ${pageInfo};
		});
		
		//初始化表格內容
		function initTable(pageData){
			$.ajax({
				url : "${pageContext.request.contextPath}/mainCourse/page=" + pageData.currentPage + "&recperpage="
						+ pageData.recPerPage + ".json",
				type : "GET",
				success : function(data) {
					storesData = data.mainCourseList;
					console.log(storesData);
					names = Object.values(storesData).map(item => item.productName);
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
		let actionType;
		let targetData;
		//送圖片用的仿造form
		let formData = new FormData();
		
		function preloadData(data){
     		$(".edit-button").unbind().click(function(){
     			let currentName = $(this).parents().eq(2).children().eq(1).text();
				console.log(currentName);
				let listLoc = names.indexOf(currentName);
				console.log(listLoc);		
				targetData = data[listLoc];
				console.log(targetData);	
     			$.ajax({
					url : "${pageContext.request.contextPath}/mainCourse/mainCourse=" + targetData.productId + ".json",
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
			  $("#productName").val(targetData.productName);
			  $("#productPrice").val(targetData.price);
			  $("#productImg").attr("src", "${pageContext.request.contextPath}" + targetData.productImg);
			  let storeTypeValue;
			  if(targetData.productType == 1){
				  storeTypeValue = 0;
			  }else if(targetData.productType == 2){
				  storeTypeValue = 1;
			  }
			  $("input[name=type][value='"+ storeTypeValue + "']").prop("checked", true);
			  $("input[name=status][value='"+ targetData.productStatus + "']").prop("checked", true);				
			  cleanImgBoxText();
			  submitAction(targetData, listLoc, actionType);
		  });
	    }
	    
	    //新增按鈕的前置作業
		function newStore(data){
     		$("#addbtn").unbind().click(function(){
     			actionType = 2;
     			console.log(actionType);
     			let listLoc = 0;
     			targetData = data[listLoc];
     			console.log(targetData);
     			cleanImgBoxText();
				submitAction(targetData, listLoc, actionType);
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
    	            		url : "${pageContext.request.contextPath}/mainCourse/update",
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
    	            		url : "${pageContext.request.contextPath}/mainCourse/add",
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
	    
	    //取得更改的資訊
 		function getData(targetData, listLoc){			
 			let storeData = Object.assign({}, targetData);
 			storeData.productName = $("#productName").val();
 			if($("input[name=type]:checked").val() == 1){
 				storeData.productType = "1";
 			}else if($("input[name=type]:checked").val() == 2){
 				storeData.productType = "2";
 			}
 			storeData.productStatus = $("input[name=status]:checked").val();
 			storeData.price = $("#productPrice").val();
 			storeData.productImg = imgName[listLoc];
 			console.log(storeData.productImg);
 			return storeData;
 		}
		
 		function getNewData(targetData, listLoc){
 			let newData = new FormData();
 			newData.append("productName", $("#productName").val());
 			if($("input[name=type]:checked").val() == 1){
 				newData.append("productType", "1");
 			}else if($("input[name=type]:checked").val() == 2){
 				newData.append("productType", "2");
 			}
 			newData.append("productStatus", $("input[name=status]:checked").val());
 			newData.append("price", $("#productPrice").val());	
     		return newData;
     	}
 		
 		//上傳圖片到server端
     	function uploadFile(formData) {
     		console.log(formData.get("img"));
     	    $.ajax({
     	       url: "${pageContext.request.contextPath}/mainCourse/updateimg",
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
 		
     	
	</script>
	<script type="text/javascript">
		let nameStatus;
 		let priceStatus;
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

	        $("#productPrice").unbind().blur(function () {
	            checkPriceInput();
	        });
	        
	        $("#submit").next().unbind().click(function(){
	        	cleanMsg();
	        	console.log(storesData);
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
        
        function submitCheck() {
            checkNameInput();
            checkPriceInput();
            let statusCode = nameStatus + priceStatus;
            if (statusCode == 0) {
                return true;
            } else {
                alert("仍有錯誤，請檢查!");
                return false;
            }
        }
        
        //增加按鈕的動作事件
		function addDataButtonAction(){
			$(".addProduct").unbind().click(function(){
				$("#productName").val("");
				$("#productPrice").val("");
				$("#productImg").attr("src", "");
				initImgBoxText();
			});
		}
        
		$("#mainCourseDemo").click(function(){
        	$("#productName").val("經典魯肉便當");
        	$("#productPrice").val("98");
        });
	</script>
</body>
</html>