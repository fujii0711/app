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
			data01 : [],
			data02 : []
	};

	var sampleView = function(){
	    $('#container').highcharts({
	        chart: {
	            type: 'area'
	        },
	        title: {
	            text: 'US and USSR nuclear stockpiles'
	        },
	        subtitle: {
	            text: 'Source: <a href="http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf">' +
	                'thebulletin.metapress.com</a>'
	        },
	        xAxis: {
	            allowDecimals: false,
	            labels: {
	                formatter: function () {
	                    return this.value; // clean, unformatted number for year
	                }
	            }
	        },
	        yAxis: {
	            title: {
	                text: 'Nuclear weapon states'
	            },
	            labels: {
	                formatter: function () {
	                    return this.value / 1000 + 'k';
	                }
	            }
	        },
	        tooltip: {
	            pointFormat: '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
	        },
	        plotOptions: {
	            area: {
	                pointStart: 0,
	                marker: {
	                    enabled: false,
	                    symbol: 'circle',
	                    radius: 2,
	                    states: {
	                        hover: {
	                            enabled: true
	                        }
	                    }
	                }
	            }
	        },
	        series: [
				        {
				            name: 'USA',
				            data: sample.data01
				        }, {
				            name: 'USSR/Russia',
				            data: sample.data02
				        }
	        		]
	    });
	}
	
	function dataList(){			
		$.ajax({
			type : "get",
			url : "/sampleList.do",
			data : {
				country_id  :  "test"
			},
			dataType : "json",
			contentType : "application/x-www-form-urlencoded;charset=UTF-8",
			success : function(callback) {
				if(callback.msg =='success'){					
					var obj = $.parseJSON(callback.Json);				
					for (var i in obj) {
						sample.data01.push(Number(obj[i].DATA01));
						sample.data02.push(Number(obj[i].DATA05));					
					}
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
		<input type="button" value="그래프보기" onclick="dataList();"/>
	</div>
	<script src="/resources/Highcharts/code/highcharts.js"></script>
	<script src="/resources/Highcharts/code/modules/exporting.js"></script>
	<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

	</body>
</html>
