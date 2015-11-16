<%@page contentType="image/jpeg"%>
<%@page import="javax.imageio.ImageIO"%>   
<%@page import="com.yph.infcenter.common.constant.Constants"%>
<%@page import="com.yph.infcenter.common.util.VerificationCodeUtil"%>
<%@page import="com.yph.infcenter.common.util.VerifyCode"%>
<%@page import="java.awt.Color"%>

<%   
     
	response.setHeader("Pragma","No-cache");   
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);   
	session.removeAttribute(Constants.CHECK_CODE);
	
	//VerificationCodeUtil vcode=new VerificationCodeUtil(); 
	
	//session.setAttribute(Constants.CHECK_CODE,vcode.getCodevalue().toLowerCase());
	
	//ImageIO.write(vcode.getImage(),"JPEG",response.getOutputStream());
	
	String checkCode = VerifyCode.generateTextCode(VerifyCode.TYPE_NUM_UPPER,4,"0oOilJI1");
	session.setAttribute(Constants.CHECK_CODE, checkCode);
	
	response.setContentType("image/jpeg");
	ImageIO.write(VerifyCode.generateImageCode(checkCode, 90, 30, 5,true,Color.WHITE,Color.BLACK,null),"JPEG",response.getOutputStream());
	
	response.flushBuffer();
	out.clear();
	out = pageContext.pushBody();
  
%>