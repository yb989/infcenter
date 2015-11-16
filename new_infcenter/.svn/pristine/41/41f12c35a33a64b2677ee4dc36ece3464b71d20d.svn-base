<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.dafy.crm.common.constant.InterfaseDescriptionConstants"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>接口日志信息列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript">
		var datagrid;
		$(function(){
			datagrid = $('#datagrid').datagrid({
				url : '${app}/interface_log/interfaceLog_pageList.shtml',
				title : '',
				pagination : true,
				pageSize : <%=Constants.PAGE_SIZE%>,
				pageList : [10,20,30,40,50],
				fit : true,
				border : false,
				idField : 'id',
				singleSelect:true,
				columns : [[{
					field:'cd',
					checkbox:true
				},{
					field : 'system_identifying',
					title : '系统标识',
					width : 60
				},{
					field : 'interfase_description',
					title : '接口功能描述',
					width : 200
				},{
					field : 'interfase_data',
					title : '传输数据',
					width : 500
				},{
					field : 'oper_state',
					title : '操作状态',
					width : 70
				},{
					field : 'is_call_back_name',
					title : '是否为回调接口',
					width : 100
				},{
					field : 'oper_time',
					title : '操作时间',
					width : 130
				},{
					field : 'id',
					title : '操作',
					width : 80,
					formatter: function(value,row,index){
						var retStr = "";
						if(row.oper_state != 'true' && row.is_call_back =='0'){
							retStr += "<a href='javascript:void(0);' style='color: green;' onclick='callInterface(" + index + ");'>手动触发</a>&nbsp;&nbsp;";
						}
						return retStr;
					}
				}]]
			});
		});
		
		//手动触发
		function callInterface(v_index){
			openMask();
			datagrid.datagrid('selectRow',v_index);
			var row = datagrid.datagrid('getSelected');
			$.ajax({
				async:false,
				type:'post',
				url:"${app}/interface_log/interfaceLog_callInterface.shtml?interfaceLogId=" + row.id,
				dataType:'json',
				success:function(obj){
					closeMask();
					parent.createTab("${app}/interface_log/interfaceLog_toInterfaceLogList.shtml?messageCode=" + obj.messageCode, '接口日志管理');
				}
			});
		}
		
		//搜索
		function searchFun() {
			datagrid.datagrid('load',serializeObject($("#searchForm")));
			datagrid.datagrid('clearSelections');
			datagrid.datagrid('clearChecked');
		}
	</script>
  </head>
  
  <body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
  	<div region="north" border="false" style="height:60px; overflow:hidden;">
  		<form id="searchForm">
	  		<table border="0" class="searchForm datagrid-toolbar" width="100%">
	  			<tr>
					<td class="tdR" width="10%">系统标识:</td>
					<td  width="15%">
						<input name="systemIdentifying" class='easyui-validatebox' style="width: 150px;"/>
					</td>
					<td class="tdR" width="10%">操作时间:</td>
					<td  width="20%">
						<input name="startDate" class="easyui-datebox" editable="false" style="width: 90px;"/>
						至<input name="endDate" class="easyui-datebox" editable="false" style="width: 90px;"/>
					</td>
					<td class="tdR" width="10%">接口功能描述:</td>
					<td width="15%">
						<input name="interfaseDescription" class="easyui-validatebox" panelheight="150px" style="width:150px;"/>
					</td>
					<td  width="20%">&nbsp;</td>
				</tr>
				<tr>
					<td class="tdR">传输数据:</td>
					<td>
						<input name="interfaseData" class="easyui-validatebox" panelheight="150px" style="width:150px;"/>
					</td>
					<td class="tdR">操作状态:</td>
					<td>
						<select name="operState" id="operState" class="easyui-combobox" panelheight="130px" editable="false" style="width:150px;">
							<option value="">请选择</option>
							<option value="true">true</option>
							<option value="false">false</option>
							<option value="null">空</option>
						</select>
					</td>
					<td class="tdR">是否回调:</td>
					<td>
						<select name="isCallBack" id="isCallBack" class="easyui-combobox" panelheight="130px" editable="false" style="width:150px;">
							<option value="">请选择</option>
							<option value="1">是</option>
							<option value="0">不是</option>
						</select>
					</td>
					<td>
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="clearForm(datagrid);">清空</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
  	<div region="center" border="false" style="overflow: hidden;">
  		<table id="datagrid"></table>
  	</div>
  </body>
</html>
