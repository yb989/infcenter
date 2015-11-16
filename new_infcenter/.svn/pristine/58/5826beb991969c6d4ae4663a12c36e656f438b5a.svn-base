<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>常量编辑页面</title>
    <%@ include file="/common/header.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">		 
		   
		//提交
		function submitForm(){			
			
			var dictionaryForm = $("#dictionaryForm");
			dictionaryForm.form('submit',{
				url:'${app}/dictionary/doUpdateDictionary',				
				onSubmit:function(){					
					if(dictionaryForm.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.createTab('${app}/dictionary/toDictionaryList?messageCode=' + obj.messageCode,'常量维护');
					parent.closeTab("修改常量信息");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改常量信息");
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="dictionaryForm" class="easyui-form" method="post" modelAttribute="dictionary">
  		<input type="hidden" id="id" name="id" value="${dictionaryMap.id}"/>
		<table class="tableForm" border="0" width="100%" >
			<tr style="font-weight: bold;">
  				<td class="tdL" colspan="4" style="padding-left: 18px;">常量信息</td>
  			</tr>
			<tr>
				<td width="15%" class="tdR"><span style="color: red;">*</span>中文注释:</td>
				<td width="25%">
					<input type="text" name="cnNote" value="${dictionaryMap.cn_note}" class="easyui-textbox" data-options="required:true,validType:['length[0,100]']" style="width: 175px;"/>
				</td>
				<td class="tdR" width="10%"><span style="color: red;">*</span>参数:</td>
	  				<td>
	  					<input type="text" name="paramete" value="${dictionaryMap.paramete}" class="easyui-textbox" data-options="required:true,validType:['length[0,300]']" style="width: 175px;"/>
	  				</td>
				</td>									
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>备注:</td>
				<td>
					<input type="text" name="remark" value="${dictionaryMap.remark}" class="easyui-textbox" data-options="required:true,validType:['length[0,300]']" style="width: 175px;"/>					
				</td>												
			</tr>							
			<tr>
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
