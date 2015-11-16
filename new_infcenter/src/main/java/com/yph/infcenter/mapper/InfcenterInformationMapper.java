/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterIndustryMapper 
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
package com.yph.infcenter.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yph.infcenter.entity.InfcenterInformation;

/** 
 *
 * Description: 亿普惠官网行业新闻业务持久化处理
 *
 * @author DYP
 * @version 1.0
 * <pre>
 * Modification History: 
 *          Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-11-27 下午02:56:00 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface InfcenterInformationMapper extends BaseMapper<InfcenterInformation> {
	/**
	  * 
	  * @Description: 根据条件分页查询行业新闻记录列表
	  *
	  * @param paramsCondition
	  * @return List<Map<String,Object>>
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-27 下午02:56:40
	 */
	public List<Map<String, Object>> findAllInfcenterInformationMapByPage(Map<String, Object> paramsCondition);
	/**
	 * 
	  * 
	  * @Description: 根据条件获取满足条件的数据总条数
	  *
	  * @param paramsCondition
	  * @return Long
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-27 下午02:57:51
	 */
	public Long findAllInfcenterInformationByPageCount(Map<String, Object> paramsCondition);
	/**
	  * 
	  * @Description: TODO
	  *
	  * @param entityMap
	  * @return
	  * @return Integer
	  * @throws 
	  * @Author DYP
	  * @date 2014-11-28 下午03:47:14
	 */
	public Integer insertInformation(Map<String, Object> entityMap);
	
	/**
	 * 
	 * Description: 获取文件名称
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-11-27 上午11:58:36
	 */
	public List<Map<String,Object>> queryInformation(Map<String,Object> map);
	
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
     * @Description: 根据各栏目编号，查询页面存储基本信息文件保存路径，模板名称，访问地址
     *
     * @param condition
     * 
     * @return Map<String,Object>
     * @throws 
     * @Author DYP
     * @date 2014-12-16 下午01:52:05
    */
    public Map<String,Object> findWebsitInfoByColumnId(Map<String, Object> condition);
    
    /**
     * 根据ID=8公司动态，获取前5条新闻
     * @return
     */
    public List<InfcenterInformation> findNewsInfomationById(InfcenterInformation infcenterInformation);
    
    public List<InfcenterInformation> findNewsInfomationByPage(Map map);
    public Long findNewsInfomationByPageCount(Map map);
    
    /**
     * 获取新闻详细信息
     * @param id
     * @return
     */
    public InfcenterInformation findNewsDetailInfomationById(InfcenterInformation infcenterInformation);
    
    /**
     * 查询首页新闻
     * @param p
     * @return
     */
    public List<Map<String, Object>> findIndexNews(Map<String, Object> p);
    
}
