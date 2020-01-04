<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>登录</title>
	<!--meta tags -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
	<link href="css/style.css" rel='stylesheet' type='text/css' media="all">
</head>
<style type="text/css">
	body {
		position: relative;
	}

	.aa {
		position: absolute;
		float: right;
		left: 50%;
		top: 230px;
		z-index: 1000;
	}
</style>

<body>
<!--改变颜色-->
<!--<div class="blast-box">
    <div class="blast-icon"><span class="fas fa-tint"></span></div>
    <div class="blast-frame">
        <p>change colors</p>
        <div class="blast-colors">
            <div class="blast-color">#86bc42</div>
            <div class="blast-color">#8373ce</div>
            <div class="blast-color">#14d4f4</div>
            <div class="blast-color">#72284b</div>
        </div>
        <p class="blast-custom-colors">Custom colors</p>
        <input type="color" name="blastCustomColor" value="#cf2626">
    </div>
</div>
-->
<!--头部状态-->
<div class="header-outs" id="header">
	<!--<div class="header-w3layouts">
        <nav class="navbar navbar-expand-lg navbar-light">
            <div class="headdser-nav-color" data-blast="bgColor">
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <ul class="navbar-nav ">
                        <li class="nav-item">
                            <a href="#contact" class="nav-link scroll">注册</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>-->

	<!--登录-->
	<div class="container aa py-lg-5 py-md-5 py-sm-4 py-3">
		<div class="row">
			<div class="col-md-7 contact-form">
				<div class="form-group contact-forms">
					<input type="text" name="userNo" id="userNo" class="form-control" placeholder="账号">
				</div>
				<div class="form-group contact-forms">
					<input type="text" name="passWord" id="passWord" class="form-control" placeholder="密码">
				</div>
				<div class="sent-butnn text-center">
					<button type="button" onclick="submit()" id="submit" class="btn btn-block" data-blast="bgColor">登录</button>
				</div>
			</div>
		</div>
	</div>


	<!--轮播图-->
	<div class="slider">
		<div class="callbacks_container">
			<ul class="rslides" id="slider4">
				<li>
					<div class="slider-img three-img">
						<div class="container">
							<div class="slider-info text-left" style="width: 500px;padding-top: 300px;">
								<h5></h5>
								<h5>不要说你不会做!你是个人你就会做!</h5>
							</div>
						</div>

					</div>
				</li>
				<li>
					<div class="slider-img one-img">
						<div class="container">
							<div class="slider-info text-left" style="width: 500px;padding-top: 300px;">
								<h5></h5>
								<h5>没有所谓失败，除非你不再尝试。</h5>
							</div>
						</div>
					</div>
				</li>
				<li>
					<div class="slider-img two-img">
						<div class="container">
							<div class="slider-info text-left" style="width: 500px;padding-top: 300px;">
								<h5></h5>
								<h5>业精于勤而荒于嬉，行成于思而毁于随。</h5>
							</div>
						</div>

					</div>
				</li>

			</ul>

		</div>

	</div>
</div>

</div>
<script src='js/jquery-2.2.3.min.js'></script>
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		// Slideshow 4
		$("#slider4").responsiveSlides({
			auto: true,
			pager: false,
			nav: true,
			speed: 900,
			namespace: "callbacks",
			before: function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after: function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});

	});
</script>
<script src="js/easy-responsive-tabs.js"></script>
<script>
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion
			width: 'auto', //auto or any width like 600px
			fit: true, // 100% fit in a container
			closed: 'accordion', // Start closed if in accordion view
			activate: function(event) { // Callback function if tab is switched
				var $tab = $(this);
				var $info = $('#tabInfo');
				var $name = $('span', $info);
				$name.text($tab.text());
				$info.show();
			}
		});
	});
</script>
<!--回顶-->
<script src="js/move-top.js"></script>
<script src="js/easing.js"></script>
<script>
	$(document).ready(function() {

		var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear'
		};

		$().UItoTop({
			easingType: 'easeOutQuart'
		});

	});
</script>
<!--=================================-->
<script>
	$(function () {

		$("#userId").blur(function () {
			var userId = $("#userId").val();

			if (userId == "" || userId == undefined){
				$("#userId").attr("placeholder","请输入账号")
			}
		});
		$("#passWord").blur(function () {
			var pwd = $("#passWord").val();

			if (pwd == "" || pwd == undefined){
				$("#passWord").attr("placeholder","请输入密码")
			}
		});
	});
	function submit() {
		var userNo = $("#userNo").val();
		var pwd = $("#passWord").val();

		if (userNo == "" || userNo == undefined || pwd == "" || pwd == undefined ){
			alert("账号或密码错误");
			$("#userId").val("");
			$("#passWord").val("");
		}else {
			$.post(
					"userAction_login",
					{
						"userNo":userNo,
						"passWord":pwd
					},
					function (data) {
						if (data === "true"){
							// window.location.href = "jsp/main.jsp";
							window.location.replace("jsp/main.jsp");
						} else{
							alert("账号或密码错误");
							$("#userId").val("");
							$("#passWord").val("");
						}
					},
					"json"

			);
		}
	}
</script>
</body>

</html>