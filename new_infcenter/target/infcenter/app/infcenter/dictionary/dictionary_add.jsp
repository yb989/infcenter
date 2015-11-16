<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>    
    <title>常量添加页面</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    	
	<script type="text/javascript">				   
		//提交
		function submitForm(){						
			var dictionaryForm = $("#dictionaryForm");			
			dictionaryForm.form('submit',{
				url:'${app}/dictionary/doInsertDictionary',				
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
					parent.closeTab("新增常量信息");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("新增常量信息");
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="dictionaryForm" class="easyui-form" method="post" modelAttribute="dictionary">
		<table class="tableForm" border="0" width="100%" >			
			<tr>
				<td class="tdR"><span style="color: red;">*</span>中文注释:</td>
				<td>
					<input type="text" name="cnNote" class="easyui-textbox" data-options="required:true,validType:['length[0,100]']" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red;">*</span>参数:</td>
	  				<td>
	  					<input type="text" name="paramete" class="easyui-textbox" data-options="required:true,validType:['length[0,300]']" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;
	  				</td>
				</td>									
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>备注:</td>
				<td>
					<input type="text" name="remark" class="easyui-textbox" data-options="required:true,validType:['length[0,300]']" style="width: 175px;height: 24px;"/>&nbsp;&nbsp;					
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
