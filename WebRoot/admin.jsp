<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<title>后台管理系统</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

<script src="lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
<script type="text/javascript">
var name = "${uu.cyuname}";
if(name != "admin" && name != null){
	
	alert("您没登录");
	window.location.href="logout.jsp";
			}
    
        $(function() {
            $(".knob").knob();
        });
    </script>


<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">

</head>
<body class=" theme-blue">

	<!-- Demo page code -->

	<script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
	<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.navbar-default .navbar-brand,.navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>

	<script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
        
    </script>


	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="" href="index.html"><span class="navbar-brand">
					Fxhand</span></a>
		</div>
		<div class="navbar-collapse collapse" style="height: 1px;">
			<ul id="main-menu" class="nav navbar-nav navbar-right">
				<li class="dropdown hidden-xs"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user padding-right-small"
						style="position:relative;top: 3px;"></span> ${uu.cyuname} <i
						class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a tabindex="-1" href="logout.jsp">退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div class="sidebar-nav">
		<ul>
			<li><a href="#" data-target=".dashboard-menu" class="nav-header"
				data-toggle="collapse"><i class="fa fa-fw fa-heart"></i> 数据列表<i
					class="fa fa-collapse"></i></a></li>
			<li><ul class="dashboard-menu nav nav-list collapse in">
					<li class="active"><a href="cyuser!allcount.action"><span
							class="fa fa-caret-right"></span> 首页</a></li>
					<li><a href="cyuser.action"><span class="fa fa-caret-right"></span>
							用户列表</a></li>
					<li><a href="cygood.action"><span class="fa fa-caret-right"></span>
							商品列表</a></li>
				</ul></li>
			<li><a
				href="#" data-target=".premium-menu" class="nav-header"
				data-toggle="collapse"><i class="fa fa-fw fa-heart"></i> 审核列表<span class="label label-info">+${checkusercount }</span></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse in">
					<li><a href="cymesg.action"><span
							class="fa fa-caret-right"></span> 留言列表 </a></li>
					<li><a href="cyuser!checkpage.action"><span
							class="fa fa-caret-right"></span> 待认证列表 </a></li>
				</ul></li>
		</ul>
	</div>
	<div class="content">
		<div class="header">
			<div class="stats"></div>
			<h1 class="page-title">数据总览</h1>
			<ul class="breadcrumb">
				<li><a href="cyuser!allcount.action">首页</a></li>
				<li class="active">数据总览</li>
			</ul>
		</div>
		<div class="main-content">
			<div class="panel panel-default">
				<a href="#page-stats" class="panel-heading" data-toggle="collapse">数据统计</a>
				<div id="page-stats" class="panel-collapse panel-body collapse in">

					<div class="row">
						<div class="col-md-3 col-sm-6">
							<div class="knob-container">
								<input class="knob" data-width="200" data-min="0" data-max="100"
									data-displayPrevious="true" value="${usercount}"
									data-fgColor="#92A3C2" data-readOnly=true;>
								<h3 class="text-muted text-center">用户数量</h3>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="knob-container">
								<input class="knob" data-width="200" data-min="0" data-max="100"
									data-displayPrevious="true" value="${goodcount }"
									data-fgColor="#92A3C2" data-readOnly=true;>
								<h3 class="text-muted text-center">商品数量</h3>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="knob-container">
								<input class="knob" data-width="200" data-min="0" data-max="500"
									data-displayPrevious="true" value="${viewcount }" data-fgColor="#92A3C2"
									data-readOnly=true;>
								<h3 class="text-muted text-center">访问次数</h3>
							</div>
						</div>
						<div class="col-md-3 col-sm-6">
							<div class="knob-container">
								<input class="knob" data-width="200" data-min="0" data-max="500"
									data-displayPrevious="true" value="${msgcount }" data-fgColor="#92A3C2"
									data-readOnly=true;>
								<h3 class="text-muted text-center">留言数量</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>

