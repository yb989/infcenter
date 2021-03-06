/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterIndustryService 
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
package com.yph.infcenter.service;

import java.util.List;
import java.util.Map;

import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterInformation;

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
 * 2014-11-27 下午02:49:53 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface InfcenterInformationService{
	/**
	 * 
	  * 
	  * @Description: 分页查询行业新闻记录
	  *
	  * @param paramsCondition
	  * @return PageModel
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-27 下午02:50:46
	 */
	public PageModel queryAllByPage(Map<String, Object> paramsCondition);
	/**
	 * 
	  * 
	  * @Description:新增公司信息
	  *
	  * @param @param entityMap
	  * @param @return
	  * @return Integer
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-1 下午02:27:03
	 */
	public Integer insertInformation(Map<String, Object> entityMap);
	
	/**
	 * 
	 * Description: 添加新闻信息
	 *
	 * @param 
	 * @return Integer
	 * @throws Exception 
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午11:58:36
	 */
	
	public Integer saveInformation(InfcenterInformation infcenterInformation) throws Exception;
	
	/**
	 * 
	 * Description: 添加新闻信息
	 *
	 * @param 
	 * @return Integer
	 * @throws Exception 
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午11:58:36
	 */
	public Integer editInformation(InfcenterInformation infcenterInformation) throws Exception;
	
	/**
	 * 
	 * Description: 获取修改信息
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午11:58:36
	 */
	public Map<String,Object> findMapByInformationId(Integer id);
	
	/**
	  * 
	  * @Description: 根据主键查询页面信息
	  *
	  * @param @param id
	  * @param @return
	  * @return InfcenterInformation
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 上午10:36:37
	 */
	public InfcenterInformation findEntityByInformationId(Integer id);
	
	/**
	  * 
	  * @Description: 根据主键查询站点文件保存路径，模板名称，访问地址信息
	  *
	  * @param id
	  * 
	  * @return Map<String,Object>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-15 上午10:41:26
	 */
	public Map<String,Object> findWebsitInfoById(Integer id);
	
	/**
	  * 
	  * @Description: 根据主键查询实体对象
	  *
	  * @param id
	  * 
	  * @return Map<String,Object>
	  * @throws 
	  * @Author ywb
	  * @date 2014-12-15 下午13:56:26
	 */
	public Map<String,Object> getMapByInformationId(Integer id);
	
	/**
	  * 
	  * @Description: 根据各栏目编号，查询页面存储基本信息文件保存路径，模板名称，访问地址
	  *
	  * @param content
	  * @return Map<String,Object>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-16 下午01:55:58
	 */
	public Map<String,Object> findWebsitInfoByColumnId(Map<String,Object> content);
	
	public List<Map<String, Object>> findIndexNews(Map<String, Object> p);
	
	public List<InfcenterInformation> findNewsByOnline(InfcenterInformation infcenterInformation);
	
	public PageModel findNewsByOnlineByPage(
			InfcenterInformation infcenterInformation, Integer pageNo,
			Integer pageSize);
	
	public InfcenterInformation findNewsDetailInfomationById(
			InfcenterInformation infcenterInformation);
	
	public void deleteById(Integer id);
}
