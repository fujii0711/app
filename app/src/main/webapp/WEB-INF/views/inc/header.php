<!doctype html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>HEMS 관리시스템</title>
<meta name="Publisher" content="cdc" />
<meta name="Keywords"  content="cdc" />
<meta name="Description" content="cdc" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta name="format-detection" content="telephone=no" />

<!-- css -->
<link  href="/resources/css/common.css" rel="stylesheet" type="text/css" />
<link  href="/resources/css/layout.css" rel="stylesheet" type="text/css" />
<link  href="/resources/css/swiper.min.css" rel="stylesheet" type="text/css" />
<!-- js -->
<script src="/resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){

	//메뉴슬라이드
	$("p.openGnb").click(function(){
		$("p.backBg").fadeIn("slow");
		$(this).next(".gnbArea").animate({
				'left':'0px',
		});

	});
	$("p.closeGnb").click(function(){
		$(this).parents(".gnbArea").animate({
				'left':'-300px',
		});
		$("p.backBg").fadeOut("slow");
	});

	//tab
	$(".tab_content").hide();
		$("#tab1").show();
		$("ul.tabs li").click(function () {
			$("ul.tabs li").removeClass("active");
			$(this).addClass("active");
			$(".tab_content").hide()
			var activeTab = $(this).attr("rel");
			$("#" + activeTab).fadeIn()
    });

});
</script>
</head>
<body>
<div class="wrap">

	<!-- headerArea -->
	<div class="headerArea">
		<div class="headerTop">
			<h1><a href="/hems/index.html">HEMS 관리시스템</a></h1>
		</div>
		<p class="openGnb"><a href="javascript:void(null);"><img src="/hems/images/btn_openMenu.png"  alt="메뉴오픈"></a></p>
		<div class="gnbArea">
			<div id="" class="gnbHeader">
				<h2>홍길동</h2>
				<p class="closeGnb"><a href="javascript:void(null);"><img src="/hems/images/bnt_close.png"  border="0" alt="메뉴닫기"></a></p>
			</div>
			<ul class="gnb">
				<li class="iconA active"><a href="javascript:void(null);">전력현황</a>
					<ul class="gnb2">
						<li class="focus"><a href="/hems/html/a01.html">세대 전력 현황</a></li>
						<li><a href="/hems/html/a02.html">(일별)기기별 상세현황</a></li>
						<li><a href="/hems/html/a03.html">(월별)기기별 상세현황</a></li>
						<li><a href="/hems/html/a04.html">전력 사용 통계</a></li>
						<li><a href="/hems/html/a05.html">전력절감 효과보기</a></li>
					</ul>				
				</li>
				<li class="iconB"><a href="javascript:void(null);">난방현황</a></li>
				<li class="iconA"><a href="javascript:void(null);">에너지 성과분석</a></li>
				<li class="iconB"><a href="javascript:void(null);">뉴스&공지</a></li>
				<li class="iconA"><a href="javascript:void(null);">스마트플러그</a></li>
				<li class="iconB"><a href="javascript:void(null);">관리비정보</a></li>
			</ul>
			<p class="logoutArea"><a class="btn_logout"href="javascript:void(null);">로그아웃</a></p>
		</div>
		<p class="btnSet"><a href="javascript:void(null);"><img src="/hems/images/bnt_set.png"  alt="메뉴오픈"></a></p>
		<p class="backBg"></p>
		<!-- //gnbArea -->
	</div>
	<!-- End headerArea -->

	<!-- container -->
	<div class="container">