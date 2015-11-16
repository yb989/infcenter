/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterIndustryServiceImpl 
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
package com.yph.infcenter.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yph.infcenter.common.constant.Constants;
import com.yph.infcenter.common.util.DesUtil;
import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.mapper.InfcenterInformationMapper;
import com.yph.infcenter.service.InfcenterInformationService;

/** 
 *
 * Description: 亿普惠官网行业新闻业务处理接口
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-27 下午02:52:11 DYP         1.0        1.0 Version 
 * </pre>
 */
@Service("infcenterInformationService")
public class InfcenterInformationServiceImpl implements InfcenterInformationService {
	
	@Autowired
	private InfcenterInformationMapper infcenterInformationMapper;
	
	/* (非 Javadoc)
	
	 * <p>Title: queryAllByPage</p>
	 * <p>Description: TODO</p>
	 * @param paramsCondition
	 * @return
	 * @see com.yipuhui.infcenter.service.InfcenterIndustryService#queryAllByPage(java.util.Map)
	 */
	@Override
	public PageModel queryAllByPage(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = infcenterInformationMapper.findAllInfcenterInformationMapByPage(paramsCondition);
		Long totalRecords = infcenterInformationMapper.findAllInfcenterInformationByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: saveIndustry</p>
	 * <p>Description: TODO</p>
	 * @param entityMap
	 * @return
	 * @see com.yipuhui.infcenter.service.InfcenterIndustryService#saveIndustry(java.util.Map)
	 */
	@Override
	public Integer insertInformation(Map<String, Object> entityMap) {
		return infcenterInformationMapper.insertInformation(entityMap);
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: saveInformation</p>
	 * <p>Description: TODO</p>
	 * @param infcenterInformation
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#saveInformation(com.yph.infcenter.entity.InfcenterInformation)
	 */
	@Override
	public Integer saveInformation(InfcenterInformation infcenterInformation) throws Exception{
		int rows = infcenterInformationMapper.insertSelective(infcenterInformation);
		//装配ID和文件名称
		infcenterInformation.setId(infcenterInformation.getId());
		infcenterInformation.setFileName(infcenterInformation.getId() + ".html");
		
		//使用des加密，生成加密串
		infcenterInformation = getEncodeFileName(infcenterInformation);
		infcenterInformationMapper.updateByPrimaryKeySelective(infcenterInformation);
		return rows; 
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: editInformation</p>
	 * <p>Description: TODO</p>
	 * @param infcenterInformation
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#editInformation(com.yph.infcenter.entity.InfcenterInformation)
	 */
	@Override
	public Integer editInformation(InfcenterInformation infcenterInformation) throws Exception {
		//使用des加密，生成加密串
		infcenterInformation = getEncodeFileName(infcenterInformation);
		int rows = infcenterInformationMapper.updateByPrimaryKeySelective(infcenterInformation);
		return rows;
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: findEntityByInformationId</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#findEntityByInformationId(java.lang.Integer)
	 */
	@Override
	public InfcenterInformation findEntityByInformationId(Integer id) {
		return infcenterInformationMapper.selectByPrimaryKey(id);
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: findMapByInformationId</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#findMapByInformationId(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> findMapByInformationId(Integer id) {
		return infcenterInformationMapper.selectRetMapByPrimaryKey(id);
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: findWebsitInfoById</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#findWebsitInfoById(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> findWebsitInfoById(Integer id) {
		return infcenterInformationMapper.findWebsitInfoById(id);
	}

	/*
	 * (非 Javadoc)
	
	 * <p>Title: getMapByInformationId</p>
	 * <p>Description: TODO</p>
	 * @param id
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#getMapByInformationId(java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getMapByInformationId(Integer id) {
		return infcenterInformationMapper.selectRetMapByPrimaryKey(id);
	}
	
	/*
	 * (非 Javadoc)
	
	 * <p>Title: findWebsitInfoByColumnId</p>
	 * <p>Description: TODO</p>
	 * @param content
	 * @return
	 * @see com.yph.infcenter.service.InfcenterInformationService#findWebsitInfoByColumnId(java.util.Map)
	 */
	@Override
	public Map<String,Object> findWebsitInfoByColumnId(Map<String,Object> content){
		content = infcenterInformationMapper.findWebsitInfoByColumnId(content);
		StringBuffer sb = new StringBuffer();
		
		sb.append(content.get("p2")).append(content.get("p3")).append(content.get("p4")).append(content.get("p5"));
		String savePath = content.get("p1") + sb.toString().trim();
		Map<String,Object> content1 = new HashMap<String, Object>();
		content1.put("save_path", savePath);
		
		sb = new StringBuffer();
		sb.append(content.get("c2")).append(content.get("c3")).append(content.get("c4")).append(content.get("c5"));
		String columnUrl = content.get("c1") + sb.toString().trim();
		content1.put("column_url", columnUrl);
		
		content1.put("velocity_name", content.get("v3"));
		content1.put("velocity_name1", content.get("v1"));
		content1.put("velocity_name2", content.get("v2"));
		content1.put("velocity_name3", content.get("v3"));
		content1.put("velocity_name4", content.get("v4"));
		content1.put("velocity_name5", content.get("v5"));
		
		content1.put("column_url1", content.get("c1"));
		content1.put("column_url2", content.get("c2"));
		content1.put("column_url3", content.get("c3"));
		content1.put("column_url4", content.get("c4"));
		content1.put("column_url5", content.get("c5"));
		return content1;
	}
	
	/**
	  * 
	  * @Description: 修改数据功能方法，用于更新文件名称和加密后文件名称
	  *
	  * @param @param infcenterInformation
	  * @param @return
	  * @param @throws Exception
	  * @return InfcenterInformation
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-20 下午03:45:17
	 */
	private InfcenterInformation getEncodeFileName(InfcenterInformation infcenterInformation) throws Exception{
		
		Map<String,Object> content = new HashMap<String, Object>();
		content.put("websiteId"    , infcenterInformation.getWebsiteId());
		content.put("firstLevelId" , infcenterInformation.getFirstLevelId());
		content.put("secondLevelId", infcenterInformation.getSecondLevelId());
		content.put("thirdLevelId" , infcenterInformation.getThirdLevelId());
		content.put("fourthLevelId", infcenterInformation.getFourthLevelId());
		//根据传入数据查询文件保存信息
		content = infcenterInformationMapper.findWebsitInfoByColumnId(content);
		if(content!=null){
			StringBuffer sb = new StringBuffer();
			sb.append(content.get("p1")).append(content.get("p2")).append(
					content.get("p3")).append(content.get("p4")).append(
					content.get("p5"));
			sb.append("/" + infcenterInformation.getId());
			
			String  encodeFileName = DesUtil.encrypt(sb.toString().trim(), Constants.DES_KEY).replaceAll(" ", "");
			infcenterInformation.setEncodeFileName(encodeFileName);
		}
		return infcenterInformation;
	}

	@Override
	public List<Map<String, Object>> findIndexNews(Map<String, Object> p) {
		return infcenterInformationMapper.findIndexNews(p);
	}

	@Override
	public List<InfcenterInformation> findNewsByOnline(
			InfcenterInformation infcenterInformation) {
		return infcenterInformationMapper.findNewsInfomationById(infcenterInformation);
	}

	@Override
	public PageModel findNewsByOnlineByPage(
			InfcenterInformation infcenterInformation, Integer pageNo,
			Integer pageSize) {
		PageModel pageModel = new PageModel();
		Map<String, Object> paramsCondition = new HashMap<String,Object>();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(pageSize);
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		paramsCondition.put("pageNo", pageNo);
		paramsCondition.put("pageSize", pageSize);
		paramsCondition.put("firstLevelId", infcenterInformation.getFirstLevelId());
		List<InfcenterInformation> data = infcenterInformationMapper.findNewsInfomationByPage(paramsCondition);
		for (InfcenterInformation infcenterInformation2 : data) {
			if(infcenterInformation2.getOperateTime()!=null){
				String date = new SimpleDateFormat("yyyy-MM-dd").format(infcenterInformation2.getOperateTime());
				infcenterInformation2.setCreateTime(date);
			}
		}
		Long totalRecords = infcenterInformationMapper.findNewsInfomationByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public InfcenterInformation findNewsDetailInfomationById(
			InfcenterInformation infcenterInformation) {
		return infcenterInformationMapper.findNewsDetailInfomationById(infcenterInformation);
	}

	@Override
	public void deleteById(Integer id) {
		infcenterInformationMapper.deleteByPrimaryKey(id);
	} 
	
}
