/* 
 * Copyright (C) 2006-2014 亿谱汇投资管理（北京）有限公司.
 *
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 *
 * ============================================================
 *
 * FileName: InfcenterCarouselService.java 
 *
 * Created: [2014-12-16 下午05:22:17] by suxuqiang 
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
import com.yph.infcenter.entity.InfcenterCarousel;

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

public interface InfcenterCarouselService {
	/**
	 * 
	 * Description: 分页查询首页轮播图
	 *
	 * @param 
	 * @return PageModel
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:23:03
	 */
	public PageModel queryAllByPage(Map<String, Object> paramsCondition);
	/**
	 * 
	 * Description: 添加首页轮播图
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:25:34
	 */
	public Integer insertCarousel(InfcenterCarousel carousel);
	/**
	 * 
	 * Description: 通过ID查询一个轮播图
	 *
	 * @param 
	 * @return Map<String,Object>
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:26:18
	 */
	public Map<String, Object> findMapById(Integer id);
	/**
	 * 
	 * Description: 更新一张轮播图
	 *
	 * @param 
	 * @return Integer
	 * @throws 
	 * @Author suxuqiang
	 * Create Date: 2014-12-16 下午05:27:28
	 */
	public Integer updateCarousel(InfcenterCarousel carousel);

}
