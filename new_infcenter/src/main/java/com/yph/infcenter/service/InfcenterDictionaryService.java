/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterDictionaryService.java 
 *
 * Created: [2014-12-16 上午10:46:47] by suxuqiang 
 *
 * $Id$
 * 
 * $Revision$
 *
 * $Author$
 *
 * $Date$
 *
 * ============================================================ 
 * 
 * ProjectName: infcenter 
 * 
 * Description: 
 * 
 * ==========================================================*/

package com.yph.infcenter.service;

import java.util.Map;

import com.yph.infcenter.common.util.PageModel;
import com.yph.infcenter.entity.InfcenterDictionary;

/** 
 *
 * Description: 
 *
 * @author ua
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2014-12-16    suxuqiang       1.0        1.0 Version 
 * </pre>
 */

public interface InfcenterDictionaryService {
	/**
	 * 
	 * Description: 分页查询内容发布平台字典
	 *
	 * @param 
	 * @return PageModel
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 上午10:47:12
	 */
	public PageModel queryAllByPage(Map<String, Object> paramsCondition);
	/**
	 * 
	 * Description: 添加字典
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 上午10:48:28
	 */
	public Integer insertDictionary(InfcenterDictionary dictionary);
	/**
	 * 
	 * Description: 通过ID查询字典
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 上午10:48:52
	 */
	public Map<String, Object> findMapById(Integer id);
	/**
	 * 
	 * Description:更新字典 
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 上午10:49:34
	 */
	public Integer updateDictionary(InfcenterDictionary dictionary);

}
