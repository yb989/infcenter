<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>轮播图列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
		var datagrid;
		$(function(){
			$("#isEffective").combobox('clear');
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('loadData', options);
			
			datagrid = $('#datagrid').datagrid({
				url : '${app}/carousel/queryCarouselList',
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
					field : 'file_url',
					title : '图片访问地址',
					width : 170
				},{
					field : 'url',
					title : '点击后跳转链接地址',
					width : 150
				},{
					field : 'website_id',
					title : '站点名称',
					width : 170
				},{
					field : 'is_effective',
					title : '是否有效',
					width : 170,
					formatter:function(value){
						if(value == '0'){
							return "<span style='font-family:华文中宋; color:#FF0000; '>否</span>";
						}else{
							return "<span style='font-family:华文中宋; color:#00DB00; '>是</span>";
						}
					}
				},{
					field : 'begin_time',
					title : '生效时间',
					width : 270
				},{
					field : 'end_time',
					title : '失效时间',
					width : 150					
				},{
					field : 'operator',
					title : '操作人',
					width : 100
				},{
					field : 'operate_time',
					title : '最后操作时间',
					width : 150
				}]],
				
			});
		});
		//跳转添加信息站点页面
		function toInsertCarousel(){
			parent.createTab('${app}/carousel/toInsertCarousel','新增轮播图');
		}
		
		//跳转到修改信息站点页面
		function toUpdateCarousel(){
			var row = datagrid.datagrid('getSelected');
			if(null != row){
				parent.createTab('${app}/carousel/toUpdateCarousel/' + row.id,'修改轮播图');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选中要修改的轮播图!',
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
		
		function getCarouseLists(){
			$("#isEffective").combobox('clear');
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('loadData', options);
		}
		
	</script>
  </head>
  
  <body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
   	 <div region="north" border="false" style="height:75px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
	  			<tr style="height: 5px;"/>
	  			<tr>
	  				<td class="tdR" width="10%">站点名称:</td>
	  				<td width="28%">
	  					<input id="websiteId" class="easyui-combobox" name="websiteId" style="width: 140px;"
   						data-options="valueField:'id',panelHeight:'auto',textField:'column_zh_name',url:'${app}/pilot/findFirstPilotInfo'" />
	  				</td>
	  				<td class="tdR" width="10%">生效时间:</td>
	  				<td width="28%">
	  					<input id="beginTimeBegin" name="beginTimeBegin" class="easyui-datebox" style="width: 150px;" />
	  					<span>至</span>
	  					<input id="beginTimeEnd" name="beginTimeEnd" class="easyui-datebox" style="width: 150px;" />
	  				</td>	  					  					  					  											  					  								
	  			</tr>
	  			
	  			<tr>
	  				<td class="tdR" width="10%">是否有效:</td>
	  				<td  onclick="getCarouseLists();">
	  					<input type="text" id="isEffective" name="isEffective" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;"/>
	  				</td>
	  				<td class="tdR">失效时间:</td>
	  				<td>
	  					<input id="endTimeBegin" name="endTimeBegin" class='easyui-datebox' style="width: 150px;"/>
	  					<span>至</span>
	  					<input id="endTimeEnd" name="endTimeEnd" class="easyui-datebox" style="width: 150px;" />
	  				</td>	  					  					  				
	  				<td width="*%">
						<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchFun()">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="clearForm(datagrid);">清空</a>
					</td>
	  			</tr>
	  			
	  			<tr style="height: 5px;"/>	  			
			</table>
		</form>
	</div>
  	<div region="center" border="false" style="overflow: hidden;">
  		<table id="datagrid"></table>  
  	</div>
 	<div id="toolbar" style="display: none;">
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toInsertCarousel();">新增轮播图</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toUpdateCarousel();">修改轮播图</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
	</div>
	
			
  </body>
</html>
