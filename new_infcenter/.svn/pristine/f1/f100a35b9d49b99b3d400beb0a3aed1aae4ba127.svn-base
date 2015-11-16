<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>内容发布平台字典列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">
		var datagrid;
		$(function(){			
			
			datagrid = $('#datagrid').datagrid({
				url : '${app}/dictionary/queryDictionaryList',
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
					field : 'cn_note',
					title : '中文注释',
					width : 170
				},{
					field : 'paramete',
					title : '参数',
					width : 170
				},{
					field : 'remark',
					title : '备注',
					width : 170,					
				}]],
				
			});
		});
		//跳转添加信息站点页面
		function toInsertDictionary(){
			parent.createTab('${app}/dictionary/toInsertDictionary','新增常量信息');
		}
		
		//跳转到修改信息站点页面
		function toUpdateDictionary(){
			var row = datagrid.datagrid('getSelected');
			if(null != row){
				parent.createTab('${app}/dictionary/toUpdateDictionary/' + row.id,'修改常量信息');
			}else{
				$.messager.show({
					title:'信息提示',
					msg:'请选中要修改的常量!',
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
		
	</script>
  </head>
  
  <body class="easyui-layout" fit="true" style="width: 100%;height: 100%;">
   	 <div region="north" border="false" style="height:42px; overflow:hidden;">
  		<form id="searchForm">
	  		<table  border="0" class="searchForm datagrid-toolbar" width="100%">
  			
	  			
	  			<tr>
	  				<td class="tdR" width="10%">中文注释:</td>
	  				<td width="40%">
						<input id="cnNote" name="cnNote" class='easyui-textbox' style="width: 140px;"/>
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
  		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="toInsertDictionary();">新增常量信息</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="toUpdateDictionary();">修改常量信息</a>
		<img src="${app}/images/separator.jpg" style="vertical-align: middle; *margin-top: -4px">
	</div>
	
	
  </body>
</html>
