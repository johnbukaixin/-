<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<!-- 	<link rel="stylesheet" type="text/css" href="../demo.css"> -->
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	   $(function(){
		   $("#my-tree").tree({    
			    url:"<%=basePath%>shiro/menu.do",  
			    onClick:function(node){
			    	if($("#my-tree").tree("isLeaf",node.target)){
			    		$("#myTabs").tabs("add",{    
						    title:node.text,
						    href:"<%=basePath%>"+node.url,
						    closable:true,
						    iconCls:"icon-ok"
						}); 
			    	}
			    }
			});
	   })
	
	</script>
</head>
<body  class="easyui-layout">
	<div style="margin:20px 0;"></div>
		<div data-options="region:'west',split:true" title="West" style="width:250px;">
		   <ul class="easyui-tree" id="my-tree">
		   </ul>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
		<div class="easyui-tabs" style="width:1110px;height:400px" id="myTabs">
		<div title="About" style="padding:10px">
			<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
			<ul>
				<li>easyui is a collection of user-interface plugin based on jQuery.</li>
				<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
				<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
				<li>complete framework for HTML5 web page.</li>
				<li>easyui save your time and scales while developing your products.</li>
				<li>easyui is very easy but powerful.</li>
			</ul>
		</div>
		<div title="My Documents" style="padding:10px">
		  <table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:300px"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data.json',method:'get',pagination:true">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:250">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>
		
		</div>
		
		<div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
			This is the help content.
		</div>
	</div>
		</div>

</body>
</html>