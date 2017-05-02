<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>商品详情</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
var name = "${u.cyuname}";
if(name == null){
	alert("您没登录");
	window.location.href="logout.jsp";
			}
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/reg.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.12.3.min.js"></script>
<!-- 引入封装了failback的接口--initGeetest -->
<script src="http://static.geetest.com/static/tools/gt.js"></script>
<script src="js/imagezoom.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js">
var name = "${u.cyuname}";
if(name != "admin"){
	
	alert("您没登录");
	window.location.href="logout.jsp";
			}
</script>
<!-- cart -->
<!-- FlexSlider -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>
<!--//FlexSlider -->
</head>
<body>
	<!--header-->
		<div class="header">
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h1 class="navbar-brand">
					<a href="jump.jsp">fxhand</a>
				</h1>
			</div>
			<!--navbar-header-->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="jump.jsp" >首页</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">二手分类<b class="caret"></b></a>
						<ul class="dropdown-menu multi-column columns-4">
							<div class="row">
								<c:forEach var="cg" items="${c }">
								<div class="col-sm-2">
									<h4>${cg.cgname }</h4>
									<ul class="multi-column-dropdown">
										<c:forEach var="cd" items="${cg.cyclassds }">
											<li><a cslass="list" href="cygood!querylist.action?cygoods.cyclassd.cdid=${cd.cdid }">${cd.cdname }</a></li>
										</c:forEach>
									</ul>
								</div>
								</c:forEach>
							</div>
						</ul></li>
					<li><a href="add.jsp" onclick="return fun1()">我要发布</a></li>
					<li><a href="contact.jsp">关于我们</a></li>
				</ul>
				<!--/.navbar-collapse-->
			</div>
			<!--//navbar-header--> </nav>
			<div class="header-info">
				<div class="header-right search-box">
					<a href="#"><span class="glyphicon glyphicon-search"></span></a>
					<div class="search">
						<form class="navbar-form" action="cygood!search.action">
							<input type="text" class="form-control" name="content" id="asd"/>
							<button type="submit" class="btn btn-default"
								aria-label="Left Align">搜索</button>
						</form>
					</div>
				</div>
				<c:choose>
					<c:when test="${u.cyuname !=null }">
						<div class="header-right login">
							<a href="#"><span class="glyphicon glyphicon-user"
								aria-hidden="true"></span></a>
							<div id="loginBox">
								<form id="loginForm">
									<h4 style="margin-top: 20px">欢迎您，${u.cyuname}</h4>
									<fieldset id="body">
										<a type="button" id="login" style=" margin: 5px 15px" href="cygood!ugoodlist.action?cygoods.cyusers.cyuid=${u.cyuid }">个人中心</a>
										<a type="button" id="login" style=" margin: 10px 15px" href="cygood!ugoodlist.action?cygoods.cyusers.cyuid=${u.cyuid }#tab-2">我的发布</a>
										<a type="button" id="login" style=" margin: 10px 15px"
											href="cygood!collectlist.action?cycarts.cyusers.cyuid=${u.cyuid}">我的收藏</a>
									</fieldset>
								</form>
							</div>
						</div>
						<div class="header-right cart">
							<a href="logout.jsp" onclick="javascript: return confirm('确定要退出吗？')"><span class="glyphicon glyphicon glyphicon-log-out"
								aria-hidden="true"></span></a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header-right login">
							<a data-toggle="modal" data-target="#login_view"
								onclick="log_init()"><span class="glyphicon"></span>登录</a>
						</div>
						<div class="header-right login">
							<a data-toggle="modal" data-target="#reg_view"
								onclick="reg_init()"><span class="glyphicon"></span>注册</a>
						</div>
					</c:otherwise>
				</c:choose>

				<div class="modal fade" id="login_view" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h3 class="modal-title" id="myModalLabel"
									style="text-align: center;">用户登录</h3>
							</div>
							<div class="passport-sign">
								<div class="main-form">
									<form class="passport-form passport-form-sign" id="login-form"
										action="cyuser!login.action" method="post">
										<div class="form-item">
											<div class="form-cont">
												<input type="text" name="cyuser.cyuphone" id="phone_login"
													class="passport-txt xl w-full" tabindex="1"
													autocomplete="off" placeholder="请输入手机号">
												<div class="passport-note passport-error-text"
													id="phone_login1"></div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<input type="password" name="cyuser.cyupwd" id="pwd_login"
													class="passport-txt xl w-full" tabindex="2"
													autocomplete="off" placeholder="输入6~32位密码">
												<div class="passport-note passport-error-text"
													id="pwd_login1"></div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<div class="popup">
													<div id="embed-captcha"></div>
													<p id="wait" class="show">正在加载验证码......</p>
													<div class="passport-note passport-error-text" id="gtcode"
														style="margin-right: 70px;"></div>
												</div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<button type="button" name="register" id="embed-submit1"
													class="passport-btn passport-btn-def xl w-full"
													tabindex="5" jktag="0001|0.1|91026">登录</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>

				<div class="modal fade" id="reg_view" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h3 class="modal-title" id="myModalLabel"
									style="text-align: center;">新用户注册</h3>
							</div>
							<div class="passport-sign">
								<div class="main-form">
									<!-- form -->
									<form class="passport-form passport-form-sign"
										id="register-form" action="cyuser!register.action"
										method="post">
										<div class="form-item">
											<div class="form-cont">
												<input type="text" name="cyuser.cyuname" id="username"
													class="passport-txt xl w-full" tabindex="1"
													autocomplete="off" placeholder="请输入6~25位用户名">
												<div class="passport-note passport-error-text" id="u1"></div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<input type="text" name="phone" id="phone"
													class="passport-txt xl w-full" tabindex="1"
													autocomplete="off" placeholder="请输入手机号">
												<div class="passport-note passport-error-text" id="p1"></div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<input type="password" name="cyuser.cyupwd" id="pwd"
													class="passport-txt xl w-full" tabindex="2"
													autocomplete="off" placeholder="输入6~32位密码">
												<div class="passport-note passport-error-text" id="p2"></div>
												<ul class="passport-safely" id="safely">
													<li class="danger" id="pp1">弱</li>
													<li class="general" id="pp2">中</li>
													<li class="safe" id="pp3">高</li>
												</ul>
											</div>
										</div>
										<div class="form-item form-mcode mb-25">
											<div class="form-cont">
												<input type="text" name="verify_code" id="code"
													class="passport-txt xl w-full" tabindex="4"
													autocomplete="off" placeholder="动态码">
												<div class="passport-note passport-error-text" id="c1"></div>
												<div class="btn-getcode">
													<input type="button" class="passport-btn js-getcode"
														value="获取动态码" onclick="settime(this)" />
												</div>
											</div>
										</div>
										<div class="form-item">
											<div class="form-cont">
												<button type="button" name="register" id="register"
													class="passport-btn passport-btn-def xl w-full"
													tabindex="5" jktag="0001|0.1|91026" onclick="sub()">注册</button>
											</div>
										</div>
									</form>
									<!-- form end -->
								</div>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				<!--  -->
			</div>
		</div>
	</div>
	<!--//header-->
	<!--//single-page-->
	<div class="gallery">
		<div class="container">
			<div class="single-grids">
				<div class="col-md-5 single-grid">
					<div class="flexslider">
						<ul class="slides">
							<div class="thumb-image">
								<img src="upload/${gd.cygphoto }" data-imagezoom="true"
									class="img-responsive">
							</div>
						</ul>
					</div>
				</div>
				<div class="col-md-5 single-grid simpleCart_shelfItem"
					style="margin-left: 50px">
					<h3>${gd.cygtitle }</h3>
					<ul class="size">
						<h3 style="display: inline">浏览次数:</h3>
						<h5 style="display: inline; padding-left: 20px">${gd.cygview }</h5>
					</ul>
					<ul class="size">
						<h3 style="display: inline">发布时间:</h3>
						<h5 style="display: inline; padding-left: 20px">${gd.cygdate }</h5>
					</ul>
					<ul class="size">
						<h3 style="display: inline;">卖家:</h3>
						
						<c:choose>
					<c:when test="${gd.cyusers.cyustat =='3' }">
						<h5 style="display: inline; padding-left: 20px">${gd.cyusers.cyuname }【已认证】</h5>
					</c:when>
					<c:otherwise>
						<h5 style="display: inline; padding-left: 20px">${gd.cyusers.cyuname }</h5>
					</c:otherwise>
					</c:choose>
					
					</ul>
					<ul class="size">
						<h3 style="display: inline">商品价格:</h3>
						<h5 style="display: inline; padding-left: 20px">￥${gd.cyprice }</h5>
					</ul>
					<ul class="size">
						<h3>商品描述:</h3>
						<p>${gd.cygdep }</p>
						<p>【联系我时请说明是在fxhand上看到的哦】</p>
					</ul>
					<div class="btn_form" style="margin-top: 50px">
						<a
							href=""
							class="add-cart item_add" onclick="return check()">加入收藏</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
	function check(){
		var user = "${u.cyuname}";
		if (user == "") {
			alert("您还没登录，请先登录");
			return false;
		}
		var users = "${gd.cyusers.cyuname}";
		if (user == users) {
			alert("不能收藏自己的商品哦");
			return false;
		}
			$.ajax({
				url : "cygood!collect.action?cycarts.cygoods.cygid=${gd.cygid }&cycarts.cyusers.cyuid=${u.cyuid}",
				async : false,//改为同步方式
				type : "POST",
				data : "",
				dataType : "text",
			});
			alert("收藏成功");
		return true;
	}
	
	</script>
	<!-- collapse -->
	<div class="gallery">
		<div class="container">
			<div class="panel-group collpse" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" aria-expanded="true"
								aria-controls="collapseOne"> 购买帮助 </a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							看到自己喜欢的商品可以点击下方的卖家联系方式查看卖家的联系信息，与卖家取得联系后进行购买。<br>
						【温馨提示】标有已认证的卖家更靠谱哦， 联系卖家时记得说明是在fxhand上看到的哦
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingTwo">
						<h4 class="panel-title">
							<a class="collapsed" role="button" data-toggle="collapse"
								data-parent="#accordion" href="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">
								卖家联系方式 </a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse"
						role="tabpanel" aria-labelledby="headingTwo">
						<div class="panel-body">
						<p>TEL: ${gd.cyusers.cyuphone }</p>
						<p>Email: ${gd.cyusers.cyemail }</p>
						<p>QQ: ${gd.cyusers.cyuqq }</p>
						<p>Address: ${gd.cyusers.cyuaddress }</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--//collapse -->
	<!--related-products-->
	<div class="related-products">
		<div class="container">
			<h3>相关商品</h3>
			<div class="product-model-sec single-product-grids">
			<c:forEach items="${glike }" var="glike">
				<div class="product-grid single-product">
					<a href="cygood!queryd.action?cygoods.cygid=${glike.cygid }">
						<div class="more-product">
							<span> </span>
						</div>
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="upload/${glike.cygphoto }" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">
									<button>查看详情</button>
								</h4>
							</div>
						</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${glike.cygtitle }</h4>
							<span class="item_price">￥${glike.cyprice }</span>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			   </c:forEach>
			</div>
		</div>
	</div>
	<!--related-products-->
	<!--footer-->
	<!--footer-->
<div class="footer-bottom">
		<div class="container">
			<p>
				©2016-2017  fxhand  部分版权所有     谨慎盗用      晋ICP备16008887号-1
			</p>
		</div>
	</div>
	<script type="text/javascript">
		function fun1() {
			var user = "${u.cyuname}";
			if (user == "") {
				alert("您还没登录，请先登录");
				return false;
			}
			return true;
		}
	</script>
	<script type="text/javascript" src="js/checks.js"></script>
</body>
</html>