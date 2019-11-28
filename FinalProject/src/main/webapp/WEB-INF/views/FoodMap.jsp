<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>美食地圖</title>
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
            <jsp:include page="HeadNav10919_map.jsp" />
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
			<div class="row d-md-flex">
				<div class="col-xl-8">
					<div class="card" style="height: 600px;">
						<div class="card-header">
							<h4>美食地圖</h4>
						</div>
						<div id="map"></div>
					</div>
				</div>
				<div class="col-xl-4">
					<div class="card h-100" style="height: 600px;">
						<div class="card-block">
							<div class="card-header pb-0">
								<div class="form-group row">
									<label for="storetype" class="col-4 col-form-label pr-0">
										<h4 class="d-inline">店家類別</h4>
									</label> <select id="storetype" name="storetype"
										class="form-control col-8 pl-0">
										<option value="0" selected="selected">全部</option>
										<option value="1">正餐類</option>
										<option value="2">飲料類</option>
									</select>
								</div>
							</div>
							<div id="button-area" class="row d-flex"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--   GoogleMap   -->
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBfQsYFLzhd52wMdf18-KvmenUEe3O-ES8&callback=initMap"
		type="text/javascript">google.maps.event.addDomListener(window, "load", initialize);</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/dist/eeit10919/dist/js/map-icons.js"></script>
	<script>
		let myLatLng = { lat: 25.033727, lng: 121.542567 };
		let StoreInfo = ${foodMapStoresData};
		let stordatas = Object.assign(StoreInfo);
		var markers1 = [];
		var map;
		
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 17,
				center : myLatLng,
				styles : [ {
					"featureType" : "poi.business",
					"stylers" : [ {
						"visibility" : "off"
					} ]
				}, {
					"featureType" : "poi.park",
					"elementType" : "labels.text",
					"stylers" : [ {
						"visibility" : "off"
					} ]
				} ]
			});
			map.setOptions({
				minZoom : 17,
				maxZoom : 20
			});
			map.setCenter(myLatLng);
			var marker = new google.maps.Marker({
				position : myLatLng,
				map : map,
				title : '當前位置'
			});
			setMapRestaueant(map, stordatas);
		}
		
		function setMapRestaueant(map, storedata) {
			let colorPlate = [
	            { iconcolor: 'red', buttoncolor: 'danger' },
	            { iconcolor: '#FF5511', buttoncolor: 'warning' }
	        ];
	        let icons = [
	            { icon: '<span class="map-icon map-icon-restaurant"></span>' },
	            { icon: '<span class="map-icon map-icon-bar"></span>' }
	        ]
            $('#button-area').html("");
	        if(infowindow){
	        	
	        }
            var infowindow = new google.maps.InfoWindow();
            infowindow.setContent('');
            var butnum = 0;
            for (let i = 0; i < storedata.length; i++) {
                let store = storedata[i];
                var contentString = '<div id="content">' +
                    '<div id="siteNotice">' +
                    '</div>' +
                    '<h1 id="firstHeading" class="firstHeading">' + store.storename + '</h1>' +
                    '<div id="bodyContent">' +
                    '<p>電話 : 02-8978-2668</p>' +
                    '</div>' +
                    '</div>';
                markers1[i] = new mapIcons.Marker({
                    position: { lat: store.lat, lng: store.lng },
                    map: map,
                    icon: {
                        path: 'M0-48c-9.8 0-17.7 7.8-17.7 17.4 0 15.5 17.7 30.6 17.7 30.6s17.7-15.4 17.7-30.6c0-9.6-7.9-17.4-17.7-17.4z',
                        strokeWeight: 0,
                        fillColor: colorPlate[store.storeTypeBean.typeId - 1].iconcolor,
                        fillOpacity: 1,
                        scale: 0.5
                    },
                    map_icon_label: icons[store.storeTypeBean.typeId - 1].icon,
                    title: store.storename
                });
                google.maps.event.addListener(markers1[i], 'click', (function (marker, contentString) {
                    return function () {
                        infowindow.setContent(contentString);
                        infowindow.open(map, marker);
                    }
                })(markers1[i], contentString));
                addButtonAction(markers1[i], store, butnum, colorPlate[store.storeTypeBean.typeId - 1].buttoncolor);
                butnum = butnum + 1;
            }
            return markers1;
        }

        //增加右邊按鈕區域按鈕
        function addButtonAction(marker, store, i, color) {
            if (i % 12 == 0 && Math.floor(i / 12) != 0) {
                $('#button-area').append('<div class="col-4 pl-0"><div class="btn-group-vertical w-100"><button type="button" class="btn btn-block btn-' + color + ' w-100">' + store.storename + '</button></div></div>');
            } else if (i % 12 == 0) {
                $('#button-area').append('<div class="col-4 pr-0"><div class="btn-group-vertical w-100"><button type="button" class="btn btn-block btn-' + color + ' w-100">' + store.storename + '</button></div></div>');
            } else {
                $('.btn-group-vertical').eq(Math.floor(i / 12)).append('<button type="button" class="btn btn-block btn-' + color + ' w-100">' + store.storename + '</button>');
            }
            // $('#button-area').append('<button type="button" class="btn btn-'+ color +'">' + store.name + '</button>');
            $('#button-area button.btn').eq(i).click(function () {
                google.maps.event.trigger(marker, 'click');
            });
        }
        
        $("#storetype").change(function () {
            let selectval = $("#storetype").find(":selected").val();
            if (selectval == 0) {
                stordatas = StoreInfo;
                console.log(stordatas);
            } else {
                let selecttarget = [];
                for (let i = 0; i < StoreInfo.length; i++) {
                    let store = StoreInfo[i];
                    console.log(StoreInfo[i]);
                    if (store.storeTypeBean.typeId == selectval) {
                        selecttarget.push(store);
                    }
                }
                stordatas = selecttarget;
                console.log(stordatas);
            }
            markers1.forEach(function (marker) {
                marker.setMap(null);
            });
            setMapRestaueant(map, stordatas);
        })
	
        function selectAction(StoreInfo, markers1){
        	$("#storetype").change(function () {
                let selectval = $("#storetype").find(":selected").val();
                if (selectval == 0) {
                    stordatas = StoreInfo;
                } else {
                    let selecttarget = [];
                    for (let i = 0; i < StoreInfo.length; i++) {
                        let store = StoreInfo[i];
                        if (store.storeTypeBean.typeId == selectval) {
                            selecttarget.push(store);
                        }
                    }
                    stordatas = selecttarget;
                }
                markers1.forEach(function (marker) {
                    marker.setMap(null);
                });
                setMapRestaueant(map, stordatas);
            })
        }
        
	</script>
</body>
</html>