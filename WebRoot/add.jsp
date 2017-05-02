<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>发布商品</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">

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
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->

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
					<li><a href="add.jsp" onclick="return fun1()" class="active">我要发布</a></li>
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
						</div><!-- /.modal-content -->
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
	<!--gallery-->
	<div class="gallery">
		<div class="register-container container">
			<div class="row">
				<div class="register span6 ">
					<form action="cygood!addGood.action" method="post" enctype="multipart/form-data" id="add_form">
						<h2>
							商品 <span class="red"><strong>发布</strong></span>
						</h2>
						<input type="hidden" name="cygoods.cyusers.cyuid"
							value="${u.cyuid }"> 
						<label for="firstname">商品名称     &nbsp;</label><span id="title1" style="color: red" ></span>
						<input type="text" id="title" name="cygoods.cygtitle"
							placeholder="建议写个酷炫的标题，最多16个字"> 
						<label for="lastname">商品描述 &nbsp;</label><span id="descp1" style="color: red" ></span>
						<textarea id="descp" name="cygoods.cygdep"
							placeholder="建议填写物品新旧程度，原价等信息，至少15个字"></textarea>
						<label for="username" style="display: block">商品类别 &nbsp;<span id="select" style="color: red; font-size: 14px;font-weight:normal" ></span></label>
						<tr>
							<td><select id="firstLevel" class="input_search"
								onchange="change()">
									<option value="-1">--请选择--</option>
									<option value="1">电子设备</option>
									<option value="2">电器</option>
									<option value="3">生活娱乐</option>
									<option value="4">图书材料</option>
									<option value="5">校园代步</option>
									<option value="6">租赁</option>
							</select></td>

							<td><select id="secondLevel"
								class="input_search" name="cygoods.cyclassd.cdid">
									<option value="-1">--请选择--</option>
							</select></td>
						</tr>
						<label for="email">商品价格 &nbsp;</label><span id="price1" style="color: red" ></span> 
						<input type="text" id="price"  name="cygoods.cyprice" placeholder="标个合理的价格吧">
						<label for="password">商品图片 &nbsp;</label><span id="upload1" style="color: red" ></span> 
						<input type="file"  id="upload" name="upload" style="height: 28px">
						<button type="button" onclick="add()">确认发布</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--//gallery-->
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
<script type="text/javascript">

var select = document.getElementById("select");
var first = document.getElementById("firstLevel");
var secd = document.getElementById("secondLevel");
var title = document.getElementById("title");
var title1 = document.getElementById("title1");
var descp = document.getElementById("descp");
var descp1 = document.getElementById("descp1");
var price = document.getElementById("price");
var price1= document.getElementById("price1");
var upload = document.getElementById("upload");
var upload1 = document.getElementById("upload1");

window.onload = function() {

	//商品名称
	title.onfocus = function() {
		title1.innerHTML = "";
	};
	title.onblur = function() {
		//不能为空
		if (this.value == "") {
			title1.innerHTML = '请输入商品名称';
			return false;
		}
		//长度超过25个字符
		else if (getLength(this.value) > 32) {
			title1.innerHTML = '商品名称不能超过16个字';
			return false;
		}
		//OK
		else {
			return true;
		}
	};
	//商品描述
	descp.onfocus = function() {
		descp1.innerHTML = "";
	};
	descp.onblur = function() {
		//不能为空
		if (this.value == "") {
			descp1.innerHTML = '请输入商品描述';
			return false;
		}
		//长度超过25个字符
		else if (getLength(this.value) < 30) {
			descp1.innerHTML = '商品描述不能少于15个字';
			return false;
		}
		//OK
		else {
			return true;
		}
	};
	//商品类别
	secd.onfocus = function() {
		select.innerHTML = "";
	};
	secd.onblur = function() {
		//不能为空
		if (this.value == -1) {
			select.innerHTML = '请选择商品类别';
			return false;
		}
		//长度超过25个字符
		//OK
		else {
			return true;
		}
	};
	//商品价格
	price.onfocus = function() {
		price1.innerHTML = "";
	};

	price.onblur = function() {
			var reg = /^[1-9]\d*$/g; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。
			//不能为空
			if (this.value == "") {
				price1.innerHTML = '请输入商品价格';
				return false;
			}
			//长度超过25个字符
			else if (!reg.test(this.value)) {
				price1.innerHTML = '价格不为正整数';
				return false;
			}
			else if (this.value >100000 ) {
				price1.innerHTML = '价格过高';
				return false;
			}
			//OK
			else {
				return true;
			}
		};
		
		//商品图片
		upload.onfocus = function() {
			upload1.innerHTML = "";
		};

		upload.onblur = function() {
				var reg = /^.*[^a][^b][^c]\.(?:png|jpg|bmp|jpeg)$/g; // \w代表“数字、字母（不分大小写）、下划线”，\u4e00-\u9fa5代表汉字。
				//不能为空
				if (this.value == "") {
					upload1.innerHTML = '请选择商品图片';
					return false;
				}
				//长度超过25个字符
				else if (!reg.test(this.value)) {
					upload1.innerHTML = '图片格式不正确';
					return false;
				}
				//OK
				else {
					return true;
				}
			};

	};
    function add() {
    	var userid = "${u.cyuid }";
    	title.onblur();
    	descp.onblur();
    	secd.onblur();
    	price.onblur();
    	upload.onblur();
    	if(userid == ""){
    		alert("您还没登录，请先登录");
    	}else {
    		if (title.onblur() && descp.onblur() && secd.onblur()
    				&& price.onblur()&& upload.onblur()) {
    				alert("发布成功");
    				document.getElementById("add_form").submit();
    		} else {
    		}
		}
    	
    }
	function change() {

		var i = first.selectedIndex;
		if (i == 1) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c1 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 2) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c2 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 3) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c3 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 4) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c4 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else if (i == 5) {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c5 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		} else {
			secd.innerHTML = '<option value="-1">--请选择--</option><c:forEach items="${c6 }"  var="c"><option value="${c.cdid }">${c.cdname }</option></c:forEach>';
		}

	}
</script>
</body>
</html>
