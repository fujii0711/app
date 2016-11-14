<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<!DOCTYPE HTML>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Highcharts Example</title>

	<!-- <script type="text/javascript" src="/resources/Highcharts/api/js/jquery-1.11.3.min.js"></script> -->	
	<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script> -->										
	<script type="text/ecmascript" src="/resources/js/jquery.min.js"></script>
	<style type="text/css"> ${demo.css}
	</style>
	<script type="text/javascript">
	var sample = { 
			data01 : 0,
			data02 : 0,
			data03 : 0,
			data04 : 0,
			data05 : 0,
			data06 : 0
	};
	
	function sampleView(){
		$('#container').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false,
	            type: 'pie'
	        },
	        title: {
	            text: '샘플 데이터 보기'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {
	                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                    }
	                }
	            }
	        },
	        series: [{
	            name: 'Brands',
	            colorByPoint: true,
	            data: [{
	                name: '사과',
	                y: Number(sample.data01)
	            }, {
	                name: '배',
	                y: Number(sample.data02),
	                sliced: true,
	                selected: true
	            }, {
	                name: '오렌지',
	                y: Number(sample.data03)
	            }, {
	                name: '파인애플',
	                y: Number(sample.data04)
	            }, {
	                name: '망고',
	                y: Number(sample.data05)
	            }, {
	                name: '포도',
	                y: Number(sample.data06)
	            }]
	        }]
	    });
	}

	function dataMap(){			
		$.ajax({
			type : "get",
			url : "/sampleMap.do",
			data : {
				country_id  :  "test"
			},
			dataType : "json",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(callback) {
				if(callback.msg =='success'){
					sample.data01 = callback.data01;
					sample.data02 = callback.data02;
					sample.data03 = callback.data03;
					sample.data04 = callback.data04;
					sample.data05 = callback.data05;
					sample.data06 = callback.data06;
					sampleView();
				}
				
				if(callback.msg =='fail'){
					alert("실패");
				}
			},
			error: function(request,status,error){
				console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		});
	}
	</script>
	</head>
	<body>
	<div>
		<input type="button" value="그래프보기" onclick="dataMap();"/>
	</div>
	<script src="/resources/Highcharts/code/highcharts.js"></script>
	<script src="/resources/Highcharts/code/modules/exporting.js"></script>
	<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

	</body>
</html>
