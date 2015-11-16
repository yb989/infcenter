/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: PublishPageServiceImpl 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-16
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.service.InfcenterInformationService;
import com.yph.infcenter.service.InfcenterPilotService;
import com.yph.infcenter.service.InfcenterVelocityService;
import com.yph.infcenter.service.PublishPageService;
import com.yph.toolcenter.util.DateTimeUtil;

/** 
 *
 * Description: TODO
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-16 下午02:10:44 DYP         1.0        1.0 Version 
 * </pre>
 */
@Service("publishPageService")
public class PublishPageServiceImpl implements PublishPageService {
	
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	@Autowired
	private InfcenterVelocityService infcenterVelocityService;
	@Autowired
	private InfcenterInformationService infcenterInformationService;
	
	/* (非 Javadoc)
	
	 * <p>Title: againPublishPage</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @throws Exception
	 * @see com.yph.infcenter.service.PublishPageService#againPublishPage(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> againPublishPage(Integer id) throws Exception {
		// 查询页面详情
		InfcenterInformation info = infcenterInformationService.findEntityByInformationId(id);
		
		// 查询页面保存信息
		Map<String,Object> pageInfo = infcenterInformationService.findWebsitInfoById(id);
		
		// 保存路径
		StringBuffer sb = new StringBuffer();
		sb.append(replaceNullForObject(pageInfo.get("webPath"))).append(
				replaceNullForObject(pageInfo.get("firstPath"))).append(
				replaceNullForObject(pageInfo.get("secondPath"))).append(
				replaceNullForObject(pageInfo.get("thirdPath"))).append(
				replaceNullForObject(pageInfo.get("fourthPath")));
		String savePath = sb.toString();
		
		// 文件名称
		String fileName = replaceNullForObject(pageInfo.get("fileName"));
		
		// 使用模板
		String velocityName = replaceNullForObject(pageInfo.get("velocityName"));
		
		// 站点访问地址
		String columnUrl = replaceNullForObject(pageInfo.get("columnUrl"));
		
		Map<String,Object> content = getVelocityHtmlParam(info, columnUrl);
		
		content = infcenterVelocityService.createVelocityForHtml(savePath, fileName, velocityName, content);
		
		return content;
	}

	/* (非 Javadoc)
	
	 * <p>Title: showPageToHtml</p>
	 * <p>Description: TODO</p>
	 * @param infcenterInformation
	 * @return
	 * @throws Exception
	 * @see com.yph.infcenter.service.PublishPageService#showPageToHtml(com.yph.infcenter.entity.InfcenterInformation)
	 */
	@Override
	public Map<String, Object> showPageToHtml(InfcenterInformation infcenterInformation) throws Exception {
		
		Map<String,Object> content = new HashMap<String, Object>();
		content.put("websiteId"    , infcenterInformation.getWebsiteId());
		content.put("firstLevelId" , infcenterInformation.getFirstLevelId());
		content.put("secondLevelId", infcenterInformation.getSecondLevelId());
		content.put("thirdLevelId" , infcenterInformation.getThirdLevelId());
		content.put("fourthLevelId", infcenterInformation.getFourthLevelId());
		
		content = infcenterInformationService.findWebsitInfoByColumnId(content);
		
		// 站点访问地址
		String columnUrl = content.get("column_url1") == null ? "" : content.get("column_url1").toString();
		
		content = getVelocityHtmlParam(infcenterInformation, columnUrl);
		
		return infcenterVelocityService.showVelocityForHtml(infcenterInformation.getVelocityName(), content);
	}
	
	/**
	 * 
	  * 
	  * @Description: 页面生成参数组装方法，私有方法
	  *
	  * @param info				页面信息
	  * @param columnUrl        站点访问地址
	  * @param @return
	  * @return Map<String,Object>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-16 下午01:27:25
	 */
	private Map<String,Object> getVelocityHtmlParam(InfcenterInformation info,String columnUrl){
		
		Map<String,Object> content = new HashMap<String, Object>();
		
		// 文章基本信息
		content.put("text"          , info.getText());
		content.put("title"			, info.getTitle());
		content.put("information_sources", info.getInfoSources());
		if(info.getOperateTime() != null){
			content.put("publish_time"  , DateTimeUtil.getTimeNormalString(info.getOperateTime()));
		}
		
		// 查询页面保存信息
		content.put("column_url"    , columnUrl);   // 站点访问地址
		
		/* 一级菜单导航 */
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("website_id"     , info.getWebsiteId());	//站点主键
		map.put("first_column_id", info.getFirstLevelId());	//一级菜单主键
		List<Map<String,Object>> firstPilot = infcenterPilotService.queryFirstPilot(map);
		content.put("firstPilot" , firstPilot);
		
		/* 二级菜单导航 */
		map.put("column_id"		 , info.getSecondLevelId());//二级以下菜单主键
		List<Map<String,Object>> secondPilot = infcenterPilotService.queryDirectionPilot(map);
		content.put("secondPilot", secondPilot);
		
		//左侧导航上方文字
		if(!firstPilot.isEmpty() && firstPilot.size() > 0){
			for(Map<String,Object> firstMap : firstPilot){
				if("1".equals(firstMap.get("highlight").toString())){
					content.put("page_zh_title", firstMap.get("column_zh_name"));
					content.put("page_en_title", firstMap.get("column_en_name"));
					break;
				}
			}
		}
		
		//正文上方文字
		if(!secondPilot.isEmpty() && secondPilot.size() > 0){
			for(Map<String,Object> secondMap : secondPilot){
				if("1".equals(secondMap.get("highlight").toString())){
					content.put("content_title", secondMap.get("zh_name"));
					break;
				}
			}
		}
		return content;
	}
	
	private String replaceNullForObject(Object o){
		if(o == null)
			return "";
		return o.toString();	
	}
}
