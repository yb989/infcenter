<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<%@ include file="/common/zTree.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>栏目管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<style type="text/css">
		.trreDiv {
			float: left;
			width: 23%;
			height: 100%;
			font-size: 15px;
			border: 1px solid #6699FF;
		}
		#treeDept {
			float: left;
			width: 95%;
			height: 90%;
			overflow: auto;
		}
	</style>
	<script type="text/javascript">
		var zTreeObj = null;
		var deptDialog = null;
		$(document).ready(function(){
			var setting = {
					data: {
						key:{name: 'column_zh_name'},
						simpleData: {
							enable: true,
							idKey: 'id',
							pIdKey: 'parent_id'
						}
					},
					view: {
						showTitle: false,
						expandSpeed: 0
					},
					callback: {
						onRightClick : zTreeOnRightClick
					}
			};
			
			var zTreeNodes = null;
			//查询树节点
			$.ajax({
				url : "${app}/pilot/queryPilots",
				type : "post",
				dataType : "json",
				async : false,
				success : function(msg){
					if(msg != null && msg.length != 0){
						zTreeNodes = msg;
					}
				},		
				error : function(){
					$.messager.alert("提示信息","系统错误！","info");
				}
			});
			
			zTreeObj = $.fn.zTree.init($("#treeDept"), setting, zTreeNodes);
			zTreeObj.expandAll(true);//全部展开
		});
		
		//右键回调事件
		function zTreeOnRightClick(event, treeId, treeNode) {
			if(treeNode != null){
				zTreeObj.selectNode(treeNode);//选中当前节点
				$("#id").val(treeNode.id);
				$('#rightMenu').menu('show', {
					left: event.pageX,
					top: event.pageY
				});
			}
		}
		
		//打开设置提前还款时间输入框
		function openDeptDialog(v_url,v_oper){
			deptDialog = $('#deptDialog').dialog({  
				top:100,
				title: v_oper,   
				width: 550,   
				height: 230,  
				closed: false,   
				cache: false,   
				href: v_url,   
				modal: true
			}); 
		}
		
		//添加根目录
		function addBigPilot(){
			var url = "${app}/pilot/toInputPilot";
			openDeptDialog(url,"添加栏目站点");
		}
		
		//添加站点
		function addPilot(){
			var nodes = zTreeObj.getSelectedNodes();//获取 zTree当前被选中的节点数据集合
			var isParent = nodes[0].isParent;
			var selectNode = zTreeObj.getSelectedNodes()[0];
			if( selectNode.parent_id == null){
				var url = "${app}/pilot/toInputPilotFirst?parentId=" + $("#id").val();
				openDeptDialog(url,"添加栏目站点");			
			}else if(isParent){
				var url = "${app}/pilot/toInputPilotTwo?parentId=" + $("#id").val();
				openDeptDialog(url,"添加栏目站点");
			}else{
				var url = "${app}/pilot/toInputPilotTwo?parentId=" + $("#id").val();
				openDeptDialog(url,"添加栏目站点");
			}
		}
		
		//修改站点
		function editPilot(){
			var nodes = zTreeObj.getSelectedNodes();//获取 zTree当前被选中的节点数据集合
			var isParent = nodes[0].isParent;
			var selectNode = zTreeObj.getSelectedNodes()[0];
			if(selectNode.parent_id == null){
				var url = "${app}/pilot/toInputPilot?id=" + $("#id").val();
				openDeptDialog(url,"修改栏目站点");
			}else if(isParent){
				var url = "${app}/pilot/toInputPilotFirst?id=" + $("#id").val();
				openDeptDialog(url,"修改栏目站点");
			}else{
				var url = "${app}/pilot/toInputPilotTwo?id=" + $("#id").val();
				openDeptDialog(url,"修改栏目站点");
			}
		}
		
		//删除站点
		function removePilot(){
			var nodes = zTreeObj.getSelectedNodes();//获取 zTree当前被选中的节点数据集合
			var isParent = nodes[0].isParent;//记录 treeNode 节点是否为父节点。
			if(isParent){
				$.messager.alert("信息提示", "父节点不能执行删除操作!!", "warning",function(){});
				return;
			}
			$.messager.confirm("请确认", "您确认要删除该部门吗？", function(b){
				if(b){
					openMask();
					$.ajax({
						async:false,
						type:'post',
						url:"${app}/pilot/doDelPilot/" + $("#id").val(),
						dataType:'json',
						success:function(data){
							closeMask();
							parent.createTab('${app}/pilot/toPilotList?messageCode=' + data.messageCode,'栏目管理');
						}
					});
				}
			});
		}
		
		//移动站点进行排序上移
		function movePilotUp(){
			var nodes = zTreeObj.getSelectedNodes();//获取 zTree当前被选中的节点数据集合
			$.ajax({
					async:false,
					type:'post',
					url:"${app}/pilot/queryMenuSort?sort=" +nodes[0].column_sort+"&parentId="+nodes[0].parent_id,
					dataType:'json',
					success:function(data){
					data = JSON.parse(data);
						if(data!=null){
							$.ajax({
							async:false,
							type:'post',
							url:"${app}/pilot/editSortByPilot?id1=" +nodes[0].id+"&sort1="+data.sort+"&id2="+data.id+"&sort2="+nodes[0].column_sort,
							dataType:'json',
							success:function(result){
									result = JSON.parse(result);
									if(result!=null&result.messageCode=='0'){
									    parent.createTab('${app}/pilot/toPilotList?refreshTag=1','栏目管理');
									}
							}
						});
						}
					}
			});
		}
		
		//移动站点进行排序下移
		function movePilotDown(){
			var nodes = zTreeObj.getSelectedNodes();//获取 zTree当前被选中的节点数据集合
			$.ajax({
					async:false,
					type:'post',
					url:"${app}/pilot/queryMenuSortByDown?sort=" +nodes[0].column_sort+"&parentId="+nodes[0].parent_id,
					dataType:'json',
					success:function(data){
					data = JSON.parse(data);
						if(data!=null){
							$.ajax({
							async:false,
							type:'post',
							url:"${app}/pilot/editSortByPilot?id1=" +nodes[0].id+"&sort1="+data.sort+"&id2="+data.id+"&sort2="+nodes[0].column_sort,
							dataType:'json',
							success:function(result){
									result = JSON.parse(result);
									if(result!=null&result.messageCode=='0'){
									   parent.createTab('${app}/pilot/toPilotList?refreshTag=1','栏目管理');
									}
								}
							});
						}
					}
			});
		}
		
		//提交
		function submitFn(){
			var pilotForm = $("#pilotForm");
			pilotForm.form('submit',{
				url:'${app}/pilot/doAddEditPilot',
				onSubmit:function(){
					if(pilotForm.form("validate")){
				    	openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(msg){
					closeMask();
					var data = eval("(" + msg + ")");
					parent.createTab('${app}/pilot/toPilotList?messageCode=' + data.messageCode,'栏目管理');
				}
			});
		}
		
		//取消
		function cancelFn(){
			deptDialog.dialog('close');
		}
	</script>
  </head>
  <body style="background-color: white;">
		<div class="trreDiv">
			<a id="addMenu" onclick="addBigPilot()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加导航</a>
			<ul id="treeDept" class="ztree"></ul>
		</div>
<input type="hidden" id="id" name="id"/>
<div id="rightMenu" class="easyui-menu" style="width: 100px;display: none;">
	<a id="addMenu" onclick="addPilot()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加栏目站点</a>
	<a id="editMenu" onclick="editPilot()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改栏目站点</a>
	<!-- <a id="removeMenu" onclick="removePilot()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除栏目站点</a> -->
	 <a id="removeMenu" onclick="movePilotUp()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">上移</a>
	<a id="removeMenu" onclick="movePilotDown()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">下移</a> 
</div>
<div id="deptDialog"></div>
  </body>
</html>