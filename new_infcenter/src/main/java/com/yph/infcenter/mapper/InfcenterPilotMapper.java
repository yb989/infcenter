/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterPilotMapper 
 *
 * Created: [2014-11-18 上午09:53:06] by DYP 
 *
 *
 * 2014-12-8
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: TODO
 * 
 * ==========================================================*/
package com.yph.infcenter.mapper;

import java.util.List;
import java.util.Map;

import com.yph.infcenter.entity.InfcenterPilot;

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
 * 2014-12-8 下午03:30:34 DYP         1.0        1.0 Version 
 * </pre>
 */
public interface InfcenterPilotMapper extends BaseMapper<InfcenterPilot>{
	
	/**
	  * 
	  * @Description: 查询站点的子导航
	  *
	  * @param map second_column_id	//二级菜单主键
	  * @return List<Map<String,Object>>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-8 下午03:25:56
	 */
	public List<Map<String,Object>> queryDirectionPilot(Map<String,Object> map);
	
	/**
	  * 
	  * @Description: 查询站点的根导航
	  *
	  * @param map website_id      站点主键
				   first_column_id 一级菜单主键
	  * @return List<Map<String,Object>>
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-8 下午03:25:04
	 */
	public List<Map<String,Object>> queryFirstPilot(Map<String,Object> map);
	
	/**
	  * 
	  * @Description: 获取网点最大排列数
	  *
	  * @param @return
	  * @return Integer
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-9 下午04:41:51
	 */
	public Integer getMaxFirstPilot(Integer parentId);
	
	/**
	  * 
	  * @Description: 新增站点信息或导航栏目信息
	  *
	  * @param map
	  * @return void
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-9 下午04:44:18
	 */
	public void insertPilot(Map<String,Object> map);
	
	/**
	 * 
	 * Description:一级部门 亿普惠官网
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	public List<Map<String, Object>> findFirstPilotInfo();
	
	/**
	 * 
	 * Description:查找级联菜单
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	public List<Map<String, Object>> findSubWorkPilotInfoById(Integer id);
	
	/**
	 * 
	 * Description:查找级联菜单
	 *
	 * @param 
	 * @return hashmap
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-11 下午18:30:14
	 */
	public Map<String, Object> findVelocityById(Integer id);
	
	/**
	  * 
	  * @Description: 根据中文名称查询主键ID
	  *
	  * @param name		中文名称
	  * @return Integer
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-17 上午11:57:37
	 */
	public Integer findIdByIdColumnZhName(String name);

	/**
	 * 
	 * Description:查询所有栏目信息
	 *
	 * @param 
	 * @return Map<String, Object>
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16下午11:22:14
	 */
	public List<Map<String, Object>> queryPilots();
	
	/**
	 * 
	 * Description: 通过Id查出站点实体的信息
	 *
	 * @param 
	 * @return InfcenterPilot
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午14:09:18
	 */
	public InfcenterPilot queryByIdPilot(Integer id);
	
	/**
	 * 
	 * Description:栏目增加信息
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午14:57:14
	 */
	public Integer insertSelectivePolit(InfcenterPilot infcenterPilot);
	
	/**
	 * 
	 * Description:删除栏目信息
	 *
	 * @param 
	 * @return DataMsg
	 * @throws 
	 * @Author ywb
	 * Create Date: 2014-12-16 下午16:04:14
	 */
	public Integer deleteInfcenterPilot(Integer id);
	
	/**
	  * 
	  * @Description: 根据中文名称查询主键ID
	  *
	  * @param @param zhName
	  * @param @return
	  * @return Integer
	  * @throws 
	  * @Author DYP
	  * @date 2014-12-23 下午05:31:31
	 */
	public Integer findIdByZhName(String zhName);
	
	/**
	 * 根据ID查询路径
	 * @return
	 */
	public Map<String, Object> findPilotById(Integer id);
	
	/**
	 * 查询菜单
	 * @param map
	 * @return
	 */
	public List<InfcenterPilot> queryFirstMenu(Map<String,Object> map);
	
	/**
	 * 根据当前Id查询他的上一条数据的排序
	 * @return
	 */
	public Map<String,Object> queryMenuSort(Map<String,Object> map);
	
	/**
	 * 根据当前顺序和父ID获取下一条数据
	 * @param map
	 * @return
	 */
	public Map<String,Object> queryMenuSortByDown(Map<String,Object> map);
}
