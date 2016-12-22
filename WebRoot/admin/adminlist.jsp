<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="<%=request.getContextPath() %>" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${ctx}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/demo.css">
<script language="javascript" src="${ctx}/js/jquery-1.9.1.js"></script>
<script language="javascript" src="${ctx}/js/jquery.min.js"></script>
<script language="javascript" src="${ctx}/js/jquery.easyui.min.js"></script>
</head>
<body>
<table id="userlist" class="easyui-datagrid" title="用户管理" style="width:700px;height:250px"
			data-options="singleSelect:true,collapsible:true,url:'usergrid',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userId',width:80">ID</th>
				<th data-options="field:'userName',width:100">用户名</th>
				<th data-options="field:'roleName',width:100">角色</th>
				<th field="isDelete" formatter="formatIsDelete">是否删除</th>
			</tr>
		</thead>
	</table>
<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除</a>
</div>
<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">User Information</div>
	<form id="fm" method="post">
		<div class="fitem">
			<label>用户名</label>
			<input name="userName" id="userName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>密码</label>
			<input name="password" id="password" type="password" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
</body>
</html>
<script language="javascript">
function newUser() {
	$('#dlg').dialog('open').dialog('setTitle','New User');
	$('#fm').form('clear');
}
function saveUser() {
	//alert($('password').val());
	$.post("user!add",
			{userName:$('#userName').val(),password:$('#password').val()},
			function(result){
				if(result.result) {
					$('#dlg').dialog('close');
					$('#userlist').datagrid('reload');
				} else {
					alert("fail");
				}
			},
			'json');
}
function formatIsDelete(val,row) {
	if(val == 0)
		return "未删除";
	else
		return "已删除";
}
function deleteUser() {
	var row = $('#userlist').datagrid('getSelected');
	if (row){
		$.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
			if (r){
				$.post('user!delete',{id:row.userId},function(result){
					if (result.result){
						$('#userlist').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({	// show error message
							title: 'Error',
							msg: 'error'
						});
					}
				},'json');
			}
		});
	}
}
</script>
<!-- <script language="javascript"> -->
<!-- // // var grid; -->
<!-- // // $(function() { -->
<!-- // // 	grid = $('#grid').datagrid({ -->
<!-- // // 		title : '', -->
<!-- // // 		url :'http://localhost:8080/zyhCityTcp/user!grid', -->
		
<!-- // // 		columns : [ [ { -->
<!-- // // 			title : "id", -->
<!-- // // 			field : "userId", -->
<!-- // // 		},{ -->
<!-- // // 			title : "name", -->
<!-- // // 			field : "userName" -->
<!-- // // 		} ] ], -->
<!-- // // 		toolbar : '#toolbar', -->
<!-- // // 		onBeforeLoad : function(param) { -->
			
<!-- // // 		}, -->
<!-- // // 		onLoadSuccess : function(data) { -->
			
<!-- // // 		} -->
<!-- // // 	}); -->
<!-- // // }); -->
<!-- </script> -->