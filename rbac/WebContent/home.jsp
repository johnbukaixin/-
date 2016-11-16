<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Full Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="easyui/demo.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<style type="text/css">
		.navmenu{
			border:1px solid #95B8E7;
			width:168px;
			margin:5px 10px;
			text-align: center;
			display: block;
			height:30px;
			line-height: 30px;
		}
		.navmenu a{
			text-decoration: none;
			color:#0099FF;
		}
	</style>
	<script type="text/javascript">
		function addPanel(title,url){
				$('#tt').tabs('add',{
					title: title,
					content: "<iframe frameborder=0 width='1000px' height='460px' src='"+url+"'></iframe>",
					closable: true
				});
		}
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:120px;background:#B3DFDA;overflow: hidden" >
		<img src="image/banner.jpg" width="100%" height="120px">
	</div>
	<div data-options="region:'west',title:'系统功能'" style="width:200px;">
		<div class="easyui-accordion" style="width:198px;height:auto;">
			<div title="系统管理" style="overflow:auto;">
				<h3 class="navmenu"><a href="javascript:addPanel('学生信息','list.jsp')">学生信息</a></h3>
				<h3 class="navmenu"><a href="#">个人信息</a></h3>
				<h3 class="navmenu"><a href="#">数据字典</a></h3>
				<h3 class="navmenu"><a href="#">权限设置</a></h3>
			</div>
			<div title="用户管理" >
			<h3 class="navmenu"><a href="#">修改密码</a></h3>
				<h3 class="navmenu"><a href="#">个人信息</a></h3>
				<h3 class="navmenu"><a href="#">数据字典</a></h3>
				<h3 class="navmenu"><a href="#">权限设置</a></h3>
			</div>
			<div title="成绩管理" >
				<h3 class="navmenu"><a href="#">修改密码</a></h3>
				<h3 class="navmenu"><a href="#">个人信息</a></h3>
				<h3 class="navmenu"><a href="#">数据字典</a></h3>
				<h3 class="navmenu"><a href="#">权限设置</a></h3>
			</div>
	</div>
	</div>
	<div data-options="region:'center',title:''">
		<div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:1076px;height:530px">
		</div>
	</div>
</body>
</html>