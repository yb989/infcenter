<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>公告记录列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
		var datagrid;
		$(function(){
			close();
			$("#isEffective").combobox('clear');
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('loadData', options);
			
			datagrid = $('#datagrid').datagrid({
				url : '${app}/notice/queryNoticeList',
				title : '',
				pagination : true,
				pageSize : <%=Constants.PAGE_SIZE%>,
				pageList : [10,20,30,40,50],
				fit : true,
				toolbar:"#toolbar",
				border : false,
				idField : 'id',
				singleSelect:true,
				columns : [[{
					field:'cd',
					checkbox:true
				},{
					field : 'title',
					title : '公告标题',
					width : 306
				},{
					field : 'website_id',
					title : '站点名称',
					width : 115
				},{
					field : 'is_effective',
					title : '是否有效',
					width : 55,
					formatter:function(value){
						if(value == '0'){
							return "<span style='font-family:华文中宋; color:#CC0000; '>否</span>";
						}else{
							return "<span style='font-family:华文中宋; color:#00DB00; '>是</span>";
						}
					}
				},{
					field : 'is_top',
					title : '是否置顶',
					width : 55,
					formatter:function(value){
						if(value == '0'){
							return "<span style='font-family:华文中宋; color:#CC0000; '>否</span>";
						}else{
							return "<span style='font-family:华文中宋; color:#00DB00; '>是</span>";
						}
					}
				},{
					field : 'operator',
					title : '操作人',
					width : 55
				},{
					field : 'begin_time',
					title : '公告生效时间',
					width : 140
				},{
					field : 'end_time',
					title : '公告失效时间',
					width : 140				
				},{
					field : 'create_time',
					title : '发布时间',
					width : 140
				},{
					field : 'operate_time',
					title : '最后操作时间',
					width : 150
				}]],
				onDblClickRow :function(rowIndex,rowData){
					var message = rowData.text;
					$("#message").html(message);
					open();
				}
			});
		});
		//跳转添加信息站点页面
		function toInsertNotice(){
			parent.createTab('${app}/notice/toInsertNotice','新增公告信息');
		}
		
		//跳转到修改信息站点页面
		function toUpdateNotice(){
			var row = datagrid.datagrid('getSelected');
			if(null != row){
				parent.createTab('${app}/notice/toUpdateNotice/' + row.id,'修改公告信息');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选中要修改的公告!',
					timeout:5000,
					showType:'slide'
				});
			}
		}				
		
		// 搜索
		function searchFun() {
			datagrid.datagrid('load',serializeObject($("#searchForm")));
			datagrid.datagrid('clearSelections');
			datagrid.datagrid('clearChecked');
		}
		
		function getIsEffective(){
			$("#isEffective").combobox('clear');
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('loadData', options);
		}
		
		function open(){
			$("#w").window('open');
		}
		function close(){
			$("#w").window('close');
		}
	</script>
  </head>
  
  <body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
   	 <div region="north" border="false" style="height:75px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
	  			<tr style="height: 6px;"/>
	  			<tr>
	  				<td class="tdR" width="8%">站点名称:</td>
	  				<td width="10%">
	  					<input id="websiteId" class="easyui-combobox" name="websiteId" style="width: 140px;"
   						data-options="valueField:'id',panelHeight:'auto',textField:'column_zh_name',url:'${app}/pilot/findFirstPilotInfo'" />
	  				</td>
	  				<td class="tdR" width="8%">公告标题:</td>
	  				<td width="10%">
	  					<input id="title" class="easyui-textbox" name="title" style="width: 140px;"/>
	  				</td>
	  				<td class="tdR" width="8%">是否有效:</td>
	  				<td onclick="getIsEffective();">
	  					<input type="text" id="isEffective" name="isEffective" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;"/>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="tdR" width="8%">生效时间:</td>
	  				<td width="28%">
	  					<input id="beginTimeBegin" name="beginTimeBegin" class="easyui-datebox" style="width: 150px;" />
	  					<span>至</span>
	  					<input id="beginTimeEnd" name="beginTimeEnd" class="easyui-datebox" style="width: 150px;" />
	  				</td>
	  				<td class="tdR" width="8%">失效时间:</td>
	  				<td width="28%">
	  					<input id="endTimeBegin" name="endTimeBegin" class='easyui-datebox' style="width: 150px;"/>
	  					<span>至</span>
	  					<input id="endTimeEnd" name="endTimeEnd" class="easyui-datebox" style="width: 150px;" />
	  				</td>
	  				<td width="10%">
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun()">查询</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="clearForm(datagrid);">清空</a>
					</td>
	  			</tr>
	  			<tr style="height: 4px;"/>
			</table>
		</form>
	</div>
  	<div region="center" border="false" style="overflow: hidden;">
  		<table id="datagrid"></table>  
  	</div>
 	<div id="toolbar" style="display: none;">
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toInsertNotice();">新增公告信息</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toUpdateNotice();">修改公告信息</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
	</div>
	<div id="w" class="easyui-window" data-options="title:'正文',collapsible:true,minimizable:true,maximizable:true" style="width:660px;height:440px;padding:4px;z-index:9999">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center',border:false" style="padding:10px;background:#fff;border:1px solid #ccc;">
 				<div id="message">
 				</div>
				<br/><br/>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0;">
			</div>
		</div>
	</div>
  </body>
</html>
