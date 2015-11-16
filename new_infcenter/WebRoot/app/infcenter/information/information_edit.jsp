<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%@page import="com.yph.infcenter.common.util.PropertyUtil"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>修改文章</title>
    <%@ include file="/common/header.jsp"%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${app}/js/upload/css/default.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${app}/js/upload/ajaxupload.js"></script>	
	<script type="text/javascript" src="${app}/js/upload/swfupload.js"></script>
	<script type="text/javascript" src="${app}/js/upload/swfupload.queue.js"></script>
	<script type="text/javascript" src="${app}/js/upload/fileprogress.js"></script>
	<script type="text/javascript" src="${app}/js/upload/handlers.js"></script>
	<script type="text/javascript" src="${app}/js/common/js/common.js"></script>
	<script type="text/javascript">
		var upload;
		window.onload = function() {
			upload = new SWFUpload({
				// Backend Settings
				upload_url: "${app}/infcenterInformation/makeImg?id=${map.id}",
				file_post_name: "file",
				preserve_relative_urls:true,
				// File Upload Settings
				file_size_limit : "500KB",
				file_types : "*.jpg;*.png;*.gif;",
				file_types_description : "All Files",
				file_upload_limit : "1",  //最多10个附件上传
				file_queue_limit : "0",
				// Event Handler Settings (all my handlers are in the Handler.js file)
				file_dialog_start_handler : fileDialogStart,
				file_queued_handler : fileQueued,
				file_queue_error_handler : fileQueueError,
				file_dialog_complete_handler : fileDialogComplete,
				upload_start_handler : uploadStart,
				upload_progress_handler : uploadProgress,
				upload_error_handler : uploadError,
				upload_success_handler : uploadSuccess,
				upload_complete_handler : uploadComplete,
				// Button Settings
				button_image_url : "${app}/js/upload/XPButtonUploadText_61x22.png",
				button_placeholder_id : "spanButtonPlaceholder",
				button_window_mode : "Opaque",
				button_width: 61,
				button_height: 22,
				// Flash Settings
				flash_url : "${app}/js/upload/swfupload.swf",
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false
			});
		}
		
		function uploadError(file,code,message){
			var progress = new FileProgress(file, this.customSettings.progressTarget);
			progress.setComplete();
			progress.setStatus("<span>上传失败</span>!");
			progress.toggleCancel(false);
		}
		
	    function uploadSuccess(file, serverData) {
			try {
				var data =$.parseJSON(serverData);
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				if(data.status=='success'){
					console.info(data.code);
					progress.setStatus("<span>上传成功</span>!");
					progress.setComplete();
					$("#indexImgs").attr("src","${app }/indexImg/"+data.indexUrl);
					$("#indexImgs").attr("width",360);
					$("#indexImgs").attr("height",240);
					$("#isIndex2").attr("checked","checked");
					$("#indexUrl").val(data.indexUrl);
					progress.toggleCancel(false);
				}else{
					progress.setStatus("<span>上传失败</span>!");
				}		
			} catch (ex) {
				this.debug(ex);
			}
	}

	function fileQueueError(file, errorCode, message) {
		console.info(file);
		console.info(errorCode);
		console.info(message);
		try {
			if (errorCode === SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED) {
				alert("您已经上传了太多的附件!\n"
						+ (message === 0 ? "已经达到限制了." : "You may select "
								+ (message > 1 ? "up to " + message + " files."
										: "0 file.")));
				return;
			}

			var progress = new FileProgress(file,
					this.customSettings.progressTarget);
			progress.setError();
			progress.toggleCancel(false);

			switch (errorCode) {
			case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
				progress.setStatus("文件太大了 请缩小文件!");
				this
						.debug("Error Code: 文件太大了 请缩小文件!, File name: "
								+ file.name + ", File size: " + file.size
								+ ", Message: " + message);
				break;
			case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
				progress.setStatus("Cannot upload Zero Byte files.");
				this.debug("Error Code: Zero byte file, File name: "
						+ file.name + ", File size: " + file.size
						+ ", Message: " + message);
				break;
			case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
				progress.setStatus("错误的文件类型!");
				this.debug("Error Code: Invalid File Type, File name: "
						+ file.name + ", File size: " + file.size
						+ ", Message: " + message);
				break;
			case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
				alert("You have selected too many files.  "
						+ (message > 1 ? "You may only add " + message
								+ " more files"
								: "You cannot add any more files."));
				break;
			default:
				if (file !== null) {
					progress.setStatus("Unhandled Error");
				}
				this.debug("Error Code: " + errorCode + ", File name: "
						+ file.name + ", File size: " + file.size
						+ ", Message: " + message);
				break;
			}
		} catch (ex) {
			this.debug(ex);
		}
	}
</script>
	<script type="text/javascript">
		$(document).ready(function(){
			var indexUrl = "${map.indexUrl}";
			if(indexUrl != ""){
				$("#indexImgs").attr("src","${app }/indexImg/"+indexUrl);
				$("#indexImgs").attr("width",360);
				$("#indexImgs").attr("height",240);
			}
			limit_textarea_input();//统计文本域输入字数
			$("#isEffective").combobox('clear');
			var options = [{"text": "--请选择--", "value": ""},{"text": "是", "value": "1"},{"text": "否", "value": "0"}];
			$("#isEffective").combobox('loadData', options);
			
			var optionsColumn = [{"text": "--请选择--", "value": ""}];
			$("#columnZhName2").combobox('clear');
			$("#columnZhName2").combobox('loadData', optionsColumn);
			$("#columnZhName3").combobox('clear');
			$("#columnZhName3").combobox('loadData', optionsColumn);
				
			//一级导航
			$("#columnZhName1").combobox({
				url:'${app}/pilot/findFirstPilotInfo',
				valueField:'id',
				textField :'column_zh_name',
				onChange:function(newValue,oldValue){
					$("#columnZhName2").combobox('clear');
					$("#columnZhName2").combobox('reload',"${app}/pilot/findSubWorkPilotInfoById?id=" + newValue);
					$("#columnZhName2").combobox('loadData', optionsColumn);
					$("#columnZhName3").combobox('clear');
					$("#columnZhName3").combobox('loadData', optionsColumn);
					$("#velocity_name").val();
					$("#websiteId").val($('#websiteId').combobox('getValue'));
				}
			});
			
		    //二级导航
			$("#columnZhName2").combobox({
				valueField:'id',
				textField :'column_zh_name',
				onChange:function(newValue,oldValue){
				  $("#firstLevelId").val($('#columnZhName2').combobox('getValue'));
					$("#columnZhName3").combobox('clear');
					$("#columnZhName3").combobox('reload',"${app}/pilot/findSubWorkPilotInfoById?id=" + newValue);
					$("#velocity_name").val();
				}
			});
			
			//三级导航
			$("#columnZhName3").combobox({
				valueField:'id',
				textField :'column_zh_name',
				onChange:function(newValue,oldValue){
				    $("#secondLevelId").val($('#columnZhName3').combobox('getValue'));
					$("#velocity_name").val();
					$("#thirdLevelId").val($('#columnZhName3').combobox('getValue'));
				}
			});
		});
		
		//提交
		function submitForm(){
			var customerForm = $("#infcenterForm");
			customerForm.form('submit',{
				url:'${app}/infcenterInformation/doEdit',
				onSubmit:function(){
					if(customerForm.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					var obj = eval("(" + data + ")");
					parent.createTab('${app}/infcenterInformation/toInformationList?messageCode=' + obj.messageCode,'页面发布管理');
					resetForm();
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("修改页面内容");
		}
		
		//预览
		function previewForm(){
		 	
		 	var text = FCKeditorAPI.GetInstance("text").GetHTML().replace(/[ ]/g,"").replace("<br/>","");
		 	if(text.length==0){
				$.messager.show({
							title:'信息提示',
							msg	 :'所属栏目不能为空',
							timeout:5000,
							showType:'slide'
				});
				return false;
			}
			var informationAddForm = $("#infcenterForm");
			informationAddForm.form('submit',{
				url:'${app}/infcenterInformation/showInformationHtml',
				onSubmit:function(){
					if(informationAddForm.form("validate")){
						openMask();
						return true;
					}else{
						return false;
					}
				},
				success:function(data){
					closeMask();
					
					var obj = eval("(" + data + ")");
					var code = obj.code;
					if(code == '0000'){
						OpenWindow=window.open("", "newwin", "");
						obj = obj.html.replaceAll("&lt;","<").replaceAll("&gt;",">").replaceAll("&amp;","&");
						OpenWindow.document.write(obj);
						OpenWindow.document.close();
					}else{
						$.messager.show({
							title:'信息提示',
							msg	 :'出现异常，无法预览页面',
							timeout:5000,
							showType:'slide'
						});
						return;
					}
				}
			});
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="infcenterForm" class="easyui-form" method="post" modelAttribute="infcenterEdit">
  	    <input type="hidden" id="indexUrl" name="indexUrl" />
  	    <input type="hidden" id="thirdLevelId" name="thirdLevelId" value="${map.second_level_id }"/>
  		<input type="hidden" id="id" name="id" value="${map.id}"/>
  		<input type="hidden" id="websiteId" name="websiteId" value="${map.website_id }"/>
  		<input type="hidden" id="firstLevelId" name="firstLevelId" value="${map.first_level_id }"/>
  		<input type="hidden" id="secondLevelId" name="secondLevelId" value="${map.second_level_id }"/>
		<table class="tableForm" border="0" width="100%" >
			<tr style="font-weight: bold;">
  				<td class="tdL" colspan="4" style="padding-left: 18px;">详情页发布信息</td>
  			</tr>
			<tr>
				<td width="15%" class="tdR"><span style="color: red;">*</span>标题:</td>
				<td width="35%">
					<input type="text" id="title" name="title" value="${map.title}" class="easyui-textbox" data-options="required:true,validType:['length[0,80]']" style="width: 341px;"/>
				</td>
<%--				<td width="15%" class="tdR"><span style="color: red;">*</span>信息来源:</td>--%>
<%--			    <td width="35%">--%>
<%--				    <input type="text" name="infoSources" value="${map.info_sources}" class="easyui-textbox" data-options="required:true,validType:['length[0,30]']" style="width: 341px;"/>--%>
<%--			    </td>--%>
			</tr>
			<tr>
				<td class="tdR">所属栏目:</td>
  				<td>
  					<input type="text" id="columnZhName1" name="columnZhName1" value="${map.first_name}" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 110px;"/>&nbsp;
  					<input type="text" id="columnZhName2" name="columnZhName2" value="${map.seconde_name}" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 110px;"/>&nbsp;
<%--  					<input type="text" id="columnZhName3" name="columnZhName3" value="${map.thread_name}" class="easyui-combobox" panelHeight="130px" editable="false" style="width: 110px;"/>--%>
  				</td>
	    		<td class="tdR"></td>
				<td>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>是否有效:</td>
				<td>
					<input type="radio" id="isEffective_1" name="isEffective" value="0" <c:if test="${map.is_effective=='0'}">checked</c:if>/><label for="isTask_1">否</label>
					<input type="radio" id="isEffective_2" name="isEffective" value="1" <c:if test="${map.is_effective=='1'}">checked</c:if>/><label for="isTask_2">是</label>
			   	</td>
	   			<td class="tdR">是否置顶:</td>
				<td>
					<input readonly="readonly" type="radio" id="isTop1" name="isTop" value="0"  <c:if test="${map.is_top=='0'}">checked</c:if>/><label for="isTop1">否</label>
					<input readonly="readonly" type="radio" id="isTop2" name="isTop" value="1"  <c:if test="${map.is_top=='1'}">checked</c:if>/><label for="isTop2">是</label>
			   	</td>
   			</tr>
			 <tr>
			    <td width="15%" class="tdR">上传缩略图:</td>
			    <td width="85%" colspan="3">
					<div class="fieldset flash" id="fsUploadProgress" style="width: 90%">
						<span class="legend">请点击'上传附件'按钮上传附件,单个文件上限2M:</span>
						<div>
							<ol class="files">
							   <img id="indexImgs" />
							</ol>
						</div>
					</div>
					<span style="color: red">
						温馨提示：操作中，程序运行时间可能较长，请耐心等待。
						<span id="spanButtonPlaceholder"></span>
						<input id="btnCancel" type="button" value="取   消" onclick="cancelQueue(upload);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
					</span>
			   	</td>
			 </tr>
			 <tr>
<%--   			  <td class="tdR" width="15%">新闻摘要:</td>--%>
<%--   			  <td width="85%" colspan="3">--%>
<%--   			  	<textarea id="describition" name="describition" class="easyui-textarea" maxlength="65" style="height:100px;width:100%;">${map.describition }</textarea>--%>
<%--   			   	<span style="color:#ccc;">最多输入50个字符</span>--%>
<%--   			  </td>--%>
<%--   			</tr>--%>
   			<tr>
   			  <td class="tdR">正文内容</td>
   			  <td colspan="3">
					<FCK:editor instanceName="text" value="${map.text}" height="400">
					</FCK:editor>
				</td>
   			</tr>
		</table>
		<table class="tableForm" border="0" width="100%" >
			<tr>
				<td colspan="4" align="center">
<%--					<a class="easyui-linkbutton buttonHeight" iconCls="icon-search" onclick="previewForm();">预览</a>--%>
<%--					&nbsp;&nbsp;&nbsp;&nbsp;--%>
					<a class="easyui-linkbutton buttonHeight" iconCls="icon-ok" onclick="submitForm();">提交</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="easyui-linkbutton buttonHeight" iconCls="icon-redo" onclick="resetForm();">取消</a>
				</td>
			</tr>
		</table>
		<div id="deptDialog"></div>
	</form>
  </body>
</html>
