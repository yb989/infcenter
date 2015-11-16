<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>详情页列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
		var datagrid;
		$(function(){
			//关闭正文窗口
			close();
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('clear');
			$("#isEffective").combobox('loadData', options);
			
			$("#columnZhName2").combobox({
				url:'${app}/pilot/findSubWorkPilotInfoById?id='+"",
				valueField:'id',
				textField :'column_zh_name'
				
			});	
			
			$("#columnZhName3").combobox({
				url:'${app}/pilot/findSubWorkPilotInfoById?id='+"",
				valueField:'id',
				textField :'column_zh_name'
			});
			//所属站点
			var optionsColumn = [{"text": "--请选择--", "value": ""}];
			$("#columnZhName1").combobox({
				url:'${app}/pilot/findFirstPilotInfo',
				valueField:'id',
				textField :'column_zh_name',
				onChange:function(newValue,oldValue){
					//一级导航
					$("#columnZhName2").combobox('clear');
					$("#columnZhName2").combobox('reload',"${app}/pilot/findSubWorkPilotInfoById?id=" + newValue);
					$("#columnZhName2").combobox('loadData', optionsColumn);
<%--					$("#columnZhName3").combobox('clear');--%>
<%--					$("#columnZhName3").combobox('loadData', optionsColumn);--%>
				}
			});
			
			
			$("#columnZhName2").combobox({
				valueField:'id',
				textField :'column_zh_name',
				onChange:function(newValue,oldValue){
					$("#columnZhName3").combobox('clear');
					$("#columnZhName3").combobox('reload',"${app}/pilot/findSubWorkPilotInfoById?id=" + newValue);
				}
			});
			
			//三级导航
			$("#columnZhName3").combobox({
				valueField:'id',
				textField :'column_zh_name'
			});
			
			$("input[name='isEffective']").click(function(){
				getInfcenterInformationLists();
			});
			
			$("#message").html('');
			datagrid = $('#datagrid').datagrid({
				url : '${app}/infcenterInformation/queryInformationList',
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
					title : '标题',
					width : 370,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				},{
					field : 'info_sources',
					title : '信息来源',
					width : 203,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				},{
					field : 'is_effective',
					title : '是否有效',
					width : 58,
					formatter:function(value){
						if(value == '0'){
							return "<span title='双击查看文件正文' style='font-family:华文中宋; color:#CC0000'>否</span>";
						}else{
							return "<span title='双击查看文件正文' style='font-family:华文中宋; color:#009900'>是</span>";
						}
					}
				},{
					field : 'is_top',
					title : '是否置顶',
					width : 58,
					formatter:function(value){
						if(value == '0'){
							return "<span title='双击查看文件正文' style='font-family:华文中宋; color:#CC0000'>否</span>";
						}else{
							return "<span title='双击查看文件正文' style='font-family:华文中宋; color:#009900'>是</span>";
						}
					}
				},{
					field : 'first_name',
					title : '所属站点',
					width : 90,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				},{
					field : 'seconde_name',
					title : '一级站点',
					width : 90,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				}
				,{
					field : 'operator',
					title : '操作人',
					width : 65,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				},{
					field : 'operate_time',
					title : '最后操作时间',
					width : 135,
					formatter:function(value){
						return "<span title='双击查看文件正文'>"+ value +"</span>";
					}
				}]],
				onDblClickRow :function(rowIndex,rowData){
					var message = rowData.text;
					$("#message").html(message);
					open();
				}
			});
		});
		
		function toAddInformation(){
			parent.createTab('${app}/infcenterInformation/saveInformation','添加页面内容');
		}
		
		//跳转到客户编辑页面
		function toEditInformation(){
			var row = datagrid.datagrid('getSelected');
			if(null != row){
				parent.createTab('${app}/infcenterInformation/toEdit/' + row.id,'修改页面内容');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选中要修改的页面内容!',
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
		
		function open(){
			$('#w').window('open');
		}
		function close(){
			$('#w').window('close');
		}
		function getInfcenterInformationLists(){
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
	  			<tr style="height: 6px;"/>
	  			<tr>
	  				<td class="tdR" width="8%">标题:</td>
	  				<td width="10%">
	  					<input id="title" name="title" class='easyui-textbox' style="width: 140px;"/>
	  				</td>
	  				<td class="tdR" width="8%">信息来源:</td>
	  				<td width="10%">
	  					<input  id="infoSources" name="infoSources" class='easyui-textbox' style="width: 140px;"/>
	  				</td>
	  				<td class="tdR" width="8%">是否有效:</td>
	  				<td onclick="getInfcenterInformationLists();">
	  					<input type="text"  id="isEffective" name="isEffective" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;" />
	  				</td>
	  			</tr>
	  			<tr>
	  				<td class="tdR" width="8%">所属栏目:</td>
	  				<td width="38%">
	  					<input type="text" id="columnZhName1" name="columnZhName1" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;"/>&nbsp;
	  					<input type="text" id="columnZhName2" name="columnZhName2" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;"/>&nbsp;
<%--	  					<input type="text" id="columnZhName3" name="columnZhName3" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 140px;"/>--%>
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
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toAddInformation();">新增信息</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toEditInformation();">修改信息</a>
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