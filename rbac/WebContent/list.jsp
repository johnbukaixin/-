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
	<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		function submitForm(){
			var name=$('#stuName').val();
			var sex='女';
			if($('#stuSex').checked){
				sex='男';
			}
			var age=$('#stuAge').val();
			var teacher=$('#stuTea').combobox('getValue');
			 $.post('student/save.action',{'student.name':name,'student.sex':sex,'student.age':age,'student.teacher.id':teacher},function(data){
				var node=eval("("+data+")");
				if(node.type==1){
					$.messager.alert('提示',node.msg);    
					$('#w').window('close');
					//重新加载数据
				}else{
					$.messager.alert('提示',node.msg);    
				}
			}); 
		}
		function dataLoad(){
			$('#dg').datagrid({    
	    	url:'student/list.action'    
			});  
		}
	</script>
</head>
  <body>
	<table id="dg" class="easyui-datagrid" title="学生信息" style="width:700px;height:400px"
			data-options="rownumbers:true,singleSelect:true,url:'student/list.action',method:'get',toolbar:'#tb',
			pagination:true,pageSize:2,pageList:[2,4,6]">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">编号</th>
				<th data-options="field:'name',width:100">姓名</th>
				<th data-options="field:'age',width:80,align:'right'">年龄</th>
				<th data-options="field:'sex',width:80,align:'right'">性别</th>
				<th data-options="field:'teacher.name',width:80,align:'right',formatter: function(value,row,index){
																				if (row.teacher!=null){
																					return row.teacher.name;
																				} else {
																					return value;
																				}
																			}">老师</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#w').window('open')"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
		</div>
		<div>
			Date From: <input class="easyui-datebox" style="width:80px">
			To: <input class="easyui-datebox" style="width:80px">
			Language: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>
	<div id="w" class="easyui-window" title="新增学生信息" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:280px;padding:10px;">
	<div class="easyui-panel" title="" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input id="stuName" class="easyui-validatebox textbox" type="text" name="student.name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input id="stuSex" class="easyui-validatebox radio" type="radio" name="student.sex" value="男" checked>男</input>
	    				<input class="easyui-validatebox radio" type="radio" name="student.sex" value="女">女</input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>年龄:</td>
	    			<td><input id="stuAge" class="easyui-numberbox" type="text" name="student.age" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>教师:</td>
	    			<td><input id="stuTea" class="easyui-combobox" 
							name="student.teacher.id"
							data-options="
									url:'teacher/list.action',
									method:'get',
									valueField:'id',
									textField:'name',
									panelHeight:'auto'
							"></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
	    </div>
	</div>
	
	
	</div>
	
</body>
</html>
