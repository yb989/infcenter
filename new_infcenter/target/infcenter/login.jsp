<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/header.jsp"%>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
	<style type="text/css">
		body {
			background:#eeeeee  repeat-x left top;
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		body,table,td,div {
			font-size: 12px;
			line-height: 24px;
		}
		
		.textfile {background:url(${app}/images/bg_login_textfile.gif) no-repeat left top; padding: 0px 2px; height: 29px; width: 143px; border: 0;line-height: 29px;}
		#chkcode {border:1px double #bfd7f0; height: 27px; width: 60px;line-height: 27px;}
	</style>
	<script type="text/javascript">
		function validate(){
			var flag=true;
			var username=$("#username").val();
			var password=$("#password").val();
			if(username.length==0){
				flag=false;
				showerror("usernamelaber","请输入用户名!");
				return flag;
			}else{
				$("#usernamelaber").html('');
			}
			if(password.length==0){
				flag=false;
				showerror("passwordlaber","请输入密码!");
				return flag;
			}else{
				$("#passwordlaber").html('');
			}
			
			return flag;
		}
	
		function login(){
			if(validate()){
				$("#userlogin").submit();
			}
		}
		
		function resets(){
			$("#username").textbox('setValue','');
			$("#password").textbox('setValue','');
			$("#chkcode").val("");
		}
		//回车登录
		$(document).keydown(function(event){ 
			if(event.keyCode==13){
				login();
			}
		}); 
		
		function changeCheckIMG(){
			$("#loginimg").attr("src","${app }/checkimg.jsp?timestamp=" + new Date());
		}
		
		function showerror(id,info){
			$("#"+id).html("<font color='red'>× "+info+"</font>");
		}
	</script>
	
</head>
<body>
<table width="95" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td><img src="${app}/images/top_login.png"  style="margin-top:150px"/></td>
  </tr>
  <tr>
    <td>
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td style="background:url('${app}/images/bg_form.jpg');background-size:410px 185px;background-repeat:no-repeat;">
	         <form id="userlogin"  method="post" action="${app }/admin/j_spring_security_check">
		        <table width="370" border="0" align="center" cellpadding="0" cellspacing="0" style="padding-top: 6px;">
		          <tr height="35px">
		            <td align="right"  width="90">用户名：</td>
		            <td width="165">
			            <label>
		                	<input id="username" name="username" type="text" class="easyui-textbox" iconCls='icon-man' value="${username}" style="width: 165px;height: 28px;"/>
		                </label>
	                </td>
	                <td>&nbsp;</td>
		          </tr>
		          <tr height="35px">
		            <td align="right"  width="90">密　码：</td>
		            <td>
			            <label>
			            	<input id="password" name="password" type="password" class="easyui-textbox" iconCls='icon-lock' style="width: 165px;height: 28px;" autocomplete="off" disableautocomplete/>
			            </label>
		            </td>
		            <td><label id="passwordlaber"> </label></td>
		          </tr>
		          <tr height="35px">
		            <td align="right" width="90">验证码：</td>
		            <td>
			            <div style="width:70px;height: 25px;float:left;margin-right: 12px;">
			              	<input name="check_code" style="width: 70px;height: 25px;" id="chkcode" class="easyui-validatebox textbox" maxlength="4" />
			            </div>
      					<div style="width:70px;height: 25px;float:left;">
      						<img id="loginimg" name="loginimg" style="width:70px;height:25px;cursor:pointer;" src="${app}/checkimg.jsp" title='看不清，单击更改'  onclick="javascript:changeCheckIMG();" border="0" />
   						</div>
		            </td>
		            <td>&nbsp;</td>
		          </tr>
		          <tr>
		          	<td align="right" width="90">&nbsp;</td>
		          	<td colspan="2">
		          		<label id="chkcodelaber" style="color: red">
		            		${SPRING_SECURITY_LAST_EXCEPTION.message}
		            	</label> 
		          	</td>
		          </tr>
		          <tr height="30px">
		            <td>&nbsp;</td>
		            <td>
			            <label>
			              <input onclick="login()" type="button" style="cursor:pointer;width:64px; height:25px;  border:0;background:url('${app}/images/btn_login.gif')"/>
			              &nbsp;
			              <input onclick="resets()" type="button" style="cursor:pointer;width:64px; height:25px;  border:0;background:url('${app}/images/btn_reset.gif')"/>
			            </label>
		            </td>
		            <td>&nbsp;</td>
		          </tr>
		        </table>
	          </form>
	        </td>
	      </tr>
	      <tr><td><br><br><br></td></tr>
	      <tr align="center"><td style="color: #999;font-size: 11px;">Copyright © 2015-2016 :All rights reserved<br>备案序号：京ICP备13003387号</td></tr>
    	</table>
    </td>
  </tr>
</table>
</body>
</html>