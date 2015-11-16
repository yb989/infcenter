<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/header.jsp"%>
<%@page import="com.yph.infcenter.common.util.PropertyUtil"%>
<%
	request.setAttribute("IMAGESERVICE_UPLOAD_URL", PropertyUtil.getInfo("IMAGESERVICE_UPLOAD_URL"));
	request.setAttribute("swfUrl", PropertyUtil.getInfo("swfUrl"));
	request.setAttribute("indexUrl", PropertyUtil.getInfo("indexUrl"));
%>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>轮播图添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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

				upload_url: "${IMAGESERVICE_UPLOAD_URL}",
				
				file_post_name: "file",
				// File Upload Settings
				file_size_limit : "2048",	// 20480k
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
				flash_url : "${swfUrl}",
				custom_settings : {
					progressTarget : "fsUploadProgress",
					cancelButtonId : "btnCancel"
				},
				debug: false
			});
		}
		
		function uploadError(file,code,message){
		 console.log(file);
	        console.log(serverData);
			//alert('file=' + file + ';code=' + code + ';message=' + message);
			closeMask();
			var progress = new FileProgress(file, this.customSettings.progressTarget);
			progress.setComplete();
			progress.setStatus("<span>上传失败</span>!");
			progress.toggleCancel(false);
		}
		
	    function uploadSuccess(file, serverData) {
	        console.log(file);
	        console.log(serverData);
	    	try {
				closeMask();
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				progress.setComplete();
				progress.setStatus("<span>上传成功</span>!");
				progress.toggleCancel(false);
				
				var obj = eval("(" + serverData + ")");
				console.info(obj);
				if(obj[0].status== 'success'){
					$("#fileUrl").val(obj[0].chain);
				}else{
					showMsgSlide('图片上传失败');
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
					alert("您已经上传了太多的附件!\n" + (message === 0 ? "已经达到限制了." : "You may select " + (message > 1 ? "up to " + message + " files." : "0 file.")));
					return;
				}
		
				var progress = new FileProgress(file, this.customSettings.progressTarget);
				progress.setError();
				progress.toggleCancel(false);
		
				switch (errorCode) {
				case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
					progress.setStatus("文件太大了 请缩小文件!");
					this.debug("Error Code: 文件太大了 请缩小文件!, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
					break;
				case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
					progress.setStatus("Cannot upload Zero Byte files.");
					this.debug("Error Code: Zero byte file, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
					break;
				case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
					progress.setStatus("错误的文件类型!");
					this.debug("Error Code: Invalid File Type, File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
					break;
				case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
					alert("You have selected too many files.  " +  (message > 1 ? "You may only add " +  message + " more files" : "You cannot add any more files."));
					break;
				default:
					if (file !== null) {
						progress.setStatus("Unhandled Error");
					}
					this.debug("Error Code: " + errorCode + ", File name: " + file.name + ", File size: " + file.size + ", Message: " + message);
					break;
				}
			} catch (ex) {
		        this.debug(ex);
		    }
		}
	    
	
		//提交
		function submitForm(){
			var websiteId = $("#websiteId").combobox('getValue'); 
			if(websiteId == null || websiteId == ''){
				$.messager.show({
					title:'信息提示',
					msg	 :'请选择站点',
					timeout:5000,
					showType:'slide'
				});
				return;
			}
			var fileUrl = $("#fileUrl").val();
			if(fileUrl == null || fileUrl == ''){
				$.messager.show({
					title:'信息提示',
					msg	 :'文件名称不能为空!',
					timeout:5000,
					showType:'slide'
				});
				return;
			}
			var carouselForm = $("#carouselForm");			
			carouselForm.form('submit',{
				url:'${app}/carousel/doInsertCarousel',				
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
					parent.closeTab("新增轮播图");
				}
			});
		}
		
		//取消
		function resetForm(){
			parent.closeTab("新增轮播图");
		}
	</script>
  </head>
  
  <body style="background: white;">
  	<form id="carouselForm" class="easyui-form" method="post" modelAttribute="carousel"   >
  	
  		<input type="hidden" id="fileUrl" name="fileUrl" />
  		
		<table class="tableForm" border="0" width="100%" >			
			<tr>
				<td class="tdR">点击后跳转链接地址:</td>
				<td>
					<input type="text" name="url" class="easyui-textbox" data-options="validType:['length[0,300]']" style="width: 475px;" maxlength="300"/>
				</td>
			</tr>
			<tr>
				<td class="tdR"><span style="color: red;">*</span>站点名称:</td>
	  				<td>
	  					<input required="true" id="websiteId" class="easyui-combobox" name="websiteId"  
   						 data-options="valueField:'id',panelHeight:'auto',textField:'column_zh_name',url:'${app}/pilot/findFirstPilotInfo'" style="width: 475px;"/>
	  				</td>
				</td>									
			</tr>
			<tr>
				<td class="tdR"><span style="color: red">*</span>是否有效:</td>
				<td>
					<input type="radio" id="isEffective_1" name="isEffective" value="0" checked="checked"/><label for="isEffective_1">否</label>
					<input type="radio" id="isEffective_2" name="isEffective" value="1"/><label for="isEffective_2">是</label>					
				</td>
			</tr>
			<tr>								
				<td class="tdR" id="td_hidden1"><span style="color: red">*</span>生效时间:</td>
				<td id="td_hidden2">
					<input type="text" name="beginTime" class="easyui-datetimebox" style="width: 450px;" required="true"/>
				</td>
			</tr>			
			<tr>				
				<td class="tdR"><span style="color: red"></span>失效时间:</td>
				<td>
					<input type="text" name="endTime" class="easyui-datetimebox" style="width: 450px;" editable="false"/>
				</td>
			</tr>
			<tr>
				<td class="tdRT" style="vertical-align: middle">
					<span style="color: red">*</span>上传轮播图:
				</td>
				<td colspan="3" style="padding: 15px;">
					<div class="fieldset flash" id="fsUploadProgress">
						<span class="legend">请点击'上传附件'按钮上传附件,单个文件上限20M:</span>
						<div>
							<ol class="files">
							</ol>
						</div>
					</div>
					<span style="color: red">温馨提示：操作中，程序运行时间可能较长，请耐心等待。</span>
					<div style="padding-left: 5px;margin-top: 20px;">
						<span id="spanButtonPlaceholder"></span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="btnCancel" type="button" value="取   消" onclick="cancelQueue(upload);" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
						&nbsp;
					</div>
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
