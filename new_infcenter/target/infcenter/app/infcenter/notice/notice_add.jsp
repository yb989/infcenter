<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>新增公告</title>
    <%@ include file="/common/header.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">
		$(document).ready(function(){						
		});
		   
		//提交
		function submitForm(){
			var title = $("#title").textbox("getValue");
			var text = FCKeditorAPI.GetInstance("text").GetHTML().replace(/[ ]/g,"").replace("<br/>","");
			var websiteId = $("#websiteId").combobox('getValue');
			if(text ==""){
				$.messager.show({
					title:'信息提示',
					msg	 :'正文不能为空',
					timeout:5000,
					showType:'slide'
				});
				return;
			}
			if(title == ""){
				$.messager.show({
					title:'信息提示',
					msg	 :'标题不能为空',
					timeout:5000,
					showType:'slide'
				});
				return;
			}
			if(websiteId == null || websiteId == ''){
				$.messager.show({
					title:'信息提示',
					msg	 :'请选择站点',
					timeout:5000,
					showType:'slide'
				});
				return;
			}
			var noticeForm = $("#noticeForm");			
			noticeForm.form('submit',{
				url:'${app}/notice/doInsertNotice',				
				onSubmit:function(){					
					if(noticeForm.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.createTab('${app}/notice/toNoticeList?messageCode=' + obj.messageCode,'公告发布管理');
					parent.closeTab("新增公告信息");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("新增公告信息");
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="noticeForm" class="easyui-form" method="post" modelAttribute="notice">
		<table class="tableForm" border="0" width="100%" >
			<tr style="font-weight: bold;">
  				<td class="tdL" colspan="4" style="padding-left: 18px;">公告发布信息</td>
  			</tr>
			<tr>
				<td width="15%" class="tdR" ><span style="color: red;">*</span>标题:</td>
				<td width="25%" colspan="3">
					<input name="title" id="title" class="easyui-textbox" data-options="required:true" style="width: 828px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red;">*</span>站点名称:</td>
	  				<td  colspan="3">
	  					<input required="true" id="websiteId" class="easyui-combobox" name="websiteId"  
   						 data-options="valueField:'id',panelHeight:'auto',textField:'column_zh_name',url:'${app}/pilot/findFirstPilotInfo'" />
	  				</td>
				</td>									
			</tr>
			<tr>
				<td class="tdR"><span style="color: red"></span>是否有效:</td>
				<td>
					<input type="radio" id="isEffective1" name="isEffective" value="0" /><label for="isEffective1">否</label>
					<input type="radio" id="isEffective2" name="isEffective" value="1" checked="checked"/><label for="isEffective2">是</label>					
				</td>								
				<td width="15%" class="tdR">是否置顶:</td>
				<td width="35%" >
					<input readonly="readonly" type="radio" id="isTop1" name="isTop" value="0" checked="checked"/><label for="isTop1">否</label>
					<input readonly="readonly" type="radio" id="isTop2" name="isTop" value="1" /><label for="isTop2">是</label>
			   	</td>
			</tr>
			<tr>
				<td class="tdR" id="td_hidden1"><span style="color: red"></span>公告生效时间:</td>
				<td id="td_hidden2">
					<input type="text" id="beginTime" name="beginTime" class="easyui-datetimebox" style="width: 150px;"  editable="false"/>
				</td>			
				<td class="tdR"><span style="color: red"></span>公告失效时间:</td>
				<td>
					<input type="text" id="endTime" name="endTime" class="easyui-datetimebox" style="width: 150px;"  editable="false"/>
				</td>
			</tr>
			<tr>
				<td class="tdR" ><span style="color: red;">*</span>公告内容:</td>
				<td colspan="3">
					<FCK:editor instanceName="text" height="400">
						<jsp:attribute name="value" ></jsp:attribute>
					</FCK:editor>
				</td>
			</tr>
		</table>
		<table align="center">					
			<tr >
				<td colspan="4" align="center">
					<a class="easyui-linkbutton buttonHeight" iconCls="icon-ok" onclick="submitForm();">提交</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton buttonHeight" iconCls="icon-redo" onclick="javascript:resetForm();">取消</a>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
