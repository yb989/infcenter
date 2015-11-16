/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PublishPageController 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-12
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.service.InfcenterPilotService;
import com.yph.infcenter.service.PublishPageService;
import com.yph.toolcenter.util.StringUtil;

/** 
 *
 * Description: velocity页面生成
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-12 下午05:58:58 DYP         1.0        1.0 Version 
 * </pre>
 */
@Controller
@RequestMapping("/publishPage")
public class PublishPageController extends BaseController{
	
	@Autowired
	private PublishPageService publishPageService;
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	
	/**
	  * 
	  * @Description: 重新生成缺失页面
	  *
	  * @param @return
	  * @return String
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-12 下午06:00:35
	 */
	@ResponseBody 
	@RequestMapping(value="/againPublishPage/{id}")
	public Map<String,Object> againPublishPage(@PathVariable Integer id){
		Map<String,Object> htmlCode = new HashMap<String, Object>();
		try {
			htmlCode = publishPageService.againPublishPage(id);
		} catch (Exception e) {
			e.printStackTrace();
			htmlCode.put("code", "9999");
			return htmlCode;
		}
		return htmlCode;
	}
	
	/**
	  * 
	  * @Description: 在线预览，使用velocity生成html页面
	  *
	  * @param id
	  * @return Map<String,String>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-16 上午11:11:31
	 */
	@ResponseBody
	@RequestMapping(value={"/showVelocityForHtml"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json;charset=UTF-8"})
	public Map<String,Object> showVelocityForHtml(@ModelAttribute InfcenterInformation infcenterInformation,HttpSession session,HttpServletRequest request){
		
		Map<String,Object> htmlCode = new HashMap<String, Object>();
		try {
			infcenterInformation.setOperator(getSystemCurrentUser(session).getEmployeeId());
			infcenterInformation.setOperateTime(new Date());
			
			String websiteId     = request.getParameter("columnZhName1");
			String firstLevelId  = request.getParameter("columnZhName2");
			String secondLevelId = request.getParameter("columnZhName3");
			String velocityName  = request.getParameter("velocity_name");
			
			if(StringUtil.isNotBlank(websiteId) && StringUtil.isNumeric(websiteId)){
				infcenterInformation.setWebsiteId(Integer.parseInt(websiteId));
			}else{
				infcenterInformation.setWebsiteId(infcenterPilotService.findIdByIdColumnZhName(websiteId));
			}
			if(StringUtil.isNotBlank(firstLevelId) && StringUtil.isNumeric(firstLevelId)){
				infcenterInformation.setFirstLevelId(Integer.parseInt(firstLevelId));
			}else{
				infcenterInformation.setFirstLevelId(infcenterPilotService.findIdByIdColumnZhName(firstLevelId));
			}
			if(StringUtil.isNotBlank(secondLevelId) && StringUtil.isNumeric(secondLevelId)){
				infcenterInformation.setSecondLevelId(Integer.parseInt(secondLevelId));
			}else{
				infcenterInformation.setSecondLevelId(infcenterPilotService.findIdByIdColumnZhName(secondLevelId));
			}
			if(StringUtil.isNotBlank(velocityName)){
				infcenterInformation.setVelocityName(velocityName);
			}
			htmlCode = publishPageService.showPageToHtml(infcenterInformation);
		} catch (Exception e) {
			e.printStackTrace();
			htmlCode.put("code", "9999");
			return htmlCode;
		}
		return htmlCode;
	}
	
}
