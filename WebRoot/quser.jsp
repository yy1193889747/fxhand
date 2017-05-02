<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人中心</title>
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
<link href="css/style3.css" rel='stylesheet' type='text/css' />

<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.12.3.min.js"></script>
<!-- 引入封装了failback的接口--initGeetest -->
<script src="http://static.geetest.com/static/tools/gt.js"></script>

<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js">
var name = "${u.cyuname}";
if(name != "admin"){
	
	alert("您没登录");
	window.location.href="logout.jsp";
			}
</script>
<style type="text/css">


</style>
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
	<!--gallery-->
	<div class="gallery">
		<div class="container">
				<h2 style="padding-top: 30px">个人中心</h2>
			<div class="product-tabs" style="margin: 10px auto;padding:0px 40px;">
				<!--Horizontal Tab-->
				<div id="horizontalTab">
					<ul>
						<li><a href="#tab-1">修改资料</a></li>
						<li><a href="#tab-2">我的发布</a></li>
						<li><a href="#tab-3">认证中心</a></li>
					</ul>
					<div id="tab-1" class="product-complete-info">
					
						<div class="modal-body" style="width: 500px">
							<form action="cyuser!userupdate.action" method="post" name="form22">
								<div class="form-group">
									<label>用户名</label> <input type="text" class="form-control"
										value="${u.cyuname }" name="cyuser.cyuname" readonly="readonly"> <input
										type="hidden" class="form-control" value="${u.cyupwd }"
										name="cyuser.cyupwd"> <input type="hidden"
										class="form-control" value="${u.cyuid }" name="cyuser.cyuid">
										<input type="hidden"
										class="form-control" value="${u.cyustat }" name="cyuser.cyustat">
										<input type="hidden"
										class="form-control" value="${u.cyuphoto }" name="cyuser.cyuphoto">
								</div>
								<div class="form-group">
									<label>手机号&nbsp;&nbsp;&nbsp;<span style="color: red"></span></label> <input type="text" class="form-control"
										value="${u.cyuphone }" name="cyuser.cyuphone" readonly="readonly">
								</div>
								<div class="form-group">
									<label>邮箱&nbsp;&nbsp;&nbsp;<span style="color: red;" id="emailstr"></span></label> <input type="text" class="form-control"
										value="${u.cyemail }" name="cyuser.cyemail" id=email>
								</div>
								<div class="form-group">
									<label>QQ&nbsp;&nbsp;&nbsp;<span style="color: red;" id="qqstr"></span></label> <input type="text" class="form-control"
										value="${u.cyuqq }" name="cyuser.cyuqq" id="qq">
								</div>
								<div class="form-group">
									<label>宿舍地址</label> <input type="text" class="form-control"
										value="${u.cyuaddress }" name="cyuser.cyuaddress">
								</div>
									<div class="form-group">
									<label>注册时间</label> <input type="text" class="form-control"
										value="${u.cyrdate } " readonly="readonly" name="cyuser.cyrdate">
								</div>
								<br>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-dismiss="modal" onclick="return fun();">修改</button>
								</div>
			
							</form>
						</div>
					</div>
					<div id="tab-2" class="product-complete-info">

						<ul class="list-group">
							<c:forEach var="c" items="${uglist }">
								<li class="list-group-item">
									<div class="media">
										<a class="pull-left" href="#"> <img
											src="upload/${c.cygphoto }" class="media-object thumb-sm"
											width="150px" height="150px">
										</a>
										<div class="media-body">
											<p class="text-sm pull-right">价格：${c.cyprice }</p>
											<p class="media-heading" >标题：${c.cygtitle }</p>
											<p>内容：${c.cygdep }</p>
											<p>浏览次数：${c.cygview }</p>
											<p>发布时间：${c.cygdate }</p>
										</div>
										<script type="text/javascript">
										function funnn(){
										var r=confirm("确定删除商品吗");
									    if (r==true)
									    {
												$.ajax({
													url : "cygood!deleteugood.action?cygoods.cygid=${c.cygid }",
													async : false,//改为同步方式
													type : "POST",
													data : "",
													dataType : "text",
												});
												return true;
									    }
									    return false;
										}
										</script>
										<p class="text-sm pull-right"
											style="margin-top: 5px;margin-right: 0px;">
											<a href="" onclick="return funnn()"><button class="add-cart item_add" >删除发布</button></a>
										</p>
										<p class="text-sm pull-right"
											style="margin-top: 5px;margin-right: 10px;">
											<a href="#editUser${c.cygid}" data-toggle="modal"
												class="padding-right-small"><button class="add-cart item_add">编辑发布</button></a>
										</p>
									</div>
									<div class="modal fade" id="editUser${c.cygid}" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true" style="display: none;">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">关闭</button>
													<h3 id="myModalLabel">编辑商品&nbsp;&nbsp;</h3>
													<p style="color: red">（注：商品种类不可修改)</p>
												</div>
												<div class="modal-body" style="padding: 30px 60px;">
													<form id="bianji_form"
														action="cygood!usergupdate.action?cygoods.cygid=${c.cygid}&cygoods.cyusers.cyuid=${u.cyuid}"
														method="post" enctype="multipart/form-data">
														<div class="form-group">
															<label>商品名称&nbsp;&nbsp;&nbsp;<span style="color: red;" id="title1"></span></label> <input type="text"
															id="title"	class="form-control" value="${c.cygtitle }" name="cygoods.cygtitle">
														</div>
														<div class="form-group">
															<label>商品描述&nbsp;&nbsp;&nbsp;<span style="color: red;" id="descp1"></span></label> <textarea class="form-control" 
															id="descp"	name="cygoods.cygdep">${c.cygdep }</textarea>
														</div>
														<div class="form-group">
															<label>商品图片&nbsp;&nbsp;&nbsp;<span style="color: red;" id="upload1"></span></label> <input type="file"
															id="upload"	class="form-control" value="${c.cygphoto }" name="upload">
														</div>
														<div class="form-group">
															<label>商品价格&nbsp;&nbsp;&nbsp;<span style="color: red;" id="price1"></span></label> <input type="text"
															id="price"	class="form-control" value="${c.cyprice }" name="cygoods.cyprice" >
														</div>
														<div class="form-group">
															<label>商品种类：${c.cyclassd.cdname }</label>
														</div>
														<br>
														<div class="modal-footer">
															<button class="btn btn-default">取消</button>
															<button type="button" class="btn btn-primary" onclick="fun123()" >保存</button>
														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					<script type="text/javascript">
					function getLength(str) {
						// \x00-xff代表单字节字符。
						return str.replace(/[^\x00-\xff]/g, "xx").length;
					}
									var qqstr = document
											.getElementById('qqstr');
									var qq = document.getElementById('qq');
									var emailstr = document
											.getElementById('emailstr');
									var email = document
											.getElementById('email');
									
									var title = document.getElementById('title');
									var title1 = document.getElementById('title1');
									var descp = document.getElementById('descp');
									var descp1 = document.getElementById('descp1');
									var price = document.getElementById('price');
									var price1= document.getElementById('price1');
									var upload = document.getElementById('upload');
									var upload1 = document.getElementById('upload1');
									window.onload = function() {

										//qq
										qq.onfocus = function() {
											qqstr.innerHTML = "";
										};
										qq.onblur = function() {
											var reg = /^[1-9]\d{5,10}$/g; // qq
											//不能为空
											if (this.value == "") {
												return true;
											}
											//长度超过25个字符
											else if (!reg.test(this.value)) {
												qqstr.innerHTML = '(请输入正确的qq号)';
												return false;
											} else {
												return true;
											}
										};
										//email
										email.onfocus = function() {
											emailstr.innerHTML = "";
										};
										email.onblur = function() {
											var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/g; // email
											//不能为空
											if (this.value == "") {
												return true;
											}
											//长度超过25个字符
											else if (!reg.test(this.value)) {
												emailstr.innerHTML = '(请输入正确的邮箱)';
												return false;
											} else {
												return true;
											}
										};
										
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
														return true;
													}
													//格式
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
									
									
						function fun123() {
							title.onblur();
							descp.onblur();
							price.onblur();
							upload.onblur();
							if (title.onblur() && descp.onblur() && price.onblur() && upload.onblur()) {
								alert("修改成功");
								document.getElementById("bianji_form").submit();
							} else {
								alert("数据有误");
							}

						}

						function fun() {
							email.onblur();
							qq.onblur();
							if (email.onblur() && qq.onblur()) {
								var load = window.prompt("请输入登录密码:", "");
								if (load == ${u.cyupwd}) {
									document.form22.submit();
									alert("修改成功");
								} else if (load != null) {
									alert("您输入的密码有误");
								}
							}
						}
					</script>

					</div>
					<div id="tab-3" class="product-complete-info" style="height: 150px">
					<c:choose>
					<c:when test="${u.cyustat =='3' }">
					<p>【恭喜你，认证成功】</p>
					</c:when>
					<c:when test="${u.cyustat =='2' }">
					<p>【认证中】</p>
					</c:when>
					<c:when test="${u.cyustat =='4' }">
					<p>【认证失败】：${u.cyuphoto }</p>
								<form id="userphoto" action="cyuser!userphoto.action?cyuser.cyuid=${u.cyuid }" method="post"  enctype="multipart/form-data"> 
								<input style="float: left; margin-bottom: 20px" type="file" name="upload"  id="upload123" >
								<button type="button"  class="btn btn-success" style="float: left;"  onclick="uploadsss()">确定</button>
								</form>
					</c:when>
					<c:otherwise>
					<p>【未认证】</p>
						<form id="userphotos" action="cyuser!userphoto.action?cyuser.cyuid=${u.cyuid }" method="post"  enctype="multipart/form-data"> 
								<input style="float: left; margin-bottom: 20px" type="file" name="upload"  id="upload1234" >
								<button type="button"  class="btn btn-success" style="float: left;"  onclick="uploadssss()">确定</button>
								</form>
					</c:otherwise>
					</c:choose>
						
					</div>
				</div>
			</div>
			<!-- Responsive Tabs JS -->
			<script src="lib/bootstrap/js/bootstrap.js"></script>
			<script type="text/javascript">
			
			function uploadsss(){
				var photo = document.getElementById("upload123").value;
				var reg = /^.*[^a][^b][^c]\.(?:png|jpg|bmp|jpeg)$/g;
				
				if (photo == "") {
					alert("请选择商品图片");
					return false;
				}
				//长度超过25个字符
				else if (!reg.test(photo)) {
					alert("图片格式不正确");
					return false;
				}
				else {
					alert("上传成功");
					document.getElementById("userphoto").submit();
					return true;
				}
			}
			function uploadssss(){
				var photo = document.getElementById("upload1234").value;
				var reg = /^.*[^a][^b][^c]\.(?:png|jpg|bmp|jpeg)$/g;
				
				if (photo == "") {
					alert("请选择商品图片");
					return false;
				}
				//长度超过25个字符
				else if (!reg.test(photo)) {
					alert("图片格式不正确");
					return false;
				}
				else {
					alert("上传成功");
					document.getElementById("userphotos").submit();
					return true;
				}
			}
			
				$("[rel=tooltip]").tooltip();
				$(function() {
					$('.demo-cancel-click').click(function() {
						return false;
					});
				});
			</script>

			<script src="js/jquery.responsiveTabs.js" type="text/javascript"></script>

			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$('#horizontalTab')
											.responsiveTabs(
													{
														rotate : false,
														startCollapsed : 'accordion',
														collapsible : 'accordion',
														setHash : true,
														disabled : [ 3, 4 ],
														activate : function(e,
																tab) {
															$('.info')
																	.html(
																			'Tab <strong>'
																					+ tab.id
																					+ '</strong> activated!');
														}
													});

									$('#start-rotation').on(
											'click',
											function() {
												$('#horizontalTab')
														.responsiveTabs(
																'active');
											});
									$('#stop-rotation')
											.on(
													'click',
													function() {
														$('#horizontalTab')
																.responsiveTabs(
																		'stopRotation');
													});
									$('#start-rotation').on(
											'click',
											function() {
												$('#horizontalTab')
														.responsiveTabs(
																'active');
											});
									$('.select-tab').on(
											'click',
											function() {
												$('#horizontalTab')
														.responsiveTabs(
																'activate',
																$(this).val());
											});

								});
			</script>
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
</body>
</html>