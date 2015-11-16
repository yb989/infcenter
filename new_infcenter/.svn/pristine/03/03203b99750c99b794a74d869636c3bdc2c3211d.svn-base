<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("app",request.getContextPath());
%>

<link href="${app}/css/style.css" rel="stylesheet" type="text/css">
<link href="${app}/css/meneame.css" rel="stylesheet" type="text/css">
<link href="${app}/js/common/css/validate.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${app}/js/common/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${app}/js/common/js/jquery.validate.js"></script>
<script type="text/javascript" src="${app}/js/common/js/messages_cn.js"></script>

<script type="text/javascript">
/**
 * 提示错误信息
 * @param {Object} id	提示控件ID
 * @param {Object} info	提示文字内容
 */
function showerror(id,info){
 	if (navigator.userAgent.indexOf("MSIE") > 0) {
        $("#"+id).html("<img src=\"${app}/images/attention.gif\" align=\"absmiddle\"/>&nbsp;<span style='color: red;line-height: 16px;'>"+info+"</span>");
    }else{
    	$("#"+id).html("<img src=\"${app}/images/attention.gif\" align=\"absmiddle\"/>&nbsp;<span style='color: red;line-height: 16px;vertical-align: middle;'>"+info+"</span>");
    }
}
function shomsg(id,info){
 	if (navigator.userAgent.indexOf("MSIE") > 0) {
        $("#"+id).html("<img src=\"${app}/images/onCorrect.png\" align=\"absmiddle\"/>&nbsp;<span style='color: green;line-height: 16px;'>"+info+"</span>");
    }else{
    	$("#"+id).html("<img src=\"${app}/images/onCorrect.png\" align=\"absmiddle\"/>&nbsp;<span style='color: green;line-height: 16px;vertical-align: middle;'>"+info+"</span>");
    }
}

</script>