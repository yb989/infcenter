/* 
' * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterIndustryController 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-11-27
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yph.infcenter.common.constant.Constants;
import com.yph.infcenter.common.util.DataMsg;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.Employee;
import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.entity.InfcenterPilot;
import com.yph.infcenter.service.InfcenterInformationService;
import com.yph.infcenter.service.InfcenterPilotService;
import com.yph.toolcenter.util.DateTimeUtil;
import com.yph.toolcenter.util.StringUtil;

/** 
 *
 * Description: 亿普惠官网信息发布后台管理业务控制层
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-27 下午02:23:41 DYP         1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/infcenterInformation")
public class InfcenterInformationController extends BaseController{
	
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	@Autowired
	private InfcenterInformationService infcenterInformationService;
	
	@Autowired // spring配置中定义
	private VelocityEngine velocityEngine;
	
	/**
	  * 
	  * @Description: 跳转至详情页记录列表
	  *
	  * @param refreshTag
	  * @param messageCode
	  * @param model
	  * @return
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-27 下午02:26:41
	 */
	@RequestMapping(value = "/toInformationList")
	public String toInformationList(String refreshTag,String messageCode,Model model){
		showMessageAlert(refreshTag,messageCode,model);
		return "app/infcenter/information/information_list";
	}
	
	/**
	 * 
	  * 
	  * @Description: 分页查询详情页记录列表
	  *
	  * @param request	请求对象
	  * @param dataMsg  查询条件
	  * @return DataMsg
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-27 下午02:45:18
	 */
	@ResponseBody
	@RequestMapping(value="/queryInformationList")
	public DataMsg queryInformationList(HttpServletRequest request,DataMsg dataMsg) {
		Map<String, Object> paramsCondition = new HashMap<String, Object>();
		paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("page")));
		paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("rows")));
		String title = request.getParameter("title");//标题
		if(StringUtil.isNotBlank(title)){
			paramsCondition.put("title", title.trim());
		}
		String fileName = request.getParameter("fileName");//文件名称
		if(StringUtil.isNotBlank(fileName)){
			paramsCondition.put("fileName", fileName.trim());
		}
		String infoSources = request.getParameter("infoSources");//信息来源
		if(StringUtil.isNotBlank(infoSources)){
			paramsCondition.put("infoSources",infoSources.trim());
		}
		String isEffective = request.getParameter("isEffective");//是否有效
		if(StringUtil.isNotBlank(isEffective)){
			paramsCondition.put("isEffective",isEffective.trim());
		}
		String columnZhName1 = request.getParameter("columnZhName1");
		if(StringUtil.isNotBlank(columnZhName1)){
			paramsCondition.put("columnZhName1",columnZhName1.trim());
		}
		String columnZhName2 = request.getParameter("columnZhName2");
		if(StringUtil.isNotBlank(columnZhName2)){
			paramsCondition.put("columnZhName2",columnZhName2.trim());
		}
//		String columnZhName3 = request.getParameter("columnZhName3");
//		if(StringUtil.isNotBlank(columnZhName2)){
//			paramsCondition.put("columnZhName3",columnZhName3.trim());
//		}
		PageModel pageModel = infcenterInformationService.queryAllByPage(paramsCondition);
		dataMsg.setTotal(pageModel.getTotalRecords());
		dataMsg.setRows(pageModel.getList());
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 跳转到增加详情页面信息
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-2 下午07:43:12
	 */
	@RequestMapping(value = "/saveInformation")
	public String saveInformation(){
		return "app/infcenter/information/information_add";
	}
	/**
	 * 
	 * Description: 保存详情页面信息
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午10:10:28
	 */
	@ResponseBody
	@RequestMapping(value="/doAdd")
	public DataMsg doAdd(@ModelAttribute InfcenterInformation infcenterInformation,DataMsg dataMsg,HttpSession session,HttpServletRequest request){
		try{
			infcenterInformation.setOperator(getSystemCurrentUser(session).getEmployeeId());
			infcenterInformation.setOperateTime(new Date());
			
			String websiteId = request.getParameter("columnZhName1");
			if(StringUtil.isNotBlank(websiteId)){
				infcenterInformation.setWebsiteId(Integer.parseInt(websiteId));
			}
			String firstLevelId = request.getParameter("columnZhName2");
			if(StringUtil.isNotBlank(firstLevelId)){
				infcenterInformation.setFirstLevelId(Integer.parseInt(firstLevelId));
			}
			String secondLevelId = request.getParameter("columnZhName3");
			if(StringUtil.isNotBlank(secondLevelId)){
				infcenterInformation.setSecondLevelId(Integer.parseInt(secondLevelId));
			}
			String velocityName = request.getParameter("velocity_name");
			if(StringUtil.isNotBlank(velocityName)){
				infcenterInformation.setVelocityName(velocityName);
			}
			
			infcenterInformationService.saveInformation(infcenterInformation);
			dataMsg.setMessageCode("0001");
			}catch(Exception e){
				e.printStackTrace();
				dataMsg.setMessageCode("0002");
			}
		return dataMsg;
	}
	
	/**
	 * 保存图片
	 * @param imgUrl
	 * @param picName
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/makeImg")
	public @ResponseBody String makeImg(@RequestParam MultipartFile  file,@RequestParam (value="id" ,required=false) Integer id,HttpSession session) {  
		HashMap<String, String> map = new HashMap<String, String>();
	   try {  
		   String name = file.getOriginalFilename();
		   String fileName =String.valueOf(new Date().getTime())+name.substring(name.lastIndexOf("."));
			// 创建流  
	       BufferedInputStream in = new BufferedInputStream( file.getInputStream());
	       String savePath = session.getServletContext().getRealPath("/")+"indexImg"+File.separator;//保存路径
		   File files =new File(savePath); 
		   if(!files.exists()){
		    	   files.mkdir();
		   }
		  // 生成图片
		  File img = new File(savePath+fileName);
		  BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(img));  
		  byte[] buf = new byte[2048];  
		  int length = in.read(buf);  
		  while (length != -1) {  
		          out.write(buf, 0, length);  
		          length = in.read(buf);  
		  }  
		  in.close();  
		  out.close();  
		  map.put("status", "success");
		  map.put("indexUrl", fileName);
	    } catch (Exception e) {  
	    	map.put("status", "fail");
	         e.printStackTrace();  
	    }  
	    return JSONObject.fromObject(map).toString();
	} 
	
	/**
	 * 
	 * Description: 跳转到详情修改页面
	 *
	 * @param 
	 * @return String
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午10:10:28
	 */
	@RequestMapping(value="toEdit/{id}")
	public String toEdit(@PathVariable Integer id,Model model){
		Map<String,Object> map = infcenterInformationService.getMapByInformationId(id);
		model.addAttribute("map", map);
		return "app/infcenter/information/information_edit";
	}
	
	@ResponseBody
	@RequestMapping(value="toDelete/{id}")
	public DataMsg toDelete(@PathVariable Integer id,HttpSession session,DataMsg dataMsg) {
		try {
			infcenterInformationService.deleteById(id);
			dataMsg.setMessageCode("0005");
		} catch (Exception e) {
			e.printStackTrace();
			dataMsg.setMessageCode("0006");
		}
		return dataMsg;
	}
	
	/**
	 * 
	 * Description: 详情修改页面
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-2 下午05:34:21
	 */
	@ResponseBody
	@RequestMapping(value="/doEdit")
	public DataMsg doEdit(@ModelAttribute InfcenterInformation infcenterInformation,DataMsg dataMsg,HttpSession session,HttpServletRequest request){
		try{
			if("".equals(infcenterInformation.getIndexUrl())){
				infcenterInformation.setIndexUrl(null);
			}
			infcenterInformation.setOperator(getSystemCurrentUser(session).getEmployeeId());
			infcenterInformation.setOperateTime(new Date());
			String websiteId = request.getParameter("columnZhName1");
//			if(StringUtil.isNotBlank(websiteId) && StringUtil.isNumeric(websiteId)){
//				infcenterInformation.setWebsiteId(Integer.parseInt(websiteId));
//			}else{
//				infcenterInformation.setWebsiteId(infcenterPilotService.findIdByZhName(websiteId));
//			}
//			String firstLevelId = request.getParameter("columnZhName2");
//			if(StringUtil.isNotBlank(firstLevelId) && StringUtil.isNumeric(firstLevelId)){
//				infcenterInformation.setFirstLevelId(Integer.parseInt(firstLevelId));
//			}else{
//				infcenterInformation.setFirstLevelId(infcenterPilotService.findIdByZhName(firstLevelId));
//			}
//			String secondLevelId = request.getParameter("columnZhName3");
//			if(StringUtil.isNotBlank(secondLevelId) && StringUtil.isNumeric(secondLevelId)){
//				infcenterInformation.setSecondLevelId(Integer.parseInt(secondLevelId));
//			}else{
//				infcenterInformation.setSecondLevelId(infcenterPilotService.findIdByZhName(secondLevelId));
//			}
			infcenterInformationService.editInformation(infcenterInformation);
			dataMsg.setMessageCode("0003");
		}catch(Exception e){
			e.printStackTrace();
			dataMsg.setMessageCode("0004");
		}
		return dataMsg;
	}
	
	@RequestMapping("showInformationHtml")
	public @ResponseBody Map<String,Object> showInformationHtml(InfcenterInformation information){
		Map<String, Object> content = this.getVelocityHtmlParam(information);
		String htmlCode = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, Constants.VELOCITY_MODEL_PATH + Constants.MODEL_NAME, "UTF-8", content);
		content.put("code", "0000");
		content.put("html", htmlCode);
		return content;
	}
	
	/**
	 * 组装新闻信息
	 * @param info
	 * @param columnUrl
	 * @return
	 */
	public Map<String,Object> getVelocityHtmlParam(InfcenterInformation info){
		
		Map<String,Object> content = new HashMap<String, Object>();
		List<InfcenterPilot> menu1 = new ArrayList<InfcenterPilot>();// 一级菜单
		// 文章基本信息
		content.put("text"          , info.getText());
		content.put("title"			, info.getTitle());
		content.put("publish_time"  , DateTimeUtil.getTimeNormalString(new Date()));
		if(info.getThirdLevelId()!=null&&(info.getThirdLevelId()==26||info.getThirdLevelId()==27||info.getThirdLevelId()==28||info.getThirdLevelId()==29)){
			content.put("isNews", "1");
		}
		// 查询页面保存信息
		List<InfcenterPilot> list = infcenterPilotService.queryFirstMenu(null);
		// 获取一级菜单
		for (InfcenterPilot infcenterPilot : list) {
			if(infcenterPilot.getId()==21){
				content.put("column_url", infcenterPilot.getColumnUrl());
			}
			if (infcenterPilot.getParentId() == 21) {
				menu1.add(infcenterPilot);
			}
		}
		List<InfcenterPilot> list2 = new ArrayList<InfcenterPilot>();
		// 获取所有二级菜单
		for (InfcenterPilot infcenterPilot : menu1) {
			for (InfcenterPilot infcenterPilot1 : list) {
				if (infcenterPilot1.getParentId() == infcenterPilot.getId()) {
					if(infcenterPilot1.getId()!=null&&infcenterPilot1.getId().equals(info.getThirdLevelId())){
						infcenterPilot1.setHighlight("1");
					}
					list2.add(infcenterPilot1);
				}
			}
		}
		content.put("secondPilot", list2);
		return content;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/topnews")
	public DataMsg topnews(HttpServletRequest request,DataMsg dataMsg) {
		Map<String, Object> p = new HashMap<String, Object>();
		String id = request.getParameter("id");
		p.put("first_level_id", Integer.valueOf(id));
		p.put("top_num", "2".equals(id) ? 10 : 7);
		List<?> list = infcenterInformationService.findIndexNews(p);
		dataMsg.setRows(list);
		return dataMsg;
	}
}

