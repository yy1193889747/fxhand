<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="cyuser!allcount.action"><span
							class="fa fa-caret-right"></span> 首页</a></li>
					<li><a href="cyuser.action"><span class="fa fa-caret-right"></span>
							用户列表</a></li>
					<li class="active"><a href="cygood.action"><span class="fa fa-caret-right"></span>
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

			<h1 class="page-title">商品列表</h1>
			<ul class="breadcrumb">
				<li><a href="cyuser!allcount.action">首页</a></li>
				<li class="active">商品列表</li>
			</ul>

		</div>
		<div class="main-content">
				<form class="form-inline" style="margin-top:0px;" action="cygood.action" method="get">
                    <input name="str"  value="${requestScope.str }" class="input-xlarge form-control" placeholder="Search" id="appendedInputButton" type="text">
                    <button class="btn btn-default" type="submit"><i class="fa fa-search"></i> Go</button>
                </form>
			<div class="btn-toolbar list-toolbar">
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>编号</th>
						<th>商品标题</th>
						<th>卖家</th>
						<th>商品描述</th>
						<th>商品价格</th>
						<th>商品种类</th>
						<th>发布时间</th>
						<th style="width: 1.5em;"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${p.list }">
						<tr>
							<td>${c.cygid }</td>
							<td>${c.cygtitle }</td>
							<td>${c.cyusers.cyuname }</td>
							<td>${c.cygdep }</td>
							<td>${c.cyprice }</td>
							<td>${c.cyclassd.cdname }</td>
							<td>${c.cygdate }</td>
							<td><a href="cygood!delete.action?cygoods.cygid=${c.cygid }"
								onclick="javascript: return confirm('真的要删除吗？')" role="button"
								data-toggle="modal"><i class="fa fa-trash-o"></i></a></td>
						</tr>


					</c:forEach>
				</tbody>
			</table>

			<ul class="pagination">
				<li><a href="cygood.action?p.pageNo=1&str=${requestScope.str }">首页</a></li>
				<li><a href="cygood.action?p.pageNo=${p.prePageNo }&str=${requestScope.str }">上一页</a></li>
				<li><a href="">${p.pageNo }</a></li>
				<li><a href="cygood.action?p.pageNo=${p.nextPageNo }&str=${requestScope.str }">下一页</a></li>
				<li><a href="cygood.action?p.pageNo=${p.lastNo }&str=${requestScope.str }">最后一页</a></li>
			</ul>




			<footer>
			<hr>


			</footer>
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
