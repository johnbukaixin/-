<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:300px"
			data-options="singleSelect:true,collapsible:true,url:'<%=basePath %>role/roleList.do',method:'get',pagination:true">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">id</th>
				<th data-options="field:'productid',width:100">name</th>
			</tr>
		</thead>
	</table>