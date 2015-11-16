<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>    
    <title>公告信息编辑页面</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script type="text/javascript">		 
		//提交
		function submitForm(){						
			var carouselForm = $("#carouselForm");
			carouselForm.form('submit',{
				url:'${app}/carousel/doUpdateCarousel',				
				onSubmit:function(){					
					if(carouselForm.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.createTab('${app}/carousel/toCarouselList?messageCode=' + obj.messageCode,'轮播图管理');
					parent.closeTab("修改轮播图");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改轮播图");
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="carouselForm" class="easyui-form" method="post" modelAttribute="carousel">
  		<input type="hidden" id="id" name="id" value="${carouselMap.id}"/>
		<table class="tableForm" border="0" width="100%" >
			<tr>
				<td class="tdR"><span style="color: red;">*</span>图片访问地址:</td>
				<td>
					<input type="text" name="fileUrl" value="${carouselMap.file_url}" class="easyui-textbox" data-options="required:true,validType:['length[0,300]']" style="width: 475px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR">点击后跳转链接地址:</td>
				<td>
					<input type="text" name="url" value="${carouselMap.url}" class="easyui-textbox" data-options="validType:['length[0,500]']" style="width: 475px;"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red;">*</span>站点名称:</td>
	  				<td>
	  					<input id="websiteId" class="easyui-combobox" name="websiteId" value="${carouselMap.website_id}"
   						 data-options="valueField:'id',panelHeight:'auto',textField:'column_zh_name',url:'${app}/pilot/findFirstPilotInfo'" style="width: 475px;"/>   						 
	  				</td>
				</td>									
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>是否有效:</td>
				<td>
					<input type="radio" id="isEffective_1" name="isEffective" value="0" <c:if test="${carouselMap.is_effective=='0'}">checked</c:if> /><label for="isEffective_1">否</label>
					<input type="radio" id="isEffective_2" name="isEffective" value="1" <c:if test="${carouselMap.is_effective=='1'}">checked</c:if>/><label for="isEffective_2">是</label>					
				</td>
			</tr>
			<tr>								
				<td class="tdR" id="td_hidden1"><span style="color: red">*</span>生效时间:</td>
				<td id="td_hidden2">
					<input type="text" name="beginTime" value="${carouselMap.begin_time}" class="easyui-datetimebox" style="width: 450px;" required="true"/>
				</td>
			</tr>			
			<tr>				
				<td class="tdR"><span style="color: red"></span>失效时间:</td>
				<td>
					<input type="text" name="endTime" value="${carouselMap.end_time}" class="easyui-datetimebox" style="width: 450px;" editable="false"/>
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
